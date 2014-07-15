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


/** Factory object for creating [[LocalTime]] instances **/
private[scalatime] abstract class LocalTimeFactory {

  /** Creates a new [[LocalTime]] instance from the current time of the system UTC clock. **/
  def apply(): LocalTime

  /** Creates a new [[LocalTime]] instance from the current time of the provided clock. 
    *
    * @param clock  the clock to use
    */
  def apply(clock: Clock): LocalTime

  /** Queries a [[Temporal]] to obtain a [[LocalTime]] (if available)
    *
    * @param from the temporal to query
    * @throws DateTimeException - if unable to convert to a [[LocalTime]]
    */
  def from(from: TemporalAccessor): Try[LocalTime]

  /** Tries to obtain a [[LocalTime]] instance from text formatted according to [[DateTimeFormatter.Iso.LocalTime]].
    *
    * @param text the text to parse such as "10:15:30"
    */
  def parse(text: String): Try[LocalTime]

  /** Tries to obtain a [[LocalTime]] instance from valid text formatted according to the provided `formatter`. */
  def parse(text: String, formatter: DateTimeFormatter): Try[LocalTime]

  /** Creates a new [[LocalTime]] instance from an hour, minute, second and nanosecond.
    *
    * @param hour the hour-of-day to represent, from 0 to 23
    * @param minute the minute-of-hour to represent, from 0 to 59
    * @param second the second-of-minute to represent, from 0 to 59
    * @param nano the nano-of-second to represent, from 0 to 999,999,999
    * @throws DateTimeException - if the value of any field is out of range
    */
  def of(hour: Int, minute: Int, second: Int, nano: Int): LocalTime

  /** Creates a new [[LocalTime]] instance from an hour, minute and second.
    *
    * @param hour the hour-of-day to represent, from 0 to 23
    * @param minute the minute-of-hour to represent, from 0 to 59
    * @param second the second-of-minute to represent, from 0 to 59
    * @throws DateTimeException - if the value of any field is out of range
    */
  def of(hour: Int, minute: Int, second: Int): LocalTime

  /** Creates a new [[LocalTime]] instance from an hour and minute.
    *
    * @param hour the hour-of-day to represent, from 0 to 23
    * @param minute the minute-of-hour to represent, from 0 to 59
    * @throws DateTimeException - if the value of any field is out of range
    */
  def of(hour: Int, minute: Int): LocalTime

  /** Creates a new [[LocalTime]] instance from from a nanos-of-day value.
    *
    * @param  nanoOfDay the nano of day, from 0 to 24 * 60 * 60 * 1,000,000,000 - 1
    * @throws DateTimeException - if the nanos of day value is invalid
    */
  def ofNano(nanoOfDay: Long): LocalTime

  /** Creates a new [[LocalTime]] instance from from a second-of-day value.
    *
    * @param  secondOfDay the second-of-day, from 0 to 24 * 60 * 60 - 1
    * @throws DateTimeException - if the second of day value is invalid
    */
  def ofSecond(secondOfDay: Long): LocalTime

  /** The maximum supported LocalTime ('23:59:59.999999999' - just before midnight at the end of the day). **/
  def Max: LocalTime

  /** The LocalTime of midnight at the start of the day, '00:00'. **/
  def Midnight: LocalTime

  /** The minimum supported LocalTime ('00:00' - the time of midnight at the start of the day). **/
  def Min: LocalTime

  /** The LocalTime of noon in the middle of the day, '12:00'. **/
  def Noon: LocalTime
}
