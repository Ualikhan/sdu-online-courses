
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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Lecture,List[VideoResource],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(lecture: Lecture,resources:List[VideoResource],user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.60*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(user)/*5.12*/{_display_(Seq[Any](format.raw/*5.13*/("""
<h2>Edit lecture</h2>


<form id="addStudentForm" method="post" action=""""),_display_(Seq[Any](/*9.50*/routes/*9.56*/.Lectures.updateLecture(lecture.id))),format.raw/*9.91*/("""" enctype="multipart/form-data"> 
<p>
<input type="text" name="title" placeholder="Name" value=""""),_display_(Seq[Any](/*11.60*/lecture/*11.67*/.title)),format.raw/*11.73*/("""">
</p>
<p>
<textarea rows="10" cols="30" name="content" placeholder="Description" >"""),_display_(Seq[Any](/*14.74*/lecture/*14.81*/.content)),format.raw/*14.89*/("""</textarea>
</p>
<p>
Video<input class="videos" type="file" id="1" name="video" placeholder="Video">
</p>
<a class="addVideo">Add another video</a>
<p>
<div id="videos">
<ul>
"""),_display_(Seq[Any](/*23.2*/for(resource <- resources) yield /*23.28*/{_display_(Seq[Any](format.raw/*23.29*/("""
<li>"""),_display_(Seq[Any](/*24.6*/resource/*24.14*/.title)),format.raw/*24.20*/(""" 
"""),_display_(Seq[Any](/*25.2*/if(resource.resourceType.name().equals("VIDEO"))/*25.50*/{_display_(Seq[Any](format.raw/*25.51*/("""
"""),_display_(Seq[Any](/*26.2*/if(resource.file_path!=null)/*26.30*/{_display_(Seq[Any](format.raw/*26.31*/("""
<iframe class="videoDiv" width="420" height="345"
src=""""),_display_(Seq[Any](/*28.7*/routes/*28.13*/.Assets.at("uploadVideos/"+{resource.file_path}))),format.raw/*28.61*/("""">
</iframe>
""")))})),format.raw/*30.2*/("""
""")))}/*31.2*/else/*31.6*/{_display_(Seq[Any](format.raw/*31.7*/("""
"""),_display_(Seq[Any](/*32.2*/if(resource.resourceType.name().equals("SLIDE"))/*32.50*/{_display_(Seq[Any](format.raw/*32.51*/("""
"""),_display_(Seq[Any](/*33.2*/if(resource.file_path!=null)/*33.30*/{_display_(Seq[Any](format.raw/*33.31*/("""
<iframe class="videoDiv" width="420" height="345"
src=""""),_display_(Seq[Any](/*35.7*/routes/*35.13*/.Assets.at("uploadSlides/"+{resource.file_path}))),format.raw/*35.61*/("""">
</iframe>
""")))})),format.raw/*37.2*/("""
""")))})),format.raw/*38.2*/("""
""")))})),format.raw/*39.2*/("""
</li>
""")))})),format.raw/*41.2*/("""
</ul>
</div>
Slides<input type="file" name="slide" placeholder="Slides">
</p>
<p>
<button type="submit">Update</button><a href=""""),_display_(Seq[Any](/*47.48*/routes/*47.54*/.Lectures.index())),format.raw/*47.71*/("""">Cancel</button>
</p>
</form>
""")))})),format.raw/*50.2*/("""

<script type="text/javascript">
$(document).ready(function() """),format.raw/*53.30*/("""{"""),format.raw/*53.31*/("""
	
		$('.addVideo').on('click', function() """),format.raw/*55.41*/("""{"""),format.raw/*55.42*/("""
			$('#videos').append('<p>Video<input type="file" name="video" placeholder="Video"></p>');
		 
		   """),format.raw/*58.6*/("""}"""),format.raw/*58.7*/(""");
	
		
		"""),format.raw/*61.3*/("""}"""),format.raw/*61.4*/(""");
</script>
	"""))}
    }
    
    def render(lecture:Lecture,resources:List[VideoResource],user:User): play.api.templates.Html = apply(lecture,resources,user)
    
    def f:((Lecture,List[VideoResource],User) => play.api.templates.Html) = (lecture,resources,user) => apply(lecture,resources,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 17 19:44:58 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/lecture/item.scala.html
                    HASH: c3ea4af9566d8df278e984c861f8172828263a20
                    MATRIX: 756->1|908->59|938->81|975->84|993->94|1031->95|1144->173|1158->179|1214->214|1349->313|1365->320|1393->326|1517->414|1533->421|1563->429|1783->614|1825->640|1864->641|1906->648|1923->656|1951->662|1990->666|2047->714|2086->715|2124->718|2161->746|2200->747|2294->806|2309->812|2379->860|2426->876|2447->879|2459->883|2497->884|2535->887|2592->935|2631->936|2669->939|2706->967|2745->968|2839->1027|2854->1033|2924->1081|2971->1097|3005->1100|3039->1103|3080->1113|3252->1249|3267->1255|3306->1272|3372->1307|3466->1373|3495->1374|3568->1419|3597->1420|3729->1525|3757->1526|3797->1539|3825->1540
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|37->9|37->9|37->9|39->11|39->11|39->11|42->14|42->14|42->14|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|56->28|56->28|56->28|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|63->35|63->35|63->35|65->37|66->38|67->39|69->41|75->47|75->47|75->47|78->50|81->53|81->53|83->55|83->55|86->58|86->58|89->61|89->61
                    -- GENERATED --
                */
            