package service;

import java.util.List;
import model.Lesson;
import model.Payment;
import model.Role;

import model.Student;
import model.Teacher;

public interface CourseService {

    List<Student> getstudentList() throws Exception;

    boolean addStudent(Student student) throws Exception;

    Student getStudentById(Long studentId) throws Exception;

    boolean updateStudent(Student student1, Long studentId) throws Exception;

    boolean deleteStudent(Long id) throws Exception;

    List<Student> searchStudentData(String keyword) throws Exception;

    List<Lesson> getLessonList() throws Exception;

    List<Teacher> getTeacherList() throws Exception;
    List<Payment>getPaymentList() throws Exception;
    boolean addPayment(Payment payment) throws Exception;
     List<Role>getRoleList() throws Exception;
}
