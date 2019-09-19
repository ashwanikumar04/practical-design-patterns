package in.ashwanik.pdp.adapter;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JsonAdapterUnitTest {

    @Test
    public void testAdapter() {
        String data = UUID.randomUUID().toString();
        OutputStream outputStream = new ByteArrayOutputStream();
        FileWriter writer = new FileWriter();
        writer.write(outputStream, data.getBytes());
        assertThat(outputStream.toString()).isEqualTo(data);
    }
}
