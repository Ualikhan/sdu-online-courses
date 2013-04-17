
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Long,List[Announcement],Form[Announcement],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courseId: Long , announcements: List[Announcement] , announcementForm: Form[Announcement],user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.103*/("""
"""),_display_(Seq[Any](/*3.2*/main(user)/*3.12*/{_display_(Seq[Any](format.raw/*3.13*/("""
<table class="table table-bordered">
<th>Announcement name</th>
<th>Description</th>
<th>Date</th>
<th></th>
"""),_display_(Seq[Any](/*9.2*/if(announcements!=null)/*9.25*/{_display_(Seq[Any](format.raw/*9.26*/("""
"""),_display_(Seq[Any](/*10.2*/for(announcement<-announcements) yield /*10.34*/{_display_(Seq[Any](format.raw/*10.35*/("""
<tr>
"""),_display_(Seq[Any](/*12.2*/form(routes.Announcements.deleteAnnouncement(announcement.id))/*12.64*/{_display_(Seq[Any](format.raw/*12.65*/("""
<td><a href=""""),_display_(Seq[Any](/*13.15*/routes/*13.21*/.Announcements.announcementPage(announcement.id))),format.raw/*13.69*/("""">"""),_display_(Seq[Any](/*13.72*/announcement/*13.84*/.title)),format.raw/*13.90*/("""</a></td>
<td>
<div class="description">
"""),_display_(Seq[Any](/*16.2*/if(announcement.content!=null)/*16.32*/{_display_(Seq[Any](format.raw/*16.33*/("""
"""),_display_(Seq[Any](/*17.2*/Html(announcement.content))),format.raw/*17.28*/("""
""")))})),format.raw/*18.2*/("""
</div>
</td>
<td>"""),_display_(Seq[Any](/*21.6*/announcement/*21.18*/.createdDate)),format.raw/*21.30*/("""</td>
<td><button type="submit">Delete</button></td>
""")))})),format.raw/*23.2*/("""
</tr>
""")))})),format.raw/*25.2*/("""
""")))})),format.raw/*26.2*/("""
</table>

<h2>Add a new announcement</h2>
"""),_display_(Seq[Any](/*30.2*/form(routes.Announcements.newAnnouncement())/*30.46*/{_display_(Seq[Any](format.raw/*30.47*/("""
<p>
<input type="text" name="title" placeholder="Name">
</p>
<p>
<textarea class="ckeditor"  rows="10" cols="30" name="content" placeholder="Description"></textarea>
</p>
<p>
<button type="submit">Create</button>
</p>
""")))})),format.raw/*40.2*/("""
""")))})),format.raw/*41.2*/("""

 <script type="text/javascript">
				$(document).ready(function() """),format.raw/*44.34*/("""{"""),format.raw/*44.35*/("""
					$('.cont').hide();
					 """),format.raw/*46.7*/("""}"""),format.raw/*46.8*/(""");
				$('.more').on('click', function() """),format.raw/*47.39*/("""{"""),format.raw/*47.40*/("""
					var id=$(this).attr('href');
					$('span[name='+id+']').show();
				"""),format.raw/*50.5*/("""}"""),format.raw/*50.6*/("""
</script>"""))}
    }
    
    def render(courseId:Long,announcements:List[Announcement],announcementForm:Form[Announcement],user:User): play.api.templates.Html = apply(courseId,announcements,announcementForm,user)
    
    def f:((Long,List[Announcement],Form[Announcement],User) => play.api.templates.Html) = (courseId,announcements,announcementForm,user) => apply(courseId,announcements,announcementForm,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 17 22:13:00 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/announcement/index.scala.html
                    HASH: 949307da811c619a707b1280a255f7bff7dd983c
                    MATRIX: 777->1|973->102|1010->123|1028->133|1066->134|1217->251|1248->274|1286->275|1324->278|1372->310|1411->311|1455->320|1526->382|1565->383|1617->399|1632->405|1702->453|1741->456|1762->468|1790->474|1870->519|1909->549|1948->550|1986->553|2034->579|2068->582|2125->604|2146->616|2180->628|2267->684|2308->694|2342->697|2425->745|2478->789|2517->790|2778->1020|2812->1023|2911->1094|2940->1095|3000->1128|3028->1129|3098->1171|3127->1172|3232->1250|3260->1251
                    LINES: 26->1|30->1|31->3|31->3|31->3|37->9|37->9|37->9|38->10|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|41->13|41->13|41->13|44->16|44->16|44->16|45->17|45->17|46->18|49->21|49->21|49->21|51->23|53->25|54->26|58->30|58->30|58->30|68->40|69->41|72->44|72->44|74->46|74->46|75->47|75->47|78->50|78->50
                    -- GENERATED --
                */
            