package models.elevators

import models.{Direction, ElevatorStatus}

import scala.collection.mutable.Set as MutableSet

class ElevatorWithQueue(private val elevatorId: Int,
                        currentFloor: Int = 0,
                        destinationFloor: Int = 0) extends SimpleElevator(elevatorId, currentFloor, destinationFloor):
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
    if currentDirection == Direction.STAYING then
      this.destinationFloor = destinationFloor
      currentDirection = calculateDirection()

    if destinationFloor != currentFloor then
      floorsQueue += destinationFloor
  }

