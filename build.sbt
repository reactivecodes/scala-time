import org.scalastyle.sbt.{PluginKeys => StylePluginKeys, ScalastylePlugin}


lazy val scalaTime = project.in(file("."))

site.settings

ghpages.settings

version := "0.1.0-SNAPSHOT"

organization := "codes.reactive"

description := "Basic Scala wrapper for easier use of JDK 1.8.0 (JSR-310) time libraries."

startYear := Some(2014)

homepage := Some(url("https://oss.reactive.codes/scala-time"))

apiURL := Some(url(s"http://oss.reactive.codes/scala-time/${version.value}/"))

apacheLicensed

publishOSS

scalaVersion := "2.11.1"

crossScalaVersions := Seq("2.11.1", "2.10.4")

libraryDependencies += scalaTest

codesCompileOpts

codesDocOpts

codesUnidocOpts

scalacOptions in (Compile, compile) += "-language:postfixOps"

unmanagedSourceDirectories in Compile += (sourceDirectory in Compile).value / s"scala_${scalaBinaryVersion.value}"

codesDevelopers := Some(Seq(Developer("Ali Salim Rashid", "arashi01")))

ScalastylePlugin.Settings

StylePluginKeys.config <<= baseDirectory(_ / "project/scalastyle-config.xml")

SiteKeys.siteMappings := Seq(baseDirectory.value / "project/site.html" -> "index.html")

SiteKeys.siteMappings <++= (mappings in (ScalaUnidoc, packageDoc), version) map {(m,v) =>
        for ((f, d) <- m) yield (f, s"$v/$d") }

git.remoteRepo := codesGithubRepo.value.developerConnection.drop(8)

def scalaTest = "org.scalatest" %% "scalatest" % "2.1.5" % "test"

