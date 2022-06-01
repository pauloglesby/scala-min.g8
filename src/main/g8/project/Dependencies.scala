import sbt._

object Dependencies {

  object Versions {
    lazy val cats = "2.7.0"
    lazy val munit = "1.0.0-M1"
  }

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
