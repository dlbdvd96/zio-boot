package layers

import zio.{Ref, UIO}

class CounterService(value: Ref[Int]):
  def inc: UIO[Unit] = value.update(_ + 1)
  def dec: UIO[Unit] = value.update(_ - 1)
  def get: UIO[Int] = value.get

object CounterService:
  def apply(): UIO[CounterService] = Ref.make(0).map(new CounterService(_))
