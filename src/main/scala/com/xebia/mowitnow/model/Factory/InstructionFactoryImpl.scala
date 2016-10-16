package com.xebia.mowitnow.model.Factory

import com.xebia.mowitnow.model.Entity.Instruction
import org.slf4j.LoggerFactory

/**
  * Instruction Factory Implementation
  * @author omokeddem
  **/
class InstructionFactoryImpl extends InstructionFactory {
  final val instructionsPattern = "(\\s*[DGA]+\\s*)".r
  final val instructionPattern = "([DGA])".r
  val logger = LoggerFactory.getLogger(classOf[App])

  /**
    * Parse the input string to a List of instructions.
    *
    * @param instructionData the line of instruction in the input file like (AAGDAADAA)
    * @return List of Instructions object
    */
  def createInstruction(instructionData: String): Option[List[Instruction.Value]] = {
    instructionData match {
      case instructionsPattern(c) => {
        val instructions = (instructionPattern findAllIn instructionData).toList
          .map(inst => Instruction.withName(inst))
        logger.info("the instructions list was created successfully from {}", instructionData)
        Some(instructions)
      }
      case _ => {
        logger.warn("there's unsupported instructions in {} , Instruction must be one of: D, G, A", instructionData)
        val instructions = (instructionPattern findAllIn instructionData).toList
          .map(inst => Instruction.withName(inst))
        if (instructions.length != 0)
          Some(instructions)
        else
          None
      }
    }
  }
}
