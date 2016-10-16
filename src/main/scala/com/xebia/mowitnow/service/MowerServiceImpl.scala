package com.xebia.mowitnow.service

import com.xebia.mowitnow.model.Entity._
import com.xebia.mowitnow.model.Factory.MowerFactory
import org.slf4j.LoggerFactory

/**
  * Mower service implementation
  * @author omokeddem
  **/
class MowerServiceImpl(implicit mowerFactory: MowerFactory, groundService: GroundService) extends MowerService {

  val logger = LoggerFactory.getLogger(classOf[App])

  /**
    * Use MowerFactory to parse the input string to a mower object.
    *
    * @param mowerData the line of the mower's position & orientation in the input file like (1 2 E)
    * @return Mower object
    */
  def getMower(mowerData: String): Option[Mower] = {
    mowerFactory.createMower(mowerData)
  }

  /**
    * Applies an instruction to a mower.
    *
    * @param ground
    * @param mower
    * @param instruction
    * @return Mower object
    */
  def applyInstruction(ground: Ground, mower: Mower, instruction: Instruction.Value): Mower = {
    val nextPosition = computeNextPosition(mower.position, instruction)
    if (groundService.isInsideGround(ground, nextPosition))
      mower.copy(position = nextPosition)
    else
      mower
  }

  /**
    * Given an instruction, computes the next position.
    *
    * @param position the current position
    * @param instruction to apply
    * @return Position th next position object
    */
  def computeNextPosition(position: Position, instruction: Instruction.Value): Position = {
    instruction match {
      case Instruction.A => moveForward(position)
      case Instruction.D => position.copy(orientation = turnRightLeft(position.orientation)._1)
      case Instruction.G => position.copy(orientation = turnRightLeft(position.orientation)._2)
      case _ => position
    }
  }

  /**
    * Returns a new position after moving forward (the result may be invalid).
    *
    * @param position the current position
    * @return Position th next position object
    */
  def moveForward(position: Position): Position = {
    position.orientation match {
      case Orientation.N => position.copy(y = position.y + 1)
      case Orientation.E => position.copy(x = position.x + 1)
      case Orientation.S => position.copy(y = position.y - 1)
      case Orientation.W => position.copy(x = position.x - 1)
      case _ => position
    }
  }

  /**
    * Get the next orientation after turning left and right.
    *
    * @param orientation the current orientation
    * @return tuple(the next orientation after turning right, the next orientation after turning left).
    */
  def turnRightLeft(orientation: Orientation.Value): (Orientation.Value, Orientation.Value) = {
    orientation match {
      case Orientation.N => (Orientation.E, Orientation.W)
      case Orientation.E => (Orientation.S, Orientation.N)
      case Orientation.S => (Orientation.W, Orientation.E)
      case Orientation.W => (Orientation.N, Orientation.S)
      case _ => (orientation, orientation)
    }
  }
}
