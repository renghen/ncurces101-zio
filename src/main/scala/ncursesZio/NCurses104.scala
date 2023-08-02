package ncursesZio

import zio.{ExitCode, ZIO, ZIOAppDefault}

import ncursesZio.Ncursesh.Window

import scalanative.unsafe.Ptr

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
      _   <- ZIO.attempt(wprintw(win, "title".toCStr))
      _   <- ZIO.attempt(wRefresh(win))
      _   <- ZIO.attempt(getch())
    yield ExitCode.success
end NCurses104
