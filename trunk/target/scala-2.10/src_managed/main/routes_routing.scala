// @SOURCE:D:/Programming/Eclipse Projects/sdu-online-courses/conf/routes
// @HASH:be6d59cc254c0ab3128844fe889e21d9ebdbc5be
// @DATE:Mon Apr 15 00:31:29 ALMT 2013


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
        

// @LINE:37
private[this] lazy val controllers_Lectures_index20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lectures"))))
        

// @LINE:39
private[this] lazy val controllers_Lectures_newLecture21 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lectures"))))
        

// @LINE:40
private[this] lazy val controllers_Lectures_deleteLecture22 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lecture/"),DynamicPart("aid", """[^/]+"""),StaticPart("/delete"))))
        

// @LINE:41
private[this] lazy val controllers_Lectures_lecturePage23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lectures/"),DynamicPart("aid", """[^/]+"""))))
        

// @LINE:42
private[this] lazy val controllers_Lectures_getLecture24 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lecture/"),DynamicPart("id", """[^/]+"""))))
        

// @LINE:43
private[this] lazy val controllers_Lectures_updateLecture25 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/lectures/"),DynamicPart("aid", """[^/]+"""))))
        

// @LINE:46
private[this] lazy val controllers_CourseInformations_index26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseInformations"))))
        

// @LINE:47
private[this] lazy val controllers_CourseInformations_newCourseInformation27 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseInformations"))))
        

// @LINE:48
private[this] lazy val controllers_CourseInformations_deleteCourseInformation28 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseInformation/"),DynamicPart("aid", """[^/]+"""),StaticPart("/delete"))))
        

// @LINE:49
private[this] lazy val controllers_CourseInformations_courseInformationPage29 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseInformations/"),DynamicPart("aid", """[^/]+"""))))
        

// @LINE:50
private[this] lazy val controllers_CourseInformations_updateCourseInformation30 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseInformations/"),DynamicPart("aid", """[^/]+"""))))
        

// @LINE:51
private[this] lazy val controllers_CourseInformations_getCourseInformation31 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("course/courseInformation/"),DynamicPart("id", """[^/]+"""))))
        

// @LINE:55
private[this] lazy val controllers_Students_index32 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student"))))
        

// @LINE:58
private[this] lazy val controllers_Users_upload33 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/upload"))))
        

// @LINE:59
private[this] lazy val controllers_Users_profile34 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/profile"))))
        

// @LINE:60
private[this] lazy val controllers_Users_pro35 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/profile"))))
        

// @LINE:62
private[this] lazy val controllers_Users_editUser36 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/editUser"))))
        

// @LINE:63
private[this] lazy val controllers_Users_changePassword37 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/changePassword"))))
        

// @LINE:69
private[this] lazy val controllers_Assets_at38 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+"""))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Application.registerForm()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Application.register()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """list""","""controllers.Application.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """javascriptRoutes""","""controllers.Application.javascriptRoutes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """courses""","""controllers.Courses.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """courses""","""controllers.Courses.newCourse()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """courses/$id<[^/]+>/delete""","""controllers.Courses.deleteCourse(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """courses/$id<[^/]+>""","""controllers.Courses.updateCourse(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """courses/$id<[^/]+>""","""controllers.Courses.coursePage(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """courses/$id<[^/]+>/description""","""controllers.Courses.courseDescription(id:Long)"""),("""POST""", prefix,"""controllers.Courses.join(course:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/announcements""","""controllers.Announcements.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/announcements""","""controllers.Announcements.newAnnouncement()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/announcement/$aid<[^/]+>/delete""","""controllers.Announcements.deleteAnnouncement(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/announcements/$aid<[^/]+>""","""controllers.Announcements.announcementPage(aid:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/announcements/$aid<[^/]+>""","""controllers.Announcements.updateAnnouncement(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lectures""","""controllers.Lectures.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lectures""","""controllers.Lectures.newLecture()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lecture/$aid<[^/]+>/delete""","""controllers.Lectures.deleteLecture(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lectures/$aid<[^/]+>""","""controllers.Lectures.lecturePage(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lecture/$id<[^/]+>""","""controllers.Lectures.getLecture(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/lectures/$aid<[^/]+>""","""controllers.Lectures.updateLecture(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseInformations""","""controllers.CourseInformations.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseInformations""","""controllers.CourseInformations.newCourseInformation()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseInformation/$aid<[^/]+>/delete""","""controllers.CourseInformations.deleteCourseInformation(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseInformations/$aid<[^/]+>""","""controllers.CourseInformations.courseInformationPage(aid:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseInformations/$aid<[^/]+>""","""controllers.CourseInformations.updateCourseInformation(aid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """course/courseInformation/$id<[^/]+>""","""controllers.CourseInformations.getCourseInformation(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student""","""controllers.Students.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/upload""","""controllers.Users.upload()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/profile""","""controllers.Users.profile()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/profile""","""controllers.Users.pro()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/editUser""","""controllers.Users.editUser()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/changePassword""","""controllers.Users.changePassword()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e match {
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
        

// @LINE:37
case controllers_Lectures_index20(params) => {
   call { 
        invokeHandler(controllers.Lectures.index(), HandlerDef(this, "controllers.Lectures", "index", Nil,"GET", """Lectures""", Routes.prefix + """course/lectures"""))
   }
}
        

// @LINE:39
case controllers_Lectures_newLecture21(params) => {
   call { 
        invokeHandler(controllers.Lectures.newLecture(), HandlerDef(this, "controllers.Lectures", "newLecture", Nil,"POST", """""", Routes.prefix + """course/lectures"""))
   }
}
        

// @LINE:40
case controllers_Lectures_deleteLecture22(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.Lectures.deleteLecture(aid), HandlerDef(this, "controllers.Lectures", "deleteLecture", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/lecture/$aid<[^/]+>/delete"""))
   }
}
        

// @LINE:41
case controllers_Lectures_lecturePage23(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.Lectures.lecturePage(aid), HandlerDef(this, "controllers.Lectures", "lecturePage", Seq(classOf[Long]),"GET", """""", Routes.prefix + """course/lectures/$aid<[^/]+>"""))
   }
}
        

// @LINE:42
case controllers_Lectures_getLecture24(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Lectures.getLecture(id), HandlerDef(this, "controllers.Lectures", "getLecture", Seq(classOf[Long]),"GET", """""", Routes.prefix + """course/lecture/$id<[^/]+>"""))
   }
}
        

// @LINE:43
case controllers_Lectures_updateLecture25(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.Lectures.updateLecture(aid), HandlerDef(this, "controllers.Lectures", "updateLecture", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/lectures/$aid<[^/]+>"""))
   }
}
        

// @LINE:46
case controllers_CourseInformations_index26(params) => {
   call { 
        invokeHandler(controllers.CourseInformations.index(), HandlerDef(this, "controllers.CourseInformations", "index", Nil,"GET", """CourseInformation""", Routes.prefix + """course/courseInformations"""))
   }
}
        

// @LINE:47
case controllers_CourseInformations_newCourseInformation27(params) => {
   call { 
        invokeHandler(controllers.CourseInformations.newCourseInformation(), HandlerDef(this, "controllers.CourseInformations", "newCourseInformation", Nil,"POST", """""", Routes.prefix + """course/courseInformations"""))
   }
}
        

// @LINE:48
case controllers_CourseInformations_deleteCourseInformation28(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.CourseInformations.deleteCourseInformation(aid), HandlerDef(this, "controllers.CourseInformations", "deleteCourseInformation", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/courseInformation/$aid<[^/]+>/delete"""))
   }
}
        

// @LINE:49
case controllers_CourseInformations_courseInformationPage29(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.CourseInformations.courseInformationPage(aid), HandlerDef(this, "controllers.CourseInformations", "courseInformationPage", Seq(classOf[Long]),"GET", """""", Routes.prefix + """course/courseInformations/$aid<[^/]+>"""))
   }
}
        

// @LINE:50
case controllers_CourseInformations_updateCourseInformation30(params) => {
   call(params.fromPath[Long]("aid", None)) { (aid) =>
        invokeHandler(controllers.CourseInformations.updateCourseInformation(aid), HandlerDef(this, "controllers.CourseInformations", "updateCourseInformation", Seq(classOf[Long]),"POST", """""", Routes.prefix + """course/courseInformations/$aid<[^/]+>"""))
   }
}
        

// @LINE:51
case controllers_CourseInformations_getCourseInformation31(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.CourseInformations.getCourseInformation(id), HandlerDef(this, "controllers.CourseInformations", "getCourseInformation", Seq(classOf[Long]),"GET", """""", Routes.prefix + """course/courseInformation/$id<[^/]+>"""))
   }
}
        

// @LINE:55
case controllers_Students_index32(params) => {
   call { 
        invokeHandler(controllers.Students.index(), HandlerDef(this, "controllers.Students", "index", Nil,"GET", """""", Routes.prefix + """student"""))
   }
}
        

// @LINE:58
case controllers_Users_upload33(params) => {
   call { 
        invokeHandler(controllers.Users.upload(), HandlerDef(this, "controllers.Users", "upload", Nil,"GET", """Users""", Routes.prefix + """user/upload"""))
   }
}
        

// @LINE:59
case controllers_Users_profile34(params) => {
   call { 
        invokeHandler(controllers.Users.profile(), HandlerDef(this, "controllers.Users", "profile", Nil,"POST", """""", Routes.prefix + """user/profile"""))
   }
}
        

// @LINE:60
case controllers_Users_pro35(params) => {
   call { 
        invokeHandler(controllers.Users.pro(), HandlerDef(this, "controllers.Users", "pro", Nil,"GET", """""", Routes.prefix + """user/profile"""))
   }
}
        

// @LINE:62
case controllers_Users_editUser36(params) => {
   call { 
        invokeHandler(controllers.Users.editUser(), HandlerDef(this, "controllers.Users", "editUser", Nil,"POST", """""", Routes.prefix + """user/editUser"""))
   }
}
        

// @LINE:63
case controllers_Users_changePassword37(params) => {
   call { 
        invokeHandler(controllers.Users.changePassword(), HandlerDef(this, "controllers.Users", "changePassword", Nil,"POST", """""", Routes.prefix + """user/changePassword"""))
   }
}
        

// @LINE:69
case controllers_Assets_at38(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        