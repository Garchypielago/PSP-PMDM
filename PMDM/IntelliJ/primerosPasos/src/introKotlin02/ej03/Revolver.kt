package introKotlin02.ej03

import introKotlin02.ej01.Figuras

class Revolver(var posBala: Int, var posTambor: Int) {


    constructor(): this(0,0){
        reiniciar()
    }

    fun reiniciar(){
        posBala = (1..6).random()
        posTambor = (1..6).random()
    }

    fun sumarTambor(): Int{
        if (++posTambor > 6)
            posTambor = 1;

        return posTambor;
    }

    fun disparar(): Boolean {
        return (posBala == sumarTambor() );
    }

}