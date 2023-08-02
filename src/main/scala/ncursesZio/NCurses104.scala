package ncursesZio

import zio.{ExitCode, ZIO, ZIOAppDefault}

import ncursesZio.Ncursesh.Window

import scalanative.unsafe.Ptr


/**
  * windowing functions
  */
object NCurses104 extends ZIOAppDefault:
  import Ncurses.*
  import NativeUtils.*
  import NCursesUtils.*

  val initScreenRes = ZIO.acquireRelease(init())(release)
  val winRes        = ZIO.acquireRelease(initWin(8, 20, 2, 10))(releaseWin)

  def run =
    for
      _   <- initScreenRes
      win <- winRes
      _   <- ZIO.attempt(refresh())
      _   <- ZIO.attempt(box(win, 0, 0))
      _   <- ZIO.attempt(printFormatted(win, 0, 7, "window".toCStr))
      _   <- ZIO.attempt(wRefresh(win))
      _   <- ZIO.attempt(getch())
    yield ExitCode.success
end NCurses104
