ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.2"

lazy val root = (project in file("."))
  .settings(
    name := "ElevatorSystemBackend"
  )

val http4sVersion = "1.0.0-M23"

// Only necessary for SNAPSHOT releases
resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-ember-server" % http4sVersion,
  "org.http4s" %% "http4s-ember-client" % http4sVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.11" % Runtime,

  "org.scalatest" %% "scalatest" % "3.2.11" % Test,

  "org.json4s" %% "json4s-jackson" % "4.0.4"
)
