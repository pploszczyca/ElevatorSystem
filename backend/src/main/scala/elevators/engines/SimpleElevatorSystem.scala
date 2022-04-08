package elevators.engines

import elevators.models.{Direction, Elevator, ElevatorStatus}

class SimpleElevatorSystem(private val elevatorList: List[Elevator]) extends ElevatorSystem {
  private val elevatorsMap = elevatorList.map(elevator => elevator.status().elevatorID -> elevator).toMap

  override def pickup(floor: Int, direction: Direction): Unit = {
    val stayingElevatorsList = getStayingElevators
    if stayingElevatorsList.nonEmpty then
      stayingElevatorsList.head.update(floor)
  }

  private def getStayingElevators: List[Elevator] = getElevatorList.filter(elevator => elevator.getCurrentDirection == Direction.STAYING)

  override def update(elevatorId: Int, destinationFloor: Int): Unit = elevatorsMap(elevatorId).update(destinationFloor)

  override def step(): Unit = getElevatorList.foreach(_.step())

  override def status(): List[ElevatorStatus] = getElevatorList.map(_.status())

  private def getElevatorList = elevatorsMap.values.toList
}
