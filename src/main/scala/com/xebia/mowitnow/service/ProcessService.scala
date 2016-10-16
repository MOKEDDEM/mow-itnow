package com.xebia.mowitnow.service

import com.xebia.mowitnow.model.Entity.{Ground, Mower, Instruction}
import org.xml.sax.InputSource

/**
  * Process service interface
  * @author omokeddem
  **/
trait ProcessService {
  def mowItNowTextFile(fileIn: String): Unit
  def applyInstructions(ground: Ground, mower: Mower, instructions: List[Instruction.Value]): Mower
}
