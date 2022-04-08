import api.*
import cats.effect.{ExitCode, IO, IOApp}
import elevators.engines.SimpleElevatorSystem
import elevators.models.SimpleElevator
import constants.Constants.NUMBER_OF_ELEVATORS

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    val elevators = (0 until NUMBER_OF_ELEVATORS).map(id => SimpleElevator(id)).toList
    val elevatorSystem = SimpleElevatorSystem(elevators)
    val elevatorService = ElevatorService(elevatorSystem)

    ServerBuilder(elevatorService).apply()
  }
}
