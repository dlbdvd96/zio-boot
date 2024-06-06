package openapi

import aliases.URoutes
import controllers.{CounterControllers, HelloControllers}
import zio.http.*
import zio.http.codec.PathCodec.*
import zio.http.endpoint.openapi.{OpenAPI, OpenAPIGen, SwaggerUI}

object SwaggerRoutes:
  private val openAPI: OpenAPI =
    OpenAPIGen.fromEndpoints(
      title = "App API",
      version = "1.0",
      HelloControllers.hello.endpoint,
      CounterControllers.count.endpoint
    )

  def apply(): URoutes = SwaggerUI.routes("docs" / "openapi", openAPI).sandbox
