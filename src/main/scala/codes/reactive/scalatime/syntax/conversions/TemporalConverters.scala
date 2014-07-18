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
package syntax.conversions

import temporal._


private[conversions] trait TemporalConverters {

  /** Returns a new [[temporal.RichTemporal]] from a [[Temporal]] **/
  protected def richTemporal(temporal: Temporal): RichTemporal = new RichTemporal(temporal)

  /** Returns a new [[temporal.RichTemporalAdjuster]] from a [[TemporalAdjuster]] **/
  protected def richTemporalAdjuster(temporalAdjuster: TemporalAdjuster) = new RichTemporalAdjuster(temporalAdjuster)

  /** Returns a new [[temporal.RichTemporalAmount]] from a [[TemporalAmount]] **/
  protected def richTemporalAmount(temporalAmount: TemporalAmount): RichTemporalAmount = new RichTemporalAmount(temporalAmount)

  /** Returns a new [[temporal.RichDuration]] from a [[Duration]] **/
  protected def richDuration(duration: Duration): RichDuration = new RichDuration(duration)

  /** Returns a new [[temporal.RichPeriod]] from a [[Period]] **/
  protected def richPeriod(period: Period): RichPeriod = new RichPeriod(period)

}


private[conversions] trait TemporalImplicits extends TemporalConverters {

  /** Implicit function which returns a new [[temporal.RichTemporal]] from a [[Temporal]].
    * We make it a val to avoid having to explicitly enable implicit conversions
    */
  implicit val augmentTemporal: Temporal => RichTemporal = richTemporal

  /** Implicit function which returns a new [[temporal.RichTemporalAdjuster]] from a [[TemporalAdjuster]].
    * We make it a val to avoid having to explicitly enable implicit conversions
    */
  implicit val augmentTemporalAdjuster: TemporalAdjuster => RichTemporalAdjuster = richTemporalAdjuster

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

private[scalatime] trait AnnotateEnrichTemporal extends TemporalConverters with Decorators {

  import scala.language.implicitConversions

  implicit def enrichTemporalConverter(u: Temporal): Enrich[RichTemporal] = new Enrich[RichTemporal](richTemporal(u))

  implicit def enrichTemporalAdjusterConverter(u: TemporalAdjuster): Enrich[RichTemporalAdjuster] =
    new Enrich[RichTemporalAdjuster](richTemporalAdjuster(u))

  implicit def enrichTemporalAmountConverter(u: TemporalAmount): Enrich[RichTemporalAmount] =
    new Enrich[RichTemporalAmount](richTemporalAmount(u))

  implicit def enrichDuration(u: Duration): Enrich[RichDuration] = new Enrich[RichDuration](richDuration(u))

  implicit def enrichPeriod(u: Period): Enrich[RichPeriod] = new Enrich[RichPeriod](richPeriod(u))

}

