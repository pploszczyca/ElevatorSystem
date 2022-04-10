package models.elevators

import models.ElevatorStatus
import models.elevators.ElevatorWithQueue
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class ElevatorWithQueueTest extends AnyFunSuite with BeforeAndAfter {
  val elevatorId = 0
  var elevatorWithQueue: ElevatorWithQueue = _

  before {
    elevatorWithQueue = ElevatorWithQueue(elevatorId)
  }

  test("Update with multiple floors UP test") {
    // Given
    val destinationFloorList = List(2, 1, 5, 3, -10)

    // When
    destinationFloorList.foreach(floor => elevatorWithQueue.update(floor))
    elevatorWithQueue.step()

    // Then
    assert(elevatorWithQueue.status() == ElevatorStatus(elevatorID = elevatorId, currentFloor = 1, destinationFloor = 5))
  }

  test("Update with multiple floor with level smaller and higher than current test") {
    // Given
    val destinationFloorList = List(2, -2, 3, -3)

    // When
    destinationFloorList.foreach(floor => elevatorWithQueue.update(floor))
    (0 until 3).foreach(_ => elevatorWithQueue.step())

    // Then
    assert(elevatorWithQueue.status() == ElevatorStatus(elevatorID = elevatorId, currentFloor = 3, destinationFloor = -2))
  }

  test("Update and reset queue after making steps test") {
    // Given
    val destinationFloorList = List(3, 1, 2, 0)

    // When
    destinationFloorList.foreach(floor => elevatorWithQueue.update(floor))
    (0 until 4).foreach(_ => elevatorWithQueue.step())

    // Then
    assert(elevatorWithQueue.status() == ElevatorStatus(elevatorID = elevatorId, currentFloor = 3, destinationFloor = 3))
  }
}
