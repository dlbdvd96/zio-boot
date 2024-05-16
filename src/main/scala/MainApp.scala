import zio.http.Server
import zio.{Task, ZIOAppDefault, ZLayer}

object MainApp extends ZIOAppDefault:

  override def run: Task[Nothing] =
    Server.serve(MainRoutes.routes).provide(MainLayer.layer)
