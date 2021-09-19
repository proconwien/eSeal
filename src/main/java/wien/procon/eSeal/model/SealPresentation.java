package wien.procon.eSeal.model;

import javax.persistence.Entity;
import java.time.ZonedDateTime;

@Entity
public class SealPresentation {
    public EndPoint endPoint;
    public CommunicationPath communicationPath;

    public String hash;
    public byte[] originalBinaryData;

    public ZonedDateTime presented;
    public ZonedDateTime received;
}
