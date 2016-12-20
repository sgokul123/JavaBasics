/*
*
*
**/
import java.util.Scanner;
public class titackto{
		

		int cross=1,nought=2;
		int emty=0; 
		int arr[][]=new int[3][3];
		char arr1[][]=new char[3][3];
		int i,j,count=0,player=0,curplayer=0,status=0;
		int rows=0 ,colls=0;

		boolean isWon(int curP,int row,int coll){
		return arr[row][0]==curP &&arr[row][1]==curP && arr[row][2]==curP||arr[0][coll]==curP && arr[1][coll]==curP&&arr[2][coll]==curP||arr[0][0]==curP &&arr[1][1]==curP && arr[2][2]==curP||arr[0][2]==curP && arr[1][1]==curP&&arr[2][0]==curP;
		}
		
	boolean	isEmty(int row,int coll){
	return arr[row][coll]==0;
	}
	boolean insert(int player ,int row,int coll)
	 {
		if(isEmty(row,coll)){
		arr[row][coll]=player;	
		return true;	
		}
		else {return false;}
	}
	void board(){
	convert();
	for(int i=0;i<3;i++){
	System.out.println("   "+arr1[i][0]+"   |  "+arr1[i][1]+"   |  "+arr1[i][2]+"  ");
	System.out.println("");
	}		
	}
	void convert(){
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
		if(arr[i][j]==cross)	
		{
			arr1[i][j]='x';
		}else if(arr[i][j]==nought){arr1[i][j]='0';}
		else{arr1[i][j]=' ';}
	    }	
	}
	}
	public static void main(String args[])
	{
		titackto ob=new titackto();
		int rval=0,cval=0,player=1;
                Scanner sc=new Scanner(System.in);
		while(!ob.isWon(player,rval,cval))
		{
			if(player!=1)player=1; 
			else player=2;
		System.out.println("Enter player  "+player+" rows and colls (0 - 2)");
		rval=sc.nextInt();
		cval=sc.nextInt();
	        boolean b=ob.insert(player,rval,cval);
		if(b){ ob.board();}else{}

		
		}
		if(ob.isWon(player,rval,cval)){
			System.out.println("Congrats..... "+player+"    is win");
		}
	}
}
