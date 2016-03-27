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

import java.time.temporal.Temporal
import java.time.{DateTimeException, Month, MonthDay}

import scala.language.implicitConversions

/** Enriches a [[Month]] with additional methods. */
final case class MonthOps(underlying: Month) extends AnyVal {

  /** Obtains the month-of-year which is the specified number of months after this one. */
  def +(months: Int): Month = underlying.plus(months)

  /** Obtains the month-of-year which is the specified number of months before this one. */
  def -(months: Int): Month = underlying.minus(months)

  /** Obtains a [[java.time.MonthDay]] by combining this month with the specified day-of-month.
    *
    * @throws DateTimeException if the day-of-month is invalid for the month.
    */
  def /(day: Int): MonthDay = MonthDay.of(underlying, day)

  def =~(temporal: Temporal): Temporal = underlying.adjustInto(temporal)

}

trait ToMonthOps extends Any {
  implicit final def toMonthOpsFromMonth(f: Month): MonthOps = new MonthOps(f)
}
