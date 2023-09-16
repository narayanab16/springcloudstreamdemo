# springcloudstreamdemo
Spring Cloud Stream Demo

-    Prereq: Docker, DockerCompose, IntelliJ, Java 8+, Here i use JDK 18/20 
-    And or Any Local kafka broker running
-    Start your confluent kafka docker (see under resources)
-     [admin@fedora37 ~]$ docker-compose -f confluent-kafka.yml up 
-    Create a topic (see under resources/kafka-help.txt)
-    See Producer and Consumer apps start
-    Kill consumer and restart consumer still u get previous missed data[Exactly once achieved]
