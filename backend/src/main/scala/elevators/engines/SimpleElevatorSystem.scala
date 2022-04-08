package elevators.engines
import elevators.models.{Direction, Elevator, ElevatorStatus}

class SimpleElevatorSystem(private val elevatorList: List[Elevator]) extends ElevatorSystem {
  override def pickup(floor: Int, direction: Direction): Unit = {
    val stayingElevatorsList = getStayingElevators
    if stayingElevatorsList.nonEmpty then
      stayingElevatorsList.head.update(floor)
  }

  private def getStayingElevators: List[Elevator] = elevatorList.filter(elevator => elevator.getCurrentDirection == Direction.STAYING)

  override def update(elevatorId: Int, destinationFloor: Int): Unit = elevatorList(elevatorId).update(destinationFloor)

  override def step(): Unit = elevatorList.foreach(_.step())

  override def status(): List[ElevatorStatus] = elevatorList.map(_.status())
}
