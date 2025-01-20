package introKotlin01

import java.util.*

fun main() {
    var election: Int
    val sc = Scanner(System.`in`)

    do {
        println(
            "Elige una de las siguientes opciones:"
                    + "\n1. Saber si un día es laborable o fin de semana"
                    + "\n2. Divisibles entre 3"
                    + "\n3. Siguiente divisible entre 7"
                    + "\n4. Notas del aula"
                    + "\n5. Divisibles entre 11"
                    + "\n6. calcula el precio del cine"
                    + "\n0. Salir"
        )

        election = sc.nextInt()

        when (election) {
            1 -> laborable(sc)
            2 -> divisibles3(sc)
            3 -> divisibles7(sc)
            4 -> notas(sc)
            5 -> divisibles11(sc)
            6 -> cine(sc)
            0 -> println("Programa cerrado.")
            else -> println("La eleccion $election no es una opcion valida")
        }

        println("-----------------------------")

    } while (election != 0)


}

fun laborable(sc: Scanner) {
    var calendar = Calendar.getInstance()

    println("Escribe el num del anyo:")
    var anyo: Int = sc.nextInt()
    println("Escribe el num del mes:")
    var mes: Int = sc.nextInt() - 1
    println("Escribe el num del dia:")
    var dia: Int = sc.nextInt()

    calendar.set(anyo, mes, dia)
    var diaSemana: Int = calendar.get(Calendar.DAY_OF_WEEK)

    if (diaSemana == Calendar.SATURDAY || diaSemana == Calendar.SUNDAY) {
        println("El dia es fin de semana")
        return
    }
    println("El dia es laborable")
    return
}

fun divisibles3(sc: Scanner) {
    println("Escribe el num del que debo partir:")
    var num: Int = sc.nextInt()

    while (num % 3 != 0)
        num++


    for (i in num..num + 25 step 3)
        println("Siguiente numero divisible entre 3: ${i}")

    return
}

fun divisibles7(sc: Scanner) {
    println("Escribe el num del que debo partir:")
    var num: Int = sc.nextInt()

    while (num % 7 != 0)
        num++

    println("El siguiente numero divisible entre 7 es ${num}")

}

fun notas(sc: Scanner) {
    println("Escribe el num de alumnos:")
    var num: Int = sc.nextInt()
    var media: Double = 0.0
    val notasArray = arrayOfNulls<Double>(num)

    for (i in 0 until num) {
        println("Escribe la nota del ${i + 1} alumno:")
        notasArray[i] = sc.nextDouble()
        media += notasArray[i]!!
    }

    println("La nota media de la clase es de: ${media / num}")

    for (nota in notasArray)
        if (nota!! > media)
            println("La nota $nota esta por encima de la media")
    return
}

fun divisibles11(sc: Scanner) {
    println("Escribe el num del que parto:")
    var num: Int = sc.nextInt()
    println("Escribe cuanto por encima del anterior quieres que busque:")
    var rango: Int = sc.nextInt()

    for (i in num until num + rango) {
        if (divisible11(i) != null) {
            println("El numero $i es divisile por 11")
        }
    }

}

fun divisible11(num: Int): Int? {
    if (num % 11 == 0)
        return num
    return null
}

fun cine(sc: Scanner) {
    println("Escribe el num de asistentes:")
    var num: Int = sc.nextInt()
    sc.nextLine()

    println("Escribe para que fecha las quieres (dd/mm/yyyy):")
    var fecha: String = sc.nextLine()
    var precioAdulto: Double = miercoles(fecha)

    var total: Double = 0.0
    var precio: Double = 0.0

    for (i in 1..num) {
        println("Dime la edad de la entrada $i")

        when (sc.nextInt()) {
            in 3..14 -> precio = 5.5
            in 15..64 -> precio = precioAdulto
            in 65..100 -> precio = 4.5
            else -> precio = 0.0
        }
        total += precio
        println("El precio de la entrada es de: $precio")
    }

    println("---------------------------------------------\n" +
            "El precio total de las entradas es de $total")
}

fun miercoles(fecha: String): Double {
    var calendar = Calendar.getInstance()

    var anyo: Int = Integer.parseInt(fecha.substring(6, 9))
    var mes: Int = Integer.parseInt(fecha.substring(3, 4))
    var dia: Int = Integer.parseInt(fecha.substring(0, 1))

    calendar.set(anyo, mes, dia)
    var diaSemana: Int = calendar.get(Calendar.DAY_OF_WEEK)

    if (diaSemana == Calendar.WEDNESDAY) {
        return 6.0
    }
    return 9.6
}
