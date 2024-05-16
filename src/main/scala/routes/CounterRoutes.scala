package routes

import aliases.URRoutes
import layers.CounterService
import zio.direct.*
import zio.http.*

object CounterRoutes:
  val routes: URRoutes[CounterService] = Routes(
    Method.GET / "count" -> handler((_: Request) =>
      withContext((counterService: CounterService) =>
        defer:
          counterService.inc.run
          Response.text(counterService.get.run.toString)
      )
    )
  )
