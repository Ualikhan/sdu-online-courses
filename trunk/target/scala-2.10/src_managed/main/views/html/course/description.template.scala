
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
object description extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Course,List[CourseInformation],String,User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(course:Course,courseInformations:List[CourseInformation],enrollment:String,user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.88*/("""

"""),_display_(Seq[Any](/*4.2*/main(user)/*4.12*/{_display_(Seq[Any](format.raw/*4.13*/("""
	<h2>"""),_display_(Seq[Any](/*5.7*/course/*5.13*/.name)),format.raw/*5.18*/("""</h2>
	<p>"""),_display_(Seq[Any](/*6.6*/course/*6.12*/.description)),format.raw/*6.24*/("""</p>
	"""),_display_(Seq[Any](/*7.3*/if(enrollment.equals("ENROLLED"))/*7.36*/{_display_(Seq[Any](format.raw/*7.37*/("""
		"""),_display_(Seq[Any](/*8.4*/form(routes.Courses.coursePage(course.id))/*8.46*/ {_display_(Seq[Any](format.raw/*8.48*/("""
		<button class="btn btn-primary btn-medium" type="submit">Go to class</button>
		""")))})),format.raw/*10.4*/("""
	""")))}/*11.3*/else/*11.7*/{_display_(Seq[Any](format.raw/*11.8*/("""
	"""),_display_(Seq[Any](/*12.3*/if(enrollment.equals("OWNER"))/*12.33*/{_display_(Seq[Any](format.raw/*12.34*/("""
		"""),_display_(Seq[Any](/*13.4*/form(routes.Courses.coursePage(course.id))/*13.46*/ {_display_(Seq[Any](format.raw/*13.48*/("""
		<button class="btn btn-primary btn-medium" type="submit">Edit course</button>
		""")))})),format.raw/*15.4*/("""
	""")))}/*16.3*/else/*16.7*/{_display_(Seq[Any](format.raw/*16.8*/("""
		"""),_display_(Seq[Any](/*17.4*/form(routes.Courses.join(course.id))/*17.40*/{_display_(Seq[Any](format.raw/*17.41*/("""
		<button class="btn btn-primary btn-medium" type="submit">Sign up</button>
		""")))})),format.raw/*19.4*/("""
	""")))})),format.raw/*20.3*/("""
""")))})),format.raw/*21.2*/("""
 """),_display_(Seq[Any](/*22.3*/courseInformations/*22.21*/.map/*22.25*/ { task =>_display_(Seq[Any](format.raw/*22.35*/("""
<div class="courseInformation">
<h3>"""),_display_(Seq[Any](/*24.6*/task/*24.10*/.title)),format.raw/*24.16*/("""</h3>
<span>"""),_display_(Seq[Any](/*25.8*/task/*25.12*/.content)),format.raw/*25.20*/("""</span>
</div>
""")))})),format.raw/*27.2*/("""
""")))})))}
    }
    
    def render(course:Course,courseInformations:List[CourseInformation],enrollment:String,user:User): play.api.templates.Html = apply(course,courseInformations,enrollment,user)
    
    def f:((Course,List[CourseInformation],String,User) => play.api.templates.Html) = (course,courseInformations,enrollment,user) => apply(course,courseInformations,enrollment,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 00:41:56 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/course/description.scala.html
                    HASH: 1412a8f262e45f15a906ea22aa394675c2a267da
                    MATRIX: 772->1|952->87|991->110|1009->120|1047->121|1089->129|1103->135|1129->140|1175->152|1189->158|1222->170|1264->178|1305->211|1343->212|1382->217|1432->259|1471->261|1588->347|1610->351|1622->355|1660->356|1699->360|1738->390|1777->391|1817->396|1868->438|1908->440|2025->526|2047->530|2059->534|2097->535|2137->540|2182->576|2221->577|2334->659|2369->663|2403->666|2442->670|2469->688|2482->692|2530->702|2605->742|2618->746|2646->752|2695->766|2708->770|2738->778|2787->796
                    LINES: 26->1|30->1|32->4|32->4|32->4|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|43->15|44->16|44->16|44->16|45->17|45->17|45->17|47->19|48->20|49->21|50->22|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|55->27
                    -- GENERATED --
                */
            