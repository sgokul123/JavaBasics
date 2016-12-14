
public class Utility {

	public static void main(String args[]){
		
		Utility u=new Utility();
		boolean b=u.isArmStrong(20);
		if(b){
			System.out.println("Number is  Armstrong .");
		}else{
			System.out.println("Number is Not Armstrong .");
		}
		
		private static boolean isAnagram(String s1,String s2){
			String s1,s2;
			s1=s1;
			s2=s2;
			int b=0,c=0;
			if(s1.length()>s2.length())
			   {
				System.out.print("String 2nd is smaller");
			   }
			  else if(s1.length()<s2.length())
			  {
				System.out.println("String 1st is smaller");
				}
			  else {
				  
			   for(int i=0;i<s1.length();i++) 
			   {
			      char s = s1.charAt(i);
			      for(int j=0;j<s2.length();j++) 
			      {
			         if(s==s2.charAt(j))
			         {
			            b++;
			         } 
			      }
			      if(b==0)
			         break;
			   }
			   if(b==0)
			      System.out.print("String is not Anagram:");
			   else 
			      System.out.print("String is Anagram :");
			} 
			System.out.print("");
		}
		
		
		
	}
	private static boolean isArmStrong(int number) {
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
}
//pratikranjane94/basic-programs