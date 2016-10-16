package com.xebia.mowitnow.service

import com.xebia.mowitnow.model.Entity._

/**
  * Mower service interface
  * @author omokeddem
  **/
trait MowerService {
  def getMower(mowerData: String): Option[Mower]
  def applyInstruction(ground: Ground, mower: Mower, instruction: Instruction.Value): Mower
  def computeNextPosition(position: Position, instruction: Instruction.Value): Position
  def moveForward(position: Position): Position
  def turnRightLeft(orientation: Orientation.Value): (Orientation.Value, Orientation.Value)
}
