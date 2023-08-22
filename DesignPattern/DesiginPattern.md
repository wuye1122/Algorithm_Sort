# DesignPattern

[23种设计模式学习导航（Java完整版](https://blog.csdn.net/weixin_45433817/article/details/131037102)

23种常见的设计模式,以下从应用方面入手：
分类	设计模式
# 创建型
工厂方法模式（FactoryMethod）、抽象工厂模式（AbstractFactory）、建造者模式（Builder）、原型模式（Prototype）、单例模式(Singleton)
# 结构型
适配器模式(Adapter)、桥接模式（Bridge）、组合模式（Composite）、装饰器模式（Decorator）、门面模式（Facade）、享元模式（Flyweight）、代理模式（Proxy）
# 行为型
解释器模式（Interpreter）、模板方法模式（TemplateMethod）、责任链模式（ChainofResponsibility）、命令模式（Command）、迭代器模式（Iterator）、调解者模式（Mediator）、备忘录模式（Memento）、观察者模式（Observer）、状态模式（State）、策略模式（Strategy）、访问者模式（Visitor）

# 常见设计模式
1.工厂模式：这个很明显，在各种BeanFactory以及ApplicationContext创建中都用到了；

2.模版模式：这个也很明显，在各种BeanFactory以及ApplicationContext实现中也都用到了；

3.代理模式：在Aop实现中用到了JDK的动态代理；

4.单例模式：这个比如在创建bean的时候。

5.外观模式（门面模式）：Tomcat中有很多场景都使用到了外观模式，因为Tomcat中有很多不同的组件，每个组件需要相互通信，但又不能将自己内部数据过多地暴露给其他组件。用外观模式隔离数据是个很好的方法。

6.策略模式：在Java中的应用，这个太明显了，因为Comparator这个接口简直就是为策略模式而生的。Comparable和Comparator的区别一文中，详细讲了Comparator的使用。比方说Collections里面有一个sort方法，因为集合里面的元素有可能是复合对象，复合对象并不像基本数据类型，可以根据大小排序，复合对象怎么排序呢？基于这个问题考虑，Java要求如果定义的复合对象要有排序的功能，就自行实现Comparable接口或Comparator接口.

7.原型模式：使用原型模式创建对象比直接new一个对象在性能上好得多，因为Object类的clone()方法是一个native方法，它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显。

8.迭代器模式：Iterable接口和Iterator接口 这两个都是迭代相关的接口，可以这么认为，实现了Iterable接口，则表示某个对象是可被迭代的；Iterator接口相当于是一个迭代器，实现了Iterator接口，等于具体定义了这个可被迭代的对象时如何进行迭代的
