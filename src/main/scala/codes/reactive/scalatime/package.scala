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

package codes.reactive

import java.time

import codes.reactive.scalatime.conversions


package object scalatime extends conversions.PredefImplicits with TimeZones with TimeFormatters {

  // java.time
  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/Clock.html java.time.Clock]]. A clock providing
    * access to the current instant, date and time using a time-zone.
    */
  type Clock = time.Clock

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/DateTimeException.html java.time.DateTimeException]].
    * This exception is used to indicate problems with creating, querying and manipulating date-time objects.
    */
  type DateTimeException = time.DateTimeException

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/DayOfWeek.html java.time.DayOfWeek]]. DayOfWeek is
    * an enum representing the 7 days of the week - Monday, Tuesday, Wednesday, Thursday, Friday, Saturday and Sunday.
    */
  type DayOfWeek = time.DayOfWeek

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/Duration.html java.time.Duration]]. Duration is a
    * time-based amount of time, such as '34.5 seconds'.
    */
  type Duration = time.Duration

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/Instant.html java.time.Instant]]. Instant is an
    * instantaneous point on the time-line.
    */
  type Instant = time.Instant

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html java.time.LocalDate]]. LocalDate is
    * a date without a time-zone in the ISO-8601 calendar system, such as 2007-12-03.
    */
  type LocalDate = time.LocalDate

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html java.time.LocalDateTime]].
    * LocalDateTime is a date-time without a time-zone in the ISO-8601 calendar system, such as 2007-12-03T10:15:30.
    */
  type LocalDateTime = time.LocalDateTime

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html java.time.LocalTime]].
    * LocalTime is a time without time-zone in the ISO-8601 calendar system, such as 10:15:30.
    */
  type LocalTime = time.LocalTime

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/Month.html java.time.Month]].
    * Month is an enum representing the 12 months of the year - January, February, March, April, May, June, July,
    * August, September, October, November and December.
    */
  type Month = time.Month

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/MonthDay.html java.time.MonthDay]].
    * A month-day in the ISO-8601 calendar system, such as --12-03.
    */
  type MonthDay = time.MonthDay

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html java.time.OffsetDateTime]].
    * An OffsetDateTime is a date-time with an offset from UTC/Greenwich in the ISO-8601 calendar system,
    * such as 2007-12-03T10:15:30+01:00.
    */
  type OffsetDateTime = time.OffsetDateTime

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/Period.html java.time.Period]].
    * Period is a date-based amount of time in the ISO-8601 calendar system, such as '2 years, 3 months and 4 days'.
    */
  type Period = time.Period

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/Year.html java.time.Year]].
    * A year in the ISO-8601 calendar system, such as 2007.
    */
  type Year = time.Year

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/YearMonth.html java.time.YearMonth]].
    * A year-month in the ISO-8601 calendar system, such as 2007-12.
    */
  type YearMonth = time.YearMonth

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html java.time.ZonedDateTime]].
    * ZonedDateTime is a date-time with a time-zone in the ISO-8601 calendar system, such as
    * 2007-12-03T10:15:30+01:00 Europe/Paris.
    */
  type ZonedDateTime = time.ZonedDateTime

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html java.time.ZoneId]].
    * A time-zone ID, such as Europe/Paris.
    */
  type ZoneID = time.ZoneId

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/ZoneOffset.html java.time.ZoneOffset]].
    * A time-zone offset from Greenwich/UTC, such as +02:00.
    */
  type ZoneOffset = time.ZoneOffset


  // java.time.temporal
  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/Temporal.html java.time.temporal.Temporal]]
    * Temporal is the base interface type for date, time and offset objects that are complete enough to be manipulated
    * using plus and minus
    */
  type Temporal = time.temporal.Temporal

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalAccessor.html java.time.temporal.TemporalAccessor]]
    * Framework-level interface defining read-only access to a temporal object, such as a date, time, offset or some
    * combination of these.
    */
  type TemporalAccessor = time.temporal.TemporalAccessor

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalAdjuster.html java.time.temporal.TemporalAdjuster]]
    * Strategy for adjusting a temporal object.
    */
  type TemporalAdjuster = time.temporal.TemporalAdjuster

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalAmount.html java.time.temporal.TemporalAmount]]
    * The base interface type for amounts of time. An amount is distinct from a date or time-of-day in that it is not
    * tied to any specific point on the time-line.
    */
  type TemporalAmount = time.temporal.TemporalAmount

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalUnit.html java.time.temporal.TemporalUnit]]
    * TemporalUnit is a unit of date-time, such as Days or Hours.
    */
  type TemporalUnit = time.temporal.TemporalUnit

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalField.html java.time.temporal.TemporalField]]
    * TemporalUnit is a field of date-time, such as month-of-year or hour-of-minute.
    */
  type TemporalField = time.temporal.TemporalField

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/ChronoField.html java.time.temporal.ChronoField]]
    * A standard set of date periods fields.
    */
  type ChronoField = time.temporal.ChronoField

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/ChronoUnit.html java.time.temporal.ChronoUnit]]
    * A standard set of date periods units.
    */
  type ChronoUnit = time.temporal.ChronoUnit

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalQuery.html java.time.temporal.TemporalQuery]]
    * Strategy for querying a temporal object.
    */
  type TemporalQuery[A] = time.temporal.TemporalQuery[A]

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/temporal/UnsupportedTemporalTypeException.html java.time.temporal.UnsupportedTemporalTypeException]]
    * Exception indicating that a [[ChronoField]] or [[ChronoUnit]] is not supported for a Temporal class.
    */
  type UnsupportedTemporalTypeException = time.temporal.UnsupportedTemporalTypeException


  // java.time.format
  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html java.time.format.DateTimeFormatter]]
    * DateTimeFormatter is a formatter for printing and parsing date-time objects.
    */
  type DateTimeFormatter = time.format.DateTimeFormatter

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatterBuilder.html java.time.format.DateTimeFormatterBuilder]]
    * DateTimeFormatterBuilder is a factory for creating date-time formatters.
    */
  type DateTimeFormatterBuilder = time.format.DateTimeFormatterBuilder

  // java.time.zone
  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/zone/ZoneRulesException.html java.time.zone.ZoneRulesException]]
    * ZoneRulesException is used to indicate a problems with the configured time-zone rules.
    */
  type ZoneRulesException = time.zone.ZoneRulesException

  // java.time.chrono
  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/chrono/ChronoLocalDate.html java.time.chrono.ChronoLocalDate]]
    * A date without time-of-day or time-zone in an arbitrary chronology, intended for advanced globalization use cases.
    */
  type ChronoLocalDate = time.chrono.ChronoLocalDate

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/chrono/ChronoLocalDateTime.html java.time.chrono.ChronoLocalDateTime]]
    * A date-time without a time-zone in an arbitrary chronology, intended for advanced globalization use cases.
    */
  type ChronoLocalDateTime[A <: ChronoLocalDate] = time.chrono.ChronoLocalDateTime[A]

  /** Alias for [[http://docs.oracle.com/javase/8/docs/api/java/time/chrono/ChronoZonedDateTime.html java.time.chrono.ChronoZonedDateTime]]
    * A date-time with a time-zone in an arbitrary chronology, intended for advanced globalization use cases.
    */
  type ChronoZonedDateTime[A <: ChronoLocalDate] = time.chrono.ChronoZonedDateTime[A]
}
