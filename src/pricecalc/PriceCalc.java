package pricecalc;

import java.util.Scanner;

public class PriceCalc {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int antal;
        float price;
        float totalPrice;
        float tax;
        int rabat;

        System.out.println("Discount rates:\n"
                + "price over 1000: 3%\n"
                + "5000: 5% \n"
                + "7000: 7%\n"
                + "10000: 10%\n"
                + "50000: 15%\n");

        antal:
        while (true) {
            System.out.println("how many?");
            String inputantal = sc.nextLine();

            try {
                antal = Integer.parseInt(inputantal);
                break antal;
            } catch (Exception e) {
                System.out.println("not a correct number");
            }
        }
        pris:
        while (true) {
            System.out.println("how much?");
            String inputprice = sc.nextLine();
            inputprice.replaceAll(".", ",");

            try {
                price = Float.parseFloat(inputprice);
                break pris;
            } catch (Exception e) {
                System.out.println("not a correct number");
            }
        }

        stat:
        while (true) {
            System.out.println("State?");
            System.out.println("1. Texas (TX) - 6.25%");
            System.out.println("2. California (CA) - 8.25%");
            System.out.println("3. Utah (UT) - 6.85%");
            System.out.println("4. Nevada (NV) - 8%");
            System.out.println("5. Alabama (AL) - 4%");
            String input = sc.nextLine().toLowerCase();
            switch (input) {
                case "tx":
                case "1":
                    tax = (float) 1.0625;
                    break stat;
                case "ca":
                case "2":
                    tax = (float) 1.0825;
                    break stat;
                case "ut":
                case "3":
                    tax = (float) 1.0685;
                    break stat;
                case "nv":
                case "4":
                    tax = (float) 1.08;
                    break stat;
                case "al":
                case "5":
                    tax = (float) 1.04;
                    break stat;
                default:
                    System.out.println("Try again");
            }
        }
        totalPrice = antal * price;
        if (totalPrice > 50000) {
            totalPrice = (float) (totalPrice * 0.85);
            System.out.println("Discount : 15%");
        } else if (totalPrice > 10000) {
            totalPrice = (float) (totalPrice * 0.9);
            System.out.println("Discount : 10%");
        } else if (totalPrice > 7000) {
            totalPrice = (float) (totalPrice * 0.93);
            System.out.println("Discount : 7%");
        } else if (totalPrice > 5000) {
            totalPrice = (float) (totalPrice * 0.95);
            System.out.println("Discount : 5%");
        } else if (totalPrice > 1000) {
            totalPrice = (float) (totalPrice * 0.97);
            System.out.println("Discount : 3%");
        }

        System.out.println("total:");
        System.out.println(totalPrice * tax);
    }

}
