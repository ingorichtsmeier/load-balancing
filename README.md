# load-balancing
Work in progress playground to set up a load balanced environment with Camunda BPM

A mix of Docker and bare metal setup:

1. Docker with apache httpd to serve as a load-balancer. Check the IP-Adress in httpd.conf and change them to run on your machine. 
Build it with `docker build .` and run it with `docker run -p 80:80 IMAGEID`. 
2. Two spring-boot Camunda apps, listening to ports 8082 and 8083. Build them with `mvn clean package` and run them with `java -jar sb-test2.jar`
3. The spring-boot-engines point to a single postgres database, running on Docker.   

The cluster can be reached by [http:\\localhost\app\tasklist](http:\\localhost\app\tasklist).
