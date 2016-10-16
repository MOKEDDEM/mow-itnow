package com.xebia.mowitnow.service

import com.xebia.mowitnow.model.Entity._
import com.xebia.mowitnow.model.Factory.{MowerFactoryImpl, GroundFactoryImpl}
import org.junit.Assert._
import org.junit.{Test, Before}
import org.scalatest.Assertions

/**
  * Mower service test
  * @author omokeddem
  **/
class MowerServiceImplTest extends Assertions {
  implicit var mowerFactory: MowerFactoryImpl = null
  implicit var groundFactory: GroundFactoryImpl = null
  implicit var groundService : GroundServiceImpl = null
  var mowerService: MowerServiceImpl = null
  var ground: Ground = null
  var mower: Mower = null

  @Before def initialize() {
    mowerFactory = new MowerFactoryImpl
    groundService = new GroundServiceImpl
    mowerService = new MowerServiceImpl
    ground = Ground(Dimension(1,1))
  }

  @Test
  def testTurnLeft() {
    mower = Mower(Position(1,1,Orientation.N))
    mower =  mowerService.applyInstruction(ground,mower,Instruction.G)
    assertEquals(Orientation.W, mower.position.orientation)
    mower =  mowerService.applyInstruction(ground,mower,Instruction.G)
    assertEquals(Orientation.S, mower.position.orientation)
    mower =  mowerService.applyInstruction(ground,mower,Instruction.G)
    assertEquals(Orientation.E, mower.position.orientation)
    mower =  mowerService.applyInstruction(ground,mower,Instruction.G)
    assertEquals(Orientation.N, mower.position.orientation)
  }

  @Test
  def testTurnRight() ={
    mower = Mower(Position(1,1,Orientation.N))
    mower =  mowerService.applyInstruction(ground,mower,Instruction.D)
    assertEquals(Orientation.E, mower.position.orientation)
    mower =  mowerService.applyInstruction(ground,mower,Instruction.D)
    assertEquals(Orientation.S, mower.position.orientation)
    mower =  mowerService.applyInstruction(ground,mower,Instruction.D)
    assertEquals(Orientation.W, mower.position.orientation)
    mower =  mowerService.applyInstruction(ground,mower,Instruction.D)
    assertEquals(Orientation.N, mower.position.orientation)
  }

  @Test
  def testMoveForwardToNorth() ={
    mower = Mower(Position(0,0,Orientation.N))
    mower =  mowerService.applyInstruction(ground,mower,Instruction.A)
    assertEquals(1, mower.position.y)
    mower =  mowerService.applyInstruction(ground,mower,Instruction.A)
    assertEquals(1, mower.position.y)
  }

  @Test
  def testMoveForwardToSouth() ={
    mower = Mower(Position(0,1,Orientation.S))
    mower =  mowerService.applyInstruction(ground,mower,Instruction.A)
    assertEquals(0, mower.position.y)
    mower =  mowerService.applyInstruction(ground,mower,Instruction.A)
    assertEquals(0, mower.position.y)
  }

  @Test
  def testMoveForwardToWest() ={
    mower = Mower(Position(1,0,Orientation.W))
    mower =  mowerService.applyInstruction(ground,mower,Instruction.A)
    assertEquals(0, mower.position.x)
    mower =  mowerService.applyInstruction(ground,mower,Instruction.A)
    assertEquals(0, mower.position.x)
  }

  @Test
  def testMoveForwardToEst() ={
    mower = Mower(Position(0,0,Orientation.E))
    mower =  mowerService.applyInstruction(ground,mower,Instruction.A)
    assertEquals(1, mower.position.x)
    mower =  mowerService.applyInstruction(ground,mower,Instruction.A)
    assertEquals(1, mower.position.x)
  }

}
