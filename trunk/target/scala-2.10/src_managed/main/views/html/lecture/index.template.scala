
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
<td>
<div class="description" >
"""),_display_(Seq[Any](/*17.2*/if(lecture.content!=null)/*17.27*/{_display_(Seq[Any](format.raw/*17.28*/("""
"""),_display_(Seq[Any](/*18.2*/Html(lecture.content))),format.raw/*18.23*/("""
""")))})),format.raw/*19.2*/("""
</div>
</td>
<td>"""),_display_(Seq[Any](/*22.6*/lecture/*22.13*/.file)),format.raw/*22.18*/("""</td>
<td>"""),_display_(Seq[Any](/*23.6*/lecture/*23.13*/.video)),format.raw/*23.19*/("""</td>
<td><button type="submit">Delete</button></td>
""")))})),format.raw/*25.2*/("""
</tr>
""")))})),format.raw/*27.2*/("""
""")))})),format.raw/*28.2*/("""
</table>

<h2>Add a new lecture</h2>
"""),_display_(Seq[Any](/*32.2*/form(routes.Lectures.newLecture())/*32.36*/{_display_(Seq[Any](format.raw/*32.37*/("""
<p>
<input type="text" name="title" placeholder="Name">
</p>
<p>
<textarea rows="10" cols="30" name="content" placeholder="Description"></textarea>
</p>
<p>
<button type="submit">Create</button>
</p>
""")))})),format.raw/*42.2*/("""
""")))})),format.raw/*43.2*/("""


"""))}
    }
    
    def render(courseId:Long,lectures:List[Lecture],lectureForm:Form[Lecture],user:User): play.api.templates.Html = apply(courseId,lectures,lectureForm,user)
    
    def f:((Long,List[Lecture],Form[Lecture],User) => play.api.templates.Html) = (courseId,lectures,lectureForm,user) => apply(courseId,lectures,lectureForm,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 23:33:23 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/lecture/index.scala.html
                    HASH: c2c3c12cd6c0592ee025a7853a8487eb72f70b76
                    MATRIX: 762->1|937->82|974->103|992->113|1030->114|1164->213|1191->231|1230->232|1268->235|1306->257|1345->258|1389->267|1445->314|1484->315|1536->331|1551->337|1606->370|1645->373|1661->380|1689->386|1770->432|1804->457|1843->458|1881->461|1924->482|1958->485|2015->507|2031->514|2058->519|2105->531|2121->538|2149->544|2236->600|2277->610|2311->613|2389->656|2432->690|2471->691|2714->903|2748->906
                    LINES: 26->1|30->1|31->3|31->3|31->3|38->10|38->10|38->10|39->11|39->11|39->11|41->13|41->13|41->13|42->14|42->14|42->14|42->14|42->14|42->14|45->17|45->17|45->17|46->18|46->18|47->19|50->22|50->22|50->22|51->23|51->23|51->23|53->25|55->27|56->28|60->32|60->32|60->32|70->42|71->43
                    -- GENERATED --
                */
            