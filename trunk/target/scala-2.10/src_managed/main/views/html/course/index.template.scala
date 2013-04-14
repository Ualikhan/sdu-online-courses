
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Course],Form[Course],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courses:List[Course],courseForm:Form[Course]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.48*/("""

"""),format.raw/*4.1*/("""
<table>
<th>Course name</th>
<th>Description</th>
<th></th>
"""),_display_(Seq[Any](/*9.2*/for(course<-courses) yield /*9.22*/{_display_(Seq[Any](format.raw/*9.23*/("""
<tr>
"""),_display_(Seq[Any](/*11.2*/form(routes.Courses.deleteCourse(course.id))/*11.46*/{_display_(Seq[Any](format.raw/*11.47*/("""
<td><a href=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.Courses.coursePage(course.id))),format.raw/*12.51*/("""">"""),_display_(Seq[Any](/*12.54*/course/*12.60*/.name)),format.raw/*12.65*/("""</a></td>
<td>"""),_display_(Seq[Any](/*13.6*/course/*13.12*/.description)),format.raw/*13.24*/("""</td>
<td><button type="submit">Delete</button></td>
""")))})),format.raw/*15.2*/("""
</tr>
""")))})),format.raw/*17.2*/("""
</table>

<h2>Add a new course</h2>
"""),_display_(Seq[Any](/*21.2*/form(routes.Courses.newCourse())/*21.34*/{_display_(Seq[Any](format.raw/*21.35*/("""
<p>
<input type="text" name="name" placeholder="Name">
</p>
<p>
<textarea rows="10" cols="30" name="description" placeholder="Description"></textarea>
</p>
<p>
<button type="submit">Create</button>
</p>
""")))})))}
    }
    
    def render(courses:List[Course],courseForm:Form[Course]): play.api.templates.Html = apply(courses,courseForm)
    
    def f:((List[Course],Form[Course]) => play.api.templates.Html) = (courses,courseForm) => apply(courses,courseForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 00:24:07 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/course/index.scala.html
                    HASH: 42cc8a9bcbca1d7ca4e8cf3c7e54cb3018271a3d
                    MATRIX: 749->1|889->47|919->69|1020->136|1055->156|1093->157|1137->166|1190->210|1229->211|1281->227|1296->233|1348->263|1387->266|1402->272|1429->277|1480->293|1495->299|1529->311|1616->367|1657->377|1734->419|1775->451|1814->452
                    LINES: 26->1|30->1|32->4|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|41->13|41->13|41->13|43->15|45->17|49->21|49->21|49->21
                    -- GENERATED --
                */
            