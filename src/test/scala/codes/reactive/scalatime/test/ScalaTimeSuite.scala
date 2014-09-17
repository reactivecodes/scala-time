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

package codes.reactive.scalatime.test

import org.scalatest.{FreeSpec, Matchers}

import util.Try


class ScalaTimeSuite extends FreeSpec with Matchers {

  "code examples provided by documentation are current." - {
    import codes.reactive.scalatime._
    import syntax._
    "readme / rootdoc examples" - {

      "create a Duration from a Long" in {
        def duration = {
          10L minutes
        }
        duration shouldBe DurationTestHelpers.minutes(10L)
      }

      "create a Period from a Long" in {
        def period = {
          10 days
        }
        period shouldBe PeriodTestHelpers.days(10)
      }

      "Try to create a LocalDate" in {
        val localDate = LocalDate.of(2014, 6, 7)
        localDate.foreach { d =>
          d.getYear shouldBe 2014
          d.getMonth shouldBe Month.June
          d.getDayOfMonth shouldBe 7
        }
      }

      "Create a Duration from the sum of Durations" in {
        val duration = {
          10L minutes
        }
        val otherDuration = {
          1L minute
        }

        (duration + otherDuration) shouldBe (11L minutes)
      }

      "Obtain a Temporal from a TemporalAmount added to a Period" in {
        val period = {
          2 weeks
        }
        val localDate = LocalDate.of(2014, 6, 7)

        (period <<+ localDate.get) shouldBe LocalDate.of(2014, 6, 21).get
        (localDate.get + period) shouldBe LocalDate.of(2014, 6, 21).get
      }


      "Obtain a Temporal from a TemporalAmount subtracted from a Period" in {
        val period = {
          2 weeks
        }
        val localDate = LocalDate.of(2014, 6, 7)

        (period <<- localDate.get) shouldBe LocalDate.of(2014, 5, 24).get
        (localDate.get - period) shouldBe LocalDate.of(2014, 5, 24).get
      }
    }

    "control.Catcher api doc" - {
      import codes.reactive.scalatime._
      val catchAllLocalDate = control.Catcher.all(_ => LocalDate.of(2014, 9, 14).get)
      val recovered = Try(LocalDate.parse(")(&#)(@*@&#%@#%@#%)")).recover(catchAllLocalDate)
      recovered.map(_ shouldBe LocalDate.of(2014, 9, 14).get)
    }

  }

  "'simple' usage via import of 'ke.co.sbsproperties.scalatime._'" in {
    import codes.reactive.scalatime._

    val period: Period = Period.days(1)

    val duration = Duration.days(1)

    duration shouldBe DurationTestHelpers.days(1L)

    period shouldBe PeriodTestHelpers.days(1)
  }

  "'extended' usage with additional implicits import of 'conversions._'" in {
    import codes.reactive.scalatime._
    import syntax._

    val duration: Duration = 1L day

    val otherDuration: Duration = 2L days

    val period = 1 day
    val otherPeriod = 2 days

    duration + otherDuration shouldBe DurationTestHelpers.days(3L)
    period + otherPeriod shouldBe PeriodTestHelpers.days(3)
  }

}
import org.threeten.bp.temporal.{ChronoField => CF}
import codes.reactive.scalatime._

/** Provides a standard set of date period fields as [[TemporalField]] instances.
  *
  * @define cf  [[ChronoField]] representing the
  */
trait ChronoFields {

  /** $cf the aligned day-of-week within a month. */
  final val AlignedDayOfWeekInMonth = CF.ALIGNED_DAY_OF_WEEK_IN_MONTH

  /** $cf the aligned day-of-week within a year. */
  final val AlignedDayOfWeekInYear = CF.ALIGNED_DAY_OF_WEEK_IN_YEAR

  /** $cf the aligned week within a month. */
  final val AlignedWeekOfMonth = CF.ALIGNED_WEEK_OF_MONTH

  /** $cf the aligned week within a year. */
  final val AlignedWeekOfYear = CF.ALIGNED_WEEK_OF_YEAR

  /** $cf the am-pm-of-day. */
  final val AmPmOfDay = CF.AMPM_OF_DAY

  /** $cf the clock-hour-of-am-pm. */
  final val ClockHourOfAmPm = CF.CLOCK_HOUR_OF_AMPM

  /** $cf the clock-hour-of-day. */
  final val ClockHourOfDay = CF.CLOCK_HOUR_OF_DAY

  /** $cf the day-of-month. */
  final val DayOfMonth = CF.DAY_OF_MONTH

  /** $cf the day-of-week, such as Tuesday. */
  final val DayOfWeek = CF.DAY_OF_WEEK

  /** $cf the day-of-year. */
  final val DayOfYear = CF.DAY_OF_YEAR

  /** $cf the epoch-day, based on the Java epoch of 1970-01-01 (ISO). */
  final val EpochDay = CF.EPOCH_DAY

  /** $cf the era. */
  final val Era = CF.ERA

  /** $cf the hour-of-am-pm. */
  final val HourOfAmPm = CF.HOUR_OF_AMPM

  /** $cf the hour-of-day. */
  final val HourOfDay = CF.HOUR_OF_DAY

  /** $cf the instant epoch-seconds. */
  final val InstantSeconds = CF.INSTANT_SECONDS

  /** $cf the micro-of-day. */
  final val MicroOfDay = CF.MICRO_OF_DAY

  /** $cf the micro-of-second. */
  final val MicroOfSecond = CF.MICRO_OF_SECOND

  /** $cf the milli-of-day. */
  final val MilliOfDay = CF.MILLI_OF_DAY

  /** $cf the milli-of-second. */
  final val MilliOfSecond = CF.MILLI_OF_SECOND

  /** $cf the minute-of-day. */
  final val MinuteOfDay = CF.MINUTE_OF_DAY

  /** $cf the minute-of-hour. */
  final val MinuteOfHour = CF.MINUTE_OF_HOUR

  /** $cf the month-of-year, such as March. */
  final val MonthOfYear = CF.MONTH_OF_YEAR

  /** $cf the nano-of-day. */
  final val NanoOfDay = CF.NANO_OF_DAY

  /** $cf the nano-of-second. */
  final val NanoOfSecond = CF.NANO_OF_SECOND

  /** $cf the offset from UTC/Greenwich. */
  final val OffsetSeconds = CF.OFFSET_SECONDS

  /** $cf the proleptic-month based, counting months sequentially from year 0. */
  final val ProlepticMonth = CF.PROLEPTIC_MONTH

  /** $cf the second-of-day. */
  final val SecondOfDay = CF.SECOND_OF_DAY

  /** $cf the second-of-minute. */
  final val SecondOfMinute = CF.SECOND_OF_MINUTE

  /** $cf the proleptic year, such as 2012. */
  final val Year = CF.YEAR

  /** $cf the year within the era. */
  final val YearOfEra = CF.YEAR_OF_ERA
}
