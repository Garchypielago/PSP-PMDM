package introKotlin02.ej01

import introKotlin02.ej01.objects.Circulo
import introKotlin02.ej01.objects.Cuadrado
import introKotlin02.ej01.objects.Plano
import introKotlin02.ej01.objects.Triangulo

fun main() {

    val cuadrado = Cuadrado("Cuadrado", 2.0)
    val triangulo = Triangulo("Triangulo", 2.0, 4.0)
    val circulo = Circulo("Circulo", 2.0)
    val plano = Plano("Plano")

    println(cuadrado.toString())
    println(triangulo.toString())
    println(circulo.toString())
    println(plano.toString())

}