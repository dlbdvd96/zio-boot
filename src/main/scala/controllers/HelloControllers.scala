package controllers

import layers.HelloService
import utils.Controller
import zio.http.RoutePattern.POST
import zio.http.endpoint.Endpoint
import zio.{Tag, ZNothing}

object HelloControllers:

  val hello: Controller[String, HelloService, ZNothing, Map[String, Int]] =
    Controller(
      Endpoint(POST / "hello-world").in[String].out[Map[String, Int]],
      (request: String, helloService: HelloService) =>
        helloService.getHello(request).map(s => Map(s -> 1))
    )
