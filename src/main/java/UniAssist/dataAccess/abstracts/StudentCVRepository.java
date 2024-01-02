package UniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import UniAssist.entities.concretes.StudentCV;

public interface StudentCvRepository extends JpaRepository<StudentCV,Integer>{
	StudentCV findById(int id);
}
