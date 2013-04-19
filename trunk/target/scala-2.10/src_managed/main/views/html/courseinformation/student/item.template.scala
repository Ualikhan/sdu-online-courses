
package views.html.courseinformation.student

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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[CourseInformation,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courseInformation: CourseInformation):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.40*/("""

"""),format.raw/*4.1*/("""
<h3>"""),_display_(Seq[Any](/*5.6*/courseInformation/*5.23*/.title)),format.raw/*5.29*/("""</h3>
<p>
"""),_display_(Seq[Any](/*7.2*/if(courseInformation.content!=null)/*7.37*/{_display_(Seq[Any](format.raw/*7.38*/("""
"""),_display_(Seq[Any](/*8.2*/Html(courseInformation.content))),format.raw/*8.33*/("""
""")))})),format.raw/*9.2*/("""
</p>"""))}
    }
    
    def render(courseInformation:CourseInformation): play.api.templates.Html = apply(courseInformation)
    
    def f:((CourseInformation) => play.api.templates.Html) = (courseInformation) => apply(courseInformation)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Apr 19 11:38:52 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/courseinformation/student/item.scala.html
                    HASH: 573850f584b269c6b4596b0adc8b3523b219f1b2
                    MATRIX: 759->1|891->39|921->61|962->68|987->85|1014->91|1061->104|1104->139|1142->140|1179->143|1231->174|1264->177
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|37->9
                    -- GENERATED --
                */
            