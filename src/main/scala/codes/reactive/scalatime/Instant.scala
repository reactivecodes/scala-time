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

import impl.TimeSupport.{Instant => I}
import scala.util.Try


/** Factory object for obtaining instances of [[Instant! Instant]].
  *
  * Instant is an instantaneous point on the time-line.
  *
  * @example
  *          {{{
  *            import codes.reactive.scalatime._
  *
  *            // Obtain the current instant of a Clock
  *            val clockInstant = Instant(Clock())
  *
  *            // Obtain the current instant
  *            val currentInstant = Instant()
  *          }}}
  *
  */
object Instant {

  /** Obtains the current instant from the UTC system clock. **/
  def apply(): Instant = apply(Clock())

  /** Queries the provided [[Clock]] to obtain the current instant **/
  def apply(clock: Clock): Instant = I.now(clock)

  /** Obtains an [[Instant]] from specified milliseconds from the epoch of 1970-01-01T00:00:00Z.
    *
    * @throws DateTimeException if the instant exceeds the maximum or minimum instant.
    */
  def milli(epochMilli: Long): Instant = I.epochMilli(epochMilli)

  /** Obtains an [[Instant]] from specified seconds from the epoch of 1970-01-01T00:00:00Z.
    *
    * @throws DateTimeException if the instant exceeds the maximum or minimum instant.
    * @throws ArithmeticException if numeric overflow occurs.
    */
  def second(epochSecond: Long): Instant = I.epochSec(epochSecond, 0)

  /** Obtains an [[Instant]] from specified seconds from the epoch of 1970-01-01T00:00:00Z, and nanosecond
    * fraction.
    *
    * @throws DateTimeException if the instant exceeds the maximum or minimum instant.
    * @throws ArithmeticException if numeric overflow occurs.
    */
  def second(epochSecond: Long, nanoAdjustment: Long): Instant = I.epochSec(epochSecond, nanoAdjustment)

  /** Queries a [[Temporal]] to obtain an [[Instant]].
    *
    * @throws DateTimeException if unable to convert to an Instant.
    */
  def from(from: TemporalAccessor): Instant = I.from(from)

  /** Obtains an [[Instant]] from text formatted according to [[format.DateTimeFormatter.Iso.Instant]], such as
    * `2014-07-15T14:47:00.00Z`.
    *
    * @throws DateTimeParseException - if the text cannot be parsed.
    */
  def parse(text: String): Instant = I.parse(text)
}
