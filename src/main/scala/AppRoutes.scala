import aliases.URRoutes
import layers.{CounterService, HelloService}
import routes.{CounterRoutes, HelloRoutes}

object AppRoutes:

  val routes: URRoutes[HelloService & CounterService] =
    (HelloRoutes.routes ++ CounterRoutes.routes).sandbox
