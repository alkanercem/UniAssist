package SeniorProject.uniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import SeniorProject.uniAssist.entities.concretes.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher,Integer>{
	Teacher findByTc(Long tc);
	
}
	
