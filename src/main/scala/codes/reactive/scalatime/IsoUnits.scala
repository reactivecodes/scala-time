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

import java.time.temporal.{IsoFields => IF}


@deprecated object IsoUnits extends IsoUnits

trait IsoUnits {

  /** [[TemporalUnit]] which represents the concept of a quarter-year. For the ISO calendar system, it is equal to 3 months.
    * The estimated duration of a quarter-year is one quarter of 365.2425 Days.
    */
  val quarterYears: TemporalUnit = IF.QUARTER_YEARS

  /** [[TemporalUnit]] which represents week-based-years for the purpose of addition and subtraction. The estimated duration of
    * a week-based-year is the same as that of a standard ISO year at 365.2425 Days.
    *
    * The rules for addition add the number of week-based-years to the existing value for the week-based-year field. If 
    * the resulting week-based-year only has 52 weeks, then the date will be in week 1 of the following week-based-year.
    */
  val weekBasedYears: TemporalUnit = IF.WEEK_BASED_YEARS
}


@deprecated object IsoFields extends IsoFields

trait IsoFields {

  /** [[TemporalField]] which represents the day-of-quarter. **/
  val dayOfQuarter = IF.DAY_OF_QUARTER

  /** [[TemporalField]] which represents the quarter-of-year. **/
  val quarterOfYear = IF.QUARTER_OF_YEAR

  /** [[TemporalField]] which represents the week-based-year. **/
  val weekBasedYear = IF.WEEK_BASED_YEAR

  /** [[TemporalField]] which represents the week-of-week-based-year. **/
  val weekOfWeekBasedYear = IF.WEEK_OF_WEEK_BASED_YEAR

}
