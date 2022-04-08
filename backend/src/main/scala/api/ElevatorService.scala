package api

import cats.effect.IO
import org.http4s.HttpRoutes
import cats.effect._, org.http4s._, org.http4s.dsl.io._
import org.http4s.implicits._

object ElevatorService:
  val routes: Any = HttpRoutes.of[IO] {
    case GET -> Root / "hello" / name =>
      Ok(s"Hello $name")
  }.orNotFound
