@echo off
call mvn clean package
call docker build -t ch.lab.Unil/EventTicketRestfulService .
call docker rm -f EventTicketRestfulService
call docker run -d -p 9080:9080 -p 9443:9443 --name EventTicketRestfulService ch.lab.Unil/EventTicketRestfulService