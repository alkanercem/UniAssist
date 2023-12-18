package UniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import UniAssist.entities.concretes.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	Student findByMail(String mail);
	Student findById(int id);
	
}
