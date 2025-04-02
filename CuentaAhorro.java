package cuenta;

public class CuentaAhorro extends Cuenta{
    private double interesVariable;
    private double saldoMinimo;

    public CuentaAhorro(int numerocuenta, Persona cliente, double interesVariable, double saldoMinimo) {
        super(numerocuenta, cliente);
        this.interesVariable = interesVariable;
        this.saldoMinimo = saldoMinimo;
    }

    public void retirar(double cantidad){
        double nuevoSaldo = getSaldo() - cantidad;
        if(cantidad <= 0){
            System.out.println("Por favor introduce una cantidad positiva.");
        }else if(nuevoSaldo >= saldoMinimo){
            setSaldo(nuevoSaldo);
        }else{
            System.out.println("No puedes retirar " + cantidad + "$.");
        }
    }

    public void actualizarSaldo(){
        double nuevoSaldo = getSaldo()*(1+interesVariable);
        setSaldo(nuevoSaldo);
    }

    public void actualizarInteresVariable(){
        interesVariable = getSaldo()*0.1;
    }

    @Override
    public String toString() {
        return "Saldo cuenta ahorro: " + getSaldo() + " interes variable: " + interesVariable + " saldo minimo: " + saldoMinimo;
    }

    



    
}
