/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_ci_yufika;

/**
 *
 * @author TOSHIBA C40.A
 */
public final class EvaluasiFitness {
    int[] Fitness;int[] TFitness;
    int tBerat, tHarga;
    isi_array data=new isi_array();
    
    Individu[] individuals;
   // int[] beratBarang={2,10,5,45,23,4,3,34,7,34,12,4,5,21,3,45,23,87,34,56};
    //int[] hargaBarang={5000,4000,4000,100000,68000,2500,7400,36000,1200,200000,4500,
                          //  600,7400,3600,7500,47000,50000,87000,6800,6000};
    
    
    
    public EvaluasiFitness(Populasi pop, int kapasitas){
        int bb,hb,fit,kap;
        kap=kapasitas;
        Fitness=new int[pop.size()];
        for (int i=0;i<pop.size();i++){
            bb=getBeratI(pop.getIndividual(i));
            hb=0;
            if (bb <= kapasitas){
                hb=getHargaI(pop.getIndividual(i));
            }else {
                hb=0;
            }
            saveFitness(i,hb);
        }
    }
    
    public int arrayberat(int i){
        int[] berat={2,10,5,45,23,4,3,34,7,34,12,4,5,21,3,45,23,87,34,56};
        return berat[i];
     }
    
     public int arrayharga(int i){
        int[] harga={5000,4000,4000,100000,68000,2500,7400,36000,1200,200000,4500,600,7400,3600,7500,47000,50000,87000,6800,6000};
        return harga[i];
     }
    
     private int getHargaI(Individu individu) {
        int harga;
        harga = 0;
        tHarga=0;
        for (int i = 0; i < individu.size();i++) {
            if (individu.getGene(i) == 1) {
                harga=data.iHarga(i);
                tHarga=(tHarga+harga);
            } 
        }
        return  tHarga;
    }
    
    
    public int getBeratI(Individu individu) {
        int berat=0;
        tBerat=0;
        for (int i = 0; i < individu.size();i++) {
            if (individu.getGene(i) == 1) {
                berat=data.bberat(i);
                tBerat=(tBerat+berat);
            } 
        }
        return  tBerat;
    }
    
    public void saveFitness(int index, int value) {
       Fitness[index] = value;
   }
    
    public int getFitness(int index) {
       return Fitness[index];
   }
    
    public int Terbaik(Populasi pop,int kapasitas) {
      TFitness=new int[pop.size()];
      int[] TTFitness=new int[pop.size];
        for (int i = 0; i < pop.size(); ) {
            int berat=getBeratI(pop.getIndividual(i));
            if( berat<=kapasitas ){
                TFitness[i]=i+1;
            }i++;
        }
     
        //Mencari Fitness Terbaik
        int j=0;
        int Terbaik;
        do{
            Terbaik = TFitness[j];
            j++;
        }while(Terbaik==0 && j < TFitness.length);
        if (j!=TFitness.length && Terbaik!=0){
            Terbaik=Terbaik-1;
            for (int i=j;i<TFitness.length; i++){
                if (TFitness[i]!=0){
                    if (getFitness(Terbaik)<=getFitness(i)-1){
                        Terbaik=(TFitness[i]-1);
                    } 
                        Terbaik=Terbaik;
                }
            }
            Terbaik=Terbaik+1;
        }Terbaik=Terbaik;
        
    return Terbaik;
    }
    
        public int getTFitness(int index) {
        return TFitness[index];
        }
}
