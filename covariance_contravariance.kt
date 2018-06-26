
/**
 * Created by raibito on 2018/06/26.
 */

// 共変 -> プロデューサ   提供(戻り値に使う)だけする、消費(引数として使用)できない
class MyListOut<out T>(value: T) {
    val value: T= value
        get() = field   //  valはgetだけ持つ(提供だけする)ため、共変
}

// 反変 -> コンシューマ  消費(引数として使用)だけする、提供(戻り値に使う)できない
class MyListIn<in T>{
    fun print(value :T){ // valもvarもget(提供)は持つため、Tは引数としてしか使えない
        println(value)
    }
}


fun main(args: Array<String>) {
    // 共変　out
    val anyList1: MyListOut<Any> = MyListOut<String>("test1")
    val any: Any = anyList1.value // 提供はOK
    println(any)

    // 反変  in
    val anyList2: MyListIn<String> = MyListIn<Any>()
    anyList2.print("test2")  // 消費はOK
}
