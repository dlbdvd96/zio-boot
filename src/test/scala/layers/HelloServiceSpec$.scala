package layers

import aliases.TestSuite
import layers.*
import mocks.ServiceBMock
import zio.*
import zio.ZIO.{service, serviceWithZIO}
import zio.mock.Expectation
import zio.mock.Expectation.value
import zio.test.Assertion.equalTo
import zio.test.{Assertion, Spec, TestResult, ZIOSpecDefault, assertZIO}

object HelloServiceSpec$ extends ZIOSpecDefault:

  val mockServiceB: Expectation[ServiceB] = ServiceBMock
    .ToLower(equalTo("ciao"), value("test"))

  def spec: TestSuite = suite("ServiceASpec")(
    test("getLower should return input as lowercase") {
      // Given
      val testSubject = serviceWithZIO[HelloService]

      // When
      val actualResult: RIO[HelloService, String] =
        testSubject(_.getHello("ciao"))

      // Then
      assertZIO(actualResult)(equalTo("test"))
    }
  ).provideShared(ZLayer.derive[HelloService], mockServiceB)
