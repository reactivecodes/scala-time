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

import scala.language.implicitConversions


private[conversions] trait TemporalConverters {

  protected def richTemporal(temporal: Temporal): RichTemporal = new RichTemporal(temporal)

  protected def richTemporalAccessor(temporalAccessor: TemporalAccessor) = new RichTemporalAccessor(temporalAccessor)

  protected def richTemporalAdjuster(temporalAdjuster: TemporalAdjuster) = new RichTemporalAdjuster(temporalAdjuster)

  protected def richTemporalAdjusterFun[A <: Temporal](f: A => A) = TemporalAdjuster(f)

  protected def richTemporalAdjusterFunR[A <: Temporal](f: A => A) =
    new RichTemporalAdjuster(richTemporalAdjusterFun(f))

  protected def richTemporalAmount(temporalAmount: TemporalAmount): RichTemporalAmount =
    new RichTemporalAmount(temporalAmount)

  protected def richDuration(duration: Duration): RichDuration = new RichDuration(duration)

  protected def richPeriod(period: Period): RichPeriod = new RichPeriod(period)

  protected def richTemporalQuery[A](query: TemporalQuery[A]): RichTemporalQuery[A] = new RichTemporalQuery(query)

  protected def richMonth(month: Month): RichMonth = new RichMonth(month)

  protected def richYear(year: Year): RichYear = new RichYear(year)

  protected def richYearMonth(yearMonth: YearMonth): RichYearMonth = new RichYearMonth(yearMonth)

  protected def richMonthDay(monthDay: MonthDay): RichMonthDay = new RichMonthDay(monthDay)
}

/**
 * @define  implV Implicitly converts a
 */
private[conversions] trait TemporalImplicits extends TemporalConverters {

  /** $implV [[temporal.RichTemporal]] from a [[Temporal]]. */
  implicit def augmentTemporal(t: Temporal): RichTemporal = richTemporal(t)

  /** $implV [[temporal.RichTemporalAccessor]] from a [[TemporalAccessor]]. */
  implicit def augmentTemporalAccessor(t: TemporalAccessor): RichTemporalAccessor = richTemporalAccessor(t)

  /** $implV [[temporal.RichTemporalAdjuster]] from a [[TemporalAdjuster]]. */
  implicit def augmentTemporalAdjuster(t: TemporalAdjuster): RichTemporalAdjuster = richTemporalAdjuster(t)

  /** $implV [[TemporalAdjuster]] from a function `(Temporal) => Temporal`. */
  implicit def augmentTemporalAdjusterFun(f: Temporal => Temporal): TemporalAdjuster = richTemporalAdjusterFun(f)

  /** $implV [[RichTemporalAdjuster]] from a function `(Temporal) => Temporal`. */
  implicit def augmentTemporalAdjusterFunR(f: Temporal => Temporal): RichTemporalAdjuster = richTemporalAdjusterFunR(f)

  /** $implV [[temporal.RichTemporalAmount]] from a [[TemporalAmount]]. */
  implicit def augmentTemporalAmount(t: TemporalAmount): RichTemporalAmount = richTemporalAmount(t)

  /** $implV [[temporal.RichDuration]] from a [[Duration]]. */
  implicit def augmentDuration(d: Duration): RichDuration = richDuration(d)

  /** $implV [[temporal.RichPeriod]] from a [[Period]]. */
  implicit def augmentPeriod(p: Period): RichPeriod = richPeriod(p)

  /** $implV [[temporal.RichTemporalQuery]] from a [[TemporalQuery]]. */
  implicit def augmentTemporalQuery[A](t: TemporalQuery[A]): RichTemporalQuery[A] = richTemporalQuery(t)

  /** $implV [[RichMonth]] from a [[Month]]. */
  implicit def augmentMonth(m: Month): RichMonth = richMonth(m)

  /** $implV [[RichYear]] from a [[Year]]. */
  implicit def augmentYear(y: Year): RichYear = richYear(y)

  /** $implV [[RichYearMonth]] from a [[YearMonth]]. */
  implicit def augmentYearMonth(y: YearMonth): RichYearMonth = richYearMonth(y)

  /** $implV [[RichMonthDay]] from a [[MonthDay]]. */
  implicit def augmentMonthDay(m: MonthDay): RichMonthDay = richMonthDay(m)

}

private[scalatime] trait AnnotateEnrichTemporal extends TemporalConverters with Decorators {

  implicit def enrichTemporal(u: Temporal): Enrich[RichTemporal] = new Enrich(richTemporal(u))

  implicit def enrichTemporalAccessor(u: TemporalAccessor): Enrich[RichTemporalAccessor] =
    new Enrich(richTemporalAccessor(u))

  implicit def enrichTemporalAdjuster(u: TemporalAdjuster): Enrich[RichTemporalAdjuster] =
    new Enrich(richTemporalAdjuster(u))

  implicit def enrichTemporalAmount(u: TemporalAmount): Enrich[RichTemporalAmount] =
    new Enrich(richTemporalAmount(u))

  implicit def enrichDuration(u: Duration): Enrich[RichDuration] = new Enrich(richDuration(u))

  implicit def enrichPeriod(u: Period): Enrich[RichPeriod] = new Enrich(richPeriod(u))

  implicit def enrichTemporalQuery[A](u: TemporalQuery[A]): Enrich[RichTemporalQuery[A]] =
    new Enrich(richTemporalQuery[A](u))

  implicit def enrichMonth(m: Month): Enrich[RichMonth] = new Enrich(richMonth(m))

  implicit def enrichYear(y: Year): Enrich[RichYear] = new Enrich(richYear(y))

  implicit def enrichYearMonth(y: YearMonth): Enrich[RichYearMonth] = new Enrich(richYearMonth(y))

  implicit def enrichMonthDay(m: MonthDay): Enrich[RichMonthDay] = new Enrich(richMonthDay(m))

}
