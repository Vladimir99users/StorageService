import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RequestServiceTest
{
    @Test
    public  void AddToStorageUsefulObjects()
    {
        UsefulObject objExpected = new UsefulObject(2, "Drop down", "Отключиться", "https://yandex.ru");

        Map<Integer,UsefulObject> dictionary = new HashMap<Integer,UsefulObject>();

        dictionary.put(objExpected.ID, objExpected);

        UsefulObject newObj = new UsefulObject(2, "Drop down", "Отключиться", "https://yandex.ru");

        assertNotEquals(objExpected, newObj);
    }

    private  static List<UsefulObject> GetDataFromString(String finallyStr)
    {
        List<UsefulObject> usefulObjects = new ArrayList<UsefulObject>();

        String[] str = finallyStr.split("\n");
        for (String s : str) {
            String[] value = s.split(",");

            UsefulObject newObj = new UsefulObject
                    (
                            Integer.parseInt(value[0]),
                            value[1],
                            value[2],
                            value[3]
                    );

            usefulObjects.add(newObj);
        }
        return usefulObjects;
    }

    @Test
    public void CorrectIDTest()
    {
        int testID = 109;

        IReadable readFile = new ReadDataFromFile();

        String value = readFile.Read(GetPathToFile());
        List<UsefulObject> usefulObjects = GetDataFromString(value);

        Map<Integer,UsefulObject> dictionary = SetDataFromDictionary(usefulObjects);

        RequestService sevice = new RequestService(dictionary);

        UsefulObject obj = sevice.displayRecordById(testID);

        assertNotNull(obj);
        assertEquals(testID, obj.ID);
    }

    @Test
    public void SearchUsefulObjectToNameTest()
    {
        String nameExpected = "Led";

        IReadable readFile = new ReadDataFromFile();

        String value = readFile.Read(GetPathToFile());
        List<UsefulObject> usefulObjects = GetDataFromString(value);

        Map<Integer,UsefulObject> dictionary = SetDataFromDictionary(usefulObjects);

        RequestService sevice = new RequestService(dictionary);

        UsefulObject obj = sevice.displayRecordsByName(nameExpected);

        assertNotNull(obj);
        assertEquals(nameExpected, obj.Name);
    }

    private  static Map<Integer,UsefulObject> SetDataFromDictionary(List<UsefulObject> datas)
    {
        Map<Integer,UsefulObject> dictionary = new HashMap<Integer,UsefulObject>();

        for (UsefulObject data : datas)
        {
            dictionary.put(data.ID, data);
        }

        return  dictionary;
    }

    private String GetPathToFile()
    {
        return "D:\\C#_WPF\\WhiteStudentsJava\\RequestServiceTest\\src\\test\\java\\TestFile";
    }
}
