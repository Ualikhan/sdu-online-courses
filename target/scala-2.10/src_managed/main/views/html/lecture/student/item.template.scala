
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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Lecture,List[LectureResource],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(lecture: Lecture,resources:List[LectureResource]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.52*/("""

"""),format.raw/*4.1*/("""
<input type="hidden" id="flowPlayer" value=""""),_display_(Seq[Any](/*5.46*/routes/*5.52*/.Assets.at("javascripts/flowplayer-5.4.0/flowplayer.swf"))),format.raw/*5.109*/("""">

<h3>"""),_display_(Seq[Any](/*7.6*/lecture/*7.13*/.title)),format.raw/*7.19*/("""</h3>
<p>
"""),_display_(Seq[Any](/*9.2*/if(lecture.content!=null)/*9.27*/{_display_(Seq[Any](format.raw/*9.28*/("""
"""),_display_(Seq[Any](/*10.2*/Html(lecture.content))),format.raw/*10.23*/("""
""")))})),format.raw/*11.2*/("""
</p>
"""),_display_(Seq[Any](/*13.2*/resources/*13.11*/.groupBy(_.resourceType).map/*13.39*/{/*14.11*/case (resourceT,resources) =>/*14.40*/ {_display_(Seq[Any](format.raw/*14.42*/("""


"""),_display_(Seq[Any](/*17.2*/if(resourceT.name().equals("VIDEO"))/*17.38*/{_display_(Seq[Any](format.raw/*17.39*/("""
<fieldset>
 <legend>Videos</legend>
<div class='mask' width="">
<div class='videos'>
"""),_display_(Seq[Any](/*22.2*/for(resource <- resources) yield /*22.28*/{_display_(Seq[Any](format.raw/*22.29*/(""" 

"""),_display_(Seq[Any](/*24.2*/if(resource.file_url!=null)/*24.29*/{_display_(Seq[Any](format.raw/*24.30*/("""

<div class="videoItem">
<span class="res">
<p class="resourceTitleEdit title" id=""""),_display_(Seq[Any](/*28.41*/resource/*28.49*/.id)),format.raw/*28.52*/("""">"""),_display_(Seq[Any](/*28.55*/resource/*28.63*/.title)),format.raw/*28.69*/("""</p>
"""),_display_(Seq[Any](/*29.2*/if(resource.file_url.contains("youtube.com"))/*29.47*/{_display_(Seq[Any](format.raw/*29.48*/("""
<iframe class="videoFrameSize"
src=""""),_display_(Seq[Any](/*31.7*/resource/*31.15*/.file_url)),format.raw/*31.24*/("""">
</iframe>
""")))}/*33.2*/else/*33.6*/{_display_(Seq[Any](format.raw/*33.7*/("""
<div class="player videoFrameSize" data-engine="flash" style="display:block;">
   <video preload="none">
        <source type="video/mp4" src=""""),_display_(Seq[Any](/*36.40*/routes/*36.46*/.Assets.at("uploadVideos/"+{resource.file_url}))),format.raw/*36.93*/(""""/>
      
         </video>
</div>
""")))})),format.raw/*40.2*/("""
</span>
</div>
""")))})),format.raw/*43.2*/("""
""")))})),format.raw/*44.2*/("""
</div>
</div>
</fieldset>
""")))}/*48.2*/else/*48.6*/{_display_(Seq[Any](format.raw/*48.7*/("""
"""),_display_(Seq[Any](/*49.2*/if(resourceT.name().equals("SLIDE"))/*49.38*/{_display_(Seq[Any](format.raw/*49.39*/("""
<fieldset>
 <legend>Slides</legend>
<div class='mask'>
<div class='slides'>
"""),_display_(Seq[Any](/*54.2*/for(resource <- resources) yield /*54.28*/{_display_(Seq[Any](format.raw/*54.29*/("""
"""),_display_(Seq[Any](/*55.2*/if(resource.file_url!=null)/*55.29*/{_display_(Seq[Any](format.raw/*55.30*/("""
<div class="slideItem">
<span class="res">
"""),_display_(Seq[Any](/*58.2*/if(resource.file_url.contains("http"))/*58.40*/{_display_(Seq[Any](format.raw/*58.41*/("""
<a class="title resourceTitleEdit" id=""""),_display_(Seq[Any](/*59.41*/resource/*59.49*/.id)),format.raw/*59.52*/("""" href =""""),_display_(Seq[Any](/*59.62*/resource/*59.70*/.file_url)),format.raw/*59.79*/("""">
"""),_display_(Seq[Any](/*60.2*/resource/*60.10*/.title)),format.raw/*60.16*/("""
 </a>
""")))}/*62.2*/else/*62.6*/{_display_(Seq[Any](format.raw/*62.7*/("""
<a class="title resourceTitleEdit" id=""""),_display_(Seq[Any](/*63.41*/resource/*63.49*/.id)),format.raw/*63.52*/("""" href =""""),_display_(Seq[Any](/*63.62*/routes/*63.68*/.Assets.at("uploadSlides/"+{resource.file_url}))),format.raw/*63.115*/("""">
"""),_display_(Seq[Any](/*64.2*/resource/*64.10*/.title)),format.raw/*64.16*/("""
 </a>
""")))})),format.raw/*66.2*/("""
</span>
</div>
""")))})),format.raw/*69.2*/("""
""")))})),format.raw/*70.2*/("""
</div>
</div>
</fieldset>
""")))})),format.raw/*74.2*/("""
""")))})),format.raw/*75.2*/("""

""")))}})),format.raw/*78.2*/("""

<script type="text/javascript">
$(document).ready(function() """),format.raw/*81.30*/("""{"""),format.raw/*81.31*/("""
	
	       var flowPlayer=$('#flowPlayer').val();
		   // install flowplayer to an element with CSS class "player"
		   $(".player").flowplayer("""),format.raw/*85.30*/("""{"""),format.raw/*85.31*/(""" swf: flowPlayer
		   """),format.raw/*86.6*/("""}"""),format.raw/*86.7*/(""");
		   
		"""),format.raw/*88.3*/("""}"""),format.raw/*88.4*/(""");
</script>"""))}
    }
    
    def render(lecture:Lecture,resources:List[LectureResource]): play.api.templates.Html = apply(lecture,resources)
    
    def f:((Lecture,List[LectureResource]) => play.api.templates.Html) = (lecture,resources) => apply(lecture,resources)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Apr 19 11:38:53 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/lecture/student/item.scala.html
                    HASH: 476019aaff41f53019df9f3cb522fc7daba6e26d
                    MATRIX: 761->1|905->51|935->73|1017->120|1031->126|1110->183|1155->194|1170->201|1197->207|1244->220|1277->245|1315->246|1353->249|1396->270|1430->273|1474->282|1492->291|1529->319|1539->332|1577->361|1617->363|1659->370|1704->406|1743->407|1870->499|1912->525|1951->526|1992->532|2028->559|2067->560|2192->649|2209->657|2234->660|2273->663|2290->671|2318->677|2360->684|2414->729|2453->730|2528->770|2545->778|2576->787|2610->803|2622->807|2660->808|2844->956|2859->962|2928->1009|3000->1050|3051->1070|3085->1073|3135->1105|3147->1109|3185->1110|3223->1113|3268->1149|3307->1150|3425->1233|3467->1259|3506->1260|3544->1263|3580->1290|3619->1291|3702->1339|3749->1377|3788->1378|3866->1420|3883->1428|3908->1431|3954->1441|3971->1449|4002->1458|4042->1463|4059->1471|4087->1477|4115->1487|4127->1491|4165->1492|4243->1534|4260->1542|4285->1545|4331->1555|4346->1561|4416->1608|4456->1613|4473->1621|4501->1627|4542->1637|4593->1657|4627->1660|4690->1692|4724->1695|4761->1703|4855->1769|4884->1770|5060->1918|5089->1919|5139->1942|5167->1943|5207->1956|5235->1957
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|38->10|38->10|39->11|41->13|41->13|41->13|41->14|41->14|41->14|44->17|44->17|44->17|49->22|49->22|49->22|51->24|51->24|51->24|55->28|55->28|55->28|55->28|55->28|55->28|56->29|56->29|56->29|58->31|58->31|58->31|60->33|60->33|60->33|63->36|63->36|63->36|67->40|70->43|71->44|75->48|75->48|75->48|76->49|76->49|76->49|81->54|81->54|81->54|82->55|82->55|82->55|85->58|85->58|85->58|86->59|86->59|86->59|86->59|86->59|86->59|87->60|87->60|87->60|89->62|89->62|89->62|90->63|90->63|90->63|90->63|90->63|90->63|91->64|91->64|91->64|93->66|96->69|97->70|101->74|102->75|104->78|107->81|107->81|111->85|111->85|112->86|112->86|114->88|114->88
                    -- GENERATED --
                */
            