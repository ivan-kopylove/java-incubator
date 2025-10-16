package heap.c085;

import java.util.Date;

class ComparableObject
{

    private String str;
    private Date   date;
    private int    num;

    ComparableObject(String str, Date date, int num)
    {
        this.str = str;
        this.date = date;
        this.num = num;
    }

    String getStr()
    {
        return str;
    }

    void setStr(String str)
    {
        this.str = str;
    }

    Date getDate()
    {
        return date;
    }

    void setDate(Date date)
    {
        this.date = date;
    }

    int getNum()
    {
        return num;
    }

    void setNum(int num)
    {
        this.num = num;
    }
}
