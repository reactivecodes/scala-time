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

import java.time.{LocalDateTime => LD}


/** Factory object for creation of [[LocalDateTime]] instances
  * @since 0.1.0
  */
object LocalDateTime {

  /** Creates a new [[LocalDateTime]] instance by querying the current system UTC clock for the current date. **/
  def apply(): LocalDateTime = LD.now(Clock())

  /** Obtains a [[LocalDateTime]] instance by querying the provided clock for the current date. **/
  def apply(clock: Clock): LocalDateTime = LD.now(clock)

  /** Queries a [[Temporal]] to obtain an [[LocalDateTime]] (if available)
    *
    * @param from the temporal to query
    * @throws DateTimeException - if unable to convert to an [[LocalDateTime]]
    */
  def apply(from: TemporalAccessor): LocalDateTime = LD.from(from)

  /** Obtains a [[LocalDateTime]] instance from a [[LocalDate]] and [[LocalTime]] instance **/
  def apply(date: LocalDate, time: LocalTime): LocalDateTime = LD.of(date, time)


  /** Creates a new [[LocalDateTime]] instance from year, month, day, hour, minute, second and nanosecond.
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
    * @throws DateTimeException - if the value of any field is out of range or if the day-of-month is invalid for
    *                           the month-year.
    */
  def of(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int, nano: Int): LocalDateTime =
    LD.of(year, month, day, hour, minute, second, nano)


  /** Creates a new [[LocalDateTime]] instance from a year, month, day, hour, minute and second, setting the nanosecond
    * to zero. An exception will be thrown if the day is not valid for the year and month or if the value of any field
    * is out of range.
    *
    * @param year the year to represent
    * @param month the month to represent
    * @param day the day to represent
    * @param hour the hour to represent
    * @param minute the minute to represent
    * @param second the second to represent
    * @throws DateTimeException - if the value of any field is out of range or if the day-of-month is invalid for
    *                           the month-year.
    */
  def of(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int): LocalDateTime =
    LD.of(year, month, day, hour, minute, second)

  /** Creates a new [[LocalDateTime]] instance from a year, month, day, hour and minute, setting the second and
    * nanosecond to zero. An exception will be thrown if the day is not valid for the year and month or if the
    * value of any field is out of range.
    *
    * @param year the year to represent
    * @param month the month to represent
    * @param day the day to represent
    * @param hour the hour to represent
    * @param minute the minute to represent
    * @throws DateTimeException - if the value of any field is out of range or if the day-of-month is invalid for
    *                           the month-year.
    */
  def of(year: Int, month: Int, day: Int, hour: Int, minute: Int): LocalDateTime =
    LD.of(year, month, day, hour, minute)

  /** Creates a new [[LocalDateTime]] instance from a year, month, day, hour, minute, second and nanosecond. An
    * exception will be thrown if the day is not valid for the year and month or if the value of any field is out
    * of range.
    *
    * @param year the year to represent
    * @param month the month to represent
    * @param day the day to represent
    * @param hour the hour to represent
    * @param minute the minute to represent
    * @param second the second to represent
    * @param nano the nano to represent
    * @throws DateTimeException - if the value of any field is out of range or if the day-of-month is invalid for
    *                           the month-year.
    */
  def of(year: Int, month: Month, day: Int, hour: Int, minute: Int, second: Int, nano: Int): LocalDateTime =
    LD.of(year, month, day, hour, minute, second, nano)

  /** Creates a new [[LocalDateTime]] instance from a year, month, day, hour, minute and second, setting the nanosecond
    * to zero. An exception will be thrown if the day is not valid for the year and month or if the value of any field
    * is out of range.
    *
    * @param year the year to represent
    * @param month the month to represent
    * @param day the day to represent
    * @param hour the hour to represent
    * @param minute the minute to represent
    * @param second the second to represent
    * @throws DateTimeException - if the value of any field is out of range or if the day-of-month is invalid for
    *                           the month-year.
    */
  def of(year: Int, month: Month, day: Int, hour: Int, minute: Int, second: Int): LocalDateTime =
    LD.of(year, month, day, hour, minute, second)

  /** Creates a new [[LocalDateTime]] instance from year, month, day, hour and minute, setting the second and
    * nanosecond to zero. An exception will be thrown if the day is not valid for the year and month or if the value
    * of any field is out of range.
    *
    * @param year the year to represent
    * @param month the month to represent
    * @param day the day to represent
    * @param hour the hour to represent
    * @param minute the minute to represent
    * @throws DateTimeException - if the value of any field is out of range or if the day-of-month is invalid for
    *                           the month-year.
    */
  def of(year: Int, month: Month, day: Int, hour: Int, minute: Int): LocalDateTime =
    LD.of(year, month, day, hour, minute)

  /** Creates a new [[LocalDateTime]] instance from valid ISO-8601 extended offset date time formatted text, otherwise
    * throws an exception.
    *
    * @param text the text to parse such as "2007-12-03T10:15:30"
    * @throws DateTimeException - if the text cannot be successfully parsed as a LocalDate.
    */
  def parse(text: String): LocalDateTime = LD.parse(text)

  /** Creates a new [[LocalDateTime]] instance from valid text formatted according to the provided `formatter`, otherwise
    * throws an exception.
    *
    * @param text the text to parse
    * @throws DateTimeException - if the text cannot be successfully parsed as a LocalDate.
    */
  def parse(text: String, formatter: DateTimeFormatter): LocalDateTime = LD.parse(text, formatter)

}
