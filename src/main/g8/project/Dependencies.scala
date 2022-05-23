import sbt._

object Dependencies {
  lazy val catsVersion = "2.7.0"

  lazy val catsCore: Seq[ModuleID] = Seq("org.typelevel" %% "cats-core" % catsVersion)

  lazy val baseDependencies: Seq[ModuleID] =
    catsCore

  lazy val munit = "org.scalameta" %% "munit" % "1.0.0-M1" % Test

  /* ------- MODULES --------- */

  lazy val coreDependencies = baseDependencies ++ Seq(munit)
}
