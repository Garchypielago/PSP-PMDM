package introKotlin02.ej03

class Jugador(var nombre: String, var vivo: Boolean = true) {

    fun abandona() {
        vivo =false;
    }

    fun muerto() {
        vivo = false;
    }

}