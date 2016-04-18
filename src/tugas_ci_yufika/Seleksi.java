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
public final class Seleksi {

    EvaluasiFitness evalFitness;
    float peluang;
    float[] peluangKum;
    int TFitness;
    
    public Seleksi(Populasi pop, int kapasitas, EvaluasiFitness eval){
         peluangKum=new float[pop.size()];
         float tf=Float.parseFloat(String.valueOf(hitungTotalFitness(pop,eval)));
         float pk;
         int j;
         for (int i=0;i<pop.size();i++){
            float p;
            if (i==0){
                p=Float.parseFloat(String.valueOf(eval.getFitness(i)));
                pk=p/tf;
                savePeluangKum(i,pk);
            } else if (i > 0) {
            j=0;
            p=Float.parseFloat(String.valueOf(eval.getFitness(j)));
            pk=p/tf;
            do{
                j++;
                p=Float.parseFloat(String.valueOf(eval.getFitness(j)));
                pk=pk+(p/tf);
                savePeluangKum(i,pk);
            } while(j<i);
        }
         }
      }
      
      
      public int hitungTotalFitness(Populasi pop, EvaluasiFitness eval){
          TFitness=0;
          int fitness;
          for (int i=0;i<pop.size();i++){
              fitness=eval.getFitness(i);
              TFitness=TFitness+fitness;
          }
          return TFitness;
      }
      
   
      
    public void savePeluangKum(int index, float value) {
       peluangKum[index] = value;
    }
    
    public float getPeluangKum(int index) {
       return peluangKum[index];
    }
    
    public Populasi tournamentSelection(Populasi pop, int kapasitas, int banyakbarang) {
        Populasi populasibaru=new Populasi(pop.size(),false,kapasitas,banyakbarang);
        int j;
        for (int i=0;i<pop.size();i++){
            float p1,p2;
            float Ri=(float) (Math.random()*1);
                j=0;
                p1=getPeluangKum(j);
               do {
                    p1=getPeluangKum(j);
                    populasibaru.saveIndividual(i, pop.getIndividual(j));
                    j++;
                }while(Ri>p1 && j<=pop.size());
        }
        return populasibaru;
    }
    
 
      
}
