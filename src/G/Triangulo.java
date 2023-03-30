package G;

public class Triangulo extends FiguraGeometrica {
    Ponto a,b,c;
    public Triangulo(String s){
        super(s);
        String[] x = s.split(" ",-1);
        this.a = new Ponto(Integer.parseInt(x[1]), Integer.parseInt(x[2]));
        this.b = new Ponto(Integer.parseInt(x[3]), Integer.parseInt(x[4]));
        this.c = new Ponto(Integer.parseInt(x[5]), Integer.parseInt(x[6]));
        check();
    }

    public Ponto getA(){return a;}
    public Ponto getB(){return b;}
    public Ponto getC(){return c;}

    public void check(){
        if(b.dist(a) + b.dist(c) > a.dist(c) || c.dist(a) + c.dist(b) > a.dist(b) || a.dist(c) + a.dist(b) <= b.dist(c)){
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
    }
}
