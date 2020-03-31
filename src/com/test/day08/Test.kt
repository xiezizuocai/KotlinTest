package com.test.day08


//
//    一、字符串查找
//    字符串查找功能在实际开发中，只会用到几个简单的函数，这里我只说明几个常用的。

//    1.1、获取第一个元素
//    val str = "kotlin very good"
//    str.first()   <=>   str[0]   <=>   str.get(0)



//    其还实现了查找等于某一个字符的第一个元素,即first{}高阶函数
//    val str = "kotlin very good"
//    // 如果未查找到满足条件的元素，会抛出NoSuchElementException异常
//    str.first{ it == 'o' }


//    还有一个firstOrNull()函数，它和first()函数的区别在于如果字符串为空串时，first()函数会抛出异常，
//    而firstOrNull()函数会返回null。当然还有firstOrNull{}函数，它和first{}函数的区别在于如果字符串为空串时，
//    first{}函数会抛出异常，而firstOrNull{}函数会返回null

//    1.2、 获取最后一个元素
//    val str = ...
//    str.last()   <==>   str.get(lastIndex)   <==>  str[lastIndex]

//    其中 lastIndex 是一个拓展属性，其实现是 length - 1


//    同时还实现了查找等于某一个字符的最后一个元素,即last{}高阶函数
//    val str = "kotlin very good"
//    // 如果未查找到满足条件的元素，会抛出NoSuchElementException异常
//    str.last{ it == 'o' }   // 其实从源码中我们发现其是对原字符串反转之后再进行遍历查找满足条件的元素。


//    lastOrNull()同firstOrNUll()一样。lastOrNull{}同firstOrNUll{}一样。


//    1.3、查找元素
//    其实查找元素提供了两个高阶函数find{}、findLast{}。不过他们都是对firstOrNull()或lastOrNull()函数进行处理。这里不多作累述。


//    1.3、 查找对应元素的下标
//    这里提供查找对应元素下标的几个函数：
//
//    indexOf() : 查找某一个元素或字符串在原字符串中第一次出现的下标。
//    indexLastOf() : 查找某一个元素或字符串在原字符串中最后一次出现的下标。
//    indexOfFirst{} : 同indexOf()
//    indexOfLast{} : 同indexLastOf()
//
//    例：
//    println(str.indexOfFirst { it == 'o' })
//    println(str.indexOfLast { it == 'o' })
//    println(str.indexOf('o',0))
//    println(str.indexOf("very",0))
//    println(str.lastIndexOf('o'))
//    println(str.lastIndexOf("good"))




fun main(args:Array<String>) {


//    val str = "kotlin very good"
//
//    println(str.first())
//    println(str[0])
//    println(str.get(0))
//
//    println(str.last())
//    println(str.get(str.lastIndex) )
//    println(str[str.lastIndex])
//
//    println(str.indexOfFirst { it == 'o' })
//    println(str.indexOfLast { it == 'o' })
//    println(str.indexOf('o',0))
//    println(str.indexOf("very",0))
//    println(str.lastIndexOf('o'))
//    println(str.lastIndexOf("good"))



//    二、字符串截取
//    如果你有Java或者其他语言的编程基础。相信您对字符串的截取应该不会陌生。您可以继续的往下看，就当作是对字符串截取只是的一个巩固。
//    当然，您也可以直接的跳过本节内容，因为在Kotlin中，字符串的截取的函数subString()是调用了Java中的subString()函数。

//    在Kotlin中除了调用subString()函数外，还可以调用subSequence()函数，有兴趣的朋友可以去看看源码。

//    2.1、 用subString()函数截取

//    我们看一看subString()函数的源码

//    @kotlin.internal.InlineOnly
//    public inline fun String.substring(startIndex: Int): String = (this as java.lang.String).substring(startIndex)
//
//    @kotlin.internal.InlineOnly
//    public inline fun String.substring(startIndex: Int, endIndex: Int): String
//            = (this as java.lang.String).substring(startIndex, endIndex)
//
//    public fun String.substring(range: IntRange): String = substring(range.start, range.endInclusive + 1)
//

//    从以上的源码中我们可以看出，Kotlin中是使用了Java中的subString()函数
//    其中：

//    startIndex参数：截取字符串的开始下标
//    endIndex参数：截取字符串的结束下标
//    rang参数，是指一个IntRang类型


//    val str = "Kotlin is a very good programming language"
//
//    println("s = ${str.substring(10)}")  // 当只有开始下标时，结束下标为length - 1
//    println(str.substring(0,15))
//    println(str.substring(IntRange(0,15)))

//    使用subString(startIndex,endIndex)和subString(rang)时的区别。可以从上边的结果结合源码可以看出来。
//    切记下标越界的情况。即StringIndexOutOfBoundsException异常


//
//    2.2、用subSequence()函数截取
//    在Kotlin中除了使用上面讲解到的使用subString()截取字符串外，还可以使用subSequence()函数截取。
//
//    我们看一看其源码实现：
//
//    public fun subSequence(startIndex: Int, endIndex: Int): CharSequence
//
//    public fun CharSequence.subSequence(range: IntRange): CharSequence = subSequence(range.start, range.endInclusive + 1)
//

//    从源码中我们可以看出，其大致和subString()函数一样，但是其不提供只传递startIndex的情况


//   val str = "Kotlin is a very good programming language"
//
//    println(str.subSequence(0,15))
//    println(str.subSequence(IntRange(0,15)))


//
//
//    三、字符串替换

//    同上述字符串截取一样，如果您有编程经验，可跳过此节。不过对于字符串替换功能，Kotlin除了实现Java中的replace()ha函数外，
//    还提供了另外的replaceFirst()、replaceAfter()、replaceBefore()、replaceIndent()、等函数。下面会对这些函数意义进行实例讲解。

//    3.1、replace()函数
//    replace()函数提供了4个重载函数。他们能实现不同的功能

//    3.1.1、 replace(oldChar,newChar,ignoreCase = false)
//    其中：
//
//    作用 ： 把原字符串中的某一个字符全部替换成新的字符。然后返回新的字符串
//    参数说明：

//    oldChar: 需要替换的字符
//    newChar: 新的字符
//    ignoreCase : 是否引用Java中的replace()函数。默认值为false，即用Java的replace()函数
//

    // 把字符`a`全部替换为`A`
//    val str = "Kotlin is a very good programming language"
//    println(str.replace('a','A'))
//
//
//
//    3.1.2、 replace(oldValue,newValue,ignoreCase = false)
//    其中：
//
//
//    作用 ： 把原字符串中的某一个字符全部替换成新的字符。然后返回新的字符串
//    参数说明：
//
//
//
//    oldValue: 需要替换的字符串
//    newValue: 新的字符串
//    ignoreCase : 是否引用Java中的replace()函数。默认值为false，即用Java的replace()函数


    // 把字符串`Kotlin`替换成字符串`Java`
    val str = "Kotlin is a very good programming language"
    println(str.replace("Kotlin","Java"))


}