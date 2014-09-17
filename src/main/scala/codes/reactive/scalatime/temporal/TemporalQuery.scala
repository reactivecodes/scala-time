/********************************************************************
 * See the NOTICE file distributed with this work for additional    *
 * information regarding Copyright ownership.  The author/authors   *
 * license this file to you under the terms of the Apache License,  *
 * Version 2.0 (the "License"); you may not use this file except    *
 * in compliance with the License.  You may obtain a copy of the    *
 * License at:                                                      *
 *                                                                  *
 *     http://www.apache.org/licenses/LICENSE-2.0                   *
 *                                                                  *
 * Unless required by applicable law or agreed to in writing,       *
 * software distributed under the License is distributed on an      *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY           *
 * KIND, either express or implied.  See the License for the        *
 * specific language governing permissions and limitations          *
 * under the License.                                               *
 ********************************************************************/

package codes.reactive.scalatime
package temporal

import util.Try


/** Factory object for obtaining instances of [[TemporalQuery]]. */
object TemporalQuery {

  /** Obtains a [[TemporalQuery]] from a function ([[TemporalAccessor]])  => `A`. */
  def apply[A](f: TemporalAccessor => A) : TemporalQuery[A] = new TemporalQuery[A] {
    override def queryFrom(temporal: TemporalAccessor): A = f(temporal)
  }

}

/** Enriches instances of [[TemporalQuery]] with additional methods. */
class RichTemporalQuery[A](val underlying: TemporalQuery[A]) extends AnyVal {

  /** Tries to query the specified [[TemporalAccessor]] using this query strategy. */
  def <<?(temporal: TemporalAccessor): Try[A] = Try(temporal.query(underlying))

  /** Queries the specified [[TemporalAccessor]] using this query strategy.
    *
    * @throws DateTimeException if unable to query.
    * @throws ArithmeticException if numeric overflow occurs.
    */
  def <<(temporal: TemporalAccessor): A = temporal.query(underlying)

}