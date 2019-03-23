package hieubt.projects.swd_crm_coffee.ultilities;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;

import hieubt.projects.swd_crm_coffee.Model.Membership;

public class UserSession {
    private static String id;
    private static List<Membership> userMembership = new ArrayList<>();
    private static String qrCode = "";

    @Contract(pure = true)
    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        UserSession.id = id;
    }

    public static List<Membership> getUserMembership() {
        return userMembership;
    }

    public static void setUserMembership(List<Membership> userMembership) {
        UserSession.userMembership = userMembership;
    }

    public static String getQrCode() {
        return qrCode;
    }

    public static void setQrCode(String qrCode) {
        UserSession.qrCode = qrCode;
    }
}
