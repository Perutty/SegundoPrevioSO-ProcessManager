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

public class ProcessController {
    
    public Proceso proceso;
    public Procesos procesos = new Procesos();
    
 public void taskList() throws FileNotFoundException, IOException{
            String comando[]={"cmd.exe","/c", "tasklist", "/v", "/nh","/FO", "csv"};
            Process process=Runtime.getRuntime().exec(comando);
            BufferedReader is = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            String line;
                    int cont=0;
                    while ((line = is.readLine()) != null) {
                    String[] parts = line.split(",");
                        proceso = new Proceso();
                        proceso.setNombre(parts[0]);
                        proceso.setPid(parts[1]);
                        proceso.setRam(parts[4]);
                        proceso.setCpu(parts[7]);
                        procesos.tablaHash.put(cont, proceso);
                        cont++;
                    }
                        
            }
 
    public Procesos getTablaHash(){
     return procesos;
    }
 }