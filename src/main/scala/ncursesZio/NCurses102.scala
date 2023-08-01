package ncursesZio

import scala.scalanative.unsafe.Ptr

import ncursesZio.Ncursesh.Window
import zio.{Console, Scope, Task, ZIO, ZIOAppDefault}

import scalanative.unsafe.CQuote
import scalanative.unsafe.toCString
import ncursesZio.NCurses102

object NCurses102 extends ZIOAppDefault:
  import Ncurses.*
  import NativeUtils.*

  val init: ZIO[Any, Throwable, Ptr[Window]] = ZIO.attempt(initialzeScreen())
  def release(window: Ptr[Window])           = ZIO.succeed(endWindow())

  val result = ZIO.acquireReleaseWith(init)(release) { res =>
    ZIO.attempt(printw("hello world 2".toCStr)) *> ZIO.attempt(refresh()) *> ZIO.attempt(getch())
  }

  val resource = ZIO.acquireRelease(init)(release)

  def run =
    resource.flatMap { _ =>
      ZIO.attempt(printw("hello world 2".toCStr)) *> ZIO.attempt(refresh()) *> ZIO.attempt(getch())
    }
end NCurses102
