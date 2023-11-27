package UniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import UniAssist.entities.concretes.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher,Integer>{
	Teacher findByTc(Long tc);
	
}
	
