ThisBuild / version := "1.0.0"
ThisBuild / scalaVersion := "3.2.1"
ThisBuild / organization := "com.github.dagmendez"
ThisBuild / organizationName := "dagmendez"

lazy val root: Project = (project in file ("."))
  .aggregate(`core-headers`, main)
  .settings(
    name := "diamond-architecture"
  )

lazy val `core-headers`: Project = (project in file("01-core-contracts"))


lazy val core: Project = (project in file ("02-core"))
  .dependsOn(`core-headers`)



lazy val main: Project = (project in file("03-main"))
  .dependsOn(core)