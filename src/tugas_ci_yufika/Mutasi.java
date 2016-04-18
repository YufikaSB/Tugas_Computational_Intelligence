/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_ci_yufika;
import java.lang.NumberFormatException;
/**
 *
 * @author TOSHIBA C40.A
 */
public class Mutasi {
    
    public int defaultGeneLength;
    byte[] gen;
    
    public Populasi Mutasi(Populasi pop,int PM,int psize,int kapasitas, int banyakbarang){
        Populasi HasilMutasi=new Populasi(psize,false,200,20);
        int totalGen=psize*20;
        
        int ProbM=(20*psize*PM)/100;
        int iKromosom,iGen;
        byte gen0=0;
        byte gen1=1;
       
        MutasiGen(pop, ProbM, totalGen);
         
        //Memasukkan kembali gen ke dalam kromosom-kromosom
        int start,end;
        end=19;start=0;
        for (int p=0;p<pop.size();p++){
            Individu idiv=new Individu();
            int e=end;
            int i=0;
            do{
                byte g=gen[start];
                idiv.setGene(i, g);
                start++;e++;i++;
            }while (start<=end);
            HasilMutasi.saveIndividual(p, idiv);
            end=e;
        } 
       return HasilMutasi;
    }

    
    public void MutasiGen(Populasi pop, int ProbM, int totalGen){
        gen= new byte[totalGen];
        int[] Bil_Acak=new int[ProbM];
        //memasukkan gen ke dalam array gen
        int k=0;
        for (int i=0;i<pop.size();i++){
            for (int j=0;j<pop.getIndividual(i).size();j++){
                 gen[k]=pop.getIndividual(i).getGene(j);
                k++;
            }
        }
        
         //membangkitkan bilangan acak untuk posisi mutasi
        for(int i=0;i<ProbM;i++){
            int Ri=(int) (Math.random()*(totalGen-1));
            Bil_Acak[i]=Ri;
        }

        
        //Mengubah gen
        for (int i=0;i<Bil_Acak.length;i++){
            if (gen[Bil_Acak[i]]==0){
                gen[Bil_Acak[i]]=1;
            }  else if (gen[Bil_Acak[i]]==1){
                gen[Bil_Acak[i]]=0;
            }
        }
    }
}
