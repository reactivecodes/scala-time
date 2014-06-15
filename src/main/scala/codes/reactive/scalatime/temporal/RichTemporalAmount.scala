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

final class RichTemporalAmount(val underlying: TemporalAmount) extends AnyVal {

  def <+= (temporal: Temporal): Temporal = underlying.addTo(temporal)

  def <-= (temporal: Temporal): Temporal = underlying.subtractFrom(temporal)
}

final class RichDuration(val underlying: Duration) extends AnyVal {

  def * (scalar: Int): Duration = underlying.multipliedBy(scalar)

  def + (duration: Duration): Duration = underlying.plus(duration)

  def + (amount: Long, unit: TemporalUnit): Duration = underlying.plus(amount, unit)

  def - (duration: Duration): Duration = underlying.minus(duration)

  def - (amount: Long, unit: TemporalUnit): Duration = underlying.minus(amount, unit)

}

final class RichPeriod(val underlying: Period) extends AnyVal {

  def * (scalar: Int): Period = underlying.multipliedBy(scalar)

  def + (amount: TemporalAmount): Period = underlying.plus(amount)

  def - (amount: TemporalAmount): Period = underlying.minus(amount)

}
