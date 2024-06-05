package routes

import aliases.{URRoute, URRoutes}
import endpoints.HelloEndpoints
import layers.HelloService
import zio.http.*

object HelloRoutes:

  def apply(): URRoutes[HelloService] = Routes(hello)

  val hello: URRoute[HelloService] =
    HelloEndpoints.hello.implement(
      handler((request: String) =>
        withContext((helloService: HelloService) =>
          helloService.getHello(request).map(s => Map(s -> 1))
        )
      )
    )
