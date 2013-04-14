
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
             """),_display_(Seq[Any](/*13.15*/if(user!=null)/*13.29*/{_display_(Seq[Any](format.raw/*13.30*/("""
              <script type="text/javascript">
				$(document).ready(function() """),format.raw/*15.34*/("""{"""),format.raw/*15.35*/("""
					$('.dropdown-toggle').dropdown();
					 """),format.raw/*17.7*/("""}"""),format.raw/*17.8*/(""");
				</script>
				""")))})),format.raw/*19.6*/("""
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*20.54*/routes/*20.60*/.Assets.at("stylesheets/main.css"))),format.raw/*20.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*21.59*/routes/*21.65*/.Assets.at("images/favicon.png"))),format.raw/*21.97*/("""">
        
        
    </head>
    <body>
     <header>
       

    </header>
    <div class="main">
 	<div class="header row">
 	<span class="logo">
    <a href=""""),_display_(Seq[Any](/*33.15*/routes/*33.21*/.Application.index)),format.raw/*33.39*/("""" id="logo" ><span>SDU Online Courses!</span></a>
    
    </span>
     <span class="user">
    """),_display_(Seq[Any](/*37.6*/if(user!=null)/*37.20*/{_display_(Seq[Any](format.raw/*37.21*/("""
   
       <div class="dropdown">
  <a class="dropdown-toggle" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="#">
    """),_display_(Seq[Any](/*41.6*/user/*41.10*/.name)),format.raw/*41.15*/("""
    <b class="caret"></b>
  </a>
  <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
     <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*45.56*/routes/*45.62*/.Users.pro())),format.raw/*45.74*/("""">Profile</a></li>
     <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*46.56*/routes/*46.62*/.Students.index())),format.raw/*46.79*/("""">My courses</a></li>
    <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*47.55*/routes/*47.61*/.Application.logout())),format.raw/*47.82*/("""">Logout</a></li>
  </ul>
</div>

""")))}/*51.2*/else/*51.6*/{_display_(Seq[Any](format.raw/*51.7*/("""
<a href=""""),_display_(Seq[Any](/*52.11*/routes/*52.17*/.Application.login)),format.raw/*52.35*/("""">Sign in</a>
""")))})),format.raw/*53.2*/("""
</span>
</div>
<div class="content">
      """),_display_(Seq[Any](/*57.8*/content)),format.raw/*57.15*/("""
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
                    DATE: Mon Apr 15 00:24:07 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/main.scala.html
                    HASH: b0dde5d90c9715a78be354b0b0d59f18cfc2c745
                    MATRIX: 725->1|828->27|1011->175|1025->181|1090->224|1151->250|1165->256|1231->301|1347->381|1362->387|1415->418|1508->475|1523->481|1586->522|1679->579|1694->585|1761->630|1823->656|1846->670|1885->671|1993->751|2022->752|2095->798|2123->799|2176->821|2266->875|2281->881|2337->915|2434->976|2449->982|2503->1014|2706->1181|2721->1187|2761->1205|2893->1302|2916->1316|2955->1317|3134->1461|3147->1465|3174->1470|3365->1625|3380->1631|3414->1643|3524->1717|3539->1723|3578->1740|3690->1816|3705->1822|3748->1843|3801->1878|3813->1882|3851->1883|3898->1894|3913->1900|3953->1918|3999->1933|4079->1978|4108->1985
                    LINES: 26->1|29->1|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|43->15|43->15|45->17|45->17|47->19|48->20|48->20|48->20|49->21|49->21|49->21|61->33|61->33|61->33|65->37|65->37|65->37|69->41|69->41|69->41|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|79->51|79->51|79->51|80->52|80->52|80->52|81->53|85->57|85->57
                    -- GENERATED --
                */
            