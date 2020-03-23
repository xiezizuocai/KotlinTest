package com.test.day02

//    kotlin变量的声明方式与Java中声明变量有很大的区别，而且必须使用var或val关键字。其中：
//
//    var: 用此关键字声明的变量表示可变变量，即可读且可写。相当于Java中普通变量
//    val: 用此关键字声明的变量表示不可变变量，即可读且不可写。相当于Java中用final修饰的变量


//    其中。var和val是Kotlin中定义变量必须使用的关键字。
//    每一行代码的结束可以省略掉分号;，这一点是和Java不同的地方。当然，第一次写可能会有一点不习惯。
//    print()与println()都是打印方法，后者打印完成之后会换一行。此两个方法和Java的打印方法是一模一样的。
//    $符号表示引用的意思。这里理解为字符串模板


fun main(args:Array<String>)
{
    //立即初始化
    var var_a: Int = 10

    //推导出类型
    var var_b = 5

    //没有初始化的时候，必须声明类型
    var var_c: Float
    var_c = 12.3f
    var_c += 1

    //println("var_a => $var_a \t var_b => $var_b \t var_a => $var_c")


    //立即初始化
    val val_a: Int = 100

    //推导出类型
    val val_b = 50

    //没有初始化的时候，必须声明类型
    val val_c: Int
    val_c = 1
    // val_c += 1  // 因为c是常量，所以这句代码是会报错的

    //println("val_a => $val_a \t val_b => $val_b \t val_c => $val_c")


    //Test1()

    //Test2()

    println("NUM_A => $NUM_A")
    println("NUM_B => ${TestConst.NUM_B}")
    println("NUM_C => ${TestClass.NUM_C}")

}



//    上面的是演示变量的基础定义。而且只有在顶层声明的情况下是可以不用实例化的。但是在实际开发当中，
//
//    一般都是在一个类中去定义变量，这种情况被称为声明类的属性。在后面Kotlin——中级篇（二）：属性与字段详解章节会详细的讲解。
//
//    这里讲解其声明的特点并实例分析。
//
//    其特点如下：必须初始化，如果不初始化，需使用lateinit关键字。


class Test1{

    // 定义属性
    var var_a : Int = 0
    val val_a : Int = 0

    // 初始化
    init {
        var_a = 10
        // val_a = 0 为val类型不能更改。

        println("var_a => $var_a \t val_a => $val_a")
    }
}


//    在Java中，当我们声明一个变量不必关心这个变量是否为空，在使用这个变量的时候几乎上都会判断其是否为空增加程序的安全性。
//
//    这样的习惯是极好的。但是无形中也增加了一定的代码量。有时候这样的代码还极有可能是无用的废代码。
//
//    然而在Kotlin中当我们可以确定这个属性或变量一定不为空时，我们就用上面讲解到的去定义变量。否则就把它声明为可空变量。
//
//    可空变量的特点：
//
//    在声明的时候一定用标准的声明格式定义。不能用可推断类型的简写。
//    变量类型后面的?符号不能省略。不然就和普通的变量没区别了。
//    其初始化的值可以为null或确定的变量值。

//    定义：
//    var/val 变量名 ： 类型? = null/确定的值


class Test2{

    // 声明可空变量

    var var_a : Int? = 0
    val val_a : Int? = null

    init {
        var_a = 10
        // val_a = 0 为val类型不能更改。

        println("var_a => $var_a \t val_a => $val_a")
    }
}



//    1.3.1、后期初始化属性
//
//    声明后期初始化属性的特点：
//
//    使用lateinit关键字
//    必须是可读且可写的变量，即用var声明的变量
//    不能声明于可空变量。
//    不能声明于基本数据类型变量。例：Int、Float、Double等，注意：String类型是可以的。
//    声明后，在使用该变量前必须赋值，不然会抛出UninitializedPropertyAccessException异常。
//    实例讲解：举一个Android中常见的例子
//
//    // 声明组件
//    private lateinit var mTabLayout : TabLayout
//
//    lateinit var a : Int // 会报错。因为不能用于基本数据类型。
//
//    // 赋值
//    mTabLayout = find(R.id.home_tab_layout)
//
//    // 使用
//    mTabLayout.setupWithViewPager(mViewPager)






//    延迟初始化属性
//
//    所谓延迟初始化即：指当程序在第一次使用到这个变量（属性）的时候在初始化。
//
//    声明延迟初始化属性的特点：
//
//    使用lazy{}高阶函数，不能用于类型推断。且该函数在变量的数据类型后面，用by链接。
//    必须是只读变量，即用val声明的变量。
//    实例讲解：同样是Android中常见的例子
//
//    // 声明一个延迟初始化的字符串数组变量
//    private val mTitles : Array<String> by lazy {
//        arrayOf(
//            ctx.getString(R.string.tab_title_android),
//            ctx.getString(R.string.tab_title_ios),
//            ctx.getString(R.string.tab_title_h5)
//        )
//    }
//
//    // 声明一个延迟初始化的字符串
//    private val mStr : String by lazy{
//        "我是延迟初始化字符串变量"
//    }




//    Kotlin之常量的用法
//    Kotlin中声明常量的方式和在Java中声明常量的方式有很大的区别。这里举例说明：
//
//    Kotlin中使用val时候对应的Java代码：
//
//    Kotlin中的 val numA = 6   等价于  Java中的：public final int numA = 6
//    很显然，Kotlin中只用val修饰还不是常量，它只能是一个不能修改的变量。那么常量怎么定义呢？其实很简单，在val关键字前面加上const关键字。
//
//    即：
//
//    const val NUM_A = 6
//    其特点：const只能修饰val，不能修饰var
//
//    声明常量的三种正确方式
//
//    在顶层声明

//    在object修饰的类中声明，在kotlin中称为对象声明，它相当于Java中一种形式的单例类

//    在伴生对象中声明




// 1. 顶层声明
const val NUM_A : String = "顶层声明"

// 2. 在object修饰的类中
object TestConst{
    const val NUM_B = "object修饰的类中"
}

// 3. 伴生对象中
class TestClass{
    companion object {
        const val NUM_C = "伴生对象中声明"
    }
}

