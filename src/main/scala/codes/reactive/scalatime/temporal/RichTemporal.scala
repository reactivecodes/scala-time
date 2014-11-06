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

import language.implicitConversions

/** Enriches a [[Temporal]] with additional methods.
  *
  * @define  sameType  Obtains an object of the same type as this object
  */
final class RichTemporal(val underlying: Temporal) extends AnyVal {

  private type T = underlying.type

  /** $sameType with an amount added.
    *
    * @throws DateTimeException - if the addition cannot be made.
    * @throws ArithmeticException - if numeric overflow occurs.
    */
  def +(amount: TemporalAmount): T = underlying.plus(amount)

  /** $sameType with an amount added.
    *
    * @throws DateTimeException - if the unit cannot be added.
    * @throws UnsupportedTemporalTypeException - if the unit is not supported.
    * @throws ArithmeticException - if numeric overflow occurs.
    */
  def +(amount: Long, unit: TemporalUnit): T = underlying.plus(amount, unit)

  /** $sameType with an amount subtracted.
    *
    * @throws DateTimeException - if the subtraction cannot be made
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def -(amount: TemporalAmount): T = underlying.minus(amount)

  /** $sameType with an amount subtracted.
    *
    * @throws DateTimeException - if the unit cannot be subtracted
    * @throws UnsupportedTemporalTypeException - if the unit is not supported
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def -(amount: Long, unit: TemporalUnit): T = underlying.minus(amount, unit)

  /** Obtains an adjusted object of the same type as this object with the adjustment made.
    *
    * @throws DateTimeException - if unable to make the adjustment
    * @throws  ArithmeticException - if numeric overflow occurs
    */
  def ~=(adjuster: TemporalAdjuster): T = underlying.`with`(adjuster)

  /** Obtains an adjusted object of the same type as this object with the adjustment made.
    *
    * @throws DateTimeException - if the field cannot be set
    * @throws  UnsupportedTemporalTypeException - if the field is not supported
    * @throws  ArithmeticException - if numeric overflow occurs
    */
  def ~=(field: TemporalField, fieldValue: Long): T = underlying.`with`(field, fieldValue)

  /** Calculates the amount of time until this temporal in terms of the specified unit.
    *
    * @throws DateTimeException - if the amount cannot be calculated, or the end temporal cannot be converted
    *                           to the same type as this temporal.
    * @throws  UnsupportedTemporalTypeException - if the unit is not supported.
    * @throws  ArithmeticException - if numeric overflow occurs.
    */
  def from(begin: Temporal, inUnits: TemporalUnit): Long = begin.until(underlying, inUnits)

  private implicit def t(t: Temporal): T = t.asInstanceOf[T]

}
