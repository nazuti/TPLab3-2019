package Pantallas;

import Graficos.HojaSprites;
import Graficos.Recurso;
import Pantallas.Pantalla;
import Tablero.TableroJuego;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Abstracta.Tablero;

/**
 * 
 * @author ivanmdq22
 * @author Pardo
 * @author Nazuti.
 * @since 10/05/2019
 * @version 1.6
 * 
 * Clase que se encarga de crear un objeto juego implementa la interfaz runnable para utilizar hilos
 * @see <a href = "https://www.youtube.com/watch?v=qXhc4wbDaqU&t=186s" /> Hilos en Java </a>
 * 
 * @param objeto pantalla
 * @param ancho y largo de pantalla
 * @param boolean de ejecucion
 * @param hilo
 * @param imagenes de sprites y hoja de sprites
 * @param objeto estado del juego
 * @param objeto estado del menu
 * 
 */

public class Juego implements Runnable {
    
    
    public Pantalla ventana;
    public int ancho, alto;
    private String titulo;
    
    private boolean enEjecucion = false;
    private Thread hilo;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //temporal
    private BufferedImage test;
    private HojaSprites hoja;
    
    //Estados
    private Tablero estadoJuego;
    private Tablero estadoMenu;
    
    public Juego(String titulo, int ancho, int alto){
        
        this.ancho = ancho;
        this.alto = alto;
        this.titulo = titulo;
      
    }
    
    public void run(){
        
        inicializar();
        
        int fps = 60;
        double tiempoPorActualizacion = 1000000000 / fps; //mide ne nanosecs
        double delta = 0;
        long ahora;
        long ultimoSegundo = System.nanoTime();
        long temporizador = 0;
        int actualizaciones = 0;
        
        while(enEjecucion == true){
            ahora = System.nanoTime();
            delta += (ahora - ultimoSegundo) / tiempoPorActualizacion;
            temporizador += ahora - ultimoSegundo;
            ultimoSegundo = ahora;
            
            if(delta >=1){
                actualizar();
                renderizar();
                actualizaciones ++;
                delta--;
                
            }
            
            if(temporizador >= 1000000000){
                System.out.println("Actualizaciones y cuadros: " + actualizaciones);
                actualizaciones = 0;
                temporizador = 0;
            }
            
        }
        
        
    }
    
    private void inicializar(){
        
          ventana = new Pantalla(titulo, ancho, alto);
          Recurso.inicializar();
          
          estadoJuego = new TableroJuego(this);
          
          
          Tablero.setEstado(estadoJuego);
        // test = CargadorImagen.cargarImagen("/Utilidades/bg.png");
         // hoja = new HojaSprites(test);
    }
    
    private void actualizar(){
        if(Tablero.getEstado() != null)
            Tablero.getEstado().actualizar();
    }
    
    private void renderizar(){
        
        bs = ventana.getCanvas().getBufferStrategy();
        
        if(bs == null){
            ventana.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //LIMPIAR PANTALLA
        g.clearRect(0, 0, ancho, alto);
        //dIBUJAR
        
        if(Tablero.getEstado() != null)
            Tablero.getEstado().renderizar(g);
        //g.drawImage(Recurso.cespedOscuro, 10, 10, null);

        //g.drawImage(test, 0, 0, null);
        //g.drawImage(hoja.ajustar(64, 64, 32, 32), 5, 5, null);
        
        //terminar de dibujar
        bs.show();
        g.dispose();
    }
    
    /**
     * Si la ejecucuon ya esta en ejecucion no te deja incializar el juego. 
     */
    public synchronized void iniciar(){
        
        if(enEjecucion == true)
            return;
        
        enEjecucion = true;
        hilo = new Thread(this);
        hilo.start();
    }
    /**
     * Si la ejecucion no esta en ejecucion crea un hilo de ejecucion. 
     */
    public synchronized void detener(){
        
        if(enEjecucion == false)
            return;
        try {
            hilo.join();
        } catch (InterruptedException e) { 
           e.printStackTrace();
        }
    }
    
}
