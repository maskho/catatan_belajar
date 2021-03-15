package com.company;
import java.io.*;
import java.util.*;


public class Main {
    static void display(List<Pegawai> pegawai_list){
        System.out.println("DATA KEPEGAWAIAN\n");
        for (Pegawai peg: pegawai_list
             ) {
            System.out.println(peg.getInfo());
        }
    }

    static int binarySearch(List<Pegawai> pegawai_list, int low, int high, String nip){
        if(high<low)
            return -1;
        int mid = (low+high)/2;
        if (nip.equals(pegawai_list.get(mid).getNip()))
            return mid;
        if (Integer.parseInt(nip) > Integer.parseInt(pegawai_list.get(mid).getNip()))
            return binarySearch(pegawai_list, (mid+1),high, nip);
        return binarySearch(pegawai_list, low, (mid-1),nip);
    }

    static List<Pegawai> delete(List<Pegawai> pegawai_list, String nip){
        int index_pegawai = binarySearch(pegawai_list, 0 , pegawai_list.size()-1,nip);

        if (index_pegawai == -1){
            System.out.println("Data pegawai dengan nip: "+nip+" tidak ditemukan!");
        }
        else{
            System.out.println("Data Pegawai:\n"+pegawai_list.get(index_pegawai).getInfo()+"\nBerhasil dihapus!");
            pegawai_list.remove(index_pegawai);
        }
        return pegawai_list;
    }

    static void find(List<Pegawai> pegawai_list, String nip){
        int index_pegawai = binarySearch(pegawai_list, 0 , pegawai_list.size()-1,nip);

        if (index_pegawai == -1){
            System.out.println("Data pegawai dengan nip: "+nip+" tidak ditemukan!");
        }
        else{
            System.out.println("Data Pegawai:\n"+pegawai_list.get(index_pegawai).getInfo());
        }
    }

    static List<Pegawai> binaryInsert(List<Pegawai> data, int low, int high, Pegawai pegawai_inserted) {
        if (high < low){
            data.add(low,pegawai_inserted);
            return data;
        }

        int mid = (low + high) / 2;
        if (Integer.parseInt(pegawai_inserted.getNip()) > Integer.parseInt(data.get(mid).getNip()))
            return binaryInsert(data, (mid + 1), high, pegawai_inserted);
        return binaryInsert(data, low, (mid - 1), pegawai_inserted);
    }

    static List<Pegawai> updateGaji(List<Pegawai> pegawai_list,String nip, String gaji){
        int index_pegawai = binarySearch(pegawai_list, 0 , pegawai_list.size()-1,nip);
        if(index_pegawai == -1){
            System.out.println("Data pegawai dengan nip: "+nip+" tidak ditemukan!");
           return pegawai_list;
        }
        else{
            System.out.println("Data pegawai dengan nip: "+nip+" berhasil diupdate!");
            pegawai_list.get(index_pegawai).setGaji(gaji);
            return pegawai_list;
        }
    }
    static List<Pegawai> updateMasa(List<Pegawai> pegawai_list,String nip, String masa){
        int index_pegawai = binarySearch(pegawai_list, 0 , pegawai_list.size()-1,nip);

        if(index_pegawai == -1){
            System.out.println("Data pegawai dengan nip: "+nip+" tidak ditemukan!");
            return pegawai_list;
        }
        else{
            System.out.println("Data pegawai dengan nip: "+nip+" berhasil diupdate!");
            pegawai_list.get(index_pegawai).setMasa(masa);
            return pegawai_list;
        }
    }
    static Integer getTotalGaji(List<Pegawai> pegawaiList){
        Integer total = 0;
        for(int i=0;i<pegawaiList.size();i++){
            total = total + Integer.parseInt(pegawaiList.get(0).getGaji());
        }
        return total;
    }

    public static void main(String[] args) {
        List<Pegawai> pegawai_list = new ArrayList<>();
        File fileInput = new File("resources/data_pegawai.txt");

        //MENGGUNAKAN DOUBLY LINKED LIST UNTUK MEMBACA DAN MENGURUTKAN DATA PEGAWAI
        DoublyLinkedList L = new DoublyLinkedList();
        L.head = null;
        L.tail = null;

        try{
            Scanner scanfile = new Scanner(fileInput);

            while (scanfile.hasNextLine()){
                Node data = new Node();
                String line = scanfile.nextLine();
                String[] values = line.split(",");
                Pegawai pegawai = new Pegawai();
                pegawai.setNama(values[0]);
                pegawai.setNip(values[1]);
                pegawai.setMasa(values[2]);
                pegawai.setGaji(values[3]);
                data.pegawai = pegawai;
                data.prev = null;
                data.next = null;
                L.insertSorted(data);
            }
            pegawai_list = L.pegawaiList();
        }
        catch (FileNotFoundException error){
            System.out.println("File not found");
        }

        L.printNode();

//        YANG DICOMMENT INI ADALAH TUGAS MINGGU KEMARIN YANG MELAKUKAN SORTING ARRAY TANPA DOUBLY LINKEDLIST
//        List<List<String>> data_urut_nip = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader("resources/data_pegawai.txt"))){
//            String line;
//            while ((line = br.readLine())!=null){
//                String[] values = line.split(",");
//                    data_urut_nip.add(Arrays.asList(values));
//            }
//        }
//        data_urut_nip.sort(Comparator.comparing(l -> l.get(1)));
//        List<Pegawai> pegawai_list = new ArrayList<>();
//
//        for (List data:data_urut_nip
//             ) {
//            Pegawai pegawai = new Pegawai();
//            pegawai.setNama((String) data.get(0));
//            pegawai.setNip((String) data.get(1));
//            pegawai.setMasa((String) data.get(2));
//            pegawai.setGaji((String) data.get(3));
//            pegawai_list.add(pegawai);
//        }



        Scanner scanner = new Scanner(System.in);
        System.out.println("SELAMAT DATANG DI SISTEM KEPEGAWAIAN\n");
        int pilihan = 1;
        while(pilihan!=0){
            System.out.println("_____________________________\nPilih Menu:");
            System.out.println(
                    "1. Insert()\n" +
                    "2. Delete()\n" +
                    "3. Find()\n" +
                    "4. Display()\n" +
                    "5. UpdateGaji()\n" +
                    "6. UpdateMasaKerja()\n" +
                    "7. GetTotalGaji()\n" +
                    "0. Selesai\n");
            System.out.print("_____________________________\nMasukkan nomor pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan){
                case 1:
                    Pegawai pegawai = new Pegawai();
                    System.out.println("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    pegawai.setNama(nama);
                    System.out.println("Masukkan NIP: ");
                    String nipnya = scanner.next();
                    pegawai.setNip(nipnya);
                    System.out.println("Masukkan masa: ");
                    String masanya = scanner.next();
                    pegawai.setMasa(masanya);
                    System.out.println("Masukkan gaji: ");
                    String gajinya = scanner.next();
                    pegawai.setGaji(gajinya);
                    if(binarySearch(pegawai_list, 0 , pegawai_list.size()-1,pegawai.getNip())!=-1){
                        System.out.println("NIP sudah terdaftar!");
                        break;
                    }
                    binaryInsert(pegawai_list,0,pegawai_list.size()-1,pegawai);
                    System.out.println("Data pegawai dengan NIP: "+pegawai.getNip()+" berhasil dimasukkan!");
                    break;
                case 2:
                    System.out.println("Masukkan NIP: ");
                    pegawai_list = delete(pegawai_list,scanner.next());
                    break;
                case 3:
                    System.out.println("Masukkan NIP: ");
                    String case3 =scanner.next();
                    find(pegawai_list, case3);
                    break;
                case 4:
                    display(pegawai_list);
                    break;
                case 5:
                    System.out.println("Masukkan NIP dan Gaji: ");
                    pegawai_list = updateGaji(pegawai_list,scanner.next(),scanner.next());
                    break;
                case 6:
                    System.out.println("Masukkan NIP dan Masa Kerja: ");
                    pegawai_list = updateMasa(pegawai_list, scanner.next(),scanner.next());
                    break;
                case 7:
                    System.out.println("Total gaji seluruh pegawai: "+getTotalGaji(pegawai_list));
                    break;
                case 0:
                    System.out.println("Terima kasih. Aplikasi menutup ...");
                    break;
                default:
                    System.out.println("Nomor yang anda masukkan salah. Aplikasi menutup ...");
                    pilihan = 0;
            }

        }
    }
}
