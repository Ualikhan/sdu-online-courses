
package views.html.lecture

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
  """),_display_(Seq[Any](/*35.4*/form(routes.Lectures.deleteLecture(lecture.id))/*35.51*/{_display_(Seq[Any](format.raw/*35.52*/("""
  <li><a class="lectures" id=""""),_display_(Seq[Any](/*36.32*/lecture/*36.39*/.id)),format.raw/*36.42*/("""" href=""""),_display_(Seq[Any](/*36.51*/routes/*36.57*/.Lectures.getLecture(lecture.id))),format.raw/*36.89*/("""">"""),_display_(Seq[Any](/*36.92*/lecture/*36.99*/.title)),format.raw/*36.105*/("""</a>
 <button class="btn btn-mini btn-primary"  type="submit"><i class="icon-remove"></i></button>
  </li>
""")))})),format.raw/*39.2*/("""
  """)))})),format.raw/*40.4*/("""
</ul>
    </div>
    <div class="span8">
      <div class="contentBar">
		
</div>

    </div>
  </div>
</div>


""")))})),format.raw/*53.2*/("""

<script type="text/javascript">
$(document).ready(function()"""),format.raw/*56.29*/("""{"""),format.raw/*56.30*/("""
	$('.lectures').click(function(e) """),format.raw/*57.35*/("""{"""),format.raw/*57.36*/("""
		var lectureId=$(this).attr('id');
		myJsRoutes.controllers.Lectures.getLecture(lectureId).ajax("""),format.raw/*59.62*/("""{"""),format.raw/*59.63*/("""
		    success : function(data) """),format.raw/*60.32*/("""{"""),format.raw/*60.33*/("""
			$('.contentBar').html(data);
		
		    """),format.raw/*63.7*/("""}"""),format.raw/*63.8*/("""
		"""),format.raw/*64.3*/("""}"""),format.raw/*64.4*/(""");
		return false;
	"""),format.raw/*66.2*/("""}"""),format.raw/*66.3*/(""");
"""),format.raw/*67.1*/("""}"""),format.raw/*67.2*/(""");
</script>
"""))}
    }
    
    def render(user:User,course:Course,lectures:List[Lecture]): play.api.templates.Html = apply(user,course,lectures)
    
    def f:((User,Course,List[Lecture]) => play.api.templates.Html) = (user,course,lectures) => apply(user,course,lectures)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Apr 19 18:14:40 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/lecture/index.scala.html
                    HASH: c1890a6f7b00d4a8704f6bd9469d30eb924fa7c0
                    MATRIX: 750->1|893->50|932->73|950->83|988->84|1152->213|1167->219|1194->224|1240->235|1255->241|1288->252|1326->255|1365->285|1404->286|1443->290|1457->296|1493->310|1527->313|1639->389|1654->395|1706->425|1794->477|1809->483|1863->515|1936->552|1951->558|1991->576|2067->616|2082->622|2122->640|2384->867|2422->889|2461->890|2501->895|2557->942|2596->943|2665->976|2681->983|2706->986|2751->995|2766->1001|2820->1033|2859->1036|2875->1043|2904->1049|3046->1160|3082->1165|3240->1292|3333->1357|3362->1358|3426->1394|3455->1395|3583->1495|3612->1496|3673->1529|3702->1530|3774->1575|3802->1576|3833->1580|3861->1581|3910->1603|3938->1604|3969->1608|3997->1609
                    LINES: 26->1|30->1|32->4|32->4|32->4|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|47->19|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|62->34|62->34|62->34|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|67->39|68->40|81->53|84->56|84->56|85->57|85->57|87->59|87->59|88->60|88->60|91->63|91->63|92->64|92->64|94->66|94->66|95->67|95->67
                    -- GENERATED --
                */
            