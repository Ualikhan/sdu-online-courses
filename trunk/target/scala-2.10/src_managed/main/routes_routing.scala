// @SOURCE:D:/sdu-online-courses/conf/routes
// @HASH:4ec7c094e92b81ac0eabbe980e40726f33f18f9b
// @DATE:Fri Apr 19 17:42:49 ALMT 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_login1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:8
private[this] lazy val controllers_Application_authenticate2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:9
private[this] lazy val controllers_Application_logout3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:10
private[this] lazy val controllers_Application_registerForm4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
        

// @LINE:11
private[this] lazy val controllers_Application_register5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
        

// @LINE:12
private[this] lazy val controllers_Application_list6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("list"))))
        

// @LINE:16
private[this] lazy val controllers_Application_javascriptRoutes7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("javascriptRoutes"))))
        

// @LINE:19
private[this] lazy val controllers_Courses_index8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("courses"))))
        

// @LINE:20
private[this] lazy val controllers_Courses_newCourse9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("courses"))))
        

// @LINE:21
private[this] lazy val controllers_Courses_deleteCourse10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("courses/"),DynamicPart("id", """[^/]+"""),StaticPart("/delete"))))
        

// @LINE:23
private[this] lazy val controllers_Courses_updateCourse11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("courses/"),DynamicPart("id", """[^/]+"""))))
        

// @LINE:24
private[this] lazy val controllers_Courses_coursePage12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("courses/"),DynamicPart("id", """[^/]+"""))))
        

// @LINE:25
private[this] lazy val controllers_Courses_courseDescription13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("courses/"),DynamicPart("id", """[^/]+"""),StaticPart("/description"))))
        

// @LINE:26
private[this] lazy val controllers_Courses_join14 = Route("POST", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:29
private[this] lazy val controllers_Announcements_index15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/announcements"))))
        

// @LINE:30
private[this] lazy val controllers_Announcements_newAnnouncement16 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/announcements"))))
        

// @LINE:31
private[this] lazy val controllers_Announcements_deleteAnnouncement17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/announcement/"),DynamicPart("aid", """[^/]+"""),StaticPart("/delete"))))
        

// @LINE:32
private[this] lazy val controllers_Announcements_announcementPage18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/announcements/"),DynamicPart("aid", """[^/]+"""))))
        

// @LINE:33
private[this] lazy val controllers_Announcements_updateAnnouncement19 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/announcements/"),DynamicPart("aid", """[^/]+"""))))
        

// @LINE:35
private[this] lazy val controllers_Announcements_updateTitle20 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/announcement/updateTitle"))))
        

// @LINE:36
private[this] lazy val controllers_Announcements_updateContent21 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/announcement/updateContent"))))
        

// @LINE:40
private[this] lazy val controllers_Lectures_index22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lectures"))))
        

// @LINE:42
private[this] lazy val controllers_Lectures_newLecture23 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lectures"))))
        

// @LINE:43
private[this] lazy val controllers_Lectures_addVideo24 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lecture/"),DynamicPart("id", """[^/]+"""),StaticPart("/addVideo"))))
        

// @LINE:44
private[this] lazy val controllers_Lectures_addSlide25 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lecture/"),DynamicPart("id", """[^/]+"""),StaticPart("/addSlide"))))
        

// @LINE:46
private[this] lazy val controllers_Lectures_updateTitle26 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lecture/updateTitle"))))
        

// @LINE:47
private[this] lazy val controllers_Lectures_updateContent27 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lecture/updateContent"))))
        

// @LINE:48
private[this] lazy val controllers_Lectures_updateResourceTitle28 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lecture/updateResourceTitle"))))
        

// @LINE:50
private[this] lazy val controllers_Lectures_removeResource29 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lecture/"),DynamicPart("lid", """[^/]+"""),StaticPart("/removeResource"))))
        

// @LINE:51
private[this] lazy val controllers_Lectures_deleteLecture30 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lecture/"),DynamicPart("aid", """[^/]+"""),StaticPart("/delete"))))
        

// @LINE:52
private[this] lazy val controllers_Lectures_lecturePage31 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lectures/"),DynamicPart("aid", """[^/]+"""))))
        

// @LINE:53
private[this] lazy val controllers_Lectures_getLecture32 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lecture/"),DynamicPart("id", """[^/]+"""))))
        

// @LINE:54
private[this] lazy val controllers_Lectures_updateLecture33 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lectures/"),DynamicPart("aid", """[^/]+"""))))
        

// @LINE:57
private[this] lazy val controllers_CourseInformations_index34 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseInformations"))))
        

// @LINE:58
private[this] lazy val controllers_CourseInformations_newCourseInformation35 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseInformations"))))
        

// @LINE:59
private[this] lazy val controllers_CourseInformations_deleteCourseInformation36 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseInformation/"),DynamicPart("aid", """[^/]+"""),StaticPart("/delete"))))
        

// @LINE:60
private[this] lazy val controllers_CourseInformations_courseInformationPage37 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseInformations/"),DynamicPart("aid", """[^/]+"""))))
        

// @LINE:61
private[this] lazy val controllers_CourseInformations_updateCourseInformation38 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseInformations/"),DynamicPart("aid", """[^/]+"""))))
        

// @LINE:62
private[this] lazy val controllers_CourseInformations_getCourseInformation39 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseInformation/"),DynamicPart("id", """[^/]+"""))))
        

// @LINE:66
private[this] lazy val controllers_CourseDescriptions_index40 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseDescriptions"))))
        

// @LINE:67
private[this] lazy val controllers_CourseDescriptions_newCourseDescription41 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseDescriptions"))))
        

// @LINE:68
private[this] lazy val controllers_CourseDescriptions_deleteCourseDescription42 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseDescription/"),DynamicPart("aid", """[^/]+"""),StaticPart("/delete"))))
        

// @LINE:69
private[this] lazy val controllers_CourseDescriptions_courseDescriptionPage43 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseDescriptions/"),DynamicPart("aid", """[^/]+"""))))
        

// @LINE:70
private[this] lazy val controllers_CourseDescriptions_updateCourseDescription44 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseDescriptions/"),DynamicPart("aid", """[^/]+"""))))
        

// @LINE:71
private[this] lazy val controllers_CourseDescriptions_getCourseDescription45 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseDescription/"),DynamicPart("id", """[^/]+"""))))
        

// @LINE:75
private[this] lazy val controllers_Students_index46 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student"))))
        

// @LINE:78
private[this] lazy val controllers_Users_upload47 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/upload"))))
        

// @LINE:79
private[this] lazy val controllers_Users_profile48 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/profile"))))
        

// @LINE:80
private[this] lazy val controllers_Users_pro49 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/profile"))))
        

// @LINE:82
private[this] lazy val controllers_Users_editUser50 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/editUser"))))
        

// @LINE:83
private[this] lazy val controllers_Users_changePassword51 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/changePassword"))))
        

// @LINE:89
private[this] lazy val controllers_Assets_at52 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+"""))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Application.registerForm()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Application.register()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """list""","""controllers.Application.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """javascriptRoutes""","""controllers.Application.javascriptRoutes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """courses""","""controllers.Courses.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """courses""","""controllers.Courses.newCourse()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """courses/$id<[^/]+>/delete""","""controllers.Courses.deleteCourse(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """courses/$id<[^/]+>""","""controllers.Courses.updateCourse(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """courses/$id<[^/]+>""","""controllers.Courses.coursePage(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """courses/$id<[^/]+>/description""","""controllers.Courses.courseDescription(id:Long)"""),("""POST""", prefix,"""controllers.Courses.join(course:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/announcements""","""controllers.Announcements.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/announcements""","""controllers.Announcements.newAnnouncement()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/announcement/$aid<[^/]+>/delete""","""controllers.Announcements.deleteAnnouncement(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/announcements/$aid<[^/]+>""","""controllers.Announcements.announcementPage(aid:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/announcements/$aid<[^/]+>""","""controllers.Announcements.updateAnnouncement(aid:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/announcement/updateTitle""","""controllers.Announcements.updateTitle(id:String, cont:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/announcement/updateContent""","""controllers.Announcements.updateContent(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lectures""","""controllers.Lectures.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lectures""","""controllers.Lectures.newLecture()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lecture/$id<[^/]+>/addVideo""","""controllers.Lectures.addVideo(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lecture/$id<[^/]+>/addSlide""","""controllers.Lectures.addSlide(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lecture/updateTitle""","""controllers.Lectures.updateTitle()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lecture/updateContent""","""controllers.Lectures.updateContent()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lecture/updateResourceTitle""","""controllers.Lectures.updateResourceTitle()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lecture/$lid<[^/]+>/removeResource""","""controllers.Lectures.removeResource(rid:Long, lid:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lecture/$aid<[^/]+>/delete""","""controllers.Lectures.deleteLecture(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lectures/$aid<[^/]+>""","""controllers.Lectures.lecturePage(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lecture/$id<[^/]+>""","""controllers.Lectures.getLecture(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lectures/$aid<[^/]+>""","""controllers.Lectures.updateLecture(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseInformations""","""controllers.CourseInformations.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseInformations""","""controllers.CourseInformations.newCourseInformation()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseInformation/$aid<[^/]+>/delete""","""controllers.CourseInformations.deleteCourseInformation(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseInformations/$aid<[^/]+>""","""controllers.CourseInformations.courseInformationPage(aid:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseInformations/$aid<[^/]+>""","""controllers.CourseInformations.updateCourseInformation(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseInformation/$id<[^/]+>""","""controllers.CourseInformations.getCourseInformation(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseDescriptions""","""controllers.CourseDescriptions.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseDescriptions""","""controllers.CourseDescriptions.newCourseDescription()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseDescription/$aid<[^/]+>/delete""","""controllers.CourseDescriptions.deleteCourseDescription(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseDescriptions/$aid<[^/]+>""","""controllers.CourseDescriptions.courseDescriptionPage(aid:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseDescriptions/$aid<[^/]+>""","""controllers.CourseDescriptions.updateCourseDescription(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseDescription/$id<[^/]+>""","""controllers.CourseDescriptions.getCourseDescription(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student""","""controllers.Students.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/upload""","""controllers.Users.upload()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/profile""","""controllers.Users.profile()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/profile""","""controllers.Users.pro()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/editUser""","""controllers.Users.editUser()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/changePassword""","""controllers.Users.changePassword()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_login1(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"GET", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:8
case controllers_Application_authenticate2(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:9
case controllers_Application_logout3(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:10
case controllers_Application_registerForm4(params) => {
   call { 
        invokeHandler(controllers.Application.registerForm(), HandlerDef(this, "controllers.Application", "registerForm", Nil,"GET", """""", Routes.prefix + """register"""))
   }
}
        

// @LINE:11
case controllers_Application_register5(params) => {
   call { 
        invokeHandler(controllers.Application.register(), HandlerDef(this, "controllers.Application", "register", Nil,"POST", """""", Routes.prefix + """register"""))
   }
}
        

// @LINE:12
case controllers_Application_list6(params) => {
   call { 
        invokeHandler(controllers.Application.list(), HandlerDef(this, "controllers.Application", "list", Nil,"GET", """""", Routes.prefix + """list"""))
   }
}
        

// @LINE:16
case controllers_Application_javascriptRoutes7(params) => {
   call { 
        invokeHandler(controllers.Application.javascriptRoutes(), HandlerDef(this, "controllers.Application", "javascriptRoutes", Nil,"GET", """""", Routes.prefix + """javascriptRoutes"""))
   }
}
        

// @LINE:19
case controllers_Courses_index8(params) => {
   call { 
        invokeHandler(controllers.Courses.index(), HandlerDef(this, "controllers.Courses", "index", Nil,"GET", """Courses""", Routes.prefix + """courses"""))
   }
}
        

// @LINE:20
case controllers_Courses_newCourse9(params) => {
   call { 
        invokeHandler(controllers.Courses.newCourse(), HandlerDef(this, "controllers.Courses", "newCourse", Nil,"POST", """""", Routes.prefix + """courses"""))
   }
}
        

// @LINE:21
case controllers_Courses_deleteCourse10(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Courses.deleteCourse(id), HandlerDef(this, "controllers.Courses", "deleteCourse", Seq(classOf[Long]),"POST", """""", Routes.prefix + """courses/$id<[^/]+>/delete"""))
   }
}
        

// @LINE:23
case controllers_Courses_updateCourse11(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Courses.updateCourse(id), HandlerDef(this, "controllers.Courses", "updateCourse", Seq(classOf[Long]),"POST", """""", Routes.prefix + """courses/$id<[^/]+>"""))
   }
}
        

// @LINE:24
case controllers_Courses_coursePage12(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Courses.coursePage(id), HandlerDef(this, "controllers.Courses", "coursePage", Seq(classOf[Long]),"GET", """""", Routes.prefix + """courses/$id<[^/]+>"""))
   }
}
        

// @LINE:25
case controllers_Courses_courseDescription13(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Courses.courseDescription(id), HandlerDef(this, "controllers.Courses", "courseDescription", Seq(classOf[Long]),"GET", """""", Routes.prefix + """courses/$id<[^/]+>/description"""))
   }
}
        

// @LINE:26
case controllers_Courses_join14(params) => {
   call(params.fromQuery[Long]("course", None)) { (course) =>
        invokeHandler(controllers.Courses.join(course), HandlerDef(this, "controllers.Courses", "join", Seq(classOf[Long]),"POST", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:29
case controllers_Announcements_index15(params) => {
   call { 
        invokeHandler(controllers.Announcements.index(), HandlerDef(this, "controllers.Announcements", "index", Nil,"GET", """Announcements""", Routes.prefix + """course/announcements"""))
   }
}
        

// @LINE:30
case controllers_Announcements_newAnnouncement16(params) => {
   call { 
        invokeHandler(controllers.Announcements.newAnnouncement(), HandlerDef(this, "controllers.Announcements", "newAnnouncement", Nil,"POST", """""", Routes.prefix + """course/announcements"""))
   }
}
        

// @LINE:31
case controllers_Announcements_deleteAnnouncement17(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.Announcements.deleteAnnouncement(aid), HandlerDef(this, "controllers.Announcements", "deleteAnnouncement", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/announcement/$aid<[^/]+>/delete"""))
   }
}
        

// @LINE:32
case controllers_Announcements_announcementPage18(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.Announcements.announcementPage(aid), HandlerDef(this, "controllers.Announcements", "announcementPage", Seq(classOf[Long]),"GET", """""", Routes.prefix + """course/announcements/$aid<[^/]+>"""))
   }
}
        

// @LINE:33
case controllers_Announcements_updateAnnouncement19(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.Announcements.updateAnnouncement(aid), HandlerDef(this, "controllers.Announcements", "updateAnnouncement", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/announcements/$aid<[^/]+>"""))
   }
}
        

// @LINE:35
case controllers_Announcements_updateTitle20(params) => {
   call(params.fromQuery[String]("id", None), params.fromQuery[String]("cont", None)) { (id, cont) =>
        invokeHandler(controllers.Announcements.updateTitle(id, cont), HandlerDef(this, "controllers.Announcements", "updateTitle", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """course/announcement/updateTitle"""))
   }
}
        

// @LINE:36
case controllers_Announcements_updateContent21(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(controllers.Announcements.updateContent(id), HandlerDef(this, "controllers.Announcements", "updateContent", Seq(classOf[String]),"POST", """""", Routes.prefix + """course/announcement/updateContent"""))
   }
}
        

// @LINE:40
case controllers_Lectures_index22(params) => {
   call { 
        invokeHandler(controllers.Lectures.index(), HandlerDef(this, "controllers.Lectures", "index", Nil,"GET", """Lectures""", Routes.prefix + """course/lectures"""))
   }
}
        

// @LINE:42
case controllers_Lectures_newLecture23(params) => {
   call { 
        invokeHandler(controllers.Lectures.newLecture(), HandlerDef(this, "controllers.Lectures", "newLecture", Nil,"POST", """""", Routes.prefix + """course/lectures"""))
   }
}
        

// @LINE:43
case controllers_Lectures_addVideo24(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Lectures.addVideo(id), HandlerDef(this, "controllers.Lectures", "addVideo", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/lecture/$id<[^/]+>/addVideo"""))
   }
}
        

// @LINE:44
case controllers_Lectures_addSlide25(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Lectures.addSlide(id), HandlerDef(this, "controllers.Lectures", "addSlide", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/lecture/$id<[^/]+>/addSlide"""))
   }
}
        

// @LINE:46
case controllers_Lectures_updateTitle26(params) => {
   call { 
        invokeHandler(controllers.Lectures.updateTitle(), HandlerDef(this, "controllers.Lectures", "updateTitle", Nil,"POST", """""", Routes.prefix + """course/lecture/updateTitle"""))
   }
}
        

// @LINE:47
case controllers_Lectures_updateContent27(params) => {
   call { 
        invokeHandler(controllers.Lectures.updateContent(), HandlerDef(this, "controllers.Lectures", "updateContent", Nil,"POST", """""", Routes.prefix + """course/lecture/updateContent"""))
   }
}
        

// @LINE:48
case controllers_Lectures_updateResourceTitle28(params) => {
   call { 
        invokeHandler(controllers.Lectures.updateResourceTitle(), HandlerDef(this, "controllers.Lectures", "updateResourceTitle", Nil,"POST", """""", Routes.prefix + """course/lecture/updateResourceTitle"""))
   }
}
        

// @LINE:50
case controllers_Lectures_removeResource29(params) => {
   call(params.fromQuery[Long]("rid", None), params.fromPath[Long]("lid", None)) { (rid, lid) =>
        invokeHandler(controllers.Lectures.removeResource(rid, lid), HandlerDef(this, "controllers.Lectures", "removeResource", Seq(classOf[Long], classOf[Long]),"POST", """""", Routes.prefix + """course/lecture/$lid<[^/]+>/removeResource"""))
   }
}
        

// @LINE:51
case controllers_Lectures_deleteLecture30(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.Lectures.deleteLecture(aid), HandlerDef(this, "controllers.Lectures", "deleteLecture", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/lecture/$aid<[^/]+>/delete"""))
   }
}
        

// @LINE:52
case controllers_Lectures_lecturePage31(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.Lectures.lecturePage(aid), HandlerDef(this, "controllers.Lectures", "lecturePage", Seq(classOf[Long]),"GET", """""", Routes.prefix + """course/lectures/$aid<[^/]+>"""))
   }
}
        

// @LINE:53
case controllers_Lectures_getLecture32(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Lectures.getLecture(id), HandlerDef(this, "controllers.Lectures", "getLecture", Seq(classOf[Long]),"GET", """""", Routes.prefix + """course/lecture/$id<[^/]+>"""))
   }
}
        

// @LINE:54
case controllers_Lectures_updateLecture33(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.Lectures.updateLecture(aid), HandlerDef(this, "controllers.Lectures", "updateLecture", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/lectures/$aid<[^/]+>"""))
   }
}
        

// @LINE:57
case controllers_CourseInformations_index34(params) => {
   call { 
        invokeHandler(controllers.CourseInformations.index(), HandlerDef(this, "controllers.CourseInformations", "index", Nil,"GET", """CourseInformation""", Routes.prefix + """course/courseInformations"""))
   }
}
        

// @LINE:58
case controllers_CourseInformations_newCourseInformation35(params) => {
   call { 
        invokeHandler(controllers.CourseInformations.newCourseInformation(), HandlerDef(this, "controllers.CourseInformations", "newCourseInformation", Nil,"POST", """""", Routes.prefix + """course/courseInformations"""))
   }
}
        

// @LINE:59
case controllers_CourseInformations_deleteCourseInformation36(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.CourseInformations.deleteCourseInformation(aid), HandlerDef(this, "controllers.CourseInformations", "deleteCourseInformation", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/courseInformation/$aid<[^/]+>/delete"""))
   }
}
        

// @LINE:60
case controllers_CourseInformations_courseInformationPage37(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.CourseInformations.courseInformationPage(aid), HandlerDef(this, "controllers.CourseInformations", "courseInformationPage", Seq(classOf[Long]),"GET", """""", Routes.prefix + """course/courseInformations/$aid<[^/]+>"""))
   }
}
        

// @LINE:61
case controllers_CourseInformations_updateCourseInformation38(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.CourseInformations.updateCourseInformation(aid), HandlerDef(this, "controllers.CourseInformations", "updateCourseInformation", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/courseInformations/$aid<[^/]+>"""))
   }
}
        

// @LINE:62
case controllers_CourseInformations_getCourseInformation39(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.CourseInformations.getCourseInformation(id), HandlerDef(this, "controllers.CourseInformations", "getCourseInformation", Seq(classOf[Long]),"GET", """""", Routes.prefix + """course/courseInformation/$id<[^/]+>"""))
   }
}
        

// @LINE:66
case controllers_CourseDescriptions_index40(params) => {
   call { 
        invokeHandler(controllers.CourseDescriptions.index(), HandlerDef(this, "controllers.CourseDescriptions", "index", Nil,"GET", """CourseDescription""", Routes.prefix + """course/courseDescriptions"""))
   }
}
        

// @LINE:67
case controllers_CourseDescriptions_newCourseDescription41(params) => {
   call { 
        invokeHandler(controllers.CourseDescriptions.newCourseDescription(), HandlerDef(this, "controllers.CourseDescriptions", "newCourseDescription", Nil,"POST", """""", Routes.prefix + """course/courseDescriptions"""))
   }
}
        

// @LINE:68
case controllers_CourseDescriptions_deleteCourseDescription42(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.CourseDescriptions.deleteCourseDescription(aid), HandlerDef(this, "controllers.CourseDescriptions", "deleteCourseDescription", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/courseDescription/$aid<[^/]+>/delete"""))
   }
}
        

// @LINE:69
case controllers_CourseDescriptions_courseDescriptionPage43(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.CourseDescriptions.courseDescriptionPage(aid), HandlerDef(this, "controllers.CourseDescriptions", "courseDescriptionPage", Seq(classOf[Long]),"GET", """""", Routes.prefix + """course/courseDescriptions/$aid<[^/]+>"""))
   }
}
        

// @LINE:70
case controllers_CourseDescriptions_updateCourseDescription44(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.CourseDescriptions.updateCourseDescription(aid), HandlerDef(this, "controllers.CourseDescriptions", "updateCourseDescription", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/courseDescriptions/$aid<[^/]+>"""))
   }
}
        

// @LINE:71
case controllers_CourseDescriptions_getCourseDescription45(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.CourseDescriptions.getCourseDescription(id), HandlerDef(this, "controllers.CourseDescriptions", "getCourseDescription", Seq(classOf[Long]),"GET", """""", Routes.prefix + """course/courseDescription/$id<[^/]+>"""))
   }
}
        

// @LINE:75
case controllers_Students_index46(params) => {
   call { 
        invokeHandler(controllers.Students.index(), HandlerDef(this, "controllers.Students", "index", Nil,"GET", """""", Routes.prefix + """student"""))
   }
}
        

// @LINE:78
case controllers_Users_upload47(params) => {
   call { 
        invokeHandler(controllers.Users.upload(), HandlerDef(this, "controllers.Users", "upload", Nil,"GET", """Users""", Routes.prefix + """user/upload"""))
   }
}
        

// @LINE:79
case controllers_Users_profile48(params) => {
   call { 
        invokeHandler(controllers.Users.profile(), HandlerDef(this, "controllers.Users", "profile", Nil,"POST", """""", Routes.prefix + """user/profile"""))
   }
}
        

// @LINE:80
case controllers_Users_pro49(params) => {
   call { 
        invokeHandler(controllers.Users.pro(), HandlerDef(this, "controllers.Users", "pro", Nil,"GET", """""", Routes.prefix + """user/profile"""))
   }
}
        

// @LINE:82
case controllers_Users_editUser50(params) => {
   call { 
        invokeHandler(controllers.Users.editUser(), HandlerDef(this, "controllers.Users", "editUser", Nil,"POST", """""", Routes.prefix + """user/editUser"""))
   }
}
        

// @LINE:83
case controllers_Users_changePassword51(params) => {
   call { 
        invokeHandler(controllers.Users.changePassword(), HandlerDef(this, "controllers.Users", "changePassword", Nil,"POST", """""", Routes.prefix + """user/changePassword"""))
   }
}
        

// @LINE:89
case controllers_Assets_at52(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        