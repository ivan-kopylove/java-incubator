package heap.ad2e;

@FunctionalInterface
interface LambdaInterface
{
    long doSomething(String str, int num);

    default int someDefaultMethod()
    {
        return 0;
    }
}
