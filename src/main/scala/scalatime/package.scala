/*******************************************************************
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

/** Provides an API for convenient use of 'java.time' classes.
  *
  * @example
  * {{{
  * import java.time._
  * import scalatime._  // NOTE: Package name was changed from codes.reactive.scalatime => scalatime
  *                     // for versions 0.5.x and newer. If still using 0.4.x, use codes.reactive.scalatime
  *
  * // Obtain a Duration instance from a Long
  * val duration = 10L minutes
  *
  * val otherDuration = 1L minute
  *
  * // Obtain a Period instance from an Int
  * val period = 2 weeks
  *
  * // Obtains a LocalDate instance
  * val localDate = LocalDate.of(2014, 6, 7)
  *
  * // Obtain a default TemporalQuery for precision
  * val query = temporal.TemporalQueries.precision
  *
  * // Obtain a Duration instance from a sum of Durations
  * duration + otherDuration
  *
  * //  Add a TemporalAmount to a Temporal
  * period <<+ localDate
  *
  * //  Add a TemporalAmount to a Temporal
  * localDate + period
  *
  * // Subtract a TemporalAmount from a Temporal
  * localDate - period
  *
  * // Query a specified Temporal
  * val result = query |> localDate
  * }}}
  *
  */
package object scalatime extends impl.ToAllOps with impl.ToAllStd
