package de.hpi.isg;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author Lan Jiang
 * @since 2019-07-23
 */
public class ProcessorTest {

    @Test
    public void produceTextDataLinks() throws IOException {
        File outputFile = new File("datafile-links-text.txt");
        if (outputFile.exists()) {
            outputFile.delete();
        }

        String path = "/Users/Fuga/Documents/hpi/data/data-gov/dataset-metadata";

        File[] files = new File(path).listFiles();

        String[] formats = new String[]{"TEXT"};

        Processor processor = new Processor();

        for (File file : Objects.requireNonNull(files)) {
            if (file.getName().equals(".DS_Store")) {
                continue;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            processor.process(bufferedReader.readLine(), Arrays.asList(formats), outputFile.getName());
            bufferedReader.close();
        }
    }

    @Test
    public void produceTextDataLinksUK() throws IOException {
        File outputFile = new File("datafile-links-excel-uk.txt");
        if (outputFile.exists()) {
            outputFile.delete();
        }

        String path = "/Users/Fuga/Documents/hpi/data/data-gov/dataset-uk-metadata";

        File[] files = new File(path).listFiles();

        Processor processor = new Processor();

        String[] formats = new String[]{"XLS", "XLSX"};

        for (File file : Objects.requireNonNull(files)) {
            if (file.getName().equals(".DS_Store")) {
                continue;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            processor.process(bufferedReader.readLine(), Arrays.asList(formats), outputFile.getName());
            bufferedReader.close();
        }
    }
}
