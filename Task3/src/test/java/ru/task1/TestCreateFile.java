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
 * Created by Andy on 20.06.2017.
 */

public class TestCreateFile {

     Path path;

    @BeforeMethod(alwaysRun =true )
    public void createTempDir() throws IOException {
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

    @Test (groups ="positive")
    public void createFileTest() throws IOException
    {
       File f = new File(this.path.toString()+"\\test.txt");
       f.createNewFile();
       Assert.assertTrue(f.exists());

    }

    @Test(groups = "positive")
    public void weirdLegalname() throws IOException
    {
        File f = new File(this.path.toString()+"\\~!a.@");
        Assert.assertTrue(f.createNewFile());
        Assert.assertTrue(f.exists());
    }


    @Test(groups = {"positive", "smoke"})
    public void testEmpty() throws IOException {
        File f = new File(this.path.toString()+"\\test1.txt");
        Assert.assertTrue(f.createNewFile());
        Assert.assertTrue(f.exists());
        Assert.assertEquals(f.length(),0);

    }

    @Test(groups = "negative")
    public void negativeTest1() throws IOException {
        File file = new File(this.path.toString()+"\\.");
        Assert.assertTrue(!file.createNewFile());
        Assert.assertTrue(!file.exists());


    }
    @Test (groups = {"negative","broken"})
    public void negativeTest2() {

        File file = new File(this.path.toString() + "\\:?d.txt");
        try {
             Assert.assertTrue(file.createNewFile());

        }
        catch (Exception e){
           Assert.fail("File was not created( custom message, test is failing on purpose)");
        }

    }



}
