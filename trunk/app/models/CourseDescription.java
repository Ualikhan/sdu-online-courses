package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class CourseDescription extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	public String title;
	
	@Column(columnDefinition="TEXT")
	public String content;
	
	@ManyToOne
	public Course course;
	
	public CourseDescription(String title,String content,Course course){
		this.title=title;
		this.content=content;
		this.course=course;
	}
	
	public static Finder<Long,CourseDescription> find=new Finder<Long, CourseDescription>(Long.class, CourseDescription.class);
	
	
	 public static List<CourseDescription> findAll() {
	        return find.all();
	    }
	 
	 
	 public static List<CourseDescription> findCourseDescriptionsByCourse(Long courseId) {
	        return find.where().eq("course.id", courseId).findList();
	    }
	
	
	public static void create(String title,String content,Course course){
		CourseDescription newCourseDescription=new CourseDescription(title, content,course);
		newCourseDescription.save();
	}
	
	public static void update(Long id,String title,String content){
		CourseDescription course=CourseDescription.find.ref(id);
		System.out.println("id:"+id);
		course.title=title;
		course.content=content;
		course.update();
	}
	public static void delete(Long id){
		find.ref(id).delete();
	}
}
