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

import impl.TimeSupport

import util.Try


/** Factory for obtaining instances of [[Year]]. */
object Year {

  /** Obtains the current [[Year]] at UTC. */
  def apply(): Year = TimeSupport.Year.now(ZoneId.UTC)

  /** Obtains a [[Year]] by querying the specified clock for the current year. */
  def apply(clock: Clock): Year = TimeSupport.Year.now(clock)

  /** Obtains the current [[Year]] at the specified zone. */
  def apply(zone: ZoneId): Year = TimeSupport.Year.now(zone)

  /** Tries to query a [[Temporal]] to obtain a [[Year]]. */
  def from(temporal: TemporalAccessor): Try[Year] = Try(TimeSupport.Year.from(temporal))

  /** Tries to obtain a [[Year]] from the specified proleptic year. */
  def of(year: Int): Try[Year] = Try(TimeSupport.Year.of(year))

  /** Tries to obtain a [[Year]] from text such as `2014`. */
  def parse(text: String): Try[Year] = Try(TimeSupport.Year.parse(text))

  /** Tries to obtain a [[Year]] text formatted according to the provided `formatter`. */
  def parse(text: String, formatter: DateTimeFormatter): Try[Year] = Try(TimeSupport.Year.parse(text, formatter))

  /** The maximum supported year, '+999,999,999'. */
  val Max: Year = TimeSupport.Year.of(TimeSupport.Year.max)

  /** The minimum supported year, '-999,999,999'. */
  val Min: Year = TimeSupport.Year.of(TimeSupport.Year.min)

}


/** Enriches [[Year]] instances with additional methods. */
final class RichYear(val underlying: Year) extends AnyVal {

  /** Obtains a year with the specified number of years added. */
  def +(years: Int) = underlying.plusYears(years)

  /** Obtains a year with the specified number of years subtracted. */
  def -(years: Int): Year = underlying.minusYears(years)

  /** Returns `true` if this year is before the specified one. */
  def <(other: Year): Boolean = underlying.isBefore(other)

  /** Returns `true` if this year is equal to or before the specified one. */
  def <=(other: Year): Boolean = underlying.equals(other) || underlying.isBefore(other)

  /** Returns `true` if this year is after the specified one. */
  def >(other: Year): Boolean = underlying.isAfter(other)

  /** Returns `true` if this year is equal to or after the specified one. */
  def >=(other: Year): Boolean = underlying.equals(other) || underlying.isAfter(other)

  /** Obtains a [[YearMonth]] by combining this year with the specified [[Month]]. */
  def /(month: Month): YearMonth = underlying.atMonth(month)

  /** Obtains a [[YearMonth]] by combining this year with the specified month, from 1 (January) to 12 (December).
    * @throws DateTimeException if the month is invalid.
    */
  def /(month: Int): YearMonth = underlying.atMonth(month)

  /** Obtains a [[LocalDate]] by combining this year with the specified [[MonthDay]]. */
  def /(monthDay: MonthDay): LocalDate = underlying.atMonthDay(monthDay)

  /** Formats this year using the specified formatter.
    * @throws DateTimeException - if an error occurs during printing
    */
  def >>(formatter: DateTimeFormatter): String = underlying.format(formatter)

}