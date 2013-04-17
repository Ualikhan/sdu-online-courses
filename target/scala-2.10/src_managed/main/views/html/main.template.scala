
package views.html

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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user:User)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.28*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>SDU Online Courses</title>
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*8.70*/routes/*8.76*/.Assets.at("stylesheets/css/bootstrap.css"))),format.raw/*8.119*/(""""> 
        <script src=""""),_display_(Seq[Any](/*9.23*/routes/*9.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*9.74*/("""" type="text/javascript"></script>
        <script type="text/javascript" src='"""),_display_(Seq[Any](/*10.46*/routes/*10.52*/.Application.javascriptRoutes())),format.raw/*10.83*/("""'></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*11.46*/routes/*11.52*/.Assets.at("stylesheets/js/bootstrap.js"))),format.raw/*11.93*/(""""></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*12.46*/routes/*12.52*/.Assets.at("stylesheets/js/bootstrap.min.js"))),format.raw/*12.97*/(""""></script>
         """),_display_(Seq[Any](/*13.11*/if(user!=null)/*13.25*/{_display_(Seq[Any](format.raw/*13.26*/("""
              <script type="text/javascript">
				$(document).ready(function() """),format.raw/*15.34*/("""{"""),format.raw/*15.35*/("""
					$('.dropdown-toggle').dropdown();
					 """),format.raw/*17.7*/("""}"""),format.raw/*17.8*/(""");
				</script>
				""")))})),format.raw/*19.6*/("""
        <script src=""""),_display_(Seq[Any](/*20.23*/routes/*20.29*/.Assets.at("javascripts/ckeditor/ckeditor.js"))),format.raw/*20.75*/(""""></script>
        <script type="text/javascript">
		/*	
        tinyMCE.init("""),format.raw/*23.22*/("""{"""),format.raw/*23.23*/("""
			        mode : "textareas"
			"""),format.raw/*25.4*/("""}"""),format.raw/*25.5*/(""");
		*/
		CKEDITOR.replace( 'editor1', """),format.raw/*27.32*/("""{"""),format.raw/*27.33*/("""
		    toolbar: 'Basic',
		    uiColor: '#9AB8F3'
		"""),format.raw/*30.3*/("""}"""),format.raw/*30.4*/(""");
		</script>
            
				
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*34.54*/routes/*34.60*/.Assets.at("stylesheets/main.css"))),format.raw/*34.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*35.59*/routes/*35.65*/.Assets.at("images/favicon.png"))),format.raw/*35.97*/("""">
         
        
    </head>
    <body>
     <header>
       

    </header>
    <div class="main">
 	<div class="header row">
 	<span class="logo">
    <a href=""""),_display_(Seq[Any](/*47.15*/routes/*47.21*/.Application.index)),format.raw/*47.39*/("""" id="logo" ><span>SDU Online Courses!</span></a>
    
    </span>
     <span class="user">
    """),_display_(Seq[Any](/*51.6*/if(user!=null)/*51.20*/{_display_(Seq[Any](format.raw/*51.21*/("""
   
       <div class="dropdown">
  <a class="dropdown-toggle" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="#">
    """),_display_(Seq[Any](/*55.6*/user/*55.10*/.name)),format.raw/*55.15*/("""
    <b class="caret"></b>
  </a>
  <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
     <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*59.56*/routes/*59.62*/.Users.pro())),format.raw/*59.74*/("""">Profile</a></li>
     <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*60.56*/routes/*60.62*/.Students.index())),format.raw/*60.79*/("""">My courses</a></li>
    <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*61.55*/routes/*61.61*/.Application.logout())),format.raw/*61.82*/("""">Logout</a></li>
  </ul>
</div>

""")))}/*65.2*/else/*65.6*/{_display_(Seq[Any](format.raw/*65.7*/("""
<a href=""""),_display_(Seq[Any](/*66.11*/routes/*66.17*/.Application.login)),format.raw/*66.35*/("""">Sign in</a>
""")))})),format.raw/*67.2*/("""
</span>
</div>
<div class="content">
      """),_display_(Seq[Any](/*71.8*/content)),format.raw/*71.15*/("""
</div>
</div>
     <footer>
     <div class="container-fluid" style="height: ">
  <div class="row-fluid">
  <div class="span5"></div>
    <div class="span4">
     SDU 2013
     </div>
     </div>
     </div>
     </footer>
    </body>
</html>

"""))}
    }
    
    def render(user:User,content:Html): play.api.templates.Html = apply(user)(content)
    
    def f:((User) => (Html) => play.api.templates.Html) = (user) => (content) => apply(user)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 17 19:12:25 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/main.scala.html
                    HASH: 2b7b867378cbcfd3e7959cc4e7d48bd982983c12
                    MATRIX: 725->1|828->27|1011->175|1025->181|1090->224|1151->250|1165->256|1231->301|1347->381|1362->387|1415->418|1508->475|1523->481|1586->522|1679->579|1694->585|1761->630|1819->652|1842->666|1881->667|1989->747|2018->748|2091->794|2119->795|2172->817|2231->840|2246->846|2314->892|2421->971|2450->972|2511->1006|2539->1007|2606->1046|2635->1047|2714->1099|2742->1100|2864->1186|2879->1192|2935->1226|3032->1287|3047->1293|3101->1325|3305->1493|3320->1499|3360->1517|3492->1614|3515->1628|3554->1629|3733->1773|3746->1777|3773->1782|3964->1937|3979->1943|4013->1955|4123->2029|4138->2035|4177->2052|4289->2128|4304->2134|4347->2155|4400->2190|4412->2194|4450->2195|4497->2206|4512->2212|4552->2230|4598->2245|4678->2290|4707->2297
                    LINES: 26->1|29->1|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|43->15|43->15|45->17|45->17|47->19|48->20|48->20|48->20|51->23|51->23|53->25|53->25|55->27|55->27|58->30|58->30|62->34|62->34|62->34|63->35|63->35|63->35|75->47|75->47|75->47|79->51|79->51|79->51|83->55|83->55|83->55|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|93->65|93->65|93->65|94->66|94->66|94->66|95->67|99->71|99->71
                    -- GENERATED --
                */
            