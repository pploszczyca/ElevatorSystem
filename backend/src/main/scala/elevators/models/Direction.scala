package elevators.models

enum Direction(val value: Int):
  case UP extends Direction(1)
  case DOWN extends Direction(-1)
  case STAYING extends Direction(0)

object Direction:
  def apply(currentFloor: Int, destinationFloor: Int): Direction = {
    val difference = destinationFloor - currentFloor

    if difference > 0 then
      Direction.UP
    else if difference < 0 then
      Direction.DOWN
    else
      Direction.STAYING
  }



