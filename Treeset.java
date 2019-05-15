package filerwintotreeset;

import java.io.*;
import java.util.*;


// Program reads all the lines of blrstudent2.csv
// loads student atrributes to Student object - to be done as assignment

public class Treeset {

    public static void main(String args[]) {

        String filepath = "C:\\Users\\Bharath\\Documents\\treesetstudent.csv";
        ArrayList<String> linesRead = new ArrayList<String>();
        Student sobj;
        TreeSet<Student> items = new TreeSet<Student>();

        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String currentline = br.readLine();

            while (currentline != null) {
                linesRead.add(currentline);// Add line to String Arraylist
                currentline = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int duplicatescount = 0;
        int size = linesRead.size();
        System.out.println("The size of Arraylist in which lines from file are read is " + size + "\n");
        System.out.println("Now printing String Values again directly thru call to print strings of ArrayList");
        System.out.println(linesRead);

        //using enhanced loop
        for (String s : linesRead) {

            String[] tokens = s.split(","); //this splits the line based on "," as delimiter
            //tokens[0] will be rollno, tokens[1] will be name and tokens[2] will be age
            sobj = new Student(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]));

            if (!items.add(sobj))  // Objects are added to Treeset
                duplicatescount++;

            //items.add(sobj); // Objects are added to Treeset

        } // for loop ends heree

        System.out.println("\nThe size of ArrayList is " + size);
        System.out.println("The number of Duplicate elements is " + duplicatescount);
        System.out.println("The size of Treeset is " + items.size() + "\n");
        for (Student st1 : items)
            System.out.println(st1.rollno + " " + st1.name + " " + st1.age);
    }

    // Student class and constructor
    static class Student implements Comparable<Student> {
        int rollno;
        String name;
        int age;

        Student(int rollno, String name, int age) {
            this.rollno = rollno;
            this.name = name;
            this.age = age;
        }

        public int compareTo(Student b) {

            //Sort on roll number
            if (rollno > b.rollno) {
                return 1;
            } else if (rollno < b.rollno) {
                return -1;
            } else {
               return 0;
           }

            // Sort on name
            /*return name.compareTo(b.name);

            //Sort on Age
            /*if (age > b.age) {
                return 1;
            } else if (age < b.age) {
                return -1;
            } else {
                return 0;
            }/*/

        }

    } // Class Student Ends

} // Class Treeset ends