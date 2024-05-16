import aliases.URRoutes
import layers.{CounterService, HelloService}
import routes.{CounterRoutes, HelloRoutes}

object MainRoutes:

  val routes: URRoutes[HelloService & CounterService] =
    HelloRoutes.routes.sandbox ++ CounterRoutes.routes.sandbox
