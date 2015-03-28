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

package codes.reactive.scalatime.test

import codes.reactive.scalatime.{Period, Duration}
import org.scalatest.{Matchers, FunSuite}


class DurationSuite extends FunSuite with Matchers {

  import DurationTestHelpers._

  test("Duration can create an instance of Duration from Long nanos") {
    Duration.nanos(10L) shouldBe nanos(10L)
  }

  test("Duration can create an instance of Duration from Long millis") {
    Duration.millis(10L) shouldBe millis(10L)
  }

  test("Duration can create an instance of Duration from Long seconds") {
    Duration.seconds(10L) shouldBe seconds(10L)
  }

  test("Duration can create an instance of Duration from Long minutes") {
    Duration.minutes(10L) shouldBe minutes(10L)
  }

  test("Duration can create an instance of Duration from Long hours") {
    Duration.hours(10L) shouldBe hours(10L)
  }

  test("Duration can create an instance of Duration from Long days") {
    Duration.days(10L) shouldBe days(10L)
  }

  test("Duration can create an instance of Duration of zero") {
    Duration.empty shouldBe zero
  }

}


class PeriodSuite extends FunSuite with Matchers {

  import PeriodTestHelpers._

  test("Period can create an instance of Period from Int days") {
    Period.days(10) shouldBe days(10)
  }

  test("Period can create an instance of Period from Int weeks") {
    Period.weeks(10) shouldBe weeks(10)
  }

  test("Period can create an instance of Period from Int months") {
    Period.months(10) shouldBe months(10)
  }

  test("Period can create an instance of Period from Int years") {
    Period.years(10) shouldBe years(10)
  }

  test("Duration can create an instance of Period of zero") {
    Period.empty shouldBe zero
  }

}
