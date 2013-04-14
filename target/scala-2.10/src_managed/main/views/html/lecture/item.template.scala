
package views.html.lecture

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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Lecture,Form[Lecture],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(lecture: Lecture,lectureForm:Form[Lecture]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.46*/("""

"""),format.raw/*4.1*/("""
<h2>Edit lecture</h2>
"""),_display_(Seq[Any](/*6.2*/form(routes.Lectures.updateLecture(lecture.id))/*6.49*/{_display_(Seq[Any](format.raw/*6.50*/("""
<p>
<input type="text" name="name" placeholder="Name" value=""""),_display_(Seq[Any](/*8.59*/lecture/*8.66*/.title)),format.raw/*8.72*/("""">
</p>
<p>
<textarea rows="10" cols="30" name="description" placeholder="Description" >"""),_display_(Seq[Any](/*11.78*/lecture/*11.85*/.content)),format.raw/*11.93*/("""</textarea>
</p>
<p>
<button type="submit">Update</button><a href=""""),_display_(Seq[Any](/*14.48*/routes/*14.54*/.Lectures.index())),format.raw/*14.71*/("""">Cancel</button>
</p>
""")))})))}
    }
    
    def render(lecture:Lecture,lectureForm:Form[Lecture]): play.api.templates.Html = apply(lecture,lectureForm)
    
    def f:((Lecture,Form[Lecture]) => play.api.templates.Html) = (lecture,lectureForm) => apply(lecture,lectureForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 00:24:08 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/lecture/item.scala.html
                    HASH: 3bd4f3a3bc4539edff5fe2eb046079d8bf2df28b
                    MATRIX: 745->1|883->45|913->67|973->93|1028->140|1066->141|1166->206|1181->213|1208->219|1336->311|1352->318|1382->326|1489->397|1504->403|1543->420
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|36->8|36->8|36->8|39->11|39->11|39->11|42->14|42->14|42->14
                    -- GENERATED --
                */
            