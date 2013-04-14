
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,List[Announcement],Form[Announcement],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courseId: Long , announcements: List[Announcement] , announcementForm: Form[Announcement]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.93*/("""
"""),format.raw/*3.1*/("""
<table>
<th>Announcement name</th>
<th>Description</th>
<th>Date</th>
<th></th>
"""),_display_(Seq[Any](/*9.2*/if(announcements!=null)/*9.25*/{_display_(Seq[Any](format.raw/*9.26*/("""
"""),_display_(Seq[Any](/*10.2*/for(announcement<-announcements) yield /*10.34*/{_display_(Seq[Any](format.raw/*10.35*/("""
<tr>
"""),_display_(Seq[Any](/*12.2*/form(routes.Announcements.deleteAnnouncement(announcement.id))/*12.64*/{_display_(Seq[Any](format.raw/*12.65*/("""
<td><a href=""""),_display_(Seq[Any](/*13.15*/routes/*13.21*/.Announcements.announcementPage(announcement.id))),format.raw/*13.69*/("""">"""),_display_(Seq[Any](/*13.72*/announcement/*13.84*/.title)),format.raw/*13.90*/("""</a></td>
<td>"""),_display_(Seq[Any](/*14.6*/announcement/*14.18*/.content)),format.raw/*14.26*/("""</td>
<td>"""),_display_(Seq[Any](/*15.6*/announcement/*15.18*/.createdDate)),format.raw/*15.30*/("""</td>
<td><button type="submit">Delete</button></td>
""")))})),format.raw/*17.2*/("""
</tr>
""")))})),format.raw/*19.2*/("""
""")))})),format.raw/*20.2*/("""
</table>

<h2>Add a new announcement</h2>
"""),_display_(Seq[Any](/*24.2*/form(routes.Announcements.newAnnouncement())/*24.46*/{_display_(Seq[Any](format.raw/*24.47*/("""
<p>
<input type="text" name="title" placeholder="Name">
</p>
<p>
<textarea rows="10" cols="30" name="content" placeholder="Description"></textarea>
</p>
<p>
<button type="submit">Create</button>
</p>
""")))})))}
    }
    
    def render(courseId:Long,announcements:List[Announcement],announcementForm:Form[Announcement]): play.api.templates.Html = apply(courseId,announcements,announcementForm)
    
    def f:((Long,List[Announcement],Form[Announcement]) => play.api.templates.Html) = (courseId,announcements,announcementForm) => apply(courseId,announcements,announcementForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 00:24:07 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/announcement/index.scala.html
                    HASH: 064d30fb1e321c05485e9bbbdd194b239050e987
                    MATRIX: 772->1|957->92|985->112|1107->200|1138->223|1176->224|1214->227|1262->259|1301->260|1345->269|1416->331|1455->332|1507->348|1522->354|1592->402|1631->405|1652->417|1680->423|1731->439|1752->451|1782->459|1829->471|1850->483|1884->495|1971->551|2012->561|2046->564|2129->612|2182->656|2221->657
                    LINES: 26->1|30->1|31->3|37->9|37->9|37->9|38->10|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|45->17|47->19|48->20|52->24|52->24|52->24
                    -- GENERATED --
                */
            