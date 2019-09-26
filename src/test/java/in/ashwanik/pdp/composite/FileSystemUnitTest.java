package in.ashwanik.pdp.composite;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FileSystemUnitTest {
    @Test
    public void testFileSystem() {

        FileSystem fileSystem = new FileSystem("Ext4");
        fileSystem.add(new File("test.txt"));
        fileSystem.add(new Directory("test"));

        assertThat(fileSystem.numberOfDirectories()).isEqualTo(1);
        assertThat(fileSystem.numberOfFiles()).isEqualTo(1);
    }
}
