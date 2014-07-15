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
package format

import java.util.Locale


private[scalatime] abstract class AbstractTimeFormatters {

  /** Provides members providing default ISO-8601 [[DateTimeFormatter]] instances **/
  def Iso: AbstractIsoFormatters


  /** Formats or parses an RFC-1123 / RFC822 (internet) date-time **/
  def `RFC1123/RFC822`: DateTimeFormatter

  /** Formats or parses an RFC-1123 / RFC822 (internet) date-time **/
  def Internet: DateTimeFormatter = `RFC1123/RFC822`

  /** Creates a new [[DateTimeFormatter]] based on a string pattern of letters and symbols. See the
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html java API documentation]] for
    * a full list of symbols and meanings. For example, d MMM uuuu will format 2014-06-07 as '7 Jun 2014'.
    *
    * @param pattern  the pattern to use
    * @throws IllegalArgumentException - if the pattern is invalid
    * @return a [[DateTimeFormatter]] based on the pattern
    */
  def apply(pattern: String): DateTimeFormatter

  /** Creates a new [[DateTimeFormatter]] based on a string pattern of letters and symbols and the provided locale.
    * This can be changed using `withLocale(Locale)` on the returned formatter. See the
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html java API documentation]] for
    * a full list of symbols and meanings. For example, d MMM uuuu will format 2014-06-07 as '7 Jun 2014'.
    *
    * @param pattern  the pattern to use
    * @param locale the locale to use
    * @return a [[DateTimeFormatter]] based on the pattern and locale
    */
  def apply(pattern: String, locale: Locale): DateTimeFormatter

}


private[scalatime] trait AbstractIsoFormatters {

    /** Formats or parses a date without an offset, such as '20111203'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#BASIC_ISO_DATE Java API]]
      * for more information.
      */
    def Basic: DateTimeFormatter

    /** Formats or parses a date with the offset if available, such as '2011-12-03' or '2011-12-03+01:00'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_DATE Java API]]
      * for more information.
      */
    def Date: DateTimeFormatter

    /** Formats or parses a time, with the offset if available, such as '10:15', '10:15:30' or '10:15:30+01:00'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_TIME Java API]]
      * for more information.
      */
    def Time: DateTimeFormatter

    /** Formats or parses an instant in UTC, such as '2011-12-03T10:15:30Z'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_INSTANT Java API]]
      * for more information.
      */
    def Instant: DateTimeFormatter

    /** Formats or parses a date without an offset, such as '2011-12-03'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_LOCAL_DATE Java API]]
      * for more information.
      */
    def LocalDate: DateTimeFormatter

    /** Formats or parses a date-time without an offset, such as '2011-12-03T10:15:30'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_LOCAL_DATE_TIME Java API]]
      * for more information.
      */
    def LocalDateTime: DateTimeFormatter

    /** Formats or parses a time without an offset, such as '10:15' or '10:15:30'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_LOCAL_TIME Java API]]
      * for more information.
      */
    def LocalTime: DateTimeFormatter

    /** Formats or parses a date with an offset, such as '2011-12-03+01:00'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_OFFSET_DATE Java API]]
      * for more information.
      */
    def OffsetDate: DateTimeFormatter

    /** Formats or parses a date-time with an offset, such as '2011-12-03T10:15:30+01:00'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_OFFSET_DATE_TIME Java API]]
      * for more information.
      */
    def OffsetDateTime: DateTimeFormatter

    /** Formats or parses a time with an offset, such as '10:15+01:00' or '10:15:30+01:00'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_OFFSET_TIME Java API]]
      * for more information.
      */
    def OffsetTime: DateTimeFormatter

     /** Formats or parses a date time with an offset and zone, such as '2011-12-03T10:15:30+01:00[Europe/Paris]'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_ZONED_DATE_TIME Java API]]
      * for more information.
      */
    def ZonedDateTime: DateTimeFormatter

    /** Formats or parses the ordinal date without an offset, such as '2012-337'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_ORDINAL_DATE Java API]]
      * for more information.
      */
    def OrdinalDate: DateTimeFormatter
  }
