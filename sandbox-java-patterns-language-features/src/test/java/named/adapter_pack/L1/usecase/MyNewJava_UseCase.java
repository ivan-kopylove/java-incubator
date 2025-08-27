package named.adapter_pack.L1.usecase;


import named.adapter_pack.L1.api.MyNewJava_Api;

public class MyNewJava_UseCase implements MyNewJava_Api {


    @Override
    public Result callMe(Payload myPayload) {
        return new Result.MySuccessResult("some result 123");
    }
}
