package named.adapter_pack.L1.spi;


@FunctionalInterface
public interface MyNewJava_Spi {

    String callMe(Payload myPayload);


    record Payload(String myPayload) {
    }

}
