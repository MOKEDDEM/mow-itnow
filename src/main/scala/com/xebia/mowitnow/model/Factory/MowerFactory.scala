package com.xebia.mowitnow.model.Factory

import com.xebia.mowitnow.model.Entity.Mower

/**
  * Mower Factory Interface
  * @author omokeddem
  **/
trait MowerFactory {
def createMower(mowerData: String): Option[Mower]
}
