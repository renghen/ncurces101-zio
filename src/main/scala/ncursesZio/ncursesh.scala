package ncursesZio

import scala.scalanative.unsafe.{CChar, CInt, CShort, CStruct0, Ptr}

import ncursesZio.Ncurses

object Ncursesh:
  type ChType = CChar

  case class Size(width: Int, height: Int)

  def colorPair(pair: CShort): Attribute = new Attribute(
    Ncurses.colorPair0(pair),
  )

  def windowSize(window: Ptr[Window]): Size = {
    val width  = Ncurses.getmaxx0(window)
    val height = Ncurses.getmaxy0(window)
    Size(width, height)
  }

  type Window = CStruct0

  class CursorVisibility(val value: CInt) extends AnyVal
  object CursorVisibility {
    final val Invisible   = new CursorVisibility(0)
    final val Visible     = new CursorVisibility(1)
    final val VeryVisible = new CursorVisibility(2)
  }

  class Color(val value: CInt) extends AnyVal
  object Color {
    final val Transparent = new Color(-1)
    final val Black       = new Color(0)
    final val Red         = new Color(1)
    final val Green       = new Color(2)
    final val Yellow      = new Color(3)
    final val Blue        = new Color(4)
    final val Magenta     = new Color(5)
    final val Cyan        = new Color(6)
    final val White       = new Color(7)
  }
  class Attribute(val value: CInt) extends AnyVal
end Ncursesh
