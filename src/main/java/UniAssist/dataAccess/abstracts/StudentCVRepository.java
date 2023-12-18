package UniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import UniAssist.entities.concretes.StudentCV;

public interface StudentCVRepository extends JpaRepository<StudentCV,Integer>{

}
