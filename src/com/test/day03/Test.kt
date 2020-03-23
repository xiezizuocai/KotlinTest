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



fun main(args:Array<String>)
{
    var a: Byte = 2
    var b: Short = 2
    var c: Int = 2
    var d: Long = 2L         //长整型由大写字母L标记
    var e: Float = 2f        //单精度浮点型由小写字母f或大写字符F标记
    var f: Double = 2.0

    println(" a => $a \n b => $b \n c => $c \n d => $d \n e => $e \n f => $f ")
}