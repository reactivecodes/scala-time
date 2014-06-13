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

package ke.co.sbsproperties.scalatime

import java.time.temporal.{ChronoField => CF, ChronoUnit => CU}


@deprecated object ChronoUnits extends ChronoUnits

trait ChronoUnits {

  /** [[ChronoUnit]] which represents the concept of a century. For the ISO calendar system, it is equal to 100 years. **/
  val centuries: ChronoUnit = CU.CENTURIES

  /** [[ChronoUnit]] which represents the concept of a day. For the ISO calendar system, it is the standard day from midnight to
    * midnight. The estimated duration of a day is 24 Hours.
    *
    * When used with other calendar systems it must correspond to the day defined by the rising and setting of the Sun
    * on Earth. It is not required that days begin at midnight - when converting between calendar systems, the date
    * should be equivalent at midday.
    */
  val days: ChronoUnit = CU.DAYS

  /** [[ChronoUnit]] which represents the concept of a decade. For the ISO calendar system, it is equal to 10 years.
    *
    * When used with other calendar systems it must correspond to an integral number of days and is normally
    * an integral number of years.
    */
  val decades: ChronoUnit = CU.DECADES

  /** [[ChronoUnit]] which represents the concept of an era. The ISO calendar system doesn't have eras thus it is impossible to
    * add an era to a date or date-time. The estimated duration of the era is artificially defined as 1,000,000,000
    * Years.
    */
  val eras: ChronoUnit = CU.ERAS

  /** Artificial unit that represents the concept of forever. This is primarily used with [[TemporalField]] to represent
    * unbounded fields such as the year or era. The estimated duration of the era is artificially defined as the
    * largest duration supported by [[Duration]].
    */
  val forever: ChronoUnit = CU.FOREVER

  /** [[ChronoUnit]] which represents the concept of half a day, as used in AM/PM. For the ISO calendar system, it is equal
    * to 12 hours.
    */
  val halfDays: ChronoUnit = CU.HALF_DAYS

  /** [[ChronoUnit]] which represents the concept of an hour. For the ISO calendar system, it is equal to 60 minutes. **/
  val hours: ChronoUnit = CU.HOURS

  /** [[ChronoUnit]] which represents the concept of a microsecond. For the ISO calendar system, it is equal to the 1,000,000th
    * part of the second unit.
    */
  val micros: ChronoUnit = CU.MICROS

  /** [[ChronoUnit]] which represents the concept of a millennium. For the ISO calendar system, it is equal to 1000 years.
    * When used with other calendar systems it must correspond to an integral number of days and is normally an
    * integral number of years.
    */
  val millenia: ChronoUnit = CU.MILLENNIA

  /** [[ChronoUnit]] which represents the concept of a millisecond. For the ISO calendar system, it is equal to the 1000th
    * part of the second unit.
    */
  val millis: ChronoUnit = CU.MILLIS

  /** [[ChronoUnit]] which represents the concept of a minute. For the ISO calendar system, it is equal to 60 seconds. **/
  val minutes: ChronoUnit = CU.MINUTES

  /** [[ChronoUnit]] which represents the concept of a month. For the ISO calendar system, the length of the month varies by
    * month-of-year. The estimated duration of a month is one twelfth of 365.2425 Days. When used with other calendar
    * systems it must correspond to an integral number of days.
    */
  val months: ChronoUnit = CU.MONTHS

  /** [[ChronoUnit]] which represents the concept of a nanosecond, the smallest supported unit of time. For the ISO calendar
    * system, it is equal to the 1,000,000,000th part of the second unit.
    */
  val nanos: ChronoUnit = CU.NANOS

  /** [[ChronoUnit]] which represents the concept of a second. For the ISO calendar system, it is equal to the second in the
    * SI system of units, except around a leap-second.
    */
  val seconds: ChronoUnit = CU.SECONDS

  /** [[ChronoUnit]] which represents the concept of a week. For the ISO calendar system, it is equal to 7 days.
    * When used with other calendar systems it must correspond to an integral number of days.
    */
  val weeks: ChronoUnit = CU.WEEKS

  /** [[ChronoUnit]] which represents the concept of a year. For the ISO calendar system, it is equal to 12 months. The estimated
    * duration of a year is 365.2425 Days. When used with other calendar systems it must correspond to an integral
    * number of days or months roughly equal to a year defined by the passage of the Earth around the Sun.
    */
  val years: ChronoUnit = CU.YEARS

}


@deprecated object ChronoFields extends ChronoFields

trait ChronoFields {

  val alignedDayOfWeekInMonth: ChronoField = CF.ALIGNED_DAY_OF_WEEK_IN_MONTH

  val alignedDayOfWeekInYear: ChronoField = CF.ALIGNED_DAY_OF_WEEK_IN_YEAR

  val alignedWeekOfMonth: ChronoField = CF.ALIGNED_WEEK_OF_MONTH

  val alignedWeedOfYear: ChronoField = CF.ALIGNED_WEEK_OF_YEAR

  val amPmOfDay: ChronoField = CF.AMPM_OF_DAY

  val clockHourOfAmPm: ChronoField = CF.CLOCK_HOUR_OF_AMPM

  val clockHourOfDay: ChronoField = CF.CLOCK_HOUR_OF_DAY

  val dayOfMonth: ChronoField = CF.DAY_OF_MONTH

  val dayOfWeek: ChronoField = CF.DAY_OF_WEEK

  val dayOfYear: ChronoField = CF.DAY_OF_YEAR

  val epochDay: ChronoField = CF.EPOCH_DAY

  val era: ChronoField = CF.ERA

  val hourOfMonth: ChronoField = CF.HOUR_OF_AMPM

  val hourOfDay: ChronoField = CF.HOUR_OF_DAY

  val instantSeconds: ChronoField = CF.INSTANT_SECONDS

  val microOfDay: ChronoField = CF.MICRO_OF_DAY

  val microOfSecond: ChronoField = CF.MICRO_OF_SECOND

  val milliOfDay: ChronoField = CF.MILLI_OF_DAY

  val milliOfSecond: ChronoField = CF.MILLI_OF_SECOND

  val minuteOfDay: ChronoField = CF.MINUTE_OF_DAY

  val minuteOfMonth: ChronoField = CF.MINUTE_OF_HOUR

  val monthOfYear: ChronoField = CF.MONTH_OF_YEAR

  val monthOfday: ChronoField = CF.NANO_OF_DAY

  val nanoOfSecond: ChronoField = CF.NANO_OF_SECOND

  val offsetSeconds: ChronoField = CF.OFFSET_SECONDS

  val prolepticMonth: ChronoField = CF.PROLEPTIC_MONTH

  val secondOfDay: ChronoField = CF.SECOND_OF_DAY

  val secondOfMinute: ChronoField = CF.SECOND_OF_MINUTE

  val year: ChronoField = CF.YEAR

  val yearOfEra: ChronoField = CF.YEAR_OF_ERA
}
