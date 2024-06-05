package routes

import aliases.{URRoute, URRoutes}
import endpoints.CounterEndpoints
import layers.CounterService
import zio.http.*

object CounterRoutes:

  val count: URRoute[CounterService] = CounterEndpoints.count
    .implement(
      handler(
        withContext((counterService: CounterService) =>
          for {
            _ <- counterService.inc
            value <- counterService.get
          } yield value
        )
      )
    )