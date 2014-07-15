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

import scala.util.Try


/** Factory object for creation of [[ZonedDateTime]] instances
  * @since 0.1.0
  */
private[scalatime] abstract class ZonedDateTimeFactory {


  /** Creates a new [[ZonedDateTime]] instance by querying the current system UTC clock for the current date. **/
  def apply(): ZonedDateTime

  /** Creates a new [[ZonedDateTime]] instance by querying the provided clock for the current date. **/
  def apply(clock: Clock): ZonedDateTime

  /** Tries to query a [[Temporal]] to obtain an [[ZonedDateTime]]. */
  def from(from: TemporalAccessor): Try[ZonedDateTime]

  /** Obtain a [[ZonedDateTime]] instance from [[LocalDate]], [[LocalTime]] and [[ZoneID]] instance **/
  def apply(date: LocalDate, time: LocalTime, zone: ZoneID): ZonedDateTime

  /** Obtain a [[ZonedDateTime]] instance from a [[LocalDateTime]] and [[ZoneID]] instance **/
  def apply(dateTime: LocalDateTime, zone: ZoneID): ZonedDateTime

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
  def of(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int, nano: Int, zone: ZoneID): ZonedDateTime

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
  def of(year: Int, month: Month, day: Int, hour: Int, minute: Int, second: Int, nano: Int, zone: ZoneID): ZonedDateTime

  /** Tries to obtain a [[ZonedDateTime]] instance from text formatted according to
    * [[DateTimeFormatter.Iso.ZonedDateTime]].
    *
    * @param text the text to parse such as "2011-12-03T10:15:30+01:00[Europe/Paris]".
    */
  def parse(text: String): Try[ZonedDateTime]

  /** Tries to obtain a [[ZonedDateTime]] instance from valid text formatted according to the provided `formatter`. */
  def parse(text: String, formatter: DateTimeFormatter): Try[ZonedDateTime]

}
