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

import java.time.Duration

import org.scalatest.{Matchers, Outcome, fixture}


class LongOpsSuite extends fixture.FunSuite with Matchers {

  test("`nano` obtains a Duration equal to the specified number of nanoseconds")(_.nano shouldBe Duration.ofNanos(10))

  test("`nanos` obtains a Duration equal to the specified number of nanoseconds")(_.nanos shouldBe Duration.ofNanos(10))

  test("`milli` obtains a Duration equal to the specified number of milliseconds")(_.milli shouldBe Duration.ofMillis(10))

  test("`millis` obtains a Duration equal to the specified number of milliseconds")(_.millis shouldBe Duration.ofMillis(10))

  test("`second` obtains a Duration equal to the specified number of seconds")(_.second shouldBe Duration.ofSeconds(10))

  test("`seconds` obtains a Duration equal to the specified number of seconds")(_.seconds shouldBe Duration.ofSeconds(10))

  test("`minute` obtains a Duration equal to the specified number of minutes")(_.minute shouldBe Duration.ofMinutes(10))

  test("`minutes` obtains a Duration equal to the specified number of minutes")(_.minutes shouldBe Duration.ofMinutes(10))

  test("`hour` obtains a Duration equal to the specified number of hours")(_.hour shouldBe Duration.ofHours(10))

  test("`hours` obtains a Duration equal to the specified number of hours")(_.hours shouldBe Duration.ofHours(10))

  test("`day` obtains a Duration equal to the specified number of days")(_.day shouldBe Duration.ofDays(10))

  test("`days` obtains a Duration equal to the specified number of days")(_.days shouldBe Duration.ofDays(10))


  override type FixtureParam = LongOps

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new LongOps(10L)))
}
