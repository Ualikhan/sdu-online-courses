import sbt._
import Keys._
import play.Project._
import com.github.play2war.plugin._

object ApplicationBuild extends Build {

  val appName         = "Online_Courses"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "mysql" % "mysql-connector-java" % "5.1.10",
    "commons-io" % "commons-io" % "2.3",
    "org.imgscalr" % "imgscalr-lib" % "4.2"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    Play2WarKeys.servletVersion := "2.5",
      resolvers ++= Seq(
 "The Buzz Media Maven Repository" at "http://maven.thebuzzmedia.com"
 )
).settings(Play2WarPlugin.play2WarSettings: _*)

}