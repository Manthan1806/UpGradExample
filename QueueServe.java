import java.util.*;

class Marks implements Comparable<Marks>
{
	double cgpa;
	String name;
	int token;
	
	public Marks(double cgpa,String name,int token)
	{
		this.cgpa = cgpa;
		this.name = name;
		this.token = token;
	}
	
	@Override
	public int compareTo(Marks m) 
	{
		if(cgpa<m.cgpa)
		{
			return 1;
		}
		else if(cgpa>m.cgpa)
		{
			return -1;
		}
		else 
		{
			if(name.compareToIgnoreCase(m.name)>0)
	    	{
	    		return 1;
	    	}
	    	else if(name.compareToIgnoreCase(m.name)<0)
	    	{
	    		return -1;
	    	}
			return 0;
		}
	}	
	
}


public class QueueServe
{
	public static void main(String[] args)
	{
		Queue<Marks> queue = new PriorityQueue<Marks>();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Input Size : ");
		int size = in.nextInt();
		Marks[] marks = new Marks[size];
		String name;
		int token;
		double cgpa;
		int j=0;
		for(int i=0;i<size;i++)
		{
			marks[i] = new Marks(-1.00,"",0);
		}
		for(int i=0;i<size+1;i++)
		{
			String input = in.nextLine();
			String split[] = input.split("\\s");
			if(split.length>1)
			{
				name = split[1];
				cgpa = Double.parseDouble(split[2]);
				token = Integer.parseInt(split[3]);
				marks[j] = new Marks(cgpa, name, token);
				Arrays.sort(marks);
				queue.add(new Marks(cgpa, name, token));
				j++;
			}
			else if(split[0].equals("SERVED"))
			{
				queue.remove();
			}
		}
		System.out.println("Output :");
		for(Marks m:queue)
		{
			System.out.println(m.name);
		}
		in.close();
	}
}