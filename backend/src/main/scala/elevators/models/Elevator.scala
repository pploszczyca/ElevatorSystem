package elevators.models

trait Elevator:
  def step(): Unit
  def update(destinationFloor: Int): Unit
  def status(): ElevatorStatus
  def getCurrentDirection: Direction

