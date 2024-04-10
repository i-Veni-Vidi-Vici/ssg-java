package com.ssg.thread.alphabet;

public class AlphabetTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Runnable printUpperCase = new PrintUpperCase(printer);
        Thread tPrintUpperCase = new Thread(printUpperCase);
        Runnable printLowerCase = new PrintLowerCase(printer);
        Thread tPrintLowerCase = new Thread(printLowerCase);
        tPrintUpperCase.start();
        tPrintLowerCase.start();
    }

    static class Printer {
        public enum printCase {UPPER_CASE, LOWER_CASE}
        private printCase currentCase = printCase.UPPER_CASE;

        public synchronized void printUpperCase(char alphabet) {
            if (currentCase != printCase.UPPER_CASE) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(alphabet);
            currentCase = printCase.LOWER_CASE;
            notify();
        }

        public synchronized void printLowerCase(char alphabet) {
            if (currentCase != printCase.LOWER_CASE) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(alphabet);
            currentCase = printCase.UPPER_CASE;
            notify();
        }
    }

    static class PrintUpperCase implements Runnable {
        private Printer printer;

        public PrintUpperCase(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            for (int i = 65; i <= 90; i++) {
                printer.printUpperCase((char) i);
            }
        }
    }

    static class PrintLowerCase implements Runnable {
        private Printer printer;

        public PrintLowerCase(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            for (int i = 97; i <= 122; i++) {
                printer.printLowerCase((char) i);
            }
        }
    }
}
