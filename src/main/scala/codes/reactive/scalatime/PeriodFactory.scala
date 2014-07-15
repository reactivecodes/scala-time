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

private[scalatime] abstract class PeriodFactory {

  /** Tries to obtain an instance of [[Period]] from a temporal amount by looping around the set of units
    * from the amount and using the YEARS, MONTHS and DAYS units to create a period.
    */
  def from(amount: TemporalAmount): Try[Period]

  /** Tries to obtain an instance of [[Duration]] from a [[scala.Predef.String String]] based
    * on the ISO-8601 Period format - PnDTnHnMn.nS - PnYnMnD and PnW.
    *
    * ==== String Format ====
    * The string starts with an optional sign, denoted by the ASCII negative or positive symbol.
    * If negative, the whole period is negated.
    *
    * The ASCII letter "P" is next in upper or lower case.
    *
    * There are then four sections, each consisting of a number and a suffix. At least one of
    * the four sections must be present. The sections have suffixes in ASCII of "Y", "M", "W"
    * and "D" for years, months, weeks and days, accepted in upper or lower case.
    *
    * The suffixes must occur in order. The number part of each section must consist of ASCII
    * digits. The number may be prefixed by the ASCII negative or positive symbol. The
    * number must parse to an int.
    *
    * The leading plus/minus sign, and negative values for other units are not part of the
    * ISO-8601 standard.
    *
    * @example
    * {{{
    *               import codes.reactive.scalatime._
    *
    *               // Parses as 1 year, 2 months, 3 days
    *               val peri1 = Period.parse("P1Y2M3D")
    *
    *               // Parses as minus 1 year, 2 months, zero days
    *               val peri2 = Period.parse("P-1Y2M")
    * }}}
    */
  def parse(text: String): Try[Period]

  /** Returns a new [[Period]] instance representing a number of days.
    *
    * @param days  the number of days to represent as a [[Period]]
    * @return a new Duration instance
    */
  def days(days: Int): Period

  /** Returns a new [[Period]] instance representing a number of weeks.
    *
    * @param weeks  the number of weeks to represent as a [[Period]]
    * @return a new Duration instance
    */
  def weeks(weeks: Int): Period

  /** Returns a new [[Period]] instance representing a number of fortnights.
    *
    * @param fortnights  the number of fortnights to represent as a [[Period]]
    * @return a new Duration instance
    */
  def fortnights(fortnights: Int): Period

  /** Returns a new [[Period]] instance representing a number of months.
    *
    * @param months  the number of months to represent as a [[Period]]
    * @return a new Duration instance
    */
  def months(months: Int): Period

  /** Returns a new [[Period]] instance representing a number of years.
    *
    * @param years  the number of years to represent as a [[Period]]
    * @return a new Duration instance
    */
  def years(years: Int): Period

  /** Returns a [[Period]] instance representing a period of zero. **/
  def Nil: Period
}
