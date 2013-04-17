
package views.html.user

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
object profile extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Form[User],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user:User,userForm:Form[User]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.33*/("""
"""),format.raw/*3.1*/("""
<img src=""""),_display_(Seq[Any](/*4.12*/routes/*4.18*/.Assets.at("uploadImages/"+{user.photo}))),format.raw/*4.58*/("""" width="60px" height="60px" >
 """),_display_(Seq[Any](/*5.3*/form(routes.Users.editUser)/*5.30*/ {_display_(Seq[Any](format.raw/*5.32*/("""
<p>
<input type="text" name="name" placeholder="Name"  value=""""),_display_(Seq[Any](/*7.60*/user/*7.64*/.name)),format.raw/*7.69*/("""">
</p>
<p>
<input type="text" name="company" placeholder="Company"  value=""""),_display_(Seq[Any](/*10.66*/user/*10.70*/.company)),format.raw/*10.78*/("""">
</p>
<p>
<input type="text" name="position" placeholder="Position"  value=""""),_display_(Seq[Any](/*13.68*/user/*13.72*/.position)),format.raw/*13.81*/("""">
</p>
<p>
<input type="submit" placeholder="Save changes" >
</p>
""")))})),format.raw/*18.2*/("""
"""),_display_(Seq[Any](/*19.2*/user/*19.6*/.email)),format.raw/*19.12*/("""

 """),_display_(Seq[Any](/*21.3*/form(routes.Users.changePassword)/*21.36*/ {_display_(Seq[Any](format.raw/*21.38*/("""
<p>
<input type="password" placeholder="Password" name="password" >
</p>
<p>
<input type="password" placeholder="Confirm password" name="password2" >
</p>
<p>
<input type="submit" placeholder="Save changes" >
</p>
""")))})),format.raw/*31.2*/("""
"""))}
    }
    
    def render(user:User,userForm:Form[User]): play.api.templates.Html = apply(user,userForm)
    
    def f:((User,Form[User]) => play.api.templates.Html) = (user,userForm) => apply(user,userForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 17 22:13:01 ALMT 2013
                    SOURCE: D:/Programming/Eclipse Projects/sdu-online-courses/app/views/user/profile.scala.html
                    HASH: 65158e2b26e8c0861436aa282089cab784bf9e5e
                    MATRIX: 739->1|864->32|892->52|940->65|954->71|1015->111|1083->145|1118->172|1157->174|1258->240|1270->244|1296->249|1412->329|1425->333|1455->341|1573->423|1586->427|1617->436|1721->509|1759->512|1771->516|1799->522|1840->528|1882->561|1922->563|2179->789
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|35->7|35->7|35->7|38->10|38->10|38->10|41->13|41->13|41->13|46->18|47->19|47->19|47->19|49->21|49->21|49->21|59->31
                    -- GENERATED --
                */
            