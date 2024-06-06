package controllers

import layers.CounterService
import utils.Controller
import zio.ZNothing
import zio.http.RoutePattern.GET
import zio.http.endpoint.Endpoint

object CounterControllers:

  val count: Controller[Unit, CounterService, ZNothing, Int] = Controller(
    Endpoint(GET / "count").out[Int],
    (counterService: CounterService) =>
      for {
        _ <- counterService.inc
        value <- counterService.get
      } yield value
  )
