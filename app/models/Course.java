package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Course extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@Required
	public String name;
	
	@Column(columnDefinition="TEXT")
	public String description;
	
	@ManyToOne
	public User owner;
	
	public Course(String name,String description,User user){
		this.name=name;
		this.description=description;
		this.owner=user;
	}
	
	public static Finder<Long,Course> find=new Finder<Long, Course>(Long.class, Course.class);
	
	
	 public static List<Course> findAll() {
	        return find.all();
	    }
	 
	 public static List<Course> findAllAnother(String user) {
		 List<Course> all=find.all();
		 List<Course> userCourses=User.findStudentCourses(user);
		 List<Course> result=new ArrayList<Course>();
		 
		 for(int i=0;i<all.size();i++){
			 if(!all.get(i).owner.email.equals(user) && !userCourses.contains(all.get(i)))
				 result.add(all.get(i));
		 }
		 return result;
	    }
	 
	public static List<Course> findTutorCourses(String email){
		return find.where().eq("owner.email", email).findList();
	}
	
	public static boolean isTutor(Long course,String email){
		return find.where().eq("id", course).eq("owner.email", email).findRowCount()>0;
	}
	
	public static void create(String name,String description,User user){
		Course newCourse=new Course(name, description,user);
		newCourse.save();
	}
	
	public static void update(Long id,String name,String description){
		Course course=Course.find.ref(id);
		System.out.println("id:"+id);
		course.name=name;
		course.description=description;
		course.update();
		
		
	}
	public static void delete(Long id){
		find.ref(id).delete();
	}
}
