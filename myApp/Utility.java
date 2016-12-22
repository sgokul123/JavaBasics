package myApp;
import Info.Userinfo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
public class Utility {
	BufferedReader br;;
	public static void main(String args[]){
		
		//Utility u=new Utility();
		
		
	}
	//validate username by checking length
	public boolean checkLength(String temp)
	{
		int length=temp.length();
		if(length<3)
		{
		return false;
		}
		else
		{
		return true;	
		}
	}
	public String replaceUsername(String temp)
	{
		String uname="Hello username";
		uname=uname.replaceAll("username",temp);
		return uname;
	}

	public  boolean isArmStrong(int number) {
        int result = 0;
        int orig = number;
        while(number != 0){
            int remainder = number%10;
            result = result + remainder*remainder*remainder;
            number = number/10;
        }
        //number is Armstrong return true
        if(orig == result){
            return true;
        }
      
        return false;
    }
//return Date in form dd/mm/yyyy format
	public static String getFormattedDate(Date date)
	{
			SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
			return sdf.format(date);
	}
	//Replace the user details with regex
	public String RegexReplace(Userinfo user,String message)
	{
		String firstName="<<Name>>";
		String fullName="<<Full Name>>";
		String mobileno="xxxxxxxxxx" ;
		String Date="01/01/2016";
		
		//Regex to replace first Name 
		Pattern p=Pattern.compile(firstName);
		Matcher m=p.matcher(message);
		message=m.replaceAll(user.getFirstName()); 

		//Regex to replace full Name
		p=Pattern.compile(fullName);
		m=p.matcher(message);
		message=m.replaceAll(user.getFirstName()+" "+user.getLastName());

		//Regex to replace mobile number
		p=Pattern.compile(mobileno);
		m=p.matcher(message);
		message=m.replaceAll(user.getMobileNumber());	


		//Regex to replace Date
		p=Pattern.compile(Date);
		m=p.matcher(message);
		message=m.replaceAll(user.getDate());

		return message;
	} 
//
public boolean isTenDigit(String number) {
		if((number.length())==10&&number.contains("[a-zA-Z]+") == false)
			return true;
		else
			return false;
	}
//Calculate percentage of head and tail
public void countHeadTail(int no)
{
int head=0;
int tail=0;
int i;
float headPer,tailPer;
	Random r=new Random();
	for(i=0;i<no;i++)
	{
		if((r.nextInt(no)%2)< 0.5 ) //creating random no to count head and tail
		{
		head++;
		}
		else
		{
		tail++;
		}
	}
	headPer=head*(100/no);	//calculating percentage of head
	tailPer=tail*(100/no);	//calculating percentage of tail
	System.out.println("No of heads:"+headPer);
	System.out.println("No of tails:"+tailPer);
}
//To calculate prime factors of n no
public void PrimeFactors(int no) 
{
	int factor;
	for(factor=2;factor*factor<=no;factor++)
	{
		while(no%factor==0)
		{
			System.out.println(factor+" ");
			no=no/factor;
		}
	}
	if(no>1)
		System.out.println(no);
}
//String is anagram or not
public boolean isAnagram(String str1,String str2)
{
int i,j,flag=0;
if(str1.length()==str2.length())
	{
		char ctr1[]=str1.toCharArray();
		char ctr2[]=str2.toCharArray();
		System.out.println(str1.length());
		for(i=0;i<str1.length();i++)
		{
			for(j=0;j<str2.length();j++)
			{
				if(ctr1[i]==ctr2[j])
				{
				flag=1;
				break;
				}
				else
				flag=0;
			}
		}
	}
	if(flag==1)
	return true;
	else
	return false;
    	
}
//Find triple that sums to zero
public void findTriple(int list[],int no)
{
int i,j,k,flag=0;
for(i=0;i<no;i++)
{
	for(j=i+1;j<no;j++)
	{
		for(k=j+1;k<no;k++)
		{
			if((list[i]+list[j]+list[k])==0)
			{
			System.out.println("Combination of triples: "+list[i]+" "+list[j]+" "+list[k]+"=0");
			flag=1;
			break;
			}
		}
	}
}
if(flag==0)
	System.out.println("No triple found");
}


//search no using Binary search
public void binaryNoSearch(int search,int array[]) 
{
	int key,n;
	int middle;
	System.out.println(" No of element you have. ");
	n=array.length;
	
	int first=0,last=n,flag=0;
		//search no using Binary search
	int arr[]=new int[n];
	arr=array;
    Arrays.sort(arr);
    for(int i=0;i<n;i++){
		System.out.print("   "+arr[i]+"At index ->"+i);
	}
    System.out.println();
    key=search;
     middle=(first+last)/2;
		while(first<=last)
		{
			if(arr[middle]==key){
				System.out.println("Elment is Present in array at"+middle+"     Location");
				flag=1;
				break;
			}
				else if(key<arr[middle]){
				last=middle-1;
				middle=(first+last)/2;
				
			}
			else{
				first=middle+1;
				middle=(first+last)/2;
			}
			
	  }
		if(flag==0){
			System.out.println("Element is Not Present in List ...");
		}
}

//Wtrite code year validation.
	public int isValid(int n){
		int flag=0,cnt=0;
		int num=n;;
			while(num>0){
    			num=num/10;
    			cnt=cnt+1;
    		}
    		if(cnt==4)
    		{
    			flag=1;
    			}
    		else {
    				flag=0;
    				}
    	
    	return flag;
    
	}
	//Search world using binary search
	public void binaryWordSearch(String list[],String word) 
	{
		int i,first=0;
		int count=0;
		int last=list.length-1;
		int middle=(first+last)/2;
		//searching start
		for(i=0;i<=last;i++)
		{
			if((list[middle].compareTo(word))==0)//match found
			{
			count++;
			System.out.println("Match found at "+(middle+1));
			break;
			}
			else if(list[middle].compareTo(word)<0)//middle is less than word to be search
			{
			first=middle+1;
			count++;
			}
			else	//middle is greater than word to be search
			{
			last=middle-1;
			count++;
			}
			middle=(first+last)/2;
		}
		if(first>last)	//word is not found
			System.out.println("Word is not found "+word);

		System.out.println("No of attempts to search"+count);
	}


	//bubble sort for integers
	public int[] bubbleSort(int list[],int no)
	{
		int i,j,temp;
		for(i=0;i<no;i++)
		{
			for(j=0;j<no-i-1;j++)
			{
			//bubble sort logic
				if(list[j]>list[j+1])
				{
				temp=list[j+1];
				list[j+1]=list[j];
				list[j]=temp;
				}
			}
		}
		return list;
	}
	//validate username by checking length
	public boolean checkSLength(String temp)
	{
		int length=temp.length();
		if(length<3)
		{
		return false;
		}
		else
		{
		return true;	
		}
	}
	
	public int inputInteger()
    {
		br = new BufferedReader(new InputStreamReader(System.in));
		try{
   		int number = Integer.parseInt(br.readLine());
   		return number;
   		}catch(Exception e) {
   			System.out.println(e);
    }
    return 0;
}
	//input string
		public String inputString(){
			try{
				return br.readLine();
			}
			catch(Exception e){
				System.out.println(e);
			}
			return "";
	}
		//input double
		public double inputDouble(){
			try{
				return br.read();
			}
			catch(Exception e){
				System.out.println(e);
			}
			return 0.0;
		}

}
