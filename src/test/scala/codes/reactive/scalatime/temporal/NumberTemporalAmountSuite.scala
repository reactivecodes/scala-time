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

package codes.reactive.scalatime.temporal

import codes.reactive.scalatime.impl.{LongOps, IntOps}
import org.scalatest.{Outcome, fixture, Matchers}


class IntPeriodSuite extends fixture.FunSuite with Matchers {

  import codes.reactive.scalatime.test.PeriodTestHelpers._

  override type FixtureParam = IntOps

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new IntOps(10)))

  test("An IntPeriod instance can create a Period instance of days from an Int")(i => (i days) shouldEqual days(10))

  test("An IntPeriod instance can create a Period instance of weeks from an Int")(i => (i weeks) shouldEqual weeks(10))

  test("An IntPeriod instance can create a Period instance of months from an Int")(i => (i months) shouldEqual months(10))

  test("An IntPeriod instance can create a Period instance of years from an Int")(i => (i years) shouldEqual years(10))

}


class LongDurationSuite extends fixture.FunSuite with Matchers {

  import codes.reactive.scalatime.test.DurationTestHelpers._

  override type FixtureParam = LongOps

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new LongOps(10)))

  test("A LongDuration instance can create a Duration instance of nanos from a Long")(i => (i nanos) shouldEqual nanos(10))

  test("A LongDuration instance can create a Duration instance of a millis from a Long")(i => (i millis) shouldEqual millis(10))

  test("A LongDuration instance can create a Duration instance of a seconds from a Long")(i => (i seconds) shouldEqual seconds(10))

  test("A LongDuration instance can create a Duration instance of a minutes from a Long")(i => (i minutes) shouldEqual minutes(10))

  test("A LongDuration instance can create a Duration instance of a hours from a Long")(i => (i hours) shouldEqual hours(10))

  test("A LongDuration instance can create a Duration instance of a days from a Long")(i => (i days) shouldEqual days(10))

}

