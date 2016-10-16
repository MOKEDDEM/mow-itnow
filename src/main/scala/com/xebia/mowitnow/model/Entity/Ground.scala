package com.xebia.mowitnow.model.Entity

/**
  * Ground data model.
  * @param dimension dimension of the ground
  * @author omokeddem
  */
case class Ground (dimension: Dimension){
  def print = this.dimension.width + " " + this.dimension.height
}
