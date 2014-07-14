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

/**
 * Created by arashid on 14/07/14.
 */
private[temporal] trait AbstractChronoFields {


  def AlignedDayOfWeekInMonth: ChronoField

  def AlignedDayOfWeekInYear: ChronoField

  def AlignedWeekOfMonth: ChronoField

  def AlignedWeedOfYear: ChronoField

  def AmPmOfDay: ChronoField

  def ClockHourOfAmPm: ChronoField

  def ClockHourOfDay: ChronoField

  def DayOfMonth: ChronoField

  def DayOfWeek: ChronoField

  def DayOfYear: ChronoField

  def EpochDay: ChronoField

  def Era: ChronoField

  def HourOfMonth: ChronoField

  def HourOfDay: ChronoField

  def InstantSeconds: ChronoField

  def MicroOfDay: ChronoField

  def MicroOfSecond: ChronoField

  def MilliOfDay: ChronoField

  def MilliOfSecond: ChronoField

  def MinuteOfDay: ChronoField

  def MinuteOfMonth: ChronoField

  def MonthOfYear: ChronoField

  def MonthOfday: ChronoField

  def NanoOfSecond: ChronoField

  def OffsetSeconds: ChronoField

  def ProlepticMonth: ChronoField

  def SecondOfDay: ChronoField

  def SecondOfMinute: ChronoField

  def Year: ChronoField

  def YearOfEra: ChronoField
}
