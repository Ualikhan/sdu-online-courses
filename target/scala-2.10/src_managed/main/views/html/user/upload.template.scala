
package views.html.user

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
object upload extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*2.1*/("""
"""),_display_(Seq[Any](/*3.2*/form(action = routes.Users.profile, 'enctype -> "multipart/form-data")/*3.72*/ {_display_(Seq[Any](format.raw/*3.74*/("""
    
    <input type="file" name="photo">
    
    <p>
        <input type="submit">
    </p>
    
""")))})))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 17 22:13:01 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/user/upload.scala.html
                    HASH: 78b1872d2330357f6a370fe980123bfdc34ff796
                    MATRIX: 810->18|847->21|925->91|964->93
                    LINES: 30->2|31->3|31->3|31->3
                    -- GENERATED --
                */
            