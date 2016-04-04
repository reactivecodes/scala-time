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

import java.time.format.DateTimeFormatter
import java.time.{DateTimeException, Month, MonthDay}

import scala.language.implicitConversions

/** Enriches [[MonthDay]] instances with additional methods. */
final case class MonthDayOps(underlying: MonthDay) extends AnyVal {

  /** Returns `true` if this month-day is before the specified one. */
  def <(other: MonthDay): Boolean = underlying.isBefore(other)

  /** Returns `true` if this month-day is equal to or before the specified one. */
  def <=(other: MonthDay): Boolean = underlying.equals(other) || underlying.isBefore(other)

  /** Returns `true` if this month-day is after the specified one. */
  def >(other: MonthDay): Boolean = underlying.isAfter(other)

  /** Returns `true` if this month-day is equal to or after the specified one. */
  def >=(other: MonthDay): Boolean = underlying.equals(other) || underlying.isAfter(other)

  /** Obtains a copy of this MonthDay with the month-of-year altered. */
  def ~=(month: Month): MonthDay = underlying.`with`(month)

  /** Obtains a copy of this MonthDay with the day-of-month altered.
    *
    * @throws DateTimeException if the day-of-month value is invalid.
    * @throws DateTimeException if the day-of-month value is invalid for the month.
    */
  def ~=(day: Int): MonthDay = underlying.withDayOfMonth(day)

  /** Obtains a copy of this MonthDay with the month-of-year and/or day-of-month altered.
    *
    * @throws DateTimeException if the day-of-month value is invalid.
    * @throws DateTimeException if the day-of-month value is invalid for the month.
    */
  def ~=(month: Option[Month], day: Option[Int]): MonthDay = (month, day) match {
    case (Some(m), Some(d)) ⇒ def md1 = underlying.withMonth(m.getValue); md1.withDayOfMonth(d)
    case (Some(m), None) ⇒ underlying.withMonth(m.getValue)
    case (None, Some(d)) ⇒ underlying.withDayOfMonth(d)
    case _ ⇒ underlying
  }

  /** Formats this month-day using the specified formatter.
    *
    * @throws DateTimeException - if an error occurs during printing
    */
  def |>(formatter: DateTimeFormatter): String = underlying.format(formatter)

  /** Formats this month-day using the specified formatter.
    *
    * @throws DateTimeException - if an error occurs during printing
    */
  def ▹(formatter: DateTimeFormatter): String = underlying.format(formatter)
}

trait ToMonthDayOps extends Any {
  implicit final def toMonthDayOpsFromMonthDay(f: MonthDay): MonthDayOps = new MonthDayOps(f)
}
