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

/**
 * Created by arashid on 14/07/14.
 */
private[scalatime] abstract class DurationFactory {


  /** Obtains an instance of [[Duration]] from a temporal amount which has an exact duration
    * else throws an exception.
    *
    * @throws DateTimeException - if unable to convert to a [[Duration]]
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def apply(amount: TemporalAmount): Duration

  /** Returns a [[Duration]] instance representing a number of nanoseconds. */
  def nanos(nanos: Long): Duration

  /** Returns a new [[Duration]] instance representing a number of milliseconds. */
  def millis(millis: Long): Duration

  /** Returns a new [[Duration]] instance representing a number of seconds. */
  def seconds(seconds: Long): Duration

  /** Returns a new [[Duration]] instance representing a number of minutes. */
  def minutes(minutes: Long): Duration

  /** Returns a new [[Duration]] instance representing a number of hours. */
  def hours(hours: Long): Duration

  /** Returns a new [[Duration]] instance representing a number of days. */
  def days(days: Long): Duration

  /** Returns a [[Duration]] instance representing a duration of zero. */
  def Nil: Duration

}
