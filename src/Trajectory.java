/**
 * @author Mario_Nogueira a76947
 * @version 1.3 03/03/2023
 * @inv verifica se a trajetoria intercepta a si mesma
 */
package B;
class Trajectory {

    Line trajectory;
    public Trajectory(Line trajectory){
        this.trajectory = trajectory;
        Line.check(trajectory);
    }
    public static int hits(Rectangle[] a, Trajectory[] b){
        int result = 0;
        for (int i = 0;i < a.length;i++) {
            if (Rectangle.isIntersecting(a[i], b)) {
                result += 1;
            }
        }
        return result;
    }

    private Ponto getA() { return trajectory.getA(); }
    private Ponto getB() { return trajectory.getB(); }

    public static void check(Trajectory[] x,int n){
        if (n > 1) {
            for (int i = 0; i < n-1; i++) {
                if (Line.intersection(x[i].getA(), x[i].getB(), x[n].getA(), x[n].getB())) {
                    System.out.println("Trajetoria:vi");
                    System.exit(0);
                }
            }
        }
    }
}
