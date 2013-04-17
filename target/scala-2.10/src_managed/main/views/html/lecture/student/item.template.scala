
package views.html.lecture.student

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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Lecture,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(lecture: Lecture):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.20*/("""

"""),format.raw/*4.1*/("""
<h3>"""),_display_(Seq[Any](/*5.6*/lecture/*5.13*/.title)),format.raw/*5.19*/("""</h3>
<p>
"""),_display_(Seq[Any](/*7.2*/if(lecture.content!=null)/*7.27*/{_display_(Seq[Any](format.raw/*7.28*/("""
"""),_display_(Seq[Any](/*8.2*/Html(lecture.content))),format.raw/*8.23*/("""
""")))})),format.raw/*9.2*/("""
</p>
<iframe class="videoDiv" width="420" height="345"
src="">
</iframe>"""))}
    }
    
    def render(lecture:Lecture): play.api.templates.Html = apply(lecture)
    
    def f:((Lecture) => play.api.templates.Html) = (lecture) => apply(lecture)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 17 19:12:25 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/lecture/student/item.scala.html
                    HASH: 7cfad8706727ab8ac00d78b3013e7aac4b7df35c
                    MATRIX: 739->1|851->19|881->41|922->48|937->55|964->61|1011->74|1044->99|1082->100|1119->103|1161->124|1194->127
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|37->9
                    -- GENERATED --
                */
            