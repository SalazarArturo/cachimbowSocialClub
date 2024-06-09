public class Babuino extends Thread {
    private String direccion;
    private Cuerda cuerda;
    private int contador = 0;
        public Babuino (String grupo,Cuerda cuerda){
            this.direccion = grupo;
            this.cuerda = cuerda;
            contador ++;
        }

    @Override
    public void run() {
        try{
            cuerda.Cruzar(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getDireccion(){
            return direccion;
        }

    @Override
    public long getId() {
        return contador;
    }
}
