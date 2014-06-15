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
package chrono


/** Enriches a [[ChronoLocalDate]] with Scala friendly method syntax
  * @since 0.1.0
  */
final class RichChronoLocalDate(val underlying: ChronoLocalDate) extends AnyVal {

  /** Combines this date with a time to create a LocalDateTime. **/
  def %(time: LocalTime): ChronoLocalDateTime[_] = underlying.atTime(time)

  /** Formats this date using the specified formatter.
    * @throws DateTimeException - if an error occurs during printing
    */
  def >>(formatter: DateTimeFormatter): String = underlying.format(formatter)
}


/** Enriches a [[ChronoLocalDateTime]] with Scala friendly method syntax
  * @since 0.1.0
  */
final class RichChronoLocalDateTime[A <: ChronoLocalDate](val underlying: ChronoLocalDateTime[A]) extends AnyVal {

  /** Combines this date-time with a time-zone to create a ZonedDateTime. **/
  def %(zone: ZoneID): ChronoZonedDateTime[A] = underlying.atZone(zone)

  /** Formats this date using the specified formatter.
    * @throws DateTimeException - if an error occurs during printing
    */
  def >>(formatter: DateTimeFormatter): String = underlying.format(formatter)

}


/** Enriches a [[ChronoZonedDateTime]] with Scala friendly method syntax
  * @since 0.1.0
  */
final class RichChronoZonedDateTime[A <: ChronoLocalDate](val underlying: ChronoZonedDateTime[A]) extends AnyVal {

  /** Formats this date using the specified formatter.
    * @throws DateTimeException - if an error occurs during printing
    */
  def >>(formatter: DateTimeFormatter): String = underlying.format(formatter)

}
