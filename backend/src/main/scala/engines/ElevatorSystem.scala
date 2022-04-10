package engines

import models.{Direction, ElevatorStatus}

trait ElevatorSystem:
  def pickup(floor: Int, direction: Direction): Unit

  def update(elevatorId: Int, destinationFloor: Int): Unit

  def step(): Unit

  def status(): List[ElevatorStatus]

