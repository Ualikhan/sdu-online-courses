package models;

import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class ForumType{

	@Id
	public Long id;
	
	public String name;	
	
	public String description;	
	
	public static Finder<Long,ForumType> find=new Finder<Long, ForumType>(Long.class, ForumType.class);
	
}
