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

import impl.TimeSupport.{Month => M}

import scala.util.Try

/** Factory for obtaining singleton instances of [[Month]].
  *
  * @define Repr  The singleton instance for the month of
  */
object Month {

  /** Obtains the current [[Month]] at UTC. */
  def apply(): Month = from(OffsetDateTime())

  /** Obtains the [[Month]] of an int value (from 1 to 12).
    *
    * @throws DateTimeException if the month-of-year is invalid.
    */
  def apply(month: Int): Month = M.of(month)

  /** Queries a [[Temporal]] to obtain a Month.
    * @throws DateTimeException if unable to convert to a Month.
    */
  def from(temporal: TemporalAccessor): Month = M.from(temporal)

  /** $Repr January, with 31 days and a numeric value of `1`. */
  final val January = apply(1)

  /** $Repr February, with 28 days (or 29 in a leap year) and a numeric value of `2`. */
  final val February = apply(2)

  /** $Repr March, with 31 days and a numeric value of `3`. */
  final val March = apply(3)

  /** $Repr April, with 30 days and a numeric value of `4`. */
  final val April = apply(4)

  /** $Repr May, with 31 days and a numeric value of `5`. */
  final val May = apply(5)

  /** $Repr June, with 30 days and a numeric value of `6`. */
  final val June = apply(6)

  /** $Repr July, with 31 days and a numeric value of `7`. */
  final val July = apply(7)

  /** $Repr August, with 31 days and a numeric value of `8`. */
  final val August = apply(8)

  /** $Repr September, with 30 days and a numeric value of `9`. */
  final val September = apply(9)

  /** $Repr October, with 31 days and a numeric value of `10`. */
  final val October = apply(10)

  /** $Repr November, with 30 days and a numeric value of `11`. */
  final val November = apply(11)

  /** $Repr December, with 31 days and a numeric value of `12`. */
  final val December = apply(12)

}



