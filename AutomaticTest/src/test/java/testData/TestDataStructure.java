package testData;

import java.util.List;

public class TestDataStructure {
    private List<EmailAndPassword> emailsAndPasswordsCorrect;
    private List<EmailAndPassword> emailsAndPasswordsIncorrect;
    private List<String> validEmails;
    private List<String> invalidEmails;
    private List<UsernameAndPassword> usernamesAndPasswordsIncorrect;
    private List<UsernameAndPassword> usernamesAndPasswordsCorrect;

    public List<EmailAndPassword> getEmailsAndPasswordsCorrect() {
        return emailsAndPasswordsCorrect;
    }

    public List<EmailAndPassword> getEmailsAndPasswordsIncorrect() {
        return emailsAndPasswordsIncorrect;
    }

    public List<String> getValidEmails() {
        return validEmails;
    }

    public List<String> getInvalidEmails() {
        return invalidEmails;
    }

    public List<UsernameAndPassword> getUsernamesAndPasswordsIncorrect() {
        return usernamesAndPasswordsIncorrect;
    }

    public List<UsernameAndPassword> getUsernamesAndPasswordsCorrect() {
        return usernamesAndPasswordsCorrect;
    }
}
