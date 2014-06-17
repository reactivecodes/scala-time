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

package codes.reactive.scalatime

import org.scalatest.{Matchers, Outcome, fixture}


class TemporalFactoriesSuite extends fixture.FreeSpec with Matchers {

  override type FixtureParam = (Instant, Clock)

  override protected def withFixture(test: OneArgTest): Outcome = {
    val inst = Instant()
    withFixture(test.toNoArgTest((inst, Clock.fixed(inst))))
  }

  "Clock" - {
    "can create a default 'Clock' instance from the current UTC System clock" in { _ =>
      Clock() should be(java.time.Clock.systemUTC())
    }

    "can create a 'Clock' instance from the current System clock at a specific ZoneID" in { _ =>
      Clock(ZoneID EAT) should be(java.time.Clock.system(ZoneID.EAT))
    }

    "can create a 'Clock' instance from the current System clock at with the default system time zone" in { _ =>
      Clock.systemZone should be(java.time.Clock.systemDefaultZone())
    }

    "can create UTC 'Clock' instance which is fixed to a specific instant" in { f =>
      Clock.fixed(f _1) should be(java.time.Clock.fixed(f _1, ZoneID.UTC))
    }

    "can create 'Clock' instance at a specific ZoneID which is fixed to a specific instant" in { f =>
      Clock.fixed(f _1, ZoneID.EAT) should be(java.time.Clock.fixed(f _1, ZoneID.EAT))
    }
  }


  "Instant" - {
    "can create a default 'Instant' instance from the current UTC System time" in { _ =>
      Instant().isInstanceOf[Instant] shouldEqual true
    }

    "can create an 'Instant' instance from the current time of a provided Clock" in { f =>
      Instant(f _2) shouldEqual f._1
    }

    "can create an Instant from an Epoch millisecond value" in { _ =>
      Instant.milli(1402331329505L).atZone(ZoneID.UTC) shouldEqual ZonedDateTime.of(2014, 6, 9, 16, 28, 49, 505000000, ZoneID.UTC)
    }

    "can create an 'Instant' instance from a parsed String" in { _ =>
      Instant.parse("2014-06-09T16:28:49.505000000Z") shouldEqual Instant.milli(1402331329505L)
    }
  }


  "LocalDate" - {
    "can create a default 'LocalDate' instance from the current System time" in { _ =>
      LocalDate().isInstanceOf[LocalDate] shouldEqual true
    }

  }

  "LocalDateTime" - {
    "can create a default 'LocalDateTime' instance from the current System time" in { _ =>
      LocalDateTime().isInstanceOf[LocalDateTime] shouldEqual true
    }
  }

  "ZonedDateTime" - {
    "can create a default 'ZonedDateTime' instance from the current System time" in { _ =>
      ZonedDateTime().isInstanceOf[ZonedDateTime] shouldEqual true
    }
  }

  "OffsetDateTime" - {
    "can create a default 'OffsetDateTime' instance from the current System time" in { _ =>
      OffsetDateTime().isInstanceOf[OffsetDateTime] shouldEqual true
    }
  }

}
