package hieubt.projects.swd_crm_coffee.ultilities;

public class UnitConverter {

    public static String getDateString(String dateString) {
        int pos = dateString.indexOf("T");
        return dateString.substring(0, pos);
    }
}
