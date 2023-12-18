package UniAssist.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import UniAssist.entities.concretes.Course;
import UniAssist.entities.concretes.Teacher;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	List<Course> findByCourseClassAndSemesterName(int courseClass, String semesterName);
	Course findById(int id);
	List<Course> findByTeacher(Teacher teacher);
}
