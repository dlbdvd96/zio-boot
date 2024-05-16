package layers

import zio.UIO

class HelloService(serviceB: ServiceB):
  def getHello(s: String): UIO[String] = serviceB.toLower(s)
