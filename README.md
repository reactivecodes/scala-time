scala-time
==========

Basic Scala utilities allowing for easier use of *`java.time`* APIs.

*Note:* Support has now been dropped for JDK 7 and the [Threeten BP][12] backport APIs.

###### Supported Scala Versions:
- 2.11
- 2.10

<br>
[![][Build Status Image]][Build Status]
[![][Coverage Status Image]][Coverage Status]

__________________________________

Usage:
-----
This project is not *yet* considered stable, and the API is subject to change, however `0.3.0-SNAPSHOT` binaries are
published to the [`Sonatype OSS Snapshots`][5] public repository.

###### [sbt][6] coordinates:

```scala
    // Requires JDK 1.8 and above
    "codes.reactive" %% "scala-time" % "0.3.0-SNAPSHOT"
```

#### Documentation:
See the [project website][9] for links to current documentation.

#### Examples:
```scala
import java.time._
import codes.reactive.scalatime._
import Scalatime._

// Obtain a Duration instance from a Long
val duration = 10L minutes

val otherDuration = 1L minute

// Obtain a Period instance from an Int
val period = 2 weeks

// Obtains a LocalDate instance
val localDate = LocalDate.of(2014, 6, 7)

// Obtain a default TemporalQuery for precision
val query = temporal.TemporalQueries.precision

// Obtain a Duration instance from a sum of Durations
duration + otherDuration

//  Add a TemporalAmount to a Temporal
period <<+ localDate

//  Add a TemporalAmount to a Temporal
localDate + period

// Subtract a TemporalAmount from a Temporal
localDate - period

// Query a specified Temporal
val result = query |> localDate
```


__________________________________


License
-------
See the NOTICE file distributed with this work for additional
information regarding copyright ownership

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this work except in compliance with the License.
You may obtain a copy of the License at

 [`http://www.apache.org/licenses/LICENSE-2.0`][4]

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


[1]: http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html
[2]: http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html
[3]: https://reactive.codes/ci/app/rest/builds/buildType(id:ScalaTime_IntegrationTest),branch:master/statusIcon
[4]: http://www.apache.org/licenses/LICENSE-2.0
[5]: https://oss.sonatype.org/content/repositories/snapshots
[6]: http://scala-sbt.org
[7]: https://reactive.codes/ci/viewLog.html?buildTypeId=ScalaTime_IntegrationTest&buildId=lastFinished&buildBranch=master
[8]: https://reactive.codes/issues/issues?q=project%3A+%7BScala+Time%7D
[9]: http://oss.reactive.codes/scala-time
[11]: https://reactive.codes/ci/project.html?projectId=ScalaTime&tab=projectOverview
[12]: http://www.threeten.org
[13]: http://www.threeten.org/threetenbp/apidocs
[Build Status]:https://travis-ci.org/reactivecodes/scala-time
[Build Status Image]:https://travis-ci.org/reactivecodes/scala-time.svg?branch=master
[Coverage Status]:https://coveralls.io/r/reactivecodes/scala-time?branch=master
[Coverage Status Image]:https://coveralls.io/repos/github/reactivecodes/scala-time/badge.svg?branch=master
