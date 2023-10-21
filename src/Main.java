// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {

        if(args.length > 1)
        {
            throw new Exception("Many arguments!");
        }

        String path = args[0];
        IReadable readFile = new ReadDataFromFile();
        String finallyStr =  readFile.Read(path);

        System.out.println(finallyStr);
    }


}

