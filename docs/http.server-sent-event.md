# server sent event

## SSE connection example

### views

```
http://localhost:<port>/<context-path>/sample/eventsource-memoryinfo-client

http://localhost:<port>/<context-path>/sample/eventsource-notification-client
http://localhost:26080/springboot25/sample/eventsource-notification-client

http://localhost:<port>/<context-path>/sample/eventsource-samplejob-client
http://localhost:26080/springboot25/sample/eventsource-samplejob-client
```

### Sample Trig SSE

```
$ curl http://localhost:<port>/<context-path>/notification-message/trig?count=100
$ curl http://localhost:26080/springboot25/notification-message/trig?count=100

$ curl http://localhost:<port>/<context-path>/sampleJob/publish
$ curl http://localhost:26080/springboot25/sampleJob/publish
```
