package com.test2.day05

//
//
//    一、枚举类

//    1.1、声明方式及枚举常量
//    关键字：enum
//    枚举常量：即枚举类下的对象，每个枚举类包含0个到多个枚举常量。

//    1.1.1、声明
//
//    enum关键字在类头中的class关键字前面
//
//    声明格式：
//
//    enum class 类名{
//        ...
//    }


//    1.1.2、枚举常量
//
//    枚举类中的每一个枚举常量都是一个对象，并且他们之间用逗号分隔。
//
//    例：
//
//    /**
//     * 例：关于一个网络请求结果的枚举类
//     */
//    enum class State{
//        /*
//             NORMAL : 正常
//             NO_DATA : 数据为空
//             NO_INTERNET : 网络未连接
//             ERROR : 错误
//             OTHER : 其他
//         */
//
//        NORMAL,NO_DATA,NO_INTERNET,ERROR,OTHER
//    }


//    1.1.3、访问枚举常量
//
//    不需要实例化枚举类就可以访问枚举常量
//    使用方式为：
//
//    枚举类名.枚举常量.属性
//    通过上面例子来实例讲解：
//
//    // 使用中缀符号访问枚举常量
//    State.NORMAL.name
//    State.NO_DATA.name
//    State.NO_INTERNET.name
//    State.ERROR.name
//    State.OTHER.name
//    这里只是让大家明白怎样去访问一个枚举常量。没有讲解到枚举常量的使用。枚举常量的使用请大家耐心的看下去。在下面会详细介绍怎样去使用它。
//
//    1.2 、枚举常量的初始化
//    因为每一个枚举都是枚举类的实例，所以他们可以是初始化过的。
//    例：
//
//    enum class Color(var argb : Int){
//        RED(0xFF0000),
//        WHITE(0xFFFFFF),
//        BLACK(0x000000),
//        GREEN(0x00FF00)
//    }


//    1.3、枚举常量的匿名类
//    要实现枚举常量的匿名类，则必须提供一个抽象方法（必须重写的方法）。且该方法定义在枚举类内部。而且必须在枚举变量的后面。
//    枚举变量之间使用逗号（,）分割开。但是最后一个枚举变量必须使用分号结束。不然定义不了抽象方法。
//    在上面已经说过，每一个枚举常量就是一个对象。
//    例：

//
//fun main(args: Array<String>) {
//    ConsoleColor.BLACK.print()
//}
//
//enum class ConsoleColor(var argb : Int){
//    RED(0xFF0000){
//        override fun print() {
//            println("我是枚举常量 RED ")
//        }
//    },
//    WHITE(0xFFFFFF){
//        override fun print() {
//            println("我是枚举常量 WHITE ")
//        }
//    },
//    BLACK(0x000000){
//        override fun print() {
//            println("我是枚举常量 BLACK ")
//        }
//    },
//    GREEN(0x00FF00){
//        override fun print() {
//            println("我是枚举常量 GREEN ")
//        }
//    };
//
//    abstract fun print()
//}
//




//    1.4、枚举类的使用
//    每个枚举常量都包含两个属性：name（枚举常量名）和ordinal（枚举常量位置）
//    提供了values()和valueOf()方法来检测指定的名称与枚举类中定义的任何枚举常量是否匹配。
//    自 Kotlin 1.1 起，可以使用 enumValues<T>() 和 enumValueOf<T>() 函数以泛型的方式访问枚举类中的常量。
//    1.4.1、访问枚举变量属性
//
//    例：
//
//fun main(args: Array<String>) {
//    println("name = " + Color.RED.name + "\tordinal = " + Color.RED.ordinal)
//    println("name = " + Color.WHITE.name + "\tordinal = " + Color.WHITE.ordinal)
//    println("name = " + Color.BLACK.name + "\tordinal = " + Color.BLACK.ordinal)
//    println("name = " + Color.GREEN.name + "\tordinal = " + Color.GREEN.ordinal)
//
////    1.4.2、使用enumValues<T>() 和 enumValueOf<T>()访问
////
////    例： 枚举类还是上面例子中的Color类
//
//    println(enumValues<Color>().joinToString { it.name })
//    println(enumValueOf<Color>("RED"))
//
//
////    1.4.3、使用valueOf()和values()检测
////
////    例：
//
//    println(Color.valueOf("RED"))
//    println(Color.values()[0])
//    println(Color.values()[1])
//    println(Color.values()[2])
//    println(Color.values()[3])
//
////    其中，若使用Color.valueOf("不存在的枚举常量")，则会抛出IllegalArgumentException 异常，即枚举变量不存在。
////    若使用Color.values()[大于枚举常量位置]，则会抛出下标越界异常。
//
//}
//
//enum class Color(var argb : Int){
//    RED(0xFF0000),
//    WHITE(0xFFFFFF),
//    BLACK(0x000000),
//    GREEN(0x00FF00)
//}




//
//    1.5、枚举类的源码分析
//    即Enum.kt这个源文件。
//
//    在这里我大致的说明一下这个源文件的方法、属性等。有兴趣的可以去看看这个源文件。其实里面也没几个方法。
//

//    1.5.1、默认实现了companion object {}
//
//    这也是我们访问枚举常量无需实例化枚举类的原因。

//
//    1.5.2、仅提供了两个属性
//
//    即我们上面用到的枚举常量名称(name)和枚举常量位置(ordinal)
//    贴上这两个属性的源码：
//
//    /**
//     * Returns the name of this enum constant, exactly as declared in its enum declaration.
//     */
//    public final val name: String
//
//    /**
//     * Returns the ordinal of this enumeration constant (its position in its enum declaration, where the initial constant
//     * is assigned an ordinal of zero).
//     */
//    public final val ordinal: Int


//    1.5.3、实现了Comparable接口
//
//    这也是我们能获取枚举常量位置的原因。
//    这是Enum.kt源文件。让大家看看它实现了Comparable接口
//
//    public abstract class Enum<E : Enum<E>>(name: String, ordinal: Int): Comparable<E>{
//        ...
//    }


//    再来看看Comparable.kt里面做了些什么。其实里面就提供了一个方法罢了...
//
//    public interface Comparable<in T> {
//        /**
//         * Compares this object with the specified object for order. Returns zero if this object is equal
//         * to the specified [other] object, a negative number if it's less than [other], or a positive number
//         * if it's greater than [other].
//         */
//        public operator fun compareTo(other: T): Int
//    }
//    关于枚举类的讲解就写到这里了。不清楚的可以多看看文章，或者看看源码、官方文档等等。当然，自己按照我的例子去敲一遍代码也是非常不错的。
//
//
//
//
//
//


//
//    二、接口类

//    2.1、接口的基础使用
//    2.1.1、声明
//
//    关键字：interface
//
//    定义格式：
//
//    interface 接口名{
//        ...
//    }

//    2.1.2、用法
//
//    关键字：冒号(:)，这一点是和Java不同的。Java中使用接口使用的是implements关键字
//    在Kotlin中冒号(:)使用的地方很多：

//    用于变量的定义
//    用于继承
//    用于接口
//    方法的返回类型声明


//    使用格式：
//
//    class 类名 ： 接口名{
//        // 重写的接口函数、属性等
//        ...
//    }
//    2.1.3、举例说明

//fun main(args: Array<String>) {
//
//    // 类的初始化
//    var demo = Demo1()
//
//    demo.fun1()
//}
//
///**
// * 我定义的接口
// */
//interface Demo1Interface{
//
//    // 定义的方法
//    fun fun1()
//}
//
///**
// * 接口的实现类
// */
//class Demo1 : Demo1Interface{
//    override fun fun1() {
//        println("我是接口中的fun1方法")
//    }
//}


//    2.2、接口中的方法使用
//    不带结构体的函数可以省略大括号，且不用强制重写带结构体的函数就可以直接调用。不太明白也没关系，下面的代码中都有注释。
//    例：

//
//fun main(args: Array<String>) {
//    var demo = Demo2()
//
//    demo.fun1()
//    demo.fun2(5)
//    println(demo.fun3(10))
//    println(demo.fun4())
//
//    //可以不重写该方法直接调用
//    demo.fun5()
//}
//
//interface Demo2Interface{
//
//    /**
//     * 定义一个无参数无返回值的方法
//     */
//    fun fun1()
//
//    /**
//     * 定义一个有参数的方法
//     */
//    fun fun2(num: Int)
//
//    /**
//     * 定义一个有参数有返回值的方法
//     */
//    fun fun3(num: Int) : Int
//
//    // 下面的两个方法是有结构体， 故可以不重写
//
//    /**
//     * 定义一个无参数有返回值的方法
//     */
//    fun fun4() : String{
//        return "fun4"
//    }
//
//    /**
//     * 定义一个无结构体函数，大括号是可以省略的
//     */
//    fun fun5(){
//        // 如果函数中不存在表达式，大括号可以省略。
//        // 如fun1一样
//    }
//}
//
//class Demo2 : Demo2Interface{
//
//    override fun fun1() {
//        println("我是fun1()方法")
//    }
//
//    override fun fun2(num: Int) {
//        println("我是fun2()方法，我的参数是$num")
//    }
//
//    override fun fun3(num: Int): Int {
//        println("我是fun3()方法，我的参数是$num，并且返回一个Int类型的值")
//        return num + 3
//    }
//
//    override fun fun4(): String {
//        println("我是fun4()方法，并且返回一个String类型的值")
//
//        /*
//            接口中的fun4()方法默认返回”fun4“字符串.
//            可以用super.fun4()返回默认值
//            也可以不用super关键字，自己返回一个字符串
//        */
//        return super.fun4()
//    }
//
//    /*
//         接口中的fun5()带有结构体，故而可以不用重写，
//         fun4()同样
//    */
//
//    //    override fun fun5() {
//    //        super.fun5()
//    //    }
//}




//    2.3、接口中的属性使用
//    在接口中申明属性。接口中的属性要么是抽象的，要么提供访问器的实现。接口属性不可以有后备字段。而且访问器不可以引用它们。


//    2.3.1、作为抽象
//
//    即重写属性的时候是在实现类的类参数中。这也是用代码提示去重写的实现方法
//    例：
//
//fun main(args: Array<String>) {
//    var demo = Demo3(1,2)
//    println(demo.sum())
//}
//
//interface Demo3Interface{
//
//    val num1: Int
//
//    val num2 : Int
//}
//
//class Demo3(override val num1: Int, override val num2: Int) : Demo3Interface{
//    fun sum() : Int{
//        return num1 + num2
//    }
//}



//2.3.2、作为访问器
//
//即手动方式去实现重写，并提供get()方法
//
//例：
//
//fun main(args: Array<String>) {
//
//    var demo = Demo3(1,2)
//
//    println(demo.result())
//
//    // 在这里也可以改变接口属性的值
//    demo.num4 = 10
//    println(demo.result())
//}
//
//interface Demo3Interface{
//
//    // 声明比那俩和提供默认值
//    // 注意： val num3: Int = 3  这种方式不提供，为直接报错的
//    val num3: Int
//        get() = 3
//
//    val num4: Int
//}
//
//class Demo3( val num1: Int,  val num2: Int) : Demo3Interface{
//
//    // 提供访问器实现
//    override val num3: Int
//        get() = super.num3
//
//    // 手动赋值
//    override var num4: Int = 4
//
//    fun result() : Int{
//        return num3 + num4
//    }
//}




//    2.4、接口的冲突问题解决
//    该问题是指当我们在父类中声明了许多类型，有可能出现一个方法的多种实现。
//    例：

fun main(args: Array<String>) {

    // 类的初始化
    val demo = Demo4()

    demo.fun1()
    demo.fun2()
}

interface Demo4InterfaceOne{
    fun fun1(){
        println("我是Demo4InterfaceOne中的fun1()")
    }

    fun fun2(){
        println("我是Demo4InterfaceOne中的fun2()")
    }
}

interface Demo4InterfaceTwo{
    fun fun1(){
        println("我是Demo4InterfaceTwo中的fun1()")
    }

    fun fun2(){
        println("我是Demo4InterfaceTwo中的fun2()")
    }
}

class Demo4 : Demo4InterfaceOne,Demo4InterfaceTwo{

    override fun fun1() {
        super<Demo4InterfaceOne>.fun1()
        super<Demo4InterfaceTwo>.fun1()
    }

    override fun fun2() {
        super<Demo4InterfaceOne>.fun2()
        super<Demo4InterfaceTwo>.fun2()
    }

}


//
//
//    说明：Demo4实现了Demo4InterfaceOne和Demo4InterfaceTwo两个接口，而两个接口中都存在两个相同方法名的方法。
//    因此编译器不知道应该选哪个，故而我们用super<接口名>.方法名来区分。
//
//    三、 总结
//    我个人是从事Android开发的，以前用Java语言开发APP时因为考虑到手机性能的问题几乎用不到枚举的。因为枚举太消耗内存了。
//    当然用Kotlin语言开发Android项目中是否要用到枚举去便利去解决一些问题，此待小生自己研究。但是开发服务端项目时，一些问题用枚举是非常便利性的。

//    对于接口类来说，它在一个项目中是重中之重的，对于项目中代码的耦合性、便利性都能用接口类去实现一个良好的项目架构，对项目后期的维护或者说重构来说，
//    都能有良好的体现。可能很多Java开发者都深有体会