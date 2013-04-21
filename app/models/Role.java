package models;

import java.util.List;

import javax.persistence.*;

import models.Enums.RoleTypes;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Role {

	@Id
	public Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Administrator','Tutor','Student')")
	public RoleTypes name;
	
	@ManyToMany
	public List<Module> modules;
	
	
	
	public static Finder<Long,Role> find=new Finder<Long, Role>(Long.class, Role.class);
	
}
