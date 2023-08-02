package ncursesZio

import zio.{ZIO, ZIOAppDefault}

import ncursesZio.Ncursesh.Window

import scalanative.unsafe.Ptr

object NCurses103 extends ZIOAppDefault:
  import Ncurses.*
  import NativeUtils.*
  import NCursesUtils.*

  val resource = ZIO.acquireRelease(init())(release)

  def run =
    resource.flatMap { _ =>
      ZIO.attempt(move(5, 10)) *>
        ZIO.attempt(printw("location moved".toCStr)) *>
        ZIO.attempt(mvprintw(10, 10, "new location".toCStr)) *>
        ZIO.attempt(refresh()) *>
        ZIO.attempt(getch())
    }
end NCurses103
