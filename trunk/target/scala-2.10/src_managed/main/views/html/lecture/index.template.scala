
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,List[Lecture],Form[Lecture],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courseId: Long , lectures: List[Lecture] , lectureForm: Form[Lecture]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.73*/("""
"""),format.raw/*3.1*/("""
<table>
<th>Lecture name</th>
<th>Description</th>
<th>File</th>
<th>Video</th>
<th></th>
"""),_display_(Seq[Any](/*10.2*/if(lectures!=null)/*10.20*/{_display_(Seq[Any](format.raw/*10.21*/("""
"""),_display_(Seq[Any](/*11.2*/for(lecture<-lectures) yield /*11.24*/{_display_(Seq[Any](format.raw/*11.25*/("""
<tr>
"""),_display_(Seq[Any](/*13.2*/form(routes.Lectures.deleteLecture(lecture.id))/*13.49*/{_display_(Seq[Any](format.raw/*13.50*/("""
<td><a href=""""),_display_(Seq[Any](/*14.15*/routes/*14.21*/.Lectures.lecturePage(lecture.id))),format.raw/*14.54*/("""">"""),_display_(Seq[Any](/*14.57*/lecture/*14.64*/.title)),format.raw/*14.70*/("""</a></td>
<td>"""),_display_(Seq[Any](/*15.6*/lecture/*15.13*/.content)),format.raw/*15.21*/("""</td>
<td>"""),_display_(Seq[Any](/*16.6*/lecture/*16.13*/.file)),format.raw/*16.18*/("""</td>
<td>"""),_display_(Seq[Any](/*17.6*/lecture/*17.13*/.video)),format.raw/*17.19*/("""</td>
<td><button type="submit">Delete</button></td>
""")))})),format.raw/*19.2*/("""
</tr>
""")))})),format.raw/*21.2*/("""
""")))})),format.raw/*22.2*/("""
</table>

<h2>Add a new lecture</h2>
"""),_display_(Seq[Any](/*26.2*/form(routes.Lectures.newLecture())/*26.36*/{_display_(Seq[Any](format.raw/*26.37*/("""
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
    
    def render(courseId:Long,lectures:List[Lecture],lectureForm:Form[Lecture]): play.api.templates.Html = apply(courseId,lectures,lectureForm)
    
    def f:((Long,List[Lecture],Form[Lecture]) => play.api.templates.Html) = (courseId,lectures,lectureForm) => apply(courseId,lectures,lectureForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 00:24:08 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/lecture/index.scala.html
                    HASH: a96f56f6976f6ff1cceb1e716aec758b6c74c2ff
                    MATRIX: 757->1|922->72|950->92|1084->191|1111->209|1150->210|1188->213|1226->235|1265->236|1309->245|1365->292|1404->293|1456->309|1471->315|1526->348|1565->351|1581->358|1609->364|1660->380|1676->387|1706->395|1753->407|1769->414|1796->419|1843->431|1859->438|1887->444|1974->500|2015->510|2049->513|2127->556|2170->590|2209->591
                    LINES: 26->1|30->1|31->3|38->10|38->10|38->10|39->11|39->11|39->11|41->13|41->13|41->13|42->14|42->14|42->14|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|47->19|49->21|50->22|54->26|54->26|54->26
                    -- GENERATED --
                */
            