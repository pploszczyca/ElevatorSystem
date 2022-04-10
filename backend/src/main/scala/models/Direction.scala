package models

enum Direction(val value: Int):
  case UP extends Direction(1)
  case DOWN extends Direction(-1)
  case STAYING extends Direction(0)

object Direction:
  def apply(currentFloor: Int, destinationFloor: Int): Direction = apply(destinationFloor - currentFloor)

  def apply(value: Int): Direction = {
    if value > 0 then
      Direction.UP
    else if value < 0 then
      Direction.DOWN
    else
      Direction.STAYING
  }




