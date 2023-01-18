import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MainKtTest {
    @Test
    fun testSwapUniswapDocs() {
        //https://docs.uniswap.org/contracts/v2/concepts/core-concepts/swaps
        val reserve0 = 1200.0
        val reserve1 = 400.0
        val amount0In = 3.0
        val fee = 0.3
        val to = "someaddress"
        val result = swap(reserve0, reserve1, amount0In, fee, to)
        val expected = 0.997
        assertEquals(expected, result, 0.01) {"Swap is without fee."}
    }

    @Test
    fun testSwapMediumArticle1() {
        //https://medium.com/@chiqing/uniswap-v2-explained-beginner-friendly-b5d2cb64fe0f
        val reserve0 = 5.0
        val reserve1 = 20.0
        val amount0In = 1.0
        val fee = 0.3
        val to = "someaddress"
        val result = swap(reserve0, reserve1, amount0In, fee, to)
        val expected = 3.324995831
        assertEquals(expected, result, 0.01) {"Swap fail."}
    }

    @Test
    fun testSwapMediumArticle2() {
        //https://medium.com/@chiqing/uniswap-v2-explained-beginner-friendly-b5d2cb64fe0f
        val reserve0 = 6.0
        val reserve1 = 16.67500417
        val amount0In = 1.0
        val fee = 0.3
        val to = "someaddress"
        val result = swap(reserve0, reserve1, amount0In, fee, to)
        val expected = 2.376015315
        assertEquals(expected, result, 0.01) {"Swap fail."}
    }

    @Test
    fun testSwapRegular1() {
        //https://etherscan.io/tx/0x7f3d3b986dccf6106b4452aef0717bcba9bd77de70e1d92e0179e4bddcaba318/#eventlog
        val reserve0 = 1.8369398516488372E25
        val reserve1 = 18337980218473.0
        val amount0In = 500000000000000000000.0
        val fee = 0.3
        val to = "someaddress"
        val result = swap(reserve0, reserve1, amount0In, fee, to)
        val expected = 497660931.0
        assertEquals(expected, result, 0.01) {"Swap fail."}
    }

    @Test
    fun testSwapRegular2() {
        //https://etherscan.io/tx/0x7ca8cf4524dcd9ce0d393f040a46f7eff5a1326c20b27939786a9816dabafabc/#eventlog
        val reserve0 = 5225320397127.0
        val reserve1 = 5220339689396.0
        val amount0In = 127116799.0
        val fee = 0.3
        val to = "someaddress"
        val result = swap(reserve0, reserve1, amount0In, fee, to)
        val expected = 126617726.0
        assertEquals(expected, result, 0.01) {"Swap fail."}
    }

    @Test
    fun testSwapRegular3() {
        //https://etherscan.io/tx/0x9cc9284f3dfccb93e77fa103d6ed9454c03d906cefb9d8b008033c8313df26a1/#eventlog
        val reserve0 = 7.217643140576147E28
        val reserve1 = 1.7084177881510945E24
        val amount0In = 3.777854885154919E24
        val fee = 0.3
        val to = "someaddress"
        val result = swap(reserve0, reserve1, amount0In, fee, to)
        val expected = 8.915831283459144E19
        assertEquals(expected, result, 0.01) {"Swap fail."}
    }

    @Test
    fun testSwapRegular4() {
        //https://etherscan.io/tx/0xb7e411c4aada7e7553b7fbbcecaeec21b066f0c9a50fc7952eeccee7c7d530b8/#eventlog
        val reserve0 = 6.071992427717808E24
        val reserve1 = 1.656993341999397E19
        val amount0In = 1.8390761303386584E22
        val fee = 0.3
        val to = "someaddress"
        val result = swap(reserve0, reserve1, amount0In, fee, to)
        val expected = 5.0188219511484744E16
        assertEquals(expected, result, 0.01) {"Swap fail."}
    }

    @Test
    fun testSwapSwap() {
        //expected value set manually to pass
        val reserve0 = 5.0
        val reserve1 = 20.0
        val reserve2 = 10.0
        val reserve3 = 100.0
        val amount0In = 1.0
        val fee = 0.3
        val fee2 = 0.3
        val to = "someaddress"
        val result = swap(reserve2, reserve3, swap(reserve0, reserve1, amount0In, fee, to), fee2, to)
        val expected = 24.896850576917927
        assertEquals(expected, result, 0.01) { "Double swap failed." }
    }
}