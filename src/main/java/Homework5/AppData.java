package Homework5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData implements Serializable{
    private String[] header;
    private Integer[][] data;

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public Integer[][] getData() {
        return data;
    }

    public void setData(Integer[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AppData{" +
                "header=" + Arrays.toString(header) +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    public void load(String file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            header = bufferedReader.readLine().split(";");
            ArrayList<Integer[]> dataList = new ArrayList<>();
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                dataList.add(dataRow(temp));
            }
            data = dataList.toArray(new Integer[][]{{}});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Integer[] dataRow(String str) {
        String[] strings = str.split(";");

        Integer[] integers = new Integer[strings.length];
        for(int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }
            return integers;
    }

    public void save (String file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(rowToString(header));

            for (Integer[] row : data) {
                bufferedWriter.write(rowToString(row));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private <T> String rowToString(T[] row) {
        String result = "";

        for(int i = 0; i < row.length; i++) {
            result = result + row[i].toString();
            if (i != row.length -1) {
                result += ";";
            }
        }
        result += "\n";
        return result;
    }
}
