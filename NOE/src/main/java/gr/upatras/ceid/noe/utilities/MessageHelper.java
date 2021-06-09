package gr.upatras.ceid.noe.utilities;

import javax.swing.*;

public class MessageHelper {

    private static final String CONFIRMATION = "Επιβεβαίωση";

    public static void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static boolean showEvaluationProposalMessage(String message) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, message, CONFIRMATION, dialogButton);
        return dialogResult == 0;
    }

    public static boolean showConfirmationMessage(String message) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, message, CONFIRMATION, dialogButton);
        return dialogResult == 0;
    }

    private void close() {
    }
}
