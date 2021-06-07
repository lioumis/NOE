package gr.upatras.ceid.noe.utilities;

import java.util.ArrayList;

public class RoleHelper {
    public static ArrayList<String> mapRoles(ArrayList<String> roleIds){
        ArrayList<String> roles = new ArrayList<>();
        for (String roleId : roleIds) {
            switch (Integer.parseInt(roleId)){
                case 1:
                    roles.add("Ασθενής");
                    break;
                case 2:
                    roles.add("Ιατρός");
                    break;
                case 3:
                    roles.add("Διευθυντής");
                    break;
                case 4:
                    roles.add("Γραμματέας");
                    break;
                case 5:
                    roles.add("Υπεύθυνος Προμηθειών");
                    break;
            }
        }
        return roles;
    }
}
