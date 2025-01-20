package introKotlin02.ej01

open class Forma (var nombre:String, var tipo: Figuras){
    override fun toString(): String {
        return "La forma se llama $nombre y es de tipo $tipo"
    }
}