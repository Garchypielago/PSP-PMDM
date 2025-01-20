package introKotlin02.ej02

import kotlin.math.pow

class Persona(var nombre:String, var peso:Double, var altura:Double) {

    fun calcIMC(): Double{
        return peso/altura.pow(2)
    }

    fun valoraIMC(): String{
        when(calcIMC()){
            in Double.MIN_VALUE..20.0 -> {
                return "por debajo de"
            }
            in 20.0..25.0->{
                return "en su"
            }
            else -> {
                return "por encima de"
            }
        }
    }

    override fun toString(): String {
        return "$nombre tiene un IMC de ${calcIMC()}, y eso implica que está ${valoraIMC()} peso ideal."
    }
}