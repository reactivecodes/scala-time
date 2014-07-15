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

import scala.util.Try

private[scalatime] abstract class AbstractZoneOffsets {


  /** Queries a [[Temporal]] to obtain its ZoneOffset (if available).
    *
    * @param temporal the temporal object to query
    * @throws DateTimeException - if unable to extract a [[ZoneOffset]]
    * @return the [[ZoneOffset]]
    */
  def from(temporal: TemporalAccessor): Try[ZoneOffset]

  /** Obtains an instance of [[ZoneOffset]] using an offset in hours.
    *
    * @param hours  the time-zone offset in hours, from 0 to ±18
    * @throws DateTimeException - if the offset is not in the required range
    * @return the [[ZoneOffset]]
    */
  def apply(hours: Int): ZoneOffset

  /** Obtains an instance of [[ZoneOffset]] using an offset in hours and minutes.
    *
    * @param hours  the time-zone offset in hours, from 0 to ±18
    * @param minutes the time-zone offset in minutes, from 0 to ±59
    * @throws DateTimeException - if the offset is not in the required range
    * @return the [[ZoneOffset]]
    */
  def apply(hours: Int, minutes: Int): ZoneOffset

  /** Obtains an instance of [[ZoneOffset]] using an offset in hours, minutes and seconds.
    *
    * @param hours  the time-zone offset in hours, from 0 to ±18
    * @param minutes the time-zone offset in minutes, from 0 to ±59
    * @param seconds the time-zone offset in seconds, from 0 to ±59,
    * @throws DateTimeException - if the offset is not in the required range
    * @return the [[ZoneOffset]]
    */
  def apply(hours: Int, minutes: Int, seconds: Int): ZoneOffset

  /** Parses a [[scala.Predef.String]] producing a [[ZoneOffset]]
    * See [[http://docs.oracle.com/javase/8/docs/api/java/time/ZoneOffset.html#of-java.lang.String- Java API.]]
    *
    * @param offsetId the offset ID
    * @throws DateTimeException - if the offset ID is invalid
    * @return the [[ZoneOffset]]
    */
  def apply(offsetId: String): ZoneOffset

  /** The time-zone offset representing EAT (Eastern Africa Time), with an offset of '+03:00'. **/
  def EAT: ZoneOffset

  /** The time-zone offset representing UTC (Coordinated Universal Time), with an offset of '0'. **/
  def UTC: ZoneOffset

  /** The time-zone offset representing the minimum supported offset. **/
  def MIN: ZoneOffset

  /** The time-zone offset representing the maximum supported offset. **/
  def MAX: ZoneOffset

}
