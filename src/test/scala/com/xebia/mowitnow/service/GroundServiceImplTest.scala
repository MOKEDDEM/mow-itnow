package com.xebia.mowitnow.service

import com.xebia.mowitnow.model.Entity.{Orientation, Position, Dimension, Ground}
import com.xebia.mowitnow.model.Factory.GroundFactoryImpl
import org.junit.Assert._
import org.junit.{Test, Before}
import org.scalatest.Assertions

/**
  * Ground service test
  * @author omokeddem
  **/
class GroundServiceImplTest extends Assertions {
  implicit var groundFactory: GroundFactoryImpl = null
  var groundService: GroundServiceImpl = null

  @Before def initialize() {
    groundFactory = new GroundFactoryImpl
    groundService = new GroundServiceImpl
  }

  @Test def testIsInsideGround() {
    val ground = Ground(Dimension(5,5))
    assertEquals(true, groundService.isInsideGround(ground,Position(1,5,Orientation.N)))
    assertEquals(false, groundService.isInsideGround(ground,Position(-1,5,Orientation.N)))
    assertEquals(false, groundService.isInsideGround(ground,Position(5,6,Orientation.N)))
    assertEquals(false, groundService.isInsideGround(ground,Position(6,5,Orientation.N)))
  }
}
