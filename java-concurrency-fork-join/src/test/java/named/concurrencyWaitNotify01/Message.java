package named.concurrencyWaitNotify01;

class Message
{
    private String msg;

    Message(String msg)
    {
        this.msg = msg;
    }

    String getMsg()
    {
        return msg;
    }

    void setMsg(String msg)
    {
        this.msg = msg;
    }
}
