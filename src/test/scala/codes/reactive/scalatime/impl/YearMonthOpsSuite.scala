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

import java.time.format.{DateTimeFormatterBuilder, SignStyle}
import java.time.temporal.ChronoField._
import java.time.{LocalDate, YearMonth}

import org.scalatest.{Matchers, Outcome, fixture}


class YearMonthOpsSuite extends fixture.FunSuite with Matchers {

  test("`+` obtains a YearMonth with the specified number of months added")(_ + 6 shouldBe YearMonth.of(2016, 10))

  test("`-` obtains a YearMonth with the specified number of months subtracted")(_ - 6 shouldBe YearMonth.of(2015, 10))

  test("`<` returns true if the specified YearMonth is before the underlying value")(_ < YearMonth.of(2016, 10) shouldBe true)

  test("`<=` returns true if the specified YearMonth is before or equal the underlying value") { ym ⇒
    ym <= YearMonth.of(2016, 10) shouldBe true
    ym <= YearMonth.of(2016, 4) shouldBe true
  }

  test("`>` returns true if the specified YearMonth is after the underlying value")(_ > YearMonth.of(2015, 10) shouldBe true)

  test("`>=` returns true if the specified YearMonth is after  or equal the underlying value") { ym ⇒
    ym >= YearMonth.of(2015, 10) shouldBe true
    ym >= YearMonth.of(2016, 4) shouldBe true
  }

  test("`/` obtains a LocalDate by combining the underlying value with the specified day-of-month")(_ / 4 shouldBe LocalDate.of(2016, 4, 4))

  test("`|>` formats the underlying value with the specified formatter.")(_ |> formatter shouldBe "2016-04")

  test("`▹` formats the underlying value with the specified formatter.")(_ ▹ formatter shouldBe "2016-04")


  private def formatter = new DateTimeFormatterBuilder()
    .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
    .appendLiteral('-').appendValue(MONTH_OF_YEAR, 2)
    .toFormatter

  override type FixtureParam = YearMonthOps

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new YearMonthOps(YearMonth.of(2016, 4))))
}
