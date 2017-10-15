package duplicateremover;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DuplicateRemover {
    private static final String TAG = "DuplicateRemover";

    private static ArrayList<Address> readFile(String fileName) {
        ArrayList<String> addressArrayList = new ArrayList<>();
        ArrayList<Address> duplicateAddresses = new ArrayList<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String address = in.readLine().trim();

            while (address != null) {
                if (!addressArrayList.contains(address)) {
                    addressArrayList.add(address);
                } else {
                    Address newAddress = new Address(100000 + (addressArrayList.size() + duplicateAddresses.size() - 1), address);
                    duplicateAddresses.add(newAddress);
                }

                address = in.readLine();
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(TAG).log(Level.SEVERE, "FileNotFoundException: " + fileName);
        } catch (IOException e) {
            Logger.getLogger(TAG).log(Level.SEVERE, "IOException - Index location: " + addressArrayList.size());
        }

        return duplicateAddresses;
    }

    private static void writeFile(ArrayList<Address> inputArrayList, String outFileName) {
        Writer out = null;

        Logger.getLogger(TAG).log(Level.INFO, "Attempting to write file " + outFileName);
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFileName), "UTF-8"));
            out.flush();
            for (Address a : inputArrayList) {
                out.write("Index: " + a.getIndex() + "  Address: " + a.getAddress() + "\n");
            }
            out.close();

        } catch (IOException e) {
            Logger.getLogger(TAG).log(Level.SEVERE, "FileNotFoundException when writing new file");
        }

    }

    public static void main(String[] args) {
        writeFile(readFile(args[0]), args[1]);
    }
}
