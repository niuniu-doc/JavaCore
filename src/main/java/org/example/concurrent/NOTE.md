`Java内存模型`规范了jvm如何提供按需禁用缓存和编译优化的方法,.
包括`synchronized`, `volatile`, `final` 关键字, 及 `happens-before`原则

`volatile`告诉编译器该变量不能使用CPU缓存, 必须要从内存读取或者写入

##### happens-before 原则
它要求编译器要遵守 前一个操作的结果对后一个操作是可见的.

1. 程序的顺序性规则: 按照代码顺序、前边的操作 happens-before 于后边的操作
2. volatile 变量规则: 是指对一个volatile变量的写操作 happens-before 于读操作
3. 传递性: 若 A happens-before B, B happens-before C, 则 A happens-before 于 C
4. 管程中锁的规则: 管程是一种通用同步原语, 在Java中就是 synchronized, 它是Java对管程的实现
   管程中的锁在Java中是隐式实现的, 进入 synchronized 代码块会自动加锁, 代码块执行结束会自动释放锁
   加锁和释放都是编译器实现的
5. 线程start规则
   若 A线程中启动B线程、则, start() 方法 happens-before 于 B中的任何操作
   