package io.github.bijeshos.jackal.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.bijeshos.jackal.common.StringUtils.isNotComment;

public class FileReaderUtils {
    public static List<String> readAllLinesExceptComments(String srcPath) throws IOException {
        return readAllLinesExceptComments(Paths.get(srcPath));
    }

    public static List<String> readAllLinesExceptComments(Path srcPath) throws IOException {
        return Files.readAllLines(srcPath)
                    .stream()
                    .filter(line -> isNotComment(line))
                    .collect(Collectors.toList());
    }
}
