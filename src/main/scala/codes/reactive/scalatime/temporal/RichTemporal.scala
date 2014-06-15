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

import java.time.temporal.Temporal

/** Enriches a [[Temporal]] with Scala friendly method syntax
  * @since 0.1.0
  */
final class RichTemporal(val underlying: Temporal) extends AnyVal {

  /** Returns an object of the same type as this object with an amount added.
    *
    * @throws DateTimeException - if the addition cannot be made
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def +(amount: TemporalAmount): Temporal = underlying.plus(amount)

  /** Returns an object of the same type as this object with an amount added.
    *
    * @throws DateTimeException - if the unit cannot be added
    * @throws UnsupportedTemporalTypeException - if the unit is not supported
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def +(amount: Long, unit: TemporalUnit): Temporal = underlying.plus(amount, unit)

  /** Returns an object of the same type as this object with an amount subtracted.
    *
    * @throws DateTimeException - if the subtraction cannot be made
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def -(amount: TemporalAmount): Temporal = underlying.minus(amount)

  /** Returns an object of the same type as this object with an amount subtracted.
    *
    * @throws DateTimeException - if the unit cannot be subtracted
    * @throws UnsupportedTemporalTypeException - if the unit is not supported
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def -(amount: Long, unit: TemporalUnit): Temporal = underlying.minus(amount, unit)

  /** Returns an adjusted object of the same type as this object with the adjustment made.
    *
    * @throws DateTimeException - if unable to make the adjustment
    * @throws  ArithmeticException - if numeric overflow occurs
    */
  def ~=(adjuster: TemporalAdjuster): Temporal = underlying.`with`(adjuster)

  /** Returns an adjusted object of the same type as this object with the adjustment made.
    *
    * @throws DateTimeException - if the field cannot be set
    * @throws  UnsupportedTemporalTypeException - if the field is not supported
    * @throws  ArithmeticException - if numeric overflow occurs
    */
  def ~=(field: TemporalField, fieldValue: Long): Temporal = underlying.`with`(field, fieldValue)

  /** Queries this object using the specified [[TemporalQuery]] strategy object.
    *
    * @throws DateTimeException - if unable to query
    * @throws ArithmeticException - if numeric overflow occurs
    */
  def ?[A](query: TemporalQuery[A]): A = underlying.query(query)

  /** Calculates the amount of time until another temporal in terms of the specified unit.
    *
    * @throws DateTimeException - if the amount cannot be calculated, or the end temporal cannot be converted
    *                           to the same type as this temporal
    * @throws  UnsupportedTemporalTypeException - if the unit is not supported
    * @throws  ArithmeticException - if numeric overflow occurs
    */
  def ~>(end: Temporal, inUnits: TemporalUnit) = underlying.until(end, inUnits)

}
