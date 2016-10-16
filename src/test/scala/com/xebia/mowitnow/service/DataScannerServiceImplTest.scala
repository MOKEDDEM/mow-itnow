package com.xebia.mowitnow.service

import com.xebia.mowitnow.model.Entity._
import com.xebia.mowitnow.model.Factory.{InstructionFactoryImpl, GroundFactoryImpl, MowerFactoryImpl}
import org.junit.Assert._
import org.junit.{Test, Before}
import org.scalatest.Assertions
import scala.io.Source

/**
  * Data scanner service test
  * @author omokeddem
  **/
class DataScannerServiceImplTest extends Assertions {

  implicit var mowerFactory: MowerFactoryImpl = null
  implicit var groundFactory: GroundFactoryImpl = null
  implicit var instructionFactory: InstructionFactoryImpl = null
  implicit var groundService: GroundServiceImpl = null
  implicit var mowerService: MowerServiceImpl = null
  implicit var instructionService: InstructionServiceImpl = null
  var dataScannerService: DataScannerServiceImpl = null
  var resourcePath:String = null

  @Before def initialize() {
    mowerFactory = new MowerFactoryImpl
    groundFactory = new GroundFactoryImpl
    instructionFactory = new InstructionFactoryImpl
    groundService = new GroundServiceImpl
    mowerService = new MowerServiceImpl
    instructionService = new InstructionServiceImpl
    dataScannerService = new DataScannerServiceImpl
    resourcePath = getClass.getResource("/test_1").getPath
  }

  @Test
  def testgetGround() {
    assertEquals(Some(Ground(Dimension(5, 5))),
      dataScannerService.getGround(resourcePath))
  }

  @Test
  def testGetMowerWithInstruction() ={
    assertEquals(List((Some(Mower(Position(1,2,Orientation.N))),Some(List(Instruction.G,Instruction.A,Instruction.G,Instruction.A,Instruction.G,Instruction.A,Instruction.G,Instruction.A,Instruction.A)))),
    dataScannerService.getMowerWithInstruction(resourcePath))
  }
}
