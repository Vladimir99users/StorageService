import java.io.*;

public  class  ReadDataFromFile implements IReadable
{

    @Override
    public String Read(String path)
    {
        File file = new File(path);
        String str = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                str += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}