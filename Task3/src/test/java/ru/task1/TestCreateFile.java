package ru.task1;

import org.apache.commons.io.FileUtils;
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

    @BeforeMethod
    public void createTempDir() throws IOException {
        Path tempPath = Paths.get("src");
        this.path = Files.createTempDirectory(tempPath, "tmp");
       // path.toFile().deleteOnExit();

        System.out.println("Created temp dir "+path.toString());

    }

    @AfterMethod(enabled = true)
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

    @Test
    public void createFileTest() {
       File f = new File(this.path.toString()+"\\test.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void weirdLegalname() {
        File f = new File(this.path.toString()+"\\~!a.@");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testEmpty() throws IOException {
        File f = new File(this.path.toString()+"\\test1.txt");
        f.createNewFile();
        assert(f.length()==0);

    }

    @Test
    public void negativeTest1() throws IOException {
        File file = new File(this.path.toString()+"\\.");
        assert(!file.createNewFile());

    }
    @Test
    public void negativeTest2() {

        File file = new File(this.path.toString() + "\\:?d.txt");
        try {
             file.createNewFile();
             assert(false);
        }
        catch (Exception e){
           assert(true);
        }

    }



}
