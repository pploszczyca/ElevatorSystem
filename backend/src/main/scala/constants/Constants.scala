package constants

import com.comcast.ip4s.{ipv4, port}

object Constants:
  val ELEVATORS_PATH = "models"
  val PICKUP_PATH = "pickup"
  val UPDATE_PATH = "update"
  val STEP_PATH = "step"

  val NUMBER_OF_ELEVATORS = 16

  val HOST_IP = ipv4"127.0.0.1"
  val PORT = port"8080"