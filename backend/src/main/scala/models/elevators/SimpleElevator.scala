package models.elevators

import models.elevators.Elevator
import models.{Direction, ElevatorStatus}

class SimpleElevator(private val elevatorId: Int,
                     protected var currentFloor: Int = 0,
                     protected var destinationFloor: Int = 0) extends Elevator :

  protected var currentDirection: Direction = calculateDirection()

  override def step(): Unit = {
    currentFloor += currentDirection.value
    if currentFloor == destinationFloor then
      currentDirection = Direction.STAYING
  }

  override def update(destinationFloor: Int): Unit = {
    this.destinationFloor = destinationFloor
    this.currentDirection = calculateDirection()
  }

  override def status(): ElevatorStatus = ElevatorStatus(elevatorID = elevatorId, currentFloor = currentFloor, destinationFloor = destinationFloor)

  override def getCurrentDirection: Direction = currentDirection

  protected def calculateDirection(): Direction = Direction(this.currentFloor, this.destinationFloor)
