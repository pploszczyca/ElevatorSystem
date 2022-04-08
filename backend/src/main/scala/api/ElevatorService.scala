package api

import cats.effect.*
import constants.Constants.{ELEVATORS_PATH, PICKUP_PATH, STEP_PATH, UPDATE_PATH}
import elevators.engines.ElevatorSystem
import elevators.models.{Direction, ElevatorStatus}
import org.http4s.*
import org.http4s.dsl.io.*
import org.http4s.implicits.*
import org.json4s.jackson.Serialization.write
import org.json4s.{DefaultFormats, Formats}


class ElevatorService(elevatorSystem: ElevatorSystem):
  val routes = HttpRoutes.of[IO] {
    case GET -> Root / ELEVATORS_PATH =>
      Ok(write(elevatorSystem.status()))

    case POST -> Root / ELEVATORS_PATH / PICKUP_PATH / floor / direction =>
      Ok(elevatorSystem.pickup(floor.toInt, Direction(direction.toInt)))

    case POST -> Root / ELEVATORS_PATH / UPDATE_PATH / elevatorId / destinationFloor =>
      Ok(elevatorSystem.update(elevatorId.toInt, destinationFloor.toInt))

    case POST -> Root / ELEVATORS_PATH / STEP_PATH =>
      Ok(elevatorSystem.step())

  }.orNotFound

  implicit val formats: Formats = DefaultFormats

