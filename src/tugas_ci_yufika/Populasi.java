/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_ci_yufika;
import java.lang.ArrayIndexOutOfBoundsException;
/**
 *
 * @author TOSHIBA C40.A
 */
public final class Populasi {
     Individu[] individuals;
        private int totalBerat = 0;
        private int totalHarga = 0;
        private int totalFitness = 0;
       isi_array data=new isi_array();
        int size,tBerat;
       EvaluasiFitness evalFitness;

        int Fitness=0;double peluang;
        
      
       
    /*
     * Constructors
     */
    // Create a population

    /**
     *
     * @param populationSize
     * @param initialise
     * @param kapasitas
     * @param banyakBarang
     */
    public Populasi(int populationSize, boolean initialise, int kapasitas,int banyakBarang) {
        individuals = new Individu[populationSize];
         
         int berat = 0;
        // Initialise population
        if (initialise) {
            // Loop and create individuals
            
            for (int i = 0; i < populationSize; i++) {
                do{
                     Individu newIndividual = new Individu();
                     newIndividual.generateIndividual(banyakBarang);
                     berat=getBeratI(newIndividual);
                     saveIndividual(i, newIndividual);
                }while ( berat > kapasitas);
            }
        }
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

    /* Getters */
    public Individu getIndividual(int index) {
        return individuals[index];
    }

    int size() {
        return individuals.length;
    }

    // Save individual
    public void saveIndividual(int index, Individu indiv) {
        individuals[index] = indiv;
        totalBerat=0;
        totalHarga=0;
        totalFitness=0;
        peluang=0;
    }
    
    

}
     
