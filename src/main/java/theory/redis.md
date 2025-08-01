## redis 的数据类型及其使用场景
string：
hash：
list：
set：
zset：
## redis 的线程模型
io 多路复用(和 netty 模型一致)

## redis 的持久化、备份还原
aof、rdb

## 主从架构、哨兵模式、集群

## 主节点的选举

## 脑裂问题怎么解决
半数写入

## redisson 分布式锁，怎么实现的（可重入锁）
1、通过 setnx（或者模拟setnx的方式） 实现 + lua 脚本（ 通过lua脚本可以使 redis执行命令的原子性）
    - a. 通过exists命令判断是否存在当前锁，以及 hexists 判断是否是当前线程加锁
    - b. 通过 hincrby （自增）命令，（不存在）创建或（存在）给当前锁状态加 1
    - C. 通过 pexpire （设置超时时间）命令，给当前key设置超时时间(默认30秒)
    - d. 加锁成功后，返回一个失效时间
    - e. 然后开启一个延时任务,检测锁状态,如果锁没释放,则延长锁时间;
    - f. 如果此时有其他线程尝试加锁, 加锁线程会获取锁的超时时间,并通过信号量来控制(阻塞),在锁释放的时候,再次尝试加锁(非公平锁)

## redis 集群或者主从同步导致的 锁失效问题
1. 当主节点写入成功,但是从节点未接收时,主节点宕机,导致锁失效;(半数写入)

## 缓存击穿\缓存穿透\突发热点数据\缓存雪崩
缓存击穿:缓存中不存在,导致大量请求直接到数据库
1. 超时时间离散
2. 热点数据续期

缓存穿透:缓存中不存在,数据库也不存在,导致大量请求反复请求数据库
布隆过滤器
返回空对象

突发热点数据:冷数据 爆火,大量请求同时查询缓存发下不存在后,直接查询数据库
查数据库加锁

缓存雪崩
多级缓存(jvm 本地缓存 + redis 缓存) + 限流

## 缓存数据库双写不一致问题  并发场景下 缓存和数据库数据不一致
1. 保证操作数据库和操作缓存 这两个步骤是原子性的,  操作数据量和写缓存 一起加锁

## 淘汰策列
当redis内存满时，redis会触发淘汰
1、被动删除：当缓存对象失效时，redis 不会马上进行删除，而是在下次请求命中当前缓存时候，进行删除
2、主动删除：redis定时淘汰 的key
    1. 根据失效时间顺序进行删除
    2. 随机删除失效的数据
    3. 删除最近未访问的数据(过期的)
    4. 删除使用最少的数据(过期的)
    5. 删除最近未访问的数据(未过期的)
    6. 删除使用最少的数据(未过期的)