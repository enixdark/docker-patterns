* Build WAR

     mvn clean install
     
* Create Docker image

     docker build -t demo .
     
* Run Tomcat

     docker run -it -p 8080:8080 demo
          
* With different environment variables:

     docker run -it -e DEMO_COLOR=green -e DEMO_LABEL=Production demo
     
* Open Browser at ${DOCKER_HOST IP}:8080