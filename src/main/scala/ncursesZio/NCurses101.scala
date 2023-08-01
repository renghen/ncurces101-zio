package ncursesZio

import ncursesZio.NCurses101

import scalanative.unsafe.toCString
import scalanative.unsafe.Zone

object NCurses101 extends App:
  import Ncurses.*
  import NativeUtils.*
  initialzeScreen()
  printw("hello world".toCStr)
  refresh()
  getch()
  endWindow()
end NCurses101
