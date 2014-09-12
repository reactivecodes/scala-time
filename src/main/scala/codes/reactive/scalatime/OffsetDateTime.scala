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

import impl.TimeSupport.{OffsetDateTime => OD}
import util.Try

/** Factory object for obtaining [[OffsetDateTime]] instances. */
object OffsetDateTime {

  /** Obtains an [[OffsetDateTime]] by querying the current system clock at UTC for the current date. */
  def apply(): OffsetDateTime = OD.now(Clock())

  /** Obtains an [[OffsetDateTime]] by querying the specified clock for the current time. */
  def apply(clock: Clock): OffsetDateTime = OD.now(clock)

  /** Obtains an [[OffsetDateTime]] from the specified [[LocalDate]], [[LocalTime]] and [[ZoneOffset]]. */
  def apply(date: LocalDate, time: LocalTime, zone: ZoneOffset): OffsetDateTime = OD.of(date, time, zone)

  /** Obtains an [[OffsetDateTime]] from the specified [[LocalDateTime]] and [[ZoneOffset]]. */
  def apply(dateTime: LocalDateTime, zone: ZoneOffset): OffsetDateTime = OD.of(dateTime, zone)

  /** Tries to query a [[Temporal]] instance to obtain an [[OffsetDateTime]]. */
  def from(from: TemporalAccessor): Try[OffsetDateTime] = Try(OD.from(from))

  /** Tries to obtain an [[OffsetDateTime]] from a year, month, day, hour, minute, second, nanosecond and offset. The
    * values of all fields must be within range, and the day must be valid for the year and month.
    */
  def of(year: Int,
         month: Int,
         day: Int,
         hour: Int,
         minute: Int,
         second: Int,
         nano: Int,
         zone: ZoneOffset): Try[OffsetDateTime] =
    Try(OD.of(year, month, day, hour, minute, second, nano, zone))

  /** Tries to obtain an [[OffsetDateTime]] from a year, [[Month]], day, hour, minute, second, nanosecond and offset. The values of
    * all fields must be within range, and the day must be valid for the year and month.
    */
  def of(year: Int,
         month: Month,
         day: Int,
         hour: Int,
         minute: Int,
         second: Int,
         nano: Int,
         zone: ZoneOffset): Try[OffsetDateTime] =
    Try(OD.of(year, month.getValue, day, hour, minute, second, nano, zone))

  /** Tries to obtain an [[OffsetDateTime]] from text formatted according to [[format.DateTimeFormatter.Iso.OffsetDateTime]].
    *
    * @param text the text to parse such as "2007-12-03T10:15:30+01:00"
    */
  def parse(text: String): Try[OffsetDateTime] = Try(OD.parse(text, format.DateTimeFormatter.Iso.OffsetDateTime))

  /** Tries to obtain an [[OffsetDateTime]] from valid text formatted according to the provided `formatter`. */
  def parse(text: String, formatter: DateTimeFormatter): Try[OffsetDateTime] = Try(OD.parse(text, formatter))

  /** The maximum supported OffsetDateTime, '+999999999-12-31T23:59:59.999999999-18:00' - or 'far future'. */
  val Max: OffsetDateTime = OD.max

  /** The minimum supported OffsetDateTime, '-999999999-01-01T00:00:00+18:00' - or 'far past'. */
  val Min: OffsetDateTime = OD.min

}
