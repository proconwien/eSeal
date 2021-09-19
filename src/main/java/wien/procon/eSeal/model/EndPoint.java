package wien.procon.eSeal.model;

import java.util.Set;

public class EndPoint {
    public enum EnumFixMobile {fix,mobile};

    public EnumFixMobile enumFixMobile;
    public MountLocation currentLocation;

    Set<MountLocation> mountLocationSet;
}
