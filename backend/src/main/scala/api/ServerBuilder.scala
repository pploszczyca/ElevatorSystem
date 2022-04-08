package api

import cats.effect.{ExitCode, IO}
import com.comcast.ip4s.{ipv4, port}
import org.http4s.ember.server.EmberServerBuilder

class ServerBuilder(elevatorService: ElevatorService):
  def apply(): IO[ExitCode] = {
    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"127.0.0.1")
      .withPort(port"8080")
      .withHttpApp(elevatorService.routes)
      .build
      .use(_ => IO.never)
      .as(ExitCode.Success)
  }

