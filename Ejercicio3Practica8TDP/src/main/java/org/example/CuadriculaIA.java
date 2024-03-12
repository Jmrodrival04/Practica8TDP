package org.example;
class CuadriculaIA extends Cuadricula {

    @Override
    public void actualizarCondicionMarina() {
        super.actualizarCondicionMarina();
        if ("tormentoso".equals(condicionMarina)) {
            System.out.println("Condiciones tormentosas pueden afectar la precisión de los ataques.");
        }
    }

    public void realizarAtaqueIA(Cuadricula objetivo) {
        int x, y;
        boolean resultado;
        do {
            x = rand.nextInt(TAMANO);
            y = rand.nextInt(TAMANO);
            resultado = objetivo.realizarAtaque(x, y);
            System.out.println("IA ataca en (" + x + ", " + y + ") " + (resultado ? "y acierta!" : "y falla."));
        } while (resultado && !objetivo.verificarFinJuego()); // La IA sigue atacando mientras acierte
    }
}