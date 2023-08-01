package ncursesZio

import zio.{Console, Scope, Task, ZIO, ZIOAppDefault}

import ncursesZio.NCurses102
import ncursesZio.Ncursesh.Window

import scalanative.unsafe.Ptr
import scalanative.unsafe.toCString

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
