package io.github.bijeshos.badger.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryReaderUtils {
    public static List<Path> getAllFilePaths(String parentDir) throws IOException {
        if (Files.exists(Paths.get(parentDir))) {
            try (Stream<Path> pathStream = Files.walk(Path.of(parentDir))) {
                return pathStream.filter(Files::isRegularFile)
                                 .collect(Collectors.toList());
            }
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    public static List<Path> getAllDirectoryPathsAtDepth(String parentDir, int targetDepth) throws IOException {
        if (Files.exists(Paths.get(parentDir))) {
            try (Stream<Path> pathStream = Files.walk(Path.of(parentDir), targetDepth)) {
                List<Path> pathList = pathStream.filter(Files::isDirectory)
                                                .collect(Collectors.toList());
                Set<Path> parentPaths = pathList.stream()
                                                .map(p -> p.getParent())
                                                .collect(Collectors.toSet());
                pathList.removeAll(parentPaths);
                return pathList;
            }
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    public static List<Path> getAllDirectoryPaths(String parentDir) throws IOException {
        if (Files.exists(Paths.get(parentDir))) {
            try (Stream<Path> pathStream = Files.walk(Paths.get(parentDir))) {
                return pathStream.filter(Files::isDirectory)
                                 .collect(Collectors.toList());
            }
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    public static List<Path> getFilePathsByExtension(String parentDir, Set<String> relevantExtensions) throws IOException {
        return getFilePathsByExtension(Path.of(parentDir), relevantExtensions);
    }

    public static List<Path> getFilePathsByExtension(Path parentDir, Set<String> relevantExtensions) throws IOException {
        if (Files.exists(parentDir)) {
            try (Stream<Path> pathStream = Files.walk(parentDir)) {
                return pathStream.filter(Files::isRegularFile)
                                 .filter((path) -> isRelevantExtension(path, relevantExtensions))
                                 .collect(Collectors.toList());
            }
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    public static List<Path> getFilePathsByPattern(String parentDir, String pattern) throws IOException {
        return getFilePathsByPattern(Path.of(parentDir), pattern);
    }

    public static List<Path> getFilePathsByPattern(Path parentDir, String pattern) throws IOException {
        if (Files.exists(parentDir)) {
            try (Stream<Path> pathStream = Files.walk(parentDir)) {
                return pathStream.filter(Files::isRegularFile)
                                 .filter(path -> path.toString()
                                                     .contains(pattern))
                                 .collect(Collectors.toList());
            }
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    private static boolean isRelevantExtension(Path filePath, Set<String> relevantExtensions) {
        String fileExtension = com.google.common.io.Files.getFileExtension(filePath.toString())
                                                         .toLowerCase();
        return relevantExtensions.contains(fileExtension);
    }
}
