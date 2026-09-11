public class forma1 {
    public static void main(String[] args) {
        forma formaretangulo= new retangulo(5.0, 7.0);
        forma formacirculo= new circulo(4.7);

        double arearetangulo= formaretangulo.calcularArea();
        double areacirculo= formacirculo.calcularArea();
        
        System.out.println("Área do retangulo: " + arearetangulo);
        System.out.println("Área do circulo: " + areacirculo);
    
        System.out.println("\n---COMPARAÇÃO DOS RESULTADOS---");

        if(arearetangulo>areacirculo){
            System.out.println("A área do retângulo é Maior que a área do circulo.");
        } else if(arearetangulo<areacirculo) {
            System.out.println("Área do circulo é maior que a área do retangulo."); 
        }else{
            System.out.println("A área do retângulo é igual a área do circulo.");
        }
    }
    
}
