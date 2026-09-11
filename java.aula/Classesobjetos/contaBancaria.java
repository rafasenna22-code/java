public class contaBancaria {
private String titular;
private int numero;
private double saldo;

public contaBancaria(String titular, int numero){
this.titular = titular;
this.numero = numero;
this.saldo = 1000.50;
}

public void depositar(double valor) {
 if (valor > 0 ){ 
    saldo += valor;
}
}
public void sacar (double valor) {
 if (valor > 0 && valor <= saldo) {   
     saldo -= valor ;
}
}

public double getSaldo() {
    return saldo;
}

public String getTitular() {
    return titular;
}

public int getNumero() {
    return numero;
}

public void mostrarDados() {
    System.out.println("Titular: " + titular);
    System.out.println("Número: " + numero);
    System.out.println("Saldo: R$ " + saldo);
}
}

