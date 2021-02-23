package Behaviors;

import Entities.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "Name,Phone Number,Address,Email,Facebook,Nickname";
    public static void writeToFileCsv(List<Contacts> contacts, String pathFile) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(pathFile);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Contacts c : contacts) {
                fileWriter.append(String.valueOf(c.getName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(c.getPhoneNumber()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getFacebook());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getNickname());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("Done!!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public static void readFromFileCsv(String pathFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                if (cols[0].equals("Name")) {
                    System.out.println("Contacts: ");
                } else System.out.println("Name: " + cols[0] + ", phone number: " + cols[1] +
                        ", address: " + cols[2] + ", email: " + cols[3] + ", facebook: " +
                        cols[4] + ", nickname: " + cols[5]);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static List<Contacts> readCSV(String pathFile){
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
            String line;
            ArrayList<Contacts> contacts = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                if (cols[0].equals("Name")){
                }else {
                    Contacts c = new Contacts();
                    c.setName(cols[0]);
                    c.setPhoneNumber(Integer.parseInt(cols[1]));
                    c.setAddress(cols[2]);
                    c.setEmail(cols[3]);
                    c.setFacebook(cols[4]);
                    c.setNickname(cols[5]);
                    contacts.add(c);
                }
            }
            return contacts;
        }catch (IOException io){
            io.printStackTrace();
        }
        return null;
    }

    //read and write object
    public static void writeObjectToFile(Object serObj, String filepath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Object readFromFile(String filepath) {
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            objectIn.close();
            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

