//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double a =2.5, b=3.4;
        Calculadora miCalculadora = new Calculadora();


        double resul = miCalculadora.operacionDosParametros(a, b, new OperacionDosParametros() {
            @Override
            public double operacionDosParametros(double a, double b) {
                return a+b;
            }
        });
        System.out.println("Primer resul: "+resul);

        resul = miCalculadora.operacionDosParametros(a, b, (a1, b1) -> a1 + b1);
        System.out.println("Segun resul: "+resul);

        resul = miCalculadora.operacionDosParametros(a, b, (a1, b1) -> a1 * b1);
        System.out.println("Segun resul: "+resul);

    }
}