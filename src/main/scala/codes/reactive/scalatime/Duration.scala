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

import impl.TimeSupport.{Duration => JD}
import scala.util.Try


/** Factory object for obtaining instances of [[Duration]].
  *
  * Duration is a time-based amount of time, such as '34.5 seconds'.
  *
  * @example
  * {{{
  *             import codes.reactive.scalatime._
  *
  *             // Obtain a Duration of 10 nano seconds
  *             val tenNanos = Duration.nanos(10)
  *
  *             // Obtain a Duration of zero
  *             val zero = Duration.Nil
  * }}}
  *
  */
object Duration {

  /** Obtains a [[Duration]] from a temporal amount which has an exact duration.
    *
    * @throws DateTimeException if unable to convert to a Duration.
    * @throws ArithmeticException if numeric overflow occurs.
    */
  def from(amount: TemporalAmount): Duration = JD.from(amount)

  /** Obtains a Duration representing the duration between two temporal objects. The specified temporal objects must
    * support the [[ChronoUnit.Seconds]] unit.
    *
    * @throws DateTimeException if the seconds between the temporals cannot be obtained.
    * @throws ArithmeticException if the calculation exceeds the capacity of Duration.
    */
  def between(start: Temporal, end: Temporal): Duration = JD.between(start, end)

  /** Obtains a [[Duration]] from text based on the ISO-8601 Duration format - PnDTnHnMn.nS - with days
    * considered to be exactly 24 hours.
    *
    * ==== Text Format ====
    * The text starts with an optional sign, denoted by the ASCII negative or positive symbol. If negative, the
    * whole period is negated.
    *
    * The ASCII letter "P" is next in upper or lower case.
    *
    * There are then four sections, each consisting of a number and a suffix. The sections have suffixes in ASCII of
    * "D", "H", "M" and "S" for days, hours, minutes and seconds, accepted in upper or lower case.
    *
    * The suffixes must occur in order. The ASCII letter "T" must occur before the first occurrence, if any, of an hour,
    * minute or second section. At least one of the four sections must be present, and if "T" is present there must be
    * at least one section after the "T". The number part of each section must consist of one or more ASCII digits. The
    * number may be prefixed by the ASCII negative or positive symbol. The number of days, hours and minutes must parse
    * to an long. The number of seconds must parse to a long with optional fraction. The decimal point may be either a
    * dot or a comma. The fractional part may have from zero to 9 digits.
    *
    * The leading plus/minus sign, and negative values for other units are not part of the ISO-8601 standard.
    *
    * @example
    * {{{
    *             import codes.reactive.scalatime._
    *
    *             // Parses as 20.345 seconds
    *             val dur1 = Duration.parse("PT20.345S")
    *
    *             // Parses as 2 days, 3 hours, 4 minutes
    *             val dur2 = Duration.parse("P2DT3H4M")
    *
    *             // Parses as minus 6 hours, 3 minutes
    *             val dur3 = Duration.parse("P-6H3M")
    * }}}
    *
    * @throws DateTimeParseException. if the text cannot be parsed to a duration
    */
  def parse(text: String): Duration = JD.parse(text)

  /** Obtains a [[Duration]] representing a number of nanoseconds. */
  def nanos(nanos: Long): Duration = JD.ofNanos(nanos)

  /** Obtains a [[Duration]] representing a number of milliseconds. */
  def millis(millis: Long): Duration = JD.ofMillis(millis)

  /** Obtains a [[Duration]] representing a number of seconds. */
  def seconds(seconds: Long): Duration = JD.ofSeconds(seconds, 0)

  /** Obtains a [[Duration]] representing a number of seconds adjusted by a number of nano-seconds. */
  def seconds(seconds: Long, nanoAdjuster: Long): Duration = JD.ofSeconds(seconds, nanoAdjuster)

  /** Obtains a [[Duration]] representing a number of minutes. */
  def minutes(minutes: Long): Duration = JD.ofMinutes(minutes)

  /** Obtains a [[Duration]] representing a number of hours. */
  def hours(hours: Long): Duration = JD.ofHours(hours)

  /** Obtains a [[Duration]] representing a number of days. */
  def days(days: Long): Duration = JD.ofDays(days)

  /** Obtains a [[Duration]] of zero. */
  def empty: Duration = JD.zero
  private final val EmptyDuration = JD.zero
}
