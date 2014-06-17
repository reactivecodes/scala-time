/*******************************************************************
 * See the NOTICE file distributed with this work for additional   *
 * information regarding Copyright ownership.  The author/authors  *
 * license this file to you under the terms of the Apache License, *
 * Version 2.0 (the "License"); you may not use this file except   *
 * in compliance with the License.  You may obtain a copy of the   *
 * License at:                                                     *
 *                                                                 *
 *     http://www.apache.org/licenses/LICENSE-2.0                  *
 *                                                                 *
 * Unless required by applicable law or agreed to in writing,      *
 * software distributed under the License is distributed on an     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY          *
 * KIND, either express or implied.  See the License for the       *
 * specific language governing permissions and limitations         *
 * under the License.                                              *
 *******************************************************************/

package codes.reactive.scalatime.test

import codes.reactive.scalatime.{Period, Duration}
import org.scalatest.{Matchers, FunSuite}
import java.time.{Duration => JD, Period => JP}


class DurationSuite extends FunSuite with Matchers {

  test("Duration can create an instance of Duration from Long nanos") {
    Duration.nanos(10L) shouldBe JD.ofNanos(10L)
  }

  test("Duration can create an instance of Duration from Long millis") {
    Duration.millis(10L) shouldBe JD.ofMillis(10L)
  }

  test("Duration can create an instance of Duration from Long seconds") {
    Duration.seconds(10L) shouldBe JD.ofSeconds(10L)
  }

  test("Duration can create an instance of Duration from Long minutes") {
    Duration.minutes(10L) shouldBe JD.ofMinutes(10L)
  }

  test("Duration can create an instance of Duration from Long hours") {
    Duration.hours(10L) shouldBe JD.ofHours(10L)
  }

  test("Duration can create an instance of Duration from Long days") {
    Duration.days(10L) shouldBe JD.ofDays(10L)
  }

  test("Duration can create an instance of Duration of zero") {
    Duration.nil shouldBe JD.ZERO
  }

}


class PeriodSuite extends FunSuite with Matchers {

  test("Period can create an instance of Period from Int days") {
    Period.days(10) shouldBe JP.ofDays(10)
  }

  test("Period can create an instance of Period from Int weeks") {
    Period.weeks(10) shouldBe JP.ofWeeks(10)
  }

  test("Period can create an instance of Period from Int fortnights") {
    Period.fortnights(10) shouldBe JP.ofWeeks(20)
  }

  test("Period can create an instance of Period from Int months") {
    Period.months(10) shouldBe JP.ofMonths(10)
  }

  test("Period can create an instance of Period from Int years") {
    Period.years(10) shouldBe JP.ofYears(10)
  }

  test("Duration can create an instance of Period of zero") {
    Period.nil shouldBe JP.ZERO
  }

}
