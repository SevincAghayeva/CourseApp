
package service;

import java.util.List;

import dao.CourseDao;
import model.Lesson;
import model.Payment;
import model.Role;
import model.Student;
import model.Teacher;

public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao;

	public CourseServiceImpl(CourseDao courseDao) {
		this.courseDao=courseDao;
	}

	@Override
	public List<Student> getstudentList() throws Exception {
		return courseDao.getstudentList();
	}

	@Override
	public boolean addStudent(Student student) throws Exception {
		return courseDao.addStudent(student);
	}

	@Override
	public Student getStudentById(Long studentId) throws Exception {
           
		return courseDao.getStudentById(studentId);
	}

	@Override
	public boolean updateStudent(Student student1, Long studentId) throws Exception {
		return courseDao.updateStudent(student1, studentId);
	}

	@Override
	public boolean deleteStudent(Long id) throws Exception {
		
		return courseDao.deleteStudent(id);
	}

	@Override
	public List<Student> searchStudentData(String keyword) throws Exception {
		return courseDao.searchStudentData(keyword);
	}

    @Override
    public List<Lesson> getLessonList() throws Exception {
        return courseDao.getLessonList();
    }

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        return courseDao.getTeacherList();
    }

    @Override
    public List<Payment> getPaymentList() throws Exception {
        return courseDao.getPaymentList();
    }

    @Override
    public boolean addPayment(Payment payment) throws Exception {
        return courseDao.addPayment(payment);
    }

    @Override
    public List<Role> getRoleList() throws Exception {
        return courseDao.getRoleList();
    }
	

}
