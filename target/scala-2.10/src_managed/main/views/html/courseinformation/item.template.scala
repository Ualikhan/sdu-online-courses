
package views.html.courseinformation

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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[CourseInformation,Form[CourseInformation],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courseInformation: CourseInformation,courseInformationForm:Form[CourseInformation],user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.96*/("""

"""),_display_(Seq[Any](/*4.2*/main(user)/*4.12*/{_display_(Seq[Any](format.raw/*4.13*/("""
<h2>Edit courseInformation</h2>
"""),_display_(Seq[Any](/*6.2*/form(routes.CourseInformations.updateCourseInformation(courseInformation.id))/*6.79*/{_display_(Seq[Any](format.raw/*6.80*/("""
<p>
<input type="text" name="title" placeholder="Name" value=""""),_display_(Seq[Any](/*8.60*/courseInformation/*8.77*/.title)),format.raw/*8.83*/("""">
</p>
<p>
<textarea class="descriptionTextArea" rows="30" cols="60" name="content" placeholder="Description" >"""),_display_(Seq[Any](/*11.102*/courseInformation/*11.119*/.content)),format.raw/*11.127*/("""</textarea>
</p>
<p>
<button type="submit">Update</button><a href=""""),_display_(Seq[Any](/*14.48*/routes/*14.54*/.CourseInformations.index())),format.raw/*14.81*/("""">Cancel</button>
</p>
""")))})),format.raw/*16.2*/("""
""")))})))}
    }
    
    def render(courseInformation:CourseInformation,courseInformationForm:Form[CourseInformation],user:User): play.api.templates.Html = apply(courseInformation,courseInformationForm,user)
    
    def f:((CourseInformation,Form[CourseInformation],User) => play.api.templates.Html) = (courseInformation,courseInformationForm,user) => apply(courseInformation,courseInformationForm,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 23:41:16 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/courseinformation/item.scala.html
                    HASH: 05c6c6e2981db442329b9dd1b598504ec482ffe8
                    MATRIX: 780->1|968->95|1007->118|1025->128|1063->129|1133->165|1218->242|1256->243|1357->309|1382->326|1409->332|1562->448|1589->465|1620->473|1727->544|1742->550|1791->577|1848->603
                    LINES: 26->1|30->1|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|36->8|39->11|39->11|39->11|42->14|42->14|42->14|44->16
                    -- GENERATED --
                */
            