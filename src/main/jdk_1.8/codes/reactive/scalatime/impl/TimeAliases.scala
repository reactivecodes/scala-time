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

import java.{time => t}

/** Contains type aliases for JDK time types
  *
  */
private[scalatime] abstract class TimeAliases {

  // java.time
  /** Alias for ''java.time'' `Clock`. A clock providing access to the current instant, date and time using a time-zone. 
    * Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further
    * information.
    */
  type Clock = t.Clock

  /** Alias for ''java.time'' `DateTimeException`. This exception is used to indicate problems with creating, querying 
    * and manipulating date-time objects. Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further 
    * information.
    */
  type DateTimeException = t.DateTimeException

  /** Alias for ''java.time'' `DayOfWeek`. DayOfWeek is an enum representing the 7 days of the week - Monday, Tuesday, 
    * Wednesday, Thursday, Friday, Saturday and Sunday. Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further 
    * information.
    */
  type DayOfWeek = t.DayOfWeek

  /** Alias for ''java.time'' `Duration`. Duration is a time-based amount of time, such as '34.5 seconds'. Consult the 
    * `java.time` [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for 
    * further information. 
    */
  type Duration = t.Duration

  /** Alias for ''java.time'' `Instant`. Instant is an instantaneous point on the time-line. Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further 
    * information. 
    */
  type Instant = t.Instant

  /** Alias for ''java.time'' `LocalDate`. LocalDate is a date without a time-zone in the ISO-8601 calendar system, such
    * as 2007-12-03. Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further 
    * information.
    */
  type LocalDate = t.LocalDate

  /** Alias for ''java.time'' `LocalDateTime`. LocalDateTime is a date-time without a time-zone in the ISO-8601 
    * calendar system, such as 2007-12-03T10:15:30. Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further 
    * information.
    */
  type LocalDateTime = t.LocalDateTime

  /** Alias for ''java.time'' `LocalTime`. LocalTime is a time without time-zone in the ISO-8601 calendar system, such 
    * as 10:15:30. Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further 
    * information.
    */
  type LocalTime = t.LocalTime

  /** Alias for ''java.time'' `Month`. Month is an enum representing the 12 months of the year - January, February, 
    * March, April, May, June, July, August, September, October, November and December. Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further 
    * information.
    */
  type Month = t.Month

  /** Alias for ''java.time'' `MonthDay`. A month-day in the ISO-8601 calendar system, such as --12-03. Consult the 
    * `java.time` [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for 
    * further information. 
    */
  type MonthDay = t.MonthDay

  /** Alias for ''java.time'' `OffsetDateTime`. An OffsetDateTime is a date-time with an offset from UTC/Greenwich in 
    * the ISO-8601 calendar system, such as 2007-12-03T10:15:30+01:00 Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further 
    * information.
    */
  type OffsetDateTime = t.OffsetDateTime

  /** Alias for ''java.time'' `OffsetTime`. An OffsetTime is a time with an offset from UTC/Greenwich in the ISO-8601 
    * calendar system, such as 10:15:30+01:00. Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further 
    * information.
    */
  type OffsetTime = t.OffsetTime

  /** Alias for ''java.time'' `Period`. Period is a date-based amount of time in the ISO-8601 calendar system, such as
    * '2 years, 3 months and 4 days'. Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further 
    * information.
    */
  type Period = t.Period

  /** Alias for ''java.time'' `Year`. A year in the ISO-8601 calendar system, such as 2007. Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further
    * information.
    */
  type Year = t.Year

  /** Alias for ''java.time'' `YearMonth`. A year-month in the ISO-8601 calendar system, such as 2007-12. Consult the
    * `java.time` [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for 
    * further information.
    */
  type YearMonth = t.YearMonth

  /** Alias for ''java.time'' `ZonedDateTime`. ZonedDateTime is a date-time with a time-zone in the ISO-8601 calendar 
    * system, such as 2007-12-03T10:15:30+01:00 Europe/Paris. Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further
    * information.
    */
  type ZonedDateTime = t.ZonedDateTime

  /** Alias for ''java.time'' `ZoneId`. A time-zone ID, such as Europe/Paris. Consult the `java.time`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for further
    * information.
    */
  type ZoneID = t.ZoneId

  /** Alias for ''java.time'' `ZoneOffset`. A time-zone offset from Greenwich/UTC, such as +02:00. Consult the
    * `java.time` [[http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html API Documentation]] for 
    * further information.
    */
  type ZoneOffset = t.ZoneOffset


  // java.time.chrono
  /** Alias for ''java.time.chrono'' `ChronoLocalDate`. A date without time-of-day or time-zone in an arbitrary 
    * chronology, intended for advanced globalization use cases. Consult the `java.time.chrono`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/chrono/package-summary.html API Documentation]] for further 
    * information.
    */
  type ChronoLocalDate = t.chrono.ChronoLocalDate

  /** Alias for ''java.time.chrono'' `ChronoLocalDateTime`. A date-time without a time-zone in an arbitrary chronology, 
    * intended for advanced globalization use cases. Consult the `java.time.chrono`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/chrono/package-summary.html API Documentation]] for further
    * information.
    */
  type ChronoLocalDateTime[A <: ChronoLocalDate] = t.chrono.ChronoLocalDateTime[A]

  /** Alias for ''java.time.chrono'' `ChronoZonedDateTime`. A date-time with a time-zone in an arbitrary chronology,
    * intended for advanced globalization use cases. Consult the `java.time.chrono`
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/chrono/package-summary.html API Documentation]] for 
    * further information.
    */
  type ChronoZonedDateTime[A <: ChronoLocalDate] = t.chrono.ChronoZonedDateTime[A]


  // java.time.format
  /** Alias for ''java.time.format'' `DateTimeFormatter`. DateTimeFormatter is a formatter for printing and parsing 
    * date-time objects. See the ''java.time.format''
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/format/package-summary.html API Documentation]] for further
    * information.
    */
  type DateTimeFormatter = t.format.DateTimeFormatter

  /** Alias for ''java.time.format'' `DateTimeFormatterBuilder`. DateTimeFormatterBuilder is a factory for creating 
    * date-time formatters. See the ''java.time.format''
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/format/package-summary.html API Documentation]] for further
    * information.
    */
  type DateTimeFormatterBuilder = t.format.DateTimeFormatterBuilder


  // java.time.temporal
  /** Alias for ''java.time.temporal'' `Temporal`. Temporal is the base interface type for date, time and offset objects
    * that are complete enough to be manipulated using plus and minus.
    * See the ''java.time.temporal''
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type Temporal = t.temporal.Temporal

  /** Alias for ''java.time.temporal'' `TemporalAccessor`. Framework-level interface defining read-only access to a
    * temporal object, such as a date, time, offset or some combination of these.
    * See the ''java.time.temporal''
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type TemporalAccessor = t.temporal.TemporalAccessor

  /** Alias for ''java.time.temporal'' `TemporalAdjuster`. Strategy for adjusting a temporal object.
    * See the ''java.time.temporal''
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type TemporalAdjuster = t.temporal.TemporalAdjuster

  /** Alias for ''java.time.temporal'' `TemporalAmount` The base interface type for amounts of time. An amount is
    * distinct from a date or time-of-day in that it is not tied to any specific point on the time-line.
    * See the ''java.time.temporal''
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type TemporalAmount = t.temporal.TemporalAmount

  /** Alias for ''java.time.temporal'' `TemporalUnit`. TemporalUnit is a unit of date-time, such as Days or Hours.
    * See the ''java.time.temporal''
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type TemporalUnit = t.temporal.TemporalUnit

  /** Alias for ''java.time.temporal'' `TemporalField`. TemporalField is a field of date-time, such as month-of-year or
    * hour-of-minute.
    * See the ''java.time.temporal''
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type TemporalField = t.temporal.TemporalField

  /** Alias for ''java.time.temporal'' `ChronoField`. A standard set of date periods fields.
    * See the ''java.time.temporal''
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type ChronoField = t.temporal.ChronoField

  /** Alias for ''java.time.temporal'' `ChronoUnit`. A standard set of date periods units.
    * See the ''java.time.temporal''
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type ChronoUnit = t.temporal.ChronoUnit

  /** Alias for ''java.time.temporal'' `TemporalQuery`. Strategy for querying a temporal object.
    * See the ''java.time.temporal''
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type TemporalQuery[A] = t.temporal.TemporalQuery[A]

  /** Alias for ''java.time.temporal'' `UnsupportedTemporalTypeException`. Exception indicating that a [[ChronoField]] or [[ChronoUnit]] is
    * not supported for a Temporal class.
    * See the ''java.time.temporal''
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type UnsupportedTemporalTypeException = t.temporal.UnsupportedTemporalTypeException


  // java.time.zone
  /** Alias for ''java.time.zone'' `ZoneRulesException`. ZoneRulesException is used to indicate a problems with the
    * configured time-zone rules. See the ''java.time.zone''
    * [[http://docs.oracle.com/javase/8/docs/api/java/zone/temporal/package-summary.html API Documentation]] for further
    * information.
    */
  type ZoneRulesException = t.zone.ZoneRulesException


}
