package ncursesZio

import scala.scalanative.unsafe.Ptr

import ncursesZio.Ncursesh.Window
import zio.{Console, Scope, Task, ZIO, ZIOAppDefault}

import scalanative.unsafe.CQuote
import scalanative.unsafe.toCString

object NCurses103 extends ZIOAppDefault:
  import Ncurses.*
  import NativeUtils.*

  val init: ZIO[Any, Throwable, Ptr[Window]] = ZIO.attempt(initialzeScreen())
  def release(window: Ptr[Window])           = ZIO.succeed(endWindow())

  val resource = ZIO.acquireRelease(init)(release)

  def run =
    resource.flatMap { _ =>
      ZIO.attempt(move(5,10))  *>
      ZIO.attempt(printw("location moved".toCStr)) *>
      ZIO.attempt(mvprintw(10,10,"new location".toCStr)) *>
      ZIO.attempt(refresh()) *>
      ZIO.attempt(getch())
    }
end NCurses103
