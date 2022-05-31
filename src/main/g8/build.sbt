import Dependencies._
import sbt.Def

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.13.2" cross CrossVersion.full)

lazy val buildSettings = inThisBuild(
  Seq(
    scalaVersion := "2.13.8",
    organization := "ly.analogical",
  )
)

lazy val coverageSettings = Seq(
  Test / test / coverageEnabled := true,
  coverageMinimumStmtTotal := 100,
  coverageFailOnMinimum := true
)

lazy val lintingSettings = Seq(
  Compile / compile / wartremoverErrors ++= Warts
   .allBut(Wart.Var, Wart.ImplicitParameter, Wart.DefaultArguments, Wart.Overloading),
  scalastyleFailOnWarning := true
)

lazy val testSettings = Seq(
  testFrameworks += new TestFramework("munit.Framework"),
  Test / javaOptions ++= List("-Xss64m", "-Xmx2048m"),
  Test / fork := true,
  Test / parallelExecution := true,
)

lazy val baseWithoutTestSettings = buildSettings ++ lintingSettings
lazy val baseSettings = baseWithoutTestSettings ++ coverageSettings ++ testSettings

lazy val root = (project in file("."))
  .settings(baseSettings)
  .settings(
    name := "project name here",
    description := "description here"
  )
  .aggregate(
    core
  )

lazy val core = (project in file("core"))
  .settings(baseSettings)
  .settings(
    name := "core",
    description := "Something",
    libraryDependencies ++= coreDependencies
  )
