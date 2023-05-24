/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Proceso;
import Model.Procesos;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class ProcessController {
    
    public Proceso proceso;
    public Procesos procesos = new Procesos();
    
 public void taskList() throws FileNotFoundException, IOException{
            procesos.tablaHash.clear();
            String comando[]={"cmd.exe","/c", "tasklist", "/v", "/nh","/FO", "csv"};
            Process process=Runtime.getRuntime().exec(comando);
            BufferedReader is = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            String line;
                    while ((line = is.readLine()) != null) {
                    String[] parts = line.split(",");
                        proceso = new Proceso();
                        proceso.setNombre(parts[0].replace("\"",""));
                        proceso.setPid(parts[1].replace("\"",""));
                        proceso.setRam(parts[4].replace("\"",""));
                        proceso.setCpu(parts[7].replace("\"",""));
                        procesos.tablaHash.put(Integer.valueOf(parts[1].replace("\"","")), proceso);
                        System.out.println(procesos.tablaHash.get(Integer.valueOf(parts[1].replace("\"",""))).toString());
                    }
                        
            }
 
    public Procesos getTablaHash(){
     return procesos;
    }
    
    public void killProcess(Integer key) throws IOException{
        if(procesos.tablaHash.get(key)!=null){
            String comando2[]={"cmd.exe","/c", "taskkill", "/PID", ""+key,"/F"};
            Process process=Runtime.getRuntime().exec(comando2);
            procesos.tablaHash.remove(key);
            JOptionPane.showMessageDialog(null, "Proceso finalizado!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Proceso no encontrado!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println(key);
        System.out.println(procesos.tablaHash.get(key).toString());
        }
}