#!/bin/sh
echo "Starting presentation"

docker run -it --rm \
      -v /var/run/docker.sock:/var/run/docker.sock \
      -v $(pwd)/slides:/slides \
      -v $(pwd)/demo:/demo \
      -v $(pwd)/m2:/root/.m2 \
      -e MAVEN_OPTS="-Ddocker.host.address=127.0.0.1" \
      -p 9000:9000 -p 57575:57575 -p 35729:35729 \
      rhuss/docker-patterns:latest $*
