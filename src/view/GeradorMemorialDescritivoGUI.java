package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.Vertice;

public class GeradorMemorialDescritivoGUI extends JFrame {
    private JTextField tfNumeroVertices;
    private List<Vertice> vertices;

    public GeradorMemorialDescritivoGUI() {
        vertices = new ArrayList<>();

        setTitle("Gerador de Memorial Descritivo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblNumeroVertices = new JLabel("Número de Vértices:");
        tfNumeroVertices = new JTextField();

        JButton btnGerarMemorial = new JButton("Gerar Memorial");
        btnGerarMemorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroVertices = Integer.parseInt(tfNumeroVertices.getText());
                if (numeroVertices > 0) {
                    abrirFormularioVertices(numeroVertices);
                } else {
                    JOptionPane.showMessageDialog(GeradorMemorialDescritivoGUI.this, "Número de vértices inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(lblNumeroVertices);
        panel.add(tfNumeroVertices);
        panel.add(btnGerarMemorial);

        setContentPane(panel);
    }

    private void abrirFormularioVertices(int numeroVertices) {
        JFrame frameVertices = new JFrame("Formulário de Vértices");
        frameVertices.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameVertices.setSize(600, 400);
        frameVertices.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel panelVertices = new JPanel();
        panelVertices.setLayout(new GridLayout(numeroVertices, 7, 10, 10));

        for (int i = 1; i <= numeroVertices; i++) {
            JLabel lblVertice = new JLabel("Vértice " + i + ":");
            JTextField tfVertice = new JTextField();
            JLabel lblMedida = new JLabel("Medida:");
            JTextField tfMedida = new JTextField();
            JLabel lblAzimute = new JLabel("Azimute:");
            JTextField tfAzimute = new JTextField();
            JLabel lblCoordenadaNorte = new JLabel("Coordenada Norte:");
            JTextField tfCoordenadaNorte = new JTextField();
            JLabel lblCoordenadaLeste = new JLabel("Coordenada Leste:");
            JTextField tfCoordenadaLeste = new JTextField();
            JLabel lblConfrontante = new JLabel("Confrontante:");
            JTextField tfConfrontante = new JTextField();
            JLabel lblDistanciaConfrontante = new JLabel("Distância Confrontante:");
            JTextField tfDistanciaConfrontante = new JTextField();

            panelVertices.add(lblVertice);
            panelVertices.add(tfVertice);
            panelVertices.add(lblMedida);
            panelVertices.add(tfMedida);
            panelVertices.add(lblAzimute);
            panelVertices.add(tfAzimute);
            panelVertices.add(lblCoordenadaNorte);
            panelVertices.add(tfCoordenadaNorte);
            panelVertices.add(lblCoordenadaLeste);
            panelVertices.add(tfCoordenadaLeste);
            panelVertices.add(lblConfrontante);
            panelVertices.add(tfConfrontante);
            panelVertices.add(lblDistanciaConfrontante);
            panelVertices.add(tfDistanciaConfrontante);
        }

        JButton btnGerarMemorial = new JButton("Gerar Memorial");
        btnGerarMemorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coletar informações dos vértices e gerar memorial
                vertices.clear();
                for (int i = 0; i < numeroVertices; i++) {
                    // Obter informações de cada vértice e adicionar à lista
                    // Exemplo: 
                    String nome = "Vértice " + (i + 1);
                    double medida = Double.parseDouble("0"); // Substituir pelo valor do campo correspondente
                    double azimute = Double.parseDouble("0"); // Substituir pelo valor do campo correspondente
                    double coordenadaNorte = Double.parseDouble("0"); // Substituir pelo valor do campo correspondente
                    double coordenadaLeste = Double.parseDouble("0"); // Substituir pelo valor do campo correspondente
                    String confrontante = "Confrontante " + (i + 1);
                    double distanciaConfrontante = Double.parseDouble("0"); // Substituir pelo valor do campo correspondente
                    Vertice vertice = new Vertice(nome, medida, azimute, coordenadaNorte, coordenadaLeste, confrontante, distanciaConfrontante);
                    vertices.add(vertice);
                }

                // Gerar o memorial descritivo
                StringBuilder memorial = new StringBuilder();
                memorial.append("=== Memorial Descritivo ===\n");
                for (Vertice vertice : vertices) {
                    memorial.append(vertice.toString()).append("\n");
                }

                JOptionPane.showMessageDialog(frameVertices, memorial.toString(), "Memorial Descritivo", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panel.add(panelVertices, BorderLayout.CENTER);
        panel.add(btnGerarMemorial, BorderLayout.SOUTH);

        frameVertices.setContentPane(panel);
        frameVertices.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GeradorMemorialDescritivoGUI frame = new GeradorMemorialDescritivoGUI();
                frame.setVisible(true);
            }
        });
    }
}
