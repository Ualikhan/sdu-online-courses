
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Long,List[CourseInformation],Form[CourseInformation],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courseId: Long , courseInformations: List[CourseInformation] , courseInformationForm: Form[CourseInformation],user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.123*/("""
"""),_display_(Seq[Any](/*3.2*/main(user)/*3.12*/{_display_(Seq[Any](format.raw/*3.13*/("""
<table>
<th>CourseInformation name</th>
<th>Description</th>
<th></th>
"""),_display_(Seq[Any](/*8.2*/if(courseInformations!=null)/*8.30*/{_display_(Seq[Any](format.raw/*8.31*/("""
"""),_display_(Seq[Any](/*9.2*/for(courseInformation<-courseInformations) yield /*9.44*/{_display_(Seq[Any](format.raw/*9.45*/("""
<tr>
"""),_display_(Seq[Any](/*11.2*/form(routes.CourseInformations.deleteCourseInformation(courseInformation.id))/*11.79*/{_display_(Seq[Any](format.raw/*11.80*/("""
<td><a href=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.CourseInformations.courseInformationPage(courseInformation.id))),format.raw/*12.84*/("""">"""),_display_(Seq[Any](/*12.87*/courseInformation/*12.104*/.title)),format.raw/*12.110*/("""</a></td>
<td>
<div class="description" style="width: 60%;max-height: 40px;">
"""),_display_(Seq[Any](/*15.2*/if(courseInformation.content!=null)/*15.37*/{_display_(Seq[Any](format.raw/*15.38*/("""
"""),_display_(Seq[Any](/*16.2*/Html(courseInformation.content))),format.raw/*16.33*/("""
""")))})),format.raw/*17.2*/("""
</div>
</td>
<td><button type="submit">Delete</button></td>
""")))})),format.raw/*21.2*/("""
</tr>
""")))})),format.raw/*23.2*/("""
""")))})),format.raw/*24.2*/("""
</table>

<h2>Add a new courseInformation</h2>
"""),_display_(Seq[Any](/*28.2*/form(routes.CourseInformations.newCourseInformation())/*28.56*/{_display_(Seq[Any](format.raw/*28.57*/("""
<p>
<input type="text" name="title" placeholder="Name">
</p>
<p>
<textarea class="descriptionTextArea" rows="30" cols="60" name="content" placeholder="Description"></textarea>
</p>
<p>
<button type="submit">Create</button>
</p>
""")))})),format.raw/*38.2*/("""
""")))})),format.raw/*39.2*/("""
"""))}
    }
    
    def render(courseId:Long,courseInformations:List[CourseInformation],courseInformationForm:Form[CourseInformation],user:User): play.api.templates.Html = apply(courseId,courseInformations,courseInformationForm,user)
    
    def f:((Long,List[CourseInformation],Form[CourseInformation],User) => play.api.templates.Html) = (courseId,courseInformations,courseInformationForm,user) => apply(courseId,courseInformations,courseInformationForm,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 23:41:16 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/courseinformation/index.scala.html
                    HASH: bf8af19d4ebf8dadc9cfbb64e2029b924945af0b
                    MATRIX: 792->1|1008->122|1045->143|1063->153|1101->154|1213->232|1249->260|1287->261|1324->264|1381->306|1419->307|1463->316|1549->393|1588->394|1640->410|1655->416|1740->479|1779->482|1806->499|1835->505|1952->587|1996->622|2035->623|2073->626|2126->657|2160->660|2257->726|2298->736|2332->739|2420->792|2483->846|2522->847|2793->1087|2827->1090
                    LINES: 26->1|30->1|31->3|31->3|31->3|36->8|36->8|36->8|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|43->15|43->15|43->15|44->16|44->16|45->17|49->21|51->23|52->24|56->28|56->28|56->28|66->38|67->39
                    -- GENERATED --
                */
            