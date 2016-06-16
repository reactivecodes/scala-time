/** ****************************************************************
  * See the NOTICE file distributed with this work for additional  *
  * information regarding Copyright ownership.  The author/authors *
  * license this file to you under the terms of the Apache License *
  * Version 2.0 (the "License"); you may not use this file except  *
  * in compliance with the License.  You may obtain a copy of the  *
  * License at:                                                    *
  * *
  * http://www.apache.org/licenses/LICENSE-2.0                 *
  * *
  * Unless required by applicable law or agreed to in writing,     *
  * software distributed under the License is distributed on an    *
  * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,   *
  * either express or implied.  See the License for the specific   *
  * language governing permissions and limitations under the       *
  * License.                                                       *
  * *****************************************************************/

package codes.reactive.scalatime
package control

import java.time.DateTimeException
import java.time.format.DateTimeParseException
import java.time.temporal.UnsupportedTemporalTypeException
import java.time.zone.ZoneRulesException

import org.scalatest.{FunSuite, Matchers}

import scala.util.{Failure, Success, Try}


class CatchersSuite extends FunSuite with Matchers {

  case class Exceptions(base: Throwable = new DateTimeException("test"),
                        temporalType: Throwable = new UnsupportedTemporalTypeException("test"),
                        zoneRules: Throwable = new ZoneRulesException("test"),
                        parse: Throwable = new DateTimeParseException("test", "", 0))


  test("Catcher instances do not match unrelated Throwables") {
    val es = Exceptions()
    (Try(throw new RuntimeException).recover(Catcher.all(_ ⇒ true)) orElse Success(false)) shouldBe Success(false)
    (Try(throw new RuntimeException).recover(Catcher.dateTimeParseException(_ ⇒ true)) orElse Success(false)) shouldBe Success(false)
    (Try(throw new RuntimeException).recover(Catcher.unsupportedTemporalType(_ ⇒ true)) orElse Success(false)) shouldBe Success(false)
    (Try(throw new RuntimeException).recover(Catcher.zoneRules(_ ⇒ true)) orElse Success(false)) shouldBe Success(false)
  }

  test("Catcher.all matches all 'DateTimeException' instances") {
    val es = Exceptions()
    Try(throw es.base).recover(Catcher.all(_ ⇒ true)) shouldBe Success(true)
    Try(throw es.zoneRules).recover(Catcher.all(_ ⇒ true)) shouldBe Success(true)
  }

  test("Catcher.dateTimeParseException matches 'DateTimeParseException' instances") {
    val es = Exceptions()
    Try(throw es.parse).recover(Catcher.dateTimeParseException(_ ⇒ true)) shouldBe Success(true)
    Try(throw es.zoneRules).recover(Catcher.dateTimeParseException(_ ⇒ true)) shouldBe Failure(es.zoneRules)
  }

  test("Catcher.unsupportedTemporalType matches 'UnsupportedTemporalTypeException' instances") {
    val es = Exceptions()
    Try(throw es.temporalType).recover(Catcher.unsupportedTemporalType(_ ⇒ true)) shouldBe Success(true)
    Try(throw es.zoneRules).recover(Catcher.unsupportedTemporalType(_ ⇒ true)) shouldBe Failure(es.zoneRules)
  }

  test("Catcher.zoneRules matches 'ZoneRulesException' instances") {
    val es = Exceptions()
    Try(throw es.zoneRules).recover(Catcher.zoneRules(_ ⇒ true)) shouldBe Success(true)
    Try(throw es.temporalType).recover(Catcher.zoneRules(_ ⇒ true)) shouldBe Failure(es.temporalType)
  }

}
