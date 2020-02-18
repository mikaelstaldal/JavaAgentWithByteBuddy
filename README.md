# Java agent with Byte Buddy

Example how to build a 
[Java agent](https://docs.oracle.com/en/java/javase/11/docs/api/java.instrument/java/lang/instrument/package-summary.html)
and do byte code manipulation with [Byte Buddy](https://bytebuddy.net).

Inspired by [this talk](https://www.jfokus.se/talks/38). 

## Build

    mvn package

## Bundled agent

Run the main program with bundled agent:

    java -jar main/target/main-1.0-SNAPSHOT.jar

## Static agent

Run the main program with static agent:
  
    java -javaagent:staticagent/target/staticagent-1.0-SNAPSHOT-jar-with-dependencies.jar=TheAgent -jar main/target/main-1.0-SNAPSHOT.jar

## Dynamic agent

Run the main program:

    java -jar main/target/main-1.0-SNAPSHOT.jar
  
Get the PID of the main program (e.g. using the [jps tool](https://docs.oracle.com/en/java/javase/11/tools/jps.html)).

Attach a dynamic agent:

    java -jar agentloader/target/agentloader-1.0-SNAPSHOT.jar *pid* dynamicagent/target/dynamicagent-1.0-SNAPSHOT.jar Agent1

Do it again:

    java -jar agentloader/target/agentloader-1.0-SNAPSHOT.jar *pid* dynamicagent/target/dynamicagent-1.0-SNAPSHOT.jar Agent2  

## License

Copyright 2020 Mikael Ståldal

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
