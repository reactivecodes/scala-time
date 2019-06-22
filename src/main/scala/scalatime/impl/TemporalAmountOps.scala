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

package scalatime.impl

import java.time.temporal.{Temporal, TemporalAmount, TemporalUnit, UnsupportedTemporalTypeException}
import java.time.{Duration, Period}

import scala.language.implicitConversions

/** Enriches a [[TemporalAmount]] with scala friendly methods. */
final case class TemporalAmountOps(underlying: TemporalAmount) extends AnyVal {

  /** Adds this amount to the specified temporal object **/
  def <<+(temporal: Temporal): Temporal = underlying.addTo(temporal)

  /** Subtracts this amount from the specified temporal object **/
  def <<-(temporal: Temporal): Temporal = underlying.subtractFrom(temporal)
}

trait ToTemporalAmountOps extends Any {
  implicit final def toTemporalAmountOpsFromTemporalAmount(f: TemporalAmount): TemporalAmountOps = TemporalAmountOps(f)
}


/** Enriches a [[Duration! Duration]] with scala friendly methods. */
final case class DurationOps(underlying: Duration) extends AnyVal {

  /** Obtains a copy of this duration multiplied by the scalar.
    *
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def *(scalar: Int): Duration = underlying.multipliedBy(scalar)

  /** Obtains a copy of this duration with the specified duration added.
    *
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def +(duration: Duration): Duration = underlying.plus(duration)

  /** Obtains a copy of this duration with a duration added measured in terms of the specified unit.
    *
    * @throws UnsupportedTemporalTypeException - if the unit is not supported
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def +(amount: Long, unit: TemporalUnit): Duration = underlying.plus(amount, unit)

  /** Obtains a copy of this duration with the specified duration subtracted.
    *
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def -(duration: Duration): Duration = underlying.minus(duration)

  /** Obtains a copy of this duration with a duration subtracted measured in terms of the specified unit.
    *
    * @throws UnsupportedTemporalTypeException - if the unit is not supported
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def -(amount: Long, unit: TemporalUnit): Duration = underlying.minus(amount, unit)

  /** Obtains a copy of this duration divided by the divisor.
    *
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def /(divisor: Int): Duration = underlying.dividedBy(divisor)

  /** Swaps the sign of the total length of this duration. For example, PT1.3S will be returned as PT-1.3S.
    *
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def unary_! : Duration = underlying.negated

  /** Obtains a [[scala.concurrent.duration.Duration]] from the value of this duration in nanoseconds.
    *
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def asConcurrentDuration: concurrent.duration.Duration = concurrent.duration.Duration.fromNanos(underlying.toNanos)
}

trait ToDurationOps extends Any {
  implicit final def toDurationOpsFromDuration(f: Duration): DurationOps = DurationOps(f)
}


/** Enriches a [[Period! Period]] with scala friendly methods. */
final case class PeriodOps(underlying: Period) extends AnyVal {

  /** Obtains a copy of this period multiplied by the scalar.
    *
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def *(scalar: Int): Period = underlying.multipliedBy(scalar)

  /** Obtains a copy of this period with the specified period added.
    *
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def +(amount: TemporalAmount): Period = underlying.plus(amount)

  /** Obtains a copy of this period with the specified period subtracted.
    *
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def -(amount: TemporalAmount): Period = underlying.minus(amount)

  /** Obtains an instance of this type with each amount in this period negated. For example, a period of
    * "2 years, -3 months and 4 days" will be negated to "-2 years, 3 months and -4 days". No normalization is
    * performed.
    *
    * @throws ArithmeticException - if numeric overflow occurs, which only happens if one of the units
    *                             has the value Long.MIN_VALUE
    */
  def unary_! : Period = underlying.negated
}

trait ToPeriodOps extends Any {

  implicit final def toPeriodOpsFromPeriod(f: Period): PeriodOps = PeriodOps(f)
}
