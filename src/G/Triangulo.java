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

    //TODO:verificar este check e modificar
    public void check(){
        if(a.dist(b) + b.dist(c) <= c.dist(a) || a.dist(b) + a.dist(c) <= b.dist(c) || b.dist(c) + a.dist(c) <= a.dist(b)){
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
    }

}
