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

package ke.co.sbsproperties.scalatime

import java.time.{ZoneId => ZI, ZoneOffset => ZO}
import ke.co.sbsproperties.scalatime
import scala.collection.mutable

/** Provides the mechanisms for easily creating or obtaining [[ZoneID]] and [[ZoneOffset]] instances **/
trait TimeZones {

  /** Provides methods for creating, or values of [[ZoneID]] instances **/
  val zone = new Zone {}

  /** Provides methods for creating, or values of [[ZoneOffset]] instances **/
  val offset = new Offset {}

  protected trait Zone {

    /** The time-zone ID representing EAT (Eastern Africa Time), with an ID of 'Africa/Nairobi'. **/
    val EAT: scalatime.ZoneID = apply(entries.find(_.contains("Nairobi")).get)

    /** The time-zone ID representing UTC (Coordinated Universal Time), with an ID of 'Z'. **/
    val UTC: scalatime.ZoneID = apply("Z")

    /** Queries a [[TemporalAccessor]] to obtain its [[ZoneID]] (if available).
      *
      * @param temporal the temporal object to query
      * @throws DateTimeException - if unable to extract a ZoneID
      * @return the [[ZoneID]]
      */
    def apply(temporal: TemporalAccessor): scalatime.ZoneID = ZI.from(temporal)

    /** Parses a [[scala.Predef.String]] producing a [[ZoneID]] or [[ZoneOffset]]. A [[ZoneOffset]] is returned
      * if the String is 'Z', or starts with '+' or '-'. The result will always be a valid ID for which ZoneRules
      * can be obtained.
      *
      * @param zoneID  the time-zone ID
      * @throws DateTimeException if the converted zone ID has an invalid format
      * @throws ZoneRulesException if the converted zone region ID cannot be found
      * @return the [[ZoneID]]
      */
    def apply(zoneID: String): scalatime.ZoneID = ZI.of(zoneID)

    /** Similar to `apply(zoneID: String)`, but allows supplementing the existing [[ZoneID]]s with a [[scala.Predef.Map]] of
      * aliases.
      *
      * @param zoneID the time-zone ID
      * @param aliasMap a map of alias zone IDs (typically abbreviations) to real zone ID
      * @throws DateTimeException if the converted zone ID has an invalid format
      * @throws ZoneRulesException if the converted zone region ID cannot be found
      * @return the [[ZoneID]]
      */
    def apply(zoneID: String, aliasMap: Map[String, String]): scalatime.ZoneID = ZI.of(zoneID,
      collection.JavaConversions.mapAsJavaMap(aliasMap))

    /** Obtains an instance of [[ZoneID]] wrapping an offset.
      * If the prefix is "GMT", "UTC", or "UT" a ZoneId with the prefix and the non-zero offset is returned.
      * If the prefix is empty "" the ZoneOffset is returned.
      *
      * @param prefix the time-zone ID
      * @param offset the offset
      * @throws DateTimeException if the prefix is not one of "GMT", "UTC", or "UT", or ""
      * @return
      */
    def apply(prefix: String, offset: scalatime.ZoneOffset): scalatime.ZoneID = ZI.ofOffset(prefix, offset)

    /** Queries TimeZone.getDefault() to find the current default time-zone and converts it to a ZoneId.
      *
      * @throws DateTimeException if the converted zone ID has an invalid format
      * @throws ZoneRulesException if the converted zone region ID cannot be found
      * @return the current system default time [[ZoneID]]
      */
    def system: ZoneID = ZI.systemDefault

    /** Gets a [[scala.Predef.Set]] of the [[scala.Predef.String]] form of all currently available region based
      * zone IDs.
      *
      * @return the set of all currently available zone ID
      */
    def entries: Set[String] = collection.JavaConversions.asScalaSet(ZI.getAvailableZoneIds).toSet

  }


  protected trait Offset {

    /** Queries a [[Temporal]] to obtain its ZoneOffset (if available).
      *
      * @param temporal the temporal object to query
      * @throws DateTimeException - if unable to extract a [[ZoneOffset]]
      * @return the [[ZoneOffset]]
      */
    def apply(temporal: TemporalAccessor): scalatime.ZoneOffset = ZO.from(temporal)

    /** Obtains an instance of [[ZoneOffset]] using an offset in hours.
      *
      * @param hours  the time-zone offset in hours, from 0 to ±18
      * @throws DateTimeException - if the offset is not in the required range
      * @return the [[ZoneOffset]]
      */
    def apply(hours: Int): scalatime.ZoneOffset = ZO.ofHours(hours)

    /** Obtains an instance of [[ZoneOffset]] using an offset in hours and minutes.
      *
      * @param hours  the time-zone offset in hours, from 0 to ±18
      * @param minutes the time-zone offset in minutes, from 0 to ±59
      * @throws DateTimeException - if the offset is not in the required range
      * @return the [[ZoneOffset]]
      */
    def apply(hours: Int, minutes: Int): scalatime.ZoneOffset = ZO.ofHoursMinutes(hours, minutes)

    /** Obtains an instance of [[ZoneOffset]] using an offset in hours, minutes and seconds.
      *
      * @param hours  the time-zone offset in hours, from 0 to ±18
      * @param minutes the time-zone offset in minutes, from 0 to ±59
      * @param seconds the time-zone offset in seconds, from 0 to ±59,
      * @throws DateTimeException - if the offset is not in the required range
      * @return the [[ZoneOffset]]
      */
    def apply(hours: Int, minutes: Int, seconds: Int): scalatime.ZoneOffset = ZO.ofHoursMinutesSeconds(hours, minutes, seconds)

    /** Parses a [[scala.Predef.String]] producing a [[ZoneOffset]]
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/ZoneOffset.html#of-java.lang.String- Java API.]]
      *
      * @param offsetId the offset ID
      * @throws DateTimeException - if the offset ID is invalid
      * @return the [[ZoneOffset]]
      */
    def apply(offsetId: String): scalatime.ZoneOffset = ZO.of(offsetId)

    /** The time-zone offset representing EAT (Eastern Africa Time), with an offset of '+03:00'. **/
    val EAT: scalatime.ZoneOffset = apply(3)

    /** The time-zone offset representing UTC (Coordinated Universal Time), with an offset of '0'. **/
    val UTC: scalatime.ZoneOffset = ZO.UTC

    /** The time-zone offset representing the minimum supported offset. **/
    val MIN: scalatime.ZoneOffset = ZO.MIN

    /** The time-zone offset representing the maximum supported offset. **/
    val MAX: scalatime.ZoneOffset = ZO.MAX

  }

}
