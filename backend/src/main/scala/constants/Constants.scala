package constants

import com.comcast.ip4s.{ipv4, port}

object Constants:
  val ELEVATORS_PATH = "elevators"
  val PICKUP_PATH = "pickup"
  val UPDATE_PATH = "update"
  val STEP_PATH = "step"

  val NUMBER_OF_ELEVATORS = 16

  val HOST_IP = ipv4"0.0.0.0"
  val PORT = port"9000"