/*******************************************************************
 * See the NOTICE file distributed with this work for additional   *
 * information regarding Copyright ownership.  The author/authors  *
 * license this file to you under the terms of the Apache License, *
 * Version 2.0 (the "License"); you may not use this file except   *
 * in compliance with the License.  You may obtain a copy of the   *
 * License at:                                                     *
 *                                                                 *
 *     http://www.apache.org/licenses/LICENSE-2.0                  *
 *                                                                 *
 * Unless required by applicable law or agreed to in writing,      *
 * software distributed under the License is distributed on an     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY          *
 * KIND, either express or implied.  See the License for the       *
 * specific language governing permissions and limitations         *
 * under the License.                                              *
 *******************************************************************/

package codes.reactive.scalatime


/** Factory object for obtaining instances of [[ZoneID]]. Also provides default instances [[ZoneID.UTC]], and
  * [[ZoneID.EAT]] which correspond to time zone ids representing Coordinated Universal Time, and East African Time
  * respectively.
  *
  * In addition to factory methods, [[ZoneID.entries]] obtains a [[scala.collection.immutable.Set Set]] of all currently
  * available region based zone ids.
  *
  * @example
  *          {{{
  *            import codes.reactive.scalatime._
  *
  *            // Obtain the UTC zone
  *            val utcZone = ZoneID.UTC
  *
  *            // Obtain the current system zone
  *            val systemZone = ZoneID.system
  *
  *            // Obtain a time zone from the region zone id 'Europe/Lisbon'
  *            val lisbonZone = ZoneID("Europe/Lisbon")
  *          }}}
  * @since  0.1.0
  */
object ZoneID extends ZoneIDs


