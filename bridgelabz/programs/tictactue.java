package com.bridgelabz.programs;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;
public class tictactue{
		
	
	public static void main(String args[])
	{
		Utility u=new Utility();
		int cross=1,nought=2;
		int emty=0; 
		int arr[][]=new int[3][3];
		char arr1[][]=new char[3][3];
		int i,j,count=0,player=1,curplayer=0,status=0;
		int rows=0 ,colls=0;
		int rval=0,cval=0;
        while(!u.isWon(player,rval,cval,arr))
		{
			if(player!=1)player=1; 
			else player=2;
		System.out.println("Enter player  "+player+" rows and colls (0 - 2)");
		rval=u.inputInteger();
		cval=u.inputInteger();
	        boolean b=u.insert(player,rval,cval,arr);
		if(b){ u.board(arr);}else{}

		
		}
		if(u.isWon(player,rval,cval,arr)){
			System.out.println("Congrats..... "+player+"    is win");
		}
	}
	
}