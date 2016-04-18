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

