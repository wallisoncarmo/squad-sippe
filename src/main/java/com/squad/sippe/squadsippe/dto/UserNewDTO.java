package com.squad.sippe.squadsippe.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.squad.sippe.squadsippe.domain.User;
import org.hibernate.validator.constraints.Length;


public class UserNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(min = 5, max = 255, message = "O tamanho precisa ser de 5 a 255 caracter!")
	private String name;	
		
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Email(message = "E-mail inválido!")
	private String email;
	
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(min = 5, max = 120, message = "O tamanho precisa ser de 5 a 120 caracter!")
	private String password;
	
	private boolean active;
	
	public UserNewDTO() {
	}
		
	public UserNewDTO(User obj) {
		name = obj.getName();
		email = obj.getEmail();
		active = obj.isActive();
		password = obj.getPassword();
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String senha) {
		this.password = senha;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}		
	
}
