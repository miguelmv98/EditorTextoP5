package formularios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class Buscar extends JDialog{
	
    private Highlighter.HighlightPainter highlightPainter;
    private DefaultHighlighter highlighter;
    public JTextField txtBuscar;

	private JTextPane textPane;

    int posicionActual = 0;
    
    public Buscar(JFrame parent, JTextPane textPane) {
        
        this.textPane = textPane;
        
        // Se inicializa el pop up de buscar
        JPanel contentPanel = new JPanel();
        setResizable(false);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        JLabel lblTextoBuscar = new JLabel("Buscar:");
        contentPanel.add(lblTextoBuscar);

        txtBuscar = new JTextField(30);
        contentPanel.add(txtBuscar);

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        ButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Funciona!");
                BuscarYResaltar();
            }
        });
        ButtonPanel.add(btnBuscar);
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        ButtonPanel.add(btnCerrar);
        getContentPane().add(ButtonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
    }
    
    private void BuscarYResaltar() {
        String buscarEnTexto = textPane.getText().toLowerCase();
        String texto = txtBuscar.getText().toLowerCase();
        
        // Busca el index del texto
        int pos = buscarEnTexto.indexOf(texto, posicionActual);
        int tamaño = texto.length();
        
        // Inicializa variables de highlight
        highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(java.awt.Color.LIGHT_GRAY);
        Highlighter h = textPane.getHighlighter();
        h.removeAllHighlights();
        
        // Loop subrayar el texto
        try {
            h.addHighlight(pos, pos + tamaño, highlightPainter);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        
        posicionActual = pos + tamaño;
        
        // Actualizar la posición solo si se encontró al menos una ocurrencia
        if (posicionActual >= buscarEnTexto.length()) {
            posicionActual = 0;
        }
        
        // Si no encontramos ningun texto
        if (buscarEnTexto.indexOf(texto,posicionActual) == -1) {
        	posicionActual = 0;
        }
    }
}