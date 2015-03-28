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

import impl.TimeSupport.{ZoneId => ZI}


/** Factory object for obtaining instances of [[ZoneId]]. Also provides default instances [[ZoneId.UTC]], and
  * [[ZoneId.EAT]] which correspond to time zone ids representing Coordinated Universal Time, and East African Time
  * respectively.
  *
  * In addition to factory methods, [[ZoneId.entries]] obtains a set of all currently available region based zone ids.
  *
  * @example
  *          {{{
  *            import codes.reactive.scalatime._
  *
  *            // Obtain the UTC zone
  *            val utcZone = ZoneId.UTC
  *
  *            // Obtain the current system zone
  *            val systemZone = ZoneId.system
  *
  *            // Obtain a time zone from the region zone id 'Europe/Lisbon'
  *            val lisbonZone = ZoneId("Europe/Lisbon")
  *          }}}
  */
object ZoneId {

  /** The time-zone ID representing EAT (Eastern Africa Time), with an ID of 'Africa/Nairobi'. */
  val EAT: ZoneId = apply(entries.find(_.contains("Nairobi")).get)

  /** The time-zone ID representing UTC (Coordinated Universal Time), with an ID of 'Z'. */
  val UTC: ZoneId = apply("Z")

  /** Queries a [[Temporal]] instance to obtain its [[ZoneId]]. */
  def from(temporal: TemporalAccessor): ZoneId = ZI.from(temporal)

  /** Obtains a [[ZoneId]] or [[ZoneOffset]] from text. A [[ZoneOffset]] is returned if the text is 'Z', or
    * starts with '+' or '-'. If successful, the result will always be a valid ID for which ZoneRules can be obtained.
    *
    * @throws DateTimeException if the converted zone ID has an invalid format.
    * @throws ZoneRulesException if the converted zone region ID cannot be found.
    */
  def apply(zone: String): ZoneId = ZI.of(zone)

  /** Similar to `apply(zone: String)`, but allows supplementing the existing [[ZoneId]]s with a
    * map of aliases to real zone IDs.
    */
  def apply(zoneId: String, aliasMap: Map[String, String]): ZoneId = ZI.of(zoneId,
    collection.JavaConversions.mapAsJavaMap(aliasMap))

  /** Obtains a [[ZoneId]] wrapping an offset. If the prefix is "GMT", "UTC", or "UT" a ZoneId with the prefix
    * and the non-zero offset is returned. If the prefix is empty "" the ZoneOffset is returned.
    *
    * @throws IllegalArgumentException if the prefix is not one of "GMT", "UTC", or "UT", or "".
    */
  def apply(prefix: String, offset: ZoneOffset): ZoneId = ZI.offset(prefix, offset)

  /** Queries TimeZone.getDefault() to find the current default time-zone and convert it to a ZoneId.
    *
    * @throws DateTimeException if the converted zone ID has an invalid format.
    * @throws ZoneRulesException if the converted zone region ID cannot be found.
    */
  def system: ZoneId = ZI.default

  /** Obtains a set of the text form of all currently available region based zone IDs. */
  def entries: Set[String] = collection.JavaConversions.asScalaSet(ZI.available).toSet

}
