package api

import cats.effect.{ExitCode, IO}
import constants.Constants.{HOST_IP, PORT}
import org.http4s.ember.server.EmberServerBuilder

class ServerBuilder(elevatorService: ElevatorService):
  def apply(): IO[ExitCode] = {
    EmberServerBuilder
      .default[IO]
      .withHost(HOST_IP)
      .withPort(PORT)
      .withHttpApp(elevatorService.routes)
      .build
      .use(_ => IO.never)
      .as(ExitCode.Success)
  }

