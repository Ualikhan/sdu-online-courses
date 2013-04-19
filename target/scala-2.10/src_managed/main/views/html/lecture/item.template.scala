
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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Lecture,List[LectureResource],List[LectureResource],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(lecture: Lecture,videoResources:List[LectureResource],slideResources:List[LectureResource]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.94*/("""

"""),format.raw/*4.1*/("""
<h2>Edit lecture</h2>
<input type="hidden" id="flowPlayer" value=""""),_display_(Seq[Any](/*6.46*/routes/*6.52*/.Assets.at("javascripts/flowplayer-5.4.0/flowplayer.swf"))),format.raw/*6.109*/("""">
<input type="hidden" id="titleEdit" value=""""),_display_(Seq[Any](/*7.45*/routes/*7.51*/.Lectures.updateTitle())),format.raw/*7.74*/("""">
<input type="hidden" id="contentEdit" value=""""),_display_(Seq[Any](/*8.47*/routes/*8.53*/.Lectures.updateContent())),format.raw/*8.78*/("""">
<input type="hidden" id="resourceTitleEdit" value=""""),_display_(Seq[Any](/*9.53*/routes/*9.59*/.Lectures.updateResourceTitle())),format.raw/*9.90*/("""">

<div class="lectureTitleEdit" id=""""),_display_(Seq[Any](/*11.36*/lecture/*11.43*/.id)),format.raw/*11.46*/("""">"""),_display_(Seq[Any](/*11.49*/lecture/*11.56*/.title)),format.raw/*11.62*/("""</div>
<div class="lectureContentEdit" id=""""),_display_(Seq[Any](/*12.38*/lecture/*12.45*/.id)),format.raw/*12.48*/("""">"""),_display_(Seq[Any](/*12.51*/lecture/*12.58*/.content)),format.raw/*12.66*/("""</div>

<p>

<fieldset>
 <legend>Videos</legend>
<div class='mask' style="width:100%;">
<div class='videos'>
"""),_display_(Seq[Any](/*20.2*/for(resource <- videoResources) yield /*20.33*/{_display_(Seq[Any](format.raw/*20.34*/(""" 

"""),_display_(Seq[Any](/*22.2*/if(resource.file_url!=null)/*22.29*/{_display_(Seq[Any](format.raw/*22.30*/("""

<div class="videoItem">
<span class="res">
<p class="resourceTitleEdit title" id=""""),_display_(Seq[Any](/*26.41*/resource/*26.49*/.id)),format.raw/*26.52*/("""">"""),_display_(Seq[Any](/*26.55*/resource/*26.63*/.title)),format.raw/*26.69*/("""</p>
"""),_display_(Seq[Any](/*27.2*/if(resource.file_url.contains("youtube.com"))/*27.47*/{_display_(Seq[Any](format.raw/*27.48*/("""
<iframe class="videoFrameSize"
src=""""),_display_(Seq[Any](/*29.7*/resource/*29.15*/.file_url)),format.raw/*29.24*/("""">
</iframe>
""")))}/*31.2*/else/*31.6*/{_display_(Seq[Any](format.raw/*31.7*/("""
<div class="player videoFrameSize" data-engine="flash" style="display:block;">
   <video preload="none">
        <source type="video/mp4" src=""""),_display_(Seq[Any](/*34.40*/routes/*34.46*/.Assets.at("uploadVideos/"+{resource.file_url}))),format.raw/*34.93*/(""""/>
      
         </video>
</div>
""")))})),format.raw/*38.2*/("""
</span>
<span class="res action" style="margin:10px;margin-top:30px;">

"""),_display_(Seq[Any](/*42.2*/helper/*42.8*/.form(routes.Lectures.removeResource(resource.id,lecture.id))/*42.69*/ {_display_(Seq[Any](format.raw/*42.71*/("""
<button class="btn btn-mini btn-primary" type="submit"><i class="icon-remove"></i></button>
""")))})),format.raw/*44.2*/("""
</span>
</div>
""")))})),format.raw/*47.2*/("""
""")))})),format.raw/*48.2*/("""
</div>
</div>

</fieldset>

<form  method="post" action=""""),_display_(Seq[Any](/*54.31*/routes/*54.37*/.Lectures.addVideo(lecture.id))),format.raw/*54.67*/("""" enctype="multipart/form-data">
<fieldset>
    <legend>Add video to lecture</legend>
<input  type="text"  name="title" placeholder="Title">
<input  type="text"  name="videoUrl" placeholder="Video url"> or 
<input  type="file" id="1" name="videoFile" placeholder="Video path">
<button class="btn btn-primary" type="submit" data-loading-text="Loading...">Add</button>
</fieldset>
</form>



<fieldset>
 <legend>Slides</legend>
<div class='mask' >
<div class='slides'>
"""),_display_(Seq[Any](/*70.2*/for(resource <- slideResources) yield /*70.33*/{_display_(Seq[Any](format.raw/*70.34*/("""
"""),_display_(Seq[Any](/*71.2*/if(resource.file_url!=null)/*71.29*/{_display_(Seq[Any](format.raw/*71.30*/("""
<div class="slideItem">
<span class="res">
"""),_display_(Seq[Any](/*74.2*/if(resource.file_url.contains("http"))/*74.40*/{_display_(Seq[Any](format.raw/*74.41*/("""
<a class="title resourceTitleEdit" id=""""),_display_(Seq[Any](/*75.41*/resource/*75.49*/.id)),format.raw/*75.52*/("""" href =""""),_display_(Seq[Any](/*75.62*/resource/*75.70*/.file_url)),format.raw/*75.79*/("""">
"""),_display_(Seq[Any](/*76.2*/resource/*76.10*/.title)),format.raw/*76.16*/("""
 </a>
""")))}/*78.2*/else/*78.6*/{_display_(Seq[Any](format.raw/*78.7*/("""
<a class="title resourceTitleEdit" id=""""),_display_(Seq[Any](/*79.41*/resource/*79.49*/.id)),format.raw/*79.52*/("""" href =""""),_display_(Seq[Any](/*79.62*/routes/*79.68*/.Assets.at("uploadSlides/"+{resource.file_url}))),format.raw/*79.115*/("""">
"""),_display_(Seq[Any](/*80.2*/resource/*80.10*/.title)),format.raw/*80.16*/("""
 </a>
""")))})),format.raw/*82.2*/(""" 
</span>
<span class="res action">

"""),_display_(Seq[Any](/*86.2*/helper/*86.8*/.form(routes.Lectures.removeResource(resource.id,lecture.id))/*86.69*/ {_display_(Seq[Any](format.raw/*86.71*/("""
<button class="btn btn-mini btn-primary" type="submit"><i class="icon-remove"></i></button>
""")))})),format.raw/*88.2*/("""
</span>
</div>
""")))})),format.raw/*91.2*/("""
""")))})),format.raw/*92.2*/("""
</div>
</div>


</fieldset>

<form  method="post" action=""""),_display_(Seq[Any](/*99.31*/routes/*99.37*/.Lectures.addSlide(lecture.id))),format.raw/*99.67*/("""" enctype="multipart/form-data">
<fieldset>
    <legend>Add slides to lecture</legend>
<input  type="text"  name="title" placeholder="Title">
<input  type="text"  name="slideUrl" placeholder="Slide url"> or 
<input type="file" name="slideFile" placeholder="Slide path">
<button class="btn btn-primary" type="submit" data-loading-text="Loading...">Add</button>
</fieldset>
</form>

<script type="text/javascript">
$(document).ready(function() """),format.raw/*110.30*/("""{"""),format.raw/*110.31*/("""
	
	       var flowPlayer=$('#flowPlayer').val();
		   // install flowplayer to an element with CSS class "player"
		   $(".player").flowplayer("""),format.raw/*114.30*/("""{"""),format.raw/*114.31*/(""" swf: flowPlayer
		   """),format.raw/*115.6*/("""}"""),format.raw/*115.7*/(""");
		
		   var titleEdit=$('#titleEdit').val();
		   var contentEdit=$('#contentEdit').val();
		   $('.lectureTitleEdit').editable(titleEdit);
		   $('.lectureContentEdit').editable(contentEdit, """),format.raw/*120.53*/("""{"""),format.raw/*120.54*/(""" 
		         type      : 'textarea',
		         cancel    : 'Cancel',
		         submit    : 'OK',
		         tooltip   : 'Click to edit...'
		     """),format.raw/*125.8*/("""}"""),format.raw/*125.9*/(""");
		   
		   var resourceTitleEdit=$('#resourceTitleEdit').val();
		   $('.resourceTitleEdit').editable(resourceTitleEdit);
		   
		   
		"""),format.raw/*131.3*/("""}"""),format.raw/*131.4*/(""");
</script>
	"""))}
    }
    
    def render(lecture:Lecture,videoResources:List[LectureResource],slideResources:List[LectureResource]): play.api.templates.Html = apply(lecture,videoResources,slideResources)
    
    def f:((Lecture,List[LectureResource],List[LectureResource]) => play.api.templates.Html) = (lecture,videoResources,slideResources) => apply(lecture,videoResources,slideResources)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Apr 19 15:51:18 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/lecture/item.scala.html
                    HASH: 79c814e1fbab174c2b4cc2f8e361b17374d73fd0
                    MATRIX: 775->1|961->93|991->115|1096->185|1110->191|1189->248|1272->296|1286->302|1330->325|1415->375|1429->381|1475->406|1566->462|1580->468|1632->499|1709->540|1725->547|1750->550|1789->553|1805->560|1833->566|1914->611|1930->618|1955->621|1994->624|2010->631|2040->639|2193->757|2240->788|2279->789|2320->795|2356->822|2395->823|2520->912|2537->920|2562->923|2601->926|2618->934|2646->940|2688->947|2742->992|2781->993|2856->1033|2873->1041|2904->1050|2938->1066|2950->1070|2988->1071|3172->1219|3187->1225|3256->1272|3328->1313|3441->1391|3455->1397|3525->1458|3565->1460|3692->1556|3743->1576|3777->1579|3878->1644|3893->1650|3945->1680|4464->2164|4511->2195|4550->2196|4588->2199|4624->2226|4663->2227|4746->2275|4793->2313|4832->2314|4910->2356|4927->2364|4952->2367|4998->2377|5015->2385|5046->2394|5086->2399|5103->2407|5131->2413|5159->2423|5171->2427|5209->2428|5287->2470|5304->2478|5329->2481|5375->2491|5390->2497|5460->2544|5500->2549|5517->2557|5545->2563|5586->2573|5663->2615|5677->2621|5747->2682|5787->2684|5914->2780|5965->2800|5999->2803|6102->2870|6117->2876|6169->2906|6651->3359|6681->3360|6858->3508|6888->3509|6939->3532|6968->3533|7197->3733|7227->3734|7408->3887|7437->3888|7610->4033|7639->4034
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|48->20|48->20|48->20|50->22|50->22|50->22|54->26|54->26|54->26|54->26|54->26|54->26|55->27|55->27|55->27|57->29|57->29|57->29|59->31|59->31|59->31|62->34|62->34|62->34|66->38|70->42|70->42|70->42|70->42|72->44|75->47|76->48|82->54|82->54|82->54|98->70|98->70|98->70|99->71|99->71|99->71|102->74|102->74|102->74|103->75|103->75|103->75|103->75|103->75|103->75|104->76|104->76|104->76|106->78|106->78|106->78|107->79|107->79|107->79|107->79|107->79|107->79|108->80|108->80|108->80|110->82|114->86|114->86|114->86|114->86|116->88|119->91|120->92|127->99|127->99|127->99|138->110|138->110|142->114|142->114|143->115|143->115|148->120|148->120|153->125|153->125|159->131|159->131
                    -- GENERATED --
                */
            