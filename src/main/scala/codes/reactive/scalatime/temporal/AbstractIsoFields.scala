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
package temporal


private[temporal] trait AbstractIsoFields {


  /** [[TemporalField]] which represents the day-of-quarter. **/
  val DayOfQuarter: TemporalField

  /** [[TemporalField]] which represents the quarter-of-year. **/
  val QuarterOfYear: TemporalField

  /** [[TemporalField]] which represents the week-based-year. **/
  val WeekBasedYear: TemporalField

  /** [[TemporalField]] which represents the week-of-week-based-year. **/
  val WeekOfWeekBasedYear: TemporalField

}
