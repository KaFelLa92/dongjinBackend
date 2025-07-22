package day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {

        try {   // 트라이-캐치 문이 있어야 정상 작동
            // (1) 텍스트 파일 생성하기
            Scanner scan = new Scanner(System.in);
            System.out.print("뭐라고 적을까?");
            String str = scan.next();
            // 경로
            String path = "src/day16/testify.txt";
            // 쓰기 객체
            FileOutputStream fout = new FileOutputStream(path);
            // 파일을 바이트로 변환한다. 여기서는 텍스트 파일의 텍스트. 스트림은 바이트만 읽기 쓰기 가능
            byte[] outByte = str.getBytes();
            // 바이트 내보내기
            fout.write(outByte);

            // (2) 파일로부터 텍스트 호출
            File file = new File(path);

            // (3) 파일 존재할 경우 읽어오기
            if (file.exists()) {
                FileInputStream fin = new FileInputStream(path);
                byte[] inByte = new byte[(int) file.length()];
                fin.read(inByte);
                String inStr = new String(inByte);
                System.out.println(inStr);
            }
        } catch (Exception e) {
            System.out.println("저장이 안되는뎁쇼?");
        }

        try {
            // 1. 라이프워크 만들기
            String path = "src/day16/masterpiece.txt";
            FileOutputStream fout = new FileOutputStream(path , true);
            Scanner scan = new Scanner(System.in);
            System.out.println("라이프워크에 뭐라고 남길까?");
            String str = scan.nextLine(); // "오늘도 개쩌는 하루다."
            String writeLifework = str + "\n";
            byte[] outByte = writeLifework.getBytes();
            fout.write(outByte);

            // 2. 라이프워크 존재 여부 확인
            File file = new File(path);
            System.out.println(file.exists());

            // 3. 라이프워크 읽기
            if (file.exists()) {
                FileInputStream fin = new FileInputStream(path);
                byte[] inByte = new byte[(int) file.length()];
                fin.read(inByte);
                String lifework = new String(inByte, "EUC-KR");
                System.out.println(lifework);
            }

            // 3. 라이프워크 읽기

            FileInputStream fin = new FileInputStream(path);

        } catch (Exception e) {
            System.out.printf("파일을 찾을 수 없습니다.");
        }


        try {
            // CSV 파일 해석하기
            String path = "src/day16/bupyeong_population.csv";
            File file = new File(path);
            FileInputStream fin = new FileInputStream(path);
            byte[] bytes = new byte[(int) file.length()];
            fin.read(bytes);
            String str = new String(bytes, "EUC-KR");
            String[] rowData = str.split("\n");
            for (int i = 0; i < rowData.length; i++){
                String row = rowData[i];
                String[] columnData = row.split(",");
                System.out.printf("동별 : [ %5s ] , 총 인구 : [ %5s ] 명 \n" , columnData[0] , columnData[1]);
            }

        } catch (Exception e) {
            System.out.println("공공데이터를 읽을 수 없습니다.");
        }
    } // main end
}   // class end
