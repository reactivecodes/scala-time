lazy val scalaTime = (project in file("."))
  .enablePlugins(SbtCodesOsgi)


site.settings

ghpages.settings

version := "0.4.0"

organization := "codes.reactive"

description := "Basic Scala wrapper for convenient use of JDK 1.8.0 time libraries."

startYear := Some(2014)

homepage := Some(url("https://oss.reactive.codes/scala-time"))

apiURL := Some(url(s"http://oss.reactive.codes/scala-time/${version.value}"))

apacheLicensed

publishOSS

scalaVersion := crossScalaVersions.value.head

crossScalaVersions := Seq("2.11.8", "2.10.6")

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.0.0-RC2" % Test)

codesCompileOpts

codesDocOpts

codesUnidocOpts

scalacOptions in(Compile, compile) += "-language:postfixOps"

OsgiKeys.bundleSymbolicName := "codes.reactive.scalatime"

OsgiKeys.privatePackage := Seq("codes.reactive.scalatime*")

OsgiKeys.exportPackage := Seq("codes.reactive.scalatime*")

scalastyleConfig <<= baseDirectory(_ / ".idea/scalastyle_config.xml")

SiteKeys.siteMappings := {
  val dir = baseDirectory.value / "project/site"
  Seq(
    (dir / "site.html") → "index.html",
    (dir / "site.css") → "site.css",
    (dir / "site.js") → "site.js")
}

SiteKeys.siteMappings <++= (mappings in(ScalaUnidoc, packageDoc), version) map { (m, v) =>
  for ((f, d) <- m) yield (f, s"$v/$d")
}

git.remoteRepo := codesGithubRepo.value.developerConnection.drop(8)

addDevelopers(("arashi01", "Ali Salim Rashid", "a.rashid@zantekk.com"))
