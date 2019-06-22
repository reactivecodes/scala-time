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

package scalatime.impl

import java.time.LocalDate
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE
import java.time.temporal.TemporalQueries.localDate

import org.scalatest.{Matchers, Outcome, fixture}


class StringOpsSuite extends fixture.FunSuite with Matchers {

  test("`|>(formatter: DateTimeFormatter)` parses the underlying value according to the specified DateTimeFormatter to produce a Temporal") { v ⇒
    localDate.queryFrom(v |> ISO_LOCAL_DATE) shouldEqual LocalDate.of(2016, 4, 4)
  }

  test("`|>(formatter: DateTimeFormatter)` parses the underlying value according to the specified DateTimeFormatter to produce a Temporal defined by the specified TemporalQuery") { v ⇒
    v |> (ISO_LOCAL_DATE, localDate) shouldEqual LocalDate.of(2016, 4, 4)
  }

  test("`▹(formatter: DateTimeFormatter)` parses the underlying value according to the specified DateTimeFormatter to produce a Temporal") { v ⇒
    localDate.queryFrom(v ▹ ISO_LOCAL_DATE) shouldEqual LocalDate.of(2016, 4, 4)
  }

  test("`▹(formatter: DateTimeFormatter)` parses the underlying value according to the specified DateTimeFormatter to produce a Temporal defined by the specified TemporalQuery") { v ⇒
    v ▹ (ISO_LOCAL_DATE, localDate) shouldEqual LocalDate.of(2016, 4, 4)
  }
  override type FixtureParam = StringOps

  override protected def withFixture(test: OneArgTest): Outcome = withFixture(test.toNoArgTest(new StringOps("2016-04-04")))
}
