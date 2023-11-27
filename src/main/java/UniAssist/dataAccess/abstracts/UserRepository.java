package UniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import UniAssist.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

}