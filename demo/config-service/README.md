* Build WAR

     mvn clean install
     
* Create Docker image

     docker build -t demo .

* Start consul

    docker run -d -p 8500:8500 -h node1 --name consul progrium/consul -server -bootstrap -ui-dir /ui 

* Add keys "demo/color" and "demo/label" at ${docker host ip}:8500/ui

* Run Tomcat

     docker run --link consul -it -p 8080:8080 demo
               
* Open Browser at ${DOCKER_HOST IP}:8080