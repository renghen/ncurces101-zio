package ncursesZio

import scala.scalanative.unsafe.Ptr

import zio.ZIO

import ncursesZio.Ncurses.{deleteWindow, endWindow, initialzeScreen, newWindow}
import ncursesZio.Ncursesh.Window

object NCursesUtils {
  def init(): ZIO[Any, Throwable, Ptr[Window]] = ZIO.attempt(initialzeScreen())
  def release(window: Ptr[Window])             = ZIO.succeed(endWindow())
  def initWin(
      height: Int,
      width: Int,
      startY: Int,
      startX: Int,
    ): ZIO[Any, Throwable, Ptr[Window]] =
    ZIO.attempt(newWindow(height, width, startY, startX))

  def releaseWin(window: Ptr[Window]) = ZIO.succeed(deleteWindow(window))
}
