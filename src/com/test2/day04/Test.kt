package com.test2.day04


//
//
//
//    一、面向对象的特征
//    面向对象的三大特征：封装、继承、多态
//
//    由于面向对象的三大特征太过于普通，而且这并不是Kotlin中特有的知识。在这里就不多做描述。
//

//    二、Kotlin继承类
//    在Kotlin中，继承这个特性除了定义关键字,以及所有的父类和Java语言不通之外，其他的其实无太大的差别。不过既然写到了这里，
//    还是从始至终的写完这个特性，如果您有Java的基础，您可以当复习一遍。
//
//    2.1、超类(Any)
//    在Kotlin中，说有的类都是继承与Any类，这是这个没有父类型的类。即当我们定义各类时，它默认是继承与Any这个超类的
//
//    例：
//
//    class Demo    // 这里定义了一个Demo类，即这个类默认是继承与超类的。
//    因为Any这个类只是给我们提供了equals()、hashCode()、toString()这三个方法。我们可以看看Any这个类的源码实现：
//
//    package kotlin
//
//    /**
//     * The root of the Kotlin class hierarchy. Every Kotlin class has [Any] as a superclass.
//     * 看这个源码注释：意思是任何一个Kotlin的类都继承与这个[Any]类
//     */
//    public open class Any {
//
//        // 比较: 在平时的使用中经常用到的equals()函数的源码就在这里额
//        public open operator fun equals(other: Any?): Boolean
//
//        // hashCode()方法：其作用是返回该对象的哈希值
//        public open fun hashCode(): Int
//
//        // toString()方法
//        public open fun toString(): String
//    }

//    从源码可以我们看出，它直接属于kotlin这个包下。并且只定义了上面所示的三个方法。或许你具有Java的编程经验。
//    在我们熟知的Java中，所有的类默认都是继承与Object类型的。而Object这个类除了比Any多了几个方法与属性外，没有太大的区别。
//    不过他们并不是同一个类。这里就不多种讲解了....
//
//    从上面源码中所产生的疑惑：类与函数前面都加上了open这个修饰符。那么这个修饰符的作用是什么呢？
//    其实我们分析可以得出：既然Any类是所有类的父类，那么我们自己要定义一个继承类，跟着Any类的语法与结构就能定义一个继承类。
//    故而，open修饰符是我们定义继承类的修饰符
//
//
//
//
//
//


//
//
//    2.2、定义
//    2.2.1、继承类的基础使用
//    定义继承类的关键字为：open。不管是类、还是成员都需要使用open关键字。
//
//    定义格式为：
//
//    open class 类名{
//        ...
//        open var/val 属性名 = 属性值
//        ...
//        open fun 函数名()
//        ...
//    }
//    例：这里定义一个继承类Demo，并实现两个属性与方法,并且定义一个DemoTest去继承自Demo
//
//    open class Demo{
//
//        open var num = 3
//
//        open fun foo() = "foo"
//
//        open fun bar() = "bar"
//
//    }
//
//    class DemoTest : Demo(){
//        // 这里值得注意的是：Kotlin使用继承是使用`:`符号，而Java是使用extends关键字
//    }
//
//    fun main(args: Array<String>) {
//
//        println(DemoTest().num)
//        DemoTest().foo()
//        DemoTest().bar()
//
//    }
//
//    分析：从上面的代码可以看出，DemoTest类只是继承了Demo类，并没有实现任何的代码结构。一样可以使用Demo类中的属性与函数。这就是继承的好处。



//
//    2.2.2、继承类的构造函数
//    在上一篇文章中，讲解到了Kotlin类，可以有一个主构造函数，或者多个辅助函数。或者没有构造函数的情况。
//    如果您对Kotlin的构造函数还不了解的情况，请阅读我的上一篇文章Kotlin——中级篇（一）：类（class）详解
//
//    这里当实现类无主构造函数，和存在主构造函数的情况。
//
//    无主构造函数
//    当实现类无主构造函数时，则每个辅助构造函数必须使用super关键字初始化基类型，或者委托给另一个构造函数。
//    请注意，在这种情况下，不同的辅助构造函数可以调用基类型的不同构造函数

//
//    例：这里举例在Android中常见的自定义View实现，我们熟知，当我们指定一个组件是，一般实现继承类(基类型)的三个构造函数。
//
//    class MyView : View(){
//
//        constructor(context: Context) : super(context)
//
//        constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
//
//        constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
//                : super(context, attrs, defStyleAttr)
//    }
//    可以看出，当实现类无主构造函数时，分别使用了super()去实现了基类的三个构造函数。
//
//    存在主构造函数
//    当存在主构造函数时，主构造函数一般实现基类型中参数最多的构造函数，参数少的构造函数则用this关键字引用即可了。
//    这点在Kotlin——中级篇（一）：类（class）详解 这篇文章是讲解到的。
//
//    例：同样以自定义组件为例子
//
//    class MyView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
//        : View(context, attrs, defStyleAttr) {
//
//        constructor(context: Context?) : this(context,null,0)
//
//        constructor(context: Context?,attrs: AttributeSet?) : this(context,attrs,0)
//    }
//




//
//    2.3、函数的重载与重写

//    在Kotlin中关于函数的重载与重写,和Java中是几乎是一样的，但是这里还是举例来说明一下。
//

//    2.3.1、重写函数中的两点特殊用法
//
//    不管是Java还是Kotlin，重写基类型里面的方法，则称为重写，或者是覆盖基类型方法。不过这里介绍两点Kotlin一点特殊的地方
//
//    当基类中的函数，没有用open修饰符修饰的时候，实现类中出现的函数的函数名不能与基类中没有用open修饰符修饰的函数的函数名相同，
//    不管实现类中的该函数有无override修饰符修饰。读着有点绕，直接看例子你就明白了。
//    例：
//
//    open class Demo{
//        fun test(){}   // 注意，这个函数没有用open修饰符修饰
//    }
//
//    class DemoTest : Demo(){
//
//        // 这里声明一个和基类型无open修饰符修饰的函数，且函数名一致的函数
//        // fun test(){}   编辑器直接报红，根本无法运行程序
//        // override fun test(){}   同样报红
//    }

//    当一个类不是用open修饰符修饰时，这个类默认是final的。即：
//    class A{}
//
//    等价于
//
//    final class A{}   // 注意，则的`final`修饰符在编辑器中是灰色的，因为Kotlin中默认的类默认是final的
//    那么当一个基类去继承另外一个基类时，第二个基类不想去覆盖掉第一个基类的方法时，第二个基类的该方法使用final修饰符修饰。
//
//    例：
//
//    open class A{
//        open fun foo(){}
//    }
//
//    // B这个类继承类A，并且类B同样使用open修饰符修饰了的
//    open class B : Demo(){
//
//        // 这里使用final修饰符修饰该方法，禁止覆盖掉类A的foo()函数
//        final override fun foo(){}
//    }
//
//


//
//    2.3.2、方法重载
//
//    在文章的开头提到了多态这个特性，方法的重载其实主要体现在这个地方。即函数名相同，函数的参数不同的情况。这一点和Java是相同的
//
//    这一点在继承类中同样有效：
//
//    例：
//
//    open class Demo{
//        open fun foo() = "foo"
//    }
//
//    class DemoTest : Demo(){
//
//        fun foo(str: String) : String{
//            return str
//        }
//
//        override fun foo(): String {
//            return super.foo()
//        }
//    }
//
//    fun main(args: Array<String>) {
//        println(DemoTest().foo())
//        println(DemoTest().foo("foo的重载函数"))
//    }






//    2.4、重写属性
//    重写属性和重写方法其实大致是相同的，但是属性不能被重载。
//    重写属性即指：在基类中声明的属性，然后在其基类的实现类中重写该属性，该属性必须以override关键字修饰，
//    并且其属性具有和基类中属性一样的类型。且可以重写该属性的值（Getter）
//    例：
//
//    open class Demo{
//        open var num = 3
//    }
//
//    class DemoTest : Demo(){
//        override var num: Int = 10
//    }



//    2.4.1、重写属性中，val与var的区别
//
//    这里可以看出重写了num这个属性，并且为这个属性重写了其值为10
//    但是，还有一点值得我们注意：当基类中属性的变量修饰符为val的使用，其实现类可以用重写属性可以用var去修饰。反之则不能。
//
//    例：

//open class Demo{
//    open val valStr = "我是用val修饰的属性"
//}
//
//class DemoTest : Demo(){
//
//    /*
//     * 这里用val、或者var重写都是可以的。
//     * 不过当用val修饰的时候不能有setter()函数，编辑器直接会报红的
//     */
//
//    // override val valStr: String
//    //   get() = super.valStr
//
//    // override var valStr: String = ""
//    //   get() = super.valStr
//
//    // override val valStr: String = ""
//
//    override var valStr: String = "abc"
//        set(value){field = value}
//}
//
//fun main(args: Array<String>){
//
//    println(DemoTest().valStr)
//
//    val demo = DemoTest()
//    demo.valStr = "1212121212"
//    println(demo.valStr)
//}


//
//    2.4.2、Getter()函数慎用super关键字
//
//    在这里值得注意的是，在实际的项目中在重写属性的时候不用get() = super.xxx,因为这样的话，不管你是否重新为该属性赋了新值，
//    还是支持setter(),在使用的时候都调用的是基类中的属性值。
//
//    例： 继上面中的例子



//open class Demo{
//    open val valStr = "我是用val修饰的属性"
//}
//
//
//class DemoTest : Demo(){
//
//    /*
//     * 这里介绍重写属性是，getter()函数中使用`super`关键字的情况
//     */
//
//    override var valStr: String = "abc"
//    get() = super.valStr
//    set(value){field = value}
//}
//
//fun main(args: Array<String>){
//    println(DemoTest().valStr)
//
//    val demo = DemoTest()
//    demo.valStr = "1212121212"
//    println(demo.valStr)
//}

//    切记：重写属性的时候慎用super关键字。不然就是上面例子的效果







//
//    2.4.3、在主构造函数中重写
//
//    这一点和其实在接口类的文章中讲解过了，不清楚的可以去参见Kotlin——中级篇（五）：枚举类（Enum）、接口类（Interface）详解。
//
//    例：基类还是上面的例子


//open class Demo{
//    open val valStr = "我是用val修饰的属性"
//}
//
//
//class DemoTest2(var num: Int, override val valStr: String) : Demo()
//
//fun main(args: Array<String>){
//    val demo2 = DemoTest2(1,"构造函数中重写")
//    println("num = ${demo2.num} \t valStr = ${demo2.valStr}")
//}






//
//    2.5、覆盖规则
//    这里的覆盖规则，是指实现类继承了一个基类，并且实现了一个接口类，当我的基类中的方法、属性和接口类中的函数重名的情况下，
//    怎样去区分实现类到底实现哪一个中的属性或属性。

//    这一点和一个类同时实现两个接口类，而两个接口都用同样的属性或者函数的时候是一样的。
//    在接口类这篇文章中已经讲解过，您可以参见Kotlin——中级篇（五）：枚举类（Enum）、接口类（Interface）详解。
//
//    例：

open class A{
    open fun test1(){ println("基类A中的函数test1()") }

    open fun test2(){println("基类A中的函数test2()")}
}

interface B{
    fun test1(){ println("接口类B中的函数test1()") }

    fun test2(){println("接口类B中的函数test2()")}
}

class C : A(),B{
    override fun test1() {
        super<A>.test1()
        super<B>.test1()
    }

    override fun test2() {
        super<A>.test2()
        super<B>.test2()
    }
}



fun main(args: Array<String>){
    val c = C()
    c.test1()
    c.test2()
}


//
//
//    总结
//    对于Kotlin中继承类这一个知识点，在项目中用到的地方是很常见的。当你认真的学习完上面的内容，我相信你可以能很轻易的用于项目中，
//    不过对一个类来说，继承的代价较高，当实现一个功能不必用到太多的集成属性的时候，可以用对象表达式这一个高级功能去替代掉继承。
//    如果你有过其他面向对象语言的编程经验的话，你只要掌握其关键字、属性/函数重写、以及覆盖规则这三个知识点就可以了。
//
//
