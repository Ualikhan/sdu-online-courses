
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
object login extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Application.Login],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(form:Form[Application.Login]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),_display_(Seq[Any](/*3.2*/main(null)/*3.12*/{_display_(Seq[Any](format.raw/*3.13*/("""
<div class="row">
  <div class="span4"></div>
  <div class="span4">
  
 <ul class="nav nav-tabs">
  <li class="active">
  <a href=""""),_display_(Seq[Any](/*10.13*/routes/*10.19*/.Application.login)),format.raw/*10.37*/("""">Sign in</a>
  </li>
  <li> <a href=""""),_display_(Seq[Any](/*12.18*/routes/*12.24*/.Application.register)),format.raw/*12.45*/("""">Sign up</a></li>
</ul>

  
 
 """),_display_(Seq[Any](/*17.3*/helper/*17.9*/.form(routes.Application.authenticate)/*17.47*/ {_display_(Seq[Any](format.raw/*17.49*/("""
       
<h1>Sign in</h1>
  """),_display_(Seq[Any](/*20.4*/if(form.hasGlobalErrors)/*20.28*/ {_display_(Seq[Any](format.raw/*20.30*/(""" 
                <p class="error">
                    """),_display_(Seq[Any](/*22.22*/form/*22.26*/.globalError.message)),format.raw/*22.46*/("""
                </p>
            """)))})),format.raw/*24.14*/("""
<p>
<input type="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*26.62*/form("email")/*26.75*/.value)),format.raw/*26.81*/("""" />
</p>
<p>
<input type="password" name="password" placeholder="Password"/>
</p>
<p>
<button type="submit" >Login</button>
<a href=""""),_display_(Seq[Any](/*33.11*/routes/*33.17*/.Application.register)),format.raw/*33.38*/("""">Sign up</a>
</p>
""")))})),format.raw/*35.2*/("""
 </div>
</div>
""")))})))}
    }
    
    def render(form:Form[Application.Login]): play.api.templates.Html = apply(form)
    
    def f:((Form[Application.Login]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 00:24:07 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/login.scala.html
                    HASH: 388733559ae7d1c150dbb2e3f5e44e8dea4e386d
                    MATRIX: 740->1|847->31|886->36|904->46|942->47|1118->187|1133->193|1173->211|1250->252|1265->258|1308->279|1381->317|1395->323|1442->361|1482->363|1549->395|1582->419|1622->421|1717->480|1730->484|1772->504|1841->541|1945->609|1967->622|1995->628|2173->770|2188->776|2231->797|2284->819
                    LINES: 26->1|29->1|31->3|31->3|31->3|38->10|38->10|38->10|40->12|40->12|40->12|45->17|45->17|45->17|45->17|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|61->33|61->33|61->33|63->35
                    -- GENERATED --
                */
            