package com.xebia.mowitnow.model.factory

import com.xebia.mowitnow.model.Entity.{Orientation, Mower, Position}
import com.xebia.mowitnow.model.Factory.MowerFactoryImpl
import org.junit.Assert._
import org.junit.{Test, Before}
import org.scalatest.Assertions

/**
  * Mower factory test
  * @author omokeddem
  **/
class MowerFactoryImplTest  extends Assertions {

var mowerFactory: MowerFactoryImpl = null

@Before def initialize() {
  mowerFactory = new MowerFactoryImpl
}

@Test def testCreateMower() {
// Create mower with position 1,5 & orientation N
  assertEquals(Some(Mower(Position(1,5, Orientation.N))), mowerFactory.createMower("1 5 N"))
 //Try to create mower with unsupported orientation
  assertEquals(None, mowerFactory.createMower("1 5 A"))
}
}
