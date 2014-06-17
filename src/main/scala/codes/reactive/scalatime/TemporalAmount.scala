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

import java.time.{Duration => JD, Period => JP}


object Duration {

  /** Obtains an instance of [[Duration]] from a temporal amount which has an exact duration
    * else throws an exception.
    *
    * @throws DateTimeException - if unable to convert to a [[Duration]]
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def apply(amount: TemporalAmount): Duration = JD.from(amount)

  /** Returns a [[Duration]] instance representing a number of nanoseconds. **/
  def nanos(nanos: Long): Duration = JD.ofNanos(nanos)

  /** Returns a new [[Duration]] instance representing a number of milliseconds. **/
  def millis(millis: Long): Duration = JD.ofMillis(millis)

  /** Returns a new [[Duration]] instance representing a number of seconds. **/
  def seconds(seconds: Long): Duration = JD.ofSeconds(seconds)

  /** Returns a new [[Duration]] instance representing a number of minutes. **/
  def minutes(minutes: Long): Duration = JD.ofMinutes(minutes)

  /** Returns a new [[Duration]] instance representing a number of hours. **/
  def hours(hours: Long): Duration = JD.ofHours(hours)

  /** Returns a new [[Duration]] instance representing a number of days. **/
  def days(days: Long): Duration = JD.ofDays(days)

  /** Returns a [[Duration]] instance representing a duration of zero. **/
  def nil: Duration = JD.ZERO
}

object Period {

  /** Obtains an instance of [[Period]] from a temporal amount by looping around the set of units from the amount
    * and using the YEARS, MONTHS and DAYS units to create a period. If any other units are found then an exception
    * is thrown.
    *
    * @throws DateTimeException - if unable to convert to a [[Period]]
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def apply(amount: TemporalAmount): Period = JP.from(amount)

  /** Returns a new [[Period]] instance representing a number of days.
    *
    * @param days  the number of days to represent as a [[Period]]
    * @return a new Duration instance
    */
  def days(days: Int): Period = JP.ofDays(days)

  /** Returns a new [[Period]] instance representing a number of weeks.
    *
    * @param weeks  the number of weeks to represent as a [[Period]]
    * @return a new Duration instance
    */
  def weeks(weeks: Int): Period = JP.ofWeeks(weeks)

  /** Returns a new [[Period]] instance representing a number of fortnights.
    *
    * @param fortnights  the number of fortnights to represent as a [[Period]]
    * @return a new Duration instance
    */
  def fortnights(fortnights: Int): Period = JP.ofWeeks(fortnights * 2)

  /** Returns a new [[Period]] instance representing a number of months.
    *
    * @param months  the number of months to represent as a [[Period]]
    * @return a new Duration instance
    */
  def months(months: Int): Period = JP.ofMonths(months)

  /** Returns a new [[Period]] instance representing a number of years.
    *
    * @param years  the number of years to represent as a [[Period]]
    * @return a new Duration instance
    */
  def years(years: Int): Period = JP.ofYears(years)

  /** Returns a [[Period]] instance representing a period of zero. **/
  def nil: Period = JP.ZERO
}
