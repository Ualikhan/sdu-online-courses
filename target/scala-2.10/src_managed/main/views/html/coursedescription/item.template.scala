
package views.html.coursedescription

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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[CourseDescription,Form[CourseDescription],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courseDescription: CourseDescription,courseDescriptionForm:Form[CourseDescription],user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.96*/("""

"""),_display_(Seq[Any](/*4.2*/main(user)/*4.12*/{_display_(Seq[Any](format.raw/*4.13*/("""
<h2>Edit courseDescription</h2>
"""),_display_(Seq[Any](/*6.2*/form(routes.CourseDescriptions.updateCourseDescription(courseDescription.id))/*6.79*/{_display_(Seq[Any](format.raw/*6.80*/("""
<p>
<input type="text" name="title" placeholder="Name" value=""""),_display_(Seq[Any](/*8.60*/courseDescription/*8.77*/.title)),format.raw/*8.83*/("""">
</p>
<p>
<textarea class="descriptionTextArea ckeditor" rows="30" cols="60" name="content" placeholder="Description" >"""),_display_(Seq[Any](/*11.111*/courseDescription/*11.128*/.content)),format.raw/*11.136*/("""</textarea>
</p>
<p>
<button type="submit">Update</button><a href=""""),_display_(Seq[Any](/*14.48*/routes/*14.54*/.CourseDescriptions.index())),format.raw/*14.81*/("""">Cancel</button>
</p>
""")))})),format.raw/*16.2*/("""
""")))})))}
    }
    
    def render(courseDescription:CourseDescription,courseDescriptionForm:Form[CourseDescription],user:User): play.api.templates.Html = apply(courseDescription,courseDescriptionForm,user)
    
    def f:((CourseDescription,Form[CourseDescription],User) => play.api.templates.Html) = (courseDescription,courseDescriptionForm,user) => apply(courseDescription,courseDescriptionForm,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Apr 19 11:38:52 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/coursedescription/item.scala.html
                    HASH: b1c0a2df145f244bd0c30e80a37693e55627c67c
                    MATRIX: 780->1|968->95|1007->118|1025->128|1063->129|1133->165|1218->242|1256->243|1357->309|1382->326|1409->332|1571->457|1598->474|1629->482|1736->553|1751->559|1800->586|1857->612
                    LINES: 26->1|30->1|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|36->8|39->11|39->11|39->11|42->14|42->14|42->14|44->16
                    -- GENERATED --
                */
            