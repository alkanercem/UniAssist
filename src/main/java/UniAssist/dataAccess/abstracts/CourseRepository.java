package UniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import UniAssist.entities.concretes.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{

}
