
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {

        if(args.length == 0){
            System.out.println("no arguments provided"); 
        }
        // Check arguments
        if (args[0].equals("line")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = r.readLine();
                String employees[] = line.split(",");
                for (String emp : employees) {
                    System.out.println(emp);
                }
            } catch (Exception employees) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("searchName")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = r.readLine();
                System.out.println(line);
                String employees[] = line.split(",");
                Random rand = new Random();
                int randomIndex = rand.nextInt(employees.length);
                System.out.println(employees[randomIndex]);
            } catch (Exception employees) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt", true));
                String newName = args[0].substring(1);
                w.write(", " + newName);
                w.close();
            } catch (Exception employees) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = r.readLine();
                String employees[] = line.split(",");
                boolean found = false;
                String searchName = args[0].substring(1);
                for (int i = 0; i < employees.length && !found; i++) {
                    if (employees[i].equals(searchName)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception employees) {
         }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = r.readLine();
                char[] chars = line.toCharArray();
                boolean inWord = false;
                int count = 0;
                for (char c : chars) {
                    if (c == ' ') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(count + " word(searchName) found " + chars.length);
            } catch (Exception employees) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = r.readLine();
                String employees[] = line.split(",");
                String newName = args[0].substring(1);
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].equals(newName)) {
                        employees[i] = "Updated";
                    }
                }
                BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt"));
                w.write(String.join(",", employees));
                w.close();
            } catch (Exception employees) {
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = r.readLine();
                String employees[] = line.split(",");
                String newName = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(employees));
                list.remove(newName);
                BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt"));
                w.write(String.join(",", list));
                w.close();
            } catch (Exception employees) {
            }
            System.out.println("Data Deleted.");
        }
    }
}
