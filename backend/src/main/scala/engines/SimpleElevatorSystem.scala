package engines

import models.elevators.Elevator
import models.{Direction, ElevatorStatus}

class SimpleElevatorSystem(private val elevatorList: List[Elevator]) extends ElevatorSystem {
  protected val elevatorsMap: Map[Int, Elevator] = elevatorList.map(elevator => elevator.status().elevatorID -> elevator).toMap

  override def pickup(floor: Int, direction: Direction): Unit =
    getElevatorList
      .fold(getElevatorList.head)((firstElevator, secondElevator) =>
        if firstElevator.calculateStepsToFloor(floor) < secondElevator.calculateStepsToFloor(floor) then
          firstElevator
        else
          secondElevator)
      .update(floor)

  override def update(elevatorId: Int, destinationFloor: Int): Unit = elevatorsMap(elevatorId).update(destinationFloor)

  override def step(): Unit = getElevatorList.foreach(_.step())

  override def status(): List[ElevatorStatus] = getElevatorList.map(_.status())

  protected def getElevatorList: List[Elevator] = elevatorsMap.values.toList
}
