package com.test.day07

//
//    一、函数的声明及基本使用
//    在Kotlin中函数的声明，同JavaScript相似。
//
//    1.1、函数的声明
//    Kotlin中的函数声明关键字为：fun
//            定义格式为：可见性修饰符 fun 函数名(参数名 ：类型,...) : 返回值{}
//    这里的可见性修饰符请参见我的另一篇文章Kotlin——中级篇（三）：可见性修饰符详解，至于返回值以及参数请继续往下面看
//
//    例：定义一个最基本的函数
//
//    fun basis(){
//        ...
//    }
//    注意：
//
//    上面的例子中没有可见性修饰符，那是因为Kotlin中默认为public可见性修饰符
//    ()圆括号必须存在，即使是没有参数的情况下
//    {}大括号必须存在，即使是没有函数体的时候，不过在Kotlin中有一个特例就是，函数具备返回值的时候，如果只用一个表达式就可以完成这个函数，
//    则可以使用单表达式函数。在下面会详细的给大家讲解
//
//    在函数没有返回值时可以省略其返回值
//    1.2、成员函数
//    成员函数是指在类或对象中的内部函数。你可以参见我的另一篇文章Kotlin——中级篇（一）：类（class）详解
//
//    例：声明一个类，在类中在定义一个方法，这个方法就是这个类的成员函数
//
//    class Test{
//        fun foo(){}
//    }


//    1.3、函数的使用
//    函数的使用分为两种：
//
//    普通的使用
//    成员函数的使用
//    例：
//
//    // 普通的使用
//    basis()
//    // 如果函数有返回值
//    val x = basis()
//
//    // 成员函数的使用：先初始化对象，在根据对象使用`中缀符号(.)`调用其成员函数
//    Test().foo()
//    // 如果函数有返回值
//    val x = Test().foo()


//
//    二、函数的返回值
//    在Kotlin中，函数的返回值类型可以分为：
//
//    Unit类型：该类型即无返回值的情况，可以省略。
//    其他类型： 显示返回类型的情况
//    2.1、Unit类型
//    这个类型可以理解为函数无返回值。
//    例：
//
//    fun unitFun() : Unit{
//        println("我是返回值为Unit的函数，Unit可省略")
//        return
//
//        // return Unit 可省略
//        // 或者 return  可省略
//    }
//
//    等价于
//
//    fun unitFun(){
//        println("我是返回值为Unit的函数，Unit可省略")
//    }
//    当无返回值时，使用平时Java语法写普通函数一样即可。不需显示写成Unit。这里只是做一个介绍而已
//
//    2.2 、其他显示返回类型的返回值
//    这个类型可以理解为，该函数具有返回值，并且返回值类型不能省略，并且return也不能省略
//
//    例： 定义一个返回类型为Int的函数
//
//    fun returnFun() : Int{
//        return 2
//    }
//    三、函数的参数
//    对于函数中的参数来说，这里主要分为几个模块来讲解：
//
//    具有参数的基本函数声明
//    默认参数，即参数具有默认值
//    命名参数，当传递参数的时候显示使用参数名 = 参数值
//    可变数量的参数：即参数的个数不定。
//    3.1、具有参数的函数定义
//    定义一个具有参数的函数，使用Pascal 表示法定义，即为:name : type。其中的参数必须具有显示的参数类型，并且参数与参数之间用逗号(,)隔开。
//
//    例：
//
//    fun funArgs(numA : Int, numB : Float){
//        println("numA = $numA \t numB = $numB")
//    }
//
//    fun main(args: Array<String>) {
//        funArgs(1,10f)
//    }

//    3.2、默认参数
//    对于默认参数，即使指一个函数中的参数具有默认值，这样在使用该函数的时候，可以省略一部分参数，可以减少函数的重载
//
//    例：定义个具有默认参数的函数
//
//    fun defArgs(numA : Int  = 1, numB : Float = 2f, numC : Boolean = false){
//        println("numA  =  $numA \t numB = $numB \t numC = $numC")
//    }
//
//    fun main(args: Array<String>) {
//
//        // 默认参数的函数使用
//        defArgs()
//        defArgs(1,10f,true)
//    }
//    输出结果为：
//
//    numA  =  1 	 numB = 2.0 	 numC = false
//    numA  =  1 	 numB = 10.0 	 numC = true
//    可以看出：当具有默认参数时，可以对是参数有默认值的参数不传递参数值。
//
//    不过这里有一点值得注意的是： 当该函数是一个成员函数时,并且该函数时覆写继承类中的方法时，则该成员函数必须从签名中省略该函数的默认值。
//
//    其实这一点不必过于看重，因为在你覆写方法时，编辑器都默认会帮你实现的..
//
//    举例说明：
//
//    open class A{
//        open fun foo(i : Int = 10){}
//    }
//
//    class B : A(){
//        override fun foo(i: Int) {
//            super.foo(i)
//            println(i)
//        }
//    }
//
//    fun main(args: Array<String>) {
//        B().foo()
//    }
//



//
//    3.3、命名参数
//    即在使用函数时显示使用参数名 = 参数值这种方式传递参数
//
//    例：这里举例一个普通的具有参数函数与具有默认参数函数的结合使用
//
//    fun callFun(str : String,
//                isTrue : Boolean = false,
//                numA : Int = 2,
//                numB: Float = 2.0f,
//                numC : Int = 2){}
//    可以看出，上面实例中的str参数是不具备默认值的。
//
//    我们可以这样使用它：
//
//    callFun("str")  // 这样是可以的，因为后面的参数都具有默认值
//    当使用非默认参数调用它时，使用起来就和Java函数一样：
//
//    callFun("str",true,2,2.0,2)   // 这样阅读性很差，因为你除了看函数的定义外，你不知道这些参数的含义
//    使用命名参数我们可以使代码更具有可读性：
//
//    callFun("str",isTrue = true,numA = 3, numB = 3.0f, numC = 3)
//    当我们不需要所有的参数时：
//
//    callFun("str",isTrue = true)
//    不过当我们使用命名参数时，虽然可以提高代码的阅读性，及在我们使用第3、4时有一个坑，就是Java中不支持这种写法的。
//    而在实际的项目开发中，几乎上都是和Java语言混用的。那么这种用法就不适合了。所有这里还是推荐使用1、2两点的用法。
//    这是只是介绍Kotlin的这种便利性而已。
//

//    3.4、可变数量参数
//    当一个函数中的参数是不定数量的个数并且是同一个类型，则可是使用vararg修饰符去修饰这个变量，则被vararg修饰的参数相当于一个固定类型的数组。
//    声明格式：fun 函数名(vararg 参数名 ： 类型，...) ：返回值{}
//    例：
//
//    fun varargFun(numA: Int, vararg str : String){
//        // ...
//    }
//    其中，既然vararg修饰的变量相当于一个固定类型的数组，则我们可以对它进行一些高级的操作。
//    这里只举例一些简单的用法，如果你有兴趣，可以参见我的另一篇文章Kotlin——高级篇（五）：集合之常用操作符汇总


//    例：
//
//    fun varargFun(numA: Int, vararg str : String){
//        // 遍历
//        for (s in str) {
//
//        }

// 获取元素
//    str[index]
//    str.component1() ... str.component5()

// 或者其高阶函数用法
//    str.map {  }
//    str.filter {  }
//    str.sortBy {  }

//    }





//    在传递参数值时，我们可以一个一个参数的传递，或者可以直接传递一个当前定义类型的数组。不过在传递数组时，请使用伸展操作符( * )。
//
//    例：
//
//    普通传递 : varargFun(1,"aaa","bbb","ccc","ddd","fff")
//    数组传递：
//    val strArray = arrayOf("aaa","bbb","ccc","ddd","fff")
//    varargFun(1,*strArray)




//    四、单表达式函数
//    上面提到了单表达式函数。这里详细的讲解一下。因为在结构体非常简单的情况下，使用单表达式函数还是能提高代码的阅读性的，并且可以少些两行代码。
//    单表达式函数：即函数具备返回值的时候，可以省略花括号并且在=赋值符号之后指定代码体，而函数的返回值是有编辑器自动推断的。
//    例：
//
//    // 无参数的情况
//    fun test1() = 2                     // 自动推断为：返回类型为Int
//
//    // 有参数的情况
//    fun test2(num : Int) = num * 2      // 自动推断为：返回类型为Int
//
//    // 或者
//    fun test3(x : Float, y : Int = 2) = x * y  // 和默认参数一起使用，返回值为Float型
//
//    fun main(args: Array<String>) {
//        println(test1())
//        println(test2(2))
//        println(test3(2f))
//    }
//    输出结果为：
//
//    2
//    4
//    4.0

//    总结
//    对于Kotlin中函数/方法的基本用法就讲解到这里，在后续的章节中，会为大家奉上函数的高级用法以及高阶函数的使用，并且会讲到其和lambda表达式的连用。
//    这一篇讲解的内容及其简单，如果您有编程经验您只要主要关注可变个数参数的函数，以及单表达式函数就可以额。








