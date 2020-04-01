package com.test2.day07


//
//
//    一、抽象类


//    我们知道，在实际的开发程序的时候，一般都会写一个基类，封装常用方法、以及处理一些共有的逻辑，但是程序逻辑是根据每个类不同的功能实现不同的代码。
//    而这个所谓的基类，一般都是一个抽象类。不管是Java还是Kotlin，实现其抽象类的作用就在于此。那么什么是抽象类呢，它是怎么定义的，它又要怎么使用呢？

//    1、抽象类的定义
//    抽象类，可以理解为类定义了一个模板。所有的子类都是根据这个模板是填充自己的代码。
//
//    1.1、关键字
//
//    声明一个抽象（类或函数）的关键字为：abstract
//    其中值得注意的是：抽象可以分为抽象类、抽象函数、抽象属性。而一个抽象类和普通类的区别在于抽象类除了可以有其自己的属性、构造函数、方法等组成部分，
//    还包含了抽象函数以及抽象属性。
//
//    例：
//
//abstract class Lanauage{
//
//    val TAG = this.javaClass.simpleName  // 自身的属性
//
//    // 自身的函数
//    fun test() : Unit{
//        // exp
//    }
//
//    abstract var name : String           // 抽象属性
//
//    abstract fun init()                  // 抽象方法
//}
//
///**
// * 抽象类Lanauage的实现类TestAbstarctA
// */
//class TestAbstarctA : Lanauage(){
//
//    override var name: String
//        get() = "Kotlin"
//        set(value) {}
//
//    override fun init() {
//        println("我是$name")
//    }
//}
//
///**
// * 抽象类Lanauage的实现类TestAbstarctB
// */
//class TestAbstarctB : Lanauage(){
//    override var name: String
//        get() = "Java"
//        set(value) {}
//
//    override fun init() {
//        println("我是$name")
//    }
//}
//
//fun main(args: Array<String>) {
//
//    // val lanauage = Lanauage() 是错误的，因为抽象类不能直接被实例化
//
//    val mTestAbstarctA = TestAbstarctA()
//    val mTestAbstarctB = TestAbstarctB()
//
//    println(mTestAbstarctA.name)
//    mTestAbstarctA.init()
//
//    println(mTestAbstarctB.name)
//    mTestAbstarctB.init()
//}
//



//
//    1.2、小结
//
//    抽象类本身具有普通类特性，以及组成部分。不过值得注意的是，抽象类不能直接被实例化

//    其抽象了类的子类必须全部重写带abstract修饰的属性和方法。

//    抽象成员只有定义，没有实现。都有abstract修饰符修饰。

//    抽象类是为其子类定义了一个模板。不同是类实现不同的功能


//    2、抽象类的规则
//    在Kotlin中的抽象类在顶层定义的时候只能使用public可见性修饰符修饰。
//    抽象类中可以定义内部抽象类。
//    只能继承一个抽象类。
//    若要实现抽象类的实例化，需要依靠子类采用向上转型的方式处理。
//    抽象类可以继承自一个继承类，即抽象类可以作为子类。不过，抽象类建议不用open修饰符修饰，因为可以覆写抽象类的父类的函数。
//    例：
//
//open class Base{
//    open fun init(){}
//}
//
//abstract class Lanauage : Base(){
//    val TAG = this.javaClass.simpleName  // 自身的属性
//
//    // 自身的函数
//    fun test() : Unit{
//        // exp
//    }
//    abstract var name : String           // 抽象属性
//    abstract override fun init()         // 覆写父类的方法
//
//    abstract class Name(){}              // 嵌套抽象类，可查看第二节中的嵌套类使用
//}
//
//
///**
// * 抽象类Lanauage的实现类TestAbstarctB
// */
//class TestAbstarctB : Lanauage(){
//    override var name: String
//        get() = "Java"
//        set(value) {}
//
//    override fun init() {
//        println("我是$name")
//    }
//}
//
//
//fun main(args: Array<String>) {
//    // 若要实现抽象类的实例化，需要依靠子类采用向上转型的方式处理。
//    val mLanauage : Lanauage = TestAbstarctB()
//    mLanauage.init()
//}



//    3、抽象类的实际应用
//    在Java的设计模式中，有一种设计模式叫模板设计模式，其定义为：

//    定义一个操作中算法的骨架，而将一些步骤延迟到子类中，模板方法使得子类可以不改变算法的结构即可重定义该算法的某些特定步骤。

//    通俗点的理解就是 ：完成一件事情，有固定的数个步骤，但是每个步骤根据对象的不同，而实现细节不同；
//    就可以在父类中定义一个完成该事情的总方法，按照完成事件需要的步骤去调用其每个步骤的实现方法。每个步骤的具体实现，由子类完成。

//    Kotlin和Java是互通的，说明Kotlin也是支持这种设计模式的。
//    如果你对Java中的模板设计模式不是很了解的，请参见这篇文章





//    二、内部类（嵌套类）
//    在实际开发中，用到内部类的地方是很多的。比如说：
//
//    对于Android开发来说，列表适配器（adapter）中的ViewHolder类，就是一个内部类。
//    根据后台开发人员提供的json字符串生成的对象中，也包含另外一个对象，这也是一个内部类。

//    1、嵌套类
//    上面提到的两种情况，是在开发中最常见的。当然，说到内部类，就必须世道另一个概念嵌套类，所谓的嵌套类：即指一个类可以嵌套在其他类中。
//
//    例：

//class Other{           // 外部类
//    val numOuther = 1
//
//    class Nested {      // 嵌套类
//        fun init(){
//            println("执行了init方法")
//        }
//    }
//}
//
//fun main(args: Array<String>) {
//    Other.Nested().init()      // 调用格式为：外部类.嵌套类().嵌套类方法/属性
//}

//
//    注意：
//
//    调用嵌套类的属性或方法的格式为：外部类.嵌套类().嵌套类方法/属性。在调用的时候嵌套类是需要实例化的。
//    嵌套类不能使用外部类的属性和成员



//    2、内部类
//    在上面的例子中讲解了嵌套类的使用，而内部类和嵌套类还是有一定的区别的，而且内部类是有特定的关键字去声明的。
//
//    2.1、关键字
//    声明一个内部类使用inner关键字。
//    声明格式：inner class 类名(参数){}
//
//    例：

//class Other{            // 外部类
//    val numOther = 1
//
//    inner class InnerClass{     // 嵌套内部类
//        val name = "InnerClass"
//        fun init(){
//            println("我是内部类")
//        }
//    }
//}
//
//fun main(args: Array<String>) {
//    Other().InnerClass().init()  // 调用格式为：外部类().内部类().内部类方法/属性
//}


//    注意：
//
//    调用内部类的属性或方法的格式为：外部类().内部类().内部类方法/属性。在调用的时候嵌套类是需要实例化的。
//    内部类不能使用外部类的属性和成员





//    2.2、匿名内部类

//    作为一名Android开发者，对匿名内部类都不陌生，因为在开发中，匿名内部类随处可见。比如说Button的OnClickListener，
//    ListView的单击、长按事件等都用到了匿名内部类。

//    一般的使用方式为定义一个接口，在接口中定义一个方法。
//
//    例：
//
//class Other{
//
//    lateinit private var listener : OnClickListener
//
//    fun setOnClickListener(listener: OnClickListener){
//        this.listener = listener
//    }
//
//    fun testListener(){
//        listener.onItemClick("我是匿名内部类的测试方法")
//    }
//}
//
//interface OnClickListener{
//    fun onItemClick(str : String)
//}
//
//fun main(args: Array<String>){
//    // 测试匿名内部类
//    val other = Other()
//    other.setOnClickListener(object : OnClickListener{
//        override fun onItemClick(str: String) {
//            // todo
//            println(str)
//        }
//    })
//    other.testListener()
//}



//    遗留的问题
//
//    在上面实现的匿名内部类是很常规的用法以及写法。在我们的实际开发当中也是大家熟知的写法。
//    但是在我们实际开发当中，会引入lambda语法糖，让我们的项目支持lambda语法，简化代码量。
//    在这里我也是想把用lambda语法实现匿名内部类实现的代码贴出来，但是考虑到很多朋友不知道lambda语法强大或者对lambda不了解，
//
//    同时考虑到篇幅原因，故而在我的下一篇博文Kotlin——高级篇（一）：Lambda表达式详解去讲解。
//
//    3、局部类
//    所谓局部类，这一点和Java是一致的。即定义在方法（函数）中的类。
//
//    例：

class Other{    // 外部类

    val numOther = 1

    fun partMethod(){
        var name : String = "partMethod"

        class Part{
            var numPart : Int = 2

            fun test(){
                name = "test"
                numPart = 5
                println("我是局部类中的方法")
            }
        }

        val part = Part()
        println("name = $name \t numPart = " + part.numPart + "\t numOther = numOther")
        part.test()
        println("name = $name \t numPart = " + part.numPart + "\t numOther = numOther")
    }
}

fun main(args: Array<String>) {
    // 测试局部类
    Other().partMethod()
}

//
//    name = partMethod 	 numPart = 2	numOther = 1
//    我是局部类中的方法
//    name = test 	 numPart = 5	numOther = 1
//    通过上面的实例：我们可以看出：
//
//    局部类只能在定义该局部类的方法中使用。

//    定义在实例方法中的局部类可以访问外部类的所有变量和方法。但不能修改

//    局部类中的可以定义属性、方法。并且可以修改局部方法中的变量。


//    4、静态类

//    熟悉Java的朋友都知道Java的静态类，或者说用static修饰符修饰的类。但是在Kotlin中，是不存在static关键字的。那么我们怎样去实现一个静态类呢？
//
//    关于静态类的使用，以及静态类的语法。以及Koltin的单例模式实现。由于篇幅原因我在这里就不展示了。
//
//    有兴趣的朋友请参见kotlin中的object更像是语法糖。这篇文章是别的大牛诠释静态类以及单例实现很好的文章。后面我会出一篇详细的文章为大家讲解。
//

//    三、总结
//    在学完本篇博文中，你应该掌握抽象类的作用，掌握其和普通类、接口类、继承类的区别所在，了解实现抽象类的意义，
//    或者说在项目中为什么要用抽象类去编写一个基类等。

//    对于嵌套类和内部类而言，知道这两者的区别所在，和熟知他们在项目中用在什么地方就够了。
//    对于静态类来说，常用的实现都是用其去实现一个单例模式。在Koltin的不像Java一样实现很多的工具类，因为Kotlin中的扩展功能很强大。
//
//    可以用扩展去替换掉大部分的工具类。本篇文章主要是展示object的用法而已，详细的使用场景和用法会在后续的文章中为大家奉上。
//






















