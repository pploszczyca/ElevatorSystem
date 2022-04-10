package engines

import models.{Direction, ElevatorStatus}
import models.elevators.ElevatorWithQueue
import engines.ElevatorSystem
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class SimpleElevatorSystemTest extends AnyFunSuite with BeforeAndAfter {
  val numberOfElevators = 4
  var elevatorSystem: ElevatorSystem = _

  before {
    val elevatorsList = (0 until numberOfElevators).map(id => ElevatorWithQueue(id)).toList
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

  test("Pick up test") {
    // Given
    val pickUpsList = List(2, 5, 1, -1, -3)

    // When
    pickUpsList.foreach(floor => elevatorSystem.pickup(floor, Direction.UP))

    // Then
    assert(getCurrentAndDestinationFromStatuses.contains((0, 5)))
    assert(getCurrentAndDestinationFromStatuses.contains((0,-3)))
  }

  test("Simple pickup and step test") {
    // Given
    val floor = 2
    val direction = Direction.UP

    // When
    elevatorSystem.pickup(floor, direction)
    elevatorSystem.step()

    // Then
    assert(getCurrentAndDestinationFromStatuses.contains((1, floor)))
  }

  private def getCurrentAndDestinationFromStatuses: List[(Int, Int)] = elevatorSystem.status()
    .map(elevatorStatus => (elevatorStatus.currentFloor, elevatorStatus.destinationFloor))
}
