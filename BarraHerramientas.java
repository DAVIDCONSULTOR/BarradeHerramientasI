package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class BarraHerramientas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoBarra mb = new MarcoBarra();

		mb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mb.setVisible(true);
	}
}

class MarcoBarra extends JFrame{
	
	public MarcoBarra() {

		setTitle("Marco con Barra");
		
		setBounds(500, 300, 600, 450);
		
		panel = new JPanel();
		
		add(panel);
		
		ActionColorB accAmarillo=new ActionColorB("Amarillo", new ImageIcon("src/graficos/FolderAmarillo.gif"), Color.yellow);
		Action accAzul=new ActionColorB("Azul", new ImageIcon("src/graficos/FolderAzul.gif"), Color.BLUE);
		Action accVerde=new ActionColorB("Verde", new ImageIcon("src/graficos/FolderVerde.gif"), Color.green);
		Action accRojo=new ActionColorB("Rojo", new ImageIcon("src/graficos/FolderRojo.gif"), Color.red);
	 	Action accSalir=new AbstractAction("Salir", new ImageIcon("src/graficos/Exit.gif")) {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
	 		
	 	};

		JMenu menu = new JMenu("Color");
				
		menu.add(accRojo);
		menu.add(accAzul);
		menu.add(accVerde);
		menu.add(accAmarillo);
							
		JMenuBar barraMenues = new JMenuBar();
				
		barraMenues.add(menu);
				
		setJMenuBar(barraMenues);
					
		//Construcción de la barra de herramientas.
		JToolBar ToolBar = new JToolBar();
				
		ToolBar.add(accRojo);
		ToolBar.add(accVerde);
		ToolBar.add(accAmarillo);
		ToolBar.add(accAzul);
		ToolBar.addSeparator();
		ToolBar.add(accSalir);
		add(ToolBar, BorderLayout.NORTH);
		barraMenues.add(menu);
				
	}
	
	private class ActionColorB extends AbstractAction{
		
		public ActionColorB(String nombre, Icon icono, Color btnColor) {
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Xuxu dice poner la lamina de color "+nombre);
			putValue("color_fondo", btnColor);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Color c=(Color)getValue("color_fondo");
			panel.setBackground(c);
			System.out.println("Nombre "+getValue(Action.NAME)+"Descripción: "
			+getValue(Action.SHORT_DESCRIPTION));				
		}
	}
		
	private JPanel panel;
}
