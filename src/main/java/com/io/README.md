
`NIO`: New IO, 可以用来替代JavaIO的新的api, 标准io是基于 `字节流` 和 `字符流` 操作, 
`nio`是基于`通道`和`缓冲区`操作, 数据从通道读到缓冲区 或者 从缓冲区写入通道, `selector` 可以
监听多个通道的io事件
> 其实nio的主要作用是解决网络, 在nio出现之前java只能使用socket, 而socket是阻塞的,nio的出现解决了这个痛点
> 主要思想是将channel注册到selector中,通过selector监听网络中的状态, 没有网络事件时, server可以做自己的事情

#### buffer
```
nio 关键buffer实现: 
byteBuffer, shortBuffer, intBuffer, longBuffer, FloatBuffer, DoubleBuffer, charBuffer, mappedByteBuffer等

写模式: position表示当前位置, limit表示可写的最大位置(capacity), 随写入数据, position的值增加
读模式: 写数据到buffer时, position表当前模式, 从0开始(从读切换为写模式时, limit会被设置成写模式下的最大值)

可以创建堆内buffer和堆外buffer
ByteBuffer.allocate() 创建堆内buffer
ByteBuffer.allocateDirect() 创建堆外buffer(直接缓冲区)
直接缓冲区场景：
1. java程序与本地磁盘，socket传输数据
2. 大文件对象可以使用，不受堆内存大小限制
3. 不需要频繁创建，生命周期较长，可以重复使用的情况
除此之外，还是建议使用 堆内buffer, 达不到一定量级，直接内存体现不出优势.
```

#### selector
```
可以多个channel注册到同一个selector, 同时监听多个通道的状态，有io事件时, 
会回调对应的select方法,实现非阻塞io，以此来实现单线程管理多个channel的目的
(网络io需要使用，文件io不需要)

selector.open() 打开一个选择器
select() 选择一组键, 其相应的通道已为io操作准备就绪
selectedKeys() 返回此选择器已选择的键集

selectionKey的操作
OP_CONNECT 客户端向server发起连接
OP_ACCEPT  server接收到client的连接事件
OP_READ 可读事件
OP_WRITE 可写事件

register() 方法会返回一个 selectionKey对象，包含interest集合、ready集合、selector、channel等
interest集合: 感兴趣的事件集合，可以查看是否有自己感兴趣的事件发生
int interestSet = selectionKey.interestOps();
boolean isInterestedInAccept  = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT；
boolean isInterestedInConnect = interestSet & SelectionKey.OP_CONNECT;
boolean isInterestedInRead    = interestSet & SelectionKey.OP_READ;
boolean isInterestedInWrite   = interestSet & SelectionKey.OP_WRITE;

判断什么操作已经准备就绪:
int readySet = selectionKey.readyOps();
也可以使用 selectionKey.isAcceptable() / isConnectionable() / isReadable() / isWrittable()

访问channel 和 selector
Channel channel = selectionKey.channel()
Selector selector = selectionKey.selector()

可以在register时, 将一个对象或更多信息附着在 selectionKey上，方便识别
SelectionKey key = channel.register(selector, selectionKey.OP_ACCEPT, buffer);

select() 阻塞到至少只有一个通道在注册的事件上就绪
select(timeout) 同select(), 至多阻塞timeout秒
selector.wakeup() 阻塞在select上的线程会立即返回, 
若其它线程调用了wakeup, 但当前没有线程阻塞在select上, 下个调用select方法的线程会立即wakeup


```

#### Channel
```
nio channel的实现:
FileChannel, DatagramChannel, SocketChannel, serverSocketChannel
覆盖了从文件中读取, 从udp报文中读取网络数据, 从tcp socket中读取网络数据等;
serverSocketChannel 可以监听新建的tcp连接, 对每个新建连接创建一个 socketChannel 
isAcceptable 是否可以接受客户端的连接
isConnectable 是否可以连接server

FileChannel:
read(): 从inChannel中读取数据, inChannel.read(buffer)
write(): 向channel中写入数据, outChannel.write(buffer)
close(): 关闭channel, channel.close()
position(): 指定位置操作
size(): 获取关联文件大小
truncate(): 将指定位置后的内容删除,  eg. truncate(10) 只保留前10个位置的元素
force(): 强制将buffer中未写入磁盘的数据写入磁盘, eg. channel.force()

DatagramChannel
receive(): 接收数据包的内容会复制到channel中, 若buffer长度不够，多出的部分会被丢弃
send(): 从buffer向channel中写入数据



```

#### 通道间的数据传输
`transferTo`: 将源通道的数据传输到目的通道
`transferFrom`: 将来自源通道的数据传输到目的通道

#### 常用API
```
写入: 
1. 从channel读入buffer int byteReads = inChannel.read(buffer) 
2. 将字节数组写入buffer buf.put(127) 

3. 模式切换: flip() limit 设为读模式下的position, position设为0

读取:
4. buffer读取到channel int bytesWritten = outChannel.written(buffer) // read from channel to buffer
5. 使用get从buffer读取 buffer.get()

rewind() 将position设为0, limit不变,可以重新读取buffer中的全部数据
clear() position设为0, limit设为capacity, buffer可以重新写入
compact() 将未读的数据cp到buffer起始处, position设置为下一位置

mark() 标记buffer中一个特定的position
reset() 读取位置恢复到 mark设置的position

equals()和compareTo() 
equal() 不比较具体元素, 只对比元素类型，元素个数
compareTo() 比较具体元素
```

> java nio 管道是两个线程之间的单向数据连接, pipe有两个管道 source 和 sink
> 数据从source管道读取, 写入sink管道

