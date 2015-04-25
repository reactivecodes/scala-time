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

package codes.reactive.scalatime
package impl

import org.scalatest.{Matchers, Outcome, fixture}


class TemporalAmountOpsSuite extends fixture.FunSuite with Matchers {
  override type FixtureParam = (TemporalAmountOps)

  override protected def withFixture(test: OneArgTest): Outcome = {
    val amt = Duration.minutes(60)
    withFixture(test.toNoArgTest(new TemporalAmountOps(amt)))
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
    val dur = Duration.minutes(60)
    withFixture(test.toNoArgTest(new DurationOps(dur)))
  }

  test("`*` obtains a copy of the boxed Duration multiplied by the scalar") {
    _ * 2 shouldBe Duration.minutes(120)
  }

  test("`+` obtains a copy of the boxed Duration with the specified Duration added") {
    _ + Duration.minutes(60) shouldBe Duration.minutes(120)
  }

  test("`+` obtains a copy of the boxed Duration with a duration added in terms of the specified unit") {
    _ +(60, ChronoUnit.Minutes) shouldBe Duration.minutes(120)
  }

  test("`-` obtains a copy of the boxed Duration with the specified Duration subtracted") {
    _ - Duration.minutes(60) shouldBe Duration.minutes(0)
  }

  test("`-` obtains a copy of the boxed Duration with a duration subtracted in terms of the specified unit") {
    _ -(60, ChronoUnit.Minutes) shouldBe Duration.minutes(0)
  }

  test("`/` obtains a copy of the boxed Duration divided by the divisor") {
    _ / 2 shouldBe Duration.minutes(30)
  }

  test("`unary_!` negates the boxed Duration") {
    !_ shouldBe Duration.minutes(-60)
  }
}


class PeriodOpsSuite extends fixture.FunSuite with Matchers {
  override type FixtureParam = PeriodOps

  override protected def withFixture(test: OneArgTest): Outcome = {
    val period = Period.days(60)
    withFixture(test.toNoArgTest(new FixtureParam(period)))
  }

  test("`*` obtains a copy of the boxed Period multiplied by the scalar") {
    _ * 2 shouldBe Period.days(120)
  }

  test("`+` obtains a copy of the boxed Period with the specified TemporalAmount added") {
    _ + Period.days(60) shouldBe Period.days(120)
  }

  test("`+` obtains a copy of the boxed Period with the specified TemporalAmount subtracted") {
    _ - Period.days(60) shouldBe Period.days(0)
  }

  test("`unary_!` negates the boxed Period") {
    !_ shouldBe Period.days(-60)
  }
}
