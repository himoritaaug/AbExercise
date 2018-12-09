package hmorita.abexercise.loader;

import hmorita.abexercise.entity.ReportElement;
import hmorita.abexercise.factory.ReportElementFactory;
import org.junit.Test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;


public class ReportElementLoaderTest {

    @Test
    public void testLoad() {
        String fileName = "C:\\work\\AbInitioExercise\\data\\";
        ReportElementFactory f = new ReportElementFactory();

        Path path = FileSystems.getDefault().getPath(fileName, "rep-2016-11.csv");

        ReportElementLoader loader = new ReportElementLoader();
        ArrayList<ReportElement> repElements = loader.load(f, path);
        System.out.println(repElements.size());
    }

}