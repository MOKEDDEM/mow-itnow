package com.xebia.mowitnow.model.Factory

import com.xebia.mowitnow.model.Entity.Ground

/**
  * Ground Factory Interface
  * @author omokeddem
  **/
trait GroundFactory {
  def createGround(groundData: String): Option[Ground]
}
