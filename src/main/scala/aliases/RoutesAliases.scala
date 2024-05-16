package aliases

import zio.http.Routes

type TaskRoutes = Routes[Any, Throwable]
type URRoutes[-Env] = Routes[Env, Nothing]
type RRoutes[-Env] = Routes[Env, Throwable]
