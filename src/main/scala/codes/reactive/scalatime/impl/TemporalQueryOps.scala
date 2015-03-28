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

package codes.reactive.scalatime.impl

import codes.reactive.scalatime._
import temporal.TemporalQuery

import scala.language.implicitConversions

/** Enriches instances of [[TemporalQuery]] with additional methods. */
class TemporalQueryOps[A](val underlying: TemporalQuery[A]) extends AnyVal {

  /** Queries the specified [[TemporalAccessor]] using this query strategy.
    *
    * @throws DateTimeException if unable to query.
    * @throws ArithmeticException if numeric overflow occurs.
    */
  def |>(temporal: TemporalAccessor): A = temporal.query(underlying)

  /** Queries the specified [[TemporalAccessor]] using this query strategy.
    *
    * @throws DateTimeException if unable to query.
    * @throws ArithmeticException if numeric overflow occurs.
    */
  def ▹(temporal: TemporalAccessor): A = temporal.query(underlying)
}

trait ToTemporalQueryOps extends Any {

  implicit final def toTemporalQueryOpsFromTemporalQuery[A](v: TemporalQuery[A]): TemporalQueryOps[A] = new TemporalQueryOps(v)

  implicit final def toTemporalQueryOpsFromFunction1[A](f: (TemporalAccessor) ⇒ A): TemporalQueryOps[A] = new TemporalQueryOps(TemporalQuery(f))
}

trait ToTemporalQuery extends Any {

  implicit final def toTemporalQueryFromFunction1[A](f: (TemporalAccessor) ⇒ A): TemporalQuery[A] = TemporalQuery(f)
}