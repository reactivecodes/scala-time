scala-time
==========

Basic Scala utilities allowing for easier use of [Java 8][1] *[java.time][2]* APIs (JSR-310).

Build Status:  ![Build Status Icon][3]

###### Supported Scala Versions:
- 2.11
- 2.10

###### Required Java Minimum Version:
- 1.8.0 (Java 8)

Usage:
-----
This project is not *yet* considered stable, and the API is subject to change, however `0.1.0-SNAPSHOT` binaries are
published to the [`Sonatype OSS Snapshots`][5] public repository.

###### [sbt][6] coordinates:

```scala
    "ke.co.sbsproperties" %% "scala-time" % "0.1.0-SNAPSHOT"
```

#### Example:
```scala
import ke.co.sbsproperties.scalatime._
import conversions._

val duration = 10L minutes

val otherDuration = 1L minute

val period = 2 weeks

val localDate = LocalDate.of(2014, 6, 7)

duration + otherDuration

period <+= localDate

localDate - period
```


__________________________________


License
=======
See the NOTICE file distributed with this work for additional
information regarding copyright ownership

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 [`http://www.apache.org/licenses/LICENSE-2.0`][4]

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


[1]: http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html
[2]: http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html
[3]: https://dev.sbsproperties.co.ke/app/rest/builds/buildType(id:ScalaTime_Development),branch:devel/statusIcon
[4]: http://www.apache.org/licenses/LICENSE-2.0
[5]: https://oss.sonatype.org/content/repositories/snapshots
[6]: http://scala-sbt.org
