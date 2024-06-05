import zio.http.Server
import zio.{Task, ZIOAppDefault, ZLayer}

object App extends ZIOAppDefault:

  override def run: Task[Nothing] = AppRoutes().serve.provide(AppLayers())
