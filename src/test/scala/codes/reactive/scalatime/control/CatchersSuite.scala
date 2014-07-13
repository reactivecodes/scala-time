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
package control

import org.scalatest.{Matchers, FunSuite}

import scala.util.{Success, Try}


class CatchersSuite extends FunSuite with Matchers {

  test("Catcher provides 'Catcher' instances for 'DateTimeException' instances") {
    val t = Try(LocalDate.parse(")(&#)(@*@&#%@#%@#%)")).recover(Catcher.all(_ => LocalDate.of(2014, 7, 13)))
    val t1 = Try(LocalTime().get(IsoField.DayOfQuarter)).recover(Catcher.unsupportedTemporalType)
    t shouldEqual Success(LocalDate.of(2014, 7, 13))
    t1.isFailure shouldEqual true
    intercept[UnsupportedTemporalTypeException](t1.get)
  }

}
