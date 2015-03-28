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

import impl.TimeSupport

import util.Try


/** Factory for obtaining instances of [[YearMonth]]. */
object YearMonth {

  /** Obtains the current [[YearMonth]] at UTC. */
  def apply(): YearMonth = TimeSupport.YearMonth.now(ZoneId.UTC)

  /** Obtains a [[YearMonth]] by querying the specified clock for the current year and month. */
  def apply(clock: Clock): YearMonth = TimeSupport.YearMonth.now(clock)

  /** Obtains the current [[YearMonth]] at the specified zone. */
  def apply(zone: ZoneId): YearMonth = TimeSupport.YearMonth.now(zone)

  /** Queries a [[Temporal]] to obtain a [[YearMonth]].
    * @throws DateTimeException if unable to convert to a YearMonth.
    */
  def from(temporal: TemporalAccessor): YearMonth = TimeSupport.YearMonth.from(temporal)

  /** Obtains a [[YearMonth]] from the specified proleptic year and month.
    * @throws DateTimeException if the `year` value is invalid.
    */
  def of(year: Int, month: Month): YearMonth = TimeSupport.YearMonth.of(year, month)

  /** Obtains a [[YearMonth]] from the specified proleptic year and month.
    * @throws DateTimeException if the `month` or `year` value is invalid.
    */
  def of(year: Int, month: Int): YearMonth = TimeSupport.YearMonth.of(year, Month(month))

  /** Obtains a [[YearMonth]] from text such as `2014-10`.
    * @throws DateTimeParseException if the text cannot be parsed.
    */
  def parse(text: String): YearMonth = TimeSupport.YearMonth.parse(text)

  /** Obtains a [[YearMonth]] from text formatted according to the provided `formatter`.
    * @throws DateTimeParseException if the text cannot be parsed.
    */
  def parse(text: String, formatter: DateTimeFormatter): YearMonth =
    TimeSupport.YearMonth.parse(text, formatter)

}


