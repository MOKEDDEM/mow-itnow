package com.xebia.mowitnow

import com.xebia.mowitnow.model.Entity._
import com.xebia.mowitnow.model.Factory.{InstructionFactoryImpl, InstructionFactory, MowerFactoryImpl, GroundFactoryImpl}
import com.xebia.mowitnow.service._
import org.junit.Assert._
import org.junit.{Test, Before}
import org.scalatest.Assertions

/**
  * Xebia's instruction test
  * @author omokeddem
  **/
class TestXebiaInstructions extends Assertions {

  implicit var mowerFactory: MowerFactoryImpl = null
  implicit var groundFactory: GroundFactoryImpl = null
  implicit var groundService: GroundServiceImpl = null
  implicit var instructionFactoy: InstructionFactory = null
  implicit var instructionService: InstructionServiceImpl = null
  implicit var dataScannerService: DataScannerServiceImpl = null
  implicit var processService: ProcessServiceImpl = null
  implicit var mowerService: MowerServiceImpl = null
  var ground: Ground = null
  var mower: Mower = null

  @Before def initialize() {
    mowerFactory = new MowerFactoryImpl
    instructionFactoy = new InstructionFactoryImpl
    groundFactory = new GroundFactoryImpl
    groundService = new GroundServiceImpl
    mowerService = new MowerServiceImpl
    instructionService = new InstructionServiceImpl
    dataScannerService = new DataScannerServiceImpl
    processService = new ProcessServiceImpl
    ground = Ground(Dimension(5, 5))
  }

  @Test
  def testXebiaInstructionsprogrammatically() {
    /**
      * Test the first mower.
      *
      * Instructions:
      * 5 5
      * 1 2 N
      * GAGAGAGAA
      *
      * Result: 1 3 N
      */
    val firstMower = Mower(Position(1, 2, Orientation.N))
    val firstInstructions = List(Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.A)

    assertEquals(Mower(Position(1, 3, Orientation.N)), processService.applyInstructions(ground, firstMower, firstInstructions))

    /**
      * Test the second mower.
      *
      * Instructions:
      * 5 5
      * 3 3 E
      * AADAADADDA
      *
      * Result: 5 1 E
      */

    val secondMower = Mower(Position(3, 3, Orientation.E))
    val secondInstructions = List(Instruction.A, Instruction.A, Instruction.D, Instruction.A, Instruction.A, Instruction.D, Instruction.A, Instruction.D, Instruction.D, Instruction.A)

    assertEquals(Mower(Position(5, 1, Orientation.E)), processService.applyInstructions(ground, secondMower, secondInstructions))
  }
}
