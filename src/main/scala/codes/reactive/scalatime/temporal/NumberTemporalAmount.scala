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
package temporal


final class LongDuration(val underlying: Long) extends AnyVal {

  def nano: Duration = nanos

  def nanos: Duration = Duration.nanos(underlying)

  def milli: Duration = millis

  def millis: Duration = Duration.millis(underlying)

  def second: Duration = seconds

  def seconds: Duration = Duration.seconds(underlying)

  def minute: Duration = minutes

  def minutes: Duration = Duration.minutes(underlying)

  def hour: Duration = hours

  def hours: Duration = Duration.hours(underlying)

  def day: Duration = days

  def days: Duration = Duration.days(underlying)

}


final class IntPeriod(val underlying: Int) extends AnyVal {

  def day: Period = days

  def days: Period = Period.days(underlying) // FIXME: Better way to overload day/days. Take a type argument?

  def week: Period = weeks

  def weeks: Period = Period.weeks(underlying)

  def fortnight: Period = fortnights

  def fortnights: Period = Period.fortnights(underlying)

  def month: Period = months

  def months: Period = Period.months(underlying)

  def year: Period = years

  def years: Period = Period.years(underlying)

}
