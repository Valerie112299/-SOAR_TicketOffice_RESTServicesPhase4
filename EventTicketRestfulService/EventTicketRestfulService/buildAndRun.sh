#!/bin/sh
mvn clean package && docker build -t ch.lab.Unil/EventTicketRestfulService .
docker rm -f EventTicketRestfulService || true && docker run -d -p 9080:9080 -p 9443:9443 --name EventTicketRestfulService ch.lab.Unil/EventTicketRestfulService