public class retangulo extends forma {
    private double base;
    private double altura;

    public retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    public double getbase() {
        return base;
    }
    public double getaltura() {
        return altura;
    }

    @Override 
    public double calcularArea() {
        return base * altura;
    }
}
