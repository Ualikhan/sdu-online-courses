
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
object register extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Application.Register],play.api.templates.Html] {

    /**/
    def apply/*1.3*/(form:Form[Application.Register]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.36*/("""
 """),_display_(Seq[Any](/*2.3*/main(null)/*2.13*/{_display_(Seq[Any](format.raw/*2.14*/("""
 <div class="row">
  <div class="span4"></div>
  <div class="span4">
  
 <ul class="nav nav-tabs">
  <li class="active">
    <a href=""""),_display_(Seq[Any](/*9.15*/routes/*9.21*/.Application.register)),format.raw/*9.42*/("""">Sign up</a>
  </li>
  <li><a href=""""),_display_(Seq[Any](/*11.17*/routes/*11.23*/.Application.login)),format.raw/*11.41*/("""">Sign in</a></li>
</ul>

 """),_display_(Seq[Any](/*14.3*/helper/*14.9*/.form(routes.Application.register)/*14.43*/ {_display_(Seq[Any](format.raw/*14.45*/("""
       
<h1>Sign up</h1>
  """),_display_(Seq[Any](/*17.4*/if(form.hasGlobalErrors)/*17.28*/ {_display_(Seq[Any](format.raw/*17.30*/(""" 
                <p class="error">
                    """),_display_(Seq[Any](/*19.22*/form/*19.26*/.globalError.message)),format.raw/*19.46*/("""
                </p>
   """)))})),format.raw/*21.5*/("""

<p>
<input type="text" name="name" placeholder="Name" value=""""),_display_(Seq[Any](/*24.59*/form("name")/*24.71*/.value)),format.raw/*24.77*/("""" />
</p>            
<p>
<input type="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*27.62*/form("email")/*27.75*/.value)),format.raw/*27.81*/("""" />
</p>
<p>
<input type="password" name="password" placeholder="Password"/>
</p>
<p>
<input type="password" name="password2" placeholder="Confirm password"/>
</p>

<p>
<button type="submit" >Register</button>
<a href=""""),_display_(Seq[Any](/*38.11*/routes/*38.17*/.Application.login)),format.raw/*38.35*/("""">Sign in</a>
</p>
""")))})),format.raw/*40.2*/("""
</div>
</div>
""")))})))}
    }
    
    def render(form:Form[Application.Register]): play.api.templates.Html = apply(form)
    
    def f:((Form[Application.Register]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 17 22:13:00 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/register.scala.html
                    HASH: f42aaf7e53e02eacb60443bc08453b2a82066498
                    MATRIX: 746->2|856->35|894->39|912->49|950->50|1128->193|1142->199|1184->220|1260->260|1275->266|1315->284|1381->315|1395->321|1438->355|1478->357|1545->389|1578->413|1618->415|1713->474|1726->478|1768->498|1827->526|1930->593|1951->605|1979->611|2105->701|2127->714|2155->720|2423->952|2438->958|2478->976|2531->998
                    LINES: 26->1|29->1|30->2|30->2|30->2|37->9|37->9|37->9|39->11|39->11|39->11|42->14|42->14|42->14|42->14|45->17|45->17|45->17|47->19|47->19|47->19|49->21|52->24|52->24|52->24|55->27|55->27|55->27|66->38|66->38|66->38|68->40
                    -- GENERATED --
                */
            