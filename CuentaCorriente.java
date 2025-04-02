package cuenta;

public class CuentaCorriente extends Cuenta{

    private double INTERES_FIJO = 0.015;

    public CuentaCorriente(int numerocuenta, Persona cliente) {
        super(numerocuenta, cliente);
    }

    public void retirar(double cantidad){
        if(cantidad >0 && cantidad <= getSaldo()){
            setSaldo(getSaldo()-cantidad);
        }else{
            System.out.println("No puedes retirar " + cantidad + " $.");
        }
    }
    
    public void actualizarSaldo(){
        double nuevoSaldo = getSaldo()*(1+INTERES_FIJO);
        setSaldo(nuevoSaldo);
    }

    @Override
    public String toString() {
        return "Saldo cuenta corriente: " + getSaldo();
    }
}
