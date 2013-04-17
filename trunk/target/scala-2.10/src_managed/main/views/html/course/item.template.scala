
package views.html.course

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Course,Form[Course],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(course: Course,courseForm:Form[Course],user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.52*/("""

"""),_display_(Seq[Any](/*4.2*/main(user)/*4.12*/{_display_(Seq[Any](format.raw/*4.13*/("""
<h2>Edit course</h2>
"""),_display_(Seq[Any](/*6.2*/form(routes.Courses.updateCourse(course.id))/*6.46*/{_display_(Seq[Any](format.raw/*6.47*/("""
<p>
<input type="text" name="name" placeholder="Name" value=""""),_display_(Seq[Any](/*8.59*/course/*8.65*/.name)),format.raw/*8.70*/("""">
</p>
<p>
<textarea rows="10" cols="30" name="description" placeholder="Description" >"""),_display_(Seq[Any](/*11.78*/course/*11.84*/.description)),format.raw/*11.96*/("""</textarea>
</p>
<p>
<button type="submit">Update</button><a href=""""),_display_(Seq[Any](/*14.48*/routes/*14.54*/.Courses.index)),format.raw/*14.68*/("""">Cancel</button>
</p>
""")))})),format.raw/*16.2*/("""
""")))})))}
    }
    
    def render(course:Course,courseForm:Form[Course],user:User): play.api.templates.Html = apply(course,courseForm,user)
    
    def f:((Course,Form[Course],User) => play.api.templates.Html) = (course,courseForm,user) => apply(course,courseForm,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 17 19:12:25 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/course/item.scala.html
                    HASH: 2e066e31831867be39e3a0982679dfba49b4fc95
                    MATRIX: 747->1|891->51|930->74|948->84|986->85|1045->110|1097->154|1135->155|1235->220|1249->226|1275->231|1403->323|1418->329|1452->341|1559->412|1574->418|1610->432|1667->458
                    LINES: 26->1|30->1|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|36->8|39->11|39->11|39->11|42->14|42->14|42->14|44->16
                    -- GENERATED --
                */
            