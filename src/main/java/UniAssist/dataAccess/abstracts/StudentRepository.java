package UniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import UniAssist.entities.concretes.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	Student findById(int id);
	Student findByMail(String mail);

	
}
