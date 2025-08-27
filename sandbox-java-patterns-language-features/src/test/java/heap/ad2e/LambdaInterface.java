package heap.ad2e;


@FunctionalInterface
public interface LambdaInterface
{
    long doSomething(String str, int num);

    default int someDefaultMethod()
    {
        return 0;
    }
}
