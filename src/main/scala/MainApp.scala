import zio.http.Server
import zio.{Task, ZIOAppDefault, ZLayer}

object MainApp extends ZIOAppDefault:

  override def run: Task[Nothing] =
    MainRoutes.routes.serve.provide(MainLayer.layer)
