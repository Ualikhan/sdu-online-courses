
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
	<h3>Instructor:</h3>
	<p>
	"""),_display_(Seq[Any](/*8.3*/course/*8.9*/.owner.name)),format.raw/*8.20*/("""
"""),_display_(Seq[Any](/*9.2*/if(course.owner.position!=null && course.owner.position.length()>0)/*9.69*/{_display_(Seq[Any](format.raw/*9.70*/("""
,"""),_display_(Seq[Any](/*10.3*/course/*10.9*/.owner.position)),format.raw/*10.24*/("""
""")))})),format.raw/*11.2*/("""
"""),_display_(Seq[Any](/*12.2*/if(course.owner.company!=null && course.owner.company.length()>0)/*12.67*/{_display_(Seq[Any](format.raw/*12.68*/("""
,"""),_display_(Seq[Any](/*13.3*/course/*13.9*/.owner.company)),format.raw/*13.23*/("""
""")))})),format.raw/*14.2*/("""
	</p>
	
<p>
"""),_display_(Seq[Any](/*18.2*/if(course.description!=null)/*18.30*/{_display_(Seq[Any](format.raw/*18.31*/("""
"""),_display_(Seq[Any](/*19.2*/Html(course.description))),format.raw/*19.26*/("""
""")))})),format.raw/*20.2*/("""
</p>
	"""),_display_(Seq[Any](/*22.3*/if(enrollment.equals("ENROLLED"))/*22.36*/{_display_(Seq[Any](format.raw/*22.37*/("""
		"""),_display_(Seq[Any](/*23.4*/form(routes.Courses.coursePage(course.id))/*23.46*/ {_display_(Seq[Any](format.raw/*23.48*/("""
		<button class="btn btn-primary btn-medium" type="submit">Go to class</button>
		""")))})),format.raw/*25.4*/("""
	""")))}/*26.3*/else/*26.7*/{_display_(Seq[Any](format.raw/*26.8*/("""
	"""),_display_(Seq[Any](/*27.3*/if(enrollment.equals("OWNER"))/*27.33*/{_display_(Seq[Any](format.raw/*27.34*/("""
		"""),_display_(Seq[Any](/*28.4*/form(routes.Courses.coursePage(course.id))/*28.46*/ {_display_(Seq[Any](format.raw/*28.48*/("""
		<button class="btn btn-primary btn-medium" type="submit">Edit course</button>
		""")))})),format.raw/*30.4*/("""
	""")))}/*31.3*/else/*31.7*/{_display_(Seq[Any](format.raw/*31.8*/("""
		"""),_display_(Seq[Any](/*32.4*/form(routes.Courses.join(course.id))/*32.40*/{_display_(Seq[Any](format.raw/*32.41*/("""
		<button class="btn btn-primary btn-medium" type="submit">Sign up</button>
		""")))})),format.raw/*34.4*/("""
	""")))})),format.raw/*35.3*/("""
""")))})),format.raw/*36.2*/("""
 """),_display_(Seq[Any](/*37.3*/courseInformations/*37.21*/.map/*37.25*/ { task =>_display_(Seq[Any](format.raw/*37.35*/("""
<div class="courseInformation">
<h3>"""),_display_(Seq[Any](/*39.6*/task/*39.10*/.title)),format.raw/*39.16*/("""</h3>
"""),_display_(Seq[Any](/*40.2*/if(task.content!=null)/*40.24*/{_display_(Seq[Any](format.raw/*40.25*/("""
"""),_display_(Seq[Any](/*41.2*/Html(task.content))),format.raw/*41.20*/("""
""")))})),format.raw/*42.2*/("""
</div>
""")))})),format.raw/*44.2*/("""
""")))})),format.raw/*45.2*/("""

"""))}
    }
    
    def render(course:Course,courseInformations:List[CourseInformation],enrollment:String,user:User): play.api.templates.Html = apply(course,courseInformations,enrollment,user)
    
    def f:((Course,List[CourseInformation],String,User) => play.api.templates.Html) = (course,courseInformations,enrollment,user) => apply(course,courseInformations,enrollment,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 17 22:13:00 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/course/description.scala.html
                    HASH: f2231482d7ac2a84e365856b94c8644f16eaadc3
                    MATRIX: 772->1|952->87|991->110|1009->120|1047->121|1089->129|1103->135|1129->140|1201->178|1214->184|1246->195|1283->198|1358->265|1396->266|1435->270|1449->276|1486->291|1520->294|1558->297|1632->362|1671->363|1710->367|1724->373|1760->387|1794->390|1847->408|1884->436|1923->437|1961->440|2007->464|2041->467|2086->477|2128->510|2167->511|2207->516|2258->558|2298->560|2415->646|2437->650|2449->654|2487->655|2526->659|2565->689|2604->690|2644->695|2695->737|2735->739|2852->825|2874->829|2886->833|2924->834|2964->839|3009->875|3048->876|3161->958|3196->962|3230->965|3269->969|3296->987|3309->991|3357->1001|3432->1041|3445->1045|3473->1051|3516->1059|3547->1081|3586->1082|3624->1085|3664->1103|3698->1106|3740->1117|3774->1120
                    LINES: 26->1|30->1|32->4|32->4|32->4|33->5|33->5|33->5|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|46->18|46->18|46->18|47->19|47->19|48->20|50->22|50->22|50->22|51->23|51->23|51->23|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|58->30|59->31|59->31|59->31|60->32|60->32|60->32|62->34|63->35|64->36|65->37|65->37|65->37|65->37|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|70->42|72->44|73->45
                    -- GENERATED --
                */
            