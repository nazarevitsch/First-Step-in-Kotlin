package adding

import kotlin.random.Random

class Number() {

     var number: String? = null
        get() = field
        set(value) {
            field = value
        }

    constructor(number: String) : this() {
        this.number = number
    }

    constructor(number: Int) : this(){
        this.number = number.toString()
    }

    override fun toString(): String {
        return "Number(number: ${number})"
    }

    companion object {
        @JvmStatic
        fun createRandomNumber(): Number {
            return Number(Random.nextInt(0,100))
        }
    }
}