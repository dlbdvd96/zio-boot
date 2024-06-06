import aliases.URRoutes
import controllers.HelloControllers.hello
import controllers.{CounterControllers, HelloControllers}
import layers.{CounterService, HelloService}
import openapi.SwaggerRoutes
import zio.http.Routes

object AppRoutes:

  val routes: URRoutes[HelloService & CounterService] =
    SwaggerRoutes() ++
      Routes(
        CounterControllers.count.route,
        HelloControllers.hello.route
      )
