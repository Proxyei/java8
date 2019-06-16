# 学习Java8新特性

1. **lambda表达式（其实就是一个匿名内部类）**

   **函数式接口：接口只有一个抽象方法。**

   **1.1 语法**

   （1）新操作符：->，

   ​	操作符左边：表示形参，类似接口抽象方法的参数，参数的数据类型可以不写，由JVM根据上下文推断。

   ​	操作符右边：表示执行体，类似接口抽象方法的实现类的具体实现方法，专业术语：lambda体。

   **1.2 分类**

   （1）无参无返回值

   （2）无参有返回值

   （3）一个参数无返回值

   （4）一个参数有返回值

   （5）多个参数无返回值

   （6）多个参数有返回值     

    **1.3内置接口**

   (1) 无参数有返回值，只有你给我东西，没有我给你东西：

   ```java
   @FunctionalInterface
   public interface Supplier<T> {
       T get();
   }
   ```

   相当于Supplier是一个工厂，直接生产物品。

   (2)有参数，无返回值，只有我给你东西，你不给我东西：

   ```java
   @FunctionalInterface
   public interface Consumer<T> {
       void accept(T t);
       default Consumer<T> andThen(Consumer<? super T> after) {
           Objects.requireNonNull(after);
           return (T t) -> { accept(t); after.accept(t); };
       }
   }
   ```

   (3)有1个参数，有返回值，有来有往

   ```java
   @FunctionalInterface
   public interface Function<T, R> {
       R apply(T t);
       default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
           Objects.requireNonNull(before);
           return (V v) -> apply(before.apply(v));
       }
       default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
           Objects.requireNonNull(after);
           return (T t) -> after.apply(apply(t));
       }
       static <T> Function<T, T> identity() {
           return t -> t;
       }
   }
   ```

   

   (4) 判断型接口

   ```java
   @FunctionalInterface
   public interface Predicate<T> {
   
       boolean test(T t);
   
       default Predicate<T> and(Predicate<? super T> other) {
           Objects.requireNonNull(other);
           return (t) -> test(t) && other.test(t);
       }
   
       default Predicate<T> negate() {
           return (t) -> !test(t);
       }
   
       default Predicate<T> or(Predicate<? super T> other) {
           Objects.requireNonNull(other);
           return (t) -> test(t) || other.test(t);
       }
   
       static <T> Predicate<T> isEqual(Object targetRef) {
           return (null == targetRef)
                   ? Objects::isNull
                   : object -> targetRef.equals(object);
       }
   }
   ```

   

2. ****

3. 

4. 

5. 

   





