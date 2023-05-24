/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bp_rm
 */
public class Procesos {
    
    public Map<String, Proceso> tablaHash = new HashMap<>();
    
    public Procesos(){};
    
    public Procesos(Map<String, Proceso> tablaHash){
        this.tablaHash = tablaHash;
    }

    public Map<String, Proceso> getTablaHash() {
        return tablaHash;
    }

    public void setTablaHash(Map<String, Proceso> tablaHash) {
        this.tablaHash = tablaHash;
    }
}
