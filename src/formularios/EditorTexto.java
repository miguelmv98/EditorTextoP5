package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

public class EditorTexto {

	private JFrame frame;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorTexto window = new EditorTexto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditorTexto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMenuArea = new JPanel();
		frame.getContentPane().add(panelMenuArea, BorderLayout.NORTH);
		panelMenuArea.setLayout(new GridLayout(2, 1, 0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		panelMenuArea.add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mnArchivo.add(mntmCerrar);
		
		JMenu mnEdicion = new JMenu("Edición");
		menuBar.add(mnEdicion);
		
		JMenuItem mntmCopiar = new JMenuItem("Copiar");
		mnEdicion.add(mntmCopiar);
		
		JMenuItem mntmCortar = new JMenuItem("Cortar");
		mnEdicion.add(mntmCortar);
		
		JMenuItem mntmPegar = new JMenuItem("Pegar");
		mnEdicion.add(mntmPegar);
		
		JSeparator separator = new JSeparator();
		mnEdicion.add(separator);
		
		JMenu mnAlinear = new JMenu("Alinear");
		mnEdicion.add(mnAlinear);
		
		JMenuItem mntmAlinearIzquierda = new JMenuItem("Izquierda");
		mnAlinear.add(mntmAlinearIzquierda);
		
		JMenuItem mntmAlinearDerecha = new JMenuItem("Derecha");
		mnAlinear.add(mntmAlinearDerecha);
		
		JMenuItem mntmAlinearCentrada = new JMenuItem("Centrada");
		mnAlinear.add(mntmAlinearCentrada);
		
		JMenuItem mntmAlinearJustificada = new JMenuItem("Justificada");
		mnAlinear.add(mntmAlinearJustificada);
		
		JSeparator separator_1 = new JSeparator();
		mnEdicion.add(separator_1);
		
		JMenuItem mntmBuscarTexto = new JMenuItem("Buscar");
		mnEdicion.add(mntmBuscarTexto);
		
		JMenu mnFormato = new JMenu("Formato");
		menuBar.add(mnFormato);
		
		JToolBar toolBar = new JToolBar();
		panelMenuArea.add(toolBar);
		
		JPanel panelTextArea = new JPanel();
		frame.getContentPane().add(panelTextArea, BorderLayout.CENTER);
		panelTextArea.setLayout(new BorderLayout(0, 0));
		
		textPane = new JTextPane();
		panelTextArea.add(textPane);
	}
	
	private void limpiarEditorTexto() {
		textPane.setText("");
	}
}
