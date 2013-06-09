package controllers;

import static play.data.Form.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Assignment;
import models.CourseInformation;
import models.Enums.PostTypes;
import models.ForumType;
import models.ForumTypeInfo;
import models.Post;
import models.Question;
import models.Course;
import models.ThreadInfo;
import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.forum.*;

@Security.Authenticated(Secured.class)
public class Forums extends Controller{	

static Long courseId;

public static Result index() {
	courseId=Long.parseLong(session("course"));
	
	List<ForumType> forumTypes=ForumType.find.all();
	List<ForumTypeInfo> forumTypesInfo=new ArrayList<ForumTypeInfo>();
	
	for(int i=0;i<forumTypes.size();i++){
		ForumType a=forumTypes.get(i);
		int b=Post.findThreasByForumType(forumTypes.get(i).id);
		int c=Post.findPostsByForumType(forumTypes.get(i).id);
		Post l=Post.findLastPostByForumType(forumTypes.get(i).id);
		ForumTypeInfo fti=new ForumTypeInfo(a, b, c, l);
		forumTypesInfo.add(fti);
	}
	
	String userType="";
	if(Secured.isTutorOf(courseId)){
		userType="TUTOR";
	}
	if(Secured.isStudentOf(courseId)){
		userType="STUDENT";
	}
	
		return ok(
				forumtypes.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						forumTypesInfo,
						userType
						)
				);
}

public static Result getThreads(Long id){
	courseId=Long.parseLong(session("course"));
	List<Post> threads=Post.findByForumType(courseId,id);
	List<ThreadInfo> threadsInfo=new ArrayList<ThreadInfo>();
	
	for(int i=0;i<threads.size();i++){
		Post a=threads.get(i);
		int b=Post.findRepliesCountByThread(threads.get(i).id);
		Post l=Post.findLastPostByThread(threads.get(i).id);
		ThreadInfo fti=new ThreadInfo(a, b, l);
		threadsInfo.add(fti);
	}
	
	String userType="";
	if(Secured.isTutorOf(courseId)){
		userType="TUTOR";
	}
	if(Secured.isStudentOf(courseId)){
		userType="STUDENT";
	}
		return ok(
				index.render(
						User.find.where().eq("email", request().username()).findUnique(),
						Course.find.byId(courseId),
						ForumType.find.ref(id),
						threadsInfo,
						userType
						)
				);
}

public static Result getThread(Long id) {
	courseId=Long.parseLong(session("course"));
	Course course=Course.find.byId(courseId);
	Post post=Post.find.ref(id);
	post.views=post.views+1;
	post.update();
	
	String userType="";
	if(Secured.isTutorOf(courseId)){
		userType="TUTOR";
	}
	if(Secured.isStudentOf(courseId)){
		userType="STUDENT";
	}
	
		return ok(
				item.render(
						User.find.where().eq("email", request().username()).findUnique(),
						course,
						post,
						Post.findReplies(id),
						userType
						)
				);	
}

public static Result newThread(Long id) {
	courseId=Long.parseLong(session("course"));
	Course course=Course.find.byId(courseId);
	
	String userType="";
	if(Secured.isTutorOf(courseId)){
		userType="TUTOR";
	}
	if(Secured.isStudentOf(courseId)){
		userType="STUDENT";
	}
	
		return ok(
				addnewthread.render(
						User.find.where().eq("email", request().username()).findUnique(),
						course,
						ForumType.find.ref(id),
						userType
						)
				);
}

public static Result saveThread(Long formTypeId) {
	courseId=Long.parseLong(session("course"));
		DynamicForm filledForm=form().bindFromRequest();
		Course course=Course.find.byId(courseId);
		User user=User.find.where().eq("email", request().username()).findUnique();
		Post post=Post.create(filledForm.get("title"), filledForm.get("description"),formTypeId,user,course);
		
		String userType="";
		if(Secured.isTutorOf(courseId)){
			userType="TUTOR";
		}
		if(Secured.isStudentOf(courseId)){
			userType="STUDENT";
		}
		
		return ok(
				item.render(
						user,
						course,
						post,
						Post.findReplies(post.id),
						userType
						)
				);
}

public static Result newReply(Long threadId) {
	courseId=Long.parseLong(session("course"));
		DynamicForm filledForm=form().bindFromRequest();
		Course course=Course.find.byId(courseId);
		User user=User.find.where().eq("email", request().username()).findUnique();
		Post post=Post.find.ref(threadId);
		
		Post p=new Post();
		p.description=filledForm.get("description");
		p.postedDate=new Date();
		p.postType=PostTypes.REPLY;
		p.author=user;
		p.course=course;
		p.repliedTo=post;
		p.forumType=post.forumType;
		p.views=(long) 0;
		p.save();
		
		String userType="";
		if(Secured.isTutorOf(courseId)){
			userType="TUTOR";
		}
		if(Secured.isStudentOf(courseId)){
			userType="STUDENT";
		}
		
		return ok(
				item.render(
						user,
						course,
						post,
						Post.findReplies(post.id),
						userType
						)
				);
}

public static Result voteUp(Long id,Long replyId) {
	courseId=Long.parseLong(session("course"));
	Course course=Course.find.byId(courseId);
	Post post=Post.find.ref(id);
	Post reply=Post.find.ref(replyId);
	reply.votes=reply.votes+1;
	reply.update();
	
	String userType="";
	if(Secured.isTutorOf(courseId)){
		userType="TUTOR";
	}
	if(Secured.isStudentOf(courseId)){
		userType="STUDENT";
	}
	
		return ok(
				item.render(
						User.find.where().eq("email", request().username()).findUnique(),
						course,
						post,
						Post.findReplies(id),
						userType
						)
				);
}

public static Result voteDown(Long id,Long replyId) {
	courseId=Long.parseLong(session("course"));
	Course course=Course.find.byId(courseId);
	Post post=Post.find.ref(id);
	Post reply=Post.find.ref(replyId);
	reply.votes=reply.votes-1;
	reply.update();
	
	String userType="";
	if(Secured.isTutorOf(courseId)){
		userType="TUTOR";
	}
	if(Secured.isStudentOf(courseId)){
		userType="STUDENT";
	}
	
		return ok(
				item.render(
						User.find.where().eq("email", request().username()).findUnique(),
						course,
						post,
						Post.findReplies(id),
						userType
						)
				);
}

public static Result sortByDate(Long id) {
	courseId=Long.parseLong(session("course"));
	Course course=Course.find.byId(courseId);
	Post post=Post.find.ref(id);
	
	String userType="";
	if(Secured.isTutorOf(courseId)){
		userType="TUTOR";
	}
	if(Secured.isStudentOf(courseId)){
		userType="STUDENT";
	}
		return ok(
				item.render(
						User.find.where().eq("email", request().username()).findUnique(),
						course,
						post,
						Post.findRepliesByDatePosted(id),
						userType
						)
				);
}

public static Result sortByVotes(Long id) {
	courseId=Long.parseLong(session("course"));
	Course course=Course.find.byId(courseId);
	Post post=Post.find.ref(id);
	
	String userType="";
	if(Secured.isTutorOf(courseId)){
		userType="TUTOR";
	}
	if(Secured.isStudentOf(courseId)){
		userType="STUDENT";
	}
	
		return ok(
				item.render(
						User.find.where().eq("email", request().username()).findUnique(),
						course,
						post,
						Post.findRepliesByVotes(id),
						userType
						)
				);
}

}
