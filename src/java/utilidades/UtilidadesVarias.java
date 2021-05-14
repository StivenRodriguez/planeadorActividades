/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Vinni
 */
public class UtilidadesVarias {
    
    public static String formateoFechaHoy(){
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        return sd.format(new Date());
        
    }    
}
