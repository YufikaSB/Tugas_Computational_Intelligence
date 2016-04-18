-------------------------------------------------------
TUGAS COMPUTATIONAL INTELLIGENCE
IMPLEMENTASI ALGORITMA GENETIKA DALAM KNAPSACK PROBLEM
-------------------------------------------------------
NAMA : YUFIKA SARI BAGI
NIM  : 15/388514/PPA/04953
-------------------------------------------------------
Petunjuk : 
Untuk menjalankan program,
Program Utama ada di kelas Tugas_CI_Yufika.java
kelas-kelas berada di >> src/tugas_ci_yufika
-------------------------------------------------------
A. Penjelasan Program
Program ini terdiri dari 8 kelas. 1 kelas memiliki main method (program utama)
1. Kelas Tugas_CI_Yufika.java 
   merupakan program utama.
   Untuk menjalankan program ini.
2. Kelas isi_array.java
   berisi data berat dan harga barang
3. Kelas Individu
   berfungsi untuk membentuk individu
4. Kelas Populasi
   berfungsi untuk membentuk dan menyimpan populasi
5. Kelas EvaluasiFitness
   berfungsi untuk melakukan perhitungan-perhitungan
6. Kelas Seleksi
   berfungsi untuk melakukan seleksi 
7. Kelas CrossOver
   berfungsi untuk melakukan crossover
8. Kelas Mutasi 
   berfungsi untuk melakukan mutasi
----------------------------------------------------------------------------

B. Gambaran Umum Tugas
Tugas ini yaitu mengimplementasikan algoritma genetika untuk mencari solusi terbaik dalam Knapsack problem.
Knapsack problem dalam tugas ini yaitu :
Misalnya terdapat 20 jenis barang dengan berat dan harga masing-masing barang:
------------------------------------------------------ 
Barang ke-	berat	harga
------------------------------------------------------
1		2	5,000
2		10	4,000
3		5	4,000
4		45	100,000	
5		23	68,000
6		4	2,500
7		3	7,400
8		34	36,000
9		7	1,200
10		34	200,000
11		12	4,500
12		4	600
13		5	7,400
14		21	3,600
15		3	7,500
16		45	47,000
17		23	50,000
18		87	87,000
19		34	6,800		
20		56	6,000
-------------------------------------------------------
Misalkan gerobak atau karung memiliki kapasitas tertentu dalam menampung barang, 
maka barang-barang apa saja yang bisa dibawa tanpa melewati kapasitas, tetapi memiliki keuntungan yang terbaik
Algoritma genetika digunakan dalam masalah ini untuk mencari solusi terbaik.
-------------------------------------------------------

C. Representasi Kromosom
Representasi kromosom dalam masalah ini menggunakan representasi biner, yaitu setiap gen adalah bilangan acak biner 
panjang kromosom yaitu 20 (sesuai banyaknya barang). 
-------------------------------------------------------

D. Fitness
Nilai fitness dari suatu individu bernilai 0 jika total berat individu tersebut melebihi kapasitas,
sebaliknya bernilai total harga individu tersebut.
Contoh : kapasitas=200
Individu ke-1: 00100110001011111000 Fitness= 133900 Berat= 121
Individu ke-2: 11010111000101010100 Fitness= 0 Berat= 255
Individu ke-3: 01010110111011010010 Fitness= 0 Berat= 220
Individu ke-4: 01110110011011100001 Fitness= 346900 Berat= 198

Individu ke-2 dan 3 fitnessnya bernilai 0 karena berat melebihi kapasitas
-------------------------------------------------------

E. Seleksi
Seleksi menggunakan metode Roullette Wheel Selection. Tahapan dari metode ini yaitu :
1. Menghitung total nilai fitness dari populasi tersebut
2. Menghitung peluang setiap individu dengan cara membagi nilai fitness individu dengan nilai fitness total
3. Menghitung peluang kumulatif dari setiap individu
   Peluang kumulatif individu pertama sama dengan peluang individu pertama.
   Sedangkan peluang kumulatif individu ke-2 dan selajutnya dihitung dengan menambahkan peluang kumulatif 
   individu sebelumnya dengan peluang individu yang dihitung
4. Membangkitkan bilangan acak (0-1) sebanyak pop size (jumlah individu dalam 1 populasi)
   kemudian membandingkan bilangan acak tersebut dengan masing-masing individu (dimulai dari individu 1)
   jika bilangan acak kurang dari peluang kumulatif individu yang dibandingkan, maka individu tersebut terpilih.
Contoh Perhitungan peluang kumulatif
Individu	kromosom	    fitness   Peluang Kumulatif
-----------------------------------------------------
Individu ke-1: 10111001100000010000  261200    0.4373012
Individu ke-2: 00001000000101100011  92500     0.59216475
Individu ke-3: 10010011000001000010  158800    0.8580278
Individu ke-4: 00100000001101001000  62700     0.9630002
Individu ke-5: 01100000001001000001  22100     1.0
-------------------------------------------------------  

F. Crossover
Jenis crossover yang digunakan yaitu crossover 1 titik. Tahapan dalam crossover :
1. Memilih pasangan induk dengan cara membangkitkan bilangan acak sebanyak pop size
   jika bilangan acak ke-i kurang dari probabilitas crossover (PC), maka individu ke-i terpilih
2. Menentukan posisi/titik crossover dengan membangkitkan bilangan acak 0 sampai 18 (java memulai indeksnya 0)
3. Menukarkan potongan gen berdasarkan posisi yang telah ditentukan.
-------------------------------------------------------

G. MUTASI
Jumlah gen yang mengalami mutasi ditentukan oleh parameter mutation_rate.
tahapan mutasi:
1. Menghitung total gen = (banyak gen dalam 1 individu * pop size)
2. Menghitung jumlah gen yang akan mengalami mutasi berdasarkan probabilitas mutasi
3. Menentukan posisi gen yang akan dimutasi dengan membangkitkan bilangan acak 0 sampai total gen-1
4. Mengganti bilangan  gen tersebut.
   jika bilangan gen tersebut adalah 1, maka diganti menjadi 0, begitu juga sebaliknya.
-----------------------------------------------------------------


CONTOH RUN DAN OUTPUT PROGRAM
run:
==========================================================================================================
BERAT : [2, 10, 5, 45, 23, 4, 3, 34, 7, 34, 12, 4, 5, 21, 3, 45, 23, 87, 34, 56]
==========================================================================================================
PROFIT : [5000, 4000, 4000, 100000, 68000, 2500, 7400, 36000, 1200, 200000, 4500, 600, 7400, 3600, 7500, 47000, 50000, 87000, 6800, 6000]
==========================================================================================================
Kapasitas: 200
Ukuran Populasi: 30
Probabilitas CrossOver: 60
Probabilitas Mutasi: 10
Iterasi/Banyaknya Generasi: 5
--------------------------------------------------
POPULASI AWAL GENERASI 1
Individu ke-1: 01011010100010101010 Fitness= 252300 Berat= 153
Individu ke-2: 01000010111111001000 Fitness= 278700 Berat= 119
Individu ke-3: 00001001000000000101 Fitness= 197000 Berat= 200
Individu ke-4: 10010010000001000010 Fitness= 122800 Berat= 105
Individu ke-5: 00100000110000111001 Fitness= 315700 Berat= 173
Individu ke-6: 00100111011011000000 Fitness= 265400 Berat= 118
Individu ke-7: 00101010010110011000 Fitness= 384400 Berat= 142
Individu ke-8: 01000001001010100100 Fitness= 146400 Berat= 151
Individu ke-9: 10011110010111100010 Fitness= 408800 Berat= 178
Individu ke-10: 11010110100100101010 Fitness= 185000 Berat= 135
Individu ke-11: 01100100100100100110 Fitness= 113600 Berat= 154
Individu ke-12: 11100000011001011000 Fitness= 318100 Berat= 152
Individu ke-13: 00101011100100001100 Fitness= 254200 Berat= 186
Individu ke-14: 00001000010111101010 Fitness= 343900 Berat= 147
Individu ke-15: 11110001000100100011 Fitness= 169900 Berat= 193
Individu ke-16: 10000001010110011010 Fitness= 352800 Berat= 181
Individu ke-17: 00100100011100010001 Fitness= 264600 Berat= 160
Individu ke-18: 10011000100011000000 Fitness= 185200 Berat= 103
Individu ke-19: 11101010000010001011 Fitness= 158600 Berat= 161
Individu ke-20: 10000010101010111100 Fitness= 217000 Berat= 187
Individu ke-21: 10011101100000100000 Fitness= 220200 Berat= 118
Individu ke-22: 11000100110000101000 Fitness= 270200 Berat= 83
Individu ke-23: 01000101111000111000 Fitness= 352700 Berat= 172
Individu ke-24: 01000110101111000001 Fitness= 37200 Berat= 122
Individu ke-25: 01001010000101011000 Fitness= 180600 Berat= 129
Individu ke-26: 10110110100110101001 Fitness= 191600 Berat= 157
Individu ke-27: 00111001000110101010 Fitness= 280300 Berat= 176
Individu ke-28: 10000110011111100010 Fitness= 245300 Berat= 122
Individu ke-29: 01010110100101111010 Fitness= 230600 Berat= 199
Individu ke-30: 10101010011001110010 Fitness= 353800 Berat= 182
-------------------------------------------------
Hasil setelah CrossOver dan Mutasi generasi 1
Individu ke-1: 00011101100000000011 Fitness= 0 Berat= 203
Individu ke-2: 00101011100100101100 Fitness= 261700 Berat= 189
Individu ke-3: 11110001010110011000 Fitness= 0 Berat= 207
Individu ke-4: 10010000010011001000 Fitness= 366000 Berat= 130
Individu ke-5: 01001110000001011000 Fitness= 182500 Berat= 129
Individu ke-6: 01000010111111001010 Fitness= 285500 Berat= 153
Individu ke-7: 00100000111000111001 Fitness= 320200 Berat= 185
Individu ke-8: 00100000110000111001 Fitness= 315700 Berat= 173
Individu ke-9: 10010101110000100011 Fitness= 0 Berat= 219
Individu ke-10: 10101010100010001011 Fitness= 155800 Berat= 158
Individu ke-11: 01011010000010101000 Fitness= 244300 Berat= 112
Individu ke-12: 00111001010100110110 Fitness= 0 Berat= 314
Individu ke-13: 00111110010101100000 Fitness= 393600 Berat= 142
Individu ke-14: 11111101010110011000 Fitness= 0 Berat= 234
Individu ke-15: 11000100010010101010 Fitness= 283200 Berat= 115
Individu ke-16: 01101010010111100010 Fitness= 309300 Berat= 142
Individu ke-17: 01000100100110101101 Fitness= 166200 Berat= 199
Individu ke-18: 11100111001011000000 Fitness= 74400 Berat= 96
Individu ke-19: 10001111011011000000 Fitness= 334400 Berat= 138
Individu ke-20: 00110100011111010101 Fitness= 0 Berat= 318
Individu ke-21: 00111110010111100010 Fitness= 407800 Berat= 181
Individu ke-22: 10010100001101100111 Fitness= 0 Berat= 268
Individu ke-23: 01001000111001011000 Fitness= 378300 Berat= 175
Individu ke-24: 00111001000100100110 Fitness= 0 Berat= 235
Individu ke-25: 10001001000001000101 Fitness= 0 Berat= 223
Individu ke-26: 01100100100110101010 Fitness= 84000 Berat= 95
Individu ke-27: 10010110011111000010 Fitness= 337800 Berat= 164
Individu ke-28: 00111110010111100010 Fitness= 407800 Berat= 181
Individu ke-29: 01100110101111001001 Fitness= 91200 Berat= 150
Individu ke-30: 01001010000101111000 Fitness= 188100 Berat= 132

INDIVIDU TERBAIK GENERASI KE- 1: 00111110010111100010  Fitness= 407800  Berat= 181
--------------------------------------------------

POPULASI AWAL GENERASI 2
Individu ke-1: 00011101100000000011 Fitness= 0 Berat= 203
Individu ke-2: 00101011100100101100 Fitness= 261700 Berat= 189
Individu ke-3: 11110001010110011000 Fitness= 0 Berat= 207
Individu ke-4: 10010000010011001000 Fitness= 366000 Berat= 130
Individu ke-5: 01001110000001011000 Fitness= 182500 Berat= 129
Individu ke-6: 01000010111111001010 Fitness= 285500 Berat= 153
Individu ke-7: 00100000111000111001 Fitness= 320200 Berat= 185
Individu ke-8: 00100000110000111001 Fitness= 315700 Berat= 173
Individu ke-9: 10010101110000100011 Fitness= 0 Berat= 219
Individu ke-10: 10101010100010001011 Fitness= 155800 Berat= 158
Individu ke-11: 01011010000010101000 Fitness= 244300 Berat= 112
Individu ke-12: 00111001010100110110 Fitness= 0 Berat= 314
Individu ke-13: 00111110010101100000 Fitness= 393600 Berat= 142
Individu ke-14: 11111101010110011000 Fitness= 0 Berat= 234
Individu ke-15: 11000100010010101010 Fitness= 283200 Berat= 115
Individu ke-16: 01101010010111100010 Fitness= 309300 Berat= 142
Individu ke-17: 01000100100110101101 Fitness= 166200 Berat= 199
Individu ke-18: 11100111001011000000 Fitness= 74400 Berat= 96
Individu ke-19: 10001111011011000000 Fitness= 334400 Berat= 138
Individu ke-20: 00110100011111010101 Fitness= 0 Berat= 318
Individu ke-21: 00111110010111100010 Fitness= 407800 Berat= 181
Individu ke-22: 10010100001101100111 Fitness= 0 Berat= 268
Individu ke-23: 01001000111001011000 Fitness= 378300 Berat= 175
Individu ke-24: 00111001000100100110 Fitness= 0 Berat= 235
Individu ke-25: 10001001000001000101 Fitness= 0 Berat= 223
Individu ke-26: 01100100100110101010 Fitness= 84000 Berat= 95
Individu ke-27: 10010110011111000010 Fitness= 337800 Berat= 164
Individu ke-28: 00111110010111100010 Fitness= 407800 Berat= 181
Individu ke-29: 01100110101111001001 Fitness= 91200 Berat= 150
Individu ke-30: 01001010000101111000 Fitness= 188100 Berat= 132
-------------------------------------------------
Hasil setelah CrossOver dan Mutasi generasi 2
Individu ke-1: 00011000110010001001 Fitness= 432600 Berat= 193
Individu ke-2: 01001010010111100000 Fitness= 298500 Berat= 103
Individu ke-3: 10000110000001011000 Fitness= 115500 Berat= 98
Individu ke-4: 01100101010010101010 Fitness= 318200 Berat= 152
Individu ke-5: 00111110010111101100 Fitness= 0 Berat= 257
Individu ke-6: 01011010001010100000 Fitness= 198800 Berat= 101
Individu ke-7: 00101000100110101101 Fitness= 0 Berat= 213
Individu ke-8: 00101010010111100010 Fitness= 305300 Berat= 132
Individu ke-9: 00000111100000100010 Fitness= 61400 Berat= 85
Individu ke-10: 00101000100110101111 Fitness= 0 Berat= 247
Individu ke-11: 01000110110110110000 Fitness= 277600 Berat= 115
Individu ke-12: 01001010000101011010 Fitness= 187400 Berat= 163
Individu ke-13: 01011010000010100000 Fitness= 194300 Berat= 89
Individu ke-14: 00100001110000111001 Fitness= 0 Berat= 207
Individu ke-15: 01011010000010100001 Fitness= 200300 Berat= 145
Individu ke-16: 00110110011101100010 Fitness= 336900 Berat= 165
Individu ke-17: 10100010011001011000 Fitness= 321500 Berat= 145
Individu ke-18: 00101010100000001010 Fitness= 137400 Berat= 95
Individu ke-19: 01111000110110101101 Fitness= 0 Berat= 302
Individu ke-20: 11000110010011011000 Fitness= 326900 Berat= 147
Individu ke-21: 11000010111111001010 Fitness= 290500 Berat= 155
Individu ke-22: 01001110111111001001 Fitness= 0 Berat= 202
Individu ke-23: 00000111001011010010 Fitness= 115200 Berat= 158
Individu ke-24: 11100110000100101100 Fitness= 168000 Berat= 141
Individu ke-25: 01011110010111100100 Fitness= 0 Berat= 239
Individu ke-26: 01001010000100111100 Fitness= 271500 Berat= 198
Individu ke-27: 10000110000001001001 Fitness= 74500 Berat= 109
Individu ke-28: 10001111111011100110 Fitness= 0 Berat= 269
Individu ke-29: 01011110000010100000 Fitness= 196800 Berat= 93
Individu ke-30: 10000000110011001000 Fitness= 267200 Berat= 92

INDIVIDU TERBAIK GENERASI KE- 2: 00011000110010001001  Fitness= 432600  Berat= 193
--------------------------------------------------

POPULASI AWAL GENERASI 3
Individu ke-1: 00011000110010001001 Fitness= 432600 Berat= 193
Individu ke-2: 01001010010111100000 Fitness= 298500 Berat= 103
Individu ke-3: 10000110000001011000 Fitness= 115500 Berat= 98
Individu ke-4: 01100101010010101010 Fitness= 318200 Berat= 152
Individu ke-5: 00111110010111101100 Fitness= 0 Berat= 257
Individu ke-6: 01011010001010100000 Fitness= 198800 Berat= 101
Individu ke-7: 00101000100110101101 Fitness= 0 Berat= 213
Individu ke-8: 00101010010111100010 Fitness= 305300 Berat= 132
Individu ke-9: 00000111100000100010 Fitness= 61400 Berat= 85
Individu ke-10: 00101000100110101111 Fitness= 0 Berat= 247
Individu ke-11: 01000110110110110000 Fitness= 277600 Berat= 115
Individu ke-12: 01001010000101011010 Fitness= 187400 Berat= 163
Individu ke-13: 01011010000010100000 Fitness= 194300 Berat= 89
Individu ke-14: 00100001110000111001 Fitness= 0 Berat= 207
Individu ke-15: 01011010000010100001 Fitness= 200300 Berat= 145
Individu ke-16: 00110110011101100010 Fitness= 336900 Berat= 165
Individu ke-17: 10100010011001011000 Fitness= 321500 Berat= 145
Individu ke-18: 00101010100000001010 Fitness= 137400 Berat= 95
Individu ke-19: 01111000110110101101 Fitness= 0 Berat= 302
Individu ke-20: 11000110010011011000 Fitness= 326900 Berat= 147
Individu ke-21: 11000010111111001010 Fitness= 290500 Berat= 155
Individu ke-22: 01001110111111001001 Fitness= 0 Berat= 202
Individu ke-23: 00000111001011010010 Fitness= 115200 Berat= 158
Individu ke-24: 11100110000100101100 Fitness= 168000 Berat= 141
Individu ke-25: 01011110010111100100 Fitness= 0 Berat= 239
Individu ke-26: 01001010000100111100 Fitness= 271500 Berat= 198
Individu ke-27: 10000110000001001001 Fitness= 74500 Berat= 109
Individu ke-28: 10001111111011100110 Fitness= 0 Berat= 269
Individu ke-29: 01011110000010100000 Fitness= 196800 Berat= 93
Individu ke-30: 10000000110011001000 Fitness= 267200 Berat= 92
-------------------------------------------------
Hasil setelah CrossOver dan Mutasi generasi 3
Individu ke-1: 10000000110011000000 Fitness= 217200 Berat= 69
Individu ke-2: 01111110000101101011 Fitness= 0 Berat= 231
Individu ke-3: 10011001100001001000 Fitness= 263800 Berat= 155
Individu ke-4: 01011110001100100010 Fitness= 201300 Berat= 138
Individu ke-5: 00110010011010101000 Fitness= 380800 Berat= 130
Individu ke-6: 00010110110111001010 Fitness= 379500 Berat= 180
Individu ke-7: 00110110011010100000 Fitness= 333300 Berat= 111
Individu ke-8: 11010110110110011100 Fitness= 0 Berat= 269
Individu ke-9: 11000111000000100010 Fitness= 69200 Berat= 90
Individu ke-10: 11000010111111111001 Fitness= 0 Berat= 225
Individu ke-11: 00001010010010100001 Fitness= 296300 Berat= 124
Individu ke-12: 11000110111111001001 Fitness= 292200 Berat= 181
Individu ke-13: 01011010000010100000 Fitness= 194300 Berat= 89
Individu ke-14: 01001010100101011110 Fitness= 0 Berat= 257
Individu ke-15: 01011010001010100100 Fitness= 285800 Berat= 188
Individu ke-16: 01011110000100100010 Fitness= 196800 Berat= 126
Individu ke-17: 11001010000001001101 Fitness= 0 Berat= 225
Individu ke-18: 01010110110110110000 Fitness= 377600 Berat= 160
Individu ke-19: 00010010110011001000 Fitness= 369600 Berat= 138
Individu ke-20: 01001010000100111000 Fitness= 184500 Berat= 111
Individu ke-21: 00101011010111000010 Fitness= 333800 Berat= 163
Individu ke-22: 00111000110010000001 Fitness= 386600 Berat= 175
Individu ke-23: 00000110010011011010 Fitness= 324700 Berat= 169
Individu ke-24: 01001010000100110000 Fitness= 134500 Berat= 88
Individu ke-25: 00101011010101100100 Fitness= 0 Berat= 214
Individu ke-26: 00001010100000001010 Fitness= 133400 Berat= 90
Individu ke-27: 11000101100010100011 Fitness= 76400 Berat= 155
Individu ke-28: 01011010100010100000 Fitness= 195500 Berat= 96
Individu ke-29: 00000110000011001010 Fitness= 77700 Berat= 90
Individu ke-30: 00110110011010100000 Fitness= 333300 Berat= 111

INDIVIDU TERBAIK GENERASI KE- 3: 00111000110010000001  Fitness= 386600  Berat= 175
--------------------------------------------------

POPULASI AWAL GENERASI 4
Individu ke-1: 10000000110011000000 Fitness= 217200 Berat= 69
Individu ke-2: 01111110000101101011 Fitness= 0 Berat= 231
Individu ke-3: 10011001100001001000 Fitness= 263800 Berat= 155
Individu ke-4: 01011110001100100010 Fitness= 201300 Berat= 138
Individu ke-5: 00110010011010101000 Fitness= 380800 Berat= 130
Individu ke-6: 00010110110111001010 Fitness= 379500 Berat= 180
Individu ke-7: 00110110011010100000 Fitness= 333300 Berat= 111
Individu ke-8: 11010110110110011100 Fitness= 0 Berat= 269
Individu ke-9: 11000111000000100010 Fitness= 69200 Berat= 90
Individu ke-10: 11000010111111111001 Fitness= 0 Berat= 225
Individu ke-11: 00001010010010100001 Fitness= 296300 Berat= 124
Individu ke-12: 11000110111111001001 Fitness= 292200 Berat= 181
Individu ke-13: 01011010000010100000 Fitness= 194300 Berat= 89
Individu ke-14: 01001010100101011110 Fitness= 0 Berat= 257
Individu ke-15: 01011010001010100100 Fitness= 285800 Berat= 188
Individu ke-16: 01011110000100100010 Fitness= 196800 Berat= 126
Individu ke-17: 11001010000001001101 Fitness= 0 Berat= 225
Individu ke-18: 01010110110110110000 Fitness= 377600 Berat= 160
Individu ke-19: 00010010110011001000 Fitness= 369600 Berat= 138
Individu ke-20: 01001010000100111000 Fitness= 184500 Berat= 111
Individu ke-21: 00101011010111000010 Fitness= 333800 Berat= 163
Individu ke-22: 00111000110010000001 Fitness= 386600 Berat= 175
Individu ke-23: 00000110010011011010 Fitness= 324700 Berat= 169
Individu ke-24: 01001010000100110000 Fitness= 134500 Berat= 88
Individu ke-25: 00101011010101100100 Fitness= 0 Berat= 214
Individu ke-26: 00001010100000001010 Fitness= 133400 Berat= 90
Individu ke-27: 11000101100010100011 Fitness= 76400 Berat= 155
Individu ke-28: 01011010100010100000 Fitness= 195500 Berat= 96
Individu ke-29: 00000110000011001010 Fitness= 77700 Berat= 90
Individu ke-30: 00110110011010100000 Fitness= 333300 Berat= 111
-------------------------------------------------
Hasil setelah CrossOver dan Mutasi generasi 4
Individu ke-1: 00000110010011011010 Fitness= 324700 Berat= 169
Individu ke-2: 00001011011111000000 Fitness= 327500 Berat= 136
Individu ke-3: 00110110111111001010 Fitness= 388000 Berat= 197
Individu ke-4: 01011010000100110010 Fitness= 241300 Berat= 167
Individu ke-5: 01000100110110110000 Fitness= 270200 Berat= 112
Individu ke-6: 00010010100011000000 Fitness= 119600 Berat= 81
Individu ke-7: 10111000110010000001 Fitness= 391600 Berat= 177
Individu ke-8: 00001011010111100000 Fitness= 330500 Berat= 127
Individu ke-9: 01011110001000101000 Fitness= 243900 Berat= 123
Individu ke-10: 00001010101000001000 Fitness= 131100 Berat= 68
Individu ke-11: 01011010000010100001 Fitness= 200300 Berat= 145
Individu ke-12: 00100110011010100001 Fitness= 239300 Berat= 122
Individu ke-13: 00110110110110100001 Fitness= 336600 Berat= 166
Individu ke-14: 00110010011000100000 Fitness= 323400 Berat= 102
Individu ke-15: 00001010010101000000 Fitness= 279600 Berat= 85
Individu ke-16: 00110110110010100000 Fitness= 330000 Berat= 106
Individu ke-17: 00001000100000101010 Fitness= 133500 Berat= 90
Individu ke-18: 10011101000100110010 Fitness= 273400 Berat= 194
Individu ke-19: 00010110110011001100 Fitness= 0 Berat= 229
Individu ke-20: 00110101011111001010 Fitness= 0 Berat= 221
Individu ke-21: 00011010110010100001 Fitness= 397500 Berat= 176
Individu ke-22: 01000011010111000000 Fitness= 259000 Berat= 111
Individu ke-23: 10001011010111000000 Fitness= 328000 Berat= 126
Individu ke-24: 11010010001011001000 Fitness= 181900 Berat= 121
Individu ke-25: 10011001100010100110 Fitness= 0 Berat= 240
Individu ke-26: 01001010010010001000 Fitness= 336800 Berat= 98
Individu ke-27: 00000110010011011110 Fitness= 0 Berat= 256
Individu ke-28: 11001010000010100001 Fitness= 105300 Berat= 102
Individu ke-29: 01011110111100100011 Fitness= 0 Berat= 235
Individu ke-30: 01001010000100111000 Fitness= 184500 Berat= 111

INDIVIDU TERBAIK GENERASI KE- 4: 00011010110010100001  Fitness= 397500  Berat= 176
--------------------------------------------------

POPULASI AWAL GENERASI 5
Individu ke-1: 00000110010011011010 Fitness= 324700 Berat= 169
Individu ke-2: 00001011011111000000 Fitness= 327500 Berat= 136
Individu ke-3: 00110110111111001010 Fitness= 388000 Berat= 197
Individu ke-4: 01011010000100110010 Fitness= 241300 Berat= 167
Individu ke-5: 01000100110110110000 Fitness= 270200 Berat= 112
Individu ke-6: 00010010100011000000 Fitness= 119600 Berat= 81
Individu ke-7: 10111000110010000001 Fitness= 391600 Berat= 177
Individu ke-8: 00001011010111100000 Fitness= 330500 Berat= 127
Individu ke-9: 01011110001000101000 Fitness= 243900 Berat= 123
Individu ke-10: 00001010101000001000 Fitness= 131100 Berat= 68
Individu ke-11: 01011010000010100001 Fitness= 200300 Berat= 145
Individu ke-12: 00100110011010100001 Fitness= 239300 Berat= 122
Individu ke-13: 00110110110110100001 Fitness= 336600 Berat= 166
Individu ke-14: 00110010011000100000 Fitness= 323400 Berat= 102
Individu ke-15: 00001010010101000000 Fitness= 279600 Berat= 85
Individu ke-16: 00110110110010100000 Fitness= 330000 Berat= 106
Individu ke-17: 00001000100000101010 Fitness= 133500 Berat= 90
Individu ke-18: 10011101000100110010 Fitness= 273400 Berat= 194
Individu ke-19: 00010110110011001100 Fitness= 0 Berat= 229
Individu ke-20: 00110101011111001010 Fitness= 0 Berat= 221
Individu ke-21: 00011010110010100001 Fitness= 397500 Berat= 176
Individu ke-22: 01000011010111000000 Fitness= 259000 Berat= 111
Individu ke-23: 10001011010111000000 Fitness= 328000 Berat= 126
Individu ke-24: 11010010001011001000 Fitness= 181900 Berat= 121
Individu ke-25: 10011001100010100110 Fitness= 0 Berat= 240
Individu ke-26: 01001010010010001000 Fitness= 336800 Berat= 98
Individu ke-27: 00000110010011011110 Fitness= 0 Berat= 256
Individu ke-28: 11001010000010100001 Fitness= 105300 Berat= 102
Individu ke-29: 01011110111100100011 Fitness= 0 Berat= 235
Individu ke-30: 01001010000100111000 Fitness= 184500 Berat= 111
-------------------------------------------------
Hasil setelah CrossOver dan Mutasi generasi 5
Individu ke-1: 00111110111111001010 Fitness= 0 Berat= 220
Individu ke-2: 00111010111110100001 Fitness= 406600 Berat= 197
Individu ke-3: 01001010010010001000 Fitness= 336800 Berat= 98
Individu ke-4: 11001110001011001010 Fitness= 159200 Berat= 137
Individu ke-5: 10110110110110101001 Fitness= 391600 Berat= 191
Individu ke-6: 00111111110010100000 Fitness= 434000 Berat= 163
Individu ke-7: 01001010010010011000 Fitness= 383800 Berat= 143
Individu ke-8: 10001011010111100001 Fitness= 341500 Berat= 185
Individu ke-9: 00011101110001000000 Fitness= 411300 Berat= 168
Individu ke-10: 01001001000100110010 Fitness= 169900 Berat= 153
Individu ke-11: 00010110100110100001 Fitness= 132600 Berat= 127
Individu ke-12: 01011011011111000000 Fitness= 431500 Berat= 191
Individu ke-13: 00001100000111111000 Fitness= 186600 Berat= 128
Individu ke-14: 01001011010111000000 Fitness= 327000 Berat= 134
Individu ke-15: 01011011011111000100 Fitness= 0 Berat= 278
Individu ke-16: 10001011010111100000 Fitness= 335500 Berat= 129
Individu ke-17: 00001110001010010010 Fitness= 143600 Berat= 126
Individu ke-18: 01011010110010100000 Fitness= 395500 Berat= 130
Individu ke-19: 00001011011111000000 Fitness= 327500 Berat= 136
Individu ke-20: 00001110001010010010 Fitness= 143600 Berat= 126
Individu ke-21: 01011011011111000000 Fitness= 431500 Berat= 191
Individu ke-22: 01010010010000000001 Fitness= 317400 Berat= 148
Individu ke-23: 10101010000000101001 Fitness= 147900 Berat= 115
Individu ke-24: 10111011001010100001 Fitness= 245800 Berat= 188
Individu ke-25: 00110010011111001010 Fitness= 384300 Berat= 186
Individu ke-26: 01001110110011111000 Fitness= 398600 Berat= 178
Individu ke-27: 00000110010000111000 Fitness= 314400 Berat= 112
Individu ke-28: 00001100001011011010 Fitness= 189800 Berat= 167
Individu ke-29: 00001110001010011110 Fitness= 0 Berat= 236
Individu ke-30: 01011011011111000000 Fitness= 431500 Berat= 191

INDIVIDU TERBAIK GENERASI KE- 5: 00111111110010100000  Fitness= 434000  Berat= 163
--------------------------------------------------

--------------------------------------------------
HISTORY
--------------------------------------------------
Generasi ke- 1  00111110010111101100  Fitness= 407800  Berat= 181
Generasi ke- 2  00000110010011001010  Fitness= 432600  Berat= 193
Generasi ke- 3  00111000110010000001  Fitness= 386600  Berat= 175
Generasi ke- 4  00011010110010100001  Fitness= 397500  Berat= 176
Generasi ke- 5  00111111110010100000  Fitness= 434000  Berat= 163
--------------------------------------------------
HASIL TERBAIK DARI 5 GENERASI ADALAH SBB: 
--------------------------------------------------
Generasi ke- 5  00111111110010100000  Fitness= 434000  Berat= 163
--------------------------------------------------
Barang ke-  Berat barang  Harga barang  
--------------------------------------------------
3               5             4000
4               45             100000
5               23             68000
6               4             2500
7               3             7400
8               34             36000
9               7             1200
10               34             200000
13               5             7400
15               3             7500
--------------------------------------------------
BUILD SUCCESSFUL (total time: 28 seconds)


