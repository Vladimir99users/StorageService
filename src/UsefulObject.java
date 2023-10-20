public class UsefulObject
{
    public int ID;
    public  String Name;
    public  String Description;
    public  String URL;

    public  UsefulObject()
    {
        this("default name", "default Description", "default url", -1 );
    }
    public UsefulObject(String name, String description, String uRL, int id)
    {
        ID = id;
        Name = name;
        Description = description;
        URL = uRL;
    }
}
