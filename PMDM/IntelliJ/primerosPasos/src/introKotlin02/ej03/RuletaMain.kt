package introKotlin02.ej03

import java.util.*

fun main(){
    var jugadores = mutableListOf<Jugador>()
    var revolver = Revolver()
    var sc = Scanner(System.`in`)

    println("Cuantos jugadores son (entre 2 y 6):")

    for (i in 1..sc.nextLine().toInt()) {
        println("Nombre, porfavor:")
        jugadores.add(Jugador(sc.nextLine()))
    }

    var jugadoresVivos = jugadores

    while (jugadoresVivos.size > 1) {
        eliminacion(jugadoresVivos, revolver, sc)

        jugadoresVivos.removeIf { !it.vivo }
    }


    println("-----------------------------------------------------")
    println("-----------------------------------------------------")
    println("Se acabó la partida\nFelicidades ${jugadoresVivos.get(0)}")

}

fun eliminacion(lista: MutableList<Jugador>, revolver: Revolver, sc: Scanner) {


    for (jugador in lista) {
        println("-----------------------------------------------------")
        println("Le toca a ${jugador.nombre} \n¿Quieres jugar? (S/N)")

        if (!sc.nextLine().equals("S", ignoreCase = true) ){
            jugador.abandona()
            println("El jefe querra hablar contigo ${jugador.nombre}....")
        } else{
            if(revolver.disparar()){
                println("Bien hecho. Eres valiente, aunque los cementerios estan llenos de valientes\n" +
                        "PUUUUMMMM\n" +
                        "Limpiad esto y seguimos")
                jugador.muerto()
                revolver.reiniciar()
            } else {
                println("Bien hecho. Eres valiente, aunque de valientes estan llenos los cementerios\n" +
                        "CLICK\n" +
                        "...")
            }
        }

    }
}