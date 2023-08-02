package ncursesZio

import scala.scalanative.unsafe.{
  extern,
  link,
  name,
  CChar,
  CInt,
  CShort,
  CString,
  CStruct0,
  CVarArg,
  Ptr,
}

@link("ncurses")
@extern
object Ncurses:
  import Ncursesh.*

  @name("initscr")
  def initialzeScreen(): Ptr[Window] = extern

  def printw(str: CString): CInt = extern

  def refresh(): CInt = extern

  def clear(): Unit = extern

  def move(row: CInt, col: CInt): CInt = extern

  def mvprintw(
      row: CInt,
      col: CInt,
      str: CString,
    ): CInt = extern

  @name("curs_set")
  def setCursorVisibility(visibility: CursorVisibility): CInt = extern

  @name("newwin")
  def newWindow(
      nlines: Int,
      ncols: Int,
      begin_y: Int,
      begin_x: Int,
    ): Ptr[Window] = extern

  @name("delwin")
  def deleteWindow(window: Ptr[Window]): Unit = extern

  @name("endwin")
  def endWindow(): Unit = extern

  @name("werase")
  def eraseWindow(window: Ptr[Window]): CInt = extern

  @name("wnoutrefresh")
  def refreshWindow(window: Ptr[Window]): CInt = extern

  @name("wrefresh")
  def wRefresh(window: Ptr[Window]): CInt = extern

  def doupdate(): CInt = extern

  def box(
      window: Ptr[Window],
      verch: ChType,
      horch: ChType,
    ): CInt = extern

  def wprintw(window: Ptr[Window], str: CString): CInt = extern

  @name("mvwprintw")
  def printFormatted(
      window: Ptr[Window],
      y: CInt,
      x: CInt,
      fmt: CString,
      args: CVarArg*,
    ): CInt = extern

  @name("mvwaddch")
  def printChar(
      window: Ptr[Window],
      y: CInt,
      x: CInt,
      ch: ChType,
    ): CInt =
    extern

  @name("mvwvline")
  def printLine(
      WINDwindow: Ptr[Window],
      y: CInt,
      x: CInt,
      ch: ChType,
      n: CInt,
    ): CInt = extern

  def noecho(): Unit = extern

  def getch(): CInt = extern

  def timeout(delay: CInt): Unit = extern

  @name("has_colors")
  def hasColors(): Boolean = extern

  @name("start_color")
  def startColor(): Unit = extern

  @name("use_default_colors")
  def useDefaultColors(): Unit = extern

  @name("wattron")
  def attributeOn(window: Ptr[Window], attribute: Attribute): CInt = extern

  @name("wattroff")
  def attributeOff(window: Ptr[Window], attribute: Attribute): CInt = extern

  @name("init_pair")
  def initPair(
      pair: CShort,
      foreground: Color,
      background: Color,
    ): CInt =
    extern

  @name("COLOR_PAIR")
  def colorPair0(pair: CShort): CInt = extern

  @name("getmaxx")
  def getmaxx0(window: Ptr[Window]): Int = extern

  @name("getmaxy")
  def getmaxy0(window: Ptr[Window]): Int = extern

  def stdscr: Ptr[Window] = extern
end Ncurses
