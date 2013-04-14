
package views.html

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
object user2 extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[Course],List[Course],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courses: List[Course], scourses: List[Course], user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.60*/("""
"""),format.raw/*3.1*/("""

"""),_display_(Seq[Any](/*5.2*/main(user)/*5.12*/{_display_(Seq[Any](format.raw/*5.13*/("""

<div class="content">
 	<h1>All</h1>
 	<ul>
 	 """),_display_(Seq[Any](/*10.5*/courses/*10.12*/.map/*10.16*/ { task =>_display_(Seq[Any](format.raw/*10.26*/("""
                           <li>"""),_display_(Seq[Any](/*11.33*/task/*11.37*/.name)),format.raw/*11.42*/("""
                            """),_display_(Seq[Any](/*12.30*/form(routes.Courses.join(task.id))/*12.64*/ {_display_(Seq[Any](format.raw/*12.66*/("""
<p>
<input type="submit" placeholder="Join" >
</p>
""")))})),format.raw/*16.2*/("""
                           </li>
                        """)))})),format.raw/*18.26*/("""
 	</ul>
 	<h1>Student</h1>
 	<ul>
 	 """),_display_(Seq[Any](/*22.5*/scourses/*22.13*/.map/*22.17*/ { task =>_display_(Seq[Any](format.raw/*22.27*/("""
                           <li>"""),_display_(Seq[Any](/*23.33*/task/*23.37*/.name)),format.raw/*23.42*/("""</li>
                        """)))})),format.raw/*24.26*/("""
 	</ul>
 	</div>
 	
 """)))})))}
    }
    
    def render(courses:List[Course],scourses:List[Course],user:User): play.api.templates.Html = apply(courses,scourses,user)
    
    def f:((List[Course],List[Course],User) => play.api.templates.Html) = (courses,scourses,user) => apply(courses,scourses,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 00:24:07 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/user2.scala.html
                    HASH: a5ef71ff193e31ec5d3e017ecba43bc2fa9c4598
                    MATRIX: 747->1|899->59|927->79|966->84|984->94|1022->95|1112->150|1128->157|1141->161|1189->171|1259->205|1272->209|1299->214|1366->245|1409->279|1449->281|1537->338|1630->399|1708->442|1725->450|1738->454|1786->464|1856->498|1869->502|1896->507|1960->539
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|44->16|46->18|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24
                    -- GENERATED --
                */
            