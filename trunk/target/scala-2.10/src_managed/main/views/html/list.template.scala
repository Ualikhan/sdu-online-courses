
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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[User],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(users:List[User]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.20*/("""

"""),format.raw/*4.1*/("""
<ul>
"""),_display_(Seq[Any](/*6.2*/for(user<-users) yield /*6.18*/{_display_(Seq[Any](format.raw/*6.19*/("""
<li>
"""),_display_(Seq[Any](/*8.2*/user/*8.6*/.name)),format.raw/*8.11*/("""
"""),_display_(Seq[Any](/*9.2*/user/*9.6*/.email)),format.raw/*9.12*/("""
 """),_display_(Seq[Any](/*10.3*/user/*10.7*/.password)),format.raw/*10.16*/("""
  """),_display_(Seq[Any](/*11.4*/user/*11.8*/.role.name)),format.raw/*11.18*/("""
</li>
""")))})),format.raw/*13.2*/("""
</ul>"""))}
    }
    
    def render(users:List[User]): play.api.templates.Html = apply(users)
    
    def f:((List[User]) => play.api.templates.Html) = (users) => apply(users)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 17 22:12:59 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/list.scala.html
                    HASH: bea4c7efb4b2489a4e009ba84b8aef01d2c0a65e
                    MATRIX: 726->1|838->19|868->41|911->50|942->66|980->67|1023->76|1034->80|1060->85|1097->88|1108->92|1135->98|1174->102|1186->106|1217->115|1257->120|1269->124|1301->134|1342->144
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|41->13
                    -- GENERATED --
                */
            