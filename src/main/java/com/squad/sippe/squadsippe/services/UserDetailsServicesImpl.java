package com.squad.sippe.squadsippe.services;


import com.squad.sippe.squadsippe.domain.User;
import com.squad.sippe.squadsippe.repositoties.UserRepository;
import com.squad.sippe.squadsippe.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServicesImpl implements UserDetailsService {
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 User obj = repo.findByEmailContaining(email);
		if (obj == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(obj.getId(), obj.getEmail(), obj.getPassword(), obj.getProfile());
	}

}
