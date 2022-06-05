import sbt._

object Dependencies {

  object Versions {

    object scala213 {
      lazy val binary = "2.13"
      lazy val full = "2.13.8"
    }

    lazy val ammonite = "2.5.4"
    lazy val cats = "2.7.0"
    lazy val catsEffect = "3.3.12"
    lazy val cats = "2.7.0"
    lazy val munit = "1.0.0-M1"
  }

  lazy val ammonite: Seq[ModuleID] = Seq("com.lihaoyi" %% "ammonite" % Versions.ammonite % "test" cross CrossVersion.full)

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
