package openapi

import aliases.URoutes
import openapi.OpenApi.openAPI
import zio.http.*
import zio.http.codec.PathCodec.*
import zio.http.endpoint.openapi.{OpenAPI, SwaggerUI}

object SwaggerRoutes:
  def apply(): URoutes =
    SwaggerUI.routes("docs" / "openapi", openAPI).sandbox
