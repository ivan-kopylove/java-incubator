package heap.aaa8;

class WindowDecorator implements Window
{
    protected Window windowToBeDecorated;

    WindowDecorator(Window windowToBeDecorated)
    {
        super();
        this.windowToBeDecorated = windowToBeDecorated;
    }

    public void draw()
    {
        windowToBeDecorated.draw(); // delegation
    }

    public String getDescription()
    {
        return windowToBeDecorated.getDescription(); // delegation
    }
}
