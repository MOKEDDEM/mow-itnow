package com.xebia.mowitnow.model.Entity

/**
  * Mower data model.
  * @param position current position
  * @author omokeddem
  **/
case class Mower(position :Position) {
  def print = this.position.x + " " + this.position.y + " " + this.position.orientation.toString
}
