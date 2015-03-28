/******************************************************************
 * See the NOTICE file distributed with this work for additional  *
 * information regarding Copyright ownership.  The author/authors *
 * license this file to you under the terms of the Apache License *
 * Version 2.0 (the "License"); you may not use this file except  *
 * in compliance with the License.  You may obtain a copy of the  *
 * License at:                                                    *
 *                                                                *
 *     http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                                *
 * Unless required by applicable law or agreed to in writing,     *
 * software distributed under the License is distributed on an    *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,   *
 * either express or implied.  See the License for the specific   *
 * language governing permissions and limitations under the       *
 * License.                                                       *
 ******************************************************************/

package codes.reactive.scalatime

import impl.TimeSupport.{LocalTime => LT}


/** Factory object for obtaining [[LocalTime]] instances. **/
object LocalTime {

  /** Obtains a [[LocalTime]] by querying the current system clock at UTC for the current time. */
  def apply(): LocalTime = LT.now(Clock())

  /** Obtains a [[LocalTime]] by querying the specified clock for the current time. */
  def apply(clock: Clock): LocalTime = LT.now(clock)

  /** Queries a [[Temporal]] instance to obtain a [[LocalTime]].
    * @throws DateTimeException if unable to convert to a LocalTime.
    */
  def from(from: TemporalAccessor): LocalTime = LT.from(from)

  /** Obtains a [[LocalTime]] from text formatted according to [[format.DateTimeFormatter.Iso.LocalTime]].
    * @param text the text to parse such as "10:15:30"
    * @throws DateTimeParseException if the text cannot be parsed.
    */
  def parse(text: String): LocalTime = LT.parse(text, format.DateTimeFormatter.Iso.LocalTime)

  /** Obtains a [[LocalTime]] instance from valid text formatted according to the provided `formatter`.
    * @throws DateTimeParseException if the text cannot be parsed.
    */
  def parse(text: String, formatter: DateTimeFormatter):  LocalTime = LT.parse(text, formatter)

  /** Obtains a [[LocalTime]] from an hour, minute, second and nanosecond. All values must be within range.
    * @throws DateTimeException if the value of any field is out of range.
    */
  def of(hour: Int, minute: Int, second: Int, nano: Int): LocalTime = LT.of(hour, minute, second, nano)

  /** Obtains a [[LocalTime]] from an hour, minute and second, setting nanoseconds to zero. All values
    *  must be within range.
    * @throws DateTimeException if the value of any field is out of range.
    */
  def of(hour: Int, minute: Int, second: Int): LocalTime = LT.of(hour, minute, second, 0)

  /** Obtains a [[LocalTime]] from an hour and minute, setting seconds and nanoseconds to zero. Both values
    * must be within range.
    * @throws DateTimeException if the value of any field is out of range.
    */
  def of(hour: Int, minute: Int): LocalTime = LT.of(hour, minute, 0, 0)

  /** Obtains a [[LocalTime]] instance from from a nanos-of-day value - from 0 to 24 * 60 * 60 * 1,000,000,000 - 1.
    * @throws DateTimeException if the `nanoOfDay` value is invalid.
    */
  def ofNano(nanoOfDay: Long): LocalTime = LT.ofNano(nanoOfDay)

  /** Obtains a [[LocalTime]] instance from from a second-of-day value - from 0 to 24 * 60 * 60 - 1.
    * @throws DateTimeException if the `secondOfDay` value is invalid.
    */
  def ofSecond(secondOfDay: Long): LocalTime = LT.ofSec(secondOfDay)

  /** The maximum supported LocalTime ('23:59:59.999999999' - just before midnight at the end of the day). */
  val Max: LocalTime = LT.max

  /** The LocalTime of midnight at the start of the day, '00:00'. */
  val Midnight: LocalTime = LT.min

  /** The minimum supported LocalTime ('00:00' - the time of midnight at the start of the day). */
  val Min: LocalTime = Midnight

  /** The LocalTime of noon in the middle of the day, '12:00'. */
  val Noon: LocalTime = LT.noon

}
