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

import org.scalatest.{Outcome, Matchers, fixture}
import java.time.temporal.ChronoUnit.DAYS



class RichTemporalSuite extends fixture.FreeSpec with Matchers {

  override type FixtureParam = RichTemporal

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new RichTemporal(LocalDate.of(2014, 6, 7))))

  "RichTemporal instances" - {

    "have a '+' method for adding a 'TemporalAmount' to an underlying 'Temporal'" in {
      _ + Period.days(1) should equal (LocalDate.of(2014, 6, 8))
    }

    "have a '+' method for adding an amount of 'TemporalUnit's to an underlying 'Temporal'" in { p =>
      ( p + (1, DAYS)) should equal (LocalDate.of(2014, 6, 8))
    }

    "have a '-' method for subtracting a TemporalAmount from an underlying Temporal" in {
      _ - Period.days(1) should equal (LocalDate.of(2014, 6, 6))
    }

    "have a '-' method for subtracting  an amount of 'TemporalUnit's from  an underlying 'Temporal'" in { p =>
      ( p - (1, DAYS)) should equal (LocalDate.of(2014, 6, 6))
    }

 }

}
