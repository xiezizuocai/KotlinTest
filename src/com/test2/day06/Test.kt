package com.test2.day06



//
//
//    一、数据类
//    在Java中，或者在我们平时的Android开发中，为了解析后台人员给我们提供的接口返回的Json字符串，我们会根据这个字符串去创建一个类或者实例对象，
//    在这个类中，只包含了一些我们需要的数据，以及为了处理这些数据而所编写的方法。这样的类，在Kotlin中就被称为数据类。
//
//    1、关键字
//    声明数据类的关键字为：data
//
//    1.1、声明格式
//
//    data class 类名(var param1 ：数据类型,...){}
//    或者
//
//    data class 类名 可见性修饰符 constructor(var param1 : 数据类型 = 默认值,...)
//    说明：
//
//    data为声明数据类的关键字，必须书写在class关键字之前。

//    在没有结构体的时候，大括号{}可省略。

//    构造函数中必须存在至少一个参数，并且必须使用val或var修饰。这一点在下面数据类特性中会详细讲解。
//    参数的默认值可有可无。（若要实例一个无参数的数据类，则就要用到默认值）

//    例：
//
//    // 定义一个名为Person的数据类
//    data class Preson(var name : String,val sex : Int, var age : Int)
//

//
//
//    1.2、约定俗成的规定
//
//    数据类也有其约定俗成的一些规定，这只是为增加代码的阅读性。
//    即，当构造函数中的参过多时，为了代码的阅读性，一个参数的定义占据一行。
//
//    例：
//
//    data class Person(var param1: String = "param1",
//                      var param2: String = "param2",
//                      var param3 : String,
//                      var param4 : Long,
//                      var param5 : Int = 2,
//                      var param6 : String,
//                      var param7 : Float = 3.14f,
//                      var param8 : Int,
//                      var param9 : String){
//        // exp
//        .
//        .
//        .
//    }


//    1.3、编辑器为我们做的事情
//
//    当我们声明一个数据类时，编辑器自动为这个类做了一些事情，不然它怎么又比Java简洁呢。它会根据主构造函数中所定义的所有属性自动生成下列方法：
//
//    生成equals()函数与hasCode()函数
//    生成toString()函数，由类名（参数1 = 值1，参数2 = 值2，....）构成

//    由所定义的属性自动生成component1()、component2()、...、componentN()函数，其对应于属性的声明顺序。

//    copy()函数。在下面会实例讲解它的作用。


//    其中，当这些函数中的任何一个在类体中显式定义或继承自其基类型，则不会生成该函数
//
//    2、数据类的特性

//    数据类有着和Kotlin其他类不一样的特性。除了含有其他类的一些特性外，还有着其独特的特点。并且也是数据类必须满足的条件：
//
//    主构造函数需要至少有一个参数
//    主构造函数的所有参数需要标记为 val 或 var；
//    数据类不能是抽象、开放、密封或者内部的；
//    数据类是可以实现接口的，如(序列化接口)，同时也是可以继承其他类的，如继承自一个密封类。


//
//
//    3、用实例说明其比Java的简洁性
//    3.1、数据类的对比
//
//    Kotlin版：
//
//    data class User(val name : String, val pwd : String)



//    Java版：
//
//    public class User {
//        private String name;
//        private String pwd;
//
//        public User(){}
//
//        public User(String name, String pwd) {
//            this.name = name;
//            this.pwd = pwd;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getPwd() {
//            return pwd;
//        }
//
//        public void setPwd(String pwd) {
//            this.pwd = pwd;
//        }
//
//        @Override
//        public String toString() {
//            return "User{" +
//                    "name='" + name + '\'' +
//                    ", pwd='" + pwd + '\'' +
//                    '}';
//        }
//    }
//    分析：实现同一个功能，从代码量来说，Koltin比Java少了很多行代码，比起更简洁。
//
//
//
//

//
//
//
//    3.2、修改数据类属性
//
//    例：修改User类的name属性
//
//    Kotlin版：
//
//    Koltin要修改数据类的属性，则使用其独有的copy()函数。其作用就是：修改部分属性，但是保持其他不变
//    val mUser = User("kotlin","123456")
//    println(mUser)
//    val mNewUser = mUser.copy(name = "new Kotlin")
//    println(mNewUser)


//    输出结果为：
//
//    User(name=kotlin, pwd=123456)
//    User(name=new Kotlin, pwd=123456)


//    Java版：
//
//    User mUser = new User("Java","123456");
//    System.out.println(mUser);
//    mUser.setName("new Java");
//    System.out.println(mUser);

//    输出结果为：
//
//    User{name='Java', pwd='123456'}
//    User{name='new Java', pwd='123456'}

//    分析：从上面对两种方式的实现中可以看出，Kotlin是使用其独有的copy()函数去修改属性值，而Java是使用setXXX()去修改


//
//    4、解构声明

//    在前面讲到，Kotlin中定义一个数据类，则系统会默认自动根据参数的个数生成component1() ... componentN()函数。
//    其...,componentN()函数就是用于解构声明的

//    val mUser = User("kotlin","123456")
//    val (name,pwd) = mUser

//    println("name = $name\tpwd = $pwd")

//    输出结果为：
//
//    name = kotlin	pwd = 123456

//
//
//
//    5、系统标准库中的标准数据类

//    标准库提供了 Pair 和 Triple。尽管在很多情况下命名数据类是更好的设计选择， 因为它们通过为属性提供有意义的名称使代码更具可读性。
//    其实这两个类的源码部分不多，故而贴出这个类的源代码来分析分析

//    5.1、源码分析
//
//    @file:kotlin.jvm.JvmName("TuplesKt")
//    package kotlin
//
//    // 这里去掉了源码中的注释
//    public data class Pair<out A, out B>(
//        public val first: A,
//        public val second: B) : Serializable {
//
//        // toString()方法
//        public override fun toString(): String = "($first, $second)"
//    }
//
//    // 转换
//    public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
//
//    // 转换成List集合
//    public fun <T> Pair<T, T>.toList(): List<T> = listOf(first, second)
//
//    // 这里去掉了源码中的注释
//    public data class Triple<out A, out B, out C>(
//        public val first: A,
//        public val second: B,
//        public val third: C ) : Serializable {
//
//        // toString()方法
//        public override fun toString(): String = "($first, $second, $third)"
//    }
//
//    // 转换成List集合
//    public fun <T> Triple<T, T, T>.toList(): List<T> = listOf(first, second, third)

//    分析：从上面的源码可以看出，标准库中提供了两个标准的数据类，Pair类以及Triple类.其中：
//
//    两个类中都实现了toList()方法以及toString()方法。
//    to()方法乃Pair类特有，起作用是参数转换
//    Pair类需要传递两个参数，Triple类需要传递三个参数。


//    5.2、用法
//
//    val pair = Pair(1,2)        // 实例
//    val triple = Triple(1,2,3)  // 实例

//    println("$pair \t $triple") // 打印：即调用了各自的toString()方法
//    println(pair.toList())      // 转换成List集合
//    println(triple.toList())    // 转换成List集合
//    println(pair.to(3))         // Pair类特有: 其作用是把参数Pair类中的第二个参数替换

//    输出结果为：
//
//    (1, 2) 	 (1, 2, 3)
//    [1, 2]
//    [1, 2, 3]
//    ((1, 2), 3)
//
//


