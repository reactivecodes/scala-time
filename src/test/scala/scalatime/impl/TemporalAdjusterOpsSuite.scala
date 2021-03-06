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

import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

import org.scalatest.{Matchers, Outcome, fixture}


class TemporalAdjusterOpsSuite extends fixture.FunSuite with Matchers {
  override type FixtureParam = TemporalAdjusterOps

  override protected def withFixture(test: OneArgTest): Outcome = {
    val adj = TemporalAdjusters.firstDayOfMonth()
    withFixture(test.toNoArgTest(new FixtureParam(adj)))
  }

  test("`<<=` applies the boxed TemporalAdjuster to the specified Temporal") { a ⇒
    (a <<= LocalDate.of(2015, 4, 25)) shouldBe LocalDate.of(2015, 4, 1)
  }
}
