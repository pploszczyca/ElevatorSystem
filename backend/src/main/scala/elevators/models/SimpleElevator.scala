package elevators.models

class SimpleElevator(private val elevatorId: Int,
                     private var currentFloor: Int = 0,
                     private var destinationFloor: Int = 0) extends Elevator :

  private var currentDirection: Direction = Direction(this.currentFloor, this.destinationFloor)

  override def step(): Unit = {
    currentFloor += currentDirection.value
    if currentFloor == destinationFloor then
      currentDirection = Direction.STAYING
  }

  override def update(destinationFloor: Int): Unit = {
    this.destinationFloor = destinationFloor
    this.currentDirection = Direction(this.currentFloor, this.destinationFloor)
  }

  override def status(): ElevatorStatus = ElevatorStatus(elevatorID = elevatorId, currentFloor = currentFloor, destinationFloor = destinationFloor)

  override def getCurrentDirection: Direction = currentDirection
