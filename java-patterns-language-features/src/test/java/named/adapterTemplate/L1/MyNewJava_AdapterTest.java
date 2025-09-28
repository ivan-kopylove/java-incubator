package named.adapterTemplate.L1;

import named.adapterTemplate.L1.adapter.MyNewJava_Adapter;
import named.adapterTemplate.L1.spi.MyNewJava_Spi;
import named.adapterTemplate.L1.usecase.MyNewJava_UseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import heap.qweqweweqweq.TestBase;
class MyNewJava_AdapterTest extends TestBase
{

    @Test
    @DisplayName("what is the purpose of this example?")
    void what_is_the_purpose_of_this_example()
    {
        // given
        MyNewJava_Adapter myNewJavaAdapter = new MyNewJava_Adapter(new MyNewJava_UseCase());

        // when
        String result = myNewJavaAdapter.callMe(new MyNewJava_Spi.Payload(""));

        // then
        assertThat(result, equalTo("some result 123"));
    }
}