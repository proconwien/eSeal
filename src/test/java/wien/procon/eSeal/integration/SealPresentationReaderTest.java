package wien.procon.eSeal.integration;

import org.junit.jupiter.api.Test;

class SealPresentationReaderTest {

    @Test
    void testSeal() throws Exception {
        SealPresentationReader sealPresentationReader = new SealPresentationReader( "ftps.bytebar.eu",  "Lisle",  "w4FSi7ucWA8X");
        sealPresentationReader.read();
    }
}