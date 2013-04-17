// @SOURCE:D:/sdu-online-courses/conf/routes
// @HASH:be6d59cc254c0ab3128844fe889e21d9ebdbc5be
// @DATE:Wed Apr 17 19:12:23 ALMT 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:69
// @LINE:63
// @LINE:62
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:55
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:37
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:69
class ReverseAssets {
    

// @LINE:69
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:63
// @LINE:62
// @LINE:60
// @LINE:59
// @LINE:58
class ReverseUsers {
    

// @LINE:62
def editUser(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/editUser")
}
                                                

// @LINE:63
def changePassword(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/changePassword")
}
                                                

// @LINE:59
def profile(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/profile")
}
                                                

// @LINE:58
def upload(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/upload")
}
                                                

// @LINE:60
def pro(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/profile")
}
                                                
    
}
                          

// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
class ReverseCourseInformations {
    

// @LINE:48
def deleteCourseInformation(aid:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "course/courseInformation/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/delete")
}
                                                

// @LINE:50
def updateCourseInformation(aid:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "course/courseInformations/" + implicitly[PathBindable[Long]].unbind("aid", aid))
}
                                                

// @LINE:51
def getCourseInformation(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "course/courseInformation/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:47
def newCourseInformation(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "course/courseInformations")
}
                                                

// @LINE:46
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "course/courseInformations")
}
                                                

// @LINE:49
def courseInformationPage(aid:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "course/courseInformations/" + implicitly[PathBindable[Long]].unbind("aid", aid))
}
                                                
    
}
                          

// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:37
class ReverseLectures {
    

// @LINE:43
def updateLecture(aid:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "course/lectures/" + implicitly[PathBindable[Long]].unbind("aid", aid))
}
                                                

// @LINE:40
def deleteLecture(aid:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "course/lecture/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/delete")
}
                                                

// @LINE:39
def newLecture(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "course/lectures")
}
                                                

// @LINE:37
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "course/lectures")
}
                                                

// @LINE:41
def lecturePage(aid:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "course/lectures/" + implicitly[PathBindable[Long]].unbind("aid", aid))
}
                                                

// @LINE:42
def getLecture(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "course/lecture/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                
    
}
                          

// @LINE:55
class ReverseStudents {
    

// @LINE:55
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student")
}
                                                
    
}
                          

// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
class ReverseAnnouncements {
    

// @LINE:31
def deleteAnnouncement(aid:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "course/announcement/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/delete")
}
                                                

// @LINE:33
def updateAnnouncement(aid:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "course/announcements/" + implicitly[PathBindable[Long]].unbind("aid", aid))
}
                                                

// @LINE:32
def announcementPage(aid:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "course/announcements/" + implicitly[PathBindable[Long]].unbind("aid", aid))
}
                                                

// @LINE:30
def newAnnouncement(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "course/announcements")
}
                                                

// @LINE:29
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "course/announcements")
}
                                                
    
}
                          

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseCourses {
    

// @LINE:24
def coursePage(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "courses/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:23
def updateCourse(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "courses/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:25
def courseDescription(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "courses/" + implicitly[PathBindable[Long]].unbind("id", id) + "/description")
}
                                                

// @LINE:26
def join(course:Long): Call = {
   Call("POST", _prefix + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("course", course)))))
}
                                                

// @LINE:21
def deleteCourse(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "courses/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                                                

// @LINE:19
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "courses")
}
                                                

// @LINE:20
def newCourse(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "courses")
}
                                                
    
}
                          

// @LINE:16
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:16
def javascriptRoutes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "javascriptRoutes")
}
                                                

// @LINE:9
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:11
def register(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "register")
}
                                                

// @LINE:12
def list(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "list")
}
                                                

// @LINE:10
def registerForm(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "register")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:8
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          
}
                  


// @LINE:69
// @LINE:63
// @LINE:62
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:55
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:37
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:69
class ReverseAssets {
    

// @LINE:69
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:63
// @LINE:62
// @LINE:60
// @LINE:59
// @LINE:58
class ReverseUsers {
    

// @LINE:62
def editUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.editUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/editUser"})
      }
   """
)
                        

// @LINE:63
def changePassword : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.changePassword",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/changePassword"})
      }
   """
)
                        

// @LINE:59
def profile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.profile",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/profile"})
      }
   """
)
                        

// @LINE:58
def upload : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.upload",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/upload"})
      }
   """
)
                        

// @LINE:60
def pro : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.pro",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/profile"})
      }
   """
)
                        
    
}
              

// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
class ReverseCourseInformations {
    

// @LINE:48
def deleteCourseInformation : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CourseInformations.deleteCourseInformation",
   """
      function(aid) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "course/courseInformation/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid) + "/delete"})
      }
   """
)
                        

// @LINE:50
def updateCourseInformation : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CourseInformations.updateCourseInformation",
   """
      function(aid) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "course/courseInformations/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid)})
      }
   """
)
                        

// @LINE:51
def getCourseInformation : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CourseInformations.getCourseInformation",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "course/courseInformation/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:47
def newCourseInformation : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CourseInformations.newCourseInformation",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "course/courseInformations"})
      }
   """
)
                        

// @LINE:46
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CourseInformations.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "course/courseInformations"})
      }
   """
)
                        

// @LINE:49
def courseInformationPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CourseInformations.courseInformationPage",
   """
      function(aid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "course/courseInformations/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid)})
      }
   """
)
                        
    
}
              

// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:37
class ReverseLectures {
    

// @LINE:43
def updateLecture : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lectures.updateLecture",
   """
      function(aid) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "course/lectures/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid)})
      }
   """
)
                        

// @LINE:40
def deleteLecture : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lectures.deleteLecture",
   """
      function(aid) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "course/lecture/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid) + "/delete"})
      }
   """
)
                        

// @LINE:39
def newLecture : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lectures.newLecture",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "course/lectures"})
      }
   """
)
                        

// @LINE:37
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lectures.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "course/lectures"})
      }
   """
)
                        

// @LINE:41
def lecturePage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lectures.lecturePage",
   """
      function(aid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "course/lectures/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid)})
      }
   """
)
                        

// @LINE:42
def getLecture : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lectures.getLecture",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "course/lecture/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        
    
}
              

// @LINE:55
class ReverseStudents {
    

// @LINE:55
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Students.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student"})
      }
   """
)
                        
    
}
              

// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
class ReverseAnnouncements {
    

// @LINE:31
def deleteAnnouncement : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Announcements.deleteAnnouncement",
   """
      function(aid) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "course/announcement/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid) + "/delete"})
      }
   """
)
                        

// @LINE:33
def updateAnnouncement : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Announcements.updateAnnouncement",
   """
      function(aid) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "course/announcements/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid)})
      }
   """
)
                        

// @LINE:32
def announcementPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Announcements.announcementPage",
   """
      function(aid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "course/announcements/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid)})
      }
   """
)
                        

// @LINE:30
def newAnnouncement : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Announcements.newAnnouncement",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "course/announcements"})
      }
   """
)
                        

// @LINE:29
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Announcements.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "course/announcements"})
      }
   """
)
                        
    
}
              

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseCourses {
    

// @LINE:24
def coursePage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Courses.coursePage",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "courses/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:23
def updateCourse : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Courses.updateCourse",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "courses/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:25
def courseDescription : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Courses.courseDescription",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "courses/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/description"})
      }
   """
)
                        

// @LINE:26
def join : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Courses.join",
   """
      function(course) {
      return _wA({method:"POST", url:"""" + _prefix + """" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("course", course)])})
      }
   """
)
                        

// @LINE:21
def deleteCourse : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Courses.deleteCourse",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "courses/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                        

// @LINE:19
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Courses.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "courses"})
      }
   """
)
                        

// @LINE:20
def newCourse : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Courses.newCourse",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "courses"})
      }
   """
)
                        
    
}
              

// @LINE:16
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:16
def javascriptRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.javascriptRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "javascriptRoutes"})
      }
   """
)
                        

// @LINE:9
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:11
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.register",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
      }
   """
)
                        

// @LINE:12
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "list"})
      }
   """
)
                        

// @LINE:10
def registerForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.registerForm",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:8
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:69
// @LINE:63
// @LINE:62
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:55
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:37
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:69
class ReverseAssets {
    

// @LINE:69
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:63
// @LINE:62
// @LINE:60
// @LINE:59
// @LINE:58
class ReverseUsers {
    

// @LINE:62
def editUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.editUser(), HandlerDef(this, "controllers.Users", "editUser", Seq(), "POST", """""", _prefix + """user/editUser""")
)
                      

// @LINE:63
def changePassword(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.changePassword(), HandlerDef(this, "controllers.Users", "changePassword", Seq(), "POST", """""", _prefix + """user/changePassword""")
)
                      

// @LINE:59
def profile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.profile(), HandlerDef(this, "controllers.Users", "profile", Seq(), "POST", """""", _prefix + """user/profile""")
)
                      

// @LINE:58
def upload(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.upload(), HandlerDef(this, "controllers.Users", "upload", Seq(), "GET", """Users""", _prefix + """user/upload""")
)
                      

// @LINE:60
def pro(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.pro(), HandlerDef(this, "controllers.Users", "pro", Seq(), "GET", """""", _prefix + """user/profile""")
)
                      
    
}
                          

// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
class ReverseCourseInformations {
    

// @LINE:48
def deleteCourseInformation(aid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CourseInformations.deleteCourseInformation(aid), HandlerDef(this, "controllers.CourseInformations", "deleteCourseInformation", Seq(classOf[Long]), "POST", """""", _prefix + """course/courseInformation/$aid<[^/]+>/delete""")
)
                      

// @LINE:50
def updateCourseInformation(aid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CourseInformations.updateCourseInformation(aid), HandlerDef(this, "controllers.CourseInformations", "updateCourseInformation", Seq(classOf[Long]), "POST", """""", _prefix + """course/courseInformations/$aid<[^/]+>""")
)
                      

// @LINE:51
def getCourseInformation(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CourseInformations.getCourseInformation(id), HandlerDef(this, "controllers.CourseInformations", "getCourseInformation", Seq(classOf[Long]), "GET", """""", _prefix + """course/courseInformation/$id<[^/]+>""")
)
                      

// @LINE:47
def newCourseInformation(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CourseInformations.newCourseInformation(), HandlerDef(this, "controllers.CourseInformations", "newCourseInformation", Seq(), "POST", """""", _prefix + """course/courseInformations""")
)
                      

// @LINE:46
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CourseInformations.index(), HandlerDef(this, "controllers.CourseInformations", "index", Seq(), "GET", """CourseInformation""", _prefix + """course/courseInformations""")
)
                      

// @LINE:49
def courseInformationPage(aid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CourseInformations.courseInformationPage(aid), HandlerDef(this, "controllers.CourseInformations", "courseInformationPage", Seq(classOf[Long]), "GET", """""", _prefix + """course/courseInformations/$aid<[^/]+>""")
)
                      
    
}
                          

// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:37
class ReverseLectures {
    

// @LINE:43
def updateLecture(aid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lectures.updateLecture(aid), HandlerDef(this, "controllers.Lectures", "updateLecture", Seq(classOf[Long]), "POST", """""", _prefix + """course/lectures/$aid<[^/]+>""")
)
                      

// @LINE:40
def deleteLecture(aid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lectures.deleteLecture(aid), HandlerDef(this, "controllers.Lectures", "deleteLecture", Seq(classOf[Long]), "POST", """""", _prefix + """course/lecture/$aid<[^/]+>/delete""")
)
                      

// @LINE:39
def newLecture(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lectures.newLecture(), HandlerDef(this, "controllers.Lectures", "newLecture", Seq(), "POST", """""", _prefix + """course/lectures""")
)
                      

// @LINE:37
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lectures.index(), HandlerDef(this, "controllers.Lectures", "index", Seq(), "GET", """Lectures""", _prefix + """course/lectures""")
)
                      

// @LINE:41
def lecturePage(aid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lectures.lecturePage(aid), HandlerDef(this, "controllers.Lectures", "lecturePage", Seq(classOf[Long]), "GET", """""", _prefix + """course/lectures/$aid<[^/]+>""")
)
                      

// @LINE:42
def getLecture(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lectures.getLecture(id), HandlerDef(this, "controllers.Lectures", "getLecture", Seq(classOf[Long]), "GET", """""", _prefix + """course/lecture/$id<[^/]+>""")
)
                      
    
}
                          

// @LINE:55
class ReverseStudents {
    

// @LINE:55
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Students.index(), HandlerDef(this, "controllers.Students", "index", Seq(), "GET", """""", _prefix + """student""")
)
                      
    
}
                          

// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
class ReverseAnnouncements {
    

// @LINE:31
def deleteAnnouncement(aid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Announcements.deleteAnnouncement(aid), HandlerDef(this, "controllers.Announcements", "deleteAnnouncement", Seq(classOf[Long]), "POST", """""", _prefix + """course/announcement/$aid<[^/]+>/delete""")
)
                      

// @LINE:33
def updateAnnouncement(aid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Announcements.updateAnnouncement(aid), HandlerDef(this, "controllers.Announcements", "updateAnnouncement", Seq(classOf[Long]), "POST", """""", _prefix + """course/announcements/$aid<[^/]+>""")
)
                      

// @LINE:32
def announcementPage(aid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Announcements.announcementPage(aid), HandlerDef(this, "controllers.Announcements", "announcementPage", Seq(classOf[Long]), "GET", """""", _prefix + """course/announcements/$aid<[^/]+>""")
)
                      

// @LINE:30
def newAnnouncement(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Announcements.newAnnouncement(), HandlerDef(this, "controllers.Announcements", "newAnnouncement", Seq(), "POST", """""", _prefix + """course/announcements""")
)
                      

// @LINE:29
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Announcements.index(), HandlerDef(this, "controllers.Announcements", "index", Seq(), "GET", """Announcements""", _prefix + """course/announcements""")
)
                      
    
}
                          

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseCourses {
    

// @LINE:24
def coursePage(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Courses.coursePage(id), HandlerDef(this, "controllers.Courses", "coursePage", Seq(classOf[Long]), "GET", """""", _prefix + """courses/$id<[^/]+>""")
)
                      

// @LINE:23
def updateCourse(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Courses.updateCourse(id), HandlerDef(this, "controllers.Courses", "updateCourse", Seq(classOf[Long]), "POST", """""", _prefix + """courses/$id<[^/]+>""")
)
                      

// @LINE:25
def courseDescription(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Courses.courseDescription(id), HandlerDef(this, "controllers.Courses", "courseDescription", Seq(classOf[Long]), "GET", """""", _prefix + """courses/$id<[^/]+>/description""")
)
                      

// @LINE:26
def join(course:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Courses.join(course), HandlerDef(this, "controllers.Courses", "join", Seq(classOf[Long]), "POST", """""", _prefix + """""")
)
                      

// @LINE:21
def deleteCourse(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Courses.deleteCourse(id), HandlerDef(this, "controllers.Courses", "deleteCourse", Seq(classOf[Long]), "POST", """""", _prefix + """courses/$id<[^/]+>/delete""")
)
                      

// @LINE:19
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Courses.index(), HandlerDef(this, "controllers.Courses", "index", Seq(), "GET", """Courses""", _prefix + """courses""")
)
                      

// @LINE:20
def newCourse(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Courses.newCourse(), HandlerDef(this, "controllers.Courses", "newCourse", Seq(), "POST", """""", _prefix + """courses""")
)
                      
    
}
                          

// @LINE:16
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      

// @LINE:16
def javascriptRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.javascriptRoutes(), HandlerDef(this, "controllers.Application", "javascriptRoutes", Seq(), "GET", """""", _prefix + """javascriptRoutes""")
)
                      

// @LINE:9
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:11
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.register(), HandlerDef(this, "controllers.Application", "register", Seq(), "POST", """""", _prefix + """register""")
)
                      

// @LINE:12
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.list(), HandlerDef(this, "controllers.Application", "list", Seq(), "GET", """""", _prefix + """list""")
)
                      

// @LINE:10
def registerForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.registerForm(), HandlerDef(this, "controllers.Application", "registerForm", Seq(), "GET", """""", _prefix + """register""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:8
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      
    
}
                          
}
                  
      