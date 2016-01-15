package org.clojars.gguthe.phpass;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

public class TestPHPass extends TestCase {
    static final String correct = "test12345";
    static final String wrong = "test12346";
    static final String hashMD5 = "$P$9IQRaTwmfeRo7ud9Fh4E2PdI0S3r.L0";
    static final String hashBCrypt = "$2a$10$Ap88hInx7k41c.WE/CfI7u/XEjAAdOmwoFNfveT6pb6F7/uJ.4r9e";

    static final String correctpl = "ąćęłóńśźż";
    static final String wrongpl = "acelonszz";
    static final String hashplMD5 = "$P$ByXWbzDvVAJ0jxvNp5sv4xYPIRXJJ1.";
    static final String hashplBCrypt = "$2a$10$uVWyXfgJlCTXy837ZrXR1.UA2f1YbJsN19ykdDoqnfyzq26IYW9eS";
    static final PHPass phpass = new PHPass(12);
    String hashed = phpass.HashPassword(correct);

    public static void main(String args[]) {
        junit.textui.TestRunner.run(TestPHPass.class);
    }

    public final void testCheckPassword_correct() {
        boolean check = phpass.CheckPassword(correct, this.hashed);
        Assert.assertTrue(check);
    }
    
    public final void testCheckPassword_wrong() {
        boolean check = phpass.CheckPassword(wrong, this.hashed);
        Assert.assertFalse(check);
    }

    public final void testCheckPassword_givenhash_correct() {
        boolean check = phpass.CheckPassword(correct, hashBCrypt);
        Assert.assertTrue(check);
    }

    public final void testCheckPasswordWithMD5Hash_correct() {
        boolean check = phpass.CheckPassword(correct, hashMD5);
        Assert.assertTrue(check);
    }

    public final void testCheckPassword_givenhash_wrong() {
        boolean check = phpass.CheckPassword(wrong, hashBCrypt);
        Assert.assertFalse(check);
    }

    public final void testCheckPassword_nationalCharacters_correct() {
        boolean check = phpass.CheckPassword(correctpl, hashplBCrypt);
        assertTrue(check);
    }

    public final void testCheckPassword_nationalCharacters_correctMD5() {
        boolean check = phpass.CheckPassword(correctpl, hashplMD5);
        assertTrue(check);
    }

    public final void testCheckPassword_nationalCharacters_wrong() {
        boolean check = phpass.CheckPassword(wrongpl, hashplBCrypt);
        assertFalse(check);
    }

}
