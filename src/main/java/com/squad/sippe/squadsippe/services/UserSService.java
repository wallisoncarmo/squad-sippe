package com.squad.sippe.squadsippe.services;

import com.squad.sippe.squadsippe.security.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserSService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
