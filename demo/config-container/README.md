# With config image

* Build WAR

     mvn clean install
     
* Make Docker Image 

     docker build -t demo .
     
* Make dev-config container:
    
     docker build -q --build-arg config=dev.properties -f Dockerfile-config -t dev-config-image .
     docker run --name dev-config dev-config-image
         
* Start demo image with dev-config:

     docker run --volumes-from=dev-config -p 8080:8080 demo
     
* Same for prod image
