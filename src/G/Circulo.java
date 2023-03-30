package G;

public class Circulo extends FiguraGeometrica{
    Ponto a;
    int raio;
    public Circulo(String s){
        super(s);
        String[] x = s.split(" ",-1);
        this.a = new Ponto(Integer.parseInt(x[1]), Integer.parseInt(x[2]));
        this.raio = check(raio);
    }

    private int check(int n){
        if (n <= 0) {
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
        return n;
    }
}