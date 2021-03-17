package adding

import exception.IllegalNumberExceptionNull
import exception.IllegalNumberExceptionUnparsedDouble
import exception.ObjectNumberIsNullException
import java.lang.Exception

class Adder : Adderable {

    override fun addTwoNumbers(n1: Number?, n2: Number?): Double {
        checkObjectsAreNotNUL(n1, n2)
        val list: Array<Number?> = arrayOf(n1, n2)
        checkArgumentsIsNotNULL(list)
        val listDouble: ArrayList<Double> = listNumberStringsToDouble(list)
        return recursiveSum(listDouble);
    }

    private fun recursiveSum(list: ArrayList<Double>) : Double {
        return if (list.isEmpty()) 0.0 else  list.removeAt(0) + recursiveSum(list)
    }

    private fun listNumberStringsToDouble(list: Array<Number?>): ArrayList<Double> {
        val result: ArrayList<Double>
        try {
            result = ArrayList(list.map { element -> element!!.number!!.toDouble() })
        } catch (e: Exception){
            throw IllegalNumberExceptionUnparsedDouble()
        }
        return result
    }

    private fun checkArgumentsIsNotNULL(list: Array<Number?>) {
        val flag: Boolean = check(list)
        if (!flag) throw IllegalNumberExceptionNull()
    }

    private fun check(list: Array<Number?>): Boolean {
        for (n: Number? in  list){
            when(n!!.number) {
                null -> return false
            }
        }
        return true
    }

    private fun checkObjectsAreNotNUL(vararg elements: Number?){
        var i: Int = 0
        while (i < elements.size){
            if (elements[i] == null) throw ObjectNumberIsNullException()
            i++
        }
    }
}