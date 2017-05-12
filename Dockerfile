FROM rhuss/docker-reveal:latest

ARG pdf=docker-patterns.pdf


# ADD m2.tar.bz2 /root/.m2/
ADD slides /slides/
ADD ${pdf} /slides/docker-patterns.pdf
ADD demo /demo/
