logLevel := Level.Warn

addSbtPlugin("codes.reactive.sbt" % "sbt-codes" % "0.3.0-SNAPSHOT")

addSbtPlugin("codes.reactive.sbt" % "sbt-fmpp" % "0.3-SNAPSHOT")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.7.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-ghpages" % "0.5.3")

addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "0.8.1")

resolvers += Resolver.sonatypeRepo("snapshots")
