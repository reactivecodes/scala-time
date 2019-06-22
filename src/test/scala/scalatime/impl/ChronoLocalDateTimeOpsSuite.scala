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
import java.time.{LocalDate, LocalDateTime, ZoneId, ZoneOffset}

import org.scalatest.{Matchers, Outcome, fixture}


class ChronoLocalDateTimeOpsSuite extends fixture.FunSuite with Matchers {

  test("`%%` combines a ChronoLocalDateTime with a time zone") { (ldt: ChronoLocalDateTimeOps[LocalDate]) =>
    ldt %% ZoneId.of("Z") shouldBe  ldt.underlying.atZone(ZoneOffset.UTC)
  }

  test("`±` combines a ChronoLocalDateTime with a time zone") { ldt =>
    ldt ± ZoneId.of("Z") shouldBe  ldt.underlying.atZone(ZoneOffset.UTC)
  }

  test("`>>` formats a ChronoLocalDateTime according to the specified formatter") { ldt =>
    ldt |> ISO_LOCAL_DATE shouldBe ldt.underlying.format(ISO_LOCAL_DATE)
  }

  test("`▹` formats a ChronoLocalDateTime according to the specified formatter") { ldt =>
    ldt ▹ ISO_LOCAL_DATE shouldBe ldt.underlying.format(ISO_LOCAL_DATE)
  }

  override type FixtureParam = ChronoLocalDateTimeOps[LocalDate]
  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new ChronoLocalDateTimeOps(LocalDateTime.now())))

}
