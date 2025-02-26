//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val a=3.5
    val b=3.2
    val miCalculadora = Calculadora()

    val funSumar = fun(a:Double, b:Double): Double {
        return a+b
    }

    val resultado = miCalculadora.operacionDosParametros(a,b,funSumar)
    println("Sum1: " + resultado)

    val funSumar2= { x:Double, y:Double -> x+y}
    val resultado2 = miCalculadora.operacionDosParametros(a,b,funSumar2)
    println("Sum2: " + resultado2)


    val resultado3 = miCalculadora.operacionDosParametros(a,b,{ x:Double, y:Double -> x+y})
    println("Sum3: " + resultado3)


    val resultado4 = miCalculadora.operacionDosParametros(a,b) { x: Double, y: Double -> x + y }
    println("Sum4: " + resultado4)


    val resultado5 = miCalculadora.operacionDosParametros(a,b) { x, y -> x + y }
    println("Sum5: " + resultado5)

    val funSqrt= {x: Double -> x*x }
    val resultado6 = miCalculadora.operacionUnParametros(a, funSqrt)
    println("Sqrt1: " + resultado6)

    val resultado7 = miCalculadora.operacionUnParametros(a) {x->x*x}
    println("Sqrt2: " + resultado7)

//    {it->it*it}
    val resultado8 = miCalculadora.operacionUnParametros(a) {it * it}
    println("Sqrt3: " + resultado8)


}