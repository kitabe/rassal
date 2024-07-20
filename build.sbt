import Dependencies._

Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / scalaVersion := "3.4.2"
ThisBuild / name := "rassal"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "io.github.kattulib"
ThisBuild / description := "Minimal Functional random value generator"
ThisBuild / licenses := List(("MIT", url("https://opensource.org/license/mit")))
ThisBuild / startYear := Some(2024)
ThisBuild / homepage := Some(url("https://github.com/kattulib/rassal"))
ThisBuild / scmInfo := Some(
    ScmInfo(
        url("https://github.com/kattulib/rassal"),
        "git@github.com:kattulib/rassal.git"
    )
)
ThisBuild / developers ++= List(
    Developer(
        id      = "csgn", 
        name    = "Sergen Çepoğlu", 
        email   = "dev.csgn@gmail.com", 
        url     = url("https://github.com/csgn")
    ),
)
ThisBuild / testFrameworks += new TestFramework("munit.Framework")
ThisBuild / autoAPIMappings := true
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision
ThisBuild / scalacOptions ++= Seq(
    "-Wunused:all",
)
ThisBuild / publishMavenStyle := true
Compile / doc / scalacOptions ++= Seq(
    "-doc-title", (ThisBuild / name).value,
    "-project-version", (ThisBuild / version).value,
    "-project-logo", "docs/icon.jpeg",
)

lazy val root = project
  .in(file("."))
  .settings(
    name := (ThisBuild / name).value,
    version := "0.1.0-SNAPSHOT",

    libraryDependencies ++= {
        Seq(
            munit.value % Test,
            kuram.value,
        )
    },
  )
  .enablePlugins(ScalafixPlugin)

