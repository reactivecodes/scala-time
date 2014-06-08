/**********************************************************************
 * See the NOTICE file distributed with this work for additional      *
 *   information regarding Copyright ownership.  The author/authors   *
 *   license this file to you under the terms of the Apache License,  *
 *   Version 2.0 (the "License"); you may not use this file except    *
 *   in compliance with the License.  You may obtain a copy of the    *
 *   License at:                                                      *
 *                                                                    *
 *       http://www.apache.org/licenses/LICENSE-2.0                   *
 *                                                                    *
 *   Unless required by applicable law or agreed to in writing,       *
 *   software distributed under the License is distributed on an      *
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY           *
 *   KIND, either express or implied.  See the License for the        *
 *   specific language governing permissions and limitations          *
 *   under the License.                                               *
 **********************************************************************/

package ke.co.sbsproperties.scalatime

import java.time.{Clock => JC}


object Clock {

  /** Returns a new [[Clock]] from the current instance converted to UTC obtained from the best available system clock.
    *
    * @return a new Clock
    */
  def apply(): Clock = JC.systemUTC()

  /** Returns a new [[Clock]] from the current instance converted to the provided time zone
    * obtained from the best available system clock.
    *
    * @return a new Clock
    */
  def apply(zone: ZoneID): Clock = JC.system(zone)

  /** Returns a new [[Clock]] from the current instance obtained from the best available system clock, retaining
    * the system time zone.
    *
    * @return a new Clock
    */
  def systemZone: Clock = JC.systemDefaultZone()

  /** Returns a new [[Clock]] that will always return the provided [[Instant]] converted to the provided [[ZoneID]]
    *
    * @param instant the instant which will always be returned after zone conversion
    * @param zone   the zone for which the instant will be converted
    * @return a new Clock
    */
  def fixed(instant: Instant, zone: ZoneID): Clock = JC.fixed(instant, zone)

  /** Returns a new [[Clock]] that will always return the provided [[Instant]]
    *
    * @param instant the instant which will always be returned
    * @return a new Clock
    */
  def fixed(instant: Instant): Clock = JC.fixed(instant, Zone.offset.UTC)


}
