package endpoints

import zio.http.*
import zio.http.RoutePattern.POST
import zio.http.endpoint.Endpoint

object HelloEndpoints:
  val hello = Endpoint(POST / "hello-world").in[String].out[Map[String, Int]]
