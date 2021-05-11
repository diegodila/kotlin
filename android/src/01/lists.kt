package `01`

fun main() {
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("list:   ${numbers}")

    println("sorted: ${numbers.sorted()}")
    println("sorted: ${numbers.listIterator(2).toString()}")

    println("get --${numbers.getOrNull(1)}")
    println("get --${numbers.get(1)}")

    //retorna o index do numero passado
    println("${numbers.indexOf(8)}")
    println("${numbers.listIterator(1)}")
    println(numbers)
}