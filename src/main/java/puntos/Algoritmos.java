/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puntos;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author alvar
 */
public class Algoritmos {

    public static int n;

    /*
        CALCULAR DISTANCIA ENTRE DOS PUNTOS
     */
    public static double distancia2(Punto p1, Punto p2) {
        n++;
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    /*
    
        EXHAUSTIVO
    
     */
    public static ParPuntos exhaustiva(ArrayList<Punto> puntos) {
        n = 0;
        ParPuntos recta = new ParPuntos();
        double minimo = Double.MAX_VALUE;
        n++;

        double distancia;

        for (int i = 0; i < puntos.size(); i++) {
            for (int j = i + 1; j < puntos.size(); j++) {
                distancia = distancia2(puntos.get(i), puntos.get(j));
                if (distancia < minimo) {
                    minimo = distancia;
                    recta = new ParPuntos(puntos.get(i), puntos.get(j));
                }
            }

        }
        return recta;
    }

    /*
    
            EXHAUSTIVO PODA
    
     */
    public static void intercambio(ArrayList<Punto> puntos, int p1, int p2) {
        Punto aux;
        aux = puntos.get(p1);
        puntos.set(p1, puntos.get(p2));
        puntos.set(p2, aux);
    }

    public static int partition(ArrayList<Punto> puntos, int in, int f, Punto pivote) {
        int i = in;
        int j = in;
        while (i <= f) {
            if (puntos.get(i).getX() > pivote.getX()) {
                i++;
            } else {
                intercambio(puntos, i, j);
                i++;
                j++;
            }
        }
        return j - 1;
    }

    public static void quick_sort(ArrayList<Punto> puntos, int in, int f) {
        Punto pivote;
        int q;
        if (in < f) {
            pivote = puntos.get(f);
            q = partition(puntos, in, f, pivote);
            quick_sort(puntos, in, q - 1);
            quick_sort(puntos, q + 1, f);
        }
    }

    public static ParPuntos exhaustivaPoda(ArrayList<Punto> puntos) {
        n = 0;
        quick_sort(puntos, 0, puntos.size() - 1);
        ParPuntos minimo = new ParPuntos(puntos.get(0),puntos.get(1));
        

        double distancia;

        for (int i = 0; i < puntos.size(); i++) {
            for (int j = i + 1; j < puntos.size(); j++) {
                if(puntos.get(j).getX() - puntos.get(i).getX() <= minimo.getDistancia())
                {
                    distancia2(puntos.get(i), puntos.get(j));
                    ParPuntos aux = new ParPuntos(puntos.get(i),puntos.get(j));
                if ( aux.getDistancia()< minimo.getDistancia()) {
                    minimo.setDistancia( aux.getDistancia());
                    
                    minimo.setPuntos(aux.getP1(), aux.getP2());
                }
                    
                }
                
            }

        }
        return minimo;

    }


    public static ParPuntos DyV(ArrayList<Punto> puntos, int izq, int der) {
        ParPuntos recta = new ParPuntos();
        if (izq == 0 && der == (puntos.size() - 1)) {
            n = 0;
            quick_sort(puntos, 0, puntos.size() - 1);
        }

        int opc = der - izq + 1;
        if (opc <= 3) {
            double minDistancia = Double.MAX_VALUE;
            for (int i = 0; i < puntos.size(); i++) {
                for (int j = i + 1; j < puntos.size(); j++) {
                    double distancia = distancia2(puntos.get(i), puntos.get(j));
                    if (distancia < minDistancia) {
                        minDistancia = distancia;
                        recta = new ParPuntos(puntos.get(i), puntos.get(j));
                    }
                }

            }
            return recta;

        }

        int medio = (izq + der) / 2;
        Punto puntoMedio = puntos.get(medio);

        ParPuntos di = DyV(puntos, izq, medio);
        ParPuntos dd = DyV(puntos, medio + 1, der);
        double Distanciaizq = di.distancia(di.getP2());
        double Distanciader = dd.distancia(dd.getP2());
        double Dmin = Math.min(Distanciaizq, Distanciader);

        
        
        
        
        if (Dmin == Distanciaizq) {
            recta = new ParPuntos(di.getP1(), di.getP2());
        } else {
            recta = new ParPuntos(dd.getP1(), dd.getP2());
        }

        ArrayList<Punto> puntosRange = new ArrayList<>();
        for (int i = izq; i <= der; i++) {
            if (Math.abs(puntos.get(i).getX() - puntoMedio.getX()) < Dmin) {
                puntosRange.add(puntos.get(i));
            }
        }

        //puntosRange.sort(Comparator.comparingDouble(Punto::getX));
        for (int i = 0; i < puntosRange.size(); i++) {
            for (int j = i + 1; j < puntosRange.size(); j++) {
                double distancia = distancia2(puntosRange.get(i), puntosRange.get(j));
                if (distancia < Dmin) {
                    Dmin = distancia;
                    recta = new ParPuntos(puntosRange.get(i), puntosRange.get(j));
                }
            }
        }
        return recta;
    }
    
    public static ParPuntos DyV_Mejorado(ArrayList<Punto> puntos, int izq, int der) {
        ParPuntos recta = new ParPuntos();
        if (izq == 0 && der == (puntos.size() - 1)) {
            n = 0;
            quick_sort(puntos, 0, puntos.size() - 1);
        }

        int opc = der - izq + 1;
        if (opc <= 3) {
            double minDistancia = Double.MAX_VALUE;
            for (int i = 0; i < puntos.size(); i++) {
                for (int j = i + 1; j < puntos.size(); j++) {
                    double distancia = distancia2(puntos.get(i), puntos.get(j));
                    if (distancia < minDistancia) {
                        minDistancia = distancia;
                        recta = new ParPuntos(puntos.get(i), puntos.get(j));
                    }
                }

            }
           
            return recta;

        }

        int medio = (izq + der) / 2;
        Punto puntoMedio = puntos.get(medio);

        ParPuntos di = DyV(puntos, izq, medio);
        ParPuntos dd = DyV(puntos, medio + 1, der);
        double Distanciaizq = di.distancia(di.getP2());
        double Distanciader = dd.distancia(dd.getP2());
        double Dmin = Math.min(Distanciaizq, Distanciader);

        if (Dmin == Distanciaizq) {
            recta = new ParPuntos(di.getP1(), di.getP2());
        } else {
            recta = new ParPuntos(dd.getP1(), dd.getP2());
        }

        ArrayList<Punto> puntosRange = new ArrayList<>();
        for (int i = izq; i <= der; i++) {
            if (Math.abs(puntos.get(i).getX() - puntoMedio.getX()) < Dmin) {
                puntosRange.add(puntos.get(i));
            }
        }
        
        puntosRange.sort(Comparator.comparingDouble(Punto::getY));

        for (int i = 0; i < puntosRange.size(); i++) {
            for (int j = i + 1; j < puntosRange.size() && (puntosRange.get(j).getY() - puntosRange.get(i).getY()) < Dmin ; j++) {
                double distancia = distancia2(puntosRange.get(i), puntosRange.get(j));
                if (distancia < Dmin) {
                    Dmin = distancia;
                    recta = new ParPuntos(puntosRange.get(i), puntosRange.get(j));
                }
            }
        }
        
        return recta;
    }

    public static int getN() {
        return n;
    }
    
    
    
}
