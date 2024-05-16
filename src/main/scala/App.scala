import AppLayers.layers
import AppRoutes.routes
import zio.http.Server
import zio.{Task, ZIOAppDefault, ZLayer}

object App extends ZIOAppDefault:

  override def run: Task[Nothing] = routes.serve.provide(layers)
