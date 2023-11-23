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

public class Reemplazar extends JDialog{
	
    private Highlighter.HighlightPainter highlightPainter;
    private DefaultHighlighter highlighter;
    public JTextField txtBuscar;
    public JTextField txtReemplazar;

	private JTextPane textPane;

    int posicionActual = 0;
    
    public Reemplazar(JFrame parent, JTextPane textPane) {
        
        this.textPane = textPane;
        
        // Se inicializa el pop up de buscar
        JPanel contentPanel = new JPanel();
        setResizable(false);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        getContentPane().add(contentPanel, BorderLayout.NORTH);

        JLabel lblTextoBuscar = new JLabel("Buscar:         ");
        contentPanel.add(lblTextoBuscar);

        txtBuscar = new JTextField(30);
        contentPanel.add(txtBuscar);
        
        JPanel reemplazarPanel = new JPanel();
        reemplazarPanel.setLayout(new FlowLayout());
        
        JLabel lblTextoReemplazar = new JLabel("Reemplazar: ");
        reemplazarPanel.add(lblTextoReemplazar);
        txtReemplazar = new JTextField(30);
        reemplazarPanel.add(txtReemplazar);
        
        getContentPane().add(reemplazarPanel, BorderLayout.CENTER);
        
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        ButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        JButton btnReemplazar= new JButton("Reemplazar");
        btnReemplazar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Funciona!");
                reemplazar();
            }
        });
        ButtonPanel.add(btnReemplazar);
        
        JButton btnReemplazarTodo = new JButton("Reemplazar todo");
        btnReemplazarTodo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Funciona!");
                reemplazarTodo();
            }
        });
        ButtonPanel.add(btnReemplazarTodo);
        
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
    
    private void reemplazar() {
        String buscarEnTexto = textPane.getText().toLowerCase();
        String textoBuscar = txtBuscar.getText().toLowerCase();
        String textoReemplazar = txtReemplazar.getText().toLowerCase();
        
        textPane.setText(buscarEnTexto.replaceFirst(textoBuscar, textoReemplazar));
        
        posicionActual = 0;
    }
    
    private void reemplazarTodo() {
        String buscarEnTexto = textPane.getText().toLowerCase();
        String textoBuscar = txtBuscar.getText().toLowerCase();
        String textoReemplazar = txtReemplazar.getText().toLowerCase();
        
        textPane.setText(buscarEnTexto.replaceAll(textoBuscar, textoReemplazar));
        
        posicionActual = 0;
    }
}