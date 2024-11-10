/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puntos;

/**
 *
 * @author alvar
 */
public class ParPuntos {

    private Punto p1;
    private Punto p2;
    double dist;

    public ParPuntos() {
        p1 = null;
        p2 = null;
        dist = 0;
    }

    public ParPuntos(Punto p1, Punto p2) {
        super();
        this.p1 = p1;
        this.p2 = p2;
        dist = distancia(p1, p2);
    }

    public Punto getP1() {
        return p1;
    }

    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    public Punto getP2() {
        return p2;
    }

    public void setP2(Punto p2) {
        this.p2 = p2;
    }

    public void setPuntos(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getDistancia() {
        return this.dist;
    }


    public void setDistancia(double dist) {
        this.dist = dist;
    }

    public double distancia(Punto p2) {
        double difX = p2.getX() - this.getP1().getX();
        double difY = p2.getY() - this.getP1().getY();
        return Math.sqrt((difX * difX) + (difY * difY));
    }

    public double distancia(Punto p1, Punto p2) {
        double difX = p2.getX() - this.getP1().getX();
        double difY = p2.getY() - this.getP1().getY();
        return Math.sqrt((difX * difX) + (difY * difY));
    }

    public void calcularDist() {
        dist = distancia(p1, p2);
    }

    @Override
    public String toString() {
        return "Recta" + "p1=(" + p1.getX() + " , " + p1.getY() + ")" + " p2=(" + p2.getX() + " , " + p2.getY() + ")" + '}';        
    
    }

}
