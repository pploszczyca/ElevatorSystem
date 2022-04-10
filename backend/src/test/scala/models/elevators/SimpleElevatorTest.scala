package models.elevators

import models.{Direction, ElevatorStatus}
import org.scalatest.funsuite.AnyFunSuite
import models.elevators.SimpleElevator

class SimpleElevatorTest extends AnyFunSuite {
  test("Step test") {
    // Given
    val elevatorId = 0
    val destinationFloor = 2
    val elevator = SimpleElevator(elevatorId = elevatorId, destinationFloor = destinationFloor)

    // When
    elevator.step()

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

  test("Calculating the amount of steps on the same path test") {
    // Given
    val elevator = SimpleElevator(0, 0, 5)
    val floor = 3

    // When
    val stepsToFloor = elevator.calculateStepsToFloor(floor)

    // Then
    assert(stepsToFloor == 3)
  }

  test("Calculating the amount of steps not on the same path test") {
    // Given
    val elevator = SimpleElevator(0, 2, 5)
    val floor = -3

    // When
    val stepsToFloor = elevator.calculateStepsToFloor(floor)

    // Then
    assert(stepsToFloor == 11)
  }

  test("Calculate the amount of steps with floor lower than destination test") {
    // Given
    val elevator = SimpleElevator(0, 5, -3)
    val floor = -6

    // When
    val stepsToFloor = elevator.calculateStepsToFloor(floor)

    // Then
    assert(stepsToFloor == 11)
  }
}
