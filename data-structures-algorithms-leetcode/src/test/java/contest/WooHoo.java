package contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/// - [problem definition](https://www.google.com/search?&q=yandex+contest+C.+Удаление+дубликатов)
class WooHoo
{
    static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String line = r.readLine();
        line = r.readLine();

        Set<String> duplicates = new HashSet<>();

        while (!"".equals(line))
        {
            if (!duplicates.contains(line))
            {
                System.out.println(line);
            }
            duplicates.add(line);

            line = r.readLine();
        }
    }
}

