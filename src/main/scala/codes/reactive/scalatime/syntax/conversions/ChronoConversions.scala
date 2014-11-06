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

import chrono.{RichChronoLocalDate, RichChronoLocalDateTime, RichChronoZonedDateTime}

import language.implicitConversions


private[conversions] trait ChronoConverters {

  protected def richChronoLocalDate(underlying: ChronoLocalDate): RichChronoLocalDate =
    new RichChronoLocalDate(underlying)

  protected def richChronoLocalDateTime[A <: ChronoLocalDate](underlying: ChronoLocalDateTime[A]): RichChronoLocalDateTime[A] =
    new RichChronoLocalDateTime(underlying)

  protected def richChronoZonedDateTime[A <: ChronoLocalDate](underlying: ChronoZonedDateTime[A]): RichChronoZonedDateTime[A] =
    new RichChronoZonedDateTime(underlying)
}


private[syntax] trait AnnotateEnrichChrono extends ChronoConverters with Decorators {

  import scala.language.implicitConversions

  implicit def enrichChronoLocalDateConverter(u: ChronoLocalDate): Enrich[RichChronoLocalDate] =
    new Enrich[RichChronoLocalDate](richChronoLocalDate(u))

  implicit def enrichChronoLocalDateTimeConverter[A <: ChronoLocalDate](u: ChronoLocalDateTime[A]): Enrich[RichChronoLocalDateTime[A]] =
    new Enrich[RichChronoLocalDateTime[A]](richChronoLocalDateTime(u))

  implicit def enrichChronoZonedDateTimeConverter[A <: ChronoLocalDate](u: ChronoZonedDateTime[A]): Enrich[RichChronoZonedDateTime[A]] =
    new Enrich[RichChronoZonedDateTime[A]](richChronoZonedDateTime(u))
}

private[conversions] trait ChronoImplicits extends ChronoConverters {

  /** Implicitly converts a [[ChronoLocalDate]] to a [[RichChronoLocalDate]] */
  implicit def augmentChronoLocalDate(d: ChronoLocalDate): RichChronoLocalDate = richChronoLocalDate(d)

  /** Implicitly converts a [[ChronoLocalDateTime]] to a [[RichChronoLocalDateTime]] */
  implicit def augmentChronoLocalDateTime[A <: ChronoLocalDate](d: ChronoLocalDateTime[A]): RichChronoLocalDateTime[A] =
    richChronoLocalDateTime(d)

  /** Implicitly converts a [[ChronoZonedDateTime]] to a [[RichChronoZonedDateTime]] */
  implicit def augmentChronoZonedDateTime[A <: ChronoLocalDate](d: ChronoZonedDateTime[A]): RichChronoZonedDateTime[A] =
    richChronoZonedDateTime(d)

}
