import sbt._
import Keys._
import com.github.siasia.WebPlugin.webSettings

object AliasBuild extends Build {
  lazy val root = Project("root", file(".")) aggregate(web)
  lazy val web = Project("web", file("web"),
    settings = Defaults.defaultSettings ++ webSettings ++ Seq(
      libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "7.3.0.v20110203" % "jetty"
    ))
  /*
   An alias should work like so:
   alias jr = ; project web ; jetty-run ; project root
   */
}
