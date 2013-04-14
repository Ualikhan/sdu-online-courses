
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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Course,Form[Course],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(course: Course,courseForm:Form[Course]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.42*/("""

"""),format.raw/*4.1*/("""
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
""")))})))}
    }
    
    def render(course:Course,courseForm:Form[Course]): play.api.templates.Html = apply(course,courseForm)
    
    def f:((Course,Form[Course]) => play.api.templates.Html) = (course,courseForm) => apply(course,courseForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 00:24:08 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/course/item.scala.html
                    HASH: 42c11471f9661df35a4da808cdaa80b6d2f31449
                    MATRIX: 742->1|876->41|906->63|965->88|1017->132|1055->133|1155->198|1169->204|1195->209|1323->301|1338->307|1372->319|1479->390|1494->396|1530->410
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|36->8|36->8|36->8|39->11|39->11|39->11|42->14|42->14|42->14
                    -- GENERATED --
                */
            