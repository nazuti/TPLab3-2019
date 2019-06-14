package Pantallas;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Principal.JsonUtil;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author ivanmdq22
 * @author Pardo
 * @author Nazuti.
 * @since 10/05/2019
 * @version 1.6
 * 
 * Clase de la interfaz grafica Swing que se encarga de crear un login del juego.
 * <br> Tutorial sobre <strong> Swing en Eclipse </strong> </br>
 * @see <a href="https://www.youtube.com/playlist?list=PLMQ4k-hUWGNmQwP3u5HP894NnQQ9lGY_d" /> Swing Eclipse </a>
 * 
 */

public class Login extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane;
	private JTextField nombreUsuario;
	private JTextField contrasenaUsuario;
    
	
    

		
	public Login() {
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(comprobarUsuario()==true) {
					
					SeleccionNivel s1 = new SeleccionNivel();
					JOptionPane.showMessageDialog(s1,"Bienvenido");
					
				}else {
					
					JFrame error = new JFrame("ERROR");
					error.setVisible(true);
					error.setSize(800,600);
					
					JOptionPane.showMessageDialog(error,"Error, que desea hacer?");
					
					nombreUsuario.setText("");
					contrasenaUsuario.setText("");
					
				}
				
				
			}
		});
		
		
		btnNewButton.setBounds(175, 175, 114, 25);
		contentPane.add(btnNewButton);
		
		nombreUsuario = new JTextField();
		nombreUsuario.setBounds(175, 81, 124, 19);
		contentPane.add(nombreUsuario);
		nombreUsuario.setColumns(10);
		
		contrasenaUsuario = new JTextField();
		contrasenaUsuario.setBounds(175, 106, 124, 19);
		contentPane.add(contrasenaUsuario);
		contrasenaUsuario.setColumns(10);
		
		
	}
	
	public String pideNombreUsuario() {
		return nombreUsuario.getText();
	}
	public String pideClaveUsuario() {
		return contrasenaUsuario.getText();
	}
	
	public boolean comprobarUsuario() {
		
		try {
			JSONArray arraye = new JSONArray(JsonUtil.leer());
			
			for(int i=0;i<arraye.length();i++) {
				JSONObject jo = arraye.getJSONObject(i); 
				
				if(jo.getString("nombre").equals(pideNombreUsuario()) && jo.getString("contrasena").equals(pideClaveUsuario())) {
					return true;
				}else {
					return false;
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return rootPaneCheckingEnabled;
		
	}
	
	
}
