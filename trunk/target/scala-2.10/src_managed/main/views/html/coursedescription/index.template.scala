
package views.html.coursedescription

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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Long,List[CourseDescription],Form[CourseDescription],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courseId: Long , courseDescriptions: List[CourseDescription] , courseDescriptionForm: Form[CourseDescription],user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.123*/("""
"""),_display_(Seq[Any](/*3.2*/main(user)/*3.12*/{_display_(Seq[Any](format.raw/*3.13*/("""
<table class="table table-bordered">
<th>CourseDescription name</th>
<th>Description</th>
<th></th>
"""),_display_(Seq[Any](/*8.2*/if(courseDescriptions!=null)/*8.30*/{_display_(Seq[Any](format.raw/*8.31*/("""
"""),_display_(Seq[Any](/*9.2*/for(courseDescription<-courseDescriptions) yield /*9.44*/{_display_(Seq[Any](format.raw/*9.45*/("""
<tr>
"""),_display_(Seq[Any](/*11.2*/form(routes.CourseDescriptions.deleteCourseDescription(courseDescription.id))/*11.79*/{_display_(Seq[Any](format.raw/*11.80*/("""
<td><a href=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.CourseDescriptions.courseDescriptionPage(courseDescription.id))),format.raw/*12.84*/("""">"""),_display_(Seq[Any](/*12.87*/courseDescription/*12.104*/.title)),format.raw/*12.110*/("""</a></td>
<td>
<div class="description">
"""),_display_(Seq[Any](/*15.2*/if(courseDescription.content!=null)/*15.37*/{_display_(Seq[Any](format.raw/*15.38*/("""
"""),_display_(Seq[Any](/*16.2*/Html(courseDescription.content))),format.raw/*16.33*/("""
""")))})),format.raw/*17.2*/("""
</div>
</td>
<td><button type="submit">Delete</button></td>
""")))})),format.raw/*21.2*/("""
</tr>
""")))})),format.raw/*23.2*/("""
""")))})),format.raw/*24.2*/("""
</table>

<h2>Add a new courseDescription</h2>
"""),_display_(Seq[Any](/*28.2*/form(routes.CourseDescriptions.newCourseDescription())/*28.56*/{_display_(Seq[Any](format.raw/*28.57*/("""
<p>
<input type="text" name="title" placeholder="Name">
</p>
<p>
<textarea class="descriptionTextArea ckeditor" rows="30" cols="60" name="content" placeholder="Description"></textarea>
</p>
<p>
<button type="submit">Create</button>
</p>
""")))})),format.raw/*38.2*/("""
""")))})),format.raw/*39.2*/("""
"""))}
    }
    
    def render(courseId:Long,courseDescriptions:List[CourseDescription],courseDescriptionForm:Form[CourseDescription],user:User): play.api.templates.Html = apply(courseId,courseDescriptions,courseDescriptionForm,user)
    
    def f:((Long,List[CourseDescription],Form[CourseDescription],User) => play.api.templates.Html) = (courseId,courseDescriptions,courseDescriptionForm,user) => apply(courseId,courseDescriptions,courseDescriptionForm,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Apr 19 11:38:52 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/coursedescription/index.scala.html
                    HASH: a9dc97b5e607908cdb35fc43aaf86997695a62af
                    MATRIX: 792->1|1008->122|1045->143|1063->153|1101->154|1242->261|1278->289|1316->290|1353->293|1410->335|1448->336|1492->345|1578->422|1617->423|1669->439|1684->445|1769->508|1808->511|1835->528|1864->534|1944->579|1988->614|2027->615|2065->618|2118->649|2152->652|2249->718|2290->728|2324->731|2412->784|2475->838|2514->839|2794->1088|2828->1091
                    LINES: 26->1|30->1|31->3|31->3|31->3|36->8|36->8|36->8|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|43->15|43->15|43->15|44->16|44->16|45->17|49->21|51->23|52->24|56->28|56->28|56->28|66->38|67->39
                    -- GENERATED --
                */
            