
scalaVersion in ThisBuild := "2.11.6"

lazy val root = project.in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "dockerui",
    persistLauncher := true,
    libraryDependencies ++= Seq(
      "com.lihaoyi" %%% "upickle" % "0.2.8",
      "org.scala-js" %%% "scalajs-dom" % "0.8.0" withSources() withJavadoc(),
      "com.github.japgolly.scalajs-react" %%% "extra" % "0.8.2"
    ),
    artifactPath in (Compile, fastOptJS) := (baseDirectory in ThisBuild).value / "chromeapp" / "scalajs-fastopt.js",
    artifactPath in (Compile, packageScalaJSLauncher) := (baseDirectory in ThisBuild).value / "chromeapp" / "scalajs-launcher.js"
  )

pollInterval := 100
fork in run := true
