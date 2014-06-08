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

import java.time.format.{DateTimeFormatter => DF}

/** Factory object for creation of [[DateTimeFormatter]] instances 
  * @since 0.1.0
  */
object TimeFormater {

  val ISO: ISOTimeFormatters = new ISOTimeFormatters {}

  val `RFC1123/RFC822`: DateTimeFormatter = DF.RFC_1123_DATE_TIME

  val internet: DateTimeFormatter = `RFC1123/RFC822`

  /** Creates a new [[DateTimeFormatter]] based on a string pattern of letters and symbols. See the
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html java API documentation]] for
    * a full list of symbols and meanings. For example, d MMM uuuu will format 2014-06-07 as '7 Jun 2014'.
    *
    * @param pattern  the pattern to use
    * @return a [[DateTimeFormatter]] based on the pattern
    */
  @throws[IllegalArgumentException]("if the pattern is invalid")
  def apply(pattern: String) = DF.ofPattern(pattern)

  trait ISOTimeFormatters {

    def basic: DateTimeFormatter = DF.BASIC_ISO_DATE

    def date: DateTimeFormatter = DF.ISO_DATE

    def time: DateTimeFormatter = DF.ISO_TIME

    def instant: DateTimeFormatter = DF.ISO_INSTANT

    def localDate: DateTimeFormatter = DF.ISO_LOCAL_DATE

    def localDateTime: DateTimeFormatter = DF.ISO_LOCAL_DATE_TIME

    def localTime: DateTimeFormatter = DF.ISO_LOCAL_TIME

    def offsetDate: DateTimeFormatter = DF.ISO_OFFSET_DATE

    def offsetDateTime: DateTimeFormatter = DF.ISO_OFFSET_DATE_TIME

    def offsetTime: DateTimeFormatter = DF.ISO_OFFSET_TIME

    def ordinalDate: DateTimeFormatter = DF.ISO_ORDINAL_DATE

  }

}
