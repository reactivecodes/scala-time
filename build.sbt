import org.scalastyle.sbt.{PluginKeys => StylePluginKeys, ScalastylePlugin}


lazy val scalaTime = project.in(file("."))


version := "0.1.0-SNAPSHOT"

organization := "codes.reactive"

description := "Basic Scala wrapper for easier use of JDK 1.8.0 (JSR-310) time libraries."

startYear := Some(2014)

homepage := Some(url("https://github.com/reactivecodes/scala-time"))

scmInfo := Some(ScmInfo(
  url("https://github.com/reactivecodes/scala-time"),
  "scm:git:git@github.com:reactivecodes/scala-time.git",
  Some("scm:git:git@github.com:reactivecodes/scala-time.git")))

apacheLicensed

publishOSS

scalaVersion := "2.11.1"

crossScalaVersions := Seq("2.11.1", "2.10.4")

libraryDependencies += scalaTest

codesCompileOpts

scalacOptions in (Compile, compile) += "-language:postfixOps"

unmanagedSourceDirectories in Compile += (sourceDirectory in Compile).value / s"scala_${scalaBinaryVersion.value}"

developers := Some(Seq(Developer("Ali Salim Rashid", "arashi01")))

ScalastylePlugin.Settings

StylePluginKeys.config <<= baseDirectory(_ / "project/scalastyle-config.xml")

def scalaTest = "org.scalatest" %% "scalatest" % "2.1.5" % "test"

