package SeniorProject.uniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import SeniorProject.uniAssist.entities.concretes.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{

}
