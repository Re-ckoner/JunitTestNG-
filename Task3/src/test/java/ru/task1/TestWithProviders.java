package ru.task1;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by amil on 6/29/2017.
 */
public class TestWithProviders
{
    Path path;
    @BeforeMethod(alwaysRun =true )
    public void createTempDir() throws IOException
    {
        Path tempPath = Paths.get("src");
        this.path = Files.createTempDirectory(tempPath, "tmp");
        // path.toFile().deleteOnExit();

        System.out.println("Created temp dir "+path.toString());

    }

    @AfterMethod(enabled = true, alwaysRun =true )
    public void deleteTempDir(){
        try{
            FileUtils.deleteDirectory(new File(path.toString()));
        }
        catch (Exception e)
        {
            System.out.println("nio del "+path.toString());
            //do nothing
        }

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "dynamicName")
    public void test1(String fname) throws IOException
    {
        File f = new File(this.path.toString()+"\\"+fname);
        f.createNewFile();
        Assert.assertTrue(f.exists());
        System.out.println(f.toString() +"created successfully");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "dynamicName")
    public void test2(String fname) throws IOException{

    }

}