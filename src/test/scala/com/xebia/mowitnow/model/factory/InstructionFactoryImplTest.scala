package com.xebia.mowitnow.model.factory

import com.xebia.mowitnow.model.Entity.{Instruction, Dimension, Ground}
import com.xebia.mowitnow.model.Factory.InstructionFactoryImpl
import org.junit.Assert._
import org.junit.{Test, Before}
import org.scalatest.Assertions

/**
  * Instruction factory test
  * @author omokeddem
  **/
class InstructionFactoryImplTest extends Assertions {

  var instructionFactory: InstructionFactoryImpl = null

  @Before def initialize() {
    instructionFactory = new InstructionFactoryImpl
  }

  @Test def testCreateInstruction() {
    // Create a list of instruction with some unsupported instructions
    assertEquals(Some(List(Instruction.A, Instruction.A, Instruction.G, Instruction.A, Instruction.A, Instruction.D, Instruction.G, Instruction.A, Instruction.A)), instructionFactory.createInstruction("AAGEAADGAA"))
    // Create list of instruction from only unsupported instructions
    assertEquals(None, instructionFactory.createInstruction("IEH"))
  }
}
