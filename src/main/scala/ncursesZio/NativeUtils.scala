package ncursesZio

import scalanative.unsafe.Zone
import scalanative.unsafe.toCString

object NativeUtils:
  extension (str: String)
    def toCStr =
      Zone { z =>
        given z1: Zone = z
        toCString(str)
      }
  end extension
