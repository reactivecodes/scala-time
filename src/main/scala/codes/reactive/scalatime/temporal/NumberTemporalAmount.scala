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

/** Enriches a [[scala.Int]] with methods for obtaining [[Duration]] instances. */
final class LongDuration(val underlying: Long) extends AnyVal {

  /** Obtains a [[Duration]] representing a number of nanoseconds. */
  def nano: Duration = nanos

  /** Obtains a [[Duration]] representing a number of nanoseconds. */
  def nanos: Duration = Duration.nanos(underlying)

  /** Obtains a [[Duration]] representing a number of milliseconds. */
  def milli: Duration = millis

  /** Obtains a [[Duration]] representing a number of milliseconds. */
  def millis: Duration = Duration.millis(underlying)

  /** Obtains a [[Duration]] representing a number of seconds. */
  def second: Duration = seconds

  /** Obtains a [[Duration]] representing a number of seconds. */
  def seconds: Duration = Duration.seconds(underlying)

  /** Obtains a [[Duration]] representing a number of minutes. */
  def minute: Duration = minutes

  /** Obtains a [[Duration]] representing a number of minutes. */
  def minutes: Duration = Duration.minutes(underlying)

  /** Obtains a [[Duration]] representing a number of hours. */
  def hour: Duration = hours

  /** Obtains a [[Duration]] representing a number of hours. */
  def hours: Duration = Duration.hours(underlying)

  /** Obtains a [[Duration]] representing a number of days. */
  def day: Duration = days

  /** Obtains a [[Duration]] representing a number of days. */
  def days: Duration = Duration.days(underlying)

}


/** Enriches a [[scala.Long]] with methods for obtaining [[Period]] instances. */
final class IntPeriod(val underlying: Int) extends AnyVal {

  /** Obtains a [[Period]] representing a number of days. */
  def day: Period = days

  /** Obtains a [[Period]] representing a number of days. */
  def days: Period = Period.days(underlying) // TODO: Better way to overload day/days when used on literals?

  /** Obtains a [[Period]] representing a number of weeks. */
  def week: Period = weeks

  /** Obtains a [[Period]] representing a number of weeks. */
  def weeks: Period = Period.weeks(underlying)

  /** Obtains a [[Period]] representing a number of fortnights. */
  def fortnight: Period = fortnights

  /** Obtains a [[Period]] representing a number of fortnights. */
  def fortnights: Period = Period.fortnights(underlying)

  /** Obtains a [[Period]] representing a number of months. */
  def month: Period = months

  /** Obtains a [[Period]] representing a number of months. */
  def months: Period = Period.months(underlying)

  /** Obtains a [[Period]] representing a number of years. */
  def year: Period = years

  /** Obtains a [[Period]] representing a number of years. */
  def years: Period = Period.years(underlying)

}
