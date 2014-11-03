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
package chrono

import format.DateTimeFormatter.{Iso => IDF}
import org.scalatest.{Matchers, Outcome, fixture}


class RichChronoLocalDateSuite extends fixture.FunSuite with Matchers {

  test("`%%` combines a ChronoLocalDate with a LocalTime") { ld =>
    val lt = LocalTime()
   ld %% lt shouldBe  ld.underlying.atTime(lt)
  }

  test("`>>` formats a ChronoLocalDate according to the specified formatter") { ld =>
    ld >> IDF.LocalDate shouldBe ld.underlying.format(IDF.LocalDate)
  }

  override type FixtureParam = RichChronoLocalDate
  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new RichChronoLocalDate(LocalDate())))
}


class RichChronoLocalDateTimeSuite extends fixture.FunSuite with Matchers {

  test("`%%` combines a ChronoLocalDateTime with a time zone") { (ldt: RichChronoLocalDateTime[LocalDate]) =>
    ldt %% ZoneId.UTC shouldBe  ldt.underlying.atZone(ZoneOffset.UTC)
  }

  test("`±` combines a ChronoLocalDateTime with a time zone") { ldt =>
    ldt ± ZoneId.UTC shouldBe  ldt.underlying.atZone(ZoneOffset.UTC)
  }

  test("`>>` formats a ChronoLocalDateTime according to the specified formatter") { ldt =>
    ldt >> IDF.LocalDate shouldBe ldt.underlying.format(IDF.LocalDate)
  }

  override type FixtureParam = RichChronoLocalDateTime[LocalDate]
  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new RichChronoLocalDateTime(LocalDateTime())))

}
