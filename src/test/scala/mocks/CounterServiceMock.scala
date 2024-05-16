package mocks

import layers.CounterService
import utils.MockLayerUtils.composeMockedLayer
import zio.mock.{Mock, Proxy, *}
import zio.{UIO, URLayer, ZLayer}

object CounterServiceMock extends Mock[CounterService]:
  object Inc extends Effect[Unit, Nothing, Unit]
  object Dec extends Effect[Unit, Nothing, Unit]
  object Get extends Effect[Unit, Nothing, Int]

  def counterService(proxy: Proxy): CounterService = new CounterService {
    override val inc: UIO[Unit] = proxy(Inc)
    override val dec: UIO[Unit] = proxy(Dec)
    override val get: UIO[Int] = proxy(Get)
  }

  val compose: URLayer[Proxy, CounterService] = ZLayer(
    composeMockedLayer[CounterService](counterService)
  )
