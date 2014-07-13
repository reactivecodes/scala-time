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

package codes.reactive.scalatime.test

import java.time.temporal.ChronoUnit

import codes.reactive.scalatime.format.TimeFormatters
import codes.reactive.scalatime.{ZoneID, LocalDateTime, ZonedDateTime}
import org.scalatest.{Matchers, Outcome, fixture}


class TimeFormattersSuite extends fixture.FreeSpec with Matchers {

  case class FormatFixture(subject: TimeFormatters = new TimeFormatters {},
                           date: ZonedDateTime = ZonedDateTime.of(2014, 6, 10, 22, 35, 29, 978, ZoneID.UTC),
                           internet: String = "Tue, 10 Jun 2014 22:35:29 GMT",
                           offset: String = "2014-06-10T22:35:29.000000978Z",
                           offsetTruncated: String = "2014-06-10T22:35:29Z",
                           localTime: String = "22:35:29")

  override type FixtureParam = FormatFixture

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(FormatFixture()))

  "TimeFormatters" - {

    "provides access to commonly used 'DateTimeFormatter' instances via its 'format' member" - {

      "including ISO-8601 formatters provided by the `iso` member" in { a =>
        import a.subject.Iso
        Iso.OffsetDateTime.format(a.date.truncatedTo(ChronoUnit.SECONDS)) should be(a.offsetTruncated)
        LocalDateTime(Iso.OffsetDateTime.parse(a.offset)).truncatedTo(ChronoUnit.SECONDS) should be(a.date.toLocalDateTime.truncatedTo(ChronoUnit.SECONDS))
        Iso.LocalTime.format(a.date.truncatedTo(ChronoUnit.SECONDS)) should be(a.localTime)
      }

      "and an RFC-1123 / RFC822 (internet) date-time formatter" in { a =>
        import a.subject.Internet
        Internet.format(a.date) should be(a.internet)
        LocalDateTime(Internet.parse(a.internet)) should be(a.date.truncatedTo(ChronoUnit.SECONDS).toLocalDateTime)
      }

    }
  }
}
