package com.xebia.mowitnow.model.Factory

import com.xebia.mowitnow.model.Entity.Instruction

/**
  * Instruction Factory Interface
  * @author omokeddem
  **/
trait InstructionFactory {
def createInstruction(instructionData: String): Option[List[Instruction.Value]]
}
