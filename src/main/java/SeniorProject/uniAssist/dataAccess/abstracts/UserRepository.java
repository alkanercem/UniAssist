package SeniorProject.uniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import SeniorProject.uniAssist.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

}