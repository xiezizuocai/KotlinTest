package com.test.day03


//    数值类型

//    1、Kotlin中的数字的内置类型（接近与Java），其关键字为：
//
//    Byte => 字节 => 8位
//    Short => 短整型 => 16位
//    Int => 整型 => 32位
//    Long => 长整型 => 64位
//    Float => 浮点型 => 32位
//    Double => 双精度浮点型 => 64位



//    进制数
//
//    二进制数
//    八进制数（Kotlin不支持）
//    十进制数
//    十六进制数



//    数字类型字面常量的下划线
//
//    作用：分割数字进行分组，使数字常量更易读




//    装箱与拆箱
//
//    在Kotlin中，存在数字的装箱，但是不存在拆箱。因为Kotlin是没有基本数据类型的，Kotlin是万般皆对象的原则。
//    故不存在和Java中的类似int是数据类型，Integer是整型的引用类型。
//
//    在Kotlin中要实现装箱操作。首先要了解可空引用。即类似Int?(只限数值类型)这样的。




//    两个数值的比较
//
//    判断两个数值是否相等（==）,判断两个数值在内存中的地址是否相等（===）,其实上面的装箱操作之后其内存中的地址根据其数据类型的数值范围而定。





//    转换
//
//    显式转换
//    较小的类型不会被隐式转换为更大的类型，故而系统提供了显式转换。提供的显式转换方法如下：
//    toByte() => 转换为字节型
//    toShort() => 转换为短整型
//    toInt() => 转换为整型
//    toLong() => 转换为长整型
//    toFloat() => 转换为浮点型
//    toDouble() => 转换为双精度浮点型
//    toChar() => 转换为字符型
//    toString() => 转换为字符串型






fun main(args:Array<String>)
{
    var a: Byte = 2
    var b: Short = 2
    var c: Int = 2
    var d: Long = 2L         //长整型由大写字母L标记
    var e: Float = 2f        //单精度浮点型由小写字母f或大写字符F标记
    var f: Double = 2.0

    println(" a => $a \n b => $b \n c => $c \n d => $d \n e => $e \n f => $f ")




    var g = 0x0F            //十六进制数
    var h = 0b00001011      //二进制数
    var k = 123             //十进制数
    // ps：Kotlin不支持八进制数
    println(" g => $g \n h => $h \n k => $k ")




    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    println("oneMillion => $oneMillion")
    println("creditCardNumber => $creditCardNumber")
    println("socialSecurityNumber => $socialSecurityNumber")
    println("hexBytes => $hexBytes")
    println("bytes => $bytes")



//    val numValue: Int = 123
//    //装箱的过程，其实装箱之后其值是没有变化的
//    val numValueBox: Int? = numValue
//    println("装箱后： numValueBox => $numValueBox")



    val numValue: Int = 128
    val numValueBox: Int? = numValue

    /*
        比较两个数字
     */
    var result: Boolean
    result = numValue == numValueBox
    println("numValue == numValueBox => $result")  // => true,其值是相等的

    result = numValue === numValueBox
    /*
      上面定义的变量是Int类型，大于127其内存地址不同，反之则相同。
      这是`kotlin`的缓存策略导致的，而缓存的范围是` -128 ~ 127 `。
      故，下面的打印为false
    */
    println("numValue === numValueBox => $result")




    var numA: Int = 97
    println(numA.toByte())
    println(numA.toShort())
    println(numA.toInt())
    println(numA.toLong())
    println(numA.toFloat())
    println(numA.toDouble())
    println(numA.toChar())
    println(numA.toString())



//        隐式转换
//        类型是从上下文推断出来的，即算术运算则被重载为适当的转换
    // 30L + 12 -> Long + Int => Long
    val num = 30L + 12
    print("$num\n ")



//    位运算符
//
//    Kotlin中对于按位操作，和Java是有很大的差别的。Kotlin中没有特殊的字符，但是只能命名为可以以中缀形式调用的函数，
//    下列是按位操作的完整列表(仅适用于整形（Int）和长整形（Long）)：

//    shl(bits) => 有符号向左移 (类似Java的<<)
//    shr(bits) => 有符号向右移 (类似Java的>>)
//    ushr(bits) => 无符号向右移 (类似Java的>>>)
//    and(bits) => 位运算符 and (同Java中的按位与)
//    or(bits) => 位运算符 or  (同Java中的按位或)
//    xor(bits) => 位运算符 xor (同Java中的按位异或)
//    inv() => 位运算符 按位取反 (同Java中的按位取反)

    /*
       位运算符
       支持序列如下：shl、shr、ushr、and、or、xor
    */
    var operaNum: Int = 4

    var shlOperaNum = operaNum shl(2)
    var shrOperaNum = operaNum shr(2)
    var ushrOperaNum = operaNum ushr(2)
    var andOperaNum = operaNum and(2)
    var orOperaNum = operaNum or(2)
    var xorOperaNum = operaNum xor(2)
    var invOperaNum = operaNum.inv()

    println("shlOperaNum => $shlOperaNum \n " +
            "shrOperaNum => $shrOperaNum \n " +
            "ushrOperaNum => $ushrOperaNum \n " +
            "andOperaNum => $andOperaNum \n " +
            "orOperaNum => $orOperaNum \n " +
            "xorOperaNum => $xorOperaNum \n " +
            "invOperaNum => $invOperaNum")



//    布尔类型（Boolean）
//    1、关键字
//
//    Boolean关键字表示布尔类型，并且其值有true和false
//
//    例：

    var isNum: Boolean
    isNum = false
    println("isNum => $isNum\n")



//
//    逻辑操作符（与Java相同）
//
//    ' || ' => 逻辑或（或者）
//    ' && ' => 逻辑与（并且）
//    ' ! ' => 逻辑非（取反）


    /*
    操作运算符
    ' || ' => 逻辑或（或者）
    ' && ' => 逻辑与（并且）
    ' ! ' => 逻辑非（取反）
    */
    var aa: Boolean = false
    var bb: Boolean = true
    var res: Boolean

    /* 逻辑或操作 */
    if (aa || bb){
        result = aa || bb
        println("aa || bb => $result")
    }

    /* 逻辑与操作 */
    //if (aa && bb){
        result = aa && bb
        println("aa && bb => $result")
    //}

    /* 逻辑非操作 */
    result = !aa
    println("!aa => $result")

    result = !bb
    println("!bb => $result")


//    字符型（Char）
//    1、关键字
//
//    Char为表示字符型，字符变量用单引号（‘ ’）表示。并且不能直接视为数字，不过可以显式转换为数字。
    var char1: Char
    char1 = 'a'
    //char1 = 1        => 这句代码会直接出错
    println("char1 => $char1")



//    显示转换为其他类型
//
//    字符型的变量不仅可以转换为数字，同时也可转换为其他类型
    var var1 = char1.toByte()
    var var2 = char1.toInt()
    var var3 = char1.toString()
    var var4 = char1.toFloat()
    var var5 = char1.toShort()
    println("var1 => $var1 \n var2 => $var2 \n var3 => $var3 \n var4 => $var4 \n var5 => $var5")


//    除了可以转换类型外，当变量为英文字母时还支持大小写转换。
/*
   当字符变量为英文字母时，大小写的转换
*/
    var charA: Char = 'a'
    var charB: Char = 'B'
    var charNum: Char = '1'
    var result1: Char

    // 转换为大写
    result1 = charA.toUpperCase()
    println("result1 => $result1")

    // 转换为小写
    result1 = charB.toLowerCase()
    println("result1 => $result1")

    //当字符变量不为英文字母时，转换无效
    result1 = charNum.toLowerCase()
    println("result1 => $result1")




//    字符转义
//    同Java一样，使用某些特殊的字符时，要使用转义。下列是支持的转义序列：
//
//    \t => 表示制表符
//    \n => 表示换行符
//    \b => 表示退格键（键盘上的Back建）
//    \r => 表示键盘上的Enter键
//    \\ => 表示反斜杠
//    \' => 表示单引号
//    \" => 表示双引号
//    \$ => 表示美元符号，如果不转义在kotlin中就表示变量的引用了
//    其他的任何字符请使用Unicode转义序列语法。例：'\uFF00'

    println("\n  换行符")
    println("\t  制表符")
    println(" \b  退格键")
    println("\r  Enter键同样换行")
    println('\\')
    println('\'')
    println('\"')
    println('\$')
    println('\uFF01')



//    字符串类型（String）
//    1、关键字
//
//    String表示字符串类型。其是不可变的。所以字符串的元素可以通过索引操作的字符：str[index]来访问。可以使用for循环迭代字符串：
//    其中str[index]中的str为要目标字符串，index为索引

    val str: String = "kotlin"
    println("str => $str")

    //迭代
    for (s in str){
        print(s)
        print("\t")
    }


//    字符串字面量
//
//    在Kotlin中， 字符串字面量有两种类型：
//
//    包含转义字符的字符串 转义包括（\t、\n等）,不包含转义字符串的也同属此类型
//    包含任意字符的字符串 由三重引号（""" .... """）表示

    // 类型1：
    var str1: String = "hello\t\tkotlin"
    println(str1)
    str1 = "hello kotlin"
    println(str1)

    // 类型2：
    val str2 = """ fun main(args: Array<String>){
    println("我是三重引号引用的字符串，我可以包含任意字符")
    } \n\t"""

    println(str2)



//    可以使用trimMargin()函数删除前导空格 ，默认使用符号(|)作为距前缀，当然也可以使用其他字符。例：右尖括号（> ）、左尖括号（<）等。
    val str3: String = """
        > I`m like Kotlin .
        > I`m like Java .
        > I`m like Android .
        > I`m like React-Native.
        """.trimMargin(">")

    println(str3)




//    字符串模板
//
//    使用字符串模板的符号为（$）。在$符号后面加上变量名或大括号中的表达式

    val text1: String = "我来了！"
    var text2: String = "$text1 kotlin"
    var text3: String = "$text2 ${text1.length} 哈哈！！！！"
    println(text1)
    println(text2)
    println(text3)



//    数组型（Array）
//    Kotlin中数组由Array<T>表示，可以去看看源码实现，里面就几个方法
//            创建数组的3个函数
//
//    arrayOf()
//    arrayOfNulls()
//    工厂函数（Array()）


//    1、arrayOf()
//
//    创建一个数组，参数是一个可变参数的泛型对象
//
//    例：

    var arr1 = arrayOf(1,2,3,4,5) //等价于[1,2,3,4,5]
    for (v in arr1){
        print(v)
        print("\t")
    }

    var arr2 = arrayOf("0","2","3",'a',32.3f)
    for (v in arr2){
        print(v)
        print("\t")
    }


//    2、arrayOfNulls()
//
//    用于创建一个指定数据类型且可以为空元素的给定元素个数的数组
//
//    例：
    var arr3 = arrayOfNulls<Int>(3)

    //如若不予数组赋值则arr3[0]、arr3[1]、arr3[2]皆为null
    for(v in arr3){
        print(v)
        print("\t")
    }

    println()

    //为数组arr3赋值
    arr3[0] = 10
    arr3[1] = 20
    arr3[2] = 30

    for(v in arr3){
        print(v)
        print("\t")
    }



//    3、工厂函数
//
//    使用一个工厂函数Array()，它使用数组大小和返回给定其索引的每个数组元素的初始值的函数。
//    Array() => 第一个参数表示数组元素的个数，第二个参数则为使用其元素下标组成的表达式
//    例：
    //                        0         4*2
    var arr4 = Array(5,{index -> (index * 2).toString() })
    for (v in arr4){
        print(v)
        print("\t")
    }





//    原始类型数组
//
//    Kotlin还有专门的类来表示原始类型的数组，没有装箱开销，它们分别是：
//
//    ByteArray => 表示字节型数组
//    ShortArray => 表示短整型数组
//    IntArray => 表示整型数组
//    LongArray => 表示长整型数组
//    BooleanArray => 表示布尔型数组
//    CharArray => 表示字符型数组
//    FloatArray => 表示浮点型数组
//    DoubleArray => 表示双精度浮点型数组
//    PS: Kotlin中不支持字符串类型这种原始类型数组，可以看源码Arrays.kt这个类中并没有字符串数组的声明。而源码中StringArray.kt这个类并不是声明字符串型数组的。
//
//    下面的例子只演示了几种，其他的类似。
//    例：
    var intArr: IntArray = intArrayOf(1,2,3,4,5)
    for (number in intArr){
        print(number)
        print("\t")
    }

    println()

    var charArr: CharArray = charArrayOf('a','1','b','c','3','d')
    for (char in charArr){
        print(char)
        print("\t")
    }

    println()

    var longArr: LongArray = longArrayOf(12L,1254L,123L,111L)
    for (long in longArr){
        print(long)
        print("\t")
    }



}