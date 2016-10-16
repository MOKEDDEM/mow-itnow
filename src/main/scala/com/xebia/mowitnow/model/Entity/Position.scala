package com.xebia.mowitnow.model.Entity

/**
  * Position data model.
  * @param x current x coordinate
  * @param y current y coordinate
  * @param orientation current orientation (N,E,S,W)
  * @author omokeddem
  **/

case class Position (x : Int, y: Int, orientation: Orientation.Value)
