import api.*
import cats.effect.{ExitCode, IO, IOApp}
import constants.Constants.NUMBER_OF_ELEVATORS
import engines.SimpleElevatorSystem
import models.elevators.ElevatorWithQueue

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    val elevators = (0 until NUMBER_OF_ELEVATORS).map(id => ElevatorWithQueue(id)).toList
    val elevatorSystem = SimpleElevatorSystem(elevators)
    val elevatorService = ElevatorService(elevatorSystem)

    ServerBuilder(elevatorService).apply()
  }
}
