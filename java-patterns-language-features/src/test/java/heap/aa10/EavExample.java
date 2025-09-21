package heap.aa10;

import org.junit.jupiter.api.Test;

import java.util.List;

class EavExample
{
    private String       phoneNumber;
    private List<String> eav;

    @Test
    void main()
    {
        EAVRecord entity = new EAVRecord();
        entity.dataType = "String";
        entity.value = "904";
        entity.entity = "phoneNumber";
    }
}

class EAVRecord
{
    String entity;
    String dataType;
    Object value;
}