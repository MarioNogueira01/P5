/**
 * @author Mario_Nogueira a76947
 * @version 1.2 03/03/2023
 * @inv verifica se cada lado do retangulo interceta com a trajetoria de reta
 */

package G;

class Rectangle {
     Ponto a,b,c,d;
    public Rectangle(Ponto[] x){
        this.a = x[0];
        this.b = x[1];
        this.c = x[2];
        this.d = x[3];
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

    public static boolean isIntersecting(Rectangle x, Trajectory[] y) {//confirma se o rectangulo esta a interseptar com o segmento de reta
        boolean test = false;
            for (int j = 0;j<y.length;j++){
                boolean a = Line.intersection(x.getA(), x.getB(), y[j].trajectory.getA(), y[j].trajectory.getB());
                boolean b = Line.intersection(x.getB(), x.getC(), y[j].trajectory.getA(), y[j].trajectory.getB());
                boolean c = Line.intersection(x.getC(), x.getD(), y[j].trajectory.getA(), y[j].trajectory.getB());
                boolean d = Line.intersection(x.getA(), x.getD(), y[j].trajectory.getA(), y[j].trajectory.getB());

                if(a || b || c || d){
                    return true;
                }
            }
        return test;
    }
}
