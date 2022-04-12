package models.elevators

import models.{Direction, ElevatorStatus}

import scala.collection.mutable.Set as MutableSet

class ElevatorWithQueue(private val elevatorId: Int,
                        private val startCurrentFloor: Int = 0,
                        private val startDestinationFloor: Int = 0) extends SimpleElevator(elevatorId, startCurrentFloor, startDestinationFloor) :
  private val floorsQueue = MutableSet.empty[Int]

  if currentDirection != Direction.STAYING then
    floorsQueue += destinationFloor

  override def step(): Unit = {
    currentFloor += currentDirection.value
    if currentFloor == destinationFloor then
      if floorsQueue.nonEmpty then
        destinationFloor = floorsQueue.head

      currentDirection = calculateDirection()

    floorsQueue -= currentFloor
  }

  override def update(destinationFloor: Int): Unit = {
    if currentDirection == Direction.STAYING || (Direction(currentFloor, destinationFloor) == currentDirection && Math.abs(this.destinationFloor) < Math.abs(destinationFloor)) then
      this.destinationFloor = destinationFloor
      currentDirection = calculateDirection()

    if destinationFloor != currentFloor then
      floorsQueue += destinationFloor
  }


