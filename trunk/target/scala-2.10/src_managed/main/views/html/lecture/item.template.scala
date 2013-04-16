
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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Lecture,Form[Lecture],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(lecture: Lecture,lectureForm:Form[Lecture],user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.56*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(user)/*5.12*/{_display_(Seq[Any](format.raw/*5.13*/("""
<h2>Edit lecture</h2>
"""),_display_(Seq[Any](/*7.2*/form(routes.Lectures.updateLecture(lecture.id))/*7.49*/{_display_(Seq[Any](format.raw/*7.50*/("""
<p>
<input type="text" name="title" placeholder="Name" value=""""),_display_(Seq[Any](/*9.60*/lecture/*9.67*/.title)),format.raw/*9.73*/("""">
</p>
<p>
<textarea rows="10" cols="30" name="content" placeholder="Description" >"""),_display_(Seq[Any](/*12.74*/lecture/*12.81*/.content)),format.raw/*12.89*/("""</textarea>
</p>
<p>
<input type="text" name="video" placeholder="Video" value=""""),_display_(Seq[Any](/*15.61*/lecture/*15.68*/.video)),format.raw/*15.74*/("""">
</p>
<p>
<button type="submit">Update</button><a href=""""),_display_(Seq[Any](/*18.48*/routes/*18.54*/.Lectures.index())),format.raw/*18.71*/("""">Cancel</button>
</p>
""")))})),format.raw/*20.2*/("""
""")))})))}
    }
    
    def render(lecture:Lecture,lectureForm:Form[Lecture],user:User): play.api.templates.Html = apply(lecture,lectureForm,user)
    
    def f:((Lecture,Form[Lecture],User) => play.api.templates.Html) = (lecture,lectureForm,user) => apply(lecture,lectureForm,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 20:54:14 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/lecture/item.scala.html
                    HASH: f8072bb8d75b59a6f939a59487e58290aec806cc
                    MATRIX: 750->1|898->55|928->77|965->80|983->90|1021->91|1081->117|1136->164|1174->165|1275->231|1290->238|1317->244|1441->332|1457->339|1487->347|1607->431|1623->438|1651->444|1749->506|1764->512|1803->529|1860->555
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|40->12|40->12|40->12|43->15|43->15|43->15|46->18|46->18|46->18|48->20
                    -- GENERATED --
                */
            