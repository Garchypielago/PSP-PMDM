package introKotlin02.ej01.objects

import introKotlin02.ej01.Calculos
import introKotlin02.ej01.Figuras
import introKotlin02.ej01.Forma

class Triangulo(nombre: String, val base: Double, val altura: Double) : Forma(nombre, Figuras.TRIANGULO), Calculos {

    override fun area(): Double {
        return base*altura/2
    }

    override fun toString(): String {
        return super.toString()+", y el area ${area()}"
    }

}