package routes

import aliases.RRoutes
import handlers.HelloWorldHandler
import layers.HelloService
import zio.http.*

object HelloRoutes:
  val routes: RRoutes[HelloService] = Routes(
    Method.GET / "hello-world" -> handler(HelloWorldHandler.handle)
  )
