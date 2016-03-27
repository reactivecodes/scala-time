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

import java.time.Period

import scala.language.implicitConversions

/** Enriches a [[scala.Long]] with methods for obtaining [[Period]] instances. */
final case class IntOps(underlying: Int) extends AnyVal {

  /** Obtains a [[Period]] representing a number of days. */
  def day: Period = days

  /** Obtains a [[Period]] representing a number of days. */
  def days: Period = Period.ofDays(underlying) // TODO? Better way to overload day/days when used on literals.
                                             // ie. both Period and Duration can be constructed from Int literals

  /** Obtains a [[Period]] representing a number of weeks. */
  def week: Period = weeks

  /** Obtains a [[Period]] representing a number of weeks. */
  def weeks: Period = Period.ofWeeks(underlying)

  /** Obtains a [[Period]] representing a number of months. */
  def month: Period = months

  /** Obtains a [[Period]] representing a number of months. */
  def months: Period = Period.ofMonths(underlying)

  /** Obtains a [[Period]] representing a number of years. */
  def year: Period = years

  /** Obtains a [[Period]] representing a number of years. */
  def years: Period = Period.ofYears(underlying)

}

trait ToIntOps extends Any {
  implicit final def toIntOpsFromLong(v: Int): IntOps = new IntOps(v)
}
