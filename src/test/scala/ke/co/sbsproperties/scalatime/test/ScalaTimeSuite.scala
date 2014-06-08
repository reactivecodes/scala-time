/**********************************************************************
 * See the NOTICE file distributed with this work for additional      *
 *   information regarding Copyright ownership.  The author/authors   *
 *   license this file to you under the terms of the Apache License,  *
 *   Version 2.0 (the "License"); you may not use this file except    *
 *   in compliance with the License.  You may obtain a copy of the    *
 *   License at:                                                      *
 *                                                                    *
 *       http://www.apache.org/licenses/LICENSE-2.0                   *
 *                                                                    *
 *   Unless required by applicable law or agreed to in writing,       *
 *   software distributed under the License is distributed on an      *
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY           *
 *   KIND, either express or implied.  See the License for the        *
 *   specific language governing permissions and limitations          *
 *   under the License.                                               *
 **********************************************************************/

package ke.co.sbsproperties.scalatime.test

import org.scalatest.{Matchers, FeatureSpec}
import org.scalautils.Equality
import ke.co.sbsproperties.scalatime.TemporalAmount

class ScalaTimeSuite extends FeatureSpec with Matchers {

  info("Scala Time allows use with only core implicit conversions in scope")

  feature("'simple' usage via import of 'ke.co.sbsproperties.scalatime._'") {
    import ke.co.sbsproperties.scalatime._

    val period: Period = Period.days(1)

    val otherPeriod = Period.days(2)

    val duration = Duration.days(1)

    duration + duration shouldBe java.time.Duration.ofDays(2)

    period + otherPeriod  shouldBe  java.time.Period.ofDays(3)

    (period <-= LocalDate.of(2014, 6, 7)) shouldBe LocalDate.of(2014, 6, 6)
  }

  feature("'extended' usage with additional implicits import of 'conversions._'") {
    import ke.co.sbsproperties.scalatime._
    import conversions._

    val duration: Duration = 1L day

    val otherDuration: Duration = 2L days

    val period = 1 day
    val otherPeriod = 2 days

    duration + otherDuration shouldBe java.time.Duration.ofDays(3)
    period + otherPeriod shouldBe java.time.Period.ofDays(3)
  }

}
