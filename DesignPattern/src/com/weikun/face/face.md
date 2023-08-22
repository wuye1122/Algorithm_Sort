**目录**

[TOC]

* * *

一、什么是外观模式
---------

> 这个大家一定是经常使用的，**外观模式（门面模式）**是一种结构型设计模式。它提供一个统一的接口，用于访问子系统中的一组接口，隐藏了系统的复杂性。最简单的应用就是，**当controller层的逻辑处理比较复杂，就可以考虑把这些逻辑封装成一个外观类。**

二、角色组成
------

> *   **外观（Facade）**：提供了访问子系统一组接口的统一接口，并将客户端请求委派给相应的子系统对象处理。
> *   **子系统（SubSystem）**：实现了子系统的具体功能，处理来自外观对象的请求。

三、优缺点
-----

> **优点：**
>
> *   简化接口：隐藏了一系列复杂的子系统接口，使得客户端更加方便的使用。
> *   解耦：外观模式讲客户端和子系统之间进行解耦。客户端只需要跟外观类交互，降低了客户端与子系统之间的依赖性。
> *   灵活：通过引入外观类，可以灵活地调整子系统的实现细节，而不会影响客户端调用。
>
> **缺点：**
>
> *   不符合开闭原则：如果需要新增或者修改子系统的功能，可能需要修改外观类。
> *   不适合大规模系统：当子系统很复杂且分散，或者子系统之间的交互方式频繁变化，使用外观模式可能导致外观类变得庞大且复杂。

四、应用场景
------

### 4.1 生活场景

> 那这就太多了，比如
>
> *   外卖：当我们点外卖时，可以直接在某外卖平台直接下单，经过一系列的子系统接口，通知店家备餐，通知外卖小哥取餐再送到你手里，这里某外卖平台就可以看作是一个外观对象，隐藏了买饭的复杂性。
> *   快递：我们需要寄送包裹时，可以通过快递代理公司提供的外观接口来进行操作。我们只需要提供包裹的信息，快递代理公司会负责处理包裹的取件、运输和投递等，而不需要我们直接与各个快递公司进行交互。
> *   旅行社：我们计划去旅行时，可以选择找一家旅行社来帮助我们安排旅行的各种事，如订机票、预定酒店、预定门票等。旅行社可以看作是一个外观对象，它为客户提供了一个统一的接口，隐藏了许多复杂的流程和细节，并与各个供应商进行协调。

### 4.2 java场景

> 这也太多了，就随便举几个吧。
>
> *   Java IO：IO库中，InputStream、OutPutStream、Reader和Writer等，都可以看作是外观类，它们封装了底层的复杂的IO操作，提供了简单的接口。
> *   JDBC：JDBC提供了一组统一的接口，用于访问和操作不同类型的数据库。DriverManager类，封装了底层的数据库连接细节，可以通过一个简单的接口就能操作不同的数据库。
> *   Spring框架：很多功能都是通过外观模式来设计的。如，BeanFactory，封装了底层的IOC和Bean的创建过程，提供了简单的接口供开发者使用。

五、代码实现
------

下面以旅行社为例，解释一下外观模式。

在旅行社中，我们可以将后台的一些复杂的子系统类，比如酒店、机票、门票预定等封装成一个旅行社预定服务，也就是外观类，最后提供一个简单的接口来处理客户端的请求。

> *   外观：TravelFacade
> *   子系统：FlightService、HotelService、TicketService
> *   外观实现类：TravelFacadeImpl

### 5.0 UML类图

![](https://img-blog.csdnimg.cn/2e76712e897a4b30832e7c2975436697.png)

### 5.1 外观（Facade）——旅行社预定服务
```java

    /** * @author Created by njy on 2023/6/14 * 1.外观（Facade） */
    public interface TravelFacade {     void dePart();}

```



### 5.2 子系统（SubSystem）
```java

    /** * @author Created by njy on 2023/6/14 * 2.子系统（SubSystem）：预定航班 */

    public class FlightService {   

     public void bookFlight(){        
        System.out.println("预定航班成功");    
    }
}


    /** * @author Created by njy on 2023/6/14 * 2,子系统（SubSystem）：预定酒店 */

    public class HotelService {    

        public void bookHotel(){        

        System.out.println("预定酒店成功");    
    }
}

    /** * @author Created by njy on 2023/6/14 * 2.子系统（SubSystem）：预定门票 */

    public class TicketService {   

     public void bookTicket(){        

        System.out.println("预定门票成功");    
    }
}

```


### 5.3 外观实现类

```java

    /** * @author Created by njy on 2023/6/14 * 3.外观实现类：旅行社 */

       public class TravelFacadeImpl implements TravelFacade{    

        private HotelService hotelService;   

        private FlightService flightService;    

        private TicketService ticketService;     

        public TravelFacadeImpl(){        

            hotelService=new HotelService();        

            flightService=new FlightService();        

            ticketService=new TicketService();    

        }    

         @Override    
        public void dePart(){        

            hotelService.bookHotel();        

            flightService.bookFlight();        

            ticketService.bookTicket();    
        }
    }

```
### 5.4 TestFacade——客户端

```java
    /** * @author Created by njy on 2023/6/14 * 外观模式测试 */
    @SpringBootTest
    public class TestFacade {   
      //客户端    
        @Test    
        void testFacade(){        
        TravelFacade travelFacade=new TravelFacadeImpl();      
        travelFacade.dePart();        
        System.out.println("-------出发-----------");   
    }
}

```

![](https://img-blog.csdnimg.cn/313e9ae8b6c8453f9928fdb8db047139.png)

六、总结
----

> 外观模式应用非常广泛，主要适用于需要简化和封装复杂性、解耦和提供统一接口的情况，具体的使用场景如下：
>
> *   简化复杂的子系统：当一个子系统非常复杂，包含多个组件或模块，并且它们之间的交互相对复杂时，可以使用外观模式将复杂性封装起来。外观类作为一个简单的接口，将复杂的子系统隐藏起来，对外提供简洁清晰的接口。
> *   隐藏底层实现细节：当底层系统或第三方库的实现细节复杂且易变时，可以使用外观模式将其封装起来。外观类提供一组简单的接口，封装了底层实现细节，错误处理和兼容性问题都可以在外观类中处理。
> *   提供统一的接口：当一个复杂系统需要向外部提供一组简单易用的接口时，可以使用外观模式。外观类作为一个门面，将对内部各个组件的调用转化为对外提供的接口调用。
> *   应用层和底层系统的解耦：当应用层和底层系统之间存在紧耦合时，可以使用外观模式将它们解耦。外观类作为中间层，可以将底层系统的接口整合并提供一个干净的接口给应用层使用，从而降低彼此之间的耦合度。