package com.test.day04





fun main(args:Array<String>)
{

//    if语句
//    在Kotlin中的if语句和Java还是还是有一定的区别的，它能在Java中更灵活，除了能实现Java写法外，
//    还可以实现表达式（实现三元运算符），及作为一个块的运用。

//    1、传统写法（同Java写法一样）
//    例：

//    var numA = 2
//    if (numA == 2){
//        println("numA == $numA => true")
//    }else{
//        println("numA == $numA => false")
//    }


//    Kotlin中的三元运算符
//
//    在Kotlin中其实是不存在三元运算符(condition ? then : else)这种操作的。
//    那是因为if语句的特性(if表达式会返回一个值)故而不需要三元运算符。

// 在Java中可以这么写，但是Kotlin中直接会报错。
// var numB: Int = (numA > 2) ? 3 : 5

// kotlin中直接用if..else替代。例：
//    var numB: Int = if ( numA > 2 ) 3 else 5  // 当numA大于2时输出numB的值为3，反之为5
//    println("numB = > $numB")



//    3、作为一个块结构，并且最后一句表达式为块的值(重点!)
//
//    例：

    var numA: Int = 2
    var numC: Int = if (numA > 2){
        numA++
        numA = 10
        println("numA > 2 => true")
        numA
    }else if (numA == 2){
        numA++
        numA = 20
        println("numA == 2 => true")
        numA
    }else{
        numA++
        numA = 30
        println("numA < 2 => true")
        numA
    }

// 根据上面的代码可以看出，每一个if分支里面都是一个代码块，并且返回了一个值。根据条件numC的值应该为20
    println("numC => $numC")




//    二、for语句
//    Kotlin废除了Java中的for(初始值;条件；增减步长)这个规则。但是Kotlin中对于for循环语句新增了其他的规则，来满足刚提到的规则。
//    for循环提供迭代器用来遍历任何东西
//    for循环数组被编译为一个基于索引的循环，它不会创建一个迭代器对象

//    1、新增的规则，去满足for(初始值;条件;增减步长)这个规则
//
//    1.1、递增
//    关键字：until
//    范围：until[n,m) => 即大于等于n,小于m
//
//    例：
    // 循环5次，且步长为1的递增
    for (i in 0 until 5){
        print("i => $i \t")
    }


//    1.2、递减
//    关键字：downTo
//    范围：downTo[n,m] => 即小于等于n,大于等于m ,n > m
//    例：

    // 循环5次，且步长为1的递减
    for (i in 15 downTo 11){
        print("i => $i \t")
    }




//    1.3、符号（' .. ' ） 表示递增的循环的另外一种操作
//
//    使用符号( '..').
//        范围：..[n,m]=> 即大于等于n，小于等于m
//    和until的区别，一是简便性。二是范围的不同。

    print("使用 符号`..`的打印结果\n")
    for (i in 20 .. 25){
        print("i => $i \t")
    }

    println()

    print("使用until的打印结果\n")
    for (i in 20 until 25){
        print("i => $i \t")
    }



//    1.4、设置步长
//
//    关键字：step
//
//    例：

    println()
    for (i in 10 until 16 step 2){
        print("i => $i \t")
    }




//    2、迭代
//
//    for循环提供一个迭代器用来遍历任何东西。
//    for循环数组被编译为一个基于索引的循环，它不会创建一个迭代器对象


//    2.1、遍历字符串
//    此用法在数据类型章节中的字符串类型中用到过

    println()
    for (i in "abcdefg"){
        print("i => $i \t")
    }


//    2.2、遍历数组
//
//    此用法在数据类型章节中的数组类型中用到过。还不甚清楚的可以查看Kotlin——初级篇（三）：数据类型详解。
//    例：

    var arrayListOne = arrayOf(10,20,30,40,50)

    println()
    for (i in arrayListOne){
        print("i => $i \t")
    }

//
//    2.3、使用数组的indices（index的复数）属性遍历
//
//    例：

//    var arrayListTwo = arrayOf(1,3,5,7,9)
//    for (i in arrayListTwo.indices){
//        println("arrayListTwo[$i] => " + arrayListTwo[i])
//    }


//    2.4、使用数组的withIndex()方法遍历
//
//    例：
    var arrayListTwo = arrayOf(1,3,5,7,9)

    println()
    for ((index,value) in arrayListTwo.withIndex()){
        println("index => $index \t value => $value")
    }


    println()
//    使用列表或数组的扩展函数遍历
//
//    数组或列表有一个成员或扩展函数iterator()实现了Iterator<T>接口，且该接口提供了next()与hasNext()两个成员或扩展函数
//            其一般和while循环一起使用
//    可以查看Array.kt这个类。可以看见其中的iterator()函数，而这个函数实现了Iterator接口。
//
//    /**
//     *   Creates an iterator for iterating over the elements of the array.
//     */
//    public operator fun iterator(): Iterator<T>
//    查看Iterator.kt这个接口类，这个接口提供了hasNext()函数和next()函数。
//
//    public interface Iterator<out T> {
//
//        /**
//         * Returns the next element in the iteration.
//         */
//        public operator fun next(): T
//
//        /**
//         * Returns `true` if the iteration has more elements.
//         */
//        public operator fun hasNext(): Boolean
//    }
//    例：

    var arrayListThree = arrayOf(2,'a',3,false,9)
    var iterator: Iterator<Any> = arrayListThree.iterator()

    while (iterator.hasNext()){
        println(iterator.next())
    }




//    三、when语句
//    在Kotlin中已经废除掉了Java中的switch语句。而新增了when(exp){}语句。
//    when语句不仅可以替代掉switch语句，而且比switch语句更加强大

//    3.1、when语句实现switch语句功能
//    例：
    when(5){
        1 -> {
            println("1")
        }
        2 -> println("2")
        3 -> println("3")
        5 -> {
            println("5")
        }
        else -> {
            println("0")
        }
    }


//    3.2、和逗号结合使用，相当于switch语句中的不使用break跳转语句
//    例：

    when(1){
        // 即x = 1,2,3时都输出1。
        1 , 2 , 3 -> {
            println("1")
        }
        5 -> {
            println("5")
        }
        else -> {
            println("0")
        }
    }



//    3.3、条件可以使用任意表达式，不仅局限于常量
//
//    相当于if表达式的用法。
//    例：

    var num:Int = 5
    when(num > 5){
        true -> {
            println("num > 5")
        }
        false ->{
            println("num < 5")
        }
        else -> {
            println("num = 5")
        }
    }




//    3.4、 检查值是否存在于集合或数组中
//
//    操作符：
//    （in） 在
//    (!in) 不在
//    限定:只适用于数值类型

    var arrayList = arrayOf(1,2,3,4,5)
    when(1){
        in arrayList.toIntArray() -> {
            println("1 存在于 arrayList数组中")
        }

        in 0 .. 10 -> println("1 属于于 0~10 中")

        !in 5 .. 10 -> println("1 不属于 5~10 中")

        else -> {
            println("都错了 哈哈！")
        }
    }


//    3.5、检查值是否为指定类型的值
//
//    操作符
//    是（is）
//    不是（!is）
//    值得注意的是，Kotlin的智能转换可以访问类型的方法和属性
//    例：

    when("abc"){
        is String -> println("abc是一个字符串")
        else -> {
            println("abc不是一个字符串")
        }
    }

    // 智能转换
    var a: Int = 2
    when(a){
        !is Int -> {
            println("$a 不是一个Int类型的值")
        }
        else -> {
            a = a.shl(2)
            println("a => $a")
        }
    }


//    3.6、不使用表达式的when语句
//
//    表示为最简单的布尔表达式
//
//    例：

    var array = arrayOfNulls<String>(3)
    when{
        true -> {
            for (i in array){
                print(" $i \t")
            }
            println()
        }
        else -> {

        }
    }

//    综上所述，为Kotlin中when控制语句的常见用法。可以看出它的强大。以及便利性。不仅可以替代掉Java语句中的swicth语句。甚至可以替换掉if语句。



//    while语句
//    其同Java中的while循环一样
//
//    do...while语句
//    其同Java中的do...while循环一样
//
//    跳转语句（return、break、continue）
//    其同Java中的跳转语句一样。



}
