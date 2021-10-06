package ex43;


import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.TemporaryFolder;

import java.io.File;


/**
 * Unit test for simple App.
 */
public class AppTestex43 {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void initWebsiteTest()
    {
        String root = folder.getRoot().toString();

        Website testSite = new Website(root, "testSite", "none", "n", "n");

        Assertions.assertEquals(true, testSite.initWebsite());
    }

    @Test
    public void initHTMLTest(){
        String root = folder.getRoot().toString();

        Website testSite = new Website(root, "testSite", "none", "n", "n");
        testSite.initWebsite();

        Assertions.assertNotEquals(null, testSite.initHTML());
    }

}

