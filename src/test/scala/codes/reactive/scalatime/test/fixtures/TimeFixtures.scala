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

package codes.reactive.scalatime.test.fixtures

import codes.reactive.scalatime._

/**
 * Created by arashid on 17/06/14.
 */
trait TimeFixtures {

  val localDate = LocalDate.of(2014, 6, 10).get

  val localTime = LocalTime.of(22, 35, 29, 978).get

  val offsetTime = OffsetTime(localTime, ZoneOffset.UTC)

  val zonedDateTime = ZonedDateTime(localDate, localTime, ZoneOffset.UTC)

  val offsetDateTime = OffsetDateTime(localDate, localTime, ZoneOffset.UTC)

  //val fixedClock = Clock.fixed()

}
