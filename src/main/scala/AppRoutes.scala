import aliases.URRoutes
import controllers.HelloControllers.hello
import controllers.{CounterControllers, HelloControllers}
import layers.{CounterService, HelloService}
import openapi.Swagger
import zio.http.Routes

object AppRoutes:

  val routes: URRoutes[HelloService & CounterService] =
    Swagger.routes ++ Routes(
      CounterControllers.count.route,
      HelloControllers.hello.route
    )
