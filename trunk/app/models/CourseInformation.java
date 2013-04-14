package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class CourseInformation extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	public String title;
	
	@Column(columnDefinition="TEXT")
	public String content;
	
	@ManyToOne
	public Course course;
	
	public CourseInformation(String title,String content,Course course){
		this.title=title;
		this.content=content;
		this.course=course;
	}
	
	public static Finder<Long,CourseInformation> find=new Finder<Long, CourseInformation>(Long.class, CourseInformation.class);
	
	
	 public static List<CourseInformation> findAll() {
	        return find.all();
	    }
	 
	 
	 public static List<CourseInformation> findCourseInformationsByCourse(Long courseId) {
	        return find.where().eq("course.id", courseId).findList();
	    }
	
	
	public static void create(String title,String content,Course course){
		CourseInformation newCourseInformation=new CourseInformation(title, content,course);
		newCourseInformation.save();
	}
	
	public static void update(Long id,String title,String content){
		CourseInformation course=CourseInformation.find.ref(id);
		System.out.println("id:"+id);
		course.title=title;
		course.content=content;
		course.update();
	}
	public static void delete(Long id){
		find.ref(id).delete();
	}
}
