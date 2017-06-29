package ru.task1;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.io.InputStreamReader;
import java.io.BufferedReader;
/**
 * Created by amil on 6/29/2017.
 */
public class DataProviders
{
    @DataProvider
    public static Iterator<Object[]> dynamicName(){
        List<Object[]>names = new ArrayList<Object[]>();
        for(int i=0; i<10; i++){
            names.add(new Object[]{("fname"+ new Random().nextInt())});
        }
        return names.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> nameFromFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("src//names.csv")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return userData.iterator();
    }
}
