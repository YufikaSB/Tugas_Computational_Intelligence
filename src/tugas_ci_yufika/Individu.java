/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_ci_yufika;

import java.text.DecimalFormat;

/**
 *
 * @author TOSHIBA C40.A
 */
public class Individu {

    
    isi_array data=new isi_array();
    int defaultGeneLength;
;
        private final byte[] genes = new byte[20];
        // Cache
        private int BeratK = 0;
        private int HargaK = 0;
        private int Fitness;
        float peluang;
        float peluangKum;
        EvaluasiFitness evaluasi;
        int size;
   

        // Create a random individual
        public void generateIndividual(int banyakbarang) {
            int pGen = banyakbarang;
            setDefaultGeneLength(banyakbarang);
            for (int i = 0; i < size(); i++) {
                byte gene = (byte) Math.round(Math.random());
                genes[i] = gene;
            }
        }

        /* Getters and setters */
  
        public void setDefaultGeneLength(int length) {
            defaultGeneLength = length;
        }
    
        public byte getGene(int index) {
            return genes[index];
        }

        public void setGene(int index, byte value) {
            genes[index] = value;
            BeratK = 0;
            HargaK=0;
            Fitness=0;
            peluang=0;
 
        }

        /* Public methods */
        int size() {
            return genes.length;
        }

    public int getBerat(Individu indiv) {
            if (BeratK == 0) {
                BeratK =  evaluasi.getBeratI(indiv);
            }
            return BeratK;
        
        }     
        
        

        @Override
        public String toString() {
            String geneString = "";
            for (int i = 0; i < size(); i++) {
                geneString += getGene(i);
            }
            return geneString;
        }

}
