/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_ci_yufika;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Yufika C40.A
 */

public class Tugas_CI_Yufika {
    

    public static int getInInteger(){
        int popsize=0;
        BufferedReader input= new BufferedReader(
                new InputStreamReader(System.in));
        try{
            popsize=Integer.parseInt(input.readLine()) ;
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return popsize;
    }
    int ukuran_populasi;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        //Definisi kelas-kelas
        EvaluasiFitness EvalFitness;
        Seleksi select;
        CrossOver CrossOver;
        Mutasi mutasi;
        Individu individu=new Individu();
        isi_array isiarray=new isi_array();
        isiarray.arrayberat();
        isiarray.arrayharga();
        int[] berat=isiarray.arrayberat();
        int[] profit=isiarray.arrayharga();
        int banyakbarang=berat.length;
        int fittest;
        
        //Tampilan Awal
        System.out.print("==========================================================================================================");
        System.out.println();
        System.out.print("BERAT : ");
        System.out.print(java.util.Arrays.toString(berat));
        System.out.println();
        System.out.print("==========================================================================================================");
        System.out.println();
        System.out.print("PROFIT : ");
        System.out.print(java.util.Arrays.toString(profit));
        System.out.println();
        System.out.print("==========================================================================================================");
        System.out.println();
        System.out.print("Kapasitas: ");
        int kapasitas=getInInteger();
        System.out.print("Ukuran Populasi: ");
        int psize=getInInteger();
        System.out.print("Probabilitas CrossOver: ");
        int PC=getInInteger();
        System.out.print("Probabilitas Mutasi: ");
        int PM=getInInteger();
        System.out.print("Iterasi/Banyaknya Generasi: ");
        int Iterasi=getInInteger();
        System.out.println("--------------------------------------------------");
        Individu[] IndividuTerbaik=new Individu[Iterasi];
        int[] FitnessTerbaik=new int[Iterasi];
        int[] Terbaik=new int[Iterasi];
        int[] BeratIndividu=new int[Iterasi];
        //Inisialisasi Populasi Awal
        Populasi populasi=new Populasi(psize,true,kapasitas,banyakbarang);
        int generationCount = 0;
        do{
            fittest=0;
            //Evaluasi Fitness Kromosom Populasi Awal
            EvalFitness=new EvaluasiFitness(populasi, kapasitas);
            System.out.println("POPULASI AWAL GENERASI "+(generationCount+1));
            
            for (int i=0;i<populasi.size();i++){
                System.out.print("Individu ke-"+(i+1)+": ");
                System.out.print(populasi.getIndividual(i));
                System.out.print(" ");
                System.out.print("Fitness= "+EvalFitness.getFitness(i));
                System.out.print(" ");
                System.out.println("Berat= "+EvalFitness.getBeratI(populasi.getIndividual(i)));
            }
                  
            //Seleksi Kromosom dari Populasi Awal
            select=new Seleksi(populasi,psize,EvalFitness);
            populasi=select.tournamentSelection(populasi,kapasitas,banyakbarang);
        
            //CrossOver
            CrossOver=new CrossOver();
            populasi=CrossOver.CrossOver(populasi,PC,psize,kapasitas,20);
        
            //Mutasi
            mutasi=new Mutasi();
            populasi=mutasi.Mutasi(populasi,PM,psize,kapasitas,20);
        
            //Evaluasi Populasi hasil Mutasi
            EvalFitness=new EvaluasiFitness(populasi, kapasitas);
            
         
            //Cari yang terbaik dari generasi ini
    
           
            System.out.println("-------------------------------------------------");
            System.out.println("Hasil setelah CrossOver dan Mutasi generasi "+(generationCount+1));
            
            for (int i=0;i<populasi.size();i++){
                System.out.print("Individu ke-"+(i+1)+": ");
                System.out.print(populasi.getIndividual(i));
                System.out.print(" ");
                System.out.print("Fitness= "+EvalFitness.getFitness(i));
                System.out.print(" ");
                System.out.println("Berat= "+EvalFitness.getBeratI(populasi.getIndividual(i)));
            }
            
            fittest=EvalFitness.Terbaik(populasi, kapasitas);
            if (fittest==0){
                System.out.println("INDIVIDU TERBAIK GENERASI KE- "+(generationCount+1)+"TIDAK ADA");
            }else  if (fittest>0) {
                System.out.println();
                System.out.print("INDIVIDU TERBAIK GENERASI KE- "+(generationCount+1)+": ");
                System.out.print(populasi.getIndividual(fittest-1));
                System.out.print("  ");
                System.out.print("Fitness= "+EvalFitness.getFitness(fittest-1));
                System.out.print("  ");
                System.out.println("Berat= "+EvalFitness.getBeratI(populasi.getIndividual(fittest-1)));
                IndividuTerbaik[generationCount]=populasi.getIndividual(fittest-1);
                FitnessTerbaik[generationCount]=EvalFitness.getFitness(fittest-1);
                BeratIndividu[generationCount]=EvalFitness.getBeratI(populasi.getIndividual(fittest-1));
                System.out.println("--------------------------------------------------");
            }
            System.out.println();
            generationCount++;
            
        }while (generationCount < Iterasi);

        System.out.println("--------------------------------------------------");
        System.out.println("HISTORY");
        System.out.println("--------------------------------------------------");
        for (int generasi=0;generasi<FitnessTerbaik.length;generasi++){
            System.out.print("Generasi ke- "+(generasi+1));
            System.out.print("  ");
            System.out.print(IndividuTerbaik[(generasi)]);
            System.out.print("  ");
            System.out.print("Fitness= "+FitnessTerbaik[(generasi)]);
            System.out.print("  ");
            System.out.println("Berat= "+BeratIndividu[(generasi)]);
        }
        System.out.println("--------------------------------------------------");
        
        //MENAMPILKAN HASIL AKHIR
        int mostTerbaik=0;
        for (int generasi=1;generasi<FitnessTerbaik.length;generasi++){
            if (FitnessTerbaik[mostTerbaik]<=FitnessTerbaik[generasi]){
                mostTerbaik=generasi;
            }mostTerbaik=mostTerbaik;
        }
        System.out.println("HASIL TERBAIK DARI "+generationCount+" GENERASI ADALAH SBB: ");
        System.out.println("--------------------------------------------------");
        System.out.print("Generasi ke- "+(mostTerbaik+1));
        System.out.print("  ");
        System.out.print(IndividuTerbaik[mostTerbaik]);
        System.out.print("  ");
        System.out.print("Fitness= "+FitnessTerbaik[mostTerbaik]);
        System.out.print("  ");
        System.out.println("Berat= "+BeratIndividu[mostTerbaik]);
        System.out.println("--------------------------------------------------");
        System.out.print("Barang ke-  ");
        System.out.print("Berat barang  ");
        System.out.println("Harga barang  ");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < IndividuTerbaik[mostTerbaik].size();i++) {
            if (IndividuTerbaik[mostTerbaik].getGene(i) == 1) {
                System.out.print(i+1+"  ");
                System.out.print("             ");
                System.out.print(berat[i]);
                System.out.print("             ");
                System.out.println(profit[i]);
            } 
        }System.out.println("--------------------------------------------------");
    }
    
}
