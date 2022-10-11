package ru.ewerestr.ewxchess;

import java.util.Scanner;

public class ConsoleManager implements Runnable{
	private boolean a = true;
	public ConsoleManager(){
		System.out.println("ConsoleManager has been started");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String inps;
		while(a){
			inps = s.nextLine();
			if(!inps.isEmpty() || inps != null){
				String[] cd = inps.split(" ");
				String[] gg = new String[(cd.length-1)];
				String cmd;
				cmd = cd[0].replace("/", "").toLowerCase();
				if(cd.length > 2){
					for(int i = 1;i<cd.length;i++){
						gg[i-1] = cd[i];
					}
				}else if(cd.length == 2) gg[0] = cd[1];
				else if(cd.length == 1) gg = new String[0];
				exec(cmd, gg);
			}
		}
	}
	private void exec(String command, String[] args){
		switch(command){
		case "exit":
			a = false;
			EWXChess.getGame().stop();
			EWXChess.getGame().write("The game has been stopped. Exitting");
			break;
//		case "spawn":
//			if(args.length >= 3 && EWXChess.isInt(args[1]) && EWXChess.isInt(args[2])){
//				EWXChess.getGame().spawnobj(args[0].toLowerCase(), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
//				EWXChess.getGame().write("Block " + args[0].toLowerCase() + " has been spawned on " + args[1] + ":" + args[2] + ":XY");
//			}
//			break;
			default:
				EWXChess.getGame().write("Unknown command");
				break;
		}
	}
	public void run(){
	}
}
