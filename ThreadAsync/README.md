@Async注解，开启异步执行，如果没有指定线程池，则每次都会创建一个新的线程
所以最好在@Async中指定线程池，或者是配置AsyncConfiguer
@Async注解的方法的返回值，只能是void,或者Future类在方法中可以return Future的实现类AsyncResult
在mqtt中，如果客户端订阅了topic,当消息推送到客户端时，执行回调（定义在MqttMessageListener中）
的messageArrived方法，如果不配置线程池，那么每一次都会时一个新的线程，所以可以使用@Async注解搭配
线程池一起使用，可以减少线程的创建。
顺便说一下，tomcat中对也是用线程池进行处理请求的。
这也算是线程池使用的一个小例子