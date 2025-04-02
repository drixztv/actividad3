package cuenta;

public abstract class Cuenta {
    private int numerocuenta;
    private double saldo;
    private Persona cliente;

    public Cuenta(int numerocuenta, Persona cliente) {
        this.numerocuenta = numerocuenta;
        this.saldo = 0;
        this.cliente = cliente;
    }

    public int getNumerocuenta() {
        return numerocuenta;
    }
    public void setNumerocuenta(int numerocuenta) {
        this.numerocuenta = numerocuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Persona getCliente() {
        return cliente;
    }
    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public void ingresar(double cantidad){
        if(cantidad > 0){
            saldo += cantidad;
        }else{
            System.out.println("Debes ingresar una cantidad mayor que 0$.");
        }
    }

    public abstract void retirar(double cantidad);

    public abstract void actualizarSaldo();

    

    
}
