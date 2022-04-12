package engines

import models.elevators.Elevator
import models.{Direction, ElevatorStatus}

class ElevatorSystemImp(private val elevatorList: List[Elevator]) extends ElevatorSystem {
  protected val elevatorsMap: Map[Int, Elevator] = elevatorList.map(elevator => elevator.status().elevatorID -> elevator).toMap

  override def pickup(floor: Int, direction: Direction): Unit =
    getElevatorList
      .fold(getElevatorList.head)((firstElevator, secondElevator) =>
        if isFirstElevatorBetterThanSecond(firstElevator, secondElevator, floor, direction) then
          firstElevator
        else
          secondElevator)
      .update(floor)

  private def isFirstElevatorBetterThanSecond(firstElevator: Elevator, secondElevator: Elevator, floor: Int, direction: Direction) = {
    val firstElevatorSteps = firstElevator.calculateStepsToFloor(floor)
    val secondElevatorSteps = secondElevator.calculateStepsToFloor(floor)

    firstElevatorSteps < secondElevatorSteps || (firstElevatorSteps == secondElevatorSteps && firstElevator.getCurrentDirection == direction)
  }

  override def update(elevatorId: Int, destinationFloor: Int): Unit = elevatorsMap(elevatorId).update(destinationFloor)

  override def step(): Unit = getElevatorList.foreach(_.step())

  override def status(): List[ElevatorStatus] = getElevatorList.map(_.status())

  protected def getElevatorList: List[Elevator] = elevatorsMap.values.toList
}
