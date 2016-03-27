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

package codes.reactive.scalatime
package control

import java.time.DateTimeException
import java.time.format.DateTimeParseException
import java.time.temporal.UnsupportedTemporalTypeException
import java.time.zone.ZoneRulesException

import scala.reflect.ClassTag
import scala.util.control.Exception
import scala.util.control.Exception.Catcher

/** Provides methods for obtaining default [[scala.util.control.Exception.Catcher Catchers]] for possible
  * [[DateTimeException DateTimeExceptions]] thrown by the underlying Java API.
  *
  * @example
  * {{{
  *              import java.time._
  *              import codes.reactive.scalatime._
  *              import control.Catcher
  *
  *               // Obtain a TimeCatcher for all DateTimeExceptions
  *               val catchAllLocalDate = Catcher.all(_ => LocalDate.now())
  *
  *               // Use the catcher to recover from a parse error
  *               val recovered = Try { LocalDate.parse(")(&#)(@*@&#%@#%@#%)") } recover catchAllLocalDate
  * }}}
  * @define Obt Obtains a [[scala.util.control.Exception.Catcher Catcher]] for
  */
object Catcher {

  private def catcher[A, Ex <: Throwable : ClassTag](f: Ex => A): Catcher[A] =
    Exception.mkCatcher((x: Ex) => x match {
      case _: Ex => true;
      case _ => false
    }, f)(implicitly[ClassTag[Ex]])

  /** $Obt all [[DateTimeException]]s. */
  def all[A]: Catcher[A] = catcher[A, DateTimeException](throw _)

  /** $Obt all [[DateTimeException]]s.
    *
    * @param  f function to execute if the exception is encountered.
    */
  def all[A](f: DateTimeException => A): Catcher[A] = catcher(f)

  /** $Obt an [[java.time.temporal.UnsupportedTemporalTypeException]], an exception indicating that a
    * [[java.time.temporal.ChronoField]] or [[java.time.temporal.ChronoUnit]]is not supported for a Temporal class.
    *
    * @param  f function to execute if the exception is encountered.
    */
  def unsupportedTemporalType[A](f: UnsupportedTemporalTypeException => A): Catcher[A] =
    catcher(f)

  /** $Obt a [[java.time.zone.ZoneRulesException]], an exception indicating a problems with the configured time-zone rules. */
  def zoneRules[A](f: ZoneRulesException => A): Catcher[A] = catcher(f)

  /** $Obt a [[java.time.format.DateTimeParseException]], an exception indicating when an error occurs during parsing. */
  def dateTimeParseException[A](f: DateTimeParseException ⇒ A): Catcher[A] = catcher(f)

}
