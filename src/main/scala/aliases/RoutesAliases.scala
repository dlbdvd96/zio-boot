package aliases

import zio.http.{Route, Routes}

type URRoute[-Env] = Route[Env, Nothing]

type URoutes = Routes[Any, Nothing]
type URRoutes[-Env] = Routes[Env, Nothing]
