import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cuerda {
    private Semaphore semaforo;
    private String direccionBabuinos = null;
    private int count = 0;

    public Cuerda (int cantidadDeBabuinosACruzar){
        semaforo = new Semaphore(cantidadDeBabuinosACruzar);
    }
        public void Cruzar (Babuino babuino)throws InterruptedException{
            semaforo.acquire();
            try {
                // si no hay babuinos en la cuerda establecemos la direccion del primero que intente cruzar
                if (direccionBabuinos == null) {
                    direccionBabuinos = babuino.getDireccion();
                }
                //si hay babuinos cruzando en la misma direccion se dejan pasar entre compas
                // vinicius deja pasar a carvajal y bellingham
                if (direccionBabuinos.equals(babuino.getDireccion())) {
                    count++;
                    System.out.println("babuino del:" + babuino.getDireccion() + "esta cruzando." + "babuinos en cuerda:" + count);
                    Thread.sleep(1000); //simulamos el tiempo de cruce
                    count--;
                    System.out.println("babuino del:" + babuino.getDireccion() + "ha cruzado." + "babuinos en cuerda:" + count);
                    if (count == 0) {
                        direccionBabuinos = null;
                        // si ya no hay mas vinicius cruzando reiniciamos la direccion hasta que otro lo intente.
                    }
                } else {
                    pelear(babuino);
                }
                // y si vienen de diferentes direcciones se van a sacar la PUUUUVCTA
            }finally {
                semaforo.release();
            }

        }
        private void pelear(Babuino babuino) {
            System.out.println("pelea entre babuino de:" + babuino.getDireccion() + "y babuino contrario");
            Random random = new Random();
            boolean ganaNuevo = random.nextBoolean();
                if (ganaNuevo){
                    System.out.println("babuino de:" + babuino.getDireccion() + "ha ganado la pelea");
                    count = 0; // caen de la cuerda
                    direccionBabuinos = babuino.getDireccion();
                }else{
                    System.out.println("babuino de:" + babuino.getDireccion() + "pierde la pelea y cae " );
                }
     }
}
