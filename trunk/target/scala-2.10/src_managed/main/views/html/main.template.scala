
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
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/jquery.jeditable.js"))),format.raw/*10.74*/("""" type="text/javascript"></script>
        
        <script type="text/javascript" src='"""),_display_(Seq[Any](/*12.46*/routes/*12.52*/.Application.javascriptRoutes())),format.raw/*12.83*/("""'></script>
        <!-- 2. flowplayer -->
		<script src=""""),_display_(Seq[Any](/*14.17*/routes/*14.23*/.Assets.at("javascripts/flowplayer-5.4.0/flowplayer.js"))),format.raw/*14.79*/(""""></script>
		 
		<!-- 3. skin -->
		<link rel="stylesheet" type="text/css"
		   href=""""),_display_(Seq[Any](/*18.13*/routes/*18.19*/.Assets.at("javascripts/flowplayer-5.4.0/skin/minimalist.css"))),format.raw/*18.81*/("""" />
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*19.46*/routes/*19.52*/.Assets.at("stylesheets/js/bootstrap.js"))),format.raw/*19.93*/(""""></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*20.46*/routes/*20.52*/.Assets.at("stylesheets/js/bootstrap.min.js"))),format.raw/*20.97*/(""""></script>
         """),_display_(Seq[Any](/*21.11*/if(user!=null)/*21.25*/{_display_(Seq[Any](format.raw/*21.26*/("""
              <script type="text/javascript">
				$(document).ready(function() """),format.raw/*23.34*/("""{"""),format.raw/*23.35*/("""
					$('.dropdown-toggle').dropdown();
					 """),format.raw/*25.7*/("""}"""),format.raw/*25.8*/(""");
				</script>
				""")))})),format.raw/*27.6*/("""
        <script src=""""),_display_(Seq[Any](/*28.23*/routes/*28.29*/.Assets.at("javascripts/ckeditor/ckeditor.js"))),format.raw/*28.75*/(""""></script>
        <script type="text/javascript">
		/*	
        tinyMCE.init("""),format.raw/*31.22*/("""{"""),format.raw/*31.23*/("""
			        mode : "textareas"
			"""),format.raw/*33.4*/("""}"""),format.raw/*33.5*/(""");
		*/
		CKEDITOR.replace( 'editor1', """),format.raw/*35.32*/("""{"""),format.raw/*35.33*/("""
		    toolbar: 'Basic',
		    uiColor: '#9AB8F3'
		"""),format.raw/*38.3*/("""}"""),format.raw/*38.4*/(""");
		</script>
            
				
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*42.54*/routes/*42.60*/.Assets.at("stylesheets/main.css"))),format.raw/*42.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*43.59*/routes/*43.65*/.Assets.at("images/favicon.png"))),format.raw/*43.97*/("""">
         
        
    </head>
    <body>
     <header>
       

    </header>
    <div class="main">
 	<div class="header row">
 	<span class="logo">
    <a href=""""),_display_(Seq[Any](/*55.15*/routes/*55.21*/.Application.index)),format.raw/*55.39*/("""" id="logo" ><span>SDU Online Courses!</span></a>
    
    </span>
     <span class="user">
    """),_display_(Seq[Any](/*59.6*/if(user!=null)/*59.20*/{_display_(Seq[Any](format.raw/*59.21*/("""
   
       <div class="dropdown">
  <a class="dropdown-toggle" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="#">
    """),_display_(Seq[Any](/*63.6*/user/*63.10*/.name)),format.raw/*63.15*/("""
    <b class="caret"></b>
  </a>
  <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
     <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*67.56*/routes/*67.62*/.Users.pro())),format.raw/*67.74*/("""">Profile</a></li>
     <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*68.56*/routes/*68.62*/.Students.index())),format.raw/*68.79*/("""">My courses</a></li>
    <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*69.55*/routes/*69.61*/.Application.logout())),format.raw/*69.82*/("""">Logout</a></li>
  </ul>
</div>

""")))}/*73.2*/else/*73.6*/{_display_(Seq[Any](format.raw/*73.7*/("""
<a href=""""),_display_(Seq[Any](/*74.11*/routes/*74.17*/.Application.login)),format.raw/*74.35*/("""">Sign in</a>
""")))})),format.raw/*75.2*/("""
</span>
</div>
<div class="content">
      """),_display_(Seq[Any](/*79.8*/content)),format.raw/*79.15*/("""
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
                    DATE: Fri Apr 19 11:38:52 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/main.scala.html
                    HASH: 45680e638bc79bd97fc0c3f353c3f963b227b99c
                    MATRIX: 725->1|828->27|1011->175|1025->181|1090->224|1151->250|1165->256|1231->301|1324->358|1339->364|1406->409|1531->498|1546->504|1599->535|1694->594|1709->600|1787->656|1911->744|1926->750|2010->812|2096->862|2111->868|2174->909|2267->966|2282->972|2349->1017|2407->1039|2430->1053|2469->1054|2577->1134|2606->1135|2679->1181|2707->1182|2760->1204|2819->1227|2834->1233|2902->1279|3009->1358|3038->1359|3099->1393|3127->1394|3194->1433|3223->1434|3302->1486|3330->1487|3452->1573|3467->1579|3523->1613|3620->1674|3635->1680|3689->1712|3893->1880|3908->1886|3948->1904|4080->2001|4103->2015|4142->2016|4321->2160|4334->2164|4361->2169|4552->2324|4567->2330|4601->2342|4711->2416|4726->2422|4765->2439|4877->2515|4892->2521|4935->2542|4988->2577|5000->2581|5038->2582|5085->2593|5100->2599|5140->2617|5186->2632|5266->2677|5295->2684
                    LINES: 26->1|29->1|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|40->12|40->12|40->12|42->14|42->14|42->14|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|51->23|51->23|53->25|53->25|55->27|56->28|56->28|56->28|59->31|59->31|61->33|61->33|63->35|63->35|66->38|66->38|70->42|70->42|70->42|71->43|71->43|71->43|83->55|83->55|83->55|87->59|87->59|87->59|91->63|91->63|91->63|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|101->73|101->73|101->73|102->74|102->74|102->74|103->75|107->79|107->79
                    -- GENERATED --
                */
            