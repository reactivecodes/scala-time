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

import impl.TimeSupport.{ZoneID => ZI}

import util.Try


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
object ZoneID {

  /** The time-zone ID representing EAT (Eastern Africa Time), with an ID of 'Africa/Nairobi'. */
  val EAT: ZoneID = apply(entries.find(_.contains("Nairobi")).get).get

  /** The time-zone ID representing UTC (Coordinated Universal Time), with an ID of 'Z'. */
  val UTC: ZoneID = apply("Z").get

  /** Tries to query a [[Temporal]] instance to obtain its [[ZoneID]]. */
  def from(temporal: TemporalAccessor): Try[ZoneID] = Try(ZI.from(temporal))

  /** Tries to obtains a [[ZoneID]] or [[ZoneOffset]] from text. A [[ZoneOffset]] is returned if the text is 'Z', or
    * starts with '+' or '-'. If successful, the result will always be a valid ID for which ZoneRules can be obtained.
    *
    * @note will return `Failure[DateTimeException]` if the converted zone ID has an invalid format.
    * @note will return `Failure[ZoneRulesException]` if the converted zone region ID cannot be found.
    * @param zone  the time-zone ID
    */
  def apply(zone: String): Try[ZoneID] = Try(ZI.of(zone))

  /** Similar to `apply(zone: String)`, but allows supplementing the existing [[ZoneID]]s with a
    * [[scala.collection.immutable.Map Map]] of aliases to real zone IDs.
    */
  def apply(zoneID: String, aliasMap: Map[String, String]): Try[ZoneID] = Try(ZI.of(zoneID,
    collection.JavaConversions.mapAsJavaMap(aliasMap)))

  /** Tries to obtain a [[ZoneID]] wrapping an offset. If the prefix is "GMT", "UTC", or "UT" a ZoneId with the prefix
    * and the non-zero offset is returned. If the prefix is empty "" the ZoneOffset is returned.
    */
  def apply(prefix: String, offset: ZoneOffset): Try[ZoneID] = Try(ZI.offset(prefix, offset))

  /** Tries to query TimeZone.getDefault() to find the current default time-zone and convert it to a ZoneId.
    *
    * @note will return `Failure[DateTimeException]` if the converted zone ID has an invalid format.
    * @note will return `Failure[ZoneRulesException]` if the converted zone region ID cannot be found.
    */
  def system: Try[ZoneID] = Try(ZI.default)

  /** Obtains a [[scala.collection.immutable.Set]] of the text form of all currently available region based zone IDs. */
  def entries: Set[String] = collection.JavaConversions.asScalaSet(ZI.available).toSet

}


