package models;

import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Module {

	@Id
	public Long id;
	
	public String name;	
	
	public static Finder<Long,Module> find=new Finder<Long, Module>(Long.class, Module.class);
	
}
