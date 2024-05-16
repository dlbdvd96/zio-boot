package handlers

import layers.HelloService
import zio.RIO
import zio.direct.*
import zio.http.{Request, Response, withContext}

object HelloWorldHandler:
  def handle(request: Request): RIO[HelloService, Response] =
    withContext((helloService: HelloService) =>
      defer:
        val req = request.body.asString.run
        Response.text(helloService.getHello(req).run)
    )
