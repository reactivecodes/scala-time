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


import java.time.format.{DateTimeFormatter, DateTimeParseException}
import java.time.temporal.{TemporalAccessor, TemporalQuery}

import scala.language.implicitConversions


final case class StringOps(underlying: String) extends AnyVal {

  def |>(formatter: DateTimeFormatter): TemporalAccessor = formatter.parse(underlying)

  def |>[A](formatter: DateTimeFormatter, query: TemporalQuery[A]): A = formatter.parse(underlying, query)


  /** Fully parses the text producing a temporal object.
    *
   * @throws  DateTimeParseException if unable to parse the requested result.
   */
  def ▹(formatter: DateTimeFormatter): TemporalAccessor = formatter.parse(underlying)

  def ▹[A](formatter: DateTimeFormatter, query: TemporalQuery[A]): A = formatter.parse(underlying, query)



}

trait ToStringOps {
  implicit final def toStringOpsFromString(f: String): StringOps = new StringOps(f)
}
