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

package codes.reactive.scalatime.impl

import org.threeten.{bp => t}

/** Contains type aliases for JDK time types
  *
  */
private[scalatime] abstract class TimeAliases {

  // java.time
  /** Alias for ''org.threeten.bp'' `Clock`. A clock providing access to the current instant, date and time using a time-zone. 
    * Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further
    * information.
    */
  type Clock = t.Clock

  /** Alias for ''org.threeten.bp'' `DateTimeException`. This exception is used to indicate problems with creating, querying 
    * and manipulating date-time objects. Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further 
    * information.
    */
  type DateTimeException = t.DateTimeException

  /** Alias for ''org.threeten.bp'' `DayOfWeek`. DayOfWeek is an enum representing the 7 days of the week - Monday, Tuesday, 
    * Wednesday, Thursday, Friday, Saturday and Sunday. Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further 
    * information.
    */
  type DayOfWeek = t.DayOfWeek

  /** Alias for ''org.threeten.bp'' `Duration`. Duration is a time-based amount of time, such as '34.5 seconds'. Consult the 
    * ''org.threeten.bp'' [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for 
    * further information. 
    */
  type Duration = t.Duration

  /** Alias for ''org.threeten.bp'' `Instant`. Instant is an instantaneous point on the time-line. Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further 
    * information. 
    */
  type Instant = t.Instant

  /** Alias for ''org.threeten.bp'' `LocalDate`. LocalDate is a date without a time-zone in the ISO-8601 calendar system, such
    * as 2007-12-03. Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further 
    * information.
    */
  type LocalDate = t.LocalDate

  /** Alias for ''org.threeten.bp'' `LocalDateTime`. LocalDateTime is a date-time without a time-zone in the ISO-8601 
    * calendar system, such as 2007-12-03T10:15:30. Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further 
    * information.
    */
  type LocalDateTime = t.LocalDateTime

  /** Alias for ''org.threeten.bp'' `LocalTime`. LocalTime is a time without time-zone in the ISO-8601 calendar system, such 
    * as 10:15:30. Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further 
    * information.
    */
  type LocalTime = t.LocalTime

  /** Alias for ''org.threeten.bp'' `Month`. Month is an enum representing the 12 months of the year - January, February, 
    * March, April, May, June, July, August, September, October, November and December. Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further 
    * information.
    */
  type Month = t.Month

  /** Alias for ''org.threeten.bp'' `MonthDay`. A month-day in the ISO-8601 calendar system, such as --12-03. Consult the 
    * ''org.threeten.bp'' [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for 
    * further information. 
    */
  type MonthDay = t.MonthDay

  /** Alias for ''org.threeten.bp'' `OffsetDateTime`. An OffsetDateTime is a date-time with an offset from UTC/Greenwich in 
    * the ISO-8601 calendar system, such as 2007-12-03T10:15:30+01:00 Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further 
    * information.
    */
  type OffsetDateTime = t.OffsetDateTime

  /** Alias for ''org.threeten.bp'' `OffsetTime`. An OffsetTime is a time with an offset from UTC/Greenwich in the ISO-8601 
    * calendar system, such as 10:15:30+01:00. Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further 
    * information.
    */
  type OffsetTime = t.OffsetTime

  /** Alias for ''org.threeten.bp'' `Period`. Period is a date-based amount of time in the ISO-8601 calendar system, such as
    * '2 years, 3 months and 4 days'. Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further 
    * information.
    */
  type Period = t.Period

  /** Alias for ''org.threeten.bp'' `Year`. A year in the ISO-8601 calendar system, such as 2007. Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further
    * information.
    */
  type Year = t.Year

  /** Alias for ''org.threeten.bp'' `YearMonth`. A year-month in the ISO-8601 calendar system, such as 2007-12. Consult the
    * ''org.threeten.bp'' [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for 
    * further information.
    */
  type YearMonth = t.YearMonth

  /** Alias for ''org.threeten.bp'' `ZonedDateTime`. ZonedDateTime is a date-time with a time-zone in the ISO-8601 calendar 
    * system, such as 2007-12-03T10:15:30+01:00 Europe/Paris. Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further
    * information.
    */
  type ZonedDateTime = t.ZonedDateTime

  /** Alias for ''org.threeten.bp'' `ZoneId`. A time-zone ID, such as Europe/Paris. Consult the ''org.threeten.bp''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for further
    * information.
    */
  type ZoneID = t.ZoneId

  /** Alias for ''org.threeten.bp'' `ZoneOffset`. A time-zone offset from Greenwich/UTC, such as +02:00. Consult the
    * ''org.threeten.bp'' [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/package-summary.html API Documentation]] for 
    * further information.
    */
  type ZoneOffset = t.ZoneOffset


  // java.time.chrono
  /** Alias for ''org.threeten.bp.chrono'' `ChronoLocalDate`. A date without time-of-day or time-zone in an arbitrary 
    * chronology, intended for advanced globalization use cases. Consult the ''org.threeten.bp.chrono''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/chrono/package-summary.html API Documentation]] for further 
    * information.
    */
  type ChronoLocalDate = t.chrono.ChronoLocalDate

  /** Alias for ''org.threeten.bp.chrono'' `ChronoLocalDateTime`. A date-time without a time-zone in an arbitrary chronology, 
    * intended for advanced globalization use cases. Consult the ''org.threeten.bp.chrono''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/chrono/package-summary.html API Documentation]] for further
    * information.
    */
  type ChronoLocalDateTime[A <: ChronoLocalDate] = t.chrono.ChronoLocalDateTime[A]

  /** Alias for ''org.threeten.bp.chrono'' `ChronoZonedDateTime`. A date-time with a time-zone in an arbitrary chronology,
    * intended for advanced globalization use cases. Consult the ''org.threeten.bp.chrono''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/chrono/package-summary.html API Documentation]] for 
    * further information.
    */
  type ChronoZonedDateTime[A <: ChronoLocalDate] = t.chrono.ChronoZonedDateTime[A]


  // java.time.format
  /** Alias for ''org.threeten.bp.format'' `DateTimeFormatter`. DateTimeFormatter is a formatter for printing and parsing 
    * date-time objects. See the ''org.threeten.bp.format''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/format/package-summary.html API Documentation]] for further
    * information.
    */
  type DateTimeFormatter = t.format.DateTimeFormatter

  /** Alias for ''org.threeten.bp.format'' `DateTimeFormatterBuilder`. DateTimeFormatterBuilder is a factory for creating 
    * date-time formatters. See the ''org.threeten.bp.format''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/format/package-summary.html API Documentation]] for further
    * information.
    */
  type DateTimeFormatterBuilder = t.format.DateTimeFormatterBuilder


  // java.time.temporal
  /** Alias for ''org.threeten.bp.temporal'' `Temporal`. Temporal is the base interface type for date, time and offset objects
    * that are complete enough to be manipulated using plus and minus.
    * See the ''org.threeten.bp.temporal''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type Temporal = t.temporal.Temporal

  /** Alias for ''org.threeten.bp.temporal'' `TemporalAccessor`. Framework-level interface defining read-only access to a
    * temporal object, such as a date, time, offset or some combination of these.
    * See the ''org.threeten.bp.temporal''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type TemporalAccessor = t.temporal.TemporalAccessor

  /** Alias for ''org.threeten.bp.temporal'' `TemporalAdjuster`. Strategy for adjusting a temporal object.
    * See the ''org.threeten.bp.temporal''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type TemporalAdjuster = t.temporal.TemporalAdjuster

  /** Alias for ''org.threeten.bp.temporal'' `TemporalAmount` The base interface type for amounts of time. An amount is
    * distinct from a date or time-of-day in that it is not tied to any specific point on the time-line.
    * See the ''org.threeten.bp.temporal''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type TemporalAmount = t.temporal.TemporalAmount

  /** Alias for ''org.threeten.bp.temporal'' `TemporalUnit`. TemporalUnit is a unit of date-time, such as Days or Hours.
    * See the ''org.threeten.bp.temporal''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type TemporalUnit = t.temporal.TemporalUnit

  /** Alias for ''org.threeten.bp.temporal'' `TemporalField`. TemporalField is a field of date-time, such as month-of-year or
    * hour-of-minute.
    * See the ''org.threeten.bp.temporal''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type TemporalField = t.temporal.TemporalField

  /** Alias for ''org.threeten.bp.temporal'' `ChronoField`. A standard set of date periods fields.
    * See the ''org.threeten.bp.temporal''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type ChronoField = t.temporal.ChronoField

  /** Alias for ''org.threeten.bp.temporal'' `ChronoUnit`. A standard set of date periods units.
    * See the ''org.threeten.bp.temporal''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type ChronoUnit = t.temporal.ChronoUnit

  /** Alias for ''org.threeten.bp.temporal'' `TemporalQuery`. Strategy for querying a temporal object.
    * See the ''org.threeten.bp.temporal''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type TemporalQuery[A] = t.temporal.TemporalQuery[A]

  /** Alias for ''org.threeten.bp.temporal'' `UnsupportedTemporalTypeException`. Exception indicating that a [[ChronoField]] or [[ChronoUnit]] is
    * not supported for a Temporal class.
    * See the ''org.threeten.bp.temporal''
    * [[http://www.threeten.org/threetenbp/apidocs/org/threeten/bp/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type UnsupportedTemporalTypeException = t.temporal.UnsupportedTemporalTypeException


  // java.time.zone
  /** Alias for ''org.threeten.bp.zone'' `ZoneRulesException`. ZoneRulesException is used to indicate a problems with the
    * configured time-zone rules. See the ''org.threeten.bp.zone''
    * [[http://docs.oracle.com/javase/8/docs/api/java/zone/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type ZoneRulesException = t.zone.ZoneRulesException


}
