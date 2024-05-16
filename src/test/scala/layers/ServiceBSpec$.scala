package layers

import aliases.TestSuite
import layers.*
import mocks.CounterServiceMock
import zio.*
import zio.ZIO.{service, serviceWithZIO}
import zio.mock.Expectation
import zio.mock.Expectation.value
import zio.test.Assertion.equalTo
import zio.test.{Assertion, Spec, TestResult, ZIOSpecDefault, assertZIO}

object ServiceBSpec$ extends ZIOSpecDefault:

  val stubbedCounterGet = 1
  val mockCounterService: Expectation[CounterService] =
    CounterServiceMock.Inc() ++ CounterServiceMock.Get(value(stubbedCounterGet))

  def spec: TestSuite = suite("ServiceBSpec")(
    test(
      "toLower should return input as lowercase concat value returned by CounterService.get"
    ) {
      // Given
      val testSubject = serviceWithZIO[ServiceB]

      // When
      val actualResult: RIO[ServiceB, String] =
        testSubject(_.toLower("CIAO"))

      // Then
      assertZIO(actualResult)(equalTo(s"ciao-$stubbedCounterGet"))
    }
  ).provideShared(
    ZLayer.derive[ServiceB],
    mockCounterService
  )
