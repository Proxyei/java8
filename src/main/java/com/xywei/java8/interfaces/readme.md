# 查漏补缺Java
   2. **Java8的接口**

   **2.1 接口可以有具体的实现方法，被static或者default修饰**

   使用：

   2.1.1 使用static修饰的接口方法

   ```java
   		// 测试A,B接口静态方法
   		 InterfaceA.aStaticSay();
   		 InterfaceB.bStaticSay();
   ```

   

   

   2.1.2 使用defualt修饰的接口方法

   ```java
   		//左边是A接口类型，1，就只能使用A接口相关方法或者是所有接口共同的方法,2，可以指定使用A接口的static变量;如果左边是实现类，1，可以使用实现类实现的所有接口的方法,2，多个接口相同的static变量在实现类中无法使用
   		InterfaceA interfaceA=new ImplementsClass();
   		//ImplementsClass interfaceA = new ImplementsClass();
   		interfaceA.aDefaultSay();
   		interfaceA.aSay();
   		System.out.println(interfaceA.username);
   		//interfaceA.bDefaultSay();
   		//interfaceA.bSay();
   ```

   **2.2 实现类需要实现的方法也包括implements后面所有接口的非static方法，如果所有接口都有共同的非default方法，则实现类只需要实现一个就可以，如果所有接口都有一个共同的default方法，则实现类必须使用"interface.super.deaultMethod()"来指明要实现的那个接口的default方法。**

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   