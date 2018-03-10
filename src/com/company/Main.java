package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String login = "test"; //predefiniowany login
        String password = "test"; // predefiniowane hasło
        Scanner scanner = new Scanner(System.in);
        String enteredLogin, enteredPassword; //definiowanie loginu wprowadzanego przez użytkownika

        //Logowanie do systemu
        boolean loginSucces = false;
        while (loginSucces != true) {
            System.out.print("Login: ");
            enteredLogin = scanner.nextLine();
            System.out.print("Password: ");
            enteredPassword = scanner.nextLine();

            if (enteredLogin.equals(login) && enteredPassword.equals(password)) {
                System.out.println("You're logged in");
                loginSucces = true;
            } else {
                System.out.println("Invalid credentials. Try again.");
            }
        }
        boolean programRunning = true;
        do {
            //funkcje programu
            System.out.println();
            System.out.println("Co chcesz zrobić:\n" +
                    "1. Suma N elementów\n" +
                    "2. Róźnica N elementów\n" +
                    "3. Iloczyn N elementów\n" +
                    "4. Iloraz N elementów\n" +
                    "5. Pierwiastek N stopnia z K\n" +
                    "6. Potęga N stopnia z K\n" +
                    "7. przeliczanie miedzy systemami liczbowymi\n" +
                    "8. Mediana i średnia ze zbioru liczb\n" +
                    "9. Stop the program");


            int funkcja = scanner.nextInt();
            double wynik = 0;
            double k, n;
            double[] numbers;
            ScanData scanData = new ScanData();

            switch (funkcja) {
                case 1: //dodawanie N elementów
//                System.out.print("Podaj ciąg znaków w formie: xx xx xx xx...: ");
//                input = scanner.nextLine(); //NIE WIEM DLACZEGO TEGO NIE WIDZI
//                variables = scanner.nextLine();
//                numbers = variables.split(" ");
//                enteredNumbers = new double[numbers.length];
                    numbers = scanData.enterValue(); //Generewoaniu tablicy liczb wprowadzonych przez użytkownika
                    for (int i = 0; i < numbers.length; i++) {
                        wynik += numbers[i];
                    }
                    System.out.println("Suma wynosi: " + wynik);
                    break;
                case 2: //odejmowaie N elementó
                    numbers = scanData.enterValue(); //Generewoaniu tablicy liczb wprowadzonych przez użytkownika
                    for (int i = 0; i < numbers.length; i++) {
                        wynik -= numbers[i];
                    }
                    System.out.println("Roznica wynosi: " + wynik);
                    break;

                case 3: //mnożenie N elementów
                    numbers = scanData.enterValue(); //Generewoaniu tablicy liczb wprowadzonych przez użytkownika
                    wynik = 1;
                    for (int i = 0; i < numbers.length; i++) {
                        wynik *= numbers[i];
                    }
                    System.out.println("Iloczyn wynosi: " + wynik);
                    break;
                case 4: //dzielenie  !!!! jeszcze nie skonczone
                    numbers = scanData.enterValue(); //Generewoaniu tablicy liczb wprowadzonych przez użytkownika
                    wynik = numbers[0];
                    boolean divideBy0 = false;
                    for (int i = 0; i < numbers.length - 1; i++) {
                        if (numbers[i + 1] != 0) {
                            wynik /= numbers[i];
                        } else {
                            divideBy0 = true;
                        }
                    }
                    if (divideBy0 == true) {
                        System.out.println("Roznica wynosi: " + wynik);
                    } else {
                        System.out.println("Dzielenie przez 0 niedopuszczalne.");
                    }
                    break;

                case 5: //Pierwiastek
                    System.out.println("Podaj podstawę pierwiastka K");
                    k = scanner.nextDouble();
                    System.out.println("Podaj wykładnik pierwiastka N");
                    n = scanner.nextDouble();

                    //poczatkowe przyblizenie
                    double result = k;
                    double prev_result = result;
                    //x^n-1
                    double tmp = Math.pow(result, n - 1);
                    do {//zapamietaj poprzednie przyblizenie
                        prev_result = result;
                        //oblicz nowe przyblizenie
                        result = 1 / n * ((n - 1) * result + (k / tmp));
                        //x^n-1
                        tmp = Math.pow(result, n - 1);
                    } while (Math.abs(prev_result - result) > 0.0); //powtarzaj aż zblizasz sie do rozwiazania
                    System.out.println("Pierwiastek stopnia " + n + " z " + k + " wynosi " + result);
                    break;

                case 6: //Potęga dowolnego stopnia
                    System.out.println("Podaj podstawę K:");
                    k = scanner.nextDouble();
                    System.out.println("Podsj wykładnik potęgi N:");
                    n = scanner.nextDouble();

                    double powerOf = Math.pow(k, n);
                    System.out.println("Potęga wynosi: " + powerOf);
                    break;

                case 7: //Przeliczanie na różne systemy liczbowe
                    System.out.println("Podaj liczbę która ma być przeliczona");
                    int liczba = scanner.nextInt();
                    String binaryValue = Integer.toString(liczba, 2);
                    System.out.println("Kod dwójkowy: " + binaryValue);
                    String octalValue = Integer.toString(liczba, 8);
                    System.out.println("Kod ósemkowy: " + octalValue);
                    String hexadecimalValue = Integer.toString(liczba, 16);
                    System.out.println("Kod szesnastkowy: " + hexadecimalValue);
                    break;

                case 8: //Mediana i średnia
                    numbers = scanData.enterValue(); //Generewoaniu tablicy liczb wprowadzonych przez użytkownika
                    for (int i = 0; i < numbers.length; i++) {
                        wynik += numbers[i];
                    }
                    System.out.println("Sredia wynosi: " + (wynik / (numbers.length + 1)));
                    Arrays.sort(numbers);
                    double mediana = 0;
                    int middle = numbers.length / 2;
                    if ((numbers.length + 1) % 2 == 1) {
                        System.out.println("Mediana: " + numbers[middle]);
                    } else {
                        System.out.println("Mediana: " + (numbers[middle - 1] + numbers[middle]) / 2);
                    }
                    break;

                case 9:
                    programRunning = false;
                    System.out.println("Zostałeś wylogowany.");
            }
        } while (programRunning == true);
    }
}
