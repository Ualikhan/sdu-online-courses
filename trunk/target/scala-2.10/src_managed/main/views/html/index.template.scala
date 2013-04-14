
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Course],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(courses: List[Course],user:User):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.35*/("""
"""),format.raw/*3.1*/("""

"""),_display_(Seq[Any](/*5.2*/main(user)/*5.12*/{_display_(Seq[Any](format.raw/*5.13*/("""

 	
 	
 	 """),_display_(Seq[Any](/*9.5*/courses/*9.12*/.map/*9.16*/ { task =>_display_(Seq[Any](format.raw/*9.26*/("""
 	 <div class="container-fluid courseCell">
       <div class="row-fluid">
    <div class="span2">
      
    </div>
    <div class="span4">
  							<h3><a href=""""),_display_(Seq[Any](/*16.24*/routes/*16.30*/.Courses.courseDescription(task.id))),format.raw/*16.65*/(""""" >"""),_display_(Seq[Any](/*16.70*/task/*16.74*/.name)),format.raw/*16.79*/("""</a></h3>
  							<span class="instructorName textGray">"""),_display_(Seq[Any](/*17.49*/task/*17.53*/.owner.name)),format.raw/*17.64*/("""</span>
  		</div>				
  							<div class="span4">
  							<p>"""),_display_(Seq[Any](/*20.14*/task/*20.18*/.description)),format.raw/*20.30*/("""</p>
  							</div>
  							</div>
                           
                           </div>
                        """)))})),format.raw/*25.26*/("""
                        
 """)))})))}
    }
    
    def render(courses:List[Course],user:User): play.api.templates.Html = apply(courses,user)
    
    def f:((List[Course],User) => play.api.templates.Html) = (courses,user) => apply(courses,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 15 00:24:07 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/index.scala.html
                    HASH: 540a3124999121b4ce3899aec7262473ff8fc9d7
                    MATRIX: 734->1|860->34|887->52|924->55|942->65|980->66|1026->78|1041->85|1053->89|1100->99|1301->264|1316->270|1373->305|1414->310|1427->314|1454->319|1548->377|1561->381|1594->392|1695->457|1708->461|1742->473|1898->597
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|37->9|37->9|37->9|37->9|44->16|44->16|44->16|44->16|44->16|44->16|45->17|45->17|45->17|48->20|48->20|48->20|53->25
                    -- GENERATED --
                */
            