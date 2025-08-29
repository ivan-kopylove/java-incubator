package named.adapter_template.L1.api;

@FunctionalInterface
public interface MyNewJava_Api
{
    Result callMe(Payload myPayload);

    record Payload(String myPayload)
    {}

    interface Result
    {

        <T> T adapt(ResultAdapter<T> resultAdapter);

        interface ResultAdapter<T>
        {

            T onSuccess(MySuccessResult result);

            T onFailure(MyFailureResult result);
        }

        record MySuccessResult(String myResultField) implements Result
        {

            @Override
            public <T> T adapt(ResultAdapter<T> resultAdapter)
            {
                return resultAdapter.onSuccess(this);
            }
        }

        record MyFailureResult(String myResultField) implements Result
        {

            @Override
            public <T> T adapt(ResultAdapter<T> resultAdapter)
            {
                return resultAdapter.onFailure(this);
            }
        }
    }
}
