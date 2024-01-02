package UniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import UniAssist.entities.concretes.Student;
import UniAssist.entities.concretes.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>{
	
	Teacher findByMail(String mail);
	Teacher findByTc(Long tc);
	Teacher findById(int id);
	Teacher findByFirstNameAndLastName(String firstName, String lastName);
	 
	 //@Query("SELECT t.id FROM Teacher t WHERE t.firstName = :firstName AND t.lastName = :lastName")
	 //Integer findTeacherIdByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
}
	
