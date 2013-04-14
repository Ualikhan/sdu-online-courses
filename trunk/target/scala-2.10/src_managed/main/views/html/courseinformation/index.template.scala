
package views.html.courseinformation

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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,List[CourseInformation],Form[CourseInformation],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courseId: Long , courseInformations: List[CourseInformation] , courseInformationForm: Form[CourseInformation]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.113*/("""
"""),format.raw/*3.1*/("""
<table>
<th>CourseInformation name</th>
<th>Description</th>
<th></th>
"""),_display_(Seq[Any](/*8.2*/if(courseInformations!=null)/*8.30*/{_display_(Seq[Any](format.raw/*8.31*/("""
"""),_display_(Seq[Any](/*9.2*/for(courseInformation<-courseInformations) yield /*9.44*/{_display_(Seq[Any](format.raw/*9.45*/("""
<tr>
"""),_display_(Seq[Any](/*11.2*/form(routes.CourseInformations.deleteCourseInformation(courseInformation.id))/*11.79*/{_display_(Seq[Any](format.raw/*11.80*/("""
<td><a href=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.CourseInformations.courseInformationPage(courseInformation.id))),format.raw/*12.84*/("""">"""),_display_(Seq[Any](/*12.87*/courseInformation/*12.104*/.title)),format.raw/*12.110*/("""</a></td>
<td>"""),_display_(Seq[Any](/*13.6*/courseInformation/*13.23*/.content)),format.raw/*13.31*/("""</td>
<td><button type="submit">Delete</button></td>
""")))})),format.raw/*15.2*/("""
</tr>
""")))})),format.raw/*17.2*/("""
""")))})),format.raw/*18.2*/("""
</table>

<h2>Add a new courseInformation</h2>
"""),_display_(Seq[Any](/*22.2*/form(routes.CourseInformations.newCourseInformation())/*22.56*/{_display_(Seq[Any](format.raw/*22.57*/("""
<p>
<input type="text" name="title" placeholder="Name">
</p>
<p>
<textarea rows="10" cols="30" name="content" placeholder="Description"></textarea>
</p>
<p>
<button type="submit">Create</button>
</p>
""")))})))}
    }
    
    def render(courseId:Long,courseInformations:List[CourseInformation],courseInformationForm:Form[CourseInformation]): play.api.templates.Html = apply(courseId,courseInformations,courseInformationForm)
    
    def f:((Long,List[CourseInformation],Form[CourseInformation]) => play.api.templates.Html) = (courseId,courseInformations,courseInformationForm) => apply(courseId,courseInformations,courseInformationForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 00:24:08 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/courseinformation/index.scala.html
                    HASH: bf028781dcd220522a7d5ba831dadec5b1ae073c
                    MATRIX: 787->1|993->112|1021->132|1133->210|1169->238|1207->239|1244->242|1301->284|1339->285|1383->294|1469->371|1508->372|1560->388|1575->394|1660->457|1699->460|1726->477|1755->483|1806->499|1832->516|1862->524|1949->580|1990->590|2024->593|2112->646|2175->700|2214->701
                    LINES: 26->1|30->1|31->3|36->8|36->8|36->8|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|41->13|41->13|41->13|43->15|45->17|46->18|50->22|50->22|50->22
                    -- GENERATED --
                */
            