package introKotlin02.ej01.objects

import introKotlin02.ej01.Calculos
import introKotlin02.ej01.Figuras
import introKotlin02.ej01.Forma

class Cuadrado(nombre: String, val lado: Double) : Forma(nombre, Figuras.CUADRADO), Calculos {

    override fun area(): Double {
        return lado*lado
    }

    override fun toString(): String {
        return super.toString()+", y el area ${area()}"
    }
}