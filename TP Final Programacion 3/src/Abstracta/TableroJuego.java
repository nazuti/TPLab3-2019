/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstracta;

import Principal.Tienda;
import Principal.Torreta;
import Principal.Zombie;
import Generica.Contenedor;
import Graficos.Escenario;
import Graficos.Recurso;
import Interfaces.IAcciones;
import Pantallas.Juego;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * 
 * @author ivanmdq22
 * @author Pardo
 * @author Nazuti.
 * @since 10/05/2019
 * @version 1.6
 * 
 * Clase Hija de Tablero que permite al programador saber en que situacion se encuentra el juego. 
 * <br> Presentacion sobre pilares de la POO by @author Benoffi7 </br>
 * @see <a href = "https://docs.google.com/presentation/d/1ln1p_6b44mKaHEJkfdimSZrOWz9hK5vg1FegjWzlkkg/edit#slide=id.g348419c47f_0_282" /> Herenecia en Java - PowerPoint</a> 
 * @see  Tablero.Tablero
 * @param objeto Heroe.
 * @param objeto Escenario.
 * @param lista zombie, torreta, aldea.
 * @param castillo, pincho, torreta, tienda.
 * 
 */

public class TableroJuego extends Tablero implements IAcciones{
	
	
	
	// el oro y la vida que va a tener nuestro usuario al comienzo del juego 
	public static double oro = 100;
	public static double vida = 100;
	
    private Escenario escenario;
    private Contenedor<Zombie>listazombie;
    private Contenedor<Torreta>listaTorreta;
	
    // se usa estatico ya que lo llamamos en accionboton
    public static Tienda tienda;

	
    public TableroJuego(Juego juego){
        
    	super(juego);
        escenario = new Escenario("src/Utilidades/escenario1.txt");
        listazombie = new Contenedor<Zombie>();
        listaTorreta = new Contenedor<Torreta>();
        tienda = new Tienda();
        
    }
    
    public void agregarZombie(Zombie param) {
    	listazombie.agregar(param,0);
    }
    
    public void remueveZombie(Zombie param) {
    	listazombie.eliminar(param);
    }
    public void agregarTorreta(Torreta param) {
    	listaTorreta.agregar(param, 0);
    }
    public void remueveTorreta(Torreta param) {
    	listaTorreta.agregar(param, 0);
    }
    
    @Override
    public void actualizar() {
        escenario.actualizar();
        tienda.actualizar();
        listazombie.actualizar();
        
    }

    @Override
    public void renderizar(Graphics g) {
        escenario.renderizar(g);
        tienda.renderizar(g);
       
        
        
    }
    
    
}
