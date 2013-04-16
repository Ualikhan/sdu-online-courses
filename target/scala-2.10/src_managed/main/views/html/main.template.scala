
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
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*20.46*/routes/*20.52*/.Assets.at("javascripts/tiny_mce/tiny_mce.js"))),format.raw/*20.98*/(""""></script>
        <script type="text/javascript">
			tinyMCE.init("""),format.raw/*22.17*/("""{"""),format.raw/*22.18*/("""
			        mode : "textareas"
			"""),format.raw/*24.4*/("""}"""),format.raw/*24.5*/(""");
		</script>
            
				
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*28.54*/routes/*28.60*/.Assets.at("stylesheets/main.css"))),format.raw/*28.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*29.59*/routes/*29.65*/.Assets.at("images/favicon.png"))),format.raw/*29.97*/("""">
        
        
    </head>
    <body>
     <header>
       

    </header>
    <div class="main">
 	<div class="header row">
 	<span class="logo">
    <a href=""""),_display_(Seq[Any](/*41.15*/routes/*41.21*/.Application.index)),format.raw/*41.39*/("""" id="logo" ><span>SDU Online Courses!</span></a>
    
    </span>
     <span class="user">
    """),_display_(Seq[Any](/*45.6*/if(user!=null)/*45.20*/{_display_(Seq[Any](format.raw/*45.21*/("""
   
       <div class="dropdown">
  <a class="dropdown-toggle" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="#">
    """),_display_(Seq[Any](/*49.6*/user/*49.10*/.name)),format.raw/*49.15*/("""
    <b class="caret"></b>
  </a>
  <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
     <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*53.56*/routes/*53.62*/.Users.pro())),format.raw/*53.74*/("""">Profile</a></li>
     <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*54.56*/routes/*54.62*/.Students.index())),format.raw/*54.79*/("""">My courses</a></li>
    <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*55.55*/routes/*55.61*/.Application.logout())),format.raw/*55.82*/("""">Logout</a></li>
  </ul>
</div>

""")))}/*59.2*/else/*59.6*/{_display_(Seq[Any](format.raw/*59.7*/("""
<a href=""""),_display_(Seq[Any](/*60.11*/routes/*60.17*/.Application.login)),format.raw/*60.35*/("""">Sign in</a>
""")))})),format.raw/*61.2*/("""
</span>
</div>
<div class="content">
      """),_display_(Seq[Any](/*65.8*/content)),format.raw/*65.15*/("""
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
                    DATE: Mon Apr 15 23:08:40 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/main.scala.html
                    HASH: 4c0076e0c9f168287f9914cce6f2283e88fcc6c6
                    MATRIX: 725->1|828->27|1011->175|1025->181|1090->224|1151->250|1165->256|1231->301|1347->381|1362->387|1415->418|1508->475|1523->481|1586->522|1679->579|1694->585|1761->630|1819->652|1842->666|1881->667|1989->747|2018->748|2091->794|2119->795|2172->817|2254->863|2269->869|2337->915|2433->983|2462->984|2523->1018|2551->1019|2673->1105|2688->1111|2744->1145|2841->1206|2856->1212|2910->1244|3113->1411|3128->1417|3168->1435|3300->1532|3323->1546|3362->1547|3541->1691|3554->1695|3581->1700|3772->1855|3787->1861|3821->1873|3931->1947|3946->1953|3985->1970|4097->2046|4112->2052|4155->2073|4208->2108|4220->2112|4258->2113|4305->2124|4320->2130|4360->2148|4406->2163|4486->2208|4515->2215
                    LINES: 26->1|29->1|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|43->15|43->15|45->17|45->17|47->19|48->20|48->20|48->20|50->22|50->22|52->24|52->24|56->28|56->28|56->28|57->29|57->29|57->29|69->41|69->41|69->41|73->45|73->45|73->45|77->49|77->49|77->49|81->53|81->53|81->53|82->54|82->54|82->54|83->55|83->55|83->55|87->59|87->59|87->59|88->60|88->60|88->60|89->61|93->65|93->65
                    -- GENERATED --
                */
            