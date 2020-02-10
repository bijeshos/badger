package io.github.bijeshos.badger.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import org.apache.commons.codec.digest.DigestUtils;

public class ChecksumUtils {
    public static String getMd5HexDigest(Path filePath) throws IOException {
        InputStream inputStream = new FileInputStream(filePath.toFile());
        return DigestUtils.md5Hex(inputStream);
    }

    public static String getSha256HexDigest(Path filePath) throws IOException {
        try (InputStream inputStream = new FileInputStream(filePath.toFile());) {
            return DigestUtils.sha256Hex(inputStream);
        } catch (IOException e) {
            throw e;
        }
    }
}
