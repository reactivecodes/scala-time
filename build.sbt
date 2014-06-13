import org.scalastyle.sbt.{PluginKeys => StylePluginKeys, ScalastylePlugin}


lazy val scalaTime = project.in(file("."))
  .sbsSettings

version := "0.1.0-SNAPSHOT"

description := "Basic Scala wrapper for easier use of JDK 1.8.0 (JSR-310) time libraries."

startYear := Some(2014)

homepage := Some(url("https://github.com/sbsproperties/scala-time"))

scmInfo := Some(ScmInfo(
  url("https://github.com/sbsproperties/scala-time"),
  "scm:git:git@github.com:sbsproperties/scala-time.git",
  Some("scm:git:git@github.com:sbsproperties/scala-time.git")))

sbsOss := true

licenses := Seq(("Apache License, Version 2.0", url("http://www.apache.org/licenses/LICENSE-2.0.txt")))

scalaVersion := "2.11.1"

crossScalaVersions := Seq("2.11.1", "2.10.4")

libraryDependencies += scalaTest

scalacOptions in (Compile, compile) += "-language:postfixOps"

sources in(Compile, doc) ~= (_.filter(!_.name.contains("BuildInfo")))

unmanagedSourceDirectories in Compile += (sourceDirectory in Compile).value / s"scala_${scalaBinaryVersion.value}"

pomExtra <<= pomExtra(_ ++ developers)

ScalastylePlugin.Settings

StylePluginKeys.config <<= baseDirectory(_ / "project/scalastyle-config.xml")

def scalaTest = "org.scalatest" %% "scalatest" % "2.1.5" % "test"

def developers = {
  val developers = Map(
    "arashi01" -> "Ali Salim Rashid"
  )
    <developers>
      {developers map { m =>
      <developer>
        <id>{m._1}</id>
        <name>{m._2}</name>
        <url>http://github.com/{m._1}</url>
      </developer>
      }}
    </developers>
}

