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

import org.scalatest.{Outcome, Matchers, fixture}
import temporal.TemporalQuery


class TemporalAccessorOpsSuite extends fixture.FunSuite with Matchers {
  override type FixtureParam = TemporalAccessorOps

  override protected def withFixture(test: OneArgTest): Outcome = {
    val accessor = LocalDate.of(2015, 4, 25)
    withFixture(test.toNoArgTest(new FixtureParam(accessor)))
  }

  test("`|>` queries the boxed object using the specified TemporalQuery strategy object.") {
    _ |> TemporalQuery.precision shouldBe ChronoUnit.Days
  }

  test("`▹` queries the boxed object using the specified TemporalQuery strategy object.") {
    _ |> TemporalQuery.precision shouldBe ChronoUnit.Days
  }

  test("`#|>` queries the boxed object to obtains the value of the specified field as a `Long`") {
    _ #|> ChronoField.DayOfMonth shouldBe 25L
  }

  test("`#▹` queries the boxed object to obtains the value of the specified field as a `Long`") {
    _ #▹ ChronoField.DayOfMonth shouldBe 25L
  }
}
