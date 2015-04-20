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

import codes.reactive.sbt.SbtCodes.autoImport.Deps
import sbt._

object Dependencies extends Plugin {

  def scalaTest = Deps.scalaTest("2.1.5")

  def mockito = Deps.mockitoCore("1.10.8")

  def threeten = "org.threeten" % "threetenbp" % "1.2"

  def matchJava[A](v: String, jdk7: => A, other: => A) = v.takeRight(1).toInt match {
    case 7 => jdk7
    case x if x > 7 => other
    case _ => sys.error("Java JDK version not supported. Use JDK 1.7 (Java 7) or greater.")
  }
}
