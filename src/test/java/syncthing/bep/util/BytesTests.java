package syncthing.bep.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static syncthing.bep.util.Bytes.*;

public class BytesTests {

    @Test
    public void testDecompositionOfByteIntoBits() {
        boolean[] bits = bits((byte) 0b10101010);
        assertThat(bits, is(equalTo(new boolean[]{true, false, true, false, true, false, true, false})));
    }

    @Test
    public void testDecompositionOfByteIntoNibbles() {
        byte twoNibbles = (byte) 0b10100101;
        assertThat(nibbles(twoNibbles), is(equalTo(new byte[]{0b1010, 0b0101})));
    }

    @Test
    public void testDecompositionOfShortIntoBytes() {
        short twoBytes = (short) 0b1010101001010101;
        assertThat(bytes(twoBytes), is(equalTo(new byte[]{(byte) 0b10101010, 0b01010101})));
    }

    @Test
    public void testDecompositionOfIntIntoBytes() {
        assertThat(bytes(0xF00FA00A), is(equalTo(new byte[]{(byte) 0xF0, 0x0F, (byte) 0xA0, 0x0A})));
    }

    @Test
    public void testConcatenationOfBitsIntoByte() {
        boolean[] bits = new boolean[]{true, false, true, false, true, false, true, false};
        assertThat(concatenateBits(bits), is(equalTo((byte) 0b10101010)));
    }

    @Test
    public void testConcatenationOfNibblesIntoByte() {
        assertThat(concatenateNibbles((byte) 0b1010, (byte) 0b0101), is(equalTo((byte) 0b10100101)));
    }

    @Test
    public void testConcatenationOfBytesIntoShort() {
        byte leftByte = (byte) 0b10101010;
        byte rightByte = (byte) 0b01010101;
        assertThat(concatenateBytes(leftByte, rightByte), is(equalTo((short) 0b1010101001010101)));
    }

    @Test
    public void testConcatenationOfBytesIntoInt() {
        byte b0 = (byte) 0xF0;
        byte b1 = 0x0F;
        byte b2 = (byte) 0xA0;
        byte b3 = 0x0A;
        assertThat(concatenateBytes(b0, b1, b2, b3), is(equalTo(0xF00FA00A)));
    }

    @Test
    public void testUnsignedByte() {
        assertThat(unsigned((byte) 0xFF), is(equalTo(255)));
    }

    @Test
    public void testUnsignedInt() {
        assertThat(unsigned(0xFFFFFFFF), is(equalTo(4294967295L)));
    }
}
