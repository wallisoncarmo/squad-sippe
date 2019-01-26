package com.squad.sippe.squadsippe.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.squad.sippe.squadsippe.domain.enums.Profile;
import com.squad.sippe.squadsippe.domain.generic.GenericDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class User extends GenericDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;

	@JsonIgnore
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "profiles")
	private Set<Integer> perfis = new HashSet<>();

    public User() {
        addProfile(Profile.USER);
    }

    public User(Integer id, String name, String email, boolean active, String senha) {
        super(id, active);
        this.name = name;
        this.email = email;
        this.password = senha;
        addProfile(Profile.USER);
    }

	public User(Integer id, String name, String email, boolean active, String senha, Date create, Date update) {
		super(id, active, update, create);
		this.name = name;
		this.email = email;
		this.password = senha;
		addProfile(Profile.USER);
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Profile> getProfile() {
		return perfis.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
	}

	public void addProfile(Profile profile) {
		perfis.add(profile.getCod());
	}

    @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		return Objects.equals(getName(), user.getName()) &&
				Objects.equals(getEmail(), user.getEmail()) &&
				Objects.equals(getPassword(), user.getPassword()) &&
				Objects.equals(getProfile(), user.getProfile());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getEmail(), getPassword(), getProfile());
	}
}
