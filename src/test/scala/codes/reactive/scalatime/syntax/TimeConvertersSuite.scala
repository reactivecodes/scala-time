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

package codes.reactive.scalatime.syntax

import codes.reactive.scalatime._
import temporal._
import chrono._
import org.scalatest.{Matchers, Outcome, fixture}


class TimeConvertersSuite extends fixture.FreeSpec with Matchers {


  "TimeConverters object provides decorators for converting java.time objects to their 'Rich' counterparts" - {

    val fixed = Clock.fixed(Instant())

    import TimeConverters._

    "enriching LocalDate" in {
      LocalDate(_).enrich shouldBe new RichChronoLocalDate(LocalDate(fixed))
    }

    "enriching LocalDateTime" in { c =>
      LocalDateTime(c).enrich shouldBe new RichChronoLocalDateTime(LocalDateTime(c))
    }

    "enriching Duration" in { _ =>
      Duration.seconds(2).enrich shouldBe new RichDuration(Duration.seconds(2))
    }


  }
  override type FixtureParam = Clock

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(Clock.fixed(Instant())))
}
