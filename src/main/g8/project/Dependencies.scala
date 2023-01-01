import sbt._

object Dependencies {

  object Versions {

    lazy val ammonite = "2.5.5"
    lazy val cats = "2.9.0"
    lazy val catsEffect = "3.4.3"
    lazy val munit = "1.0.0-M7"

  }

  lazy val Scala213 = "2.13.10"

  lazy val ammonite: Seq[ModuleID] = Seq(
    "com.lihaoyi" %% "ammonite" % Versions.ammonite % "test" cross CrossVersion.full
  )

  lazy val catsCore: ModuleID = "org.typelevel" %% "cats-core" % Versions.cats

  lazy val baseDependencies: Seq[ModuleID] = Seq(
    catsCore
  )

  lazy val munit = "org.scalameta" %% "munit" % Versions.munit

  lazy val testDependencies: Seq[ModuleID] = Seq(
    munit
  ).map(_ % Test)

  /* ------- MODULES --------- */

  lazy val coreDependencies = baseDependencies ++ testDependencies
}
