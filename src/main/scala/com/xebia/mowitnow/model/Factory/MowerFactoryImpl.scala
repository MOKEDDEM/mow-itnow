package com.xebia.mowitnow.model.Factory

import com.xebia.mowitnow.model.Entity.{Orientation, Position, Mower}
import org.slf4j.LoggerFactory

/**
  * Mower Factory Implementation
  * @author omokeddem
  **/
class MowerFactoryImpl extends MowerFactory{
  final val mowerPattern = "(\\s*\\d+\\s+\\d+\\s+[NEWS]\\s*)".r
  final val positionPattern = "(\\d+)".r
  final val orientationPattern = "([NEWS])".r
  val logger = LoggerFactory.getLogger(classOf[App])
  /**
    * Parse the input string to a mower object.
    *
    * @param mowerData the line of mower position and orientation in the input file like (1 2 N)
    * @return Mower object
    */
  def createMower(mowerData: String): Option[Mower] = {
    mowerData match {
      case mowerPattern(c) => {
        val position = (positionPattern findAllIn mowerData).toList
        val orientation = (orientationPattern findAllIn mowerData).toList
        logger.info("the mower object was created successfully from {}",mowerData)
        Some(Mower(Position(position(0).toInt, position(1).toInt,Orientation.withName(orientation(0)))))
      }
      case _ =>{
        logger.error("Can't create mower object from {}", mowerData)
        None
      }
    }}
}
