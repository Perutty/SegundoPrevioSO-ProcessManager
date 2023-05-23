/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author bp_rm
 */
public class Procesos {
    
    public Map<Integer, Proceso> tablaHash = new HashMap<>();
    
    public Procesos(){};
    
    public Procesos(Map<Integer, Proceso> tablaHash){
        this.tablaHash = tablaHash;
    }
}
