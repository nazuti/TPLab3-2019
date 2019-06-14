/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baldosas;

import Graficos.Recurso;
import java.awt.image.BufferedImage;

 /**
 * 
 * @author ivanmdq22
 * @author Pardo
 * @author Nazuti.
 * @since 10/05/2019
 * @version 1.6
 * 
 * Clase que permite crear un objeto baldosa de caracteristica "cesped oscuro".
 * <br> Presentacion sobre pilares de la POO by @author Benoffi7 </br>
 * @see <a href = "https://docs.google.com/presentation/d/1ln1p_6b44mKaHEJkfdimSZrOWz9hK5vg1FegjWzlkkg/edit#slide=id.g348419c47f_0_282" /> Herenecia en Java - PowerPoint</a>
 * @see {@link https://docs.google.com/presentation/d/1ln1p_6b44mKaHEJkfdimSZrOWz9hK5vg1FegjWzlkkg/edit#slide=id.g348419c47f_0_282}
 * @see  Baldosas.Baldosa
 *  
 */
public class BaldosaCespedOscuro extends Baldosa {

    public BaldosaCespedOscuro(int id) {
        super(Recurso.cespedOscuro, id);
    }
    
    
}
