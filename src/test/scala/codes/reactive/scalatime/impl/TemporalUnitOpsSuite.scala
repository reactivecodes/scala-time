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

import java.time.LocalDate
import java.time.temporal.ChronoUnit

import org.scalatest.{Matchers, Outcome, fixture}


class TemporalUnitOpsSuite extends fixture.FunSuite with Matchers {

  test("`<<+` adjusts the specified temporal with the specified amount of the underlying unit")(
    _ <<+ (LocalDate.of(2016, 4, 4), 2) shouldBe LocalDate.of(2016, 4, 6)
  )

  override type FixtureParam = TemporalUnitOps

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new TemporalUnitOps(ChronoUnit.DAYS)))
}
