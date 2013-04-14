package models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import play.db.ebean.*;
import play.db.ebean.Model.Finder;

@Entity
public class Lecture extends Model{

	@Id
	public Long id;
	public String title;
	
	@Column(columnDefinition="TEXT")
	public String content;
	
	public String file;
	
	public String video;
	
	@ManyToOne
	public Course course;
	
	public Lecture(String title,String content,Course course){
		this.title=title;
		this.content=content;
		this.course=course;
	}
	
	public static Finder<Long,Lecture> find=new Finder<Long, Lecture>(Long.class, Lecture.class);
	
	public static List<Lecture> findLecturesByCourse(Long courseId){
		return find.where().eq("course.id", courseId).findList();
	}
	
	public static void create(String title,String content,Course course){
		Lecture an=new Lecture(title, content, course);
		an.save();
	}
	
	public static void delete(Long id){
		Lecture an=Lecture.find.byId(id);
		an.delete();
	}

	public static void update(Long id2, String title2, String content2) {
		Lecture an=Lecture.find.byId(id2);
		an.title=title2;
		an.content=content2;
		an.update();
	}
}
