package layers

import zio.UIO

class ServiceB(counterService: CounterService):
  def toLower(s: String): UIO[String] =
    for {
      _ <- counterService.inc
      value <- counterService.get
    } yield s"${s.toLowerCase}-$value"
