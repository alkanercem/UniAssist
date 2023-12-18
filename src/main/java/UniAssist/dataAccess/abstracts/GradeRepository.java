package UniAssist.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import UniAssist.entities.concretes.Course;
import UniAssist.entities.concretes.Grade;
import UniAssist.entities.concretes.Student;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
	List<Grade> findByStudent(Student student);
	List<Grade> findByCourse(Course course);
	Grade findByStudentIdAndCourseId(int student_id, int course_id);

	
}

