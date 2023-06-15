package testData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class TestDataReader {
    private TestDataStructure testData;

    public TestDataReader(String filePath) throws IOException {
        loadTestData(filePath);
    }

    private void loadTestData(String filePath) throws IOException {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader(filePath);
        Type dataType = new TypeToken<TestDataStructure>() {}.getType();
        testData = gson.fromJson(fileReader, dataType);
    }

    public List<EmailAndPassword> getEmailsAndPasswordsCorrect() {
        return testData.getEmailsAndPasswordsCorrect();
    }

    public List<EmailAndPassword> getEmailsAndPasswordsIncorrect() {
        return testData.getEmailsAndPasswordsIncorrect();
    }

    public List<String> getValidEmails() {
        return testData.getValidEmails();
    }

    public List<String> getInvalidEmails() {
        return testData.getInvalidEmails();
    }

    public List<UsernameAndPassword> getUsernamesAndPasswordsIncorrect() {
        return testData.getUsernamesAndPasswordsIncorrect();
    }

    public List<UsernameAndPassword> getUsernamesAndPasswordsCorrect() {
        return testData.getUsernamesAndPasswordsCorrect();
    }
    


}

