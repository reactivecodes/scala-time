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

import java.time.{LocalDate, Month, MonthDay}

import org.scalatest.{Matchers, Outcome, fixture}


class MonthOpsSuite extends fixture.FunSuite with Matchers {

  test("`+` obtains a Month after the underlying value by the specified number of months")(_ + 13 shouldBe Month.SEPTEMBER)

  test("`-` obtains a Month before the underlying value by the specified number of months")(_ - 13 shouldBe Month.JULY)

  test("`/` obtains a MonthDay by combining the underlying value with the specified day")(_ / 1 shouldBe MonthDay.of(8, 1))

  test("`=~` adjusts the specified Temporal to have this month")(_ =~ LocalDate.of(2016, 4, 4) shouldBe LocalDate.of(2016, 8, 4))

  override type FixtureParam = MonthOps

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new MonthOps(Month.AUGUST)))
}
