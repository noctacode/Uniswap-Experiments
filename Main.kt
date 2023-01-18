fun main() {
    println(swap(5.0, 20.0, 1.0, 0.3, "someaddress"))
}
fun swap(reserve0: Double, reserve1: Double, amount0In: Double, fee: Double, to: String): Double {
    return reserve1 - reserve0 * reserve1 / (reserve0 + amount0In * (1 - fee / 100))
    //return amount0In * (1 - fee / 100) * (reserve1 / reserve0)
}