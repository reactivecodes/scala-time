
lazy val plugins = (project in file("."))
  .dependsOn(sbtFmpp)

logLevel := Level.Warn

addSbtPlugin("codes.reactive.sbt" % "sbt-codes" % "0.3.0-SNAPSHOT")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.4.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-ghpages" % "0.5.3")

addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "0.8.1")

resolvers += Resolver.sonatypeRepo("snapshots")

lazy val sbtFmpp = classpathDependency(uri("git://github.com/sumito3478/sbt-fmpp.git#97e9f168"))


//lazy val sbtOsgi = uri("git://github.com/arashi01/sbt-osgi.git#ecaaf509")