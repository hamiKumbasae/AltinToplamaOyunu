package deneme;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Deneme extends JPanel {

    public static void dosyayayazdir(String dosyaadi, String icerik) {

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(dosyaadi, true)));
            out.println(icerik);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public Deneme(int a, int c, int[] topDizi, int[] hedefDizi, int hamlekaybi, int[][] ozetTablo) {
        int[][][] matris = new int[a][c][2];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < c; j++) {

                matris[i][j][0] = 0;
                matris[i][j][1] = 1;
            }
        }
        setLayout(new java.awt.GridLayout(a, c));
        int x = 1200 / a;
        int y = 600 / c;
        int altinSayisi = (a * c) / 5;
        int altinMiltari = (altinSayisi) / 4;
        int gizliAltin = ((a * c) * 2) / 100;
        int[] Altindizi = new int[altinSayisi];

        Random random = new Random();
        int u = 0;
        while ((u < altinSayisi)) {
            int sayi = random.nextInt(a * c);
            if (Altindizi.equals(sayi) || sayi == (0) || (sayi == (a * c - 1)) || sayi == (a - 1) || ((sayi == (a * c) - c))) {
                u--;
                continue;
            }

            Altindizi[u] = sayi;

            u++;

        }
        int altintop = 0;
        for (int i = 0; i < Altindizi.length; i++) {
            altintop += Altindizi[i];
        }

        int[] altiOran = new int[4];
        for (int k = 0; k < 4; k++) {
            altiOran[k] = (k + 1) * 5;
        }
        int say = 0;
        int sayac = 0;
        JButton[] b = new JButton[a * c];

        int[] o = new int[400];
        for (int i = 0; i < a; ++i) {

            for (int j = 0; j < c; j++) {

                b[say] = new JButton();
                b[say].setBounds(x * (i + 1), y * (j + 1), x, y);

                b[say].setBackground(Color.darkGray);

                if ((i == 0 && j == 0)) {
                    b[say].setText(" A ");
                    b[say].setForeground(Color.pink);

                }
                if ((i == 0 && j == c - 1)) {
                    b[say].setText(" B ");
                    b[say].setForeground(Color.orange);
                }
                if (i == a - 1 && j == c - 1) {
                    b[say].setText(" D ");
                    b[say].setForeground(Color.orange);
                }
                if ((i == a - 1 && j == 0)) {

                    b[say].setText(" C ");
                    b[say].setForeground(Color.orange);
                }
                for (int k = 0; k < altinSayisi; k++) {
                    if (Altindizi[k] == sayac) {

                        int sayi2 = random.nextInt(4);
                        b[say].setBackground(Color.yellow);

                        b[say].setText(" " + altiOran[sayi2]);
                        matris[i][j][0] = altiOran[sayi2];
                        b[say].setForeground(Color.RED);
                    }
                    for (int l = 0; l < gizliAltin; l++) {

                        if (Altindizi[l] == sayac) {

                            int sayi2 = random.nextInt(4);
                            b[say].setBackground(Color.WHITE);

                            b[say].setText("  " + altiOran[sayi2]);
                            matris[i][j][0] = altiOran[sayi2];
                            matris[i][j][1] = 0;//0 yap
                            b[say].setForeground(Color.RED);
                        }

                    }

                }

                sayac++;

                add(b[say]);
                say++;
            }

        }

        int[][] konumA = new int[1][2];
        konumA[0][0] = 0;
        konumA[0][1] = 0;

        int[][] yenikonumA = new int[1][2];
        yenikonumA[0][0] = 0;
        yenikonumA[0][1] = 0;
        int[][] hedefA = new int[1][2];
        hedefA[0][0] = 0;
        hedefA[0][1] = 0;
        int[][] hedefB = new int[1][2];
        hedefB[0][0] = 0;
        hedefB[0][1] = 0;

        int[][] konumB = new int[1][2];
        konumB[0][0] = 0;
        konumB[0][1] = c - 1;

        int[][] yenikonumB = new int[1][2];
        yenikonumB[0][0] = 0;
        yenikonumB[0][1] = 0;
        int[][] konumC = new int[1][2];
        konumC[0][0] = a - 1;
        konumC[0][1] = 0;

        int[][] yenikonumC = new int[1][2];
        yenikonumC[0][0] = 0;
        yenikonumC[0][1] = 0;
        int[][] hedefC = new int[1][2];
        hedefC[0][0] = 0;
        hedefC[0][1] = 0;

        int[][] konumD = new int[1][2];
        konumD[0][0] = a - 1;
        konumD[0][1] = c - 1;

        int[][] yenikonumD = new int[1][2];
        yenikonumD[0][0] = 0;
        yenikonumD[0][1] = 0;
        int[][] hedefD = new int[1][2];
        hedefD[0][0] = 0;
        hedefD[0][1] = 0;
        dosyayayazdir("a.txt", "a nin konumu" + konumA[0][0] + "," + konumA[0][1]);

        System.out.println("a kasadaki altin" + topDizi[0]);
        System.out.println("b kasadaki altin" + topDizi[1]);
        System.out.println("c kasadaki altin" + topDizi[2]);
        System.out.println("d kasadaki altin" + topDizi[3]);
        java.util.Timer myTimer = new java.util.Timer();
        TimerTask gorev = new TimerTask() {

            @Override
            public void run() {

                int h = 1;

                topDizi[0] = a(a, c, matris, konumA, yenikonumA, topDizi[0], hedefA, hedefDizi[0], hamlekaybi, ozetTablo);
                dosyayayazdir("a.txt", "a nin toplampuani:" + topDizi[0]);

                b[konumA[0][0] * c + konumA[0][1]].setText("  ");

                b[konumA[0][0] * c + konumA[0][1]].setBackground(Color.GREEN);

                for (int i = 1; i <= 5; i++) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                }

                topDizi[1] = b(a, c, matris, konumB, yenikonumB, topDizi[1], hedefB, hedefDizi[1], hamlekaybi, ozetTablo);
                dosyayayazdir("b.txt", "B nin toplampuani:" + topDizi[1]);

                b[konumB[0][0] * c + konumB[0][1]].setText("  ");

                b[konumB[0][0] * c + konumB[0][1]].setBackground(Color.BLUE);
                for (int i = 1; i <= 5; i++) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                }

                topDizi[2] = C(a, c, matris, konumC, yenikonumC, topDizi[2], hedefC, b, hedefDizi[2], hamlekaybi, ozetTablo);
                dosyayayazdir("c.txt", "C nin toplampuani:" + topDizi[2]);

                b[konumC[0][0] * c + konumC[0][1]].setText("  ");
                b[konumC[0][0] * c + konumC[0][1]].setBackground(Color.PINK);
                for (int i = 1; i <= 5; i++) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                }
                topDizi[3] = D(a, c, matris, konumD, yenikonumD, topDizi[3], hedefD, konumB, hedefB, konumA, hedefA, konumC, hedefC, hedefDizi[3], hamlekaybi, ozetTablo);
                dosyayayazdir("d.txt", "D nin toplampuani:" + topDizi[3]);

                b[konumD[0][0] * c + konumD[0][1]].setText("  ");

                b[konumD[0][0] * c + konumD[0][1]].setBackground(Color.MAGENTA);
                for (int i = 1; i <= 5; i++) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                }
                if (matristoplami(matris, a, c) == 0) {
                    for (int i = 0; i < a * c; i++) {
                        b[i].setVisible(false);
                    }
                    System.out.println("altin bitti");
                    System.out.println("A toplam adim sayisi:" + ozetTablo[0][0]);
                    System.out.println("b toplam adim sayisi:" + ozetTablo[1][0]);
                    System.out.println("c toplam adim sayisi:" + ozetTablo[2][0]);
                    System.out.println("d toplam adim sayisi:" + ozetTablo[3][0]);
                    System.out.println("A harcanan:" + ozetTablo[0][1]);
                    System.out.println("b harcanan sayisi:" + ozetTablo[1][1]);
                    System.out.println("c harcanan:" + ozetTablo[2][1]);
                    System.out.println("d harcanan:" + ozetTablo[3][1]);
                    System.out.println("A son puan:" + topDizi[0]);
                    System.out.println("b son puan:" + topDizi[1]);
                    System.out.println("c son puan:" + topDizi[2]);
                    System.out.println("d son puan:" + topDizi[3]);

                    myTimer.cancel();
                }
                if (topDizi[0] <= 0 && topDizi[1] <= 0 && topDizi[2] <= 0 && topDizi[3] <= 0) {
                    System.out.println("altin bitti");
                    for (int i = 0; i < a * c; i++) {
                        b[i].setVisible(false);
                    }
                    System.out.println("A toplam adim sayisi:" + ozetTablo[0][0]);
                    System.out.println("b toplam adim sayisi:" + ozetTablo[1][0]);
                    System.out.println("c toplam adim sayisi:" + ozetTablo[2][0]);
                    System.out.println("d toplam adim sayisi:" + ozetTablo[3][0]);
                    System.out.println("A harcanan:" + ozetTablo[0][1]);
                    System.out.println("b harcanan sayisi:" + ozetTablo[1][1]);
                    System.out.println("c harcanan:" + ozetTablo[2][1]);
                    System.out.println("d harcanan:" + ozetTablo[3][1]);
                    System.out.println("A son puan:" + topDizi[0]);
                    System.out.println("b son puan:" + topDizi[1]);
                    System.out.println("c son puan:" + topDizi[2]);
                    System.out.println("d son puan:" + topDizi[3]);

                    myTimer.cancel();
                }

            }
        };

        myTimer.schedule(gorev, 2, 800);

    }

    public static int matristoplami(int matris[][][], int a, int c) {
        int toplam = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < c; j++) {

                toplam += matris[i][j][0];

            }
        }

        return toplam;
    }

    public static int a(int satir, int sutun, int matris[][][], int konumA[][], int yenikonum[][], int toplamPuan, int hedefA[][], int hedefdizi, int hamlekaybi, int[][] ozet) {
        Random rnd = new Random();
        if (toplamPuan <= 0) {
            return toplamPuan;
        }

        int mesafe;
        int mesafe1 = 500000;
        int mesafeToplami = 0;

        if ((hedefA[0][0] != 0 && hedefA[0][1] != 0) && (matris[hedefA[0][0]][hedefA[0][1]][0]) != 0) {
            dosyayayazdir("a.txt", "a nin hedefi: " + hedefA[0][0] + " ," + hedefA[0][1]);

            int a = Math.abs((konumA[0][0] - hedefA[0][0]));
            int b = Math.abs((konumA[0][1] - hedefA[0][1]));
            int toplam = a + b;
            mesafe = toplam;
            if (mesafe > 3) {

                üclüdurum(yenikonum, konumA, hedefA);
                dosyayayazdir("a.txt", "a nin yeni konumu" + konumA[0][0] + "," + konumA[0][1]);
                dosyayayazdir("a.txt", "mesafesi1:::::." + mesafe);

                ozet[0][0] += 3;
                ozet[0][1] += 3 * hamlekaybi;
                return toplamPuan - (hamlekaybi * 3);
            } else {

                konumA[0][0] = hedefA[0][0];
                konumA[0][1] = hedefA[0][1];
                hedefA[0][0] = 0;
                hedefA[0][1] = 0;
                dosyayayazdir("a.txt", "a nin yeni konumu" + konumA[0][0] + "," + konumA[0][1]);

                int ekle = matris[konumA[0][0]][konumA[0][1]][0];
                matris[konumA[0][0]][konumA[0][1]][0] = 0;
                ozet[0][0] += mesafe;
                ozet[0][1] += mesafe * hamlekaybi;
                return toplamPuan - (hamlekaybi * mesafe) + ekle;
            }

        } else {
            for (int i = 0; i < satir; i++) {
                for (int j = 0; j < sutun; j++) {
                    if ((i + j) * matris[i][j][0] > 0 && matris[i][j][1] > 0) {

                        int a = Math.abs((konumA[0][0] - i));
                        int b = Math.abs((konumA[0][1] - j));
                        int toplam = a + b;
                        mesafe = toplam;
                        int puan = matris[i][j][0] + (toplam * (-5));

                        if (mesafe < mesafe1) {

                            mesafe1 = mesafe;

                            yenikonum[0][0] = i;
                            yenikonum[0][1] = j;

                        }

                    }

                }

            }
            if (mesafe1 > 3) {

                üclüdurum(yenikonum, konumA, hedefA);
                dosyayayazdir("a.txt", "a nin hedefi: " + hedefA[0][0] + " ," + hedefA[0][1]);
                dosyayayazdir("a.txt", "a nin yeni konumu" + konumA[0][0] + "," + konumA[0][1]);

                ozet[0][0] += 3;
                ozet[0][1] += 3 * hamlekaybi;
                return toplamPuan - (hamlekaybi * 3) - hedefdizi;
            } else {

                konumA[0][0] = yenikonum[0][0];
                konumA[0][1] = yenikonum[0][1];
                dosyayayazdir("a.txt", "a nin hedefi: " + konumA[0][0] + "," + konumA[0][1]);
                dosyayayazdir("a.txt", "a nin yeni konumu" + konumA[0][0] + "," + konumA[0][1]);

                yenikonum[0][0] = 0;
                yenikonum[0][1] = 0;
                int ekle = matris[konumA[0][0]][konumA[0][1]][0];
                matris[konumA[0][0]][konumA[0][1]][0] = 0;
                ozet[0][0] += mesafe1;
                ozet[0][1] += mesafe1 * hamlekaybi;
                return (toplamPuan - (hamlekaybi * mesafe1) + ekle);
            }
        }

    }

    public static int b(int satir, int sutun, int matris[][][], int konumB[][], int yenikonumB[][], int BtoplamPuan, int hedefB[][], int hedefdizi, int hamlekaybi, int[][] ozet) {
        if (BtoplamPuan <= 0) {
            return BtoplamPuan;
        }

        int mesafe, puan = 0;
        float kazanc = -100000;

        int mesafeToplami = 0;
        if (hedefB[0][0] != 0 && hedefB[0][1] != 0 && (matris[hedefB[0][0]][hedefB[0][1]][0]) != 0) {
             dosyayayazdir("b.txt", "b nin hedefi: " + hedefB[0][0] + " ," + hedefB[0][1]);
           
            int a = Math.abs((konumB[0][0] - hedefB[0][0]));
            int b = Math.abs((konumB[0][1] - hedefB[0][1]));
            int toplam = a + b;
            mesafe = toplam;
            if (mesafe > 3) {

                üclüdurum(yenikonumB, konumB, hedefB);
                     dosyayayazdir("b.txt", "B nin yeni konumu" + konumB[0][0] + "," + konumB[0][1]);
                     dosyayayazdir("b.txt", "mesafesi1:::::." + mesafe);
                
                ozet[1][0] += 3;
                ozet[1][1] += 3 * hamlekaybi;
                return BtoplamPuan - (hamlekaybi * 3);
            } else {

                konumB[0][0] = hedefB[0][0];
                konumB[0][1] = hedefB[0][1];
                hedefB[0][0] = 0;
                hedefB[0][1] = 0;

                matris[konumB[0][0]][konumB[0][1]][0] = 0;
                ozet[1][0] += mesafe;
                ozet[1][1] += mesafe * hamlekaybi;
                 dosyayayazdir("b.txt","B nin yeni konumu" + konumB[0][0] + "," + konumB[0][1]);
               
                return BtoplamPuan - (mesafe * hamlekaybi);
            }

        } else {
            for (int i = 0; i < satir; i++) {
                for (int j = 0; j < sutun; j++) {
                    if ((i + j) * matris[i][j][0] > 0 && matris[i][j][1] > 0) {

                        int a = Math.abs((konumB[0][0] - i));
                        int b = Math.abs((konumB[0][1] - j));
                        int toplam = a + b;
                        int kazanc1 = matris[i][j][0] + (toplam * (-5));

                        if (kazanc1 > kazanc) {

                            kazanc = kazanc1;

                            mesafeToplami = a + b;
                            yenikonumB[0][0] = i;
                            yenikonumB[0][1] = j;

                        }

                    }

                }

            }

            if (mesafeToplami > 3) {
                üclüdurum(yenikonumB, konumB, hedefB);
                dosyayayazdir("b.txt","B nin hedefi: " + hedefB[0][0] + " ," + hedefB[0][1]);
                dosyayayazdir("b.txt","B nin yeni konumu" + konumB[0][0] + "," + konumB[0][1]);
         
                ozet[1][0] += 3;
                ozet[1][1] += 3 * hamlekaybi;
                return BtoplamPuan - (3 * hamlekaybi) - hedefdizi;
            } else {
                konumB[0][0] = yenikonumB[0][0];
                konumB[0][1] = yenikonumB[0][1];
                 dosyayayazdir("b.txt","b nin hedefi: " + konumB[0][0] + "," + konumB[0][1]);
                 dosyayayazdir("b.txt","b nin yeni konumu" + konumB[0][0] + "," + konumB[0][1]);
               
                ozet[1][0] += mesafeToplami;
                ozet[1][1] += mesafeToplami * hamlekaybi;
                matris[yenikonumB[0][0]][yenikonumB[0][1]][0] = 0;
                return BtoplamPuan - (mesafeToplami * hamlekaybi);
            }
        }

    }

    public static int C(int satir, int sutun, int matris[][][], int konumC[][], int yenikonumC[][], int CtoplamPuan, int hedefC[][], JButton[] k, int hedefdizi, int hamlekaybi, int[][] ozet) {
        if (CtoplamPuan <= 0) {
            return CtoplamPuan;
        }
        int mesafe, puan = 0;
        float kazanc = -100000;
        int toplam = 0;
        int mesafeToplami = 0;
        int sayac = 0;

        for (int i = 0; i < satir; i++) {

            for (int j = 0; j < sutun; j++) {
                if ((i + j) * matris[i][j][0] > 0 && matris[i][j][1] == 0) {
                    matris[i][j][1] = 1;
                    k[i * sutun + j].setBackground(Color.YELLOW);

                    i = satir;
                    j = sutun;
                }

            }
        }
        for (int i = 0; i < satir; i++) {

            for (int j = 0; j < sutun; j++) {
                if ((i + j) * matris[i][j][0] > 0 && matris[i][j][1] == 0) {
                    matris[i][j][1] = 1;
                    k[i * sutun + j].setBackground(Color.YELLOW);

                    i = satir;
                    j = sutun;
                }

            }
        }

        if (hedefC[0][0] != 0 && hedefC[0][1] != 0 && (matris[hedefC[0][0]][hedefC[0][1]][0]) != 0) {
             dosyayayazdir("c.txt","c nin hedefi: " + hedefC[0][0] + " ," + hedefC[0][1]);
      
            int a = Math.abs((konumC[0][0] - hedefC[0][0]));
            int b = Math.abs((konumC[0][1] - hedefC[0][1]));
            toplam = a + b;
            mesafe = toplam;
            if (mesafe > 3) {
                            dosyayayazdir("c.txt","C nin yeni konumu" + konumC[0][0] + "," + konumC[0][1]);
             dosyayayazdir("c.txt","mesafesi1:::::." + mesafe);

          
                üclüdurum(yenikonumC, konumC, hedefC);
                ozet[2][0] += 3;
                ozet[2][1] += 3 * hamlekaybi;
                return CtoplamPuan - (3 * hamlekaybi);
            } else {

                konumC[0][0] = hedefC[0][0];
                konumC[0][1] = hedefC[0][1];
                hedefC[0][0] = 0;
                hedefC[0][1] = 0;

                matris[konumC[0][0]][konumC[0][1]][0] = 0;
                 dosyayayazdir("c.txt","C nin yeni konumu" + konumC[0][0] + "," + konumC[0][1]);
              
                ozet[2][0] += mesafe;
                ozet[2][1] += mesafe * hamlekaybi;
                return CtoplamPuan - (mesafe * hamlekaybi);
            }

        } else {
            for (int i = 0; i < satir; i++) {
                for (int j = 0; j < sutun; j++) {
                    if ((i + j) * matris[i][j][0] > 0) {

                        int a = Math.abs((konumC[0][0] - i));
                        int b = Math.abs((konumC[0][1] - j));
                        toplam = a + b;
                        int kazanc1 = matris[i][j][0] + (toplam * (-5));

                        if (kazanc1 > kazanc) {

                            kazanc = kazanc1;

                            mesafeToplami = a + b;
                            yenikonumC[0][0] = i;
                            yenikonumC[0][1] = j;

                        }

                    }

                }

            }

            if (mesafeToplami > 3) {
                üclüdurum(yenikonumC, konumC, hedefC);
                     dosyayayazdir("c.txt","C nin hedefi: " + hedefC[0][0] + " ," + hedefC[0][1]);
                          dosyayayazdir("c.txt","C nin yeni konumu" + konumC[0][0] + "," + konumC[0][1]);
                
                ozet[2][0] += 3;
                ozet[2][1] += 3 * hamlekaybi;
                return CtoplamPuan - (3 * hamlekaybi) - hedefdizi;
            } else {
                konumC[0][0] = yenikonumC[0][0];
                konumC[0][1] = yenikonumC[0][1];
                 dosyayayazdir("b.txt","B nin hedefi: " + hedefC[0][0] + " ," + hedefC[0][1]);
                 dosyayayazdir("b.txt","B nin yeni konumu" + konumC[0][0] + "," + konumC[0][1]);
            
                ozet[2][0] += mesafeToplami;
                ozet[2][1] += mesafeToplami * hamlekaybi;
                matris[yenikonumC[0][0]][yenikonumC[0][1]][0] = 0;
                return CtoplamPuan - (mesafeToplami * hamlekaybi);
            }
        }

    }

    public static int D(int satir, int sutun, int matris[][][], int konumD[][], int yenikonumD[][], int DtoplamPuan, int hedefD[][], int konumB[][], int hedefB[][], int konumA[][], int hedefA[][], int konumC[][], int hedefC[][], int hedefdizi, int hamlekaybi, int[][] ozet) {
        if (DtoplamPuan <= 0) {
            return DtoplamPuan;
        } else {
            int mesafe, puan = 0;
            float kazanc = -100000;
            int toplam = 0;
            int mesafeToplami = 0;
            if (hedefD[0][0] != 0 && hedefD[0][1] != 0 && (matris[hedefD[0][0]][hedefD[0][1]][0]) != 0) {

                int a = Math.abs((konumD[0][0] - hedefD[0][0]));
                int b = Math.abs((konumD[0][1] - hedefD[0][1]));
                toplam = a + b;
                mesafe = toplam;
                if (mesafe > 3) {

                    üclüdurum(yenikonumD, konumD, hedefD);
                    ozet[3][0] += 3;
                    ozet[3][1] += 3 * hamlekaybi;
                    dosyayayazdir("d.txt","D nin hedefi: " + hedefD[0][0] + " ," + hedefD[0][1]);
                    return DtoplamPuan - (hamlekaybi * 3);
                } else {

                    konumD[0][0] = hedefD[0][0];
                    konumD[0][1] = hedefD[0][1];
                    hedefD[0][0] = 0;
                    hedefD[0][1] = 0;

                    matris[konumD[0][0]][konumD[0][1]][0] = 0;
                    dosyayayazdir("d.txt","D nin yeni konumu" + konumD[0][0] + "," + konumD[0][1]);
                    dosyayayazdir("d.txt","mesafesi1:::::." + mesafe);
                    
                    ozet[3][0] += mesafe;
                    ozet[3][1] += mesafe * hamlekaybi;
                    return DtoplamPuan - (hamlekaybi * mesafe);

                }

            } else {

                if (hedefA[0][0] > 0 && hedefA[0][1] > 0) {

                    int a = Math.abs((konumD[0][0] - hedefA[0][0]));
                    int b = Math.abs((konumD[0][1] - hedefA[0][1]));
                    toplam = a + b;

                    if (toplam < 3) {
                        konumD[0][0] = hedefA[0][0];
                        konumD[0][1] = hedefA[0][1];
                        hedefA[0][0] = 0;
                        hedefA[0][1] = 0;
                        matris[konumD[0][0]][konumD[0][1]][0] = 0;
                        dosyayayazdir("d.txt","D A nin hedefini aldi " + konumD[0][0] + "," + konumD[0][1]);
                         dosyayayazdir("d.txt","D nin yeni konumu" + konumD[0][0] + "," + konumD[0][1]);
                        
                        ozet[3][0] += toplam;
                        ozet[3][1] += toplam * hamlekaybi;
                        return DtoplamPuan - (hamlekaybi * toplam);
                    }

                } else if (hedefB[0][0] > 0 && hedefB[0][1] > 0) {

                    int a = Math.abs((konumD[0][0] - hedefB[0][0]));
                    int b = Math.abs((konumD[0][1] - hedefB[0][1]));
                    toplam = a + b;

                    if (toplam < 3) {
                        konumD[0][0] = hedefB[0][0];
                        konumD[0][1] = hedefB[0][1];
                        hedefB[0][0] = 0;
                        hedefB[0][1] = 0;
                        matris[konumD[0][0]][konumD[0][1]][0] = 0;
                         dosyayayazdir("d.txt","D b nin hedefini aldi " + konumD[0][0] + "," + konumD[0][1]);
                  dosyayayazdir("d.txt","D nin yeni konumu" + konumD[0][0] + "," + konumD[0][1]);

                    
                        ozet[3][0] += toplam;
                        ozet[3][1] += toplam * hamlekaybi;
                        return DtoplamPuan - (hamlekaybi * toplam);
                    }

                } else if (hedefC[0][0] > 0 && hedefC[0][1] > 0) {

                    int a = Math.abs((konumD[0][0] - hedefC[0][0]));
                    int b = Math.abs((konumD[0][1] - hedefC[0][1]));
                    toplam = a + b;

                    if (toplam < 3) {
                        konumD[0][0] = hedefC[0][0];
                        konumD[0][1] = hedefC[0][1];
                        hedefC[0][0] = 0;
                        hedefC[0][1] = 0;
                                 dosyayayazdir("d.txt","D c nin hedefini aldi " + konumD[0][0] + "," + konumD[0][1]);
                  dosyayayazdir("d.txt","D nin yeni konumu" + konumD[0][0] + "," + konumD[0][1]);
                        
                        matris[konumD[0][0]][konumD[0][1]][0] = 0;
                        ozet[3][0] += toplam;
                        ozet[3][1] += toplam * hamlekaybi;
                        return DtoplamPuan - (hamlekaybi * toplam);
                    }

                }
                for (int i = 0; i < satir; i++) {
                    for (int j = 0; j < sutun; j++) {
                        if ((i + j) * matris[i][j][0] > 0 && matris[i][j][1] > 0) {

                            int a = Math.abs((konumD[0][0] - i));
                            int b = Math.abs((konumD[0][1] - j));
                            toplam = a + b;
                            int kazanc1 = matris[i][j][0] + (toplam * (-5));

                            if (kazanc1 > kazanc) {

                                kazanc = kazanc1;

                                mesafeToplami = a + b;
                                yenikonumD[0][0] = i;
                                yenikonumD[0][1] = j;

                            }

                        }

                    }

                }

                if (mesafeToplami > 3) {
                              dosyayayazdir("c.txt","C nin hedefi: " + hedefD[0][0] + " ," + hedefD[0][1]);
                  dosyayayazdir("c.txt","C nin yeni konumu" + konumD[0][0] + "," + konumD[0][1]);
                        
                  
                    üclüdurum(yenikonumD, konumD, hedefD);
                    ozet[3][0] += 3;
                    ozet[3][1] += 3 * hamlekaybi;
                    return DtoplamPuan - (hamlekaybi * 3) - hedefdizi;
                } else {
                    konumD[0][0] = yenikonumD[0][0];
                    konumD[0][1] = yenikonumD[0][1];
                           dosyayayazdir("c.txt","C nin hedefi: " + hedefD[0][0] + " ," + hedefD[0][1]);
                  dosyayayazdir("c.txt","C nin yeni konumu" + konumD[0][0] + "," + konumD[0][1]);
                    
                    ozet[3][0] += mesafeToplami;
                    ozet[3][1] += mesafeToplami * hamlekaybi;
                    matris[yenikonumD[0][0]][yenikonumD[0][1]][0] = 0;
                    return DtoplamPuan - (hamlekaybi * mesafeToplami);
                }
            }

        }

    }

    public static void üclüdurum(int yeniKonum[][], int konumB[][], int hedefA[][]) {
        int a = konumB[0][0] - yeniKonum[0][0];
        int b = konumB[0][1] - yeniKonum[0][1];
        hedefA[0][0] = yeniKonum[0][0];
        hedefA[0][1] = yeniKonum[0][1];
        if (a == 0 && b > 0) {
            konumB[0][1] = konumB[0][1] - 3;
        }

        if (a > 0 && b == 0) {
            konumB[0][0] = konumB[0][0] - 3;

        }

        if (a == 0 && b < 0) {
            konumB[0][1] = konumB[0][1] + 3;
        }

        if (a < 0 && b == 0) {
            konumB[0][0] = konumB[0][0] + 3;
        }

        if (a > 0 && b > 0) {
            konumB[0][0] = konumB[0][0] - 1;
            konumB[0][1] = konumB[0][1] - 2;

        }

        if (a > 0 && b < 0) {
            konumB[0][0] = konumB[0][0] - 2;
            konumB[0][1] = konumB[0][1] + 1;
        }

        if (a < 0 && b < 0) {
            konumB[0][0] = konumB[0][0] + 1;
            konumB[0][1] = konumB[0][1] + 2;
        }

        if (a < 0 && b > 0) {
            konumB[0][0] = konumB[0][0] + 2;
            konumB[0][1] = konumB[0][1] - 1;
        }

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(new Dimension(1325, 700));

                JFrame yeniframe = new JFrame();
                yeniframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                yeniframe.setSize(new Dimension(1325, 700));

                JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
                JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
                JButton bt1;
                l1 = new JLabel("satir sayisi");
                l1.setBounds(50, 100, 100, 30);

                t1 = new JTextField("20");
                t1.setBounds(50, 125, 200, 30);

                l2 = new JLabel("sütün sayisi");
                l2.setBounds(50, 180, 100, 30);

                t2 = new JTextField("20");
                t2.setBounds(50, 205, 200, 30);

                l3 = new JLabel("aTop");
                l3.setBounds(50, 260, 100, 30);
                t3 = new JTextField("200");
                t3.setBounds(50, 285, 200, 30);

                l4 = new JLabel("bTop");
                l4.setBounds(50, 340, 100, 30);
                t4 = new JTextField("200");
                t4.setBounds(50, 365, 200, 30);

                l5 = new JLabel("cTop");
                l5.setBounds(50, 420, 100, 30);
                t5 = new JTextField("200");
                t5.setBounds(50, 445, 200, 30);

                l6 = new JLabel("dTop");
                l6.setBounds(50, 500, 100, 30);
                t6 = new JTextField("200");
                t6.setBounds(50, 525, 200, 30);

                l7 = new JLabel("aHedef");
                l7.setBounds(700, 75, 100, 30);
                t7 = new JTextField("5");
                t7.setBounds(700, 100, 200, 30);

                l8 = new JLabel("bHedef");
                l8.setBounds(700, 155, 100, 30);
                t8 = new JTextField("10");
                t8.setBounds(700, 180, 200, 30);

                l9 = new JLabel("cHedef");
                l9.setBounds(700, 235, 100, 30);
                t9 = new JTextField("15");
                t9.setBounds(700, 260, 200, 30);

                l10 = new JLabel("dHedef");
                l10.setBounds(700, 315, 100, 30);
                t10 = new JTextField("20");
                t10.setBounds(700, 340, 200, 30);

                l11 = new JLabel("hamledeki kayip");
                l11.setBounds(700, 395, 100, 30);
                t11 = new JTextField("5");
                t11.setBounds(700, 420, 200, 30);

                bt1 = new JButton("gönder");
                bt1.setBackground(Color.red);
                bt1.setSize(new Dimension(100, 200));
                bt1.setLocation(400, 100);

                bt1.setVisible(true);
                frame.add(bt1);
                frame.add(l1);
                frame.add(t1);
                frame.add(l2);
                frame.add(t2);

                frame.add(t3);
                frame.add(l3);
                frame.add(t4);
                frame.add(l4);
                frame.add(t5);
                frame.add(l5);
                frame.add(t6);
                frame.add(l6);
                frame.add(t7);
                frame.add(l7);

                frame.add(t8);
                frame.add(l8);
                frame.add(t9);
                frame.add(l9);
                frame.add(t10);
                frame.add(l10);
                frame.add(t11);
                frame.add(l11);

                l1.setVisible(true);
                t1.setVisible(true);
                l2.setVisible(true);
                t2.setVisible(true);

                frame.setLayout(null);
                frame.setVisible(true);

                frame.setResizable(false);
                int[][] ozetTablo = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

                bt1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int satir = Integer.parseInt(t1.getText());

                        int sutun = Integer.parseInt(t2.getText());
                        int[] topDizi = new int[4];
                        int[] hedefDizi = new int[4];
                        int atop = Integer.parseInt(t3.getText());
                        topDizi[0] = atop;
                        int btop = Integer.parseInt(t4.getText());
                        topDizi[1] = btop;
                        int ctop = Integer.parseInt(t5.getText());
                        topDizi[2] = ctop;
                        int dtop = Integer.parseInt(t6.getText());
                        topDizi[3] = dtop;
                        int aHedef = Integer.parseInt(t7.getText());
                        hedefDizi[0] = aHedef;
                        int bHedef = Integer.parseInt(t8.getText());
                        hedefDizi[0] = bHedef;
                        int cHedef = Integer.parseInt(t9.getText());
                        hedefDizi[0] = cHedef;
                        int dHedef = Integer.parseInt(t10.getText());
                        hedefDizi[0] = dHedef;
                        int hamlekaybi = Integer.parseInt(t11.getText());
                        frame.setVisible(false);

                        yeniframe.add(new Deneme(satir, sutun, topDizi, hedefDizi, hamlekaybi, ozetTablo));

                        yeniframe.setVisible(true);
                        yeniframe.setResizable(false);

                    }
                });
            }

        });

    }
}
