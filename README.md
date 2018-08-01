# Load Balancing Playground
Work in progress playground to set up a load balanced environment with Camunda BPM

A mix of Docker and bare metal setup:

1. Docker with apache httpd to serve as a load-balancer. Check the IP-Adress in httpd.conf and change them to run on your machine. 
Build it with `docker build .` and run it with `docker run -p 80:80 IMAGEID`. 
2. Two spring-boot Camunda apps, listening to ports 8082 and 8083. Build them with `mvn clean package` and run them with `java -jar sb-test2.jar`
3. The spring-boot-engines point to a single postgres database, running on Docker.   

The cluster can be reached by [http://localhost/app/tasklist](http://localhost/app/tasklist).

The spring-boot apps write their access logs to the users temp folder. On my windows machine you find them under c:\user\myUserId\AppData\Temp\tomcat.ALONGNUMBER.8082\logs. They are very helpful to see how load balancing works.

## Interesting links
* [https://geekflare.com/tomcat-load-balancer-using-mod-proxy-and-session-sticky/](https://geekflare.com/tomcat-load-balancer-using-mod-proxy-and-session-sticky/)
* [https://stackoverflow.com/questions/49621813/set-jvmroute-in-spring-boot-2-0-0](https://stackoverflow.com/questions/49621813/set-jvmroute-in-spring-boot-2-0-0)
* [https://httpd.apache.org/docs/2.4/mod/mod_proxy_balancer.html](https://httpd.apache.org/docs/2.4/mod/mod_proxy_balancer.html)
* [https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)

Some errors during httpd configuration:
* [https://bz.apache.org/bugzilla/show_bug.cgi?id=52841](https://bz.apache.org/bugzilla/show_bug.cgi?id=52841)
* [https://serverfault.com/questions/773449/no-protocol-handler-valid-for-the-url-with-httpd-mod-proxy-balancer](https://serverfault.com/questions/773449/no-protocol-handler-valid-for-the-url-with-httpd-mod-proxy-balancer)
