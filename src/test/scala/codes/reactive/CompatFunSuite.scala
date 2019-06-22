/*******************************************************************
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

package codes.reactive

import java.time.DateTimeException

import org.scalatest.{FunSuite, Matchers}

import scala.language.postfixOps
import scala.util.{Success, Try}

class CompatFunSuite extends FunSuite with Matchers {

  test("Users of deprecated package should still have functionality using old import") {
    import java.time._
    import codes.reactive.scalatime._

    val duration = 1L day

    val period = 1 day

    val otherDuration = 1 hour

    val durationSum = duration + otherDuration

    duration.isInstanceOf[Duration] shouldBe true
    period.isInstanceOf[Period] shouldBe true
    durationSum shouldEqual Duration.ofHours(25)

  }

  test("Users of Catcher from deprecated package should still have functionality using old import") {
    import codes.reactive.scalatime.control._
    Try(throw new DateTimeException("test")).recover(Catcher.all(_ => true)) shouldBe Success(true)  }
}
