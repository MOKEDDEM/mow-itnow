package com.xebia.mowitnow.model.factory

import com.xebia.mowitnow.model.Entity.{Dimension, Ground}
import com.xebia.mowitnow.model.Factory.GroundFactoryImpl
import org.junit.Assert._
import org.junit.{Test, Before}
import org.scalatest.Assertions

/**
  * Ground factory test
  * @author omokeddem
  **/
class GroundFactoryImplTest extends Assertions {

  var groundFactory: GroundFactoryImpl = null

  @Before def initialize() {
    groundFactory = new GroundFactoryImpl
  }

  @Test def testCreateGround() {

    assertEquals(Some(Ground(Dimension(5, 5))), groundFactory.createGround("5 5"))
    assertEquals(Some(Ground(Dimension(5, 5))), groundFactory.createGround("  5   5  "))
    // Handling of unsupported format of ground
    assertEquals(None, groundFactory.createGround("A 5"))
    assertEquals(None, groundFactory.createGround(""))
    assertEquals(None, groundFactory.createGround("5.5 5"))
    assertEquals(None, groundFactory.createGround("-1 5"))
  }
}
