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

package codes.reactive.scalatime.impl

import java.time.Duration

import scala.language.implicitConversions

/** Enriches a [[scala.Int]] with methods for obtaining [[Duration]] instances. */
final case class LongOps(underlying: Long) extends AnyVal {

  /** Obtains a [[Duration]] representing a number of nanoseconds. */
  def nano: Duration = nanos

  /** Obtains a [[Duration]] representing a number of nanoseconds. */
  def nanos: Duration = Duration.ofNanos(underlying)

  /** Obtains a [[Duration]] representing a number of milliseconds. */
  def milli: Duration = millis

  /** Obtains a [[Duration]] representing a number of milliseconds. */
  def millis: Duration = Duration.ofMillis(underlying)

  /** Obtains a [[Duration]] representing a number of seconds. */
  def second: Duration = seconds

  /** Obtains a [[Duration]] representing a number of seconds. */
  def seconds: Duration = Duration.ofSeconds(underlying)

  /** Obtains a [[Duration]] representing a number of minutes. */
  def minute: Duration = minutes

  /** Obtains a [[Duration]] representing a number of minutes. */
  def minutes: Duration = Duration.ofMinutes(underlying)

  /** Obtains a [[Duration]] representing a number of hours. */
  def hour: Duration = hours

  /** Obtains a [[Duration]] representing a number of hours. */
  def hours: Duration = Duration.ofHours(underlying)

  /** Obtains a [[Duration]] representing a number of days. */
  def day: Duration = days

  /** Obtains a [[Duration]] representing a number of days. */
  def days: Duration = Duration.ofDays(underlying)

}

trait ToLongOps extends Any {
  implicit final def toLongOpsFromLong(v: Long): LongOps = new LongOps(v)
}
