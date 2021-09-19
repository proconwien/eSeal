package wien.procon.eSeal.integration;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPSClient;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


/**
 * http://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/ftp/FTPSClient.html
 */
public class SealPresentationReader implements Tasklet {

    private final String host;
    private final String user;
    private final String password;

    FTPSClient ftpsClient;

    FTPFile[] ftpFiles;

    public void listFiles() throws IOException {
        // defaults to  explicit TLS/SSL (recommended)
        ftpsClient = new FTPSClient();
        ftpsClient.setDefaultPort(42756);
        ftpsClient.setConnectTimeout(35000);
        ftpsClient.setNeedClientAuth(true);
        ftpsClient.connect(host,42756);

        ftpsClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpsClient.execPBSZ(0);  // Set protection buffer size
        ftpsClient.execPROT("P"); // Set data channel protection to private
        ftpsClient.enterLocalPassiveMode();
        ftpsClient.login(user, password);

        ftpFiles = ftpsClient.listFiles();
        String[] nameArray = ftpsClient.listNames();
        for (String name:nameArray) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ftpsClient.retrieveFile(name,byteArrayOutputStream);
        }
        Integer i = ftpFiles.length;
         i=3;
    }

    public SealPresentationReader(String host, String user, String password) {

        this.host = host;
        this.user = user;
        this.password = password;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        return null;
    }
}
