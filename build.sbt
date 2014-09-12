import org.scalastyle.sbt.{PluginKeys => StylePluginKeys, ScalastylePlugin}


val jdkVersion = settingKey[String]("Revision of the JDK used to build this project.")

lazy val scalaTime = project.in(file("."))
  .enablePlugins(CodesOsgi)
  .configs(Fmpp)

name <<= (name, jdkVersion)((n, v) => matchJava(v, s"$n Threeten", n))

site.settings

ghpages.settings

fmppSettings

version := "0.1.0-SNAPSHOT"

organization := "codes.reactive"

description := "Basic Scala wrapper for easier use of JDK 1.8.0 (JSR-310) or Threeten BP time libraries."

startYear := Some(2014)

homepage := Some(url("https://oss.reactive.codes/scala-time"))

apiURL := Some(url(s"http://oss.reactive.codes/scala-time/${version.value}/"))

apacheLicensed

publishOSS

jdkVersion := System.getProperty("java.specification.version")

scalaVersion := crossScalaVersions.value.head

crossScalaVersions := Seq("2.11.2", "2.10.4")

libraryDependencies ++= {
  def dependencies = Seq(scalaTest)
  def j7Dependencies = threeten +: dependencies
  matchJava(jdkVersion.value, j7Dependencies, dependencies )
}

codesCompileOpts

codesDocOpts

codesUnidocOpts

scalacOptions in (Compile, compile) += "-language:postfixOps"

unmanagedSourceDirectories in Compile += (sourceDirectory in Compile).value / s"jdk_${jdkVersion.value}"

unmanagedSourceDirectories in Test += (sourceDirectory in Test).value / s"jdk_${jdkVersion.value}"

codesDevelopers := Some(Seq(Developer("Ali Salim Rashid", "arashi01")))

OsgiKeys.bundleSymbolicName := "codes.reactive.scalatime"

OsgiKeys.bundleSymbolicName := {
  import OsgiKeys.{bundleSymbolicName => n}
  matchJava(jdkVersion.value, s"${n.value}-threeten", n.value) }

OsgiKeys.bundleRequiredExecutionEnvironment := matchJava(jdkVersion.value, Seq("JavaSE-1.7"), Seq("JavaSE-1.8"))

OsgiKeys.privatePackage := Seq("codes.reactive.scalatime*")

OsgiKeys.exportPackage := Seq("codes.reactive.scalatime*")

ScalastylePlugin.Settings

StylePluginKeys.config <<= baseDirectory(_ / "project/scalastyle-config.xml")

SiteKeys.siteMappings := Seq(baseDirectory.value / "project/site.html" -> "index.html")

SiteKeys.siteMappings <++= (mappings in (ScalaUnidoc, packageDoc), version) map {(m,v) =>
  for ((f, d) <- m) yield (f, s"$v/$d") }

git.remoteRepo := codesGithubRepo.value.developerConnection.drop(8)

def scalaTest = "org.scalatest" %% "scalatest" % "2.1.5" % "test"

def threeten = "org.threeten" % "threetenbp" % "1.0"

fmppArgs ++= Seq(
  s"-DtPac:${matchJava(jdkVersion.value, "org.threeten.bp", "java.time")}," +
    s"tDoc:${matchJava(jdkVersion.value, "www.threeten.org/threetenbp/apidocs/org/threeten/bp",
    "docs.oracle.com/javase/8/docs/api/java/time")}"
)

def matchJava[A](v: String, jdk7: => A, other: => A) = v.takeRight(1).toInt match {
  case 7 => jdk7
  case x if x > 7 => other
  case _ => sys.error("Java JDK version not supported. Use JDK 1.7 (Java 7) or greater.")
}

