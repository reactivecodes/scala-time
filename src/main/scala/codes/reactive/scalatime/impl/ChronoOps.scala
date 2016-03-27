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

package codes.reactive.scalatime.impl

import java.time.chrono.{ChronoLocalDate, ChronoLocalDateTime, ChronoZonedDateTime}
import java.time.format.DateTimeFormatter
import java.time.{DateTimeException, LocalTime, ZoneId}

import scala.language.implicitConversions

/** Enriches a [[ChronoLocalDate]] with additional methods.  */
final case class ChronoLocalDateOps(underlying: ChronoLocalDate) extends AnyVal {

  /** Combines this date with a time to create a LocalDateTime. **/
  def %%[A <: underlying.type](time: LocalTime): ChronoLocalDateTime[A] =
    underlying.atTime(time).asInstanceOf[ChronoLocalDateTime[A]]

  /** Formats this date using the specified formatter.
    *
    * @throws DateTimeException - if an error occurs during formatting.
    */
  def |>(formatter: DateTimeFormatter): String = underlying.format(formatter)

  /** Formats this date using the specified formatter.
    *
    * @throws DateTimeException - if an error occurs during formatting.
    */
  def ▹(formatter: DateTimeFormatter): String = underlying.format(formatter)
}

trait ToChronoLocalDateOps {
  implicit final def toChronoLocalDateOpsFromChronoLocalDate(f: ChronoLocalDate): ChronoLocalDateOps =
    new ChronoLocalDateOps(f)
}


/** Enriches a [[ChronoLocalDateTime]] with additional methods. */
final case class ChronoLocalDateTimeOps[A <: ChronoLocalDate](underlying: ChronoLocalDateTime[A]) extends AnyVal {

  /** Combines this date-time with a time-zone to create a ZonedDateTime. **/
  def %%(zone: ZoneId): ChronoZonedDateTime[A] = underlying.atZone(zone)

  /** Alias for [[%%]].Combines this date-time with a time-zone to create a ZonedDateTime. **/
  def ±(zone: ZoneId): ChronoZonedDateTime[A] = %%(zone)

  /** Formats this date using the specified formatter.
    *
    * @throws DateTimeException - if an error occurs during formatting.
    */
  def |>(formatter: DateTimeFormatter): String = underlying.format(formatter)

  /** Formats this date using the specified formatter.
    *
    * @throws DateTimeException - if an error occurs during formatting.
    */
  def ▹(formatter: DateTimeFormatter): String = underlying.format(formatter)

}

trait ToChronoLocalDateTimeOps {
  implicit final def toChronoLocalDatetimeOpsFromChronoLocalDateTime[A <: ChronoLocalDate](f: ChronoLocalDateTime[A]):
  ChronoLocalDateTimeOps[A] = new ChronoLocalDateTimeOps(f)
}


/** Enriches a [[ChronoZonedDateTime]] with additional methods. */
final case class ChronoZonedDateTimeOps[A <: ChronoLocalDate](underlying: ChronoZonedDateTime[A]) extends AnyVal {

  /** Formats this date using the specified formatter.
    *
    * @throws DateTimeException - if an error occurs during formatting.
    */
  def |>(formatter: DateTimeFormatter): String = underlying.format(formatter)

  /** Formats this date using the specified formatter.
    *
    * @throws DateTimeException - if an error occurs during formatting.
    */
  def ▹(formatter: DateTimeFormatter): String = underlying.format(formatter)

}

trait ToChronoZonedDateTimeOps {
  implicit final def toChronoZonedDatetimeOpsFromChronoLocalDateTime[A <: ChronoLocalDate](f: ChronoZonedDateTime[A]):
  ChronoZonedDateTimeOps[A] = new ChronoZonedDateTimeOps(f)
}
