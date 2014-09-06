package syncthing.bep.util;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static syncthing.bep.util.Xdr.xdr;

public class XdrInputStreamTests {

    @Test
    public void readsStrings() throws IOException {
        byte[] xdrBytes = xdr("String One", "String Two");
        XdrInputStream in = new XdrInputStream(xdrBytes);

        assertThat(in.readString(), is(equalTo("String One")));
        assertThat(in.readString(), is(equalTo("String Two")));
    }

}
