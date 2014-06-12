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

package ke.co.sbsproperties.scalatime
package control

import scala.reflect.ClassTag
import scala.util.control.Exception
import scala.util.control.Exception._

/** Provides methods for obtaining default [[scala.util.control.Exception.Catcher]]s for possible
  * [[DateTimeException]]s thrown by the underlying Java API.
  *
  * @since  0.1.0
  */
object Catchers {

  /** Returns a new [[scala.util.control.Exception.Catcher]] for exception `Ex` **/
  private def catcher[A, Ex <: Throwable](implicit tag: ClassTag[Ex]): Catcher[A] =
    Exception.mkThrowableCatcher({ case _: Ex => true; case _ => false}, throw _)

  /** Returns a [[scala.util.control.Exception.Catcher]] for all [[DateTimeException]]s. **/
  def all[A] = catcher[A, DateTimeException]

  /** Returns a [[scala.util.control.Exception.Catcher]] for an [[UnsupportedTemporalTypeException]], an exception
    * indicating that a ChronoField or ChronoUnit is not supported for a Temporal class.
    */
  def unsupportedTemporalType[A] = catcher[A, UnsupportedTemporalTypeException]

  /** Returns a [[scala.util.control.Exception.Catcher]] for a [[ZoneRulesException]], an exception
    * indicating a problems with the configured time-zone rules.
    */
  def zoneRules[A] = catcher[A, ZoneRulesException]
}

object Catch {

  import Exception._

  /** Returns a [[scala.util.control.Exception.Catch]] for all [[DateTimeException]]s. **/
  def all[A] = catching(Catchers.all)

  /** Returns a [[scala.util.control.Exception.Catch]] for an [[UnsupportedTemporalTypeException]], an exception
    * indicating that a ChronoField or ChronoUnit is not supported for a Temporal class.
    */
  def unsupportedTemporalType[A] = catching(Catchers.unsupportedTemporalType)

  /** Returns a [[scala.util.control.Exception.Catch]] for a [[ZoneRulesException]], an exception
    * indicating a problems with the configured time-zone rules.
    */
  def zoneRules[A] = catching(Catchers.zoneRules)
}
