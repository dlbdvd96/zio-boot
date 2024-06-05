import layers.{CounterService, HelloService, ServiceB}
import zio.http.Server
import zio.{Tag, TaskLayer, ZIO, ZLayer}

object AppLayers:

  val layers: TaskLayer[Server & HelloService & CounterService] =
    ZLayer.make[Server & HelloService & CounterService](
      Server.default,
      ZLayer.derive[HelloService],
      ZLayer.derive[ServiceB],
      ZLayer.fromZIO(CounterService())
    )
