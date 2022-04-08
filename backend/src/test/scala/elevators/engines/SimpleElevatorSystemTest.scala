package elevators.engines

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.BeforeAndAfter
import elevators.models.{ElevatorStatus, SimpleElevator}

class SimpleElevatorSystemTest extends AnyFunSuite with BeforeAndAfter {
  val numberOfElevators = 4
  var elevatorSystem: ElevatorSystem = _

  before {
    val elevatorsList = (0 until numberOfElevators).map(id => SimpleElevator(id)).toList
    elevatorSystem = SimpleElevatorSystem(elevatorsList)
  }

  test("Update test") {
    // Given
    val elevatorIdToUpdate = 2
    val destinationFloor = 3

    // When
    elevatorSystem.update(elevatorIdToUpdate, destinationFloor)

    // Then
    assert(elevatorSystem.status().contains(ElevatorStatus(elevatorIdToUpdate, 0, destinationFloor)))
  }
}
