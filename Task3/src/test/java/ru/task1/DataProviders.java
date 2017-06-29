package ru.task1;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
    public static Iterator<Object[]>nameFromFile(){
        
    }
}
