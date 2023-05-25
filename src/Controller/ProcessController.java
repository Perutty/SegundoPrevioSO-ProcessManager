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
                        procesos.tablaHash.put(parts[1], proceso);
                        System.out.println(procesos.tablaHash.get(parts[1]).toString());
                    }
    }
    
    public Procesos getTablaHash(){
     return procesos;
    }
    
    public void killProcess(String key) throws IOException{
            if(Integer.parseInt(key) >= 1000){
                String comando2[]={"cmd.exe","/c", "taskkill", "/PID", ""+key};
                Process process=Runtime.getRuntime().exec(comando2);
                BufferedReader is = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
                String line = is.readLine();
                if(line == null){
                        JOptionPane.showMessageDialog(null, "ERROR: no se encontró el PID "+key, "Error", JOptionPane.ERROR_MESSAGE);

                }else{
                       JOptionPane.showMessageDialog(null, ""+line, "Alerta", JOptionPane.WARNING_MESSAGE);
                }
            }else
                JOptionPane.showMessageDialog(null, "El PID que ingresó no es correcto finalizarlo", "Caution", JOptionPane.WARNING_MESSAGE);
    }
}
