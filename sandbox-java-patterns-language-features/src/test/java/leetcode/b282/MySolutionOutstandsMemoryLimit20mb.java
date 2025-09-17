package leetcode.b282;

import java.io.*;

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

