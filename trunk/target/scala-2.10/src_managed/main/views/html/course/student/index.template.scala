
package views.html.course.student

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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[User,Course,List[Announcement],List[CourseInformation],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user:User,course:Course,announcements: List[Announcement],courseInformations: List[CourseInformation]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.105*/("""

"""),_display_(Seq[Any](/*4.2*/main(user)/*4.12*/{_display_(Seq[Any](format.raw/*4.13*/("""
<div class="container-fluid">
  <div class="row-fluid">
    <div class="span3">
     
    </div>
    <div class="span8">
<h3>"""),_display_(Seq[Any](/*11.6*/course/*11.12*/.name)),format.raw/*11.17*/("""</h3>
By """),_display_(Seq[Any](/*12.5*/course/*12.11*/.owner.name)),format.raw/*12.22*/("""
"""),_display_(Seq[Any](/*13.2*/if(course.owner.company!=null)/*13.32*/{_display_(Seq[Any](format.raw/*13.33*/("""
,"""),_display_(Seq[Any](/*14.3*/course/*14.9*/.owner.company)),format.raw/*14.23*/("""
""")))})),format.raw/*15.2*/("""
<div class="menuBar">
<ul class="nav nav-pills">
  <li class="active">
    <a href=""""),_display_(Seq[Any](/*19.15*/routes/*19.21*/.Courses.coursePage(course.id))),format.raw/*19.51*/("""">Home</a>
  </li>
  <li><a href=""""),_display_(Seq[Any](/*21.17*/routes/*21.23*/.Lectures.lecturePage(course.id))),format.raw/*21.55*/("""">Lectures</a></li>
  <li><a href=""""),_display_(Seq[Any](/*22.17*/routes/*22.23*/.Application.index)),format.raw/*22.41*/("""">Assignments</a></li>
  <li><a href=""""),_display_(Seq[Any](/*23.17*/routes/*23.23*/.Application.index)),format.raw/*23.41*/("""">Community</a></li>
</ul>
</div>
</div>
</div>
</div>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="span3">
     <ul class="nav nav-list sidebar">  
  <li class="nav-header">Course information</li>
  """),_display_(Seq[Any](/*34.4*/for(courseInformation<-courseInformations) yield /*34.46*/{_display_(Seq[Any](format.raw/*34.47*/("""
  <li><a class="courseInformations" id=""""),_display_(Seq[Any](/*35.42*/courseInformation/*35.59*/.id)),format.raw/*35.62*/("""" href="#">"""),_display_(Seq[Any](/*35.74*/courseInformation/*35.91*/.title)),format.raw/*35.97*/("""</a></li>
  """)))})),format.raw/*36.4*/("""
</ul>
    </div>
    <div class="span8">
      <div class="contentBar">
<div id="announcements">
"""),_display_(Seq[Any](/*42.2*/for(annoncement<-announcements) yield /*42.33*/{_display_(Seq[Any](format.raw/*42.34*/("""
<span>
<dl>
  <dt>"""),_display_(Seq[Any](/*45.8*/annoncement/*45.19*/.title)),format.raw/*45.25*/("""</dt>
  <dd>"""),_display_(Seq[Any](/*46.8*/annoncement/*46.19*/.content)),format.raw/*46.27*/("""</dd>
</dl>
<p>"""),_display_(Seq[Any](/*48.5*/annoncement/*48.16*/.createdDate)),format.raw/*48.28*/("""</p>
</span>
""")))})),format.raw/*50.2*/("""
</div>
</div>
    </div>
  </div>
</div>


""")))})),format.raw/*58.2*/("""
<script type="text/javascript">
$(document).ready(function()"""),format.raw/*60.29*/("""{"""),format.raw/*60.30*/("""
	$('.courseInformations').click(function(e) """),format.raw/*61.45*/("""{"""),format.raw/*61.46*/("""
		var lectureId=$(this).attr('id');
		myJsRoutes.controllers.CourseInformations.getCourseInformation(lectureId).ajax("""),format.raw/*63.82*/("""{"""),format.raw/*63.83*/("""
		    success : function(data) """),format.raw/*64.32*/("""{"""),format.raw/*64.33*/("""
			$('.contentBar').html(data);
		    """),format.raw/*66.7*/("""}"""),format.raw/*66.8*/("""
		"""),format.raw/*67.3*/("""}"""),format.raw/*67.4*/(""");
		return false;
	"""),format.raw/*69.2*/("""}"""),format.raw/*69.3*/(""");
"""),format.raw/*70.1*/("""}"""),format.raw/*70.2*/(""");
</script>"""))}
    }
    
    def render(user:User,course:Course,announcements:List[Announcement],courseInformations:List[CourseInformation]): play.api.templates.Html = apply(user,course,announcements,courseInformations)
    
    def f:((User,Course,List[Announcement],List[CourseInformation]) => play.api.templates.Html) = (user,course,announcements,courseInformations) => apply(user,course,announcements,courseInformations)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 00:33:53 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/course/student/index.scala.html
                    HASH: 119d40530fc6e1f3beb0837077dae4c85c32c9ba
                    MATRIX: 786->1|984->104|1023->127|1041->137|1079->138|1248->272|1263->278|1290->283|1336->294|1351->300|1384->311|1422->314|1461->344|1500->345|1539->349|1553->355|1589->369|1623->372|1749->462|1764->468|1816->498|1889->535|1904->541|1958->573|2031->610|2046->616|2086->634|2162->674|2177->680|2217->698|2491->937|2549->979|2588->980|2667->1023|2693->1040|2718->1043|2766->1055|2792->1072|2820->1078|2865->1092|3005->1197|3052->1228|3091->1229|3149->1252|3169->1263|3197->1269|3246->1283|3266->1294|3296->1302|3349->1320|3369->1331|3403->1343|3450->1359|3534->1412|3625->1475|3654->1476|3728->1522|3757->1523|3905->1643|3934->1644|3995->1677|4024->1678|4092->1719|4120->1720|4151->1724|4179->1725|4228->1747|4256->1748|4287->1752|4315->1753
                    LINES: 26->1|30->1|32->4|32->4|32->4|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|47->19|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|63->35|64->36|70->42|70->42|70->42|73->45|73->45|73->45|74->46|74->46|74->46|76->48|76->48|76->48|78->50|86->58|88->60|88->60|89->61|89->61|91->63|91->63|92->64|92->64|94->66|94->66|95->67|95->67|97->69|97->69|98->70|98->70
                    -- GENERATED --
                */
            