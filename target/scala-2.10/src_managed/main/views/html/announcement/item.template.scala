
package views.html.announcement

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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Announcement,Form[Announcement],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(announcement: Announcement,announcementForm:Form[Announcement]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.66*/("""

"""),format.raw/*4.1*/("""
<h2>Edit announcement</h2>
"""),_display_(Seq[Any](/*6.2*/form(routes.Announcements.updateAnnouncement(announcement.id))/*6.64*/{_display_(Seq[Any](format.raw/*6.65*/("""
<p>
<input type="text" name="name" placeholder="Name" value=""""),_display_(Seq[Any](/*8.59*/announcement/*8.71*/.title)),format.raw/*8.77*/("""">
</p>
<p>
<textarea rows="10" cols="30" name="description" placeholder="Description" >"""),_display_(Seq[Any](/*11.78*/announcement/*11.90*/.content)),format.raw/*11.98*/("""</textarea>
</p>
<p>
<button type="submit">Update</button><a href=""""),_display_(Seq[Any](/*14.48*/routes/*14.54*/.Announcements.index())),format.raw/*14.76*/("""">Cancel</button>
</p>
""")))})))}
    }
    
    def render(announcement:Announcement,announcementForm:Form[Announcement]): play.api.templates.Html = apply(announcement,announcementForm)
    
    def f:((Announcement,Form[Announcement]) => play.api.templates.Html) = (announcement,announcementForm) => apply(announcement,announcementForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 00:24:07 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/announcement/item.scala.html
                    HASH: aa7e356cea19cf95f5b451c1da950fa77ca936df
                    MATRIX: 760->1|918->65|948->87|1013->118|1083->180|1121->181|1221->246|1241->258|1268->264|1396->356|1417->368|1447->376|1554->447|1569->453|1613->475
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|36->8|36->8|36->8|39->11|39->11|39->11|42->14|42->14|42->14
                    -- GENERATED --
                */
            