addSbtPlugin("org.jmotor.sbt" % "sbt-dependency-updates" % "1.2.7")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.6")

addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.10.4")

ThisBuild / useSuperShell := false

ThisBuild / autoStartServer := false

update / evictionWarningOptions := EvictionWarningOptions.empty

addDependencyTreePlugin

addSbtPlugin("com.github.sbt" % "sbt-git" % "2.0.1")

addSbtPlugin("com.mayreh" % "sbt-thank-you-stars" % "0.2")

addSbtPlugin("com.timushev.sbt" % "sbt-rewarn" % "0.1.3")

addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.6.4")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.10.0")

addSbtPlugin("de.heikoseeberger" % "sbt-header" % "5.9.0")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "2.0.7")

addSbtPlugin("com.github.cb372" % "sbt-explicit-dependencies" % "0.3.1")
