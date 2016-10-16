package com.xebia.mowitnow.service

import com.xebia.mowitnow.model.Entity.{Position, Ground}

/**
  * Ground service interface
  * @author omokeddem
  **/
trait GroundService {
def getGround(groundData: String): Option[Ground]
def isInsideGround(ground: Ground ,position: Position): Boolean
}
