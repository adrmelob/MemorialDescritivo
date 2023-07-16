import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeradorMemorialDescritivo {
    public static void main(String[] args) {
        List<Vertice> vertices = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de vértices: ");
        int numeroVertices = scanner.nextInt();

        for (int i = 1; i <= numeroVertices; i++) {
            System.out.println("=== Vértice " + i + " ===");
            scanner.nextLine(); // Limpar o buffer do teclado

            System.out.print("Digite o nome do vértice: ");
            String vertice = scanner.nextLine();

            System.out.print("Digite a medida: ");
            double medida = scanner.nextDouble();

            System.out.print("Digite o azimute: ");
            double azimute = scanner.nextDouble();

            System.out.print("Digite a coordenada norte: ");
            double coordenadaNorte = scanner.nextDouble();

            System.out.print("Digite a coordenada leste: ");
            double coordenadaLeste = scanner.nextDouble();

            scanner.nextLine(); // Limpar o buffer do teclado

            System.out.print("Digite o confrontante: ");
            String confrontante = scanner.nextLine();

            System.out.print("Digite a distância do confrontante: ");
            double distanciaConfrontante = scanner.nextDouble();

            Vertice novoVertice = new Vertice(vertice, medida, azimute, coordenadaNorte, coordenadaLeste, confrontante, distanciaConfrontante);
            vertices.add(novoVertice);
        }

        StringBuilder memorial = new StringBuilder();

        memorial.append("=== Memorial Descritivo ===\n");

        for (Vertice vertice : vertices) {
            memorial.append(vertice.toString()).append("\n");
        }

        System.out.println(memorial.toString());
    }
}

class Vertice {
    private String nome;
    private double medida;
    private double azimute;
    private double coordenadaNorte;
    private double coordenadaLeste;
    private String confrontante;
    private double distanciaConfrontante;

    public Vertice(String nome, double medida, double azimute, double coordenadaNorte, double coordenadaLeste,
                   String confrontante, double distanciaConfrontante) {
        this.nome = nome;
        this.medida = medida;
        this.azimute = azimute;
        this.coordenadaNorte = coordenadaNorte;
        this.coordenadaLeste = coordenadaLeste;
        this.confrontante = confrontante;
        this.distanciaConfrontante = distanciaConfrontante;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vértice: ").append(nome).append("\n");
        sb.append("Medida: ").append(medida).append("\n");
        sb.append("Azimute: ").append(azimute).append("\n");
        sb.append("Coordenada Norte: ").append(coordenadaNorte).append("\n");
        sb.append("Coordenada Leste: ").append(coordenadaLeste).append("\n");
        sb.append("Confrontante: ").append(confrontante).append("\n");
        sb.append("Distância do Confrontante: ").append(distanciaConfrontante).append("\n");
        return sb.toString();
    }
}
