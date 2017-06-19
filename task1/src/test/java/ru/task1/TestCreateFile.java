package ru.task1;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
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
@Test
public class TestCreateFile {

    Path path;

    @BeforeMethod
    public void createTempDir() throws IOException {
        Path tempPath = Paths.get("C:\\Users\\Andy\\version-control\\junit");
        this.path = Files.createTempDirectory(tempPath, "tmp");
        System.out.println("Created temp dir "+path.toString());

    }

    @AfterClass(enabled = false)
    public void deleteTempDir(){
        try{

            Files.delete(path);
            System.out.println("deleted tmp dir "+ this.path);
        }
        catch (Exception e){
            System.out.print("can't delete temp dir");
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

    @Test(enabled = false)
    public void testOne(){
        System.out.println("testing");
    }
}
