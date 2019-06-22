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

import java.time._
import java.time.format.{DateTimeFormatterBuilder, SignStyle}
import java.time.temporal.ChronoField._

import org.scalatest.{Matchers, Outcome, fixture}


class YearOpsSuite extends fixture.FunSuite with Matchers {

  test("`+` obtains a Year with the specified number of years added")(_ + 6 shouldBe Year.of(2022))

  test("`-` obtains a Year with the specified number of years subtracted")(_ - 6 shouldBe Year.of(2010))

  test("`<` returns true if the specified Year is before the underlying value")(_ < Year.of(2017) shouldBe true)

  test("`<` returns true if the specified Year is before or equal to the underlying value") { y ⇒
    y <= Year.of(2017) shouldBe true
    y <= Year.of(2016) shouldBe true
  }

  test("`>` returns true if the specified Year is after the underlying value")(_ > Year.of(2015) shouldBe true)

  test("`>=` returns true if the specified Year is after  or equal to the underlying value") { y ⇒
    y >= Year.of(2015) shouldBe true
    y >= Year.of(2016) shouldBe true
  }

  test("`/(month: Month)` obtains a YearMonth by combining the underlying value with the specified Month")(_ / Month.JANUARY shouldBe YearMonth.of(2016, 1))

  test("`/(month: Int)` obtains a YearMonth by combining the underlying value with the specified Month")(_ / 1 shouldBe YearMonth.of(2016, 1))

  test("`/(monthDay: MonthDay)` obtains a LocalDate by combining the underlying value with the specified MonthDay")(_ / MonthDay.of(1, 1) shouldBe LocalDate.of(2016, 1, 1))

  test("`|>` formats the underlying value with the specified formatter.")(_ |> formatter shouldBe "2016")

  test("`▹` formats the underlying value with the specified formatter.")(_ ▹ formatter shouldBe "2016")

  private def formatter = new DateTimeFormatterBuilder()
    .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
    .toFormatter

  override type FixtureParam = YearOps

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new YearOps(Year.of(2016))))
}
