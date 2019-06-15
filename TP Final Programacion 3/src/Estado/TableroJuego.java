/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Principal.Aldea;
import Principal.Castillo;
import Principal.Heroe;
import Principal.Pincho;
import Principal.Torreta;
import Principal.Zombie;
import Tienda.Tienda;
import Escenario.Escenario;
import Generica.Contenedor;
import Interfaces.IAcciones;
import Pantallas.Juego;
import java.awt.Graphics;

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
 * @see  Estado.Tablero
 * @param objeto Heroe.
 * @param objeto Escenario.
 * @param lista zombie, torreta, aldea.
 * @param castillo, pincho, torreta, tienda.
 * 
 */

public class TableroJuego extends Tablero implements IAcciones{

  
    private Escenario escenario;
    
    //CLASE GENERICA
    
    private Contenedor<Zombie>listazombie;
	private Contenedor<Torreta>listaTorreta;
	private Contenedor<Aldea>listaAldea;
	
	private Heroe heroe;
	private Castillo castillo;
	private Pincho pincho;
	private Tienda tienda;

    
    public TableroJuego(Juego juego){
        
    	super(juego);
        escenario = new Escenario("src/recursos/escenarios/escenario1.txt");
        
        listazombie = new Contenedor<Zombie>();
        listaAldea = new Contenedor<Aldea>();
        listaTorreta = new Contenedor<Torreta>();
        
		heroe = new Heroe(100,100);
		castillo = new Castillo();
		pincho = new Pincho();
        tienda = new Tienda();
    }
    
    @Override
    public void actualizar() {
        escenario.actualizar();
        heroe.actualizar();
        tienda.actualizar();
        //todas las clases basicamente que actualicen
    }

    @Override
    public void renderizar(Graphics g) {
        
        escenario.renderizar(g);
        tienda.renderizar(g);
        //heroe.renderizar(g);
        //g.drawImage(Recurso.cespedOscuroInferior, 0, 0, null);
    }

    
}
