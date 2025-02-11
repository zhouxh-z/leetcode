# uri 和 url 的区别
范围：
uri > url，所有的url都是uri

url 通常指的是：http://ip:端口/home/xxx  -- 包含 协议、IP或者域名 以及 资源所在位置

# dns 如何查找IP地址

当我们访问一个域名时，
1、从本都hosts文件中查找是否存在对应的域名/IP映射关系；
2、如果1中没找到，查询dns解析器缓存；
3、如果2中没找到，查询本地有没有配置 dns服务器地址（如果有，向这个地市进行查找，域名对应的IP）
4、如果3中未配置dns服务器地址，直接访问根服务器，根据域名倒序（域名：三级.二级.一级）查找IP

# 网页的解析过程

1、用户输入地址
2、dns解析 
3、tcp连接
4、发起http请求
5、处理请求
6、浏览器渲染
7、连接断开

# HTTP 报文结构
1、请求的简略信息：请求方式、url、协议版本
2、请求首部：请求/响应 header
3、请求实体：请求的内容（报文）

## 请求首部
1、通用header
connection 连接类型
date 时间
cache-control 是否启用缓存

2、请求header
host 请求服务器地址
user-agent 浏览器身份标识
accept 服务器允许接收的媒体类型
accept-charset 浏览器申明可接受的字符集（utf-8）
Authorization http协议中需要认证资源的认证信息

3、响应header
Server 客户端信息
vary 缓存控制
Location 重定向的url
retry-after 多久以后可以重试

4、实体header
content-encoding 返回内容的编码
content-length 返回内容长度
content-language 返回内容语言
content-MD5 返回内容的MD5校验值
content-type 返回内容的格式及其字符集

# HTTP请求方式
有10种、常用的 get\post\delete\put，还有head、connect、options、patch、trace

# HTTP 状态码
100~199 信息性状态码
200~299 成功状态码
300~399 重定向状态码
400~499 客户端错误状态码（请求无法处理）
500~599 服务端错误状态码（请求处理报错）

# HTTP 版本的区别
http1.1 之前 默认短连接，如需使用长连接，需要在header中声明 connection:keep-alive
http1.1 之后 默认长连接，如需断开连接，需要在header中声明 connection:close

# HTTP 是无状态协议，怎么保存用户状态
1、session 第一次请求时，服务端生成session对象，并返回给客户端一个该对象的 sessionId（通过请求头 中set-cookie返回），后续请求携带sessionId进来（cookie请求头发送）；
2、cookie 第一次请求时，服务端生成cookie（用客户端信息加密成的），并发送给客户端（通过请求头 中set-cookie返回），后续请求携带该 cookie（cookie请求头发送）；

区别：
1、session需要存储，分布式服务中，需要一个独立唯一的数据中心，信息小，安全
2、cookie不需要存储，包含用户信息，信息大，不安全
