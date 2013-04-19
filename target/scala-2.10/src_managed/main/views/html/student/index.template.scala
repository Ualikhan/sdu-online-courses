
package views.html.student

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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Course],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(scourses: List[Course],user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.36*/("""
"""),format.raw/*3.1*/("""

"""),_display_(Seq[Any](/*5.2*/main(user)/*5.12*/{_display_(Seq[Any](format.raw/*5.13*/("""
   
 	 """),_display_(Seq[Any](/*7.5*/scourses/*7.13*/.map/*7.17*/ { task =>_display_(Seq[Any](format.raw/*7.27*/("""
 	 						<div class="container-fluid courseCell">
  <div class="row-fluid">
    <div class="span2">
      
    </div>
    <div class="span4">
   
      <h3>"""),_display_(Seq[Any](/*15.12*/task/*15.16*/.name)),format.raw/*15.21*/("""</h3>
      <span class="instructorName textGray">"""),_display_(Seq[Any](/*16.46*/task/*16.50*/.owner.name)),format.raw/*16.61*/("""</span>
      </div>
               <div class="span4">            
                           """),_display_(Seq[Any](/*19.29*/form(routes.Courses.coursePage(task.id))/*19.69*/ {_display_(Seq[Any](format.raw/*19.71*/("""
                           <button type="submit" class="btn btn-primary btn-medium courceCellButton">Go to class</button>
                          
							""")))})),format.raw/*22.9*/("""
			    </div>
			  </div>
			</div>   
                        """)))})),format.raw/*26.26*/("""
 	
 """)))})))}
    }
    
    def render(scourses:List[Course],user:User): play.api.templates.Html = apply(scourses,user)
    
    def f:((List[Course],User) => play.api.templates.Html) = (scourses,user) => apply(scourses,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Apr 19 11:38:53 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/student/index.scala.html
                    HASH: 016dbbfdb39cd9bb02f8d932fe5cd0cf2fec600d
                    MATRIX: 742->1|870->35|898->55|937->60|955->70|993->71|1038->82|1054->90|1066->94|1113->104|1315->270|1328->274|1355->279|1443->331|1456->335|1489->346|1624->445|1673->485|1713->487|1905->648|2006->717
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|35->7|43->15|43->15|43->15|44->16|44->16|44->16|47->19|47->19|47->19|50->22|54->26
                    -- GENERATED --
                */
            