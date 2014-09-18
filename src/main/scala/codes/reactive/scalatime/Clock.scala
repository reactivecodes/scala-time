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

import impl.TimeSupport.{Clock => JC}


/** Factory object for obtaining instances of [[Clock]].
  *
  * The default no-argument `apply` method differs from the underlying library no-argument constructor in that it
  * explicitly returns the '''UTC''' Zone Clock from the current system time. Use `apply(ZoneId)` to specify an
  * alternative zone, or [[Clock.systemZone]] to obtain a Clock from the current system time and zone.
  *
  * @example
  * {{{
  *              import codes.reactive.scalatime._
  *
  *              // Obtain a Clock from the current system UTC time
  *              val utcClock = Clock()
  *
  *              // Obtain a Clock fixed to the current instant
  *              val fixed = Clock.fixed(Instant())
  * }}}
  *
  */
object Clock {

  /** Obtains a [[Clock]] from the current instant at UTC from the best available system clock. */
  def apply(): Clock = apply(ZoneOffset.UTC)

  /** Obtains a [[Clock]] from the current instant at the specified time zone from the best available system clock. */
  def apply(zone: ZoneId): Clock = JC.system(zone)

  /** Obtains a [[Clock]] from the current instant at the system time zone from the best available system clock. */
  def systemZone: Clock = JC.systemDefaultZone

  /** Obtains a [[Clock]] fixed to a specific instant, at a specific time zone */
  def fixed(instant: Instant, zone: ZoneId): Clock = JC.fixed(instant, zone)

  /** Obtains a [[Clock]] fixed to a specific instant */
  def fixed(instant: Instant): Clock = JC.fixed(instant, ZoneOffset.UTC)
}
