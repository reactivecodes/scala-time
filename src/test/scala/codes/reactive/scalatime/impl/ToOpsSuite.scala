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

package codes.reactive.scalatime.impl

import java.time._
import java.time.temporal.{ChronoUnit, TemporalAccessor, TemporalQueries, TemporalQuery}

import org.scalatest.{Matchers, Outcome, fixture}


class ToAllOpsSuite extends fixture.FunSuite with Matchers {

  test("implicit conversion to ChronoLocalDateOps from ChronoLocalDate") { f ⇒
    import f._
    val v: ChronoLocalDateOps = LocalDate.MIN
    v.isInstanceOf[ChronoLocalDateOps] shouldBe true
  }

  test("implicit conversion to ChronoLocalDateTimeOps from ChronoLocalDateTime") { f ⇒
    import f._
    val v: ChronoLocalDateTimeOps[_] = LocalDateTime.MIN
    v.isInstanceOf[ChronoLocalDateTimeOps[_]] shouldBe true
  }

  test("implicit conversion to ChronoZonedDateTimeOps from ChronoZonedDateTime") { f ⇒
    import f._
    val v: ChronoZonedDateTimeOps[_] = ZonedDateTime.now()
    v.isInstanceOf[ChronoZonedDateTimeOps[_]] shouldBe true
  }

  test("implicit conversion to IntOps from Int") { f ⇒
    import f._
    val v: IntOps = 1
    v.isInstanceOf[IntOps] shouldBe true
  }

  test("implicit conversion to LongOps from Long") { f ⇒
    import f._
    val v: LongOps = 1L
    v.isInstanceOf[LongOps] shouldBe true
  }

  test("implicit conversion to MonthDayOps from MonthDay") { f ⇒
    import f._
    val v: MonthDayOps = MonthDay.now()
    v.isInstanceOf[MonthDayOps] shouldBe true
  }

  test("implicit conversion to MonthOps from Month") { f ⇒
    import f._
    val v: MonthOps = Month.JANUARY
    v.isInstanceOf[MonthOps] shouldBe true
  }

  test("implicit conversion to StringOps from String") { f ⇒
    import f._
    val v: StringOps = ""
    v.isInstanceOf[StringOps] shouldBe true
  }

  test("implicit conversion to TemporalAccessorOps from TemporalAccessor") { f ⇒
    import f._
    val v: TemporalAccessorOps = LocalDate.MIN
    v.isInstanceOf[TemporalAccessorOps] shouldBe true
  }

  test("implicit conversion to TemporalAdjusterOps from TemporalAdjuster") { f ⇒
    import f._
    val v: TemporalAdjusterOps = MonthDay.now()
    v.isInstanceOf[TemporalAdjusterOps] shouldBe true
  }

  test("implicit conversion to DurationOps from Duration") { f ⇒
    import f._
    val v: DurationOps = Duration.ZERO
    v.isInstanceOf[DurationOps] shouldBe true
  }

  test("implicit conversion to PeriodOps from Period") { f ⇒
    import f._
    val v: PeriodOps = Period.ZERO
    v.isInstanceOf[PeriodOps] shouldBe true
  }

  test("implicit conversion to TemporalAmountOps from TemporalAmount") { f ⇒
    import f._
    val v: TemporalAmountOps = Period.ZERO
    v.isInstanceOf[TemporalAmountOps] shouldBe true
  }

  test("implicit conversion to TemporalOps from Temporal") { f ⇒
    import f._
    val v: TemporalOps = LocalDate.MIN
    v.isInstanceOf[TemporalOps] shouldBe true
  }

  test("implicit conversion to TemporalQuery from a function (TemporalAccessor) => A") { f ⇒
    import f._
    val v: TemporalQuery[_] = (a: TemporalAccessor) ⇒ a
    v.isInstanceOf[TemporalQuery[_]] shouldBe true
  }

  test("implicit conversion to TemporalQueryOps from a function (TemporalAccessor) => A") { f ⇒
    import f._
    val v: TemporalQueryOps[_] = (a: TemporalAccessor) ⇒ a
    v.isInstanceOf[TemporalQueryOps[_]] shouldBe true
  }

  test("implicit conversion to TemporalQueryOps from a TemporalQuery") { f ⇒
    import f._
    val v: TemporalQueryOps[_] = TemporalQueries.chronology()
    v.isInstanceOf[TemporalQueryOps[_]] shouldBe true
  }

  test("implicit conversion to TemporalUnitOps from a TemporalUnit") { f ⇒
    import f._
    val v: TemporalUnitOps = ChronoUnit.FOREVER
    v.isInstanceOf[TemporalUnitOps] shouldBe true
  }

  test("implicit conversion to YearMonthOps from a YearMonth") { f ⇒
    import f._
    val v: YearMonthOps = YearMonth.now()
    v.isInstanceOf[YearMonthOps] shouldBe true
  }

  test("implicit conversion to YearOps from a Year") { f ⇒
    import f._
    val v: YearOps = Year.now()
    v.isInstanceOf[YearOps] shouldBe true
  }

  override type FixtureParam = ToAllOps with ToAllStd

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new ToAllOps with ToAllStd {}))
}
