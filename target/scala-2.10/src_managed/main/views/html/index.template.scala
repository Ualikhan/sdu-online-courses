
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

 	
 	
 	 """),_display_(Seq[Any](/*9.5*/courses/*9.12*/.map/*9.16*/ { course =>_display_(Seq[Any](format.raw/*9.28*/("""
<div class="row courseCell">
 	 <div class="span3"></div>
 	 <div class="span7">
       <div class="row-fluid">
 		<h3><a href=""""),_display_(Seq[Any](/*14.18*/routes/*14.24*/.Courses.courseDescription(course.id))),format.raw/*14.61*/(""""" >"""),_display_(Seq[Any](/*14.66*/course/*14.72*/.name)),format.raw/*14.77*/("""</a></h3>					
 		</div>
 		<div class="row-fluid" style="margin-bottom:10px;margin-top:-5px;">
 		<span class="instructorName textGray">
 		
 		"""),_display_(Seq[Any](/*19.5*/course/*19.11*/.owner.name)),format.raw/*19.22*/("""
 		"""),_display_(Seq[Any](/*20.5*/if(course.owner.position!=null)/*20.36*/{_display_(Seq[Any](format.raw/*20.37*/("""
 		:"""),_display_(Seq[Any](/*21.6*/course/*21.12*/.owner.position)),format.raw/*21.27*/("""
 		""")))})),format.raw/*22.5*/("""
 		"""),_display_(Seq[Any](/*23.5*/if(course.owner.company!=null)/*23.35*/{_display_(Seq[Any](format.raw/*23.36*/("""
 		,"""),_display_(Seq[Any](/*24.6*/course/*24.12*/.owner.company)),format.raw/*24.26*/("""
 		""")))})),format.raw/*25.5*/("""
 		
 		</span>				
 		</div>
 		<div class="row-fluid courseSummary">
 		<p>"""),_display_(Seq[Any](/*30.8*/course/*30.14*/.description)),format.raw/*30.26*/("""</p>			
 		</div>
  		</div>
</div>
                        """)))})),format.raw/*34.26*/("""
                        
 """)))})))}
    }
    
    def render(courses:List[Course],user:User): play.api.templates.Html = apply(courses,user)
    
    def f:((List[Course],User) => play.api.templates.Html) = (courses,user) => apply(courses,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Apr 19 12:11:09 ALMT 2013
                    SOURCE: D:/sdu-online-courses/app/views/index.scala.html
                    HASH: 107e12f8beccb2187fde1127605029297e86c8f6
                    MATRIX: 734->1|860->34|887->52|924->55|942->65|980->66|1026->78|1041->85|1053->89|1102->101|1268->231|1283->237|1342->274|1383->279|1398->285|1425->290|1606->436|1621->442|1654->453|1694->458|1734->489|1773->490|1814->496|1829->502|1866->517|1902->522|1942->527|1981->557|2020->558|2061->564|2076->570|2112->584|2148->589|2261->667|2276->673|2310->685|2403->746
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|37->9|37->9|37->9|37->9|42->14|42->14|42->14|42->14|42->14|42->14|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|58->30|58->30|58->30|62->34
                    -- GENERATED --
                */
            