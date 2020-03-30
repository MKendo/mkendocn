name := """mkendocn"""

version := "2.7.x"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += ws
//libraryDependencies += "com.typesafe.play" %% "play-slick" % "4.0.1"
//libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "4.0.1"

//libraryDependencies += "com.h2database" % "h2" % "1.4.197"

libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.25.2"
libraryDependencies ++= Seq(
  jdbc,
  "com.typesafe.play" %% "anorm" % "2.5.3"
)

libraryDependencies += javaJdbc

libraryDependencies += specs2 % Test

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-Xfatal-warnings"
)
