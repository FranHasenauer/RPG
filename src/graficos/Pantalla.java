package graficos;

public final class Pantalla {
    //Temporal
    private final static int LADO_SPRITE = 32;
    private final static int MASCARA_SPRITE = LADO_SPRITE - 1;
    public final int[] pixeles;
    private final int ancho;
    private final int alto;

    //Fin temporal

    public Pantalla(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        pixeles = new int[alto * ancho];
    }

    //pita todos los pixeles del array de negro
    public void limpiar() {
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = 0;
        }
    }

    //Doble bucle anidado
    //se dibuja la pantalla de izquierda a derecha y de arriba abajo
    public void mostrar(final int compensacionX, final int compesacionY) {
        for (int y = 0; y < alto; y++) {
            int posicionY = y + compesacionY;
            if (posicionY < 0 || posicionY >= alto) {//los if es para no dibujar fuera de la pantalla
                continue;
            }
            for (int x = 0; x < ancho; x++) {
                int posicionX = x + compensacionX;
                if (posicionX < 0 || posicionX >= ancho) {
                    continue;

                }
                //temporal
                pixeles[posicionX + posicionY * ancho] = Sprite.asfalto.pixeles[(x & MASCARA_SPRITE) +
                        (y & MASCARA_SPRITE) * LADO_SPRITE];
            }

        }

    }
}
