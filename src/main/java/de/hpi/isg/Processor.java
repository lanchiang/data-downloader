package de.hpi.isg;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hpi.isg.pojo.DownloadPojo;
import de.hpi.isg.pojo.PackagePojo;
import de.hpi.isg.pojo.ResourcesPojo;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Lan Jiang
 * @since 2019-07-22
 */
public class Processor {

    private ObjectMapper mapper = new ObjectMapper();

    public void process(String line, List<String> format, String outputFile) throws IOException {
        DownloadPojo result = this.mapper.readValue(line, DownloadPojo.class);

        List<PackagePojo> packagePojos = result.getResult().getPackagePojos();
        List<ResourcesPojo> resourcesPojos = packagePojos.stream().flatMap(packagePojo -> packagePojo.getResourcesPojos().stream()).collect(Collectors.toList());
        resourcesPojos = resourcesPojos.stream().filter(resourcesPojo -> format.contains(resourcesPojo.getFormat())).collect(Collectors.toList());
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile, true));
        resourcesPojos.forEach(resourcesPojo -> {
            try {
                bufferedWriter.write(resourcesPojo.getUrl() + "\t" + resourcesPojo.getName());
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bufferedWriter.close();
    }

    public static void main(String[] args) throws IOException {
        File outputFile = new File("datafile-links.txt");
        if (outputFile.exists()) {
            outputFile.delete();
        }

        String path = "/Users/Fuga/Documents/hpi/data/data-gov/dataset-metadata";

        File[] files = new File(path).listFiles();

        Processor processor = new Processor();

        for (File file : Objects.requireNonNull(files)) {
            if (file.getName().equals(".DS_Store")) {
                continue;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            processor.process(bufferedReader.readLine(), Collections.singletonList("EXCEL"), outputFile.getName());
            bufferedReader.close();
        }
    }
}
