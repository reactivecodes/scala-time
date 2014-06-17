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

package codes.reactive.scalatime.test.conversions

import codes.reactive.scalatime.conversions.TemporalImplicits
import codes.reactive.scalatime.temporal.{RichDuration, RichPeriod, RichTemporal, RichTemporalAmount}
import codes.reactive.scalatime.{Duration, LocalDate, Period}
import org.scalatest.{FreeSpec, Matchers}


class TemporalConversionsSuite extends FreeSpec with Matchers {

  "A TemporalImplicits instance" - {
    val subject = new TemporalImplicits {}
    import subject._

    "provides an implicit conversion of a 'Temporal' to a 'RichTemporal'" in {
      val v: RichTemporal = LocalDate.of(2014, 6, 7)
      v.isInstanceOf[RichTemporal] should be (right = true)
    }

    "provides an implicit conversion of a 'TemporalAmount' to a 'RichTemporalAmount'" in {
      val v: RichTemporalAmount = Duration.days(1)
      v.isInstanceOf[RichTemporalAmount] should be (right = true)
    }

    "provides an implicit conversion of a 'Duration' to a 'RichDuration'" in {
      val v: RichDuration = Duration.days(1)
      v.isInstanceOf[RichDuration] should be (right = true)
    }

    "provides an implicit conversion of a 'Period' to a 'RichPeriod'" in {
      val v: RichPeriod = Period.days(1)
      v.isInstanceOf[RichPeriod] should be (right = true)
    }
  }

}
