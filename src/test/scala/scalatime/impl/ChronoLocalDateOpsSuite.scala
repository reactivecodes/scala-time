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

import java.time.format.DateTimeFormatter._
import java.time.{LocalDate, LocalTime}

import org.scalatest.{Matchers, Outcome, fixture}


class ChronoLocalDateOpsSuite extends fixture.FunSuite with Matchers {

  test("`%%` combines a ChronoLocalDate with a LocalTime") { ld =>
    val lt = LocalTime.now()
    ld %% lt shouldBe ld.underlying.atTime(lt)
  }

  test("`>>` formats a ChronoLocalDate according to the specified formatter") { ld =>
    ld |> ISO_LOCAL_DATE shouldBe ld.underlying.format(ISO_LOCAL_DATE)
  }

  test("`▹` formats a ChronoLocalDate according to the specified formatter") { ld =>
    ld  ▹ ISO_LOCAL_DATE shouldBe ld.underlying.format(ISO_LOCAL_DATE)
  }

  override type FixtureParam = ChronoLocalDateOps

  override protected def withFixture(test: OneArgTest): Outcome =
    withFixture(test.toNoArgTest(new ChronoLocalDateOps(LocalDate.now())))
}
