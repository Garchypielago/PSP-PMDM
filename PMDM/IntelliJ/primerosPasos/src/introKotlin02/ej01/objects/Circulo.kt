package introKotlin02.ej01.objects

import introKotlin02.ej01.Calculos
import introKotlin02.ej01.Figuras
import introKotlin02.ej01.Forma
import kotlin.math.pow

class Circulo(nombre: String, val radio: Double) : Forma(nombre, Figuras.CIRCULO), Calculos {
    override fun area(): Double {
        return Math.PI*radio.pow(2)
    }

    override fun toString(): String {
        return super.toString()+", y el area ${area()}"
    }
}