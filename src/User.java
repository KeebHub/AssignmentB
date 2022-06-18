import java.util.List;

public class User
{
    private int type;
    private String name, password, country, gender, Nationality;
    private List<String> testAns;
    //Constructor for login
    public User(int type, String name, String password)
    {
        this.type = type;
        this.name = name;
        this.password = password;
    }
    
    //Constructor for viewing results
    public User(String name, List<String> testAnsList)
    {
        this.name = name;
        this.testAns = testAnsList;
    }
    
    public List<String> gettestAns()
    {
        return this.testAns;
    }
    
    public int getType()
    {
        return this.type;
    }
    public String getName()
    {
        return this.name;
    }
    public String getPassword()
    {
        return this.password;
    }
    public String getCountry()
    {
        return this.country;
    }
    public String getGender()
    {
        return this.gender;
    }
    public String getNationality()
    {
        return this.Nationality;
    }
    public void setType(int type)
    {
        this.type = type;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setCountry(String country)
    {
        this.country = country;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public void setNationality(String nationality)
    {
        this.Nationality = nationality;
    }
}