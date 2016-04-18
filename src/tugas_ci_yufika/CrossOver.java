/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_ci_yufika;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.NullPointerException;
/**
 *
 * @author TOSHIBA C40.A
 */
public final class CrossOver {
   
    public static int[][] induk;
    Individu[] IndivBaru;
    
    /**
     *
     * @param pop
     * @param PC
     * @param psize
     * @param kapasitas
     * @param banyakbarang
     * @return 
     */
    public static Populasi CrossOver(Populasi pop,float PC,int psize,int kapasitas, int banyakbarang){
    Populasi HasilCO=new Populasi(psize,false,200,20);
    float pc=PC;
    int Psize=psize;int kap=kapasitas; int bb=banyakbarang;
    Induk(pop,PC);
    Individu indiv1,indiv2;
    int Ri;
    
    for (int i=0;i<pop.size();i++){
        HasilCO.saveIndividual(i,pop.getIndividual(i));
    }
    
    int induk1,induk2;
    //Mengambil pasangan individu
    for (int i=0;i<pop.size()-1;i++){
        if (i>pop.size()){
            break;
        }
            induk1=induk[0][i];
            induk2=induk[1][i];
            if (induk1!=0 && induk2!=0){
                indiv1=pop.getIndividual(induk1 - 1);
                indiv2=pop.getIndividual(induk2 - 1);
            
                //CrossOver Individu
                Ri=(int) (Math.random()*(indiv1.size()-2));
                int k = Ri+1;
                do{
                    byte gen1=pop.getIndividual(induk1-1).getGene(k);
                    byte gen2=pop.getIndividual(induk2-1).getGene(k);
                    indiv1.setGene(k, gen2);
                    indiv2.setGene(k, gen1);
                    k++;
                }while (k < bb); 
                HasilCO.saveIndividual(induk1-1, indiv1);
                HasilCO.saveIndividual(induk2-1, indiv2);
            }
        }
        return HasilCO;
    }
    
     
    private static void Induk(Populasi pop, float PC){
        float R;
        float ProbC=(PC/100);
        induk=new int[2][pop.size()];
        int banyakInduk;
        banyakInduk=0;
        for (int i=0;i<pop.size();i++){
           R=(float) (Math.random()*1);
           if (ProbC >= R){
              banyakInduk=banyakInduk+1;
              if ((banyakInduk % 2)==1){
                  saveInduk(0,(banyakInduk/2),i+1);
              }else saveInduk(1,(banyakInduk/2)-1,i+1);
            }
        }
    }
    
    public static void saveInduk(int i,int j, int value){
       induk[i][j]=value;
    }
    
    public int getInduk(int i,int j){
        return induk[i][j];
    }
    
    public int size() {
        return induk.length;
    }
}
