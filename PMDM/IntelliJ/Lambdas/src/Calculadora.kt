class Calculadora {

    fun operacionDosParametros(x:Double, y:Double, myfun: (Double, Double) -> Double): Double {
        return myfun(x,y);
    }

    fun operacionUnParametros(x:Double, myfun: (Double) -> Double): Double {
        return myfun(x);
    }

}