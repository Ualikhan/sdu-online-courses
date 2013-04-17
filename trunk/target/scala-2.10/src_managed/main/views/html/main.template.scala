
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
        <!-- 2. flowplayer -->
		<script src=""""),_display_(Seq[Any](/*12.17*/routes/*12.23*/.Assets.at("javascripts/flowplayer-5.4.0/flowplayer.js"))),format.raw/*12.79*/(""""></script>
		 
		<!-- 3. skin -->
		<link rel="stylesheet" type="text/css"
		   href=""""),_display_(Seq[Any](/*16.13*/routes/*16.19*/.Assets.at("javascripts/flowplayer-5.4.0/skin/minimalist.css"))),format.raw/*16.81*/("""" />
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*17.46*/routes/*17.52*/.Assets.at("stylesheets/js/bootstrap.js"))),format.raw/*17.93*/(""""></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*18.46*/routes/*18.52*/.Assets.at("stylesheets/js/bootstrap.min.js"))),format.raw/*18.97*/(""""></script>
         """),_display_(Seq[Any](/*19.11*/if(user!=null)/*19.25*/{_display_(Seq[Any](format.raw/*19.26*/("""
              <script type="text/javascript">
				$(document).ready(function() """),format.raw/*21.34*/("""{"""),format.raw/*21.35*/("""
					$('.dropdown-toggle').dropdown();
					 """),format.raw/*23.7*/("""}"""),format.raw/*23.8*/(""");
				</script>
				""")))})),format.raw/*25.6*/("""
        <script src=""""),_display_(Seq[Any](/*26.23*/routes/*26.29*/.Assets.at("javascripts/ckeditor/ckeditor.js"))),format.raw/*26.75*/(""""></script>
        <script type="text/javascript">
		/*	
        tinyMCE.init("""),format.raw/*29.22*/("""{"""),format.raw/*29.23*/("""
			        mode : "textareas"
			"""),format.raw/*31.4*/("""}"""),format.raw/*31.5*/(""");
		*/
		CKEDITOR.replace( 'editor1', """),format.raw/*33.32*/("""{"""),format.raw/*33.33*/("""
		    toolbar: 'Basic',
		    uiColor: '#9AB8F3'
		"""),format.raw/*36.3*/("""}"""),format.raw/*36.4*/(""");
		</script>
            
				
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*40.54*/routes/*40.60*/.Assets.at("stylesheets/main.css"))),format.raw/*40.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*41.59*/routes/*41.65*/.Assets.at("images/favicon.png"))),format.raw/*41.97*/("""">
         
        
    </head>
    <body>
     <header>
       

    </header>
    <div class="main">
 	<div class="header row">
 	<span class="logo">
    <a href=""""),_display_(Seq[Any](/*53.15*/routes/*53.21*/.Application.index)),format.raw/*53.39*/("""" id="logo" ><span>SDU Online Courses!</span></a>
    
    </span>
     <span class="user">
    """),_display_(Seq[Any](/*57.6*/if(user!=null)/*57.20*/{_display_(Seq[Any](format.raw/*57.21*/("""
   
       <div class="dropdown">
  <a class="dropdown-toggle" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="#">
    """),_display_(Seq[Any](/*61.6*/user/*61.10*/.name)),format.raw/*61.15*/("""
    <b class="caret"></b>
  </a>
  <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
     <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*65.56*/routes/*65.62*/.Users.pro())),format.raw/*65.74*/("""">Profile</a></li>
     <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*66.56*/routes/*66.62*/.Students.index())),format.raw/*66.79*/("""">My courses</a></li>
    <li role="presentation"><a role="menuitem" href=""""),_display_(Seq[Any](/*67.55*/routes/*67.61*/.Application.logout())),format.raw/*67.82*/("""">Logout</a></li>
  </ul>
</div>

""")))}/*71.2*/else/*71.6*/{_display_(Seq[Any](format.raw/*71.7*/("""
<a href=""""),_display_(Seq[Any](/*72.11*/routes/*72.17*/.Application.login)),format.raw/*72.35*/("""">Sign in</a>
""")))})),format.raw/*73.2*/("""
</span>
</div>
<div class="content">
      """),_display_(Seq[Any](/*77.8*/content)),format.raw/*77.15*/("""
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
                    DATE: Wed Apr 17 23:59:52 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/main.scala.html
                    HASH: a3d4180fcb329a5c5e75cc60aad5c50d6b0043de
                    MATRIX: 725->1|828->27|1011->175|1025->181|1090->224|1151->250|1165->256|1231->301|1347->381|1362->387|1415->418|1510->477|1525->483|1603->539|1727->627|1742->633|1826->695|1912->745|1927->751|1990->792|2083->849|2098->855|2165->900|2223->922|2246->936|2285->937|2393->1017|2422->1018|2495->1064|2523->1065|2576->1087|2635->1110|2650->1116|2718->1162|2825->1241|2854->1242|2915->1276|2943->1277|3010->1316|3039->1317|3118->1369|3146->1370|3268->1456|3283->1462|3339->1496|3436->1557|3451->1563|3505->1595|3709->1763|3724->1769|3764->1787|3896->1884|3919->1898|3958->1899|4137->2043|4150->2047|4177->2052|4368->2207|4383->2213|4417->2225|4527->2299|4542->2305|4581->2322|4693->2398|4708->2404|4751->2425|4804->2460|4816->2464|4854->2465|4901->2476|4916->2482|4956->2500|5002->2515|5082->2560|5111->2567
                    LINES: 26->1|29->1|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|40->12|40->12|40->12|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|49->21|49->21|51->23|51->23|53->25|54->26|54->26|54->26|57->29|57->29|59->31|59->31|61->33|61->33|64->36|64->36|68->40|68->40|68->40|69->41|69->41|69->41|81->53|81->53|81->53|85->57|85->57|85->57|89->61|89->61|89->61|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|99->71|99->71|99->71|100->72|100->72|100->72|101->73|105->77|105->77
                    -- GENERATED --
                */
            