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

package codes.reactive.scalatime.syntax.conversions

import codes.reactive.scalatime
import scalatime.{ChronoLocalDate, ChronoLocalDateTime, ChronoZonedDateTime}
import scalatime.chrono.{RichChronoLocalDateTime, RichChronoLocalDate, RichChronoZonedDateTime}
import org.scalatest.mock.MockitoSugar
import org.scalatest.{FreeSpec, Matchers}


class ChronoConversionsSuite extends FreeSpec with Matchers with MockitoSugar {

  val subject = new ChronoImplicits {}
  import subject._

  "A ChronoImplicits instance" - {
    val t = "provides implicit conversion of a"

    s"$t ChronoLocalDate to a RichChronoLocalDate" in {
      val richChronoLocalDate: RichChronoLocalDate = mock[ChronoLocalDate]
      richChronoLocalDate.isInstanceOf[RichChronoLocalDate] shouldBe true
    }

    s"$t ChronoLocalDateTime to a RichChronoLocalDateTime" in {
      val richChronoLocalDateTime: RichChronoLocalDateTime[_] = mock[ChronoLocalDateTime[_ <: ChronoLocalDate]]
      richChronoLocalDateTime.isInstanceOf[RichChronoLocalDateTime[_]] shouldBe true
    }

    s"$t ChronoZonedDateTime to a RichChronoZonedDateTime" in {
      val richChronoZonedDateTime: RichChronoZonedDateTime[_] = mock[ChronoZonedDateTime[_ <: ChronoLocalDate]]
      richChronoZonedDateTime.isInstanceOf[RichChronoZonedDateTime[_]] shouldBe true
    }
  }

}
