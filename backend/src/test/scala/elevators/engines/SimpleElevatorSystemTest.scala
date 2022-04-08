package elevators.engines

import elevators.models.{Direction, ElevatorStatus, SimpleElevator}
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

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

  test("Pickup and step test") {
    // Given
    val floor = 2
    val direction = Direction.UP

    // When
    elevatorSystem.pickup(floor, direction)
    elevatorSystem.step()

    // Then
    assert(elevatorSystem.status().contains(ElevatorStatus(0, 1, floor)))
  }
}
