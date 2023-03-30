package G;

public class Circunferencia extends FiguraGeometrica{
    Ponto a;
    int raio;
    public Circunferencia(String s){
        super(s);
        String[] x = s.split(" ",-1);
        this.a = new Ponto(Integer.parseInt(x[1]), Integer.parseInt(x[2]));
        this.raio = raio;
    }

    @Override
    public void check(){
        if (this.raio <= 0) {
            System.out.println("Circunferencia vi");
            System.exit(0);
        }
    }
}