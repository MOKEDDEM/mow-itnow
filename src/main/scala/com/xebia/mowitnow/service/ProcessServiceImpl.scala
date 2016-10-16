package com.xebia.mowitnow.service

import com.xebia.mowitnow.model.Entity.{Ground, Instruction, Mower}
import org.slf4j.LoggerFactory
import org.xml.sax.InputSource

/**
  * Process service implementation
  * @author omokeddem
  **/
class ProcessServiceImpl(implicit dataScannerService: DataScannerService, mowerService: MowerService) extends ProcessService {
  val logger = LoggerFactory.getLogger(classOf[App])
  /**
    * Applies an instruction to a mower.
    *
    * @param ground
    * @param mower
    * @param instructions a list of instructions
    * @return Mower object
    */
  def applyInstructions(ground: Ground, mower: Mower, instructions: List[Instruction.Value]): Mower = {
    logger.info("Applies Instruction to mower " + mower.print + " in the ground " + ground.print)
    var mower_ = mower
    instructions.foreach(inst => {
      mower_ = mowerService.applyInstruction(ground, mower_, inst)
    })
    mower_
  }

  /**
    * Run all mower's instructions in the file & print the results .
    *
    * @param fileIn the path of the input file
    */
  def mowItNowTextFile(fileIn: String): Unit = {
    val ground = dataScannerService.getGround(fileIn)
    if (ground != None) {
      val mowerWithInstruction = dataScannerService.getMowerWithInstruction(fileIn)
      val mowerResult: List[Option[Mower]] = mowerWithInstruction.map(x => {
        if (x._1 != None && x._2 != None) {
          val mower = applyInstructions(ground.get, x._1.get, x._2.get)
          Some(mower)
        } else
          None
      })
      logger.info("Document processing completed")
      println("Result of : " + fileIn)
      mowerResult.filter(_ != None).foreach(mower => {
        println(mower.get.print)
      })
    }
  }
}
