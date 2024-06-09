import java.util.Scanner;
public class BatallaDeBabuinos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de babuinos para la batalla:");
        int totalBabuinos = scanner.nextInt();
        Cuerda cuerda = new Cuerda(totalBabuinos);
        Babuino [] grupoNorte = new Babuino[totalBabuinos];
        Babuino [] grupoSur = new Babuino[totalBabuinos];
        for (int i = 0; i < totalBabuinos; i++) {
            grupoNorte[i]  = new Babuino("norte",cuerda);
            grupoSur[i] = new Babuino("sur",cuerda);
        }
        for(Babuino babuino : grupoNorte){
            babuino.start();
        }
        for (Babuino babuino : grupoSur){
            babuino.start();
        }
    }
}