package com.squad.sippe.squadsippe.repositoties;

import com.squad.sippe.squadsippe.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmailContaining(String text);
	
}
