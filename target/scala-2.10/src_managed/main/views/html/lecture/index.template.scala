
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Long,List[Lecture],Form[Lecture],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courseId: Long , lectures: List[Lecture] , lectureForm: Form[Lecture],user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.83*/("""
"""),_display_(Seq[Any](/*3.2*/main(user)/*3.12*/{_display_(Seq[Any](format.raw/*3.13*/("""
<table class="table table-bordered">
<th>Lecture name</th>
<th>Description</th>
<th></th>
"""),_display_(Seq[Any](/*8.2*/if(lectures!=null)/*8.20*/{_display_(Seq[Any](format.raw/*8.21*/("""
"""),_display_(Seq[Any](/*9.2*/for(lecture<-lectures) yield /*9.24*/{_display_(Seq[Any](format.raw/*9.25*/("""
<tr>
"""),_display_(Seq[Any](/*11.2*/form(routes.Lectures.deleteLecture(lecture.id))/*11.49*/{_display_(Seq[Any](format.raw/*11.50*/("""
<td><a href=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.Lectures.lecturePage(lecture.id))),format.raw/*12.54*/("""">"""),_display_(Seq[Any](/*12.57*/lecture/*12.64*/.title)),format.raw/*12.70*/("""</a></td>
<td>
<div class="description" >
"""),_display_(Seq[Any](/*15.2*/if(lecture.content!=null)/*15.27*/{_display_(Seq[Any](format.raw/*15.28*/("""
"""),_display_(Seq[Any](/*16.2*/Html(lecture.content))),format.raw/*16.23*/("""
""")))})),format.raw/*17.2*/("""
</div>
</td>

<td><button type="submit">Delete</button></td>
""")))})),format.raw/*22.2*/("""
</tr>
""")))})),format.raw/*24.2*/("""
""")))})),format.raw/*25.2*/("""
</table>

<h2>Add a new lecture</h2>
"""),_display_(Seq[Any](/*29.2*/form(routes.Lectures.newLecture())/*29.36*/{_display_(Seq[Any](format.raw/*29.37*/("""
<p>
<input type="text" name="title" placeholder="Name">
</p>
<p>
<textarea rows="10" cols="30" name="content" placeholder="Description"></textarea>
</p>
<p>
<button type="submit">Create</button>
</p>
""")))})),format.raw/*39.2*/("""
""")))})),format.raw/*40.2*/("""


"""))}
    }
    
    def render(courseId:Long,lectures:List[Lecture],lectureForm:Form[Lecture],user:User): play.api.templates.Html = apply(courseId,lectures,lectureForm,user)
    
    def f:((Long,List[Lecture],Form[Lecture],User) => play.api.templates.Html) = (courseId,lectures,lectureForm,user) => apply(courseId,lectures,lectureForm,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 17 19:12:25 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/lecture/index.scala.html
                    HASH: 2f7910e2d4c0eeb9b4efe18d3edf2a8e454eb60c
                    MATRIX: 762->1|937->82|974->103|992->113|1030->114|1161->211|1187->229|1225->230|1262->233|1299->255|1337->256|1381->265|1437->312|1476->313|1528->329|1543->335|1598->368|1637->371|1653->378|1681->384|1762->430|1796->455|1835->456|1873->459|1916->480|1950->483|2049->551|2090->561|2124->564|2202->607|2245->641|2284->642|2527->854|2561->857
                    LINES: 26->1|30->1|31->3|31->3|31->3|36->8|36->8|36->8|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|43->15|43->15|43->15|44->16|44->16|45->17|50->22|52->24|53->25|57->29|57->29|57->29|67->39|68->40
                    -- GENERATED --
                */
            