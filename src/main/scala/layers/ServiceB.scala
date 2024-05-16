package layers

import zio.UIO
import zio.direct.*

class ServiceB(counterService: CounterService):
  def toLower(s: String): UIO[String] =
    defer:
      counterService.inc.run
      s"${s.toLowerCase}-${counterService.get.run}"
