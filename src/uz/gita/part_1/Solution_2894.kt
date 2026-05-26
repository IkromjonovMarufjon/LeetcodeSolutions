package uz.gita.part_1

fun main() {
    println(minMaxDifference(995996))
}

fun minMaxDifference(num: Int): Int {
    val list = ArrayList<Int>()
    var x = num
    while (x > 0) {
        list.add(x % 10)
        x /= 10;
    }

    list.reverse()

    var min = 0
    for (i in list.indices) {
        min = 10 * min + (if (list[0] == list[i]) 0 else list[i])
    }
    println("Min  =  $min")


    var target = -1
    for (i in 0 until list.size) {
        if (list[i] != 9 && target == -1) {
            target = list[i]
        }
    }

    var max = 0
    for (i in list.indices) {
        max = 10 * max + (if (target == list[i]) 9 else list[i])
    }

    println("Max  =  $max")

    return max - min
}

fun findGCD(nums: IntArray): Int {
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    for (num in nums) {
        min = Math.min(min, num)
        max = Math.max(max, num)
    }

    return gcd(min, max)
}

fun gcd(x: Int, y: Int) : Int {
    if (x == 0) return y
    if (y == 0) return x
    if (x == y) return x
    return if (x > y) gcd(x % y, y)
    else gcd(x, y % x)
}


fun differenceOfSums(n: Int, m: Int): Int {
    val allSum = (1 + n) * n / 2

    val count = n / m
    val target = count * m;
    val sum2 = (m + target) * count / 2

    println("all sum = $allSum")
    println("count = $count")
    println("sum2 = $sum2")

    return allSum - 2* sum2
}