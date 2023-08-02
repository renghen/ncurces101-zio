package ncursesZio

import ncursesZio.NCurses101

import scalanative.unsafe.toCString
import scalanative.unsafe.Zone

object NCurses101 extends App:
  import Ncurses.*
  import NativeUtils.*
  initialzeScreen()
  printw("hello world".toCStr)
  val win = newWindow(5, 15, 5, 5)
  refresh()
  box(win, 0, 0)
  wprintw(win, "hello".toCStr)
  wRefresh(win)
  getch()
  endWindow()
end NCurses101
