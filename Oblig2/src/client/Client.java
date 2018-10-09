package client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import spread.AdvancedMessageListener;
import spread.MembershipInfo;
import spread.SpreadConnection;
import spread.SpreadException;
import spread.SpreadGroup;
import spread.SpreadMessage;

public class Client implements IClient, AdvancedMessageListener {
	public double balance = 0;
	public List<Transaction> executed_list = new ArrayList<Transaction>();
	public Collection<Transaction> outstanding_collection = new ArrayList<Transaction>();
	public int order_counter = 0;
	public int outstanding_counter = 0;
	public static State state;
	public int numberOfMembers = 0;
	public UUID privateName = UUID.randomUUID();
	public SpreadConnection connection;
	public SpreadGroup group;
	public int port = 8080;
	
	public static void main(String[] args) {
		state = State.Connecting;
		

	}

	@Override
	public double balance() {
		return balance;
	}

	@Override
	public void deposit(int amount) {
		balance += amount;
		
	}

	@Override
	public void addInterest(double percent) {
		balance = balance*(1+(percent/100));
		
	}

	@Override
	public List<Transaction> getHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cleanHistory() {
		executed_list.clear();
	}

	@Override
	public List<String> memberInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void exit() {
		System.exit(0);
	}

	@Override
	public void addTransaction(Transaction transaction) {
		outstanding_collection.add(transaction);
		outstanding_counter++;
	}

	@Override
	public void processTransactions(List<Transaction> transactions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void regularMessageReceived(SpreadMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void membershipMessageReceived(SpreadMessage message) {
		MembershipInfo info = message.getMembershipInfo();
		int length = info.getMembers().length;
		this.numberOfMembers = length;
	}

	@Override
	public void Connect(String[] args) {
		// TODO Auto-generated method stub
		try {
			connection = new SpreadConnection();
			connection.connect(InetAddress.getByName(args[0]), port, privateName.toString(), false, false);
			group = new SpreadGroup();
			group.join(connection, args[1]);
			
			int nReplicas = Integer.parseInt(args[2]);
			while(numberOfMembers < nReplicas) {}
		} catch(SpreadException se) {
			System.out.println("Error on Spread connection: " + se.getMessage());
			se.printStackTrace(System.out);
		} catch(UnknownHostException uhe) {
			System.out.println("Error on group join: " + uhe.getMessage());
			uhe.printStackTrace(System.out);
		} catch(NumberFormatException nfe) {
			System.out.println("Number of replicas from args is not an Integer: " + nfe.getMessage());
			nfe.printStackTrace(System.out);
		}
	}

}