package G;

import java.util.ArrayList;

public class Circunferencia extends FiguraGeometrica{
    Ponto a;
    int raio;
    public Circunferencia(String s){
        super(s);
        String[] x = s.split(" ",-1);
        this.a = new Ponto(Integer.parseInt(x[1]), Integer.parseInt(x[2]));
        this.raio = Integer.parseInt(x[3]);
    }
    public static double[] calculateSegmentEquation(double xa, double ya, double xb, double yb) {
        double dx = xb - xa;
        double dy = yb - ya;
        double len = Math.sqrt(dx * dx + dy * dy);
        double nx = dx / len;
        double ny = dy / len;
        return new double[]{xa, ya, nx, ny, len};
    }

    public static boolean checkCollision(double x, double y, double radius, double[] seg) {
        double xa = seg[0];
        double ya = seg[1];
        double nx = seg[2];
        double ny = seg[3];
        double len = seg[4];

        double dx = x - xa;
        double dy = y - ya;

        double dot = dx * nx + dy * ny;

        if (dot < 0 || dot > len) {
            return false;
        }

        double dist = Math.abs(dx * ny - dy * nx);

        return radius == dist || radius > dist;
    }

    @Override
    public boolean intercecao(Trajectory trajetoria) {
        ArrayList<Line> seg = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < trajetoria.getpontos().size() - 1; i++) {
            Ponto pontoA = trajetoria.getpontos().get(i);
            Ponto pontoB = trajetoria.getpontos().get(i + 1);
            double[] segEq = calculateSegmentEquation(pontoA.getX(), pontoA.getY(), pontoB.getX(), pontoB.getY());
            if (checkCollision(this.a.getX(), this.a.getY(), this.raio, segEq)) {
                count++;
            }
        }
        return count != 0;
    }


    @Override
    public void check(){
        if (this.raio < 0) {
            System.out.println("Circunferencia:vi");
            System.exit(0);
        }
    }
}