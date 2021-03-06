package com.test.day05


//
//    一、约定
//    所谓预定：即指Kotlin允许我们为自己的类型提供预定义的一组操作符的实现。这些操作符具有固定的符号表示（如 + 或 *)和固定的优先级。
//    为实现这样的操作符,我们为相应的操作类型提供了一个固定名字的函数。这样的技术，称为约定
//
//    因为由类实现的接口集是固定的，而Kotlin不能为了实现其他接口而修改现有的类，因此一般通过扩展函数的机制来实现为现有的类增添新的约定方法，
//    从而适应任何现有的Java类。
//
//    二、操作符与操作符重载
//    根据操作数据个数的不同，分为两种操作类型：
//
//    一元操作：即指操作数只有一个的情况
//    二元操作：即指操作数存在二两或多个的情况。特别说明：在存在多个操作数的情况下，会用复合运算或拆分为多个运算。
//    2.1、一元操作
//    一元操作:即指一个操作数的情况，
//
//    2.1.1、简单的一元操作运算
//    这里分为三种情况有三种一元操作:
//
//    + 表示为操作数实现一个正号的意思，其操作数为数值型
//    - 表示为操作数实现一个负号的意思，其操作数为数值型
//    ! 表示取反的意思，其操作数为boolean类型


fun main(args:Array<String>) {

//    var a = 1
//    var b = -2
//    var c = true
//    var d = false
//
//    // 操作符实现
//    println("+a = ${+a}\t -a = ${-a}\t !c = ${!c}")
//    println("+b = ${+b}\t -b = ${-b}\t !d = ${!d}")
//
//    // 操作符重载实现
//    println("+a = ${a.unaryPlus()}\t -a = ${a.unaryMinus()}\t !c = ${c.not()}")
//    println("+b = ${b.unaryPlus()}\t -b = ${b.unaryMinus()}\t !d = ${d.not()}")


//    2.1.2、复杂的一元操作
//    复杂的一元操作符即指，对操作数进行自增、自减操作。和Java是一样的
//
//    这里主要有4种情况：
//
//    后缀自增：表示为操作数进行自增操作，其操作数为数值型。例如：a++
//    后缀自减：表示为操作数进行自减操作，其操作数为数值型。例如：a--
//    前缀自增：表示为操作数进行自增操作，其操作数为数值型。例如：++a
//    前缀自减：表示为操作数进行自增操作，其操作数为数值型。例如：--a




//    提供一个表格直观的展示：
//
//    操作符	重载	表示
//    a++	  a.inc()	a = a.also{ a.inc() }
//    a--	  a.dec()	a = a.also{ a.dec() }
//    ++a	  a.inc()	a = a.inc().also{ a = it }
//    --a	  a.dec()	a = a.dec().also{ a = it }
//
//    解释：操作符++的重载为inc(),操作符--的重载为dec()。但是前缀操作和后缀操作是有着明显的区别的：
//
//    后缀操作是第一次调用的时候不执行自身。在第二次开始进行自增或自减操作。
//    前缀操作是第一次调用的时候就执行自增或自减操作


//    var a = 10
//    var b = 10
//    var c = 10
//    var d = 10
//
//    // 操作符实现
//    println("a++ = ${a++} \t b-- = ${b--} \t ++c = ${++c} \t --d = ${--d}")
//
//    // 操作符重载方式实现，或许你看不明白上表中代码，不过这没关系，你只要记住上面前缀与后缀操作的区别就行
//    a.also { a.inc() }
//    b.also { b.dec() }
//    c.inc().also { c = it }
//    d.dec().also { d = it }
//    println("a = $a \t b = $b \t c = $c \t d = $d")



//    2.2 二元操作
//            二元操作：即指操作数存在二两或多个的情况。
//
//    2.2.1、简单的二元操作
//    简单的二元操作有：
//
//    a + b，表示两个操作数相加，值得注意的是若某一个操作数为String类型时。其返回值为String类型，
//                当且仅当两个操作数都为数值型时，其返回值才会数值型。
//
//    a - b，表示两个操作数相减，返回值为数值型
//    a * b，表示两个操作数相乘，返回值为数值型
//    a / b，表示两个操作数相除，返回值为数值型
//    a % b，表示两个操作数相除后的余数，官方称之为模，即a模以b 。返回值为Int型
//    a .. b，表示范围（区间），这里不详细说明，在下面一点的区间操作符一起讲解。
//
//
//    这里提供一个表格直观的展示：
//
//           操作符	    重载
//            a + b	  a.plus(b)
//            a - b	  a.minus(b)
//            a * b	  a.tiems(b)
//            a / b	  a.div(b)
//            a % b	  a.rem(b) 或 a.mod(b)
//            a .. b	a.rangTo(b)
//
//    这里值得注意的是：
//    a % b的重载为a.rem()或a.mod()。不过a.mod()是Koltin1.0版本的重载方法，现在已经弃用了，Koltin1.1以及以上版本使用a.rem()重载方法

//    // 简单的二元操作
//    val a = 10
//    val b = 2
//    val c = "2"
//    val d = "Kotlin"
//
//    // 操作符实现
//    println("a + d = " + a + d)
//    println("c + d = " + c + d)
//    println("a + b = ${a + b} \t a - b = ${a - b} \t a * b = ${a * b} \t a / b = ${a / b} \t a % b = ${a % b}")
//
//    // 操作符重载实现
//    // println("a + d = ${a + d}") 错误：字符串模板限制只能为数值型
//    println("a + b = ${a.plus(b)} \t a - b = ${a.minus(b)} \t a * b = ${a.times(b)} \t a / b = ${a.div(b)} \t a % b = ${a.rem(b)}")
//    // println(a.plus(d))  错误：因为第一个操作数`a`限制了其plus()方法的参数，
//    // println(d.plus(a))  正确：因为plus()方法的参数为超（Any）类型




//
//    2.2.2、复合二元操作
//    复合的二元操作有：
//
//    a += b，表示第一个操作数的的值为第一个操作数加上第二个操作数，
//            值得注意的是若某一个操作数为String类型时。其返回值为String类型，当且仅当两个操作数都为数值型时，其返回值才会数值型。

//    a -= b，表示第一个操作数的的值为第一个操作数减去第二个操作数，返回值为数值型
//    a *= b，表示第一个操作数的的值为第一个操作数乘以第二个操作数，返回值为数值型
//    a /= b，表示第一个操作数的的值为第一个操作数除以第二个操作数，返回值为数值型
//    a %= b，表示第一个操作数的的值为第一个操作数模以第二个操作数 。返回值为Int型

//    这里提供一个表格直观的展示：
//
//    操作符	         表示	重载
//    a += b	a = a + b	a = a.plus(b)
//    a -= b	a = a - b	a = a.minus(b)
//    a *= b	a = a * b	a = a.tiems(b)
//    a /= b	a = a / b	a = a.div(b)
//    a %= b	a = a % b	a = a.rem(b)


//    var b = 2
//    var a = 10
//    var c = "Kotlin"
//
//// 主要演示字符串的+=
//    c += a                         // 等价于  c = c.plus(a)
//    print("c = $c \t")
//
//    a += b                          //等价于  a = a.plus(b)
//    print("a = $a \t")
//
//    a = 10
//    a -= b                         // 等价于  a = a.minus(b)
//    print("a = $a \t")
//
//    a = 10
//    a *= b                        //  等价于  a = a.tiems(b)
//    print("a = $a \t")
//
//    a = 10
//    a /= b                         // 等价于  a = a.div(b)
//    print("a = $a \t")
//
//    a = 10
//    a % b                        //  等价于  a = a.rem(b)
//    print("a = $a \t")


//    2.3、位运算操作
//    位运算操作：即对一个数进行位移运算。

//    2.4、区间操作
//    区间操作符：即是符号..。值得注意的是这个操作符在Java中是不存在的，且两个操作数都是整型
//
//    操作符	表示	重载
//    a .. b	a 到 b 中间的值	a.rangeTo(b)
//    这个操作符一般用于for循环中，在条件判断中偶尔也会用到。

    val a = 1
    val b = 5

    // 操作符实现
    val s = 3 in a .. b     // true,因为3在区间[1,5]之内
    println("s = $s")
    for (index in a .. b){
        print("index = $index \t")
    }

    // 操作符重载方式实现
    val t = 3 in a.rangeTo(b)
    println("t = $t")
    for (index in a.rangeTo(b)){
        print("index = $index \t")
    }

}