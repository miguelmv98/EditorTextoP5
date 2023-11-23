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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;

public class EditorTexto implements ActionListener {

	private JFrame frame;
	private JTextPane textPane;
	private JLabel lblBarraEstado;

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
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		mntmNuevo.addActionListener(this);
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		mntmAbrir.addActionListener(this);
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mntmGuardar.addActionListener(this);
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mntmCerrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));
		mntmCerrar.addActionListener(this);
		mnArchivo.add(mntmCerrar);
	
		JMenu mnEdicion = new JMenu("Edición");
		mnEdicion.setMnemonic('E');
		menuBar.add(mnEdicion);
		
		JMenuItem mntmCopiar = new JMenuItem("Copiar");
		mntmCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		mntmCopiar.addActionListener(this);
		mnEdicion.add(mntmCopiar);
		
		JMenuItem mntmCortar = new JMenuItem("Cortar");
		mntmCortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		mntmCortar.addActionListener(this);
		mnEdicion.add(mntmCortar);
		
		JMenuItem mntmPegar = new JMenuItem("Pegar");
		mntmPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		mntmPegar.addActionListener(this);
		mnEdicion.add(mntmPegar);
		
		JSeparator separator = new JSeparator();
		mnEdicion.add(separator);
		
		JMenu mnAlinear = new JMenu("Alinear");
		mnEdicion.add(mnAlinear);
		
		JMenuItem mntmAlinearIzquierda = new JMenuItem("Izquierda");
		mntmAlinearIzquierda.addActionListener(this);
		mnAlinear.add(mntmAlinearIzquierda);
		
		JMenuItem mntmAlinearDerecha = new JMenuItem("Derecha");
		mntmAlinearDerecha.addActionListener(this);
		mnAlinear.add(mntmAlinearDerecha);
		
		JMenuItem mntmAlinearCentrada = new JMenuItem("Centrada");
		mntmAlinearCentrada.addActionListener(this);
		mnAlinear.add(mntmAlinearCentrada);
		
		JMenuItem mntmAlinearJustificada = new JMenuItem("Justificada");
		mntmAlinearJustificada.addActionListener(this);
		mnAlinear.add(mntmAlinearJustificada);
		
		JSeparator separator_1 = new JSeparator();
		mnEdicion.add(separator_1);
		
		JMenuItem mntmBuscarTexto = new JMenuItem("Buscar");
		mntmBuscarTexto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
		mntmBuscarTexto.addActionListener(this);
		mnEdicion.add(mntmBuscarTexto);
		
		JMenuItem mntmReemplazar = new JMenuItem("Reemplazar");
		mntmReemplazar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		mntmReemplazar.addActionListener(this);
		mnEdicion.add(mntmReemplazar);
		
		JMenu mnFormato = new JMenu("Formato");
		mnFormato.setMnemonic('F');
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
		mntmEstiloNegrita.addActionListener(this);
		mnEstilo.add(mntmEstiloNegrita);
		
		JMenuItem mntmEstiloCursiva = new JMenuItem("Cursiva");
		mntmEstiloCursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		mntmEstiloCursiva.addActionListener(this);
		mnEstilo.add(mntmEstiloCursiva);
		
		JMenuItem mntmEstiloSubrayado = new JMenuItem("Subrayado");
		mntmEstiloSubrayado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
		mntmEstiloSubrayado.addActionListener(this);
		mnEstilo.add(mntmEstiloSubrayado);
		
		JToolBar toolBar = new JToolBar();
		panelMenuArea.add(toolBar);
		
		JComboBox comboFonts = new JComboBox();
		comboFonts.setMaximumSize(new Dimension(300, 32767));
		comboFonts.setModel(new DefaultComboBoxModel(new String[] {"Arial", "Segoe UI", "Tahoma", "Times New Roman"}));
		comboFonts.setSelectedIndex(2);
		toolBar.add(comboFonts);
		
		JButton btnBold = new JButton("");
		btnBold.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alternarTextoNegrita();
			}
		});
		btnBold.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/bold.png")));
		toolBar.add(btnBold);
		
		JButton btnItalic = new JButton("");
		btnItalic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alternarTextoCursiva();
			}
		});
		btnItalic.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/italic.png")));
		toolBar.add(btnItalic);
		
		JButton btnUndearline = new JButton("");
		btnUndearline.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alternarTextoSubrayado();
			}
		});
		btnUndearline.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/underline.png")));
		toolBar.add(btnUndearline);
		
		JButton btnAlignLeft = new JButton("");
		btnAlignLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alinearIzquierda();
			}
		});
		btnAlignLeft.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/align-left.png")));
		toolBar.add(btnAlignLeft);
		
		JButton btnAlignCenter = new JButton("");
		btnAlignCenter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alinearCentrada();
			}
		});
		btnAlignCenter.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/align-center.png")));
		toolBar.add(btnAlignCenter);
		
		JButton btnAlignRight = new JButton("");
		btnAlignRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alinearDerecha();
			}
		});
		btnAlignRight.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/align-right.png")));
		toolBar.add(btnAlignRight);
		
		JButton btnAlignJustify = new JButton("");
		btnAlignJustify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alinearJustificada();
			}
		});
		btnAlignJustify.setIcon(new ImageIcon(EditorTexto.class.getResource("/imagenes/align-justify.png")));
		toolBar.add(btnAlignJustify);
		
		JPanel panelTextArea = new JPanel();
		frame.getContentPane().add(panelTextArea, BorderLayout.CENTER);
		panelTextArea.setLayout(new BorderLayout(0, 0));
		
		textPane = new JTextPane();
		panelTextArea.add(textPane);
		
		lblBarraEstado = new JLabel("Editor de texto abierto");
		panelTextArea.add(lblBarraEstado, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		
		switch(s)
		{
			case "Nuevo":
				nuevoDocumento();
				break;
			case "Abrir":
				abrirDocumento();
				break;
			case "Guardar":
				guardarDocumento();
				break;
			case "Cerrar":
				cerrarDocumento();
				break;
			case "Copiar":
				copiarTexto();
				break;
			case "Cortar":
				cortarTexto();
				break;
			case "Pegar":
				pegarTexto();
				break;
			case "Izquierda":
				alinearIzquierda();
				break;
			case "Derecha":
				alinearDerecha();
				break;
			case "Centrada":
				alinearCentrada();
				break;
			case "Justificada":
				alinearJustificada();
				break;
			case "Buscar":
				buscar();
				break;
			case "Reemplazar":
				reemplazar();
				break;
			case "Negrita":
				alternarTextoNegrita();
				break;
			case "Cursiva":
				alternarTextoCursiva();
				break;
			case "Subrayado":
				alternarTextoSubrayado();
				break;
			default:
		}
	}
	
	private void nuevoDocumento() {
		lblBarraEstado.setText("Creado nuevo documento.");
		textPane.setText("");
	}
	private void abrirDocumento() {
		lblBarraEstado.setText("Abierto documento.");
		textPane.setText("");
	}
	private void guardarDocumento() {
		lblBarraEstado.setText("Documento guardado.");
	}
	private void cerrarDocumento() {
		lblBarraEstado.setText("Documento cerrado");
		textPane.setText("");
	}
	private void copiarTexto() {
		lblBarraEstado.setText("Texto copiado");
		textPane.copy();
	}
	private void cortarTexto() {
		lblBarraEstado.setText("Texto cortado");
		textPane.cut();
	}
	private void pegarTexto() {
		lblBarraEstado.setText("Texto pegado");
		textPane.paste();
	}
	private void alinearIzquierda() {
		SimpleAttributeSet atributos = new SimpleAttributeSet();
		StyleConstants.setAlignment(atributos, StyleConstants.ALIGN_LEFT);
		actualizarParrafo(atributos);
		lblBarraEstado.setText("Parrafo alineado izquierda");
	}
	private void alinearDerecha() {
		SimpleAttributeSet atributos = new SimpleAttributeSet();
		StyleConstants.setAlignment(atributos, StyleConstants.ALIGN_RIGHT);
		actualizarParrafo(atributos);
		lblBarraEstado.setText("Parrafo alineado derecha");
	}
	private void alinearCentrada() {
		SimpleAttributeSet atributos = new SimpleAttributeSet();
		StyleConstants.setAlignment(atributos, StyleConstants.ALIGN_CENTER);
		actualizarParrafo(atributos);
		lblBarraEstado.setText("Parrafo alineado centrado");
	}
	private void alinearJustificada() {
		SimpleAttributeSet atributos = new SimpleAttributeSet();
		StyleConstants.setAlignment(atributos, StyleConstants.ALIGN_JUSTIFIED);
		actualizarParrafo(atributos);
		lblBarraEstado.setText("Parrafo alineado justificado");
	}
	private void buscar() {
		System.out.println("funciona?");
		
		Buscar popUpBuscar = new Buscar(frame, textPane);
	    popUpBuscar.setLocationRelativeTo(frame);
	    popUpBuscar.setVisible(true);
    }
	private void reemplazar() {
		System.out.println("funciona?");
		
		Reemplazar popUpReemplazar = new Reemplazar(frame, textPane);
		popUpReemplazar.setLocationRelativeTo(frame);
		popUpReemplazar.setVisible(true);
    }
	private void alternarTextoNegrita() {
		SimpleAttributeSet atributos = new SimpleAttributeSet();
		StyleConstants.setBold(atributos, !StyleConstants.isBold(getSelectedTextAttributes()));
		actualizarCaracteres(atributos);
		lblBarraEstado.setText("Cambio negrita de caracteres");
	}
	private void alternarTextoCursiva() {
		SimpleAttributeSet atributos = new SimpleAttributeSet();
		StyleConstants.setItalic(atributos,!StyleConstants.isItalic(getSelectedTextAttributes()));
		actualizarCaracteres(atributos);
		lblBarraEstado.setText("Cambio negrita de caracteres");
	}
	private void alternarTextoSubrayado() {
		SimpleAttributeSet atributos = new SimpleAttributeSet();
		StyleConstants.setUnderline(atributos,!StyleConstants.isUnderline(getSelectedTextAttributes()));
		actualizarCaracteres(atributos);
		lblBarraEstado.setText("Cambio negrita de caracteres");
	}
	private void actualizarCaracteres(SimpleAttributeSet atributos) {
		int inicioSeleccion = textPane.getSelectionStart();
		int finSeleccion = textPane.getSelectionEnd();
		int longitudSeleccion = finSeleccion - inicioSeleccion;
		textPane.getStyledDocument().setCharacterAttributes(inicioSeleccion, longitudSeleccion, atributos, false);
	}
	private void actualizarParrafo(SimpleAttributeSet atributos) {
		int inicioSeleccion = textPane.getSelectionStart();
		int finSeleccion = textPane.getSelectionEnd();
		int longitudSeleccion = finSeleccion - inicioSeleccion;
		textPane.getStyledDocument().setParagraphAttributes(inicioSeleccion, longitudSeleccion, atributos, false);
	}
	private AttributeSet getSelectedTextAttributes() {
		StyledDocument doc = textPane.getStyledDocument();
		Element element = doc.getCharacterElement(textPane.getSelectionStart());
		return element.getAttributes();
	}
}
