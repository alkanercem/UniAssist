package SeniorProject.uniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import SeniorProject.uniAssist.entities.concretes.Student;


public interface StudentRepository extends JpaRepository<Student,Integer>{
	
	Student findByMail(String mail);
	
}
