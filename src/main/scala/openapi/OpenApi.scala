package openapi

import endpoints.{CounterEndpoints, HelloEndpoints}
import zio.http.endpoint.openapi.{OpenAPI, OpenAPIGen}

object OpenApi:
  val openAPI: OpenAPI =
    OpenAPIGen.fromEndpoints(
      title = "App API",
      version = "1.0",
      HelloEndpoints.hello,
      CounterEndpoints.count
    )
