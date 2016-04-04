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

package codes.reactive.scalatime.impl

import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField._
import java.time.{Month, MonthDay}

import org.scalatest.{Matchers, Outcome, fixture}


class MonthDayOpsSuite extends fixture.FunSuite with Matchers {

  test("`<` returns true if underlying value is before the specified MonthDay")(_.<(MonthDay.of(11, 11)) shouldBe true)

  test("`<=` returns true if underlying value is before or equal to the specified MonthDay")(_.<=(MonthDay.of(10, 11)) shouldBe true)

  test("`>` returns true if underlying value is after the specified MonthDay")(_.>(MonthDay.of(1, 1)) shouldBe true)

  test("`>=` returns true if underlying value is after or equal to the specified MonthDay")(_.>=(MonthDay.of(10, 11)) shouldBe true)

  test("`~=(month: Month)` obtains a MonthDay from the underlying value with the specified Month")(_.~=(Month.JANUARY) shouldBe MonthDay.of(1, 11))

  test("`~=(day: Int)` obtains a MonthDay from the underlying value with the specified day")(_.~=(1) shouldBe MonthDay.of(10, 1))

  test("`~=(month: Option[Month], day: Option[Int])` obtains a MonthDay from the underlying value with the specified month or day")(_.~=(Some(Month.JANUARY), Some(1)) shouldBe MonthDay.of(1, 1))

  test("`|>` formats the underlying value with the specified formatter.")(_.|>(formatter) shouldBe "--10-11")

  test("`▹` formats the underlying value with the specified formatter.")(_.▹(formatter) shouldBe "--10-11")


  override type FixtureParam = MonthDayOps

  private def formatter = new DateTimeFormatterBuilder()
    .appendLiteral("--")
    .appendValue(MONTH_OF_YEAR, 2)
    .appendLiteral('-')
    .appendValue(DAY_OF_MONTH, 2)
    .toFormatter

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new MonthDayOps(MonthDay.of(10, 11))))
}
