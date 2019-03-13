package hieubt.projects.swd_crm_coffee.ultilities;

import org.jetbrains.annotations.Contract;

public class UserSession {
    private static String id;

    @Contract(pure = true)
    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        UserSession.id = id;
    }
}
