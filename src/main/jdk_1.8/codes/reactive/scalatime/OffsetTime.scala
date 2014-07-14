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

import java.time.{OffsetTime => OT}


/** Factory object for obtaining [[OffsetTime]] instances. */
object OffsetTime extends OffsetTimeFactory {

  def apply(): OffsetTime = OT.now(Clock())

  def apply(clock: Clock): OffsetTime = OT.now(clock)

  def apply(localTime: LocalTime, offset: ZoneOffset): OffsetTime = OT.of(localTime, offset)

  def apply(from: TemporalAccessor): OffsetTime = OT.from(from)

  def parse(text: String): OffsetTime = OT.parse(text)

  def parse(text: String, formatter: DateTimeFormatter): OffsetTime = OT.parse(text, formatter)

  def of(hour: Int, minute: Int, second: Int, nano: Int, offset: ZoneOffset): OffsetTime = OT.of(hour, minute, second, nano, offset)

  val Max: OffsetTime = OT.MAX

  val Min: OffsetTime = OT.MIN
}
