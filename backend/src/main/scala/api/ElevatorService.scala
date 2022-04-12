package api

import cats.effect.*
import constants.Constants.{ELEVATORS_PATH, PICKUP_PATH, STEP_PATH, UPDATE_PATH}
import models.Direction
import engines.ElevatorSystem
import org.http4s.*
import org.http4s.dsl.io.*
import org.http4s.implicits.*
import org.json4s.jackson.Serialization.write
import org.json4s.{DefaultFormats, Formats}


class ElevatorService(elevatorSystem: ElevatorSystem):
  val routes = HttpRoutes.of[IO] {
    case GET -> Root / ELEVATORS_PATH =>
      makeOkWithElevatorStatus()

    case POST -> Root / ELEVATORS_PATH / PICKUP_PATH / floor / direction =>
      elevatorSystem.pickup(floor.toInt, Direction(direction.toInt))
      makeOkWithElevatorStatus()

    case POST -> Root / ELEVATORS_PATH / UPDATE_PATH / elevatorId / destinationFloor =>
      elevatorSystem.update(elevatorId.toInt, destinationFloor.toInt)
      makeOkWithElevatorStatus()

    case POST -> Root / ELEVATORS_PATH / STEP_PATH =>
      elevatorSystem.step()
      makeOkWithElevatorStatus()

  }.orNotFound

  implicit val formats: Formats = DefaultFormats

  private def makeOkWithElevatorStatus() = Ok(write(elevatorSystem.status()))

