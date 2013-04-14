
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
<p>"""),_display_(Seq[Any](/*6.5*/lecture/*6.12*/.content)),format.raw/*6.20*/("""</p>"""))}
    }
    
    def render(lecture:Lecture): play.api.templates.Html = apply(lecture)
    
    def f:((Lecture) => play.api.templates.Html) = (lecture) => apply(lecture)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 00:24:08 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/lecture/student/item.scala.html
                    HASH: 1caa6c05145b4b2d2bd83b7c4b631f87ef16adac
                    MATRIX: 739->1|851->19|881->41|922->48|937->55|964->61|1009->72|1024->79|1053->87
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            