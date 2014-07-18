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

package codes.reactive.scalatime.syntax

import codes.reactive.scalatime.chrono.RichChronoLocalDate
import codes.reactive.scalatime._
import codes.reactive.scalatime.temporal.RichDuration
import org.scalatest.{Matchers, FreeSpec}


class TimeConvertersSuite extends FreeSpec with Matchers {

  "TimeConverters object provides decorators for converting java.time objects to their 'Rich' counterparts" - {

    import TimeConverters._

    val fixed = Clock.fixed(Instant())

    LocalDate(fixed).enrich shouldBe new RichChronoLocalDate(LocalDate(fixed))

    Duration.seconds(2).enrich shouldBe new RichDuration(Duration.seconds(2))
  }

}
