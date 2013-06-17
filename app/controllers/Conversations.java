package controllers;

import static play.data.Form.form;

import java.text.ParseException;
import java.util.Date;

import models.Assignment;
import models.Conversation;
import models.Course;
import models.Question;
import models.User;
import models.Enums.AnswerTypes;
import models.Enums.PostTypes;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.conversation.*;


@Security.Authenticated(Secured.class)
public class Conversations extends Controller{	

static Long courseId;	

public static Result index(){
	Course c=null;
	if(session("course")!=null && session("course").length()>0){
	courseId=Long.parseLong(session("course"));
	c=Course.find.byId(courseId);
	}
	User user=User.find.where().eq("email", request().username()).findUnique();
return ok(
		index.render(
				user,
				c,
				Conversation.findInbox(user)
				)
		);
}

public static Result sent(){
	Course c=null;
	if(session("course")!=null && session("course").length()>0){
	courseId=Long.parseLong(session("course"));
	c=Course.find.byId(courseId);
	}
	User user=User.find.where().eq("email", request().username()).findUnique();
return ok(
		sent.render(
				user,
				c,
				Conversation.findSent(user)
				)
		);
}

public static Result getThread(Long id,String convType){
	Course c=null;
	if(session("course")!=null && session("course").length()>0){
	courseId=Long.parseLong(session("course"));
	c=Course.find.byId(courseId);
	}
	User user=User.find.where().eq("email", request().username()).findUnique();
return ok(
		item.render(
				user,
				c,
				Conversation.find.ref(id),
				Conversation.findRepliesByThread(id),
				convType
				)
		);
}

public static Result newConversation(String email){
	Course c=null;
	if(session("course")!=null && session("course").length()>0){
	courseId=Long.parseLong(session("course"));
	c=Course.find.byId(courseId);
	}
	
	User user=User.find.where().eq("email", request().username()).findUnique();
	User toUser=User.find.where().eq("email", email).findUnique();
return ok(
		createconversation.render(
				user,
				c,
				toUser
				)
		);
}

public static Result saveConversation(){
	
	User user=User.find.where().eq("email", request().username()).findUnique();
	
	DynamicForm filledForm=form().bindFromRequest();
	String toUserEmail=filledForm.get("toUserEmail");
	String title=filledForm.get("title");
	String description=filledForm.get("description");
	
	Conversation conversation=new Conversation();
	conversation.title=title;
	conversation.description=description;
	conversation.toUser=User.find.ref(toUserEmail);
	conversation.fromUser=user;
	conversation.sendedDate=new Date();
	conversation.conversationType=PostTypes.THREAD;
	conversation.save();
	
return redirect(routes.Users.profile(toUserEmail));
}

public static Result saveReply(Long threadId){
	
	User user=User.find.where().eq("email", request().username()).findUnique();
	
	DynamicForm filledForm=form().bindFromRequest();
	String toUserEmail=filledForm.get("toUserEmail");
	String description=filledForm.get("description");
	
	Conversation conversation=new Conversation();
	conversation.description=description;
	conversation.toUser=User.find.ref(toUserEmail);
	conversation.fromUser=user;
	conversation.sendedDate=new Date();
	conversation.conversationType=PostTypes.REPLY;
	conversation.repliedTo=Conversation.find.ref(threadId);
	conversation.save();
	
return redirect(routes.Conversations.sent());
}
	

}