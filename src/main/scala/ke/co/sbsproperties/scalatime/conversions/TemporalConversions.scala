/**********************************************************************
 * See the NOTICE file distributed with this work for additional      *
 *   information regarding Copyright ownership.  The author/authors   *
 *   license this file to you under the terms of the Apache License,  *
 *   Version 2.0 (the "License"); you may not use this file except    *
 *   in compliance with the License.  You may obtain a copy of the    *
 *   License at:                                                      *
 *                                                                    *
 *       http://www.apache.org/licenses/LICENSE-2.0                   *
 *                                                                    *
 *   Unless required by applicable law or agreed to in writing,       *
 *   software distributed under the License is distributed on an      *
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY           *
 *   KIND, either express or implied.  See the License for the        *
 *   specific language governing permissions and limitations          *
 *   under the License.                                               *
 **********************************************************************/

package ke.co.sbsproperties.scalatime
package conversions

import temporal.{RichTemporalAmount, RichTemporal, RichDuration, RichPeriod}


trait TemporalConversions {

  /** Returns a new [[temporal.RichTemporal]] from a [[Temporal]]
    *
    * @param temporal the temporal to convert
    * @return a new [[temporal.RichTemporal]]
    */
  def richTemporal(temporal: Temporal): RichTemporal = new RichTemporal(temporal)

  /** Returns a new [[temporal.RichTemporalAmount]] from a [[TemporalAmount]]
    *
    * @param temporalAmount the [[TemporalAmount]] to convert
    * @return a new [[temporal.RichTemporalAmount]]
    */
  def richTemporalAmount(temporalAmount: TemporalAmount): RichTemporalAmount = new RichTemporalAmount(temporalAmount)

  /** Returns a new [[temporal.RichDuration]] from a [[Duration]]
    *
    * @param duration the [[Duration]] to convert
    * @return a new [[temporal.RichDuration]]
    */
  def richDuration(duration: Duration): RichDuration = new RichDuration(duration)

  /** Returns a new [[temporal.RichPeriod]] from a [[Period]]
    *
    * @param period the [[Period]] to convert
    * @return a new [[temporal.RichPeriod]]
    */
  def richPeriod(period: Period): RichPeriod = new RichPeriod(period)

}


trait TemporalImplicits extends TemporalConversions {

  /** Implicit function which returns a new [[temporal.RichTemporal]] from a [[Temporal]].
    * We make it a val to avoid having to explicitly enable implicit conversions
    */
  implicit val augmentTemporal: Temporal => RichTemporal = richTemporal

  /** Implicit function which returns a new [[temporal.RichTemporalAmount]] from a [[TemporalAmount]].
    * We make it a val to avoid having to explicitly enable implicit conversions
    */
  implicit val augmentTemporalAmount: TemporalAmount => RichTemporalAmount = richTemporalAmount

  /** Implicit function which returns a new [[temporal.RichDuration]] from a [[Duration]].
    * We make it a val to avoid having to explicitly enable implicit conversions
    */
  implicit val augmentDuration: Duration => RichDuration = richDuration

  /** Implicit function which returns a new [[temporal.RichPeriod]] from a [[Period]].
    * We make it a val to avoid having to explicitly enable implicit conversions
    */
  implicit val augmentPeriod: Period => RichPeriod = richPeriod

}
