import java.util.Map;
import java.util.Scanner;

public class RequestService
{
    private Map<Integer,UsefulObject> _dictionary;
    public  void RunService(Map<Integer,UsefulObject> dictionary)
    {
        _dictionary = dictionary;

        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;

        System.out.println("Здравствуйте, что бы вы хотели сделать?");
        System.out.println("1 - Display a record");
        System.out.println("2 - Search records by name");
        System.out.println("3 - Exit");

        while (!isExit)
        {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 :
                    displayRecordById();
                    break;
                case 2 :
                    displayRecordsByName();
                    break;
                case 3 :
                    isExit = true;
                    break;
                default :
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayRecordById()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: ");
        int choice = scanner.nextInt();

        UsefulObject obj = _dictionary.get(choice);

        if(obj == null)
        {
            System.out.println("ID is not founded");
        }

        obj.PrintData();
    }

    private void displayRecordsByName()
    {
        int stack = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String nameSearch = scanner.nextLine();

        for (UsefulObject obj : _dictionary.values() )
        {
            if(nameSearch.equalsIgnoreCase(obj.Name))
            {
                stack++;
                obj.PrintData();
            }
        }

        if(stack == 0)
        {
            System.out.println("Запись не найдена.\n");
        }

    }

}
