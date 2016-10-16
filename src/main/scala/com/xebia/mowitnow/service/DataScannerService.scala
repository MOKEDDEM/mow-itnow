package com.xebia.mowitnow.service

import com.xebia.mowitnow.model.Entity.{Mower, Ground, Instruction}
import java.io.File


/**
  * Data scanner service interface
  * @author omokeddem
  **/

trait DataScannerService {
  def getGround(file: String): Option[Ground]
  def getMowerWithInstruction(file: String): List[(Option[Mower],Option[List[Instruction.Value]])]
}
