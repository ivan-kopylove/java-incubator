package leetcode.b282;

import java.io.*;


/// [problem definition](https://contest.yandex.ru/contest/8458/problems/D/)
/// [searchable problem definition](https://www.google.com/search?client=ubuntu-sn&channel=fs&q=yandex+contest+%D0%B3%D0%B5%D0%BD%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D1%8F+%D1%81%D0%BA%D0%BE%D0%B1%D0%BE%D1%87%D0%BD%D1%8B%D1%85+%D0%BF%D0%BE%D1%81%D0%BB%D0%B5%D0%B4%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D0%B5%D0%B9)
/// [searchable solution source](https://www.google.com/search?q=%22%D0%9D%D0%B0+System.out+%D0%BD%D0%B0%D0%B4%D0%B5%D0%BD%D0%B5%D0%BC+%D0%B1%D1%83%D1%84%D0%B5%D1%80+%D0%B2+64+%D0%BA%D0%B8%D0%BB%D0%BE%D0%B1%D0%B0%D0%B9%D1%82%D0%B0%2C+%D0%BE%D0%BD+%D0%BD%D0%B5+%D0%B8%D0%BC%D0%B5%D0%B5%D1%82+%D1%81%D0%B2%D0%BE%D0%B5%D0%B3%D0%BE+%D0%B1%D1%83%D1%84%D0%B5%D1%80%D0%B0.%22)
public class MySolutionOutstandsMemoryLimit20mb
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String line = r.readLine();
    
    	int n = Integer.parseInt(line);
        dfs(new StringBuilder(6), 0, 0, n);
    }

	private static void dfs(StringBuilder current, int left, int right, int n)
    {
    	if(current.length() == n * 2)
        {
            System.out.println(current);
        	return;
        }
    
    	if(left < n)
        {
            current.append("(");
        	dfs(current, left + 1, right, n);
            current.deleteCharAt(current.length() - 1);
        }
    
    	if(right < left)
        {
            current.append(")");
        	dfs(current, left, right + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    	
    	
    	
    }
}

