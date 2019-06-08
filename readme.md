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

   

   

   **1.2 局部内部类**