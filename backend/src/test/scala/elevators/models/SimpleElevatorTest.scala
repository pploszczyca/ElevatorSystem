package elevators.models

import org.scalatest.funsuite.AnyFunSuite

class SimpleElevatorTest extends AnyFunSuite {
  test("Step test") {
    // Given
    val elevatorId = 0
    val destinationFloor = 2
    val elevator = SimpleElevator(elevatorId = elevatorId, destinationFloor = destinationFloor)

    // When
    elevator.step()

    // Then
    assert(elevator.status() == ElevatorStatus(elevatorId, 1, destinationFloor))
    assert(elevator.getCurrentDirection == Direction.UP)
  }

  test("Reaching destination test") {
    // Given
    val elevatorId = 0
    val currentFloor = 1
    val destinationFloor = 2
    val elevator = SimpleElevator(elevatorId, currentFloor, destinationFloor)

    // When
    elevator.step()

    // Then
    assert(elevator.status() == ElevatorStatus(elevatorId, destinationFloor, destinationFloor))
    assert(elevator.getCurrentDirection == Direction.STAYING)
  }

  test("Update test") {
    // Given
    val elevatorId = 0
    val currentFloor = 0
    val elevator = SimpleElevator(elevatorId, currentFloor)
    val destinationFloor = 3

    // When
    elevator.update(destinationFloor)

    // Then
    assert(elevator.status() == ElevatorStatus(elevatorId, currentFloor, destinationFloor))
  }
}
