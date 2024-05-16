package utils

import zio.mock.Proxy
import zio.{URIO, *}

object MockLayerUtils:
  def composeMockedLayer[R](
      serviceProvider: (Runtime[Proxy], Proxy) => R,
      withRuntime: (Runtime[Proxy] => UIO[R]) => URIO[Proxy, R]
  ): URIO[Proxy, R] =
    ZIO.serviceWithZIO[Proxy](proxy =>
      withRuntime(runtime => ZIO.succeed(serviceProvider(runtime, proxy)))
    )

  def composeMockedLayer[R](
      serviceProvider: Proxy => R
  ): URIO[Proxy, R] = ZIO.serviceWith[Proxy](serviceProvider)

  def runUnsafe[A](runtime: Runtime[Proxy], safeMethod: RIO[Proxy, A]): A =
    Unsafe.unsafe(implicit unsafe =>
      runtime.unsafe.run(safeMethod).getOrThrowFiberFailure()
    )
