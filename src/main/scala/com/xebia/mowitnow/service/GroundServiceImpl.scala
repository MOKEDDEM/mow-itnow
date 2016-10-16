package com.xebia.mowitnow.service

import com.xebia.mowitnow.model.Entity.{Position, Ground}
import com.xebia.mowitnow.model.Factory.GroundFactory
import org.slf4j.LoggerFactory

/**
  * Ground service implementation
  * @author omokeddem
  **/
class GroundServiceImpl(implicit groundFactory: GroundFactory) extends GroundService {
  val logger = LoggerFactory.getLogger(classOf[App])

  /**
    * Use GroundFactory to parse the first line of input file to a Ground object.
    *
    * @param groundData the first line of the input file
    * @return Option[Ground] object
    */
  def getGround(groundData: String): Option[Ground] = {
    groundFactory.createGround(groundData)
  }

  /**
    * Checks whether the position is inside the boundaries of the ground.
    *
    * @param ground the ground object
    * @param position current position
    * @return Boolean
    */
  def isInsideGround(ground: Ground, position: Position): Boolean = {
    if (position.x < 0 || position.x > ground.dimension.width ||
      position.y < 0 || position.y > ground.dimension.height) {
      logger.warn(position.x + " , " + position.y + " are outside of the boundaries of ground " + ground.dimension.width + " , " + ground.dimension.height)
      false
    }
    else
      true
  }
}
