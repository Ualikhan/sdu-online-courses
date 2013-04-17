
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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Lecture,List[LectureResource],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(lecture: Lecture,resources:List[LectureResource],user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.62*/("""

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
"""),_display_(Seq[Any](/*22.2*/resources/*22.11*/.groupBy(_.resourceType).map/*22.39*/{/*23.11*/case (resourceT,resources) =>/*23.40*/ {_display_(Seq[Any](format.raw/*23.42*/("""


"""),_display_(Seq[Any](/*26.2*/if(resourceT.name().equals("VIDEO"))/*26.38*/{_display_(Seq[Any](format.raw/*26.39*/("""
"""),_display_(Seq[Any](/*27.2*/for(resource <- resources) yield /*27.28*/{_display_(Seq[Any](format.raw/*27.29*/("""
"""),_display_(Seq[Any](/*28.2*/resource/*28.10*/.title)),format.raw/*28.16*/(""" 

"""),_display_(Seq[Any](/*30.2*/if(resource.file_url!=null)/*30.29*/{_display_(Seq[Any](format.raw/*30.30*/("""

<div class="player" data-engine="flash">
   <video preload="none">
      <source type="video/mp4" src=""""),_display_(Seq[Any](/*34.38*/routes/*34.44*/.Assets.at("uploadVideos/"+{resource.file_url}))),format.raw/*34.91*/(""""/>
         </video>
</div>
""")))})),format.raw/*37.2*/("""
""")))})),format.raw/*38.2*/("""
""")))}/*39.2*/else/*39.6*/{_display_(Seq[Any](format.raw/*39.7*/("""
"""),_display_(Seq[Any](/*40.2*/if(resourceT.name().equals("SLIDE"))/*40.38*/{_display_(Seq[Any](format.raw/*40.39*/("""

"""),_display_(Seq[Any](/*42.2*/for(resource <- resources) yield /*42.28*/{_display_(Seq[Any](format.raw/*42.29*/("""
"""),_display_(Seq[Any](/*43.2*/if(resource.file_url!=null)/*43.29*/{_display_(Seq[Any](format.raw/*43.30*/("""
<a href =""""),_display_(Seq[Any](/*44.12*/routes/*44.18*/.Assets.at("uploadSlides/"+{resource.file_url}))),format.raw/*44.65*/("""">"""),_display_(Seq[Any](/*44.68*/resource/*44.76*/.title)),format.raw/*44.82*/(""" </a>
""")))})),format.raw/*45.2*/("""
""")))})),format.raw/*46.2*/("""
""")))})),format.raw/*47.2*/("""
""")))})),format.raw/*48.2*/("""
""")))}})),format.raw/*50.2*/("""
</div>
Slides<input type="file" name="slide" placeholder="Slides">
</p>
<p>
<button type="submit">Update</button><a href=""""),_display_(Seq[Any](/*55.48*/routes/*55.54*/.Lectures.index())),format.raw/*55.71*/("""">Cancel</button>
</p>
</form>
""")))})),format.raw/*58.2*/("""

<script type="text/javascript">
$(document).ready(function() """),format.raw/*61.30*/("""{"""),format.raw/*61.31*/("""
	
		$('.addVideo').on('click', function() """),format.raw/*63.41*/("""{"""),format.raw/*63.42*/("""
			$('#videos').append('<p>Video<input type="file" name="video" placeholder="Video"></p>');
		 
		   """),format.raw/*66.6*/("""}"""),format.raw/*66.7*/(""");
	
	
		   // install flowplayer to an element with CSS class "player"
		   $(".player").flowplayer("""),format.raw/*70.30*/("""{"""),format.raw/*70.31*/(""" swf: """"),_display_(Seq[Any](/*70.39*/routes/*70.45*/.Assets.at('javascripts/flowplayer-5.4.0/flowplayer.swf'))),format.raw/*70.102*/("""" """),format.raw/*70.104*/("""}"""),format.raw/*70.105*/(""");
		
		"""),format.raw/*72.3*/("""}"""),format.raw/*72.4*/(""");
</script>
	"""))}
    }
    
    def render(lecture:Lecture,resources:List[LectureResource],user:User): play.api.templates.Html = apply(lecture,resources,user)
    
    def f:((Lecture,List[LectureResource],User) => play.api.templates.Html) = (lecture,resources,user) => apply(lecture,resources,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Apr 18 00:11:20 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/lecture/item.scala.html
                    HASH: 1408366f1b707cc4d1dc42e917efdcb83ff2ccbd
                    MATRIX: 758->1|912->61|942->83|979->86|997->96|1035->97|1148->175|1162->181|1218->216|1353->315|1369->322|1397->328|1521->416|1537->423|1567->431|1781->610|1799->619|1836->647|1846->660|1884->689|1924->691|1966->698|2011->734|2050->735|2088->738|2130->764|2169->765|2207->768|2224->776|2252->782|2293->788|2329->815|2368->816|2514->926|2529->932|2598->979|2662->1012|2696->1015|2717->1018|2729->1022|2767->1023|2805->1026|2850->1062|2889->1063|2929->1068|2971->1094|3010->1095|3048->1098|3084->1125|3123->1126|3172->1139|3187->1145|3256->1192|3295->1195|3312->1203|3340->1209|3379->1217|3413->1220|3447->1223|3481->1226|3516->1232|3681->1361|3696->1367|3735->1384|3801->1419|3895->1485|3924->1486|3997->1531|4026->1532|4158->1637|4186->1638|4319->1743|4348->1744|4392->1752|4407->1758|4487->1815|4518->1817|4548->1818|4585->1828|4613->1829
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|37->9|37->9|37->9|39->11|39->11|39->11|42->14|42->14|42->14|50->22|50->22|50->22|50->23|50->23|50->23|53->26|53->26|53->26|54->27|54->27|54->27|55->28|55->28|55->28|57->30|57->30|57->30|61->34|61->34|61->34|64->37|65->38|66->39|66->39|66->39|67->40|67->40|67->40|69->42|69->42|69->42|70->43|70->43|70->43|71->44|71->44|71->44|71->44|71->44|71->44|72->45|73->46|74->47|75->48|76->50|81->55|81->55|81->55|84->58|87->61|87->61|89->63|89->63|92->66|92->66|96->70|96->70|96->70|96->70|96->70|96->70|96->70|98->72|98->72
                    -- GENERATED --
                */
            