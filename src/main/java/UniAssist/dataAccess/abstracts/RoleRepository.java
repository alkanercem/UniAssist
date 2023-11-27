package UniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import UniAssist.entities.concretes.Role;

public interface RoleRepository extends JpaRepository<Role, Long>  {
	
	Role findByName(String name);
}
