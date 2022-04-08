package elevators.models

import org.scalatest.funsuite.AnyFunSuite

class DirectionTest extends AnyFunSuite {
  test("Calculate Up Direction") {
    // Given
    val currentFloor = 0
    val destinationFloor = 2

    // When
    val direction = Direction(currentFloor, destinationFloor)

    // Then
    assert(direction == Direction.UP)
    assert(direction.value == 1)
  }

  test("Calculate Down Direction") {
    // Given
    val currentFloor = 2
    val destinationFloor = 0

    // When
    val direction = Direction(currentFloor, destinationFloor)

    // Then
    assert(direction == Direction.DOWN)
    assert(direction.value == -1)
  }

  test("Calculate Staying Direction") {
    // Given
    val currentFloor = 2
    val destinationFloor = 2

    // When
    val direction = Direction(currentFloor, destinationFloor)

    // Then
    assert(direction == Direction.STAYING)
    assert(direction.value == 0)
  }
}
