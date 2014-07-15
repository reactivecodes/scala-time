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


private[scalatime] abstract class OffsetTimeFactory {

  /** Obtains an [[OffsetTime]] instance from the current time of the system UTC clock. **/
  def apply(): OffsetTime

  /** Obtains an [[OffsetTime]] instance from the current time of the provided clock. **/
  def apply(clock: Clock): OffsetTime

  /** Obtains an [[OffsetTime]] instance from a [[LocalTime]] and [[ZoneOffset]] **/
  def apply(localTime: LocalTime, offset: ZoneOffset): OffsetTime

  /** Queries a [[Temporal]] to obtain a [[OffsetTime]] (if available)
    *
    * @throws DateTimeException - if unable to convert to a [[OffsetTime]]
    */
  def from(from: TemporalAccessor): Try[OffsetTime]

  /** Obtains an [[OffsetTime]] instance from valid ISO-8601 extended local time formatted text, otherwise
    * throws an exception.
    *
    * @param text the text to parse such as "10:15:30"
    * @throws DateTimeException if the text cannot be successfully parsed as an [[OffsetTime]]
    */
  def parse(text: String): OffsetTime

  /** Obtains an [[OffsetTime]] instance from valid text formatted according to the provided `formatter`, otherwise
    * throws an exception.
    *
    * @param text the text to parse
    * @throws DateTimeException if the text cannot be successfully parsed as an [[OffsetTime]]
    */
  def parse(text: String, formatter: DateTimeFormatter): OffsetTime

  /** Obtains an [[OffsetTime]] instance from an hour, minute, second and nanosecond.
    *
    * @param hour the hour-of-day to represent, from 0 to 23
    * @param minute the minute-of-hour to represent, from 0 to 59
    * @param second the second-of-minute to represent, from 0 to 59
    * @param nano the nano-of-second to represent, from 0 to 999,999,999
    * @throws DateTimeException - if the value of any field is out of range
    */
  def of(hour: Int, minute: Int, second: Int, nano: Int, offset: ZoneOffset): OffsetTime

  /** The maximum supported [[OffsetTime]] ('23:59:59.999999999-18:00' - the time just before midnight at the end of
    * the day in the minimum offset)
    */
  val Max: OffsetTime

  /** The minimum supported [[OffsetTime]] ('00:00:00+18:00' - the time of midnight at the start of the day in the
    * maximum offset)
    */
  val Min: OffsetTime
}
