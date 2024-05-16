package mocks

import layers.HelloService
import utils.MockLayerUtils.composeMockedLayer
import zio.mock.{Mock, Proxy, *}
import zio.{UIO, URLayer, ZLayer}

object HelloServiceMock extends Mock[HelloService]:
  object GetLower extends Effect[String, Nothing, String]

  def serviceA(proxy: Proxy): HelloService = new HelloService(null) {
    override def getHello(s: String): UIO[String] = proxy(GetLower, s)
  }

  val compose: URLayer[Proxy, HelloService] = ZLayer(
    composeMockedLayer[HelloService](serviceA)
  )
