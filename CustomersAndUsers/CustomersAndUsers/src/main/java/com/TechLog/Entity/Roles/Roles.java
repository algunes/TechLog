package com.TechLog.Entity.Roles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role_type")
public abstract class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="roleId") 
	private Long id;
	
	@Column(name="rname", nullable = false)
	private String name;
	
	@Column(name="rcreate", nullable = false)
	private boolean create;
	
	@Column(name="rread", nullable = false)
	private boolean read;
	
	@Column(name="rupdate", nullable = false)
	private boolean update;
	
	@Column(name="rdelete", nullable = false)
	private boolean delete;
	
	public Roles() {
		
	}
	
	public Roles(String name, boolean create, boolean read, boolean update, boolean delete) {
		super();
		this.name = name;
		this.create = create;
		this.read = read;
		this.update = update;
		this.delete = delete;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCreate() {
		return create;
	}
	public void setCreate(boolean create) {
		this.create = create;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public boolean isUpdate() {
		return update;
	}
	public void setUpdate(boolean update) {
		this.update = update;
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}

}
