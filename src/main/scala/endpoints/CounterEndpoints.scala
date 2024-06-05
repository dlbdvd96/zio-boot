package endpoints

import zio.http.*
import zio.http.RoutePattern.GET
import zio.http.endpoint.Endpoint

object CounterEndpoints:
  val count = Endpoint(GET / "count").out[Int]
