package com.xebia.mowitnow.service

import com.xebia.mowitnow.model.Entity.Instruction

/**
  * Instruction service interface
  * @author omokeddem
  **/
trait InstructionService {
  def getInstruction(InstructionData: String): Option[List[Instruction.Value]]
}
