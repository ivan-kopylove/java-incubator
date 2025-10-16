package heap.a7d5;

class Person
{
    private String givenName;
    private String surName;
    private int    age;

    Person(String givenName, String surName, int age)
    {
        this.givenName = givenName;
        this.surName = surName;
        this.age = age;
    }

    String getGivenName()
    {
        return givenName;
    }

    void setGivenName(String givenName)
    {
        this.givenName = givenName;
    }

    String getSurName()
    {
        return surName;
    }

    void setSurName(String surName)
    {
        this.surName = surName;
    }

    int getAge()
    {
        return age;
    }

    void setAge(int age)
    {
        this.age = age;
    }
}
