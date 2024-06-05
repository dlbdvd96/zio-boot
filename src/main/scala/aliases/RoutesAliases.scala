package aliases

import zio.http.{Route, Routes}

type URRoute[-Env] = Route[Env, Nothing]
type TaskRoutes = Routes[Any, Throwable]
type IORoutes[+Err] = Routes[Any, Err]
type URoutes = Routes[Any, Nothing]
type URRoutes[-Env] = Routes[Env, Nothing]
