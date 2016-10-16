package com.xebia.mowitnow.model.Entity

/**
  * An Instruction defined with a constants point.
  * D to turn 90 deg to right.
  * G to turn 90 deg to left.
  * A to move forward one step.
  * @author omokeddem
  */
object Instruction extends Enumeration {
  val D, G, A = Value
}
