import aliases.URRoutes
import layers.{CounterService, HelloService}
import openapi.SwaggerRoutes
import routes.HelloRoutes.hello
import routes.{CounterRoutes, HelloRoutes}
import zio.http.Routes

object AppRoutes:

  val routes: URRoutes[HelloService & CounterService] =
    SwaggerRoutes.routes ++ Routes(CounterRoutes.count, HelloRoutes.hello)
