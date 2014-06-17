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
package dsl

import format.TimeFormatters
import temporal.{ChronoUnits, ChronoFields, IsoUnits, IsoFields}


protected[dsl] trait UnitHelpers {

  /** Provides a standard set of date period fields as [[TemporalField]] instances, including those
    * specific to the ISO-8601 calendar system.
    */
  val field = new ChronoFields with IsoFields {}

  /** Provides a standard set of date period units as [[TemporalField]] instances, including those
    * specific to the ISO-8601 calendar system.
    */
  val unit = new ChronoUnits with IsoUnits {}

}

protected[dsl] trait FormatterHelpers {

  /** Provides a standard set of [[DateTimeFormatter]] instances, as well as methods to create them **/
  val formatter = new TimeFormatters {}

}

protected[dsl] trait ZoneHelpers {

  /** Provides a standard set of time zone [[ZoneID]] instances, as well as methods to create them. **/
  val zone = new ZoneIDs {}

  /** Provides a standard set of time zone [[ZoneOffset]] instances, as well as methods to create them. **/
  val offset = new ZoneOffsets {}
}
