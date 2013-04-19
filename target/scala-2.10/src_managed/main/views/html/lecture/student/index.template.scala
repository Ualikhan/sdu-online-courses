
package views.html.lecture.student

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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[User,Course,List[Lecture],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user:User,course:Course,lectures: List[Lecture]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.51*/("""

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
  <li >
    <a href=""""),_display_(Seq[Any](/*19.15*/routes/*19.21*/.Courses.coursePage(course.id))),format.raw/*19.51*/("""">Home</a>
  </li>
  <li class="active"><a href=""""),_display_(Seq[Any](/*21.32*/routes/*21.38*/.Lectures.lecturePage(course.id))),format.raw/*21.70*/("""">Lectures</a></li>
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
  <li class="nav-header">Lectures</li>
  """),_display_(Seq[Any](/*34.4*/for(lecture<-lectures) yield /*34.26*/{_display_(Seq[Any](format.raw/*34.27*/("""
  <li><a class="lectures" id=""""),_display_(Seq[Any](/*35.32*/lecture/*35.39*/.id)),format.raw/*35.42*/("""" href=""""),_display_(Seq[Any](/*35.51*/routes/*35.57*/.Lectures.getLecture(lecture.id))),format.raw/*35.89*/("""">"""),_display_(Seq[Any](/*35.92*/lecture/*35.99*/.title)),format.raw/*35.105*/("""</a></li>
  """)))})),format.raw/*36.4*/("""
</ul>
    </div>
    <div class="span8">
      <div class="contentBar">
		
</div>

    </div>
  </div>
</div>


""")))})),format.raw/*49.2*/("""
/*
<script type="text/javascript">
$(document).ready(function()"""),format.raw/*52.29*/("""{"""),format.raw/*52.30*/("""
	$('.lectures').click(function(e) """),format.raw/*53.35*/("""{"""),format.raw/*53.36*/("""
		var lectureId=$(this).attr('id');
		myJsRoutes.controllers.Lectures.getLecture(lectureId).ajax("""),format.raw/*55.62*/("""{"""),format.raw/*55.63*/("""
		    success : function(data) """),format.raw/*56.32*/("""{"""),format.raw/*56.33*/("""
			$('.contentBar').html(data);
		
		    """),format.raw/*59.7*/("""}"""),format.raw/*59.8*/("""
		"""),format.raw/*60.3*/("""}"""),format.raw/*60.4*/(""");
		return false;
	"""),format.raw/*62.2*/("""}"""),format.raw/*62.3*/(""");
"""),format.raw/*63.1*/("""}"""),format.raw/*63.2*/(""");
</script>
*/"""))}
    }
    
    def render(user:User,course:Course,lectures:List[Lecture]): play.api.templates.Html = apply(user,course,lectures)
    
    def f:((User,Course,List[Lecture]) => play.api.templates.Html) = (user,course,lectures) => apply(user,course,lectures)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Apr 19 11:38:53 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/lecture/student/index.scala.html
                    HASH: a47e751bb54e98b0ec09b55bbce1c0ff35c7d749
                    MATRIX: 758->1|901->50|940->73|958->83|996->84|1160->213|1175->219|1202->224|1248->235|1263->241|1296->252|1334->255|1373->285|1412->286|1451->290|1465->296|1501->310|1535->313|1647->389|1662->395|1714->425|1802->477|1817->483|1871->515|1944->552|1959->558|1999->576|2075->616|2090->622|2130->640|2392->867|2430->889|2469->890|2538->923|2554->930|2579->933|2624->942|2639->948|2693->980|2732->983|2748->990|2777->996|2822->1010|2980->1137|3075->1204|3104->1205|3168->1241|3197->1242|3325->1342|3354->1343|3415->1376|3444->1377|3516->1422|3544->1423|3575->1427|3603->1428|3652->1450|3680->1451|3711->1455|3739->1456
                    LINES: 26->1|30->1|32->4|32->4|32->4|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|47->19|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|64->36|77->49|80->52|80->52|81->53|81->53|83->55|83->55|84->56|84->56|87->59|87->59|88->60|88->60|90->62|90->62|91->63|91->63
                    -- GENERATED --
                */
            