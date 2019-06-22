/******************************************************************
 * See the NOTICE file distributed with this work for additional  *
 * information regarding Copyright ownership.  The author/authors *
 * license this file to you under the terms of the Apache License *
 * Version 2.0 (the "License"); you may not use this file except  *
 * in compliance with the License.  You may obtain a copy of the  *
 * License at:                                                    *
 *                                                                *
 *     http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                                *
 * Unless required by applicable law or agreed to in writing,     *
 * software distributed under the License is distributed on an    *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,   *
 * either express or implied.  See the License for the specific   *
 * language governing permissions and limitations under the       *
 * License.                                                       *
 ******************************************************************/

package scalatime.impl

import java.time.temporal.ChronoUnit
import java.time.{Duration, LocalTime, Period}

import org.scalatest.{Matchers, Outcome, fixture}


class TemporalAmountOpsSuite extends fixture.FunSuite with Matchers {
  override type FixtureParam = (TemporalAmountOps)

  override protected def withFixture(test: OneArgTest): Outcome = {
    val amt = Duration.ofMinutes(60)
    withFixture(test.toNoArgTest(TemporalAmountOps(amt)))
  }

  test("`<<+` adds the boxed amount to the specified Temporal") {
    _ <<+ LocalTime.of(14, 50) shouldBe LocalTime.of(15, 50)
  }

  test("`<<+` subtracts the boxed amount from the specified Temporal") {
    _ <<- LocalTime.of(14, 50) shouldBe LocalTime.of(13, 50)
  }
}


class DurationOpsSuite extends fixture.FunSuite with Matchers {
  override type FixtureParam = DurationOps

  override protected def withFixture(test: OneArgTest): Outcome = {
    val dur = Duration.ofMinutes(60)
    withFixture(test.toNoArgTest(DurationOps(dur)))
  }

  test("`*` obtains a copy of the boxed Duration multiplied by the scalar") {
    _ * 2 shouldBe Duration.ofMinutes(120)
  }

  test("`+` obtains a copy of the boxed Duration with the specified Duration added") {
    _ + Duration.ofMinutes(60) shouldBe Duration.ofMinutes(120)
  }

  test("`+` obtains a copy of the boxed Duration with a duration added in terms of the specified unit") {
    _ +(60, ChronoUnit.MINUTES) shouldBe Duration.ofMinutes(120)
  }

  test("`-` obtains a copy of the boxed Duration with the specified Duration subtracted") {
    _ - Duration.ofMinutes(60) shouldBe Duration.ofMinutes(0)
  }

  test("`-` obtains a copy of the boxed Duration with a duration subtracted in terms of the specified unit") {
    _ -(60, ChronoUnit.MINUTES) shouldBe Duration.ofMinutes(0)
  }

  test("`/` obtains a copy of the boxed Duration divided by the divisor") {
    _ / 2 shouldBe Duration.ofMinutes(30)
  }

  test("`unary_!` negates the boxed Duration") {
    !_ shouldBe Duration.ofMinutes(-60)
  }

  test("`asConcurrentDuration` obtains the Duration as a `concurrent.duration.Duration`") {
    _.asConcurrentDuration shouldBe concurrent.duration.Duration.fromNanos(3600000000000L)
  }
}


class PeriodOpsSuite extends fixture.FunSuite with Matchers {
  override type FixtureParam = PeriodOps

  override protected def withFixture(test: OneArgTest): Outcome = {
    val period = Period.ofDays(60)
    withFixture(test.toNoArgTest(new FixtureParam(period)))
  }

  test("`*` obtains a copy of the boxed Period multiplied by the scalar") {
    _ * 2 shouldBe Period.ofDays(120)
  }

  test("`+` obtains a copy of the boxed Period with the specified TemporalAmount added") {
    _ + Period.ofDays(60) shouldBe Period.ofDays(120)
  }

  test("`+` obtains a copy of the boxed Period with the specified TemporalAmount subtracted") {
    _ - Period.ofDays(60) shouldBe Period.ofDays(0)
  }

  test("`unary_!` negates the boxed Period") {
    !_ shouldBe Period.ofDays(-60)
  }
}
