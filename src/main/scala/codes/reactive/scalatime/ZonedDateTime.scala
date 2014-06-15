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

import java.time.{ZonedDateTime => ZD}


/** Factory object for creation of [[ZonedDateTime]] instances
  * @since 0.1.0
  */
object ZonedDateTime {


  /** Creates a new [[ZonedDateTime]] instance by querying the current system UTC clock for the current date. **/
  def apply(): ZonedDateTime = ZD.now(Clock())

  /** Creates a new [[ZonedDateTime]] instance by querying the provided clock for the current date. **/
  def apply(clock: Clock): ZonedDateTime = ZD.now(clock)

  /** Queries a [[Temporal]] to obtain an [[ZonedDateTime]] (if available)
    *
    * @param from the temporal to query
    * @throws DateTimeException - if unable to convert to an [[ZonedDateTime]]
    */
  def apply(from: TemporalAccessor): ZonedDateTime = ZD.from(from)

  /** Creates a new [[ZonedDateTime]] instance from a year, month, day, hour, minute, second, nanosecond and zone.
    * An exception will be thrown if the day is not valid for the year and month or if the value of any field is
    * out of range.
    *
    * @param year the year to represent
    * @param month the month to represent
    * @param day the day to represent
    * @param hour the hour to represent
    * @param minute the minute to represent
    * @param second the second to represent
    * @param nano the nano to represent
    * @param zone the time zone
    * @throws DateTimeException - if the value of any field is out of range or if the day-of-month is invalid for
    *                           the month-year.
    */
  def of(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int, nano: Int, zone: ZoneID): ZonedDateTime =
    ZD.of(year, month, day, hour, minute, second, nano, zone)

  /** Creates a new [[ZonedDateTime]] instance from a year, month, day, hour, minute, second, nanosecond and zone.
    * An exception will be thrown if the day is not valid for the year and month or if the value of any field is out
    * of range.
    *
    * @param year the year to represent
    * @param month the month to represent
    * @param day the day to represent
    * @param hour the hour to represent
    * @param minute the minute to represent
    * @param second the second to represent
    * @param nano the nano to represent
    * @param zone the time zone
    * @throws DateTimeException - if the value of any field is out of range or if the day-of-month is invalid for
    *                           the month-year.
    */
  def of(year: Int, month: Month, day: Int, hour: Int, minute: Int, second: Int, nano: Int, zone: ZoneID): ZonedDateTime =
    ZD.of(year, month.getValue, day, hour, minute, second, nano, zone)


  /** Creates a new [[ZonedDateTime]] instance from [[LocalDate]], [[LocalTime]] and [[ZoneID]] instance
    *
    * @param date the local date
    * @param time the local time
    * @param zone the time zone
    */
  def of(date: LocalDate, time: LocalTime, zone: ZoneID): ZonedDateTime = ZD.of(date, time, zone)

  /** Creates a new [[ZonedDateTime]] instance from a [[LocalDateTime]] and [[ZoneID]] instance
    *
    * @param dateTime the local date
    * @param zone the time zone
    * @return a new [[ZonedDateTime]]
    */
  def of(dateTime: LocalDateTime, zone: ZoneID): ZonedDateTime = ZD.of(dateTime, zone)

  /** Creates a new [[ZonedDateTime]] instance from valid ISO-8601 extended offset date time formatted text, otherwise
    * throws an exception.
    *
    * @param text the text to parse such as "2007-12-03T10:15:30"
    * @throws DateTimeException if the text cannot be successfully parsed as an [[OffsetDateTime]]
    */
  def parse(text: String): ZonedDateTime = ZD.parse(text)

  /** Creates a new [[ZonedDateTime]] instance from valid text formatted according to the provided `formatter`, otherwise
    * throws an exception.
    *
    * @param text the text to parse
    * @throws DateTimeException if the text cannot be successfully parsed as an [[OffsetDateTime]]
    */
  def parse(text: String, formatter: DateTimeFormatter): ZonedDateTime = ZD.parse(text, formatter)

}
