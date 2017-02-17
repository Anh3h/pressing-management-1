package com.tragent.pressing.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	private String description;
	
	@Column(nullable=false)
	@ManyToMany(mappedBy="roles")
	private List<CustomUser> users;
	
	@Column(nullable=false)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="role_permission", 
	joinColumns=@JoinColumn(name="role_id"), 
	inverseJoinColumns=@JoinColumn(name="permission_id"))
	private List<Permission> permissions;
	
	public Role() {
		super();
	}

	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Permission> getPermission() {
		return this.permissions;
	}
	
	public void setPermission(List<Permission> permission) {
		this.permissions = permission;
	}

	@Override
	public String getAuthority() {
		return name.toString();
	}
	
}
