import Dependencies._
import sbt.Def

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)

lazy val buildSettings = inThisBuild(
  Seq(
    scalaVersion := "2.13.2",
    organization := "ly.analogical",
  )
)

lazy val coverageSettings = Seq(
  coverageEnabled.in(Test, test) := true,
  coverageMinimum := 100,
  coverageFailOnMinimum := true
)

lazy val lintingSettings = Seq(
  wartremoverErrors in (Compile, compile) ++= Warts
   .allBut(Wart.Var, Wart.ImplicitParameter, Wart.DefaultArguments, Wart.Overloading),
  scalastyleFailOnWarning := true
)

lazy val testSettings = Seq(
  testFrameworks += new TestFramework("munit.Framework"),
  Test / javaOptions ++= List("-Xss64m", "-Xmx2048m"),
  Test / fork := true,
  Test / parallelExecution := true,
)

lazy val baseWithoutTestSettings = CompilerOptions.flags ++ buildSettings ++ lintingSettings
lazy val baseSettings = baseWithoutTestSettings ++ coverageSettings ++ testSettings

lazy val defaultAssemblySettings =
  baseAssemblySettings ++ Seq(
    test in assembly := {}
  )

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
