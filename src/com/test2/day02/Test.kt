package com.test2.day02

//    一、属性的基础使用
//    一个类中是可以存在属性的，一个属性可以用val或者var修饰。
//
//    用val修饰符修饰的属性是只读的，即不能被修改，只可使用
//    用var修饰符修饰的属性是可读写的，即能用能改
//    例：

//    class Mime{
//        val id : String = "123"
//        var name : String? = "kotlin"
//        var age : Int? = 22
//        var sex : String? = "男"
//        var weight : Float = 120.3f
//
//        var test : String = ""
//        get() = "123"
//        set(value){field = value}
//    }
//
//    fun main(args: Array<String>) {
//        val mime = Mime()
//        println("id = ${mime.id} \t name = ${mime.name} \t age = ${mime.age} \t sex = ${mime.sex} \t weight = ${mime.weight}")
//
//    }



//
//    二、Getter()与Setter()

//    getter()对应Java中的get()函数，setter()对应Java中的set()函数。不过注意的是，不存在Getter()与Setter()的，这只是Kotlin中的叫法而已，
//    真是的写法，还是用get()、set()。可以看下面的例子。

//    在Kotlin中，普通的类中一般是不提供getter()与setter()函数的，因为在普通的类中几乎用不到，这一点和Java是相同的，
//    但是Java中在定义纯粹的数据类时，会用到get()与set()函数，但是Kotlin专门这种情况定义了数据类,这个特征。
//    而数据类是系统已经为我们实现了get()和set()函数。
//    这里为大家演示getter()与setter()
//
//    class Test{
//
//        /*
//         * getter 和 setter是可选的
//         */
//
//        // 当用var修饰时，必须为属性赋默认值(特指基本数据类型，因为自定义的类型可以使用后期初始化属性，见后续)
//        即使在用getter()的情况下,不过这样写出来，不管我们怎么去改变其值，其值都为`123`

//        var test1 : String = ""
//        get() = "123"
//        set(value){field = value}
//
//        // 用val修饰时，用getter()函数时，属性可以不赋默认值。但是不能有setter()函数。
//        val test2 : String
//        get() = "123"       // 等价于：val test2 : String = "123"
//    }

//    注意： 请认真看上面的注释......
//
//    在上面的代码中出现了set(value){field = value}这样的一句代码。其中value是Koltin写setter()函数时其参数的约定俗成的习惯。
//    你也可以换成其他的值。而field是指属性本身。


//
//    2.1、自定义
//    这里讲解属性的自定义getter()与setter()。由上面可知，使用val修饰的属性，是不能有setter()的。
//    而使用var修饰的属性可以同时拥有自定义的getter()与setter()。通过两个实例来说明:
//
//    例1：用val修饰的属性自定义情况


//    class Mime{
//        // size属性
//        private val size = 0
//
//        // 即isEmpty这个属性，是判断该类的size属性是否等于0
//        val isEmpty : Boolean
//            get() = this.size == 0
//
//        // 另一个例子
//        val num = 2
//            get() = if (field > 5) 10 else 0
//    }
//
//    // 测试
//    fun main(args: Array<String>) {
//        val mime = Mime()
//        println("isEmpty = ${mime.isEmpty}")
//        println("num = ${mime.num}")
//    }




//    例2：用var修饰的属性自定义情况

class Mime{

    var str1 = "test"
        get() = field   // 这句可以省略，kotlin默认实现的方式
        set(value){
            field = if (value.isNotEmpty()) value else "null"
        }

    var str2 = ""
        get() = "随意怎么修改都不会改变"
        set(value){
            field = if (value.isNotEmpty()) value else "null"
        }
}

// 测试
fun main(args: Array<String>) {
    val mime = Mime()

    println("str = ${mime.str1}")
    mime.str1 = ""
    println("str = ${mime.str1}")
    mime.str1 = "kotlin"
    println("str = ${mime.str1}")

    println("str = ${mime.str2}")
    mime.str2 = ""
    println("str = ${mime.str2}")
    mime.str2 = "kotlin"
    println("str = ${mime.str2}")
}


//    经过上面的实例，我总结出了以下几点：
//
//    使用了val修饰的属性，不能有setter().
//    不管是val还是var修饰的属性，只要存在getter(),其值再也不会变化
//    使用var修饰的属性，可以省略掉getter(),不然setter()毫无意义。当然get() = field除外。而get() = field是Koltin默认的实现，是可以省略这句代码的。
//    故而，在实际的项目开发中，这个自定义的getter与setter的意义不是太大。


//
//
//    2.2、修改访问器的可见性
//    如果您对Kotlin中的可见性修饰符还不了解的话，请参见Kotlin——中级篇（三）：可见性修饰符详解
//
//    修改属性访问器在实际的开发中其实也没有太大的作用，下面举个例子就明白了：
//
//    例：
//
//    var str1 = "kotlin_1"
//        private set         // setter()访问器的私有化，并且它拥有kotlin的默认实现
//
//    var test : String?
//        @Inject set         // 用`Inject`注解去实现`setter()`
//
//    val str2 = "kotlin_2"
//        private set         // 编译错误，因为val修饰的属性，不能有setter
//
//    var str3 = "kotlin_3"
//        private get         // 编译出错，因为不能有getter()的访问器可见性
//
//    fun main(args: Array<String>) {
//        // 这里伪代码
//        str1 = "能不能重新赋值呢？"     // 编译出错，因为上面的setter是私有的
//    }

//    如果，属性访问器的可见性修改为private或者该属性直接使用private修饰时，我们只能手动提供一个公有的函数去修改其属性了。就像Java中的Bean的setXXXX()



//
//
//
//    三、后备字段

//    Kotlin的类不能有字段。 但是，有时在使用自定义访问器时需要有一个后备字段。为了这些目的，Kotlin提供了可以使用字段标识符访问的自动备份字段
//
//    例：
//
//    var count = 0   // 初始化值会直接写入备用字段
//        set(value){
//            field = if(value > 10) value else 0  // 通过field来修改属性的值。
//        }


//    注意：
//
//    field标识符只能在属性的访问器中使用。这在上面提到过
//    如果属性使用至少一个访问器的默认实现，或者自定义访问器通过field标识符引用它，则将为属性生成后备字段。
//    看上面的例子，使用了getter()的默认实现。又用到了field标识符。
//
//    例：不会生成后备字段的属性
//
//    val size = 0
//
//    /*
//        没有后备字段的原因：
//        1. 并且`getter()`不是默认的实现。没有使用到`field`标识符
//        2. 使用`val`修饰，故而不存在默认的`setter()`访问器，也没有`field`修饰符
//    */
//    val isEmpty ：Boolean
//    get() = this.size == 0
//    不管是后备字段或者下面的后备属性，都是Kotlin对于空指针的一种解决方案，可以避免函数访问私有属性而破坏它的结构。
//
//    这里值得强调的一点是，setter()中


//
//
//    四、后备属性
//    所谓后备属性，其实是对后备字段的一个变种，它实际上也是隐含试的对属性值的初始化声明，避免了空指针。
//
//    我们根据一个官网的例子，进行说明：
//
//    private var _table: Map<String, Int>? = null

//    public val table: Map<String, Int>
//        get() {
//            if (_table == null) {
//                _table = HashMap() // 初始化
//            }
//            // ?: 操作符，如果_table不为空则返回，反之则抛出AssertionError异常
//            return _table ?: throw AssertionError("Set to null by another thread")
//        }

//    从上面的代码中我们可以看出：_table属性是私有的，我们不能直接的访问它。故而提供了一个公有的后备属性（table）去初始化我们的_table属性。
//
//    通俗的讲，这和在Java中定义Bean属性的方式一样。因为访问私有的属性的getter和setter函数，会被编译器优化成直接反问其实际字段。因此不会引入函数调用开销。
//
//    五、编译时常数
//    在开发中，难免会遇到一些已经确定的值的量。在Java中，我们可以称其为常量。在kotlin中，我们称其为编译时常数。我们可以用const关键字去声明它。其通常和val修饰符连用
//
//    关键字：const
//    满足const的三个条件：
//    对象的顶层或成员，即顶层声明。
//    初始化为String类型或基本类型的值
//    没有定制的getter()
//    例：
//
//    const val CONST_NUM = 5
//    const val CONST_STR = "Kotlin"
//    关于编译时常数这个知识点更详细的用法，我在讲解讲解变量的定义这一章节时，已经详细讲解过了。这里不做累赘。



//
//
//    六、后期初始化属性

//    通常，声明为非空类型的属性必须在构造函数中进行初始化。然而，这通常不方便。例如，可以通过依赖注入或单元测试的设置方法初始化属性。
//    在这种情况下，不能在构造函数中提供非空的初始值设置，但是仍然希望在引用类的正文中的属性时避免空检查。故而，后期初始化属性就应运而生了。
//
//    关键字 ： lateinit
//    该关键字必须声明在类的主体内，并且只能是用var修饰的属性。并且该属性没有自定义的setter()与getter()函数。
//    该属性必须是非空的值，并且该属性的类型不能为基本类型。
//    例：
//
//    class Test{
//        // 声明一个User对象的属性
//        lateinit var user : User
//
//        /*
//            下面的代码是错误的。因为用lateinit修饰的属性，不能为基本类型。
//            这里的基本类型指 Int、Float、Double、Short等，String类型是可以的
//        */
//        // lateinit var num : Int
//    }
//    关于后期初始化属性这一个知识点，我在讲解讲解变量的定义这一章节时，已经详细讲解过了。这里不做累赘。不过关于这一知识点，一般都是在Android开发中或者在依赖注入时会用到。
//
//    您可以参见我的Kotlin——初级篇（二）：变量、常量、注释这一篇文章
//
//    七、委托属性
//    要想把委托属性这一个知识点详细的讲解明白。以及它的实现与实例都要花上很大的篇幅去讲解。我会单独抽出一篇文章去讲解它，故而这里就不做累述了。您可以参见文章Kotlin——高级篇（八）：委托与委托属性详解
//
//    总结
//    在一些文章或者书籍里面，关于Kotlin属性/字段的讲解，不会有这么多的知识点，并且我们在实际开发中，也有一些知识点很少去用到。这里大家主要去理解与实践属性的基本使用与定义、Getter()与Setter()、后期初始化属性、以及编译时常数这几个点就可以了。
//
//
//
//
//