/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_ci_yufika;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author TOSHIBA C40.A
 */
public class isi_array {
    
    //kelas array untuk berat barang
     public int[] arrayberat(){
        int[] berat={2,10,5,45,23,4,3,34,7,34,12,4,5,21,3,45,23,87,34,56};
        return berat;
     }
     
     //kelas array untuk profit
     public int[] arrayharga(){
        int[] harga={5000,4000,4000,100000,68000,2500,7400,36000,1200,200000,4500,
                            600,7400,3600,7500,47000,50000,87000,6800,6000};
        return harga;
     }
  
            
    //kelas mengambil nilai array berat
    public int bberat(int i){
          isi_array aberat=new isi_array();
        aberat.arrayberat();
        
        return aberat.arrayberat()[i];
    }
        
    //kelas menampilkan array profit
    
    public int iHarga(int i){
        isi_array aharga=new isi_array();
        aharga.arrayharga();
        
        return aharga.arrayharga()[i];
     
    }
}
