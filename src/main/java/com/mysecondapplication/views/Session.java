/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysecondapplication.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class contains information about a user collected during a session. It
 * implements Serializable to make it possible to save a session as an object
 * and read it back as an object.
 * 
 * @author Arietta M.G., A. Goshtasby
 * 
 * @version 4.1.3
 *
 */
public class Session implements Serializable {
	/**
	 * Data field: userid 		user name 
	 * Data field: password 	user password 
	 * Data field: date 		the date and time the session started 
	 * Data field: feeling1		mood (1..100) of user at the beginning of session
	 * Data field: feeling2		mood (1..100) of user at the end of session 
	 * Data field: conversation	sentences expressed by the user during a session
	 */
	private String userid = "";
	private String password = "";
	private Date date = new Date();
	private Date time = new Date();
	private double feeling1 = 0;
	private double feeling2 = 0;
	private ArrayList<String> conversation = new ArrayList<>();
	private ArrayList<String> times = new ArrayList<>();

	// Associate 2L (long integer 2) to this class during serialization.
	// Serialization is the process of converting an object into bytes.
	// Serialization ensures compatible object input/output. That is, when
	// an object is converted to a byte stream and the byte stream is converted
	// back to an object (deserialized), the same object will be obtained.
	private static final long serialVersionUID = 2L;

	/**
	 * The only constructor: It receives a user's id and password 
	 * and starts a session associated with the user. It records
	 * the date and time the session started.
	 * 
	 * @param id   user id
	 * @param pass user password
	 */
	public Session(String id, String pass) {
		userid = id;
		password = pass;
                
		date = new Date();
	}

	/**
	 * Does this session belong to the current user? The method receives the
	 * id and password of a user and compares them to the id and password 
	 * of the current user. If the ids and passwords are the same, a true is 
	 * returned. Otherwise, a false is returned.
	 * 
	 * @param session a session
	 * @return <code> true or false </code>
	 */
	public boolean isSame(Session session) {
		if ((session.getID().equals(userid)) && (session.getPass().equals(password)))
			return true;
		else
			return false;
	}

	/**
	 * Reset id of user for this session: The method receives a user id  
	 * and replaces current user's id with the received id.
	 * 
	 * @param id the new userid
	 */
	public void setID(String id) {
		userid = id;
	}

	/**
	 * Get id of the user for this session
	 * 
	 * @return id of user for this session
	 */
	public String getID() {
		return userid;
	}

	/**
	 * Reset password of user for this session: The method receives a
	 * password and changes the password of the user for this session to
	 * the received password.
	 * 
	 * @param pass password
	 */
	public void setPass(String pass) {
		password = pass;
	}

	/**
	 * This method returns the password of user for this session
	 * 
	 * @return password
	 */
	public String getPass() {
		return password;
	}

	/**
	 * This method returns the feeling1 value of this session
	 * 
	 * @return value for feeling1
	 */
	public double getFeeling1() {
		return feeling1;
	}

	/**
	 * This method receives a feeling1 value and changes the feeling1 value 
	 * of this session to the received value.
	 * 
	 * @param f1 value for feeling1
	 */
	public void setFeeling1(double f1) {
		feeling1 = f1;
	}

	/**
	 * This method returns the feeling2 value of this session
	 * 
	 * @return value for feeling2
	 */
	public double getFeeling2() {
		return feeling2;
	}
	
	/**
	 * This method receives a feeling2 value and changes the feeling2 value
	 * of this session to the received value.
	 * 
	 * @param f2 value for feeling2
	 */
	public void setFeeling2(double f2) {
		feeling2 = f2;
	}

	/**
	 * This method receives a String sentence and adds the sentence to the 
	 * list of sentences collected so far in this session,
	 * 
	 * @param sentence	a string showing a sentence provided by user
	 */
	public void addSentence(String sentence) {
		if(sentence.isEmpty() == false) {
		conversation.add(sentence);
		time = new Date();
		times.add(""+time);
		}
	}
	
	/**
	 * This method returns String sentence number i.
	 * 
	 * @param i	a number that determines which sentence to retrieve
	 */
	public ArrayList <String> getSentences() {
		ArrayList <String> entries = new ArrayList<String>();
		for(int i=0; i<conversation.size(); i++) {
		entries.add(conversation.get(i));
		}
		return entries;
	}
	
	/**
	 * This method returns Date time attached to String sentence number i.
	 * 
	 * @param i	a number that determines which sentence to retrieve
	 */
	public ArrayList <String> getTimes() {
		ArrayList <String> times1 = new ArrayList<String>();
		for(int i=0; i<times.size(); i++) {
		times1.add(times.get(i));
		}
		return times1;
	}

	/*/**
	 * This method prints contents of this session, except for user id and password.
	 */
	public void showSession() {
		System.out.println(date + "");
		System.out.printf("\t%3.2f\t%3.2f\n", getFeeling1(), getFeeling2());
		for (String sentence : conversation)
			System.out.println("\t" + sentence);
	}
}
