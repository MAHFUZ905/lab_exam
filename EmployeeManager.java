//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {


    public static String[] readEmployees() throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("employees.txt")));
        String line = br.readLine();
        br.close();
        return line.split(",");
    }

    public static void writeEmployees(String data, boolean append) throws Exception {
        BufferedWriter bw = new BufferedWriter(
                new FileWriter("employees.txt", append));
        bw.write(data);
        bw.close();
    }
    // -------------------------------

    public static void main(String[] args) {

        if(args.length == 0){
            System.out.println("no arguments provided"); 
        }
          // check arguments
        if (args[0].equals("line")) {
            System.out.println("Loading data ...");
            try {
                String employees[] = readEmployees();
                for (String emp : employees) {
                    System.out.println(emp);
                }
            } catch (Exception e) {}
            System.out.println("Data Loaded.");

        } else if (args[0].equals("searchName")) {
            System.out.println("Loading data ...");
            try {
                String employees[] = readEmployees();
                Random rand = new Random();
                int randomIndex = rand.nextInt(employees.length);
                System.out.println(employees[randomIndex]);
            } catch (Exception e) {}
            System.out.println("Data Loaded.");

        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                String newName = args[0].substring(1);
                writeEmployees(", " + newName, true);
            } catch (Exception e) {}
            System.out.println("Data Loaded.");

        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String employees[] = readEmployees();
                boolean found = false;
                String searchName = args[0].substring(1);
                for (int i = 0; i < employees.length && !found; i++) {
                    if (employees[i].equals(searchName)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception e) {}
            System.out.println("Data Loaded.");

        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                String employees[] = readEmployees();
                int count = employees.length;
                System.out.println(count + " words found.");
            } catch (Exception e) {}
            System.out.println("Data Loaded.");

        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String employees[] = readEmployees();
                String newName = args[0].substring(1);

                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].equals(newName)) {
                        employees[i] = "Updated";
                    }
                }

                writeEmployees(String.join(",", employees), false);
            } catch (Exception e) {}
            System.out.println("Data Updated.");

        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                String employees[] = readEmployees();
                String newName = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(employees));
                list.remove(newName);

                writeEmployees(String.join(",", list), false);
            } catch (Exception e) {}
            System.out.println("Data Deleted.");
        }
    }
}
