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

package codes.reactive.scalatime.dsl.conversions

import codes.reactive.scalatime.{Duration, Period}
import org.scalatest.{FreeSpec, Matchers}

/**
 * Created by arashid on 08/06/14.
 */
class NumberConversionsSuite extends FreeSpec with Matchers {

  val subject = new NumberImplicits {}

  import subject._

  "A NumberImplicits instance" - {

    "provides an implicit conversion of an 'Int' to an 'IntPeriod'" in {
      (1 day).isInstanceOf[Period] should be(right = true)
    }

    "provides an implicit conversion of a 'Long' to a 'LongDuration'" in {
      (1L day).isInstanceOf[Duration] should be(right = true)
    }
  }

}
