package models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class User extends Model{
	
	@Id
	@Column(length=40, nullable=false)
	public String email;
	public String name;
	public String password;
	public String position;
	public String company;
	public String photo;
	public boolean active;
	
	@ManyToMany(cascade=CascadeType.REMOVE)
	public List<Course> courses=new ArrayList<Course>();
	
	@ManyToOne
	public Role role;
	
	public User(String name,String email,String password,Role role){
		this.email=email;
		this.name=name;
		this.password=password;
		this.role=role;
		this.active=false;
	}
	
	public static Finder<String, User> find=new Finder<String, User>(String.class, User.class);
	
	public static List<User> findAll(){
		return find.all();
	}
	
	public static String getRole(String email){
		return find.byId(email).role.name.name();
	}
	
	public static boolean isStudent(Long course,String email){
		List<Course> studentCourses=find.byId(email).courses;
		if(studentCourses.contains(Course.find.byId(course)))
			return true;
		return false;
	}
	
	public static List<Course> findStudentCourses(String email){
		return find.byId(email).courses;
	}
	
	public static User authenticate(String email,String password){
		return find.where().eq("active", true).eq("email", email).eq("password", password).findUnique();
	}
	
	public static void create(String name,String email,String password,Role role){
		User newUser=new User(name, email, password,role);
		newUser.save();
	}
	public static void addCourse(User user,Course course){
		user.courses.add(course);
		user.update();
	}
	
}
