/*******************************************************************
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

package codes


package object reactive {

  /** Compatibility layer to allow easier  migration from codes.reactive.scalatime -> scalatime
    * We need this hack since Scala does not support deprecating package objects yet.
    */
  @deprecated("The package name changed from 'codes.reactive.scalatime' -> 'scalatime'. Please update imports" +
    " accordingly by removing references to the 'codes.reactive' prefix.", "0.5.0")
  object scalatime extends _root_.scalatime.impl.ToAllOps with _root_.scalatime.impl.ToAllStd {

    @deprecated("The package name changed from 'codes.reactive.scalatime' -> 'scalatime'. Please update imports" +
      " accordingly by removing references to the 'codes.reactive' prefix.", "0.5.0")
    object control {

      import _root_.scalatime.control.{Catcher => RealCatcher}

      @deprecated("The package name changed from 'codes.reactive.scalatime' -> 'scalatime'. Please update imports" +
        " accordingly by removing references to the 'codes.reactive' prefix.", "0.5.0")
      val Catcher = RealCatcher
    }

  }

}
