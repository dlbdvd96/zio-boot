import aliases.URRoutes
import layers.{CounterService, HelloService}
import openapi.SwaggerRoutes
import routes.{CounterRoutes, HelloRoutes}

object AppRoutes:

  def apply(): URRoutes[HelloService & CounterService] =
    SwaggerRoutes() ++ CounterRoutes() ++ HelloRoutes()
