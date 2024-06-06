package utils

import aliases.URRoute
import zio.http.endpoint.EndpointMiddleware.None
import zio.http.endpoint.{Endpoint, EndpointMiddleware}
import zio.http.{handler, withContext}
import zio.{Tag, ZIO}

case class Controller[Input, Context: Tag, Err, Output](
    endpoint: Endpoint[Unit, Input, Err, Output, None],
    route: URRoute[Context]
)

object Controller:

  def apply[Context: Tag, Err, Output](
      endpoint: Endpoint[Unit, Unit, Err, Output, None],
      handlerFn: Context => ZIO[Context, Err, Output]
  ) = new Controller(
    endpoint,
    endpoint.implement(handler(withContext((ctx: Context) => handlerFn(ctx))))
  )

  def apply[Input, Context: Tag, Err, Output](
      endpoint: Endpoint[Unit, Input, Err, Output, None],
      handlerFn: (Input, Context) => ZIO[Context, Err, Output]
  ) = new Controller(
    endpoint,
    endpoint.implement(
      handler((req: Input) =>
        withContext((ctx: Context) => handlerFn(req, ctx))
      )
    )
  )
