
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[Course],Form[Course],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courses:List[Course],courseForm:Form[Course],user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.58*/("""



"""),_display_(Seq[Any](/*6.2*/main(user)/*6.12*/{_display_(Seq[Any](format.raw/*6.13*/("""
<table class="table table-bordered">
<th>Course name</th>
<th>Description</th>
<th></th>
"""),_display_(Seq[Any](/*11.2*/for(course<-courses) yield /*11.22*/{_display_(Seq[Any](format.raw/*11.23*/("""
<tr>
"""),_display_(Seq[Any](/*13.2*/form(routes.Courses.deleteCourse(course.id))/*13.46*/{_display_(Seq[Any](format.raw/*13.47*/("""
<td><a href=""""),_display_(Seq[Any](/*14.15*/routes/*14.21*/.Courses.coursePage(course.id))),format.raw/*14.51*/("""">"""),_display_(Seq[Any](/*14.54*/course/*14.60*/.name)),format.raw/*14.65*/("""</a></td>
<td>
<div class="description">
"""),_display_(Seq[Any](/*17.2*/if(course.description!=null)/*17.30*/{_display_(Seq[Any](format.raw/*17.31*/("""
"""),_display_(Seq[Any](/*18.2*/Html(course.description))),format.raw/*18.26*/("""
""")))})),format.raw/*19.2*/("""
</div>
</td>
<td><button type="submit">Delete</button></td>
""")))})),format.raw/*23.2*/("""
</tr>
""")))})),format.raw/*25.2*/("""
</table>

<h2>Add a new course</h2>
"""),_display_(Seq[Any](/*29.2*/form(routes.Courses.newCourse())/*29.34*/{_display_(Seq[Any](format.raw/*29.35*/("""
<p>
<input type="text" name="name" placeholder="Name">
</p>
<p>
<textarea rows="10" cols="30" class="ckeditor" name="description" placeholder="Description"></textarea>
</p>
<p>
<button type="submit">Create</button>
</p>
""")))})),format.raw/*39.2*/("""

""")))})))}
    }
    
    def render(courses:List[Course],courseForm:Form[Course],user:User): play.api.templates.Html = apply(courses,courseForm,user)
    
    def f:((List[Course],Form[Course],User) => play.api.templates.Html) = (courses,courseForm,user) => apply(courses,courseForm,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 17 19:12:25 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/course/index.scala.html
                    HASH: 9248a3000bcfaf048bf250c6836e89edeab3abb8
                    MATRIX: 754->1|904->57|947->84|965->94|1003->95|1134->191|1170->211|1209->212|1253->221|1306->265|1345->266|1397->282|1412->288|1464->318|1503->321|1518->327|1545->332|1625->377|1662->405|1701->406|1739->409|1785->433|1819->436|1916->502|1957->512|2034->554|2075->586|2114->587|2377->819
                    LINES: 26->1|30->1|34->6|34->6|34->6|39->11|39->11|39->11|41->13|41->13|41->13|42->14|42->14|42->14|42->14|42->14|42->14|45->17|45->17|45->17|46->18|46->18|47->19|51->23|53->25|57->29|57->29|57->29|67->39
                    -- GENERATED --
                */
            