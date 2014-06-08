/**********************************************************************
 * See the NOTICE file distributed with this work for additional      *
 *   information regarding Copyright ownership.  The author/authors   *
 *   license this file to you under the terms of the Apache License,  *
 *   Version 2.0 (the "License"); you may not use this file except    *
 *   in compliance with the License.  You may obtain a copy of the    *
 *   License at:                                                      *
 *                                                                    *
 *       http://www.apache.org/licenses/LICENSE-2.0                   *
 *                                                                    *
 *   Unless required by applicable law or agreed to in writing,       *
 *   software distributed under the License is distributed on an      *
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY           *
 *   KIND, either express or implied.  See the License for the        *
 *   specific language governing permissions and limitations          *
 *   under the License.                                               *
 **********************************************************************/

package ke.co.sbsproperties

import java.time

/**
 * Created by arashid on 04/06/14.
 */
package object scalatime extends conversions.TemporalImplicits {

  // java.time
  type Clock = time.Clock
  type DateTimeException = time.DateTimeException
  type DayOfWeek = time.DayOfWeek
  type Duration = time.Duration
  type Instant = time.Instant
  type LocalDate = time.LocalDate
  type LocalDateTime = time.LocalDateTime
  type Month = time.Month
  type MonthDay = time.MonthDay
  type OffsetDateTime = time.OffsetDateTime
  type Period = time.Period
  type Year = time.Year
  type YearMonth = time.YearMonth
  type ZonedDateTime = time.ZonedDateTime
  type ZoneID = time.ZoneId
  type ZoneOffset = time.ZoneOffset


  // java.time.temporal
  type Temporal = time.temporal.Temporal
  type TemporalAccessor = time.temporal.TemporalAccessor
  type TemporalAmount = time.temporal.TemporalAmount
  type TemporalUnit = time.temporal.TemporalUnit
  type ChronoUnit = time.temporal.ChronoUnit
  type TemporalQuery[A] = time.temporal.TemporalQuery[A]

}
