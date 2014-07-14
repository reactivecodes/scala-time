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

import java.time.{Duration => JD}

object Duration extends DurationFactory {

  def apply(amount: TemporalAmount): Duration = JD.from(amount)

  def nanos(nanos: Long): Duration = JD.ofNanos(nanos)

  def millis(millis: Long): Duration = JD.ofMillis(millis)

  def seconds(seconds: Long): Duration = JD.ofSeconds(seconds)

  def minutes(minutes: Long): Duration = JD.ofMinutes(minutes)

  def hours(hours: Long): Duration = JD.ofHours(hours)

  def days(days: Long): Duration = JD.ofDays(days)

  val Nil: Duration = JD.ZERO
}
