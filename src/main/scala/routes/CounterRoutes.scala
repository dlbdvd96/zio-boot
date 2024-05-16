package routes

import aliases.URRoutes
import layers.CounterService
import zio.http.*

object CounterRoutes:
  val routes: URRoutes[CounterService] = Routes(
    Method.GET / "count" -> handler((_: Request) =>
      withContext((counterService: CounterService) =>
        for {
          _ <- counterService.inc
          value <- counterService.get
        } yield Response.text(value.toString)
      )
    )
  )
