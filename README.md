# Docker Patterns

This contains the slides for the presentation "Docker Patterns" which is based on [rhuss/docker-reveal](https://github.com/rhuss/docker-reveal) image.

It includes a HTML5 Terminal emulation which can be used from within the browser (look for slides named "Demo"). The demo can be find below `/demo` where each directory contains its own README.

For the demos to work, the following software is installed:

* Java 8
* Maven 3.3.9
* Docker 1.9.1
* Emacs 25.0.50.1

The image is best started with the include `run.sh` or for some more fanciness, there is also the [shell script](https://raw.githubusercontent.com/rhuss/docker-patterns/voxxed-athens/run-container.sh).

With this startup script the presentation is then available at `http://docker_host:9000` where `docker_host` is the address of your Docker daemon's host (e.g. `localhost` or the IP of your boot2docker VM).

When watching the presentation you can use `m` for getting a Menu for directly navigating to individual slides. There you will also find section **Links** which useful links to additional information.

Have fun (and feel free to open [issues](https://github.com/rhuss/docker-patterns/issues) in case of questions or suggestions).

## Links

* [Slides](docker-patterns-voxxed-athens.pdf)

### Patterns
* [Writing Software Patterns](http://www.martinfowler.com/articles/writingPatterns.html)

### Dockerfile Template

* [fish-pepper](https://github.com/fabric8io-images/fish-pepper)
* [dogen](https://github.com/jboss-dockerfiles/dogen)
* [Crane](https://github.com/victorlin/crane)
* [App::Dockerfile::Template](http://search.cpan.org/~micvu/App-Dockerfile-Template/)

### Image Factory

* [Ansible](http://www.ansible.com)
* [Packer Docker Builder](https://www.packer.io/docs/builders/docker.html)
* [Provision Docker Containers with Ansible](http://www.ibm.com/developerworks/cloud/library/cl-provision-docker-containers-ansible)
* [Building Docker Images with Ansible](https://opensolitude.com/2015/05/26/building-docker-images-with-ansible.html)
* [ansible-container](https://docs.ansible.com/ansible-container/)
* [Packer](https://www.packer.io/)

### Sidecar Pattern

* [Why Use a Container Sidecar for Microservices?](https://www.voxxed.com/blog/2015/01/use-container-sidecar-microservices/)
* [Ambassador for network linking](https://docs.docker.com/engine/admin/ambassador_pattern_linking/)
* [Sidecar Examples](https://pinboard.in/u:moderation/t:sidecar)
* [Funktion](https://github.com/fabric8io/funktion)
* [Patterns for composite containers](http://blog.kubernetes.io/2015/06/the-distributed-system-toolkit-patterns.html)

### Java Build Integration

* [fabric8/docker-maven-plugin](https://github.com/fabric8io/docker-maven-plugin)

### Bonus

* [The Docker Wormhole Pattern](https://ro14nd.de/Docker-Wormhole-Pattern)
* [rhuss/docker-reveal](https://hub.docker.com/r/rhuss/docker-reveal)
