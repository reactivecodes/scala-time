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

package codes.reactive.scalatime.temporal

import org.scalatest.{Outcome, fixture, Matchers}


class IntPeriodSuite extends fixture.FunSuite with Matchers {

  override type FixtureParam = IntPeriod

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new IntPeriod(10)))

  test("An IntPeriod instance can create a Period instance of days from an Int")(i => (i days) shouldEqual java.time.Period.ofDays(10))

  test("An IntPeriod instance can create a Period instance of weeks from an Int")(i => (i weeks) shouldEqual java.time.Period.ofWeeks(10))

  test("An IntPeriod instance can create a Period instance of fortnights from an Int")(i => (i fortnights) shouldEqual java.time.Period.ofWeeks(20))

  test("An IntPeriod instance can create a Period instance of months from an Int")(i => (i months) shouldEqual java.time.Period.ofMonths(10))

  test("An IntPeriod instance can create a Period instance of years from an Int")(i => (i years) shouldEqual java.time.Period.ofYears(10))

}


class LongDurationSuite extends fixture.FunSuite with Matchers {

  override type FixtureParam = LongDuration

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new LongDuration(10)))

  test("A LongDuration instance can create a Duration instance of nanos from a Long")(i => (i nanos) shouldEqual java.time.Duration.ofNanos(10))

  test("A LongDuration instance can create a Duration instance of a millis from a Long")(i => (i millis) shouldEqual java.time.Duration.ofMillis(10))

  test("A LongDuration instance can create a Duration instance of a seconds from a Long")(i => (i seconds) shouldEqual java.time.Duration.ofSeconds(10))

  test("A LongDuration instance can create a Duration instance of a minutes from a Long")(i => (i minutes) shouldEqual java.time.Duration.ofMinutes(10))

  test("A LongDuration instance can create a Duration instance of a hours from a Long")(i => (i hours) shouldEqual java.time.Duration.ofHours(10))

  test("A LongDuration instance can create a Duration instance of a days from a Long")(i => (i days) shouldEqual java.time.Duration.ofDays(10))

}

