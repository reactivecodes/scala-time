/*
 * See the NOTICE file distributed with this work for additional
 * information regarding Copyright ownership.  The author/authors
 * license this file to you under the terms of the Apache License
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.  You may obtain a copy of the
 * License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */

package codes.reactive.scalatime
package impl

import java.time.temporal.TemporalQueries
import java.time.{LocalDate, LocalDateTime}

import org.scalatest.{Matchers, Outcome, fixture}


class TemporalQueryOpsSuite extends fixture.FunSuite with Matchers {
  override type FixtureParam = TemporalQueryOps[_]

  override protected def withFixture(test: OneArgTest): Outcome = {
    val query = TemporalQueries.localDate
    withFixture(test.toNoArgTest(new TemporalQueryOps(query)))
  }


  test("`▹` queries the specified TemporalAccessor using the boxed TemporalQuery.") {
    _ ▹ LocalDateTime.of(2015, 4, 25, 22, 50) shouldBe LocalDate.of(2015, 4, 25)
  }

  test("`|>` queries the specified TemporalAccessor using the boxed TemporalQuery.") {
    _ |> LocalDateTime.of(2015, 4, 25, 22, 50) shouldBe LocalDate.of(2015, 4, 25)
  }
}
