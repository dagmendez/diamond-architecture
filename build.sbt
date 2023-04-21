import sbt._

ThisBuild / scalaVersion := "3.2.1"
ThisBuild / organization := "com.github.dagmendez"
ThisBuild / organizationName := "dagmendez"

ThisBuild / scalacOptions ++=
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
  ) ++ Seq("-rewrite", "-indent") ++ Seq("-source", "future-migration")

lazy val commonSettings = commonScalacOptions ++ Seq(
  update / evictionWarningOptions := EvictionWarningOptions.empty
)

lazy val commonScalacOptions = Seq(
  Compile / console / scalacOptions --= Seq(
    "-Wunused:_",
    "-Xfatal-warnings",
  ),
  Test / console / scalacOptions :=
    (Compile / console / scalacOptions).value,
)

lazy val commonDependencies = Seq(
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
