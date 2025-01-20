package introKotlin02.ej02

import java.util.*

fun main(){
    val sc = Scanner(System.`in`)
    var personaList = mutableListOf<Persona>()
    var nombre: String
    var peso: Double
    var altura: Double

    do {
        println("Escribe el nombre de la persona:")
        nombre = sc.nextLine()
        println("Escribe el peso de la persona:")
        peso = sc.nextLine().toDouble()
        println("Escribe la altura de la persona:")
        altura = sc.nextLine().toDouble()

        personaList.add(Persona(nombre, peso, altura))

        println("Quieres seguir añadiendo personas (S/N):")
    }while(sc.nextLine().equals("s", ignoreCase = true))

    for(persona in personaList){
        println(persona.toString())
    }

}