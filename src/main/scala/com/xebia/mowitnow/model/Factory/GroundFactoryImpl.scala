package com.xebia.mowitnow.model.Factory

import com.xebia.mowitnow.model.Entity.{Dimension, Ground}
import org.slf4j.LoggerFactory

/**
  * Ground Factory Implementation
  * @author omokeddem
  **/
class GroundFactoryImpl extends GroundFactory {
  final val groundPattern = "(\\s*\\d+\\s+\\d+\\s*)".r
  final val dimensionPattern = "(\\d+)".r
  val logger = LoggerFactory.getLogger(classOf[App])

  /**
    * Parse the input string to a Ground object.
    *
    * @param groundData the first line of input file like (5 5)
    * @return Ground object
    */
  def createGround(groundData: String): Option[Ground] = {

    groundData match {
      case groundPattern(c) => {
        val dimensions = (dimensionPattern findAllIn groundData).toList
        if (dimensions(0).toInt > 0 && dimensions(1).toInt > 0) {
          logger.info("the ground was created successfully from {}",groundData)
          Some(Ground(Dimension(dimensions(0).toInt, dimensions(1).toInt)))
        }
        else {
          logger.error("Width and height must be >= 1")
          None
        }
      }
      case _ => {
        logger.error("Can't create ground object from {}", groundData)
        None
      }
    }
  }
}
