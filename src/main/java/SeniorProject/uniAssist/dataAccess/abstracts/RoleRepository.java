package SeniorProject.uniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import SeniorProject.uniAssist.entities.concretes.Role;

public interface RoleRepository extends JpaRepository<Role, Long>  {
	
	Role findByName(String name);
}
