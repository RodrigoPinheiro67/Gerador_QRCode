package org.example;

/*

public class vetor

{
       public static void main(String[] args)
       {
        int vetor [] = new int [10];
        for (int i = 0; i < vetor.length; i++)
        {
        vetor [i] = i;
        }
        for (int i = 0; i < vetor.length; i++)
        {
        System.out.println (vetor [i]);
        }
    }
}

*/

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRCodeGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite os dados para gerar o QR Code: ");
        String inputData = scanner.nextLine();

        try {
            ByteArrayOutputStream out = QRCode.from(inputData).to(ImageType.PNG).stream();

            System.out.print("Digite o nome do arquivo para salvar o QR Code (exemplo: qrcode.png): ");
            String fileName = scanner.nextLine();

            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(out.toByteArray());
            fos.flush();
            fos.close();

            System.out.println("QR Code gerado e salvo com sucesso!");
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao gerar o QR Code: " + e.getMessage());
        }
    }
}


