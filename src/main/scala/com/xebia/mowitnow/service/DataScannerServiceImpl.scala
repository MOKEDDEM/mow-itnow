package com.xebia.mowitnow.service

import com.xebia.mowitnow.model.Entity.{Instruction, Mower, Ground}
import org.slf4j.LoggerFactory

import scala.io.Source

/**
  * Data scanner service implementation
  * @author omokeddem
  **/

class DataScannerServiceImpl(implicit groundService: GroundService, mowerService: MowerService, instructionService: InstructionService) extends DataScannerService {
  val logger = LoggerFactory.getLogger(classOf[App])
  /**
    * Use GroundService to parse the first line of input file to a Ground object.
    *
    * @param file the path to the input file
    * @return Option[Ground] object
    */
  def getGround(file: String): Option[Ground] = {
    logger.info("Scanning of ground dimension from input file")
    val input = Source.fromFile(file).getLines().toList
    if (!input.isEmpty) {
      groundService.getGround(input(0))
    } else
      None
  }

  /**
    * Use MowerService & InstructionSerive to parse lines of input file to list of tuple(Mower object, list of mower's instructions object).
    *
    * @param file the path to the input file
    * @return List of tuple (Mower object, list of mower's instructions object)
    */
  def getMowerWithInstruction(file: String): List[(Option[Mower], Option[List[Instruction.Value]])] = {
   logger.info("Scanning of mower & mower's instructions from input file")
    val input = Source.fromFile(file).getLines().drop(1)
    val mowerWithInstruction = input.grouped(2)
      .map(mowerAndInstructionData => {
        (mowerService.getMower(mowerAndInstructionData.head),
          instructionService.getInstruction(mowerAndInstructionData.last))
      })
    mowerWithInstruction.toList
  }
}
