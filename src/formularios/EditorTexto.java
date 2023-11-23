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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
		frame.setBounds(100, 100, 1600, 1250);
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
		mntmNuevo.setIcon(null);
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setIcon(null);
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
		
		JMenu mnNewMenu_1 = new JMenu("Tamaño");
		mnFormato.add(mnNewMenu_1);
		
		JMenu mnNewMenu = new JMenu("Color");
		mnFormato.add(mnNewMenu);
		
		JMenu mnTipoLetra = new JMenu("Tipo de fuente");
		mnFormato.add(mnTipoLetra);
		
		JMenuItem mntmFontArial = new JMenuItem("Arial");
		mnTipoLetra.add(mntmFontArial);
		
		JMenuItem mntmFontSegoe = new JMenuItem("Segoe UI");
		mnTipoLetra.add(mntmFontSegoe);
		
		JMenuItem mntmTahoma = new JMenuItem("Tahoma");
		mnTipoLetra.add(mntmTahoma);
		
		JMenu mnEstilo = new JMenu("Estilo");
		mnFormato.add(mnEstilo);
		
		JMenuItem mntmEstiloNegrita = new JMenuItem("Negrita");
		mntmEstiloNegrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		mnEstilo.add(mntmEstiloNegrita);
		
		JMenuItem mntmEstiloCursiva = new JMenuItem("Cursiva");
		mntmEstiloCursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		mnEstilo.add(mntmEstiloCursiva);
		
		JMenuItem mntmSubrayado = new JMenuItem("Subrayado");
		mntmSubrayado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
		mnEstilo.add(mntmSubrayado);
		
		JToolBar toolBar = new JToolBar();
		panelMenuArea.add(toolBar);
		
		JComboBox comboFonts = new JComboBox();
		comboFonts.setModel(new DefaultComboBoxModel(new String[] {"Arial", "Segoe UI", "Tahoma", "Times New Roman"}));
		comboFonts.setSelectedIndex(2);
		toolBar.add(comboFonts);
		
		JButton btnBold = new JButton("");
		btnBold.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/bold.png")));
		toolBar.add(btnBold);
		
		JButton btnItalic = new JButton("");
		btnItalic.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/italic.png")));
		toolBar.add(btnItalic);
		
		JButton btnUndearline = new JButton("");
		btnUndearline.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/underline.png")));
		toolBar.add(btnUndearline);
		
		JButton btnAlignLeft = new JButton("");
		btnAlignLeft.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/align-left.png")));
		toolBar.add(btnAlignLeft);
		
		JButton btnAlignCenter = new JButton("");
		btnAlignCenter.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/align-center.png")));
		toolBar.add(btnAlignCenter);
		
		JButton btnAlignRight = new JButton("");
		btnAlignRight.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/align-right.png")));
		toolBar.add(btnAlignRight);
		
		JButton btnAlignJustify = new JButton("");
		btnAlignJustify.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/align-justify.png")));
		toolBar.add(btnAlignJustify);
		
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
