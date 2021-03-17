import adding.Adder
import adding.Number

fun main(args: Array<String>) {

    val adder = Adder()
    val sum = adder.addTwoNumbers(Number.createRandomNumber(), Number("3"))
    println(sum)
}