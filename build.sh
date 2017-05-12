#!/bin/sh
tag=$(git rev-parse --abbrev-ref HEAD)
if [ ${tag} = "master" ]; then
  tag="latest"
fi
echo "Building rhuss/docker-patterns:${tag}"
docker build --build-arg pdf=$(ls docker*.pdf) -t rhuss/docker-patterns:${tag} .
sed -i.bak "s/^tag=.*$/tag=${tag}/" run-container.sh
rm run-container.sh.bak
