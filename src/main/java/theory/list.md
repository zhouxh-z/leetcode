## CopyOnWriteArrayList 原理
内部存在一个 ReentrantLock，以及一个用 volatile 修饰的 数组
每次添加时，都会加锁，并复制一个内容相同，长度加一的数组，并再最后以为赋值，然后将数据赋值给 volatile 修饰的 数组
适合读多写少的场景