/**
 * @author Mario_Nogueira a76947
 * @version 1.2 03/03/2023
 * @inv verifica se cada lado do retangulo interceta com a trajetoria de reta
 */

package G;

class Rectangle extends FiguraGeometrica {
     Ponto a,b,c,d;
    public Rectangle(String s){
        super(s);
        String[] x = s.split(" ",-1);
        this.a = new Ponto(Integer.parseInt(x[1]), Integer.parseInt(x[2]));
        this.b = new Ponto(Integer.parseInt(x[3]), Integer.parseInt(x[4]));
        this.c = new Ponto(Integer.parseInt(x[5]), Integer.parseInt(x[6]));
        this.d = new Ponto(Integer.parseInt(x[7]), Integer.parseInt(x[8]));
    }

    public Ponto getA(){return a;}
    public Ponto getB(){return b;}
    public Ponto getC(){return c;}
    public Ponto getD(){return d;}

    public static void check(Rectangle x){//confirma que e um rectangulo
        if (x.getA().dist(x.getC()) != x.getB().dist(x.getD()) || x.getA().dist(x.getC()) == 0){
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
    }
    //TODO: verificar se esta certo quando mudar a trajetoria
    public static boolean isIntersecting(Rectangle x, Trajectory[] y) {//confirma se o rectangulo esta a interseptar com o segmento de reta
        boolean test = false;
            for (int j = 0;j<y.length;j++){
                boolean a = Line.intersection(x.getA(), x.getB(), y[j].getA(j), y[j].getB(j));
                boolean b = Line.intersection(x.getB(), x.getC(), y[j].getA(j), y[j].getB(j));
                boolean c = Line.intersection(x.getC(), x.getD(), y[j].getA(j), y[j].getB(j));
                boolean d = Line.intersection(x.getA(), x.getD(), y[j].getA(j), y[j].getB(j));

                if(a || b || c || d){
                    return true;
                }
            }
        return test;
    }
}
