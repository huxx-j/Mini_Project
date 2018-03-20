package com.javaproject.miniproject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookApp {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        List<AddressBook> list = new ArrayList<>();
        Reader reader = new FileReader("phoneDB.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);

        boolean run = true;
        String str;
        String name;
        String hp;
        String company;

        System.out.println("*******************************************************");
        System.out.println("*                 전화번호 관리 프로그램                    *");
        System.out.println("*******************************************************" + "\n");

        while (true) {
            str = bufferedReader.readLine();

            if (str == null) {
                break;
            } else {
                String[] strArray = str.split(",");
                AddressBook addressBook = new AddressBook(strArray[0], strArray[1], strArray[2]);
                list.add(addressBook);
            }
        }
        while (run) {

            System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
            System.out.println("-------------------------------------------------------");
            System.out.print("> 메뉴번호 : ");

            int num = scanner.nextInt();

            switch (num) {
                case 1:
                    System.out.println("\n" + "< 1. 리스트 >");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(i + 1 + ". " + list.get(i).toString());
                    }
                    System.out.println("\n");

                    break;

                case 2:
                    System.out.println("\n" + "< 2. 등록 >");
                    System.out.print("> 이름 : ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    System.out.print("> 휴대전화 : ");
                    hp = scanner.nextLine();
                    System.out.print("> 회사전화 : ");
                    company = scanner.nextLine();

                    AddressBook addAddBook = new AddressBook(name, hp, company);
                    list.add(addAddBook);

                    Writer writer2 = new FileWriter("phoneDB.txt");
                    BufferedWriter bufferedWriter2 = new BufferedWriter(writer2);

                    for (AddressBook aList : list) {
                        bufferedWriter2.write(aList.writeInfo());
                        bufferedWriter2.flush();
                    }

                    System.out.println("\n" + "[등록되었습니다.]" + "\n");

                    break;

                case 3:
                    System.out.println("\n" + "< 3. 삭제 >");
                    System.out.print("> 번호 : ");
                    num = scanner.nextInt();
                    list.remove(num - 1);

                    Writer writer1 = new FileWriter("phoneDB.txt");
                    BufferedWriter bufferedWriter1 = new BufferedWriter(writer1);

                    for (AddressBook aList : list) {
                        bufferedWriter1.write(aList.writeInfo());
                        bufferedWriter1.flush();
                    }
                    System.out.println("\n" + "[삭제되었습니다.]" + "\n");

                    break;

                case 4:
                    int cnt = 1;
                    System.out.println("\n" + "< 4. 검색 >");
                    System.out.print("> 이름 : ");
                    scanner.nextLine();
                    str = scanner.nextLine();

                    for (AddressBook aList : list)
                        if (aList.getName().contains(str)) {
                            System.out.println(cnt + ". " + aList.toString());
                            cnt++;
                        }
                    System.out.println();

                    break;

                case 5:
                    System.out.println("\n" + "*******************************************************");
                    System.out.println("*                      감사합니다                        *");
                    System.out.println("*******************************************************");
                    run = false;

                    break;

                default:
                    System.out.println("\n" + "[다시입력해주세요]" + "\n");

                    break;
            }
        }
        scanner.close();
        bufferedReader.close();
    }
}

