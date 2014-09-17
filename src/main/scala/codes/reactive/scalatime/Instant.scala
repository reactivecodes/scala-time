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

import impl.TimeSupport.{Instant => I}
import scala.util.Try


/** Factory object for obtaining instances of [[Instant]].
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
  * @since  0.1.0
  */
object Instant {

  /** Obtains the current instant from the UTC system clock. **/
  def apply(): Instant = apply(Clock())

  /** Queries the provided [[Clock]] to obtain the current instant **/
  def apply(clock: Clock): Instant = I.now(clock)

  /** Tries to obtain an [[Instant]] from specified milliseconds from the epoch of 1970-01-01T00:00:00Z. */
  def milli(epochMilli: Long): Try[Instant] = Try(I.epochMilli(epochMilli))

  /** Tries to obtain an [[Instant]] from specified seconds from the epoch of 1970-01-01T00:00:00Z. */
  def second(epochSecond: Long): Try[Instant] = Try(I.epochSec(epochSecond, 0))

  /** Tries to obtain an [[Instant]] from specified seconds from the epoch of 1970-01-01T00:00:00Z, and nanosecond
    * fraction.
    */
  def second(epochSecond: Long, nanoAdjustment: Long): Try[Instant] = Try(I.epochSec(epochSecond, nanoAdjustment))

  /** Tries to query a [[Temporal]] to obtain an [[Instant]]. */
  def from(from: TemporalAccessor): Try[Instant] = Try(I.from(from))

  /** Tries to obtain an [[Instant]] from text formatted according to [[format.DateTimeFormatter.Iso.Instant]], such as
    * `2014-07-15T14:47:00.00Z`.
    */
  def parse(text: String): Try[Instant] = Try(I.parse(text))
}
