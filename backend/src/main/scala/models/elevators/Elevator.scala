package models.elevators

import models.{Direction, ElevatorStatus}

trait Elevator:
  def step(): Unit

  def update(destinationFloor: Int): Unit

  def status(): ElevatorStatus

  def getCurrentDirection: Direction

  def calculateStepsToFloor(floor: Int): Int
