import com.alibaba.fastjson.serializer.UUIDCodec;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by GaoXiang on 2015/12/28 0028.
 */
public class JavaUUIDTest {

    @Test
    public void testMain() throws Exception {
        Long uuid = UUID.randomUUID().getLeastSignificantBits();

        System.out.println(uuid);
    }
}