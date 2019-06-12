package asignacion.de.memoria;

public class Memoria {

    boolean memoria[] = new boolean[49];
    int apuntador = 0;

    public Memoria() {
        for (int i = 0; i <= 48; i++) {
            memoria[i] = true;
        }
        for (int i = 0; i < 16; i++) {
            memoria[i] = false;
        }
        for (int i = 24; i < 26; i++) {
            memoria[i] = false;
        }
        for (int i = 36; i < 44; i++) {
            memoria[i] = false;
        }
    }

    public void asignarM(int cantidad, int posicion, int metodo) {

        switch (metodo) {
            case 1:
                botonFirst(cantidad, posicion);
                break;
            case 2:
                botonNext(cantidad, posicion);
                break;
            case 3:
                botonBest(cantidad, posicion);
                break;
            case 4:
                botonWorst(cantidad, posicion);
                break;
        }
    }

    private void botonFirst(int cantidad, int posicion) {
        int contador = 0;
        for (int i = 0; i < 48; i++) {
            if (memoria[i]) {
                contador++;
                if (contador == cantidad) {
                    for (int j = i - cantidad; j <= i; j++) {
                        memoria[j] = false;
                        apuntador = j;
                    }
                    break;
                }
            } else {
                contador = 0;
            }
        }
    }

    private void botonNext(int cantidad, int posicion) {
        int contador = 0;
        for (int i = apuntador; i < 48; i++) {
            if (memoria[i]) {
                contador++;
                if (contador == cantidad) {
                    for (int j = i - cantidad; j <= i; j++) {
                        memoria[j] = false;
                    }
                    break;
                }
            } else {
                contador = 0;
            }
        }
    }

    private void botonBest(int cantidad, int posicion) {
        int contador = 0, h = 0;
        int aux[] = new int[5];
        for (int i = 0; i < 5; i++) {
            aux[i] = 0;
        }
        for (int i = 0; i <= 48; i++) {
            if (memoria[i]) {
                if(contador==0){
                    h++;
                }
                contador++;
                if (contador >= cantidad) {
                    aux[h]++;
                }
            } else {
                contador = 0;
            }
        }
        contador = 0;
        for (int i = 0; i <= 48; i++) {
            if (memoria[i]) {
                contador++;
                if (contador == cantidad + compararEspacios(aux, 1)) {
                    for (int j = i - contador; j < cantidad; j++) {
                        memoria[j] = false;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i <= 48; i++) {
            System.out.println("en " + i + " es " + memoria[i] + " ");
        }
    }

    private void botonWorst(int cantidad, int posicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int compararEspacios(int espacios[], int metodo) {
        int aux = espacios[0];
        if (metodo == 1) {
            for (int i = 0; i < espacios.length; i++) {
                if (espacios[i] < aux && espacios[i] != 0) {
                    aux = espacios[i];
                }
            }

        }
        return aux;
    }
}
