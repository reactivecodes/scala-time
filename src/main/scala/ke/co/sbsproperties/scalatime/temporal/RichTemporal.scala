/**********************************************************************
 * See the NOTICE file distributed with this work for additional      *
 *   information regarding Copyright ownership.  The author/authors   *
 *   license this file to you under the terms of the Apache License,  *
 *   Version 2.0 (the "License"); you may not use this file except    *
 *   in compliance with the License.  You may obtain a copy of the    *
 *   License at:                                                      *
 *                                                                    *
 *       http://www.apache.org/licenses/LICENSE-2.0                   *
 *                                                                    *
 *   Unless required by applicable law or agreed to in writing,       *
 *   software distributed under the License is distributed on an      *
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY           *
 *   KIND, either express or implied.  See the License for the        *
 *   specific language governing permissions and limitations          *
 *   under the License.                                               *
 **********************************************************************/

package ke.co.sbsproperties.scalatime
package temporal

import java.time.temporal.Temporal


final class RichTemporal(val underlying: Temporal) extends AnyVal {


  def +(amount: TemporalAmount): Temporal = underlying.plus(amount)

  def +(amount: Long, unit: TemporalUnit): Temporal = underlying.plus(amount, unit)


  def -(amount: TemporalAmount): Temporal = underlying.minus(amount)

  def -(amount: Long, unit: TemporalUnit): Temporal = underlying.minus(amount, unit)

}
