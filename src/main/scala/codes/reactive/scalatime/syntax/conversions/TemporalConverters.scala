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
package syntax.conversions

import temporal._


private[conversions] trait TemporalConverters {

  /** Obtains a [[temporal.RichTemporal]] from a [[Temporal]] **/
  protected def richTemporal(temporal: Temporal): RichTemporal = new RichTemporal(temporal)

  /** Obtains a [[temporal.RichTemporalAdjuster]] from a [[TemporalAdjuster]] **/
  protected def richTemporalAdjuster(temporalAdjuster: TemporalAdjuster) = new RichTemporalAdjuster(temporalAdjuster)

  /** Obtains a [[temporal.RichTemporalAmount]] from a [[TemporalAmount]] **/
  protected def richTemporalAmount(temporalAmount: TemporalAmount): RichTemporalAmount = new RichTemporalAmount(temporalAmount)

  /** Obtains a [[temporal.RichDuration]] from a [[Duration]] **/
  protected def richDuration(duration: Duration): RichDuration = new RichDuration(duration)

  /** Obtains a [[temporal.RichPeriod]] from a [[Period]] **/
  protected def richPeriod(period: Period): RichPeriod = new RichPeriod(period)

  /** Obtains a [[temporal.RichTemporalQuery]] from a [[TemporalQuery]] **/
  protected def richTemporalQuery(query: TemporalQuery[_]): RichTemporalQuery[_] = new RichTemporalQuery(query)

}

/**
 * @define  implV Implicit function for obtaining a
 */
private[conversions] trait TemporalImplicits extends TemporalConverters {

  /** $implV [[temporal.RichTemporal]] from a [[Temporal]]. */
  implicit val augmentTemporal: Temporal => RichTemporal = richTemporal

  /** $implV [[temporal.RichTemporalAdjuster]] from a [[TemporalAdjuster]]. */
  implicit val augmentTemporalAdjuster: TemporalAdjuster => RichTemporalAdjuster = richTemporalAdjuster

  /** $implV [[temporal.RichTemporalAmount]] from a [[TemporalAmount]]. */
  implicit val augmentTemporalAmount: TemporalAmount => RichTemporalAmount = richTemporalAmount

  /** $implV [[temporal.RichDuration]] from a [[Duration]]. */
  implicit val augmentDuration: Duration => RichDuration = richDuration

  /** $implV [[temporal.RichPeriod]] from a [[Period]]. */
  implicit val augmentPeriod: Period => RichPeriod = richPeriod

  /** $implV [[temporal.RichTemporalQuery]] from a [[TemporalQuery]]. */
  implicit val augmentTemporalQuery: (TemporalQuery[_]) => RichTemporalQuery[_] = richTemporalQuery

}

private[scalatime] trait AnnotateEnrichTemporal extends TemporalConverters with Decorators {

  import scala.language.implicitConversions

  implicit def enrichTemporalConverter(u: Temporal): Enrich[RichTemporal] = new Enrich(richTemporal(u))

  implicit def enrichTemporalAdjusterConverter(u: TemporalAdjuster): Enrich[RichTemporalAdjuster] =
    new Enrich(richTemporalAdjuster(u))

  implicit def enrichTemporalAmountConverter(u: TemporalAmount): Enrich[RichTemporalAmount] =
    new Enrich(richTemporalAmount(u))

  implicit def enrichDuration(u: Duration): Enrich[RichDuration] = new Enrich(richDuration(u))

  implicit def enrichPeriod(u: Period): Enrich[RichPeriod] = new Enrich(richPeriod(u))

}

