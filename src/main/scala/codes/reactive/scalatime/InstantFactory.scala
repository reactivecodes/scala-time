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


private[scalatime] abstract class InstantFactory {


  /** Obtains the current instant from the UTC system clock. **/
  def apply(): Instant

  /** Queries the provided [[Clock]] to obtain the current instant **/
  def apply(clock: Clock): Instant

  /** Obtain the current instance from milliseconds from the epoch of 1970-01-01T00:00:00Z.
    *
    * @param epochMilli the number of milliseconds from 1970-01-01T00:00:00Z
    * @throws DateTimeException - if the instant exceeds the maximum or minimum instant
    */
  def milli(epochMilli: Long): Instant

  /** Obtain the current instance from seconds from the epoch of 1970-01-01T00:00:00Z.
    *
    * @param epochSecond the number of seconds from 1970-01-01T00:00:00Z
    * @throws DateTimeException - if the instant exceeds the maximum or minimum instant
    */
  def second(epochSecond: Long): Instant

  /** Obtain the current instance from seconds from the epoch of 1970-01-01T00:00:00Z, and nanosecond fraction.
    *
    * @param epochSecond the number of seconds from 1970-01-01T00:00:00Z
    * @param nanoAdjustment the nanosecond adjustment to the number of seconds, positive or negative
    * @throws DateTimeException - if the instant exceeds the maximum or minimum instant
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def second(epochSecond: Long, nanoAdjustment: Long): Instant

  /** Queries a [[Temporal]] to obtain an [[Instant]] (if available)
    *
    * @param from the temporal to query
    * @throws DateTimeException - if unable to convert to an [[Instant]]
    */
  def from(from: TemporalAccessor): Try[Instant]

  /** Creates a new [[Instant]] instance from valid ISO-8601 instant formatted text, otherwise
    * throws an exception.
    *
    * @param text the text to parse such as "2007-12-03T10:15:30.00Z"
    * @throws DateTimeException - if the text cannot be successfully parsed as a LocalDate.
    */
  def parse(text: String): Instant

}
