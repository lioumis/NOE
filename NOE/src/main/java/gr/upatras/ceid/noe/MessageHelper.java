package gr.upatras.ceid.noe;

import javax.swing.*;

public class MessageHelper {

    public static void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static boolean showEvaluationProposalMessage(String message) {
        return true;
    }

    public static boolean showConfirmationMessage(String message) {
        return true;
    }

    private void close() {
    }
}
