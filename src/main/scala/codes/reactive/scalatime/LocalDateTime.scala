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

import impl.TimeSupport.{LocalDateTime => LD}
import scala.util.Try


/** Factory object for creation of [[LocalDateTime]] instances.  */
object LocalDateTime {

  /** Obtains a [[LocalDateTime]] by querying the current system UTC clock for the current date. */
  def apply(): LocalDateTime = LD.now(Clock())

  /** Obtains a [[LocalDateTime]] by querying the specified clock for the current date. */
  def apply(clock: Clock): LocalDateTime = LD.now(clock)

  /** Obtains a [[LocalDateTime]] from the specified [[LocalDate]] and [[LocalTime]]. */
  def apply(date: LocalDate, time: LocalTime): LocalDateTime = LD.of(date, time)

  /** Tries to query a [[Temporal]] instance to obtain a [[LocalDateTime]]. */
  def from(from: TemporalAccessor): Try[LocalDateTime] = Try(LD.from(from))

  /** Tries to obtain a [[LocalDateTime]] from a year, month, day, hour, minute, second and nanosecond. The values of
    * all fields must be within range, and the day must be valid for the year and month.
    */
  def of(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int, nano: Int): Try[LocalDateTime] =
    Try(LD.of(year, Month(month), day, hour, minute, second, nano))

  /** Tries to obtain a [[LocalDateTime]] from a year, month, day, hour, minute and second, setting the nanosecond to
    * zero. The values of all fields must be within range, and the day must be valid for the year and month.
    */
  def of(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int): Try[LocalDateTime] =
    Try(LD.of(year, Month(month), day, hour, minute, second, 0))

  /** Tries to obtain a [[LocalDateTime]] from a year, month, day, hour and minute, setting the second and nanosecond to
    * zero. The values of all fields must be within range, and the day must be valid for the year and month.
    */
  def of(year: Int, month: Int, day: Int, hour: Int, minute: Int): Try[LocalDateTime] =
    Try(LD.of(year, Month(month), day, hour, minute, 0, 0))

  /** Tries to obtain a [[LocalDateTime]] from a year, month, day, hour, minute, second and nanosecond. The values of
    * all fields must be within range, and the day must be valid for the year and month.
    */
  def of(year: Int, month: Month, day: Int, hour: Int, minute: Int, second: Int, nano: Int): Try[LocalDateTime] =
    Try(LD.of(year, month, day, hour, minute, second, nano))

  /** Tries to obtain a [[LocalDateTime]] from a year, month, day, hour, minute and second, setting the nanosecond to
    * zero. The values of all fields must be within range, and the day must be valid for the year and month.
    */
  def of(year: Int, month: Month, day: Int, hour: Int, minute: Int, second: Int): Try[LocalDateTime] =
    Try(LD.of(year, month, day, hour, minute, second, 0))

  /** Tries to obtain a [[LocalDateTime]] from year, month, day, hour and minute, setting the second and nanosecond to
    * zero. The values of all fields must be within range, and the day must be valid for the year and month.
    */
  def of(year: Int, month: Month, day: Int, hour: Int, minute: Int): Try[LocalDateTime] =
    Try(LD.of(year, month, day, hour, minute, 0, 0))

  /** Tries to obtain a [[LocalDateTime]] instance from text formatted according to
    * [[format.DateTimeFormatter.Iso.LocalDateTime]].
    *
    * @param text the text to parse such as "2007-12-03T10:15:30"
    */
  def parse(text: String): Try[LocalDateTime] = Try(LD.parse(text, format.DateTimeFormatter.Iso.LocalDateTime))

  /** Tries to obtain a [[LocalDateTime]] instance from valid text formatted according to the provided `formatter`. */
  def parse(text: String, formatter: DateTimeFormatter): Try[LocalDateTime] = Try(LD.parse(text, formatter))

}
