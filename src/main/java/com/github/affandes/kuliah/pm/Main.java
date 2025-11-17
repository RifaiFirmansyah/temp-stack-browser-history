package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private Stack<String> history = new Stack<>();

    // FUNGSI MENAMBAHKAN WEBSITE KE HISTORY
    public void browse(String website) {
        history.push(website);
        System.out.println(" Membuka website: " + website);
    }

    // FUNGSI KEMBALI KE WEBSITE SEBELUMNYA
    public void back() {
        if (history.isEmpty()) {
            System.out.println(" Tidak ada history untuk kembali!");
        } else {
            String removed = history.pop();
            System.out.println(" Kembali dari: " + removed);

            if (!history.isEmpty()) {
                System.out.println(" Sekarang berada di: " + history.peek());
            } else {
                System.out.println(" Tidak ada halaman aktif.");
            }
        }
    }

    // TAMPILKAN HISTORY 
    public void view() {
        if (history.isEmpty()) {
            System.out.println(" History kosong.");
            return;
        }

        System.out.println("\n======== HISTORY BROWSER ========");
        Stack<String> temp = (Stack<String>) history.clone();

        int no = 1;
        while (!temp.isEmpty()) {
            System.out.println(no + ". " + temp.pop());
            no++;
        }
    }

    public static void main(String[] args) {
        Main browser = new Main();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== MENU BROWSER ====");
            System.out.println("1. Browse website");
            System.out.println("2. View history");
            System.out.println("3. Back");
            System.out.println("4. Exit");
            System.out.print("Pilih menu: ");
            int pilih = input.nextInt();
            input.nextLine(); // clear buffer

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan nama website: ");
                    String web = input.nextLine();
                    browser.browse(web);
                    break;

                case 2:
                    browser.view();
                    break;

                case 3:
                    browser.back();
                    break;

                case 4:
                    System.out.println("Program selesai.");
                    return;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
