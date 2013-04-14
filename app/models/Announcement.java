package models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import play.db.ebean.*;
import play.db.ebean.Model.Finder;

@Entity
public class Announcement extends Model{

	@Id
	public Long id;
	public String title;
	
	@Column(columnDefinition="TEXT")
	public String content;
	public Date createdDate;
	
	@ManyToOne
	public Course course;
	
	public Announcement(String title,String content,Course course){
		this.title=title;
		this.content=content;
		this.createdDate=new Date();
		this.course=course;
	}
	
	public static Finder<Long,Announcement> find=new Finder<Long, Announcement>(Long.class, Announcement.class);
	
	public static List<Announcement> findAnnouncementsByCourse(Long courseId){
		return find.where().eq("course.id", courseId).findList();
	}
	
	public static void create(String title,String content,Course course){
		Announcement an=new Announcement(title, content, course);
		an.save();
	}
	
	public static void delete(Long id){
		Announcement an=Announcement.find.byId(id);
		an.delete();
	}

	public static void update(Long id2, String title2, String content2) {
		Announcement an=Announcement.find.byId(id2);
		an.title=title2;
		an.content=content2;
		an.createdDate=new Date();
		an.update();
	}
}
