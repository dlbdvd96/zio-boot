package controllers

import layers.HelloService
import utils.Controller
import zio.Tag
import zio.http.RoutePattern.POST
import zio.http.endpoint.Endpoint

object HelloControllers:

  val hello = Controller(
    Endpoint(POST / "hello-world").in[String].out[Map[String, Int]],
    (request: String, helloService: HelloService) =>
      helloService.getHello(request).map(s => Map(s -> 1))
  )
