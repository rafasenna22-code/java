public class circulo extends forma {

    private double raio;

    public circulo(double raio) {
        this.raio = raio;
    }

    public double getraio() {
        return raio;
    }

    @Override 
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
    }

    

