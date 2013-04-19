
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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[User,Course,List[Announcement],List[CourseInformation],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user:User,course:Course,announcements: List[Announcement],courseInformations: List[CourseInformation]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.105*/("""


"""),_display_(Seq[Any](/*5.2*/main(user)/*5.12*/{_display_(Seq[Any](format.raw/*5.13*/("""
<div class="container-fluid">
  <div class="row-fluid">
    <div class="span3">
     
    </div>
    <div class="span8">
<h3>"""),_display_(Seq[Any](/*12.6*/course/*12.12*/.name)),format.raw/*12.17*/("""</h3>
By """),_display_(Seq[Any](/*13.5*/course/*13.11*/.owner.name)),format.raw/*13.22*/("""
"""),_display_(Seq[Any](/*14.2*/if(course.owner.company!=null)/*14.32*/{_display_(Seq[Any](format.raw/*14.33*/("""
,"""),_display_(Seq[Any](/*15.3*/course/*15.9*/.owner.company)),format.raw/*15.23*/("""
""")))})),format.raw/*16.2*/("""
<div class="menuBar">
<ul class="nav nav-pills">
  <li class="active">
    <a href=""""),_display_(Seq[Any](/*20.15*/routes/*20.21*/.Courses.coursePage(course.id))),format.raw/*20.51*/("""">Home</a>
  </li>
  <li><a href=""""),_display_(Seq[Any](/*22.17*/routes/*22.23*/.Lectures.index())),format.raw/*22.40*/("""">Lectures</a></li>
  <li><a href=""""),_display_(Seq[Any](/*23.17*/routes/*23.23*/.Application.index)),format.raw/*23.41*/("""">Assignments</a></li>
  <li><a href=""""),_display_(Seq[Any](/*24.17*/routes/*24.23*/.Application.index)),format.raw/*24.41*/("""">Community</a></li>
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
  """),_display_(Seq[Any](/*35.4*/for(courseInformation<-courseInformations) yield /*35.46*/{_display_(Seq[Any](format.raw/*35.47*/("""
  <li><a class="courseInformations" id=""""),_display_(Seq[Any](/*36.42*/courseInformation/*36.59*/.id)),format.raw/*36.62*/("""" href="#">"""),_display_(Seq[Any](/*36.74*/courseInformation/*36.91*/.title)),format.raw/*36.97*/("""</a></li>
  """)))})),format.raw/*37.4*/("""
</ul>
    </div>
    <div class="span8">
      <div class="contentBar">
      <script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script>
       
  
<div id="announcements">
<fieldset>
    <legend>Announcements</legend>
"""),_display_(Seq[Any](/*48.2*/for(annoncement<-announcements) yield /*48.33*/{_display_(Seq[Any](format.raw/*48.34*/("""
<script type="text/javascript">

     bkLib.onDomLoaded(function() """),format.raw/*51.35*/("""{"""),format.raw/*51.36*/("""
    	 var titleEdit=$('#titleEdit').val();
          var myNicEditor = new nicEditor("""),format.raw/*53.43*/("""{"""),format.raw/*53.44*/("""fullPanel : true, onSave : function(content, id, instance) """),format.raw/*53.103*/("""{"""),format.raw/*53.104*/("""
        	  myJsRoutes.controllers.Announcements.updateContent(''+"""),_display_(Seq[Any](/*54.67*/annoncement/*54.78*/.id)),format.raw/*54.81*/(""").ajax("""),format.raw/*54.88*/("""{"""),format.raw/*54.89*/("""
        		data: """),format.raw/*55.17*/("""{"""),format.raw/*55.18*/("""value:content"""),format.raw/*55.31*/("""}"""),format.raw/*55.32*/(""",
      		    success : function(data) """),format.raw/*56.38*/("""{"""),format.raw/*56.39*/("""
      		    $('#annContent'+"""),_display_(Seq[Any](/*57.30*/annoncement/*57.41*/.id)),format.raw/*57.44*/(""").html('');
      			$('#annContent'+"""),_display_(Seq[Any](/*58.27*/annoncement/*58.38*/.id)),format.raw/*58.41*/(""").html(data);
      		    """),format.raw/*59.13*/("""}"""),format.raw/*59.14*/("""
      		"""),format.raw/*60.9*/("""}"""),format.raw/*60.10*/(""");
          """),format.raw/*61.11*/("""}"""),format.raw/*61.12*/(""" """),format.raw/*61.13*/("""}"""),format.raw/*61.14*/(""");
          myNicEditor.setPanel('myNicPanel'+"""),_display_(Seq[Any](/*62.46*/annoncement/*62.57*/.id)),format.raw/*62.60*/(""");
          myNicEditor.addInstance('annContent'+"""),_display_(Seq[Any](/*63.49*/annoncement/*63.60*/.id)),format.raw/*63.63*/(""");
     """),format.raw/*64.6*/("""}"""),format.raw/*64.7*/(""");

  </script> 
  <div id="myNicPanel"""),_display_(Seq[Any](/*67.23*/annoncement/*67.34*/.id)),format.raw/*67.37*/("""" style="width: 525px;"></div>
<h4>"""),_display_(Seq[Any](/*68.6*/annoncement/*68.17*/.title)),format.raw/*68.23*/("""
"""),_display_(Seq[Any](/*69.2*/helper/*69.8*/.form(routes.Announcements.deleteAnnouncement(annoncement.id))/*69.70*/ {_display_(Seq[Any](format.raw/*69.72*/("""
<button class="btn btn-mini btn-primary" type="submit"><i class="icon-remove"></i></button>
""")))})),format.raw/*71.2*/("""
</h4>
<div id="annContent"""),_display_(Seq[Any](/*73.21*/annoncement/*73.32*/.id)),format.raw/*73.35*/("""">

"""),_display_(Seq[Any](/*75.2*/if(annoncement.content!=null)/*75.31*/{_display_(Seq[Any](format.raw/*75.32*/("""
"""),_display_(Seq[Any](/*76.2*/Html(annoncement.content))),format.raw/*76.27*/("""
""")))})),format.raw/*77.2*/("""
</div>
<p>"""),_display_(Seq[Any](/*79.5*/annoncement/*79.16*/.createdDate)),format.raw/*79.28*/("""</p>

""")))})),format.raw/*81.2*/("""
<h4>Add a new announcement</h4>
"""),_display_(Seq[Any](/*83.2*/form(routes.Announcements.newAnnouncement())/*83.46*/{_display_(Seq[Any](format.raw/*83.47*/("""
<p>
<input type="text" name="title" placeholder="Name">
</p>
<p>
<textarea class="ckeditor"  rows="10" cols="30" name="content" placeholder="Description"></textarea>
</p>
<p>
<button class="btn btn-primary"  type="submit">Create</button>
</p>
""")))})),format.raw/*93.2*/("""
</div>
</div>
    </div>
  </div>
</div>


""")))})),format.raw/*101.2*/("""
<script type="text/javascript">
$(document).ready(function()"""),format.raw/*103.29*/("""{"""),format.raw/*103.30*/("""
	$('.courseInformations').click(function(e) """),format.raw/*104.45*/("""{"""),format.raw/*104.46*/("""
		var lectureId=$(this).attr('id');
		myJsRoutes.controllers.CourseInformations.getCourseInformation(lectureId).ajax("""),format.raw/*106.82*/("""{"""),format.raw/*106.83*/("""
		    success : function(data) """),format.raw/*107.32*/("""{"""),format.raw/*107.33*/("""
			$('.contentBar').html(data);
		    """),format.raw/*109.7*/("""}"""),format.raw/*109.8*/("""
		"""),format.raw/*110.3*/("""}"""),format.raw/*110.4*/(""");
		return false;
	"""),format.raw/*112.2*/("""}"""),format.raw/*112.3*/(""");
"""),format.raw/*113.1*/("""}"""),format.raw/*113.2*/(""");
</script>
"""))}
    }
    
    def render(user:User,course:Course,announcements:List[Announcement],courseInformations:List[CourseInformation]): play.api.templates.Html = apply(user,course,announcements,courseInformations)
    
    def f:((User,Course,List[Announcement],List[CourseInformation]) => play.api.templates.Html) = (user,course,announcements,courseInformations) => apply(user,course,announcements,courseInformations)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Apr 19 18:20:25 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/course/item.scala.html
                    HASH: fc8f2a0542e555db3f40650a9bf97fbe3e2bd8db
                    MATRIX: 777->1|975->104|1016->129|1034->139|1072->140|1241->274|1256->280|1283->285|1329->296|1344->302|1377->313|1415->316|1454->346|1493->347|1532->351|1546->357|1582->371|1616->374|1742->464|1757->470|1809->500|1882->537|1897->543|1936->560|2009->597|2024->603|2064->621|2140->661|2155->667|2195->685|2469->924|2527->966|2566->967|2645->1010|2671->1027|2696->1030|2744->1042|2770->1059|2798->1065|2843->1079|3138->1339|3185->1370|3224->1371|3323->1442|3352->1443|3468->1531|3497->1532|3585->1591|3615->1592|3719->1660|3739->1671|3764->1674|3799->1681|3828->1682|3874->1700|3903->1701|3944->1714|3973->1715|4041->1755|4070->1756|4137->1787|4157->1798|4182->1801|4257->1840|4277->1851|4302->1854|4357->1881|4386->1882|4423->1892|4452->1893|4494->1907|4523->1908|4552->1909|4581->1910|4666->1959|4686->1970|4711->1973|4799->2025|4819->2036|4844->2039|4880->2048|4908->2049|4986->2091|5006->2102|5031->2105|5103->2142|5123->2153|5151->2159|5189->2162|5203->2168|5274->2230|5314->2232|5441->2328|5506->2357|5526->2368|5551->2371|5593->2378|5631->2407|5670->2408|5708->2411|5755->2436|5789->2439|5838->2453|5858->2464|5892->2476|5932->2485|6003->2521|6056->2565|6095->2566|6381->2821|6466->2874|6558->2937|6588->2938|6663->2984|6693->2985|6842->3105|6872->3106|6934->3139|6964->3140|7033->3181|7062->3182|7094->3186|7123->3187|7173->3209|7202->3210|7234->3214|7263->3215
                    LINES: 26->1|30->1|33->5|33->5|33->5|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|48->20|48->20|48->20|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|65->37|76->48|76->48|76->48|79->51|79->51|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|83->55|83->55|83->55|83->55|84->56|84->56|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|88->60|88->60|89->61|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|97->69|99->71|101->73|101->73|101->73|103->75|103->75|103->75|104->76|104->76|105->77|107->79|107->79|107->79|109->81|111->83|111->83|111->83|121->93|129->101|131->103|131->103|132->104|132->104|134->106|134->106|135->107|135->107|137->109|137->109|138->110|138->110|140->112|140->112|141->113|141->113
                    -- GENERATED --
                */
            