/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamofausto;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edgar
 */
public class MetodosGenerales {
    
    
    
    static String nivel_usuario ="";
    public String nivel_acceso(String login,String pass){
        try {
            FileReader leer = new FileReader("usuarios.txt");
            BufferedReader b = new BufferedReader(leer);
            String linea=b.readLine();
            while(linea!=null){
                if(linea.split("~")[0].equals(login) && linea.split("~")[1].equals(pass)){
                    MetodosGenerales.nivel_usuario=linea.split("~")[2];
                    return linea.split("~")[2];
                   
                }
               
                linea=b.readLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo usuario");
        }
       return "no";
    }
    
    
      public String CuotaPrestamo(String id,String num_cuota){
        try {
            FileReader leer = new FileReader("Cuotas_Prestamos.txt");
            BufferedReader b= new BufferedReader(leer);
            String dato=b.readLine();
            while(dato!=null){
                if(id.equals(dato.split("~")[0]) && num_cuota.equals(dato.split("~")[1]) ){
                    return dato;
                }
                dato=b.readLine();
            }
            leer.close();
            b.close();
        } catch (IOException ex) {
        }
        
          return "no";
    }
    
    
     public void registrar (String ruta,String dato){
        try {
            FileWriter guardar = new FileWriter(ruta,true);
            guardar.write(dato+"\r\n");
            guardar.close();
            if(ruta.equals("Prestamos.txt")==false &&  ruta.equals("Cuotas_Prestamos.txt")==false &&  ruta.equals("Detalles_Cobros.txt")==false ){
              JOptionPane.showMessageDialog(null,"Se ha registrado correctamente.");
   
            }

        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,"El archivo no existe");
        }
        
        
    }
     
     
    
    public String validarID(String ruta,String id){
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader b= new BufferedReader(leer);
            String dato=b.readLine();
            while(dato!=null){
                if(id.equals(dato.split("~")[0])){
                    return dato;
                }
                dato=b.readLine();
            }
            leer.close();
            b.close();
        } catch (IOException ex) {
//             JOptionPane.showMessageDialog(null,"El archivo no existe","Error",JOptionPane.ERROR_MESSAGE);
        }
        
          return "no";
    }
    
    
    public String verificarCuotaTrue(String id_prestamo,String numero_cuota){
        
        try {
            FileReader leer = new FileReader("Cuotas_Prestamos.txt");
            BufferedReader b= new BufferedReader(leer);
            String dato=b.readLine();
            while(dato!=null){
                if(dato.split("~")[0].equals(id_prestamo) && numero_cuota.equals(dato.split("~")[1])){
                    return dato;
                }
                dato=b.readLine();
            }
            leer.close();
            b.close();
        } catch (IOException ex) {
        }
        
          return "no";
        
    }
    
    
    public String VerificarCobrosFalse(String idCli){
        try {
            FileReader leer = new FileReader("Cobros.txt");
            BufferedReader b= new BufferedReader(leer);
            String dato=b.readLine();
            while(dato!=null){
                if(dato.split("~")[2].equals(idCli) && dato.split("~")[5].equals("false")  ){
                    return dato;
                }
                dato=b.readLine();
            }
            leer.close();
            b.close();
        } catch (IOException ex) {
        }
        
          return "no";
    }
    
    public String validarCondicion(String ruta,String condicion,int posicion){
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader b= new BufferedReader(leer);
            String dato=b.readLine();
            while(dato!=null){
                if(condicion.equals(dato.split("~")[posicion])){
                    return dato;
                }
                dato=b.readLine();
            }
            leer.close();
            b.close();
        } catch (IOException ex) {
//             JOptionPane.showMessageDialog(null,"El archivo no existe","Error",JOptionPane.ERROR_MESSAGE);
        }
          return "no";
    }
    
    public void modificar (String ruta,String id,String dato){
        try{
            FileReader leer = new FileReader(ruta);
        BufferedReader b=new  BufferedReader(leer);
        String texto=b.readLine();
        FileWriter escribir = new FileWriter(ruta);
        while(texto!=null){
            if(id.equals(texto.split("~")[0])){
                escribir.write(dato+"\r\n");
            }else{
                escribir.write(texto+"\r\n");
            }
            texto=b.readLine();
        }
        escribir.close();
        if(ruta.equals("Cuotas_Prestamos.txt")==false){
         JOptionPane.showMessageDialog(null,"Se ha modificado correctamente.");
        }

        }catch (IOException ex) {
        }
        
    }
    
    
    public void modificarPrestamos (String ruta,String id,String dato){
        try{
            FileReader leer = new FileReader(ruta);
        BufferedReader b=new  BufferedReader(leer);
        String texto=b.readLine();
        FileWriter escribir = new FileWriter(ruta);
        while(texto!=null){
            if(id.equals(texto.split("~")[0])){
                escribir.write(dato+"\r\n");
            }else{
                escribir.write(texto+"\r\n");
            }
            texto=b.readLine();
        }
        escribir.close();
        }catch (IOException ex) {
        }
        
    }
    
     
    
    public ArrayList<String> LlenarTabla (String ruta){
        ArrayList<String> vector = new ArrayList();
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader b = new BufferedReader(leer);
            String linea=b.readLine();
            while(linea!=null){
                vector.add(linea);
                linea=b.readLine();
            }
            leer.close();
            b.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo");
        }
        return vector;
        
    }
    
    
    public void  LlenarTablaModel(String ruta,JTable tabla,int ElementosVector){
         DefaultTableModel  modelo =(DefaultTableModel) tabla.getModel();
         ArrayList vector = new ArrayList();
         modelo.setRowCount(0);
         tabla.setModel(modelo);
         String datos [ ] = new String [ElementosVector];
         vector=this.LlenarTabla(ruta);
         
         for (int i = 0; i <vector.size(); i++) {
           for(int j=0;j< ElementosVector; j++){
            datos[j]=vector.get(i).toString().split("~")[j];
           }
           modelo.addRow(datos);
         }
    }
    
     
    public void  LlenarTablaModel(String ruta,JTable tabla,int ElementosVector,String filtro, int posicion){
         DefaultTableModel  modelo =(DefaultTableModel) tabla.getModel();
         ArrayList vector = new ArrayList();
         modelo.setRowCount(0);
         tabla.setModel(modelo);
         String datos [ ] = new String [ElementosVector];
         vector=this.LlenarTablaCondicion(ruta,posicion,filtro);
         
         for (int i = 0; i <vector.size(); i++) {
           for(int j=0;j< ElementosVector; j++){
            datos[j]=vector.get(i).toString().split("~")[j];
           }
           modelo.addRow(datos);
         }
    }
    
    
//    public  void reecorrerInputs(){
//         for(int i=0;i<jPanel1.getComponentCount();i++){
//            System.out.println(jPanel1.getComponent(i));
//            if(jPanel1.getComponent(i) instanceof JTextField){
//             ((JTextField)jPanel1.getComponent(i)).setText("Keloque");
//            }
//        }
//    }
    
    public ArrayList<String> LlenarTablaRangoFecha (String ruta,Date desde,Date hasta,int posicionFecha){
        ArrayList<String> vector = new ArrayList();
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader b = new BufferedReader(leer); 
            String linea=b.readLine();
            while(linea!=null){
                Date fecha = new Date(linea.split("~")[posicionFecha]);
                if((fecha.after(desde) || fecha.equals(desde)  && (fecha.before(hasta) || fecha.equals(hasta) )  )){
                vector.add(linea);

                }
                linea=b.readLine();
            }
            leer.close();
            b.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo");
        }
        return vector;
        
    }
    
    
        public ArrayList<String> LlenarTablaRango (String ruta){
        ArrayList<String> vector = new ArrayList();
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader b = new BufferedReader(leer);
            String linea=b.readLine();
            while(linea!=null){
                vector.add(linea);
                linea=b.readLine();
            }
            b.close();
            leer.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo");
        }
        return vector;
        
    }
    
        public String IdAutomatico (String ruta){
        int i=0;
                
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader b = new BufferedReader(leer);
            String linea=b.readLine();
            while(linea!=null){
               i++;
                linea=b.readLine();
            }
            leer.close();
            b.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo");
        }
        return (++i+"");
        
    }
        
        public ArrayList<String> LlenarTablaCondicion (String ruta, int posicion, String condicion){
        ArrayList<String> vector = new ArrayList();
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader b = new BufferedReader(leer);
            String linea=b.readLine();
            while(linea!=null){
                if(linea.split("~")[posicion].equals(condicion)){
                  vector.add(linea);
                }
               
                linea=b.readLine();
            }
            leer.close();
            b.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo");
        }
        return vector;
        
    }
        
        public ArrayList<String> LlenarTablaSocioActivo (String ruta){
        ArrayList<String> vector = new ArrayList();
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader b = new BufferedReader(leer);
            String linea=b.readLine();
            while(linea!=null){
                if(linea.split("~")[10].equals("Socio Activo") && linea.split("~")[9].equals("true") ){
                  vector.add(linea);
                }
               
                linea=b.readLine();
            }
            leer.close();
            b.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo");
        }
        return vector;
        
    }
    
     public ArrayList<String> RangoID (String ruta,long desde,long hasta){
        ArrayList<String> vector = new ArrayList();
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader b = new BufferedReader(leer);
            String linea=b.readLine();
            while(linea!=null){
                long id=Long.parseLong(linea.split("~")[0]);
                if(id>=desde && id<=hasta){
                  vector.add(linea);
                }
               
                linea=b.readLine();
            }
            leer.close();
            b.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo");
        }
        return vector;
        
    }
    
    public void eliminar (String ruta,String id){
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader b = new BufferedReader(leer);
            String linea=b.readLine();
            FileWriter escribir = new FileWriter(ruta);
            while(linea!=null){
                 if(id.equals(linea.split("~")[0])==false){
                escribir.write(linea+"\r\n");
            }
                 linea=b.readLine();
            }
            escribir.close();
           JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente.");

     
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro en el archivo");
        }
      
        
        
    }
     
    
   
    
      public Paragraph  encabezado (String texto){
          Paragraph p = new Paragraph();
          Chunk  c = new Chunk();
          p.setAlignment(Element.ALIGN_CENTER);
          c.append(texto);
          p.add(c);
          return p;
          
      }
      
      
      public Paragraph  informacion (String texto){
          Paragraph p = new Paragraph();
          Chunk  c = new Chunk();
          c.append(texto);
          p.add(c);
          return p;
          
      }
      
      
      public Paragraph  pie (String texto){
          Paragraph p = new Paragraph();
          Chunk  c = new Chunk();
          p.setAlignment(Element.ALIGN_BOTTOM);
          c.append(texto);
          p.add(c);
          return p;
          
      }
         
    
    
    
    
    
    
}
