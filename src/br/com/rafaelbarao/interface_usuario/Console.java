package br.com.rafaelbarao.interface_usuario;

import java.util.Scanner;

public class Console {
    private Scanner scanner;

    public Console() {
        this.scanner = new Scanner(System.in);
    }

    public Integer leNumeroInteiro() {
        while (true) {
            try {

                Integer numeroLido = scanner.nextInt();
                scanner.nextLine();
                return numeroLido;
            } catch (Exception ignored) {
            }
        }
    }

    public Double leNumeroDouble() {
        while (true) {
            try {
                Double numeroLido = scanner.nextDouble();
                scanner.nextLine();
                return numeroLido;
            } catch (Exception ignored) {
            }
        }
    }

    public String leLinhaTexto() {
        return scanner.nextLine();
    }

    public void escreveConsole(String texto) {
        System.out.println(texto);
    }

}
