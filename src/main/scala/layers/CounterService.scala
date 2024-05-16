package layers

import zio.{Ref, UIO}

class CounterService:
  val value: UIO[Ref[Int]] = Ref.make(0)

  def inc: UIO[Unit] = value.flatMap(_.update(_ - 1))
  def dec: UIO[Unit] = value.flatMap(_.update(_ - 1))
  def get: UIO[Int] = value.flatMap(_.get)
