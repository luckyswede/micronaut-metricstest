Trigger http.server.requests metric with status=500
```
# netcat on statsd port
nc -ul 8125|grep http.server

# in another terminal
# start server
./gradlew run

# in another terminal
# test
curl http://localhost:8080/insecure/test/

# the following is sent to statsd
# http.server.requests:2.090088|ms|#exception:HttpStatusException,method:GET,status:500,uri:/insecure/notfound
# http.server.requests:321.099422|ms|#exception:none,method:GET,status:200,uri:/insecure/test
```

No http.server.requests metric with status=401 is reported
```
# netcat on statsd port
nc -ul 8125|grep http.server

# in another terminal
# start server
./gradlew run

# in another terminal
# test
curl http://localhost:8080/secured/test/ -v

# nothing is sent to statsd
```

