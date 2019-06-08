# 查漏补缺Java

1. **内部类**（一般用在GUI编程中）

   **1.1 成员内部类**

   **1.1.1非静态成员内部类（以下都是说非静态内部类）**

   （1）能访问外部类的所有成员变量。

   （2）如果非静态成员内部类被private修饰，则外部程序无法使用该成员内部类。

   （3）非静态成员内部类使用：

   ```java
   		//使用一		
   		OuterInnerClass.InnerClass innerClass=new OuterInnerClass().newInnerClass();
   		innerClass.innerSay();
   		//使用二
   		InnerClass innerClass = new OuterInnerClass().new InnerClass();
   		innerClass.innerSay();
   		
   
   ```

   （4）非静态成员内部类变量与外部类同名，则使用方法如下：

   ```java
   		System.out.println(OuterInnerClass.this.username)
   ```

   （5）非静态成员内部类内部类如果有static成员变量，则该成员必须被final修饰。

   （6）如果成员内部类的方法被static修饰，则该内部类必须被static修饰，此时该成员内部类就变成了静态成员内部类。

   （7）非静态成员内部类可以直接访问外部类的静态方法。

   **1.1.2 静态成员内部类（此时相当于一个文件里面有两个class类）**

   （1）不可以访问外部类的所有非static成员变量与方法，但是可以访问外部类被static修饰的成员变量与方法。

   （2）静态成员内部类使用：

   ```java
   		StaticInnerClass staticInnerClass=new StaticInnerClass();
   		staticInnerClass.staticInnerClassSay();
   		staticInnerClass.getOuterStaticSay();
   ```

   

   

   **1.2 局部内部类（以下都默认内局部内部类）**

   （1）类不能被static，public，protected，private修饰。

   （2）局部内部类只能在定义该局部内部类的方法里面使用，并且必须是在内部类后面使用，如果再回调该方法，则会出现stackoverflow。

   （3）通过调用外部类的方法达到使用局部内部类的效果。

   ```java
   		OuterLocalInnerClass outerLocalInnerClass=new OuterLocalInnerClass();
   		outerLocalInnerClass.localInnerClassSay();
   ```

   

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

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   