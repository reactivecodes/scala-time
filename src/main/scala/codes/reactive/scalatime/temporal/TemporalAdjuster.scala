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
package temporal

import impl.TimeSupport.{TemporalAdjuster ⇒ TA}


/** Factory object for obtaining instances of [[TemporalAdjuster! TemporalAdjuster]]. */
object TemporalAdjuster {

  /** Obtains a [[TemporalAdjuster]] from a function `([[Temporal]]) => [[Temporal]]`. */
  def apply[A <: Temporal](f: A => A): TemporalAdjuster = new TemporalAdjuster {
    override def adjustInto(temporal: Temporal): Temporal = f(temporal.asInstanceOf[A]).asInstanceOf[Temporal]
  }

  /** Obtains a day-of-week in month adjuster, which returns a new date in the same month with the ordinal day-of-week. */
  def dayOfWeekInMonth(ordinal: Int, dayOfWeek: DayOfWeek): TemporalAdjuster = TA.dayOfWeekInMonth(ordinal, dayOfWeek)

  /** Obtains the "first day of month" adjuster, which returns a new date set to the first day of the current month. */
  def firstDayOfMonth: TemporalAdjuster = TA.firstDayOfMonth

  /** Obtains the "first day of next month" adjuster, which returns a new date set to the first day of the next month. */
  def firstDayOfNextMonth: TemporalAdjuster = TA.firstDayOfNextMonth

  /** Obtains the "first day of next year" adjuster, which returns a new date set to the first day of the next year. */
  def firstDayOfNextYear: TemporalAdjuster = TA.firstDayOfNextYear

  /** Obtains the "first day of year" adjuster, which returns a new date set to the first day of the current year. */
  def firstDayOfYear: TemporalAdjuster = TA.firstDayOfYear

  /** Obtains the "first day of month" adjuster, which returns a new date set to the first day of the current month. */
  def firstInMonth(dayOfWeek: DayOfWeek): TemporalAdjuster = TA.firstInMonth(dayOfWeek)

  /** Obtains the "last day of month" adjuster, which returns a new date set to the last day of the current month. */
  def lastDayOfMonth: TemporalAdjuster = TA.lastDayOfMonth

  /** Obtains the "last day of year" adjuster, which returns a new date set to the last day of the current year. */
  def lastDayOfYear: TemporalAdjuster = TA.lastDayOfYear

  /** Obtains the last in month adjuster, which returns a new date in the same month with the last matching day-of-week. */
  def lastInMonth(dayOfWeek: DayOfWeek): TemporalAdjuster = TA.lastInMonth(dayOfWeek)

  /** Obtains the next day-of-week adjuster, which adjusts the date to the first occurrence of the specified day-of-week
    * after the date being adjusted.
    */
  def next(dayOfWeek: DayOfWeek): TemporalAdjuster = TA.next(dayOfWeek)

  /** Obtains the next-or-same day-of-week adjuster, which adjusts the date to the first occurrence of the specified
    * day-of-week after the date being adjusted unless it is already on that day in which case the same object is
    * returned.
    */
  def nextOrSame(dayOfWeek: DayOfWeek): TemporalAdjuster = TA.nextOrSame(dayOfWeek)

  /** Obtains a previous day-of-week adjuster, which adjusts the date to the first occurrence of the specified
    * day-of-week before the date being adjusted.
    */
  def previous(dayOfWeek: DayOfWeek): TemporalAdjuster = TA.previous(dayOfWeek)

  /** Obtains the previous-or-same day-of-week adjuster, which adjusts the date to the first occurrence of the specified
    * day-of-week before the date being adjusted unless it is already on that day in which case the same object is
    * returned.
    */
  def previousOrSame(dayOfWeek: DayOfWeek): TemporalAdjuster = TA.previousOrSame(dayOfWeek)

}
