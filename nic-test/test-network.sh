#!/bin/sh

DIR="$( cd -P "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

java -cp $DIR/jgroups.jar -Djgroups.bind_addr=127.0.0.1 -Djava.net.preferIPv4Stack=true org.jgroups.demos.Draw -props $DIR/../lab1/src/sample/jgroups.xml &
java -cp $DIR/jgroups.jar -Djgroups.bind_addr=127.0.0.1 -Djava.net.preferIPv4Stack=true org.jgroups.demos.Draw -props $DIR/../lab1/src/sample/jgroups.xml &

