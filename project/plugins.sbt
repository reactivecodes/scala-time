logLevel := Level.Warn

addSbtPlugin("ke.co.sbsproperties" % "sbt-sbs" % "1.0-SNAPSHOT")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.4.0")

resolvers += Resolver.sonatypeRepo("snapshots")
