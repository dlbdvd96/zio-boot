package mocks

import layers.ServiceB
import utils.MockLayerUtils.{composeMockedLayer, runUnsafe}
import zio.mock.{Mock, Proxy}
import zio.{Runtime, UIO, URLayer, ZLayer}

object ServiceBMock extends Mock[ServiceB]:
  object ToLower extends Effect[String, Nothing, String]

  def serviceB(proxy: Proxy): ServiceB = new ServiceB(null) {
    override def toLower(s: String): UIO[String] = proxy(ToLower, s)
  }

  val compose: URLayer[Proxy, ServiceB] = ZLayer(
    composeMockedLayer[ServiceB](serviceB)
  )
