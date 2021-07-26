/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysecondapplication.views;

import java.util.ArrayList;
import java.io.*;
import java.sql.Date;

/**
 * This class puts together information about a user, gathered during different
 * sessions. It also saves the gathered information in a unique file associated
 * with the user.
 * 
 * @author Arietta G., A. Goshtasby
 *
 */
public class Sessions {
	// List of sessions
	private ArrayList<Session> sessions = new ArrayList<>();
	// Filename to save user information
	private String filename = "";
        
        private boolean light = true;

	/**
	 * The only constructor: It receives a filename and reads user information 
	 * from the file to a list. If the file does not exist, an empty file is 
	 * created and associated with the user. Note: a filename is created
	 * from the id and password of a user.
	 * 
	 * @param fn 						filename
	 * 
	 * @throws IOException            	this is thrown if a file for the user is not
	 *                                	found
	 * @throws ClassNotFoundException 	this is thrown when an unidentified object is
	 *                                	read from the user file
	 */
	public Sessions(String fn) throws IOException, ClassNotFoundException {
		// fn will be the name of file containing information about the user 
		// associated with the object created by this class.
		filename = fn;
		// Defining an object input stream
		ObjectInputStream oin = null;
		// Defining a file input stream
		FileInputStream fin = null;
		try { // Open byte stream input file
			fin = new FileInputStream(filename);
			oin = new ObjectInputStream(fin);
		} 
		catch (FileNotFoundException e) {// If the file does not exist,
			System.out.println("Creating file: " + filename);
			// Open byte stream and output file
			FileOutputStream fout = new FileOutputStream(filename);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			// Close byte stream and file
			oout.close();
			fout.close();
			return;
		}
		// If file exists and is not empty
		if(fin.available()>0) {
			try {// move its contents to sessions
				sessions = (ArrayList<Session>) oin.readObject();
			} catch (IOException ioe) {
				System.out.println("Problem reading from file: " + filename);
		}
		}
		// Close the byte steam and file
		oin.close();
		fin.close();
	}
        
        /**
	 * This method receives a session and adds it to sessions. It also updates
	 * the file containing sessions from the same user.
	 * 
	 * @param session	a session
	 */
	public void addSession(Session session) {
		sessions.add(session);
	}
	
	/**
	 * Added method to return the required session in sessions
	 * 
	 * @param index
	 * @return session with index "index"
	 */
	public Session get(int index) {
		return sessions.get(index);
	}
	
	/**
	 * Added method to change the value of light to "mode" in all sessions
	 * 
	 * @param mode
	 */
	public void setMode(boolean mode) {
		for (Session session : sessions) {
			session.setMode(mode);
		}
	}
	
	/**
	 * Added method to return the value of light in sessions
	 * 
	 * @return value of light in session 0
	 */
	public boolean getMode() {
		return sessions.get(0).getMode();
	}

	/**
	 * This method prints contents of sessions, except for user's password
	 */
	public void showSessions() {
		System.out.println("\n" + sessions.get(0).getID() + " Sessions:\n");
		for (Session session : sessions) {
			session.showSession();
		}
	}

	/**
	 * This method receives a session and determines if it is from a user
	 * who created previous sessions. If so, it return true; otherwise, it
	 * returns false. If list of session is empty, user is considered new.
	 * 
	 * @param session 	a session
	 * @return 	<code> true </code> or <code> false </code>
	 */
	public boolean isUserKnown(Session session) {
		if (sessions.size()==0) return false;
		else if(session.isSame(sessions.get(0))) return true;
		else return false;
	}
	
	/**
	 * This method gets the size of sessions, which is the number of sessions completed by user.
	 * 
	 * @param sessions	array of sessions
	 */
	public double getSize() {
		int size = sessions.size();
		return size;
	}

	/*/**
	 * This method prints contents of sessions, except for user's password
	 */
	/*public void showSessions() {
		System.out.println("\n" + sessions.get(0).getID() + " Sessions:\n");
		for (Session session : sessions) {
			session.showSession();
		}
	}*/
	
	
	/**
	 * This method returns all feelings1 saved so far.
	 */
	public ArrayList<Double> getFeelings1() {
		ArrayList <Double> feelings1 = new ArrayList<Double>();
		for (int i=0;i<sessions.size();i++) {
			feelings1.add(sessions.get(i).getFeeling1());
		}
		return feelings1;
	}
	
	/**
	 * This method returns all feelings2 saved so far.
	 */
	public ArrayList<Double> getFeelings2() {
		ArrayList <Double> feelings2 = new ArrayList<Double>();
		for (int i=0;i<sessions.size();i++) {
			feelings2.add(sessions.get(i).getFeeling2());
		}
		return feelings2;
	}
	
	/**
	 * This method returns the times of all entries saved so far.
	 */
	public ArrayList<String> getAllTimes(Session session) {
		ArrayList <String> times = new ArrayList<String>();
		for (int i=0;i<sessions.size();i++) {
			//ArrayList <String> sentences = session.getSentences();
			times.addAll(sessions.get(i).getTimes());
		}
		return times;
	}
	
	/**
	 * This method returns all entries saved so far.
	 */
	public ArrayList<String> getAllEntries(Session session) {
		ArrayList <String> entries = new ArrayList<String>();
		for (int i=0;i<sessions.size();i++) {
			//ArrayList <String> sentences = session.getSentences();
			entries.addAll(sessions.get(i).getSentences());
		}
		return entries;
	}
	
	/**
	 * This method gets specific entry i saved so far.
	 */
	public String getEntry(int j) {
		ArrayList <String> entries = new ArrayList<String>();
		for (int i=0;i<sessions.size();i++) {
			//ArrayList <String> sentences = session.getSentences();
			entries.addAll(sessions.get(i).getSentences());
		}
		String entry = entries.get(j);
		return entry;
	}
	
	/**
	 * This method returns time value of int j saved so far.
	 */
	public String getTime(int j) {
		ArrayList <String> time = new ArrayList<>();
		for (int i=0;i<sessions.size();i++) {
			//ArrayList <String> sentences = session.getSentences();
			time.addAll(sessions.get(i).getTimes());
		}
		String date = time.get(j);
		return date;
	}
	
	/**
	 * This method gets amount of all entries.
	 */
	public int getEntrySize() {
		ArrayList <String> entries = new ArrayList<String>();
		for (int i=0;i<sessions.size();i++) {
			//ArrayList <String> sentences = session.getSentences();
			entries.addAll(sessions.get(i).getSentences());
		}
		int j = entries.size();
		return j;
	}

/**
	 * This method saves contents of sessions to file: filename
	 */
	public void saveSessions() {
		try {// Open output file and output byte stream
			FileOutputStream fout = new FileOutputStream(filename);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			// Write sessions into file
			oout.writeObject(sessions);
			// Close output stream and file
			oout.close();
			fout.close();
		} catch (IOException ioe) {
			System.out.println("Could not save sessions to file: " + filename);
		}
	}   
}