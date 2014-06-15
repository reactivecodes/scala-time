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

import codes.reactive.scalatime.IsoFields
import codes.reactive.scalatime.LocalDate
import codes.reactive.scalatime.LocalTime
import org.scalatest.{Matchers, FunSuite}


class CatchersSuite extends FunSuite with Matchers {

  test("Catch provides 'Exception.Catch' instances for 'DateTimeException' instances") {
    val t = Catch.all.withTry(LocalDate.parse(")(&#)(@*@&#%@#%@#%)"))
    val t1 = Catch.unsupportedTemporalType.withTry(LocalTime().get(IsoFields.dayOfQuarter))
    t.isFailure shouldEqual true
    t1.isFailure shouldEqual true
    intercept[DateTimeException](t.get)
    intercept[UnsupportedTemporalTypeException](t1.get)
  }

}
