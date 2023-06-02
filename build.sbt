import sbt.*
import Dependencies.*

inThisBuild(
  Seq(
    organization := "com.github.dagmendez",
    organizationName := "dagmendez",
    scalaVersion := "3.3.0",
    scalafixDependencies += SbtPlugins.organizeImports,
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision,
    scalacOptions ++=
      Seq(
        "-deprecation",
        "-explain",
        "-feature",
        "-language:implicitConversions",
        "-unchecked",
        "-Xfatal-warnings",
        "-Yexplicit-nulls", // experimental (I've seen it cause issues with circe)
        "-Ykind-projector",
        "-Ysafe-init", // experimental (I've seen it cause issues with circe)
        "-Wunused:all",
        "-Wvalue-discard",
        "-rewrite",
        "-indent",
        "-source",
        "future-migration",
      ),
  )
)

lazy val commonSettings =
  commonScalacOptions ++ Seq(
    update / evictionWarningOptions := EvictionWarningOptions.empty
  )

lazy val commonScalacOptions: Seq[Def.Setting[Task[Seq[String]]]] = Seq(
  Compile / console / scalacOptions --= Seq(
    "-Wunused:_",
    "-Xfatal-warnings",
  ),
  Test / console / scalacOptions :=
    (Compile / console / scalacOptions).value,
)

lazy val commonDependencies: Seq[Def.Setting[Seq[ModuleID]]] = Seq(
  libraryDependencies ++= Seq(
    Dependencies.org.scalatest.scalatest,
    Dependencies.org.scalatestplus.`scalacheck-1-15`,
  )
)

lazy val root: Project = (project in file("."))
  .aggregate(`core-headers`, core, main)
  .settings(
    name := "diamond-architecture"
  )
  .settings(commonSettings)

lazy val `core-headers`: Project = (project in file("01-core-contracts"))
  .settings(commonSettings)
  .settings(commonDependencies)

lazy val core: Project = (project in file("02-core"))
  .dependsOn(`core-headers` % Utils.Cctt)
  .settings(commonSettings)

lazy val main: Project = (project in file("03-main"))
  .dependsOn(core % Utils.Cctt)
  .settings(commonSettings)
