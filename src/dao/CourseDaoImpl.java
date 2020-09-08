/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Asus
 */
import com.mysql.cj.x.protobuf.MysqlxNotice;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import model.Lesson;
import model.Payment;
import model.Role;

import model.Student;
import model.Teacher;
import util.JdbcUtility;

public class CourseDaoImpl implements CourseDao {

    public List<Student> getstudentList() throws Exception {
        List<Student> studentList = new ArrayList<Student>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select id,name,surname,dob,address,phone,email from student where active=1";
        try {
            c = DBHelper.getConnection1();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getLong("id"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    student.setDob(rs.getString("dob"));
                    student.setAdress(rs.getString("address"));
                    student.setEmail(rs.getString("email"));
                    student.setPhone(rs.getString("phone"));
                    studentList.add(student);

                }
            } else {
                System.out.println("Connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return studentList;
    }

    public boolean addStudent(Student student) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "insert into videoders.student(name,surname,address,phone,dob,email) values(?,?,?,?,?,?)";
        try {
            c = DBHelper.getConnection1();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, student.getName());
                ps.setString(2, student.getSurname());
                ps.setString(3, student.getAdress());
                ps.setString(4, student.getPhone());
                ps.setString(5, student.getDob() + "");
                ps.setString(6, student.getEmail());

                ps.execute();
                result = true;

            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
        } finally {

            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    public Student getStudentById(Long studentId) throws Exception {
        Student student = new Student();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select id,name,surname,dob,address,phone,email from student" + " where active=1 and id=?";
        try {
            c = DBHelper.getConnection1();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, studentId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    student.setId(rs.getLong("id"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    student.setDob(rs.getString("dob"));
                    student.setAdress(rs.getString("address"));
                    student.setPhone(rs.getString("phone"));
                    student.setEmail(rs.getString("email"));

                }
            } else {
                System.out.println("Connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return student;
    }

    public boolean updateStudent(Student student1, Long studentId) throws Exception {

        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "update student set name=?,surname=?,address=?,dob=?,phone=?" + " where id=?";

        try {
            c = DBHelper.getConnection1();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, student1.getName());
                ps.setString(2, student1.getSurname());
                ps.setString(3, student1.getAdress());
                ps.setString(4, student1.getDob());
                ps.setString(5, student1.getPhone());
                ps.setLong(6, studentId);

                ps.execute();
                result = true;

            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
        } finally {

            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    public boolean deleteStudent(Long id) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "update student set active=0" + " where id=?";
        try {
            c = DBHelper.getConnection1();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, null);
        }

        return result;
    }

    public List<Student> searchStudentData(String keyword) throws Exception {
        List<Student> studentList = new ArrayList<Student>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select id,name,surname,dob,address,phone from student" + " where active=1"
                + " and name like (?)or surname like (?) or address like (?)";
        try {
            c = DBHelper.getConnection1();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                rs = ps.executeQuery();

                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getLong("id"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    student.setDob(rs.getString("dob"));
                    student.setAdress(rs.getString("address"));
                    student.setPhone(rs.getString("phone"));
                    studentList.add(student);

                }
            } else {
                System.out.println("Connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return studentList;
    }

    public List<Lesson> getLessonList() throws Exception {
        List<Lesson> lessonList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT lesson_name,lesson_price,data_date FROM videoders.lesson";
        try {
            c = DBHelper.getConnection1();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Lesson lesson = new Lesson();
                    lesson.setLessonName(rs.getString("lesson_name"));
                    lesson.setLessonPrice(rs.getDouble("lesson_price"));
                    lesson.setLessonTime(rs.getDate("data_date"));
                    lessonList.add(lesson);
                }

            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);

        }
        return lessonList;
    }

    public List<Teacher> getTeacherList() throws Exception {
        List<Teacher> teacherList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT name,surname,address,phone,dob FROM videoders.teacher";
        try {
            c = DBHelper.getConnection1();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Teacher teacher = new Teacher();
                    teacher.setName(rs.getString("name"));
                    teacher.setSurname(rs.getString("surname"));
                    teacher.setAdress(rs.getString("address"));
                    teacher.setPhone(rs.getString("phone"));
                    teacher.setDob(rs.getDate("dob"));

                    teacherList.add(teacher);
                }

            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);

        }
        return teacherList;
    }

    @Override
    public List<Payment> getPaymentList() throws Exception {
        List<Payment> paymentList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT "
                + "    p.id, "
                + "    s.id AS student_id, "
                + "    s.name AS student_name, "
                + "    s.surname AS student_surname, "
                + "    t.id AS teacher_id, "
                + "    t.name AS teacher_name, "
                + "    t.surname AS teacher_surname, "
                + "    l.id AS lesson_id, "
                + "    l.lesson_name AS lesson_name, "
                + "    p.amount, "
                + "    p.date_time "
                + "FROM "
                + "    payment AS p "
                + "        INNER JOIN "
                + "    student AS s ON p.s_id = s.id "
                + "        INNER JOIN "
                + "    teacher AS t ON p.t_id = t.id "
                + "        INNER JOIN "
                + "    lesson AS l ON p.l_id = l.id "
                + "WHERE "
                + "    p.active = 1 and s.active=1 and t.active=1";
        try {
            c = DBHelper.getConnection1();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Payment payment = new Payment();
                    payment.setId(rs.getLong("id"));
                    Student student = new Student();
                    student.setId(rs.getLong("student_id"));
                    student.setName(rs.getString("student_name"));
                    student.setSurname(rs.getString("student_surname"));
                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getLong("teacher_id"));
                    teacher.setName(rs.getString("teacher_name"));
                    teacher.setSurname(rs.getString("teacher_surname"));
                    Lesson lesson = new Lesson();
                    lesson.setId(rs.getLong("lesson_id"));
                    lesson.setLessonName(rs.getString("lesson_name"));
                    payment.setStudent(student);
                    payment.setTeacher(teacher);
                    payment.setLesson(lesson);
                    payment.setAmount(rs.getDouble("amount"));
                    payment.setPayDate(rs.getDate("date_time"));
                    paymentList.add(payment);

                }

            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return paymentList;
    }

    @Override
    public boolean addPayment(Payment payment) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = " insert into payment (s_id,t_id,l_id,amount) values(?,?,?,?)";
        try {
            c = DBHelper.getConnection1();
            if (c != null) {
                ps = c.prepareStatement(sql);
//                   ps.setLong(0, payment.getId());
                ps.setLong(1, payment.getStudent().getId());
                ps.setLong(2, payment.getTeacher().getId());
                ps.setLong(3, payment.getLesson().getId());
                ps.setDouble(4, payment.getAmount());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public List<Role> getRoleList() throws Exception {
        List<Role> roleList=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select id,Role_name from role where active=1";
        try {
            c=DBHelper.getConnection1();
            if (c!=null) {
                ps=c.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next())
                {
                    Role role=new Role();
                    role.setId(rs.getLong("id"));
                    role.setRoleName(rs.getString("Role_name"));
                    roleList.add(role);
                }               
            }
            else
            {
                System.out.println("Connection is null!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roleList;
    }

}
