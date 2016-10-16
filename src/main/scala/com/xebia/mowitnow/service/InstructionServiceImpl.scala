package com.xebia.mowitnow.service

import com.xebia.mowitnow.model.Entity.Instruction
import com.xebia.mowitnow.model.Factory.InstructionFactory

/**
  * Instruction service implementation
  * @author omokeddem
  **/
class InstructionServiceImpl(implicit instructionFactory: InstructionFactory) extends InstructionService{

  /**
    * Use InstructionFactory to parse the input string to a List of Instructions.
    *
    * @param instructionData the line of instruction in the input file like (AAGDAADAA)
    * @return List of Instructions object
    */
def getInstruction(instructionData: String): Option[List[Instruction.Value]] = {
  instructionFactory.createInstruction(instructionData)
}
}
