//////////////////Program to change number to word/////////////

import java.util.*;
import java.io.*;
public class numbertowords{

	public String changetoword(int n)
	{
		String[] ones = {"","one","two","three","four","five","six","seven","eight","nine"};
		String[] teen = {"","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		String[] tens = {"","ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
		String[] levels = {"hundred","thousand","lac","crore"};
		int level = 1;
		int temp=0,savednum=0;
		String output = "";

		if(n == 0)
			return "zero";

		while(n>0)
		{
			temp = n % 10;
			
			if(temp == 0)
			{
				n = n/10;
				level++;
			}
			else
			{	
				if(level == 1)
				{
					savednum = temp;
					output = ones[temp];
					n = n/10;
					level++;
				}
				else if(level == 2)
				{
					if(temp == 1)
					{
						output = "";
						output = teen[savednum];
					}
					else
						output = tens[temp] + output;
					n = n/10;
					level++;
				}
				else if(level == 3)
				{
						String t = ones[temp] + " " + levels[level - 3];
						output = t + " " + output;
						n = n/10;
						level++;
				}
				else
				{
					int d = temp;
					n = n/10;
					temp = n%10;

					if(temp == 1)
					{
						String t = teen[d] + " " +  levels[level - 3];
						output = t + " " + output;
						n = n/10;
						level++;
					}
					else
					{
						String t = tens[temp] + " " + ones[d] + " " + levels[level - 3];
						output = t + " " + output;
						n = n/10;
						level++;
					}
				}
			}		

		}
		return output;

	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		numbertowords nn = new numbertowords();
		String x = nn.changetoword(n);
		System.out.println(x);
	}
}