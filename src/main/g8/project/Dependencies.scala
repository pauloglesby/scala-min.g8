import sbt._

object Dependencies {
  lazy val catsVersion = "2.2.0"

  lazy val compilerPlugins: Seq[ModuleID] =
    Seq(
      compilerPlugin("org.spire-math" % "kind-projector" % "0.11.0" cross CrossVersion.full)
    )

  lazy val catsCore: Seq[ModuleID] = Seq("org.typelevel" %% "cats-core" % catsVersion)

  lazy val baseDependencies: Seq[ModuleID] =
    catsCore ++ compilerPlugins

  lazy val munit = "org.scalameta" %% "munit" % "0.7.7" % Test

  /* ------- MODULES --------- */

  lazy val coreDependencies = baseDependencies ++ Seq(munit)
}
