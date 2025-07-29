## kafka 、rabbitmq 、rocketmq
kafka：吞吐量大、容易丢失数据
rabbitmq：吞吐量比较低，消息可靠性高
rocketmq：吞吐量高、消息可靠性高

## mq 的核心作用是什么
1、异步处理
2、削峰填谷
3、业务解耦

## rabbitmq 是基于AMQP 协议实现的，核心三要素是什么？
Binding：连接 Exchange 和 Queue 的规则（可带 Routing Key）
exchange：接收生产者消息并决定路由规则。
queue：存储消息直到被消费者消费。

## rabbitmq 有哪些匹配方式
1、Direct：根据 routing key 精准匹配，将消息发送到那个队列中，生产者和消费者必须声明 routing key
2、Fanout：广播，将消息发送到所有队列中，忽略 routing key
3、topic：可以根据通配符匹配，将消息发送到符合通配符的队列中，生产者和消费者必须声明 routing key

## 如何确保消息的可靠性 ？怎么保证事件不丢失
1、生产者确认：开启 confirm 模式，确保消息成功投递到 Broker
2、mq 持久化：exchange 或者 queue 开启持久化 ；集群部署，提高rabbitmq的稳定性
3、消费者确认：消费者收到消息发送ack消息

## 消息重复问题，无法从rabbitmq本身避免   ？怎么保证事件的一致性 
需要业务上支持，比如发送消息时，通过雪花算法等分布式id的作为消息id，业务上校验这个id

## 死信队列
过期、拒绝消费、队列满无法加入队列的，会被加入死信队列

怎么开启
正常配置队列时，添加死信队列的参数 x-dead-letter-exchange 

## 延迟队列
rabbitmq 未实现延迟队列，可以通过设置过期时间 + 死信队列的方式模拟实现


## 怎么解决消息堆积问题
1、可以设置队列为lazy（消息先存储在磁盘，消费时再从磁盘加载到内存中）
2、增加消费者；
